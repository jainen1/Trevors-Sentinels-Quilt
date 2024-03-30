package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.potion.PotionUtil;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import net.trevorskullcrafter.trevorssentinels.entity.custom.LaserEntity;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.item.client.GunItemRenderer;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import net.trevorskullcrafter.trevorssentinels.util.Gunclass;
import net.trevorskullcrafter.trevorssentinels.util.Gunclasses;
import net.trevorskullcrafter.trevorssentinels.util.StyleUtil;
import net.trevorskullcrafter.trevorssentinels.util.TextUtil;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class PhaserItem extends Item implements ToolSkinnable, StyleUtil.StyleSwitcher, Reloadable {
    private boolean mainHandLast = false; public boolean canDualWield = true;

    public static ItemStack laserGunFromTags(Item item, String name, Color color, int count, int shotCooldown, int reloadCooldown,
                                             float recoil, float speed, float divergence, int maxAge, float damage, int styles, int maxAmmo){
        ItemStack stack = new ItemStack(item, 1);
        NbtCompound laserModifiers = stack.getOrCreateSubNbt("trevorssentinels:Modifiers");
        laserModifiers.putInt("Count", count);
        laserModifiers.putInt("ShotCooldown", shotCooldown); laserModifiers.putInt("ReloadCooldown", reloadCooldown);
        laserModifiers.putFloat("Recoil", recoil);
        laserModifiers.putFloat("Speed", speed);
        laserModifiers.putFloat("Divergence", divergence);
        laserModifiers.putInt("MaxAge", maxAge);
        laserModifiers.putFloat("Damage", damage);
        laserModifiers.putInt("Styles", styles);
        laserModifiers.putInt("ColorOverride", color.getRGB());
        laserModifiers.putInt("MaxAmmo", maxAmmo);
        stack.getOrCreateNbt().putInt("Ammunition", maxAmmo);
        stack.getOrCreateNbt().putBoolean("Locked", false);

        stack.getOrCreateSubNbt("display").putString("Name", Text.Serializer.toJson(Text.literal(name).fillStyle(Style.EMPTY.withItalic(false)
                .withColor(TextColor.parse("#" + Integer.toHexString(color.getRGB()).substring(2)))
        )));
        return stack;
    }

    Item fuelItem; StatusEffectInstance[] effects;

    public PhaserItem(Settings settings, StatusEffectInstance... effects) {
        super(settings); this.fuelItem = ModItems.ENERGY_CELL; this.effects = effects;
    }

    @Override public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        if(isDualWielding(user)) {
            if (!mainHandLast) { shoot(world, user, Hand.MAIN_HAND); }
            else { shoot(world, user, Hand.OFF_HAND); }
            if(!world.isClient()) { mainHandLast = !mainHandLast; }
        }
        else { shoot(world, user, hand); }
        return super.use(world, user, hand);
    }

    public LaserEntity getProjectile(ItemStack stack, World world, PlayerEntity user){
        return new LaserEntity(ModEntities.LASER, world, user, getMaxAge(stack), getDamage(stack), getItemBarColor(stack), effects);
        //return new GasEntity(ModEntities.GAS, world, user, getMaxAge(stack), getDamage(stack), getItemBarColor(stack), effects);
        //return new BulletEntity(ModEntities.BULLET, world, user, getMaxAge(stack), getDamage(stack), getItemBarColor(stack), effects);
    }

    public void shoot(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (world instanceof ServerWorld serverWorld) {
            if (!getLocked(stack)) {
                LaserEntity shot;
                for (int i = 1; i <= getCount(stack); i++) {
                    shot = getProjectile(stack, world, user);
                    shot.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, getSpeed(stack), getDivergence(stack) + (isDualWielding(user) ? 3f : 0f));
                    world.spawnEntity(shot);
                    user.addVelocity(shot.getVelocity().multiply(getRecoil(stack) * (isDualWielding(user) ? 1.3 : 1.1)).negate());
                }
                if (user instanceof ServerPlayerEntity serverPlayerEntity) { serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(stack.getItem())); }
                user.fallDistance = (float) Math.abs(user.getVelocity().y) * 4;
                setFuel(stack, getFuel(stack) - 1);
                int magazine = getFuel(stack);
                user.sendMessage(Text.empty().append(Text.literal(String.valueOf(magazine)).formatted(TextUtil.quotientToolTipFormatting(magazine, getMaxAmmo(stack))))
                        .append(Text.literal(" / " + getMaxAmmo(stack) + " ⚡").formatted(Formatting.GRAY)), true);
                user.getItemCooldownManager().set(this, getShotCooldown(stack));
            }

            world.playSoundFromEntity(null, user, getLocked(stack)? getGunclass(stack).getShootFailSound() : getGunclass(stack).getShootSound(), SoundCategory.PLAYERS, 1, 1);
            //triggerAnim(user, GeoItem.getOrAssignId(user.getStackInHand(hand), serverWorld), "shootController", "shoot");
        }
    }

    @Override public void reload(ItemStack stack, World world, Entity user) {
        if(world instanceof ServerWorld serverWorld) {
            if(user instanceof PlayerEntity player) { player.getItemCooldownManager().set(this, getReloadCooldown(stack) + (StyleUtil.getStyle(stack) >= 2 ? getShotCooldown(stack) : 0)); }
            if(StyleUtil.getStyle(stack) > 1){ setFuel(stack, getMaxAmmo(stack)); /*check user's inventory for ammunition, add it to the gun*/ }
            if(getFuel(stack) > 0 && getLocked(stack)) {
                setLocked(stack, false);
                //triggerAnim(user, GeoItem.getOrAssignId(stack, serverWorld), "reloadController", "reload");
                world.playSoundFromEntity(null, user, getGunclass(stack).getReloadSound(), SoundCategory.PLAYERS, 3, 0);
            }
            else { //triggerAnim(user, GeoItem.getOrAssignId(stack, serverWorld), "reloadController", "reloadFail");
                }
        }
    }

    public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {
        if (clickType == ClickType.RIGHT) {
            if (otherStack.isEmpty()) {
                removeFuel(stack, player).ifPresent(cursorStackReference::set);
            } else { addFuel(stack, otherStack, player); }
            return true;
        } return false;
    }

    public boolean onStackClicked(ItemStack stack, Slot slot, ClickType clickType, PlayerEntity player) {
        if (clickType == ClickType.RIGHT) {
            ItemStack otherStack = slot.getStack();
            if (otherStack.isEmpty()) {
                removeFuel(stack, player).ifPresent((removedStack) -> addFuel(stack, slot.insertStack(removedStack), player));
            } else { addFuel(stack, otherStack, player); }
            return true;
        } return false;
    }

    private Optional<ItemStack> removeFuel(ItemStack stack, Entity entity) {
        if (getFuel(stack) == 0) { return Optional.empty(); }
        else {
            int x = Math.min(getFuel(stack), 64);
            if(x > 0) {
                setFuel(stack, getFuel(stack)-x);
                entity.playSound(SoundEvents.BLOCK_CHAIN_BREAK, 1f, 2f + entity.getWorld().getRandom().nextFloat() * 0.4F);
            }
            return Optional.of(new ItemStack(fuelItem, x));
        }
    }

    private void addFuel(ItemStack stack, ItemStack otherStack, Entity entity) {
        int space = getMaxAmmo(stack) - getFuel(stack);
        if (space > 0 && otherStack.isOf(fuelItem)) {
            int x = Math.min(space, otherStack.getCount());
            if (x > 0) {
                setFuel(stack, getFuel(stack)+x);
                entity.playSound(SoundEvents.BLOCK_CHAIN_PLACE, 1f, 2f + entity.getWorld().getRandom().nextFloat() * 0.4F);
                otherStack.decrement(x);
                setLocked(stack, true);
            }
        }
    }

    @Override public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        //initialization
        int count = getCount(stack);
        Color color = getColor(stack);
        float damage = Math.abs(getDamage(stack));
        int maxAmmo = getMaxAmmo(stack);
        float speed = getSpeed(stack);
        float divergence = getDivergence(stack);
        float recoil = getRecoil(stack);
        int maxAge = getMaxAge(stack);
        int shotCooldown = getShotCooldown(stack); int reloadCooldown = getReloadCooldown(stack);

        //stats
        tooltip.add(Text.literal(getGunclass(stack).getName()));

        MutableText modeText = Text.empty();
        int styles = getStyles(stack);
        if(styles > 1){
            int style = StyleUtil.getStyle(stack);
            modeText.append(Text.literal("▽").formatted(style > 1? Formatting.GREEN : Formatting.RED));
            if(styles >= 3){ modeText.append(Text.literal("△").formatted(style > 2? Formatting.GREEN : Formatting.RED)); }
        }

        int magazine = getFuel(stack);
        tooltip.add(Text.empty().append(Text.literal(String.valueOf(magazine)).formatted(TextUtil.quotientToolTipFormatting(magazine, getMaxAmmo(stack))))
                .append(Text.literal(" / " + getMaxAmmo(stack) +" ⚡ ").formatted(Formatting.GRAY))
                .append(modeText));

        if(Screen.hasAltDown()){
            tooltip.add(Text.literal("☄ " + count).formatted(TextUtil.quotientToolTipFormatting(count, 8))); //count
            tooltip.add(TextUtil.coloredText("\uD83C\uDF08 #" + Integer.toHexString(color.getRGB()).substring(2), color)); //color
            tooltip.add(Text.literal((damage < 1 ? "✚ " : "☠ ") + damage).formatted(TextUtil.quotientToolTipFormatting(damage, 20))); //damage
            tooltip.add(Text.literal("t " + maxAmmo).formatted(TextUtil.quotientToolTipFormatting(maxAmmo, 20))); //maxammo
            tooltip.add(Text.literal("→ " + speed).formatted(TextUtil.quotientToolTipFormatting(speed, 4))); //speed
            tooltip.add(Text.literal("t " + divergence).formatted(TextUtil.quotientToolTipFormatting(divergence, 4))); //divergence
            tooltip.add(Text.literal("t " + recoil).formatted(TextUtil.quotientToolTipFormatting(recoil, 4))); //recoil
            tooltip.add(Text.literal("t " + maxAge));//.formatted(TextUtil.quotientToolTipFormatting(maxAge, 4)); //maxage
            tooltip.add(Text.literal("t " + shotCooldown).formatted(TextUtil.quotientToolTipFormatting(shotCooldown, 4))); //shotcooldown
            tooltip.add(Text.literal("t " + reloadCooldown));//.formatted(TextUtil.quotientToolTipFormatting(reloadCooldown, 4)); //reloadcooldown
        } else {
            Text secondArgument;
            double firingRate = Math.floor(20.0/(shotCooldown+1) * 10) / 10;
            if(firingRate <= 1) { secondArgument = Text.literal(new DecimalFormat("#.##").format(speed)+" →")
                    .formatted(TextUtil.quotientToolTipFormatting(speed, 4)); }
            else { secondArgument = Text.literal(firingRate+" \uD83D\uDD25").formatted(TextUtil.quotientToolTipFormatting(firingRate, 5)); }

            Text column = Text.literal(" | ").formatted(Formatting.DARK_GRAY);
            tooltip.add(Text.empty()
                    .append(Text.literal(count + " ☄").formatted(TextUtil.quotientToolTipFormatting(count, 8))).append(column)
                    .append(secondArgument).append(column)
                    .append(Text.literal(Math.abs(damage)+(damage < 1 ? " ✚" : " ☠")).formatted(TextUtil.quotientToolTipFormatting(Math.abs(damage), 20))));
        }

        //effect
        if(effects.length > 0) { if(stack.getHolder() instanceof PlayerEntity player && player.isSneaking()) { PotionUtil.buildTooltip(stack, tooltip, 1.0f); }
        else { tooltip.add(Text.empty().append(Text.literal("SHIFT").formatted(Formatting.YELLOW)).append(Text.literal(" to show status effects.")
                .formatted(Formatting.DARK_GRAY))); }}
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private GunItemRenderer renderer;
            @Override public BuiltinModelItemRenderer getCustomRenderer() {
                if (this.renderer == null) { this.renderer = new GunItemRenderer(); }
                return this.renderer;
            }});
    }

    public Gunclass getGunclass(ItemStack stack){
        float damage = getDamage(stack);
        int count = getCount(stack);
        float speed = getSpeed(stack);
        int cooldown = getShotCooldown(stack);
        int maxAmmo = getMaxAmmo(stack);

        if(damage > 4 && maxAmmo < 6 && count == 1 && speed > 2) { return Gunclasses.SNIPER; }
        else if(count > 2) { return Gunclasses.SHOTGUN; }
        else if(cooldown < 6) { return Gunclasses.RIFLE; }
        else { return Gunclasses.PISTOL; }
    }

    @Override public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "idleController", 0, state -> PlayState.CONTINUE)
                .triggerableAnim("idle", RawAnimation.begin().thenLoop("idle")));
        controllers.add(new AnimationController<>(this, "shootController", 0, state -> PlayState.CONTINUE)
                .triggerableAnim("shoot", RawAnimation.begin().thenPlay("shoot"))
                .triggerableAnim("shootFail", RawAnimation.begin().thenPlay("shootFail")));
        controllers.add(new AnimationController<>(this, "reloadController", 0, state -> PlayState.CONTINUE)
                .triggerableAnim("reload", RawAnimation.begin().thenPlay("reload"))
                .triggerableAnim("reloadFail", RawAnimation.begin().thenPlay("reloadFail")));
    }

    private int getIntModifier(ItemStack stack, String key){ return stack.getOrCreateSubNbt("trevorssentinels:Modifiers").getInt(key); }
    private float getFloatModifier(ItemStack stack, String key){ return stack.getOrCreateSubNbt("trevorssentinels:Modifiers").getFloat(key); }

    public int getCount(ItemStack stack) { return MathHelper.clamp(getIntModifier(stack, "Count"), 1, 8); }
    public int getShotCooldown(ItemStack stack) { return Math.max(getIntModifier(stack, "ShotCooldown"), 3); }
    public int getReloadCooldown(ItemStack stack) { return Math.max(getIntModifier(stack, "ReloadCooldown"), 0); }
    public float getRecoil(ItemStack stack) { return MathHelper.clamp(getFloatModifier(stack, "Recoil"), -1, 1); }
    public float getSpeed(ItemStack stack) { return MathHelper.clamp(getFloatModifier(stack, "Speed"), 0.2f, 4); }
    public float getDivergence(ItemStack stack) { return getFloatModifier(stack, "Divergence"); } //not sure what values to clamp to
    public int getMaxAge(ItemStack stack) { return getIntModifier(stack, "MaxAge"); }
    public float getDamage(ItemStack stack){ return getFloatModifier(stack, "Damage"); }
    public int getMaxAmmo(ItemStack stack) { return Math.max(getIntModifier(stack, "MaxAmmo"), 1); }
    @Override public int getStyles(ItemStack stack) { return MathHelper.clamp(getIntModifier(stack, "Styles"), 1, 3); }
    public Color getColor(ItemStack stack) {
        int color = getIntModifier(stack, "ColorOverride");
        return new Color(color == 0? TextUtil.PURE.getRGB() : color);
    }

    @Override public int getItemBarColor(ItemStack stack) { return getLocked(stack)? Color.GRAY.getRGB() : getColor(stack).getRGB(); }
    @Override public Text getName(ItemStack stack) { return TextUtil.coloredText(super.getName(stack), getColor(stack)); }
    public int getFuel(ItemStack stack) { return stack.getOrCreateNbt().getInt("Ammunition"); }
    public void setFuel(ItemStack stack, int fuel) { stack.getOrCreateNbt().putInt("Ammunition", Math.min(fuel, getMaxAmmo(stack))); }
    public boolean isDualWielding(PlayerEntity user){ return user.getStackInHand(Hand.MAIN_HAND).getItem() == user.getStackInHand(Hand.OFF_HAND).getItem(); }
    @Override public boolean isItemBarVisible(ItemStack stack) { return true; }
    @Override public int getItemBarStep(ItemStack stack) { return Math.round(getFuel(stack) * 13.0F / getMaxAmmo(stack)); }
    @Override public UseAction getUseAction(ItemStack stack) { return UseAction.CROSSBOW; }
    @Override public int getMaxUseTime(ItemStack stack) { return (getShotCooldown(stack)+1)*(getMaxAmmo(stack)); }
    public void setLocked(ItemStack stack, boolean value) { stack.getOrCreateNbt().putBoolean("Locked", value); }
    public boolean getLocked(ItemStack stack) {
        boolean willLock = stack.getOrCreateNbt().getBoolean("Locked");
        if(getFuel(stack) < 1) { setLocked(stack, true); }
        return willLock;
    }
    @Override public Supplier<Object> getRenderProvider() { return this.renderProvider; }
    @Override public AnimatableInstanceCache getAnimatableInstanceCache() { return this.cache; }
    @Override public Text getSwitchMessagePrefix(ItemStack stack) { return StyleUtil.mode; }
    @Override public Text getCurrentStyleTranslation(ItemStack stack) { return Text.translatable("style.item."+ trevorssentinels.MOD_ID +".gun."+StyleUtil.getStyle(stack)); }
    @Override public Formatting getStyleSwitchFormatting(ItemStack stack){
        return switch(StyleUtil.getStyle(stack)){ case 2 -> Formatting.YELLOW; case 3 -> Formatting.GREEN; default -> Formatting.RED; };
    }
    @Override public SoundEvent getSwitchSoundEvent(ItemStack stack) { return SoundEvents.UI_BUTTON_CLICK.value(); }
    @Override public float getSwitchSoundPitch(ItemStack stack) { return 1.5f; }
    @Override public boolean allowNbtUpdateAnimation(PlayerEntity player, Hand hand, ItemStack oldStack, ItemStack newStack) { return false; }
}
