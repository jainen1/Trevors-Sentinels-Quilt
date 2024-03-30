package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import net.trevorskullcrafter.trevorssentinels.entity.custom.BulletEntity;
import net.trevorskullcrafter.trevorssentinels.entity.custom.GasEntity;
import net.trevorskullcrafter.trevorssentinels.entity.custom.PhaserProjectileEntity;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;
import net.trevorskullcrafter.trevorssentinels.util.Gunclass;
import net.trevorskullcrafter.trevorssentinels.util.StyleUtil;
import net.trevorskullcrafter.trevorssentinels.util.TextUtil;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

public class GunItem extends Item implements ToolSkinnable, StyleUtil.StyleSwitcher, Reloadable {
    Hand lastHand = Hand.OFF_HAND;

    int lasers; float laserSpeed; float divergence; float dualPenalty; float recoil; int cooldownTime; int reloadCooldown; Item fuelItem; int styles;
    Gunclass gunclass; int lifetime; float damage; int type; Color color; StatusEffectInstance[] effects;

    public GunItem(Settings settings, Gunclass gunclass, int lasers, float laserSpeed, float divergence, float dualPenalty, float recoil, int cooldown, int reloadCooldown,
                   int lifetime, float damage, int type, Color color, StatusEffectInstance... effects) {
        super(settings); this.lasers = lasers; this.laserSpeed = laserSpeed; this.divergence = divergence; this.dualPenalty = dualPenalty; this.recoil = recoil;
        this.cooldownTime = cooldown; this.reloadCooldown = reloadCooldown; this.fuelItem = ModItems.ENERGY_CELL; this.styles = 3;
        this.gunclass = gunclass; this.lifetime = lifetime;this.damage = damage; this.type = type; this.color = color; this.effects = effects;
    }

    @Override public Text getSwitchMessagePrefix(ItemStack stack) { return StyleUtil.mode; }
    @Override public Text getCurrentStyleTranslation(ItemStack stack) { return Text.translatable("style.item."+ trevorssentinels.MOD_ID +".gun."+StyleUtil.getStyle(stack)); }
    @Override public int getStyles(ItemStack stack) { return styles; }
    @Override public Formatting getStyleSwitchFormatting(ItemStack stack){
        return switch(StyleUtil.getStyle(stack)){ case 2 -> Formatting.YELLOW; case 3 -> Formatting.GREEN; default -> Formatting.RED; };
    }
    @Override public SoundEvent getSwitchSoundEvent(ItemStack stack) { return SoundEvents.UI_BUTTON_CLICK.value(); }
    @Override public float getSwitchSoundPitch(ItemStack stack) { return 1.5f; }

    @Override public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        if(isDualWielding(user)) {
            if (lastHand == Hand.OFF_HAND) { shoot(user.getMainHandStack(), world, user, hand); if(!world.isClient()) { lastHand = Hand.MAIN_HAND; }}
            else { shoot(user.getOffHandStack(), world, user, hand); if(!world.isClient()) lastHand = Hand.OFF_HAND; }}
        else if(hand == Hand.MAIN_HAND || (hand == Hand.OFF_HAND && !(user.getStackInHand(Hand.MAIN_HAND).getItem() instanceof GunItem))){
            shoot(user.getStackInHand(hand), world, user, hand);
        }
        return super.use(world, user, hand);
    }

    public void shoot(ItemStack stack, World world, PlayerEntity user, Hand hand){
        if(stack.getDamage() < stack.getMaxDamage() - 1) {
            for (int i = 1; i <= lasers; i++) { launch(stack, world, user); }
            if (user instanceof ServerPlayerEntity serverPlayerEntity) { serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(stack.getItem())); }
            if (!world.isClient()) {
                user.fallDistance = (float) Math.abs(user.getVelocity().y) * 4;
                world.playSoundFromEntity(null, user, gunclass.getShootSound(), SoundCategory.BLOCKS, Math.min(3.0F, (lasers * 0.5F)), 1.0F);
                stack.damage(1, user, p -> p.sendToolBreakStatus(hand));
                int magazine = stack.getMaxDamage() - stack.getDamage() - 1;
                user.sendMessage(Text.empty().append(Text.literal(String.valueOf(magazine)).formatted(TextUtil.quotientToolTipFormatting(magazine,
                        stack.getMaxDamage() - 1))).append(Text.literal(" / " + (stack.getMaxDamage() - 1) + " ⚡").formatted(Formatting.GRAY)), true);
                user.getItemCooldownManager().set(this, cooldownTime);
            }
        } else { if (!world.isClient()){ world.playSoundFromEntity(null, user, gunclass.getShootFailSound(), SoundCategory.BLOCKS, 1.0F, 1.0F); } }
    }

    public void launch(ItemStack stack, World world, PlayerEntity user){
        PhaserProjectileEntity laser;
        switch(type){
            case 2 -> laser = new GasEntity(ModEntities.GAS, world, user, lifetime, damage, getItemBarColor(stack), effects);
            case 3 -> laser = new BulletEntity(ModEntities.BULLET, world, user, lifetime, damage, getItemBarColor(stack), effects);
            default -> laser = new PhaserProjectileEntity(ModEntities.PHASER_PROJECTILE, world, user, lifetime, damage, getItemBarColor(stack), effects);
        }
        laser.setVelocity(user.getPitch(), user.getYaw(), user.getRoll(), laserSpeed, divergence+(isDualWielding(user)? dualPenalty: 0.0f));
        world.spawnEntity(laser);
        user.addVelocity(laser.getVelocity().multiply(-recoil * (isDualWielding(user)? 1.3 : 1.1)));
    }

    @Override public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(StyleUtil.getStyle(stack) == 2 && (stack.getDamage() == stack.getMaxDamage() - 1) && entity instanceof PlayerEntity player){ reload(stack, world, player); }
    }

    @Override public void reload(ItemStack stack, World world, Entity user) {
        if (!world.isClient()) {
            stack.setDamage(0); if(user instanceof PlayerEntity player) { player.getItemCooldownManager().set(this, reloadCooldown + (StyleUtil.getStyle(stack) == 2 ? cooldownTime : 0)); }
            world.playSoundFromEntity(null, user, gunclass.getReloadSound(), SoundCategory.BLOCKS, 3.0F, 0.0F);
        }
    }

    public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {
        if (clickType == ClickType.RIGHT) {
            if (otherStack.isEmpty()) {
                this.playRemoveOneSound(player);
                removeFuel(stack).ifPresent(cursorStackReference::set);
            } else if(otherStack.isOf(fuelItem)) { playInsertSound(stack, otherStack, player); }
            return true;
        } return false;
    }

    public boolean onStackClicked(ItemStack stack, Slot slot, ClickType clickType, PlayerEntity player) {
        if (clickType == ClickType.RIGHT) {
            ItemStack otherStack = slot.getStack();
            if (otherStack.isEmpty()) {
                this.playRemoveOneSound(player);
                removeFuel(stack).ifPresent((removedStack) -> addFuel(stack, slot.insertStack(removedStack)));
            } else if (otherStack.isOf(fuelItem)) { playInsertSound(stack, otherStack, player); }
            return true;
        } return false;
    }

    private Optional<ItemStack> removeFuel(ItemStack stack) {
        if (stack.getDamage() == stack.getMaxDamage()-1) { return Optional.empty(); }
        else {
            int x = Math.min(stack.getMaxDamage()-1, 64);
            stack.setDamage(x);
            return Optional.of(new ItemStack(fuelItem, x));
        }
    }

    private static int addFuel(ItemStack stack, ItemStack otherStack) {
        if (otherStack.isEmpty() || stack.getDamage() == 0) { return 0; }
        else {
            int x = Math.min(stack.getDamage(), otherStack.getCount());
            stack.setDamage(stack.getDamage() - x);
            return x;
        }
    }

    private void playRemoveOneSound(Entity entity) { entity.playSound(SoundEvents.BLOCK_CHAIN_BREAK, 1f, 2f + entity.getWorld().getRandom().nextFloat() * 0.4F); }
    private void playInsertSound(ItemStack stack, ItemStack otherStack, Entity entity) {
        int i = addFuel(stack, otherStack);
        if (i > 0) {
            entity.playSound(SoundEvents.BLOCK_CHAIN_PLACE, 1f, 2f + entity.getWorld().getRandom().nextFloat() * 0.4F);
            otherStack.decrement(i);
        }
    }

    private Text modeText(ItemStack stack){
        return Text.literal(StyleUtil.getStyle(stack) == 2? "△" : StyleUtil.getStyle(stack) == 3? ("▽△") : "").formatted(getStyleSwitchFormatting(stack));
    }

    @Override public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        //class + magazine
        tooltip.add(Text.literal(gunclass.getName()));
        tooltip.add(Text.empty().append(Text.literal(String.valueOf(getFuel(stack)).formatted(TextUtil.quotientToolTipFormatting(getFuel(stack), stack.getMaxDamage()-1))))
                .append(Text.literal(" / " + (stack.getMaxDamage()-1)+" ⚡ ").formatted(Formatting.GRAY)).append(modeText(stack)));
        //stats
        double firingRate = Math.floor(20.0/(cooldownTime+1) * 10) / 10;
        Text secondParameter;
        DecimalFormat df = new DecimalFormat("#.##");
        if(firingRate <= 1) secondParameter = Text.literal(df.format(laserSpeed)+" →").formatted(TextUtil.quotientToolTipFormatting(laserSpeed, 4));
        else secondParameter = Text.literal(firingRate+" \uD83D\uDD25").formatted(TextUtil.quotientToolTipFormatting(firingRate, 5));
        tooltip.add(Text.empty().append(Text.literal(lasers+" ☄").formatted(TextUtil.quotientToolTipFormatting(lasers, 8)))
                .append(column()).append(secondParameter).append(column()).append(Text.literal(Math.abs(damage)+(damage < 1 ? " ✚" : " ☠"))
                        .formatted(TextUtil.quotientToolTipFormatting(Math.abs(damage), 20))));
        //effect
        if(effects.length > 0) { if(Screen.hasShiftDown()) {
            for (StatusEffectInstance statusEffectInstance : effects) {
                StatusEffectCategory statusEffectCategory = statusEffectInstance.getEffectType().getCategory();
                tooltip.add(Text.empty().append(statusEffectCategory == StatusEffectCategory.BENEFICIAL ? "☀ " :
                                statusEffectCategory == StatusEffectCategory.NEUTRAL ? "☯ " : "☠ ").append(TextUtil.potionText(statusEffectInstance, false))
                        .formatted(statusEffectCategory == StatusEffectCategory.BENEFICIAL ? Formatting.GREEN :
                                statusEffectCategory == StatusEffectCategory.NEUTRAL ? Formatting.YELLOW : Formatting.RED)); }
        } else { tooltip.add(Text.empty().append(Text.literal("SHIFT").formatted(Formatting.YELLOW)).append(Text.literal(" to show status effects.")
                .formatted(Formatting.DARK_GRAY))); }}
        super.appendTooltip(stack, world, tooltip, context);
    }

    private int getFuel(ItemStack stack) { return stack.getMaxDamage() - stack.getDamage() -1; }

    public boolean isDualWielding(PlayerEntity user){ return user.getStackInHand(Hand.MAIN_HAND).getItem() == user.getStackInHand(Hand.OFF_HAND).getItem(); }
    private Text column(){ return Text.literal(" | ").formatted(Formatting.DARK_GRAY); }
    @Override public boolean isItemBarVisible(ItemStack stack) { return true; }
    @Override public int getItemBarStep(ItemStack stack) { return Math.round(13.0F - (float)stack.getDamage() * 13.0F / (float)stack.getMaxDamage()-1); }
    @Override public int getItemBarColor(ItemStack stack) { return color.getRGB(); }
    @Override public UseAction getUseAction(ItemStack stack) { return UseAction.CROSSBOW; }
    @Override public int getMaxUseTime(ItemStack stack) { return (cooldownTime+1)*(this.getMaxDamage()-1); }
}
