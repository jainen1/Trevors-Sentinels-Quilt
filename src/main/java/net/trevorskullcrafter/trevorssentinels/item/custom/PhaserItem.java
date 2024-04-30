package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.*;
import net.minecraft.potion.PotionUtil;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import net.trevorskullcrafter.trevorssentinels.entity.custom.PhaserProjectileEntity;
import net.trevorskullcrafter.trevorssentinels.item.TSItems;
import net.trevorskullcrafter.trevorssentinels.item.custom.unique.LivingPhaserItem;
import net.trevorskullcrafter.trevorssentinels.item.custom.unique.PaintPackItem;
import net.trevorskullcrafter.trevorssentinels.item.custom.unique.PhotonicLensItem;
import net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain;
import net.trevorskullcrafter.trevorssentinels.util.*;
import org.jetbrains.annotations.Nullable;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Vector;

public class PhaserItem extends Item implements StyleUtil.StyleSwitcher, Reloadable, StorageItem, FuelableItem {
    int slots; int count; int shotCooldown; int reloadCooldown; float recoil; float divergence; int damage; int maxAge; int maxAmmo; StatusEffectInstance[] effects;

    public PhaserItem(Settings settings, int slots, int count, int shotCooldown, int reloadCooldown, float recoil,
					  float divergence, int damage, int maxAge, int maxAmmo, StatusEffectInstance... effects) {
        super(settings); this.slots = slots; this.count = count; this.damage = damage; this.shotCooldown = shotCooldown; this.reloadCooldown = reloadCooldown;
		this.recoil = recoil; this.divergence = divergence; this.maxAge = maxAge; this.maxAmmo = maxAmmo; this.effects = effects;
    }

	@Override public int getSlots() { return Math.max(2, slots); }

	public static ItemStack getPreloadedStack(ItemConvertible item, String key, Color skinColor, Color lensColor, ItemStack... slotStacks){
		if(item instanceof PhaserItem phaser) {
			ItemStack phaserStack = new ItemStack(phaser, 1);
			if(key != null) { phaserStack.getOrCreateNbt().putString("trevorssentinels:custom_key", "item." + trevorssentinelsMain.MOD_ID + ".custom_phaser." + key); }
			Vector<NbtCompound> slots = new Vector<>();

			ItemStack skin;
			if (skinColor != null) {
				skin = new ItemStack(TSItems.Tech.PAINT_PACK);
				((PaintPackItem) skin.getItem()).setColor(skin, skinColor.getRGB());
			} else { skin = new ItemStack(Items.AIR); }
			ItemStack lens;
			if (lensColor != null) {
				lens = new ItemStack(TSItems.Tech.PHOTONIC_LENS);
				((PhotonicLensItem) lens.getItem()).setColor(lens, lensColor.getRGB());
			} else { lens = new ItemStack(Items.AIR); }

			slots.add(skin.writeNbt(new NbtCompound()));
			slots.add(lens.writeNbt(new NbtCompound()));
			for (ItemStack slotStack : slotStacks) { slots.add(slotStack.writeNbt(new NbtCompound())); }
			StorageItem.getSlotList(phaserStack).addAll(slots);

			initializeStats(phaserStack);
			phaserStack.getOrCreateNbt().putBoolean("Locked", false);
			return phaserStack;
		} return item.asItem().getDefaultStack();
	}

	@Override public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		if(stack.getNbt() == null){ initializeStats(stack); }
	}

	public static void initializeStats(ItemStack phaserStack){
		ItemStack skin = StorageItem.getStackInSlot(phaserStack, 0);
		if(skin != ItemStack.EMPTY) { phaserStack.getOrCreateNbt().putInt("CustomModelData", skin.getOrCreateNbt().getInt("CustomModelData")); }
		int count = 0; int shotCooldown = 0; int reloadCooldown = 0; float recoil = 0; float divergence = 0; int damage = 0; int maxAge = 0; int maxAmmo = 0;
		for(int i = 2; i <= ((PhaserItem) phaserStack.getItem()).slots; i++){
			if(StorageItem.getStackInSlot(phaserStack, i).getItem() instanceof PhaserAttachmentItem attachmentItem){
				count += attachmentItem.countModifier; damage += attachmentItem.damageModifier;
				shotCooldown += attachmentItem.shotCooldownModifier; reloadCooldown += attachmentItem.reloadCooldownModifier;
				recoil += attachmentItem.recoilModifier; divergence += attachmentItem.divergenceModifier;
				maxAge += attachmentItem.maxAgeModifier; maxAmmo += attachmentItem.maxAmmoModifier;
			}
		}
		NbtCompound modifiers = phaserStack.getOrCreateSubNbt("trevorssentinels:modifiers");
		modifiers.putInt("Count", count); modifiers.putFloat("Damage", damage);
		modifiers.putInt("ShotCooldown", shotCooldown); modifiers.putInt("ReloadCooldown", reloadCooldown);
		modifiers.putFloat("Recoil", recoil); modifiers.putFloat("Divergence", divergence);
		modifiers.putInt("MaxAge", maxAge); modifiers.putInt("MaxAmmo", maxAmmo);
	}

    @Override public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        if(isDualWielding(user)) {
            shoot(world, user, Hand.MAIN_HAND);
            shoot(world, user, Hand.OFF_HAND);
        }
        else { shoot(world, user, hand); }
        return super.use(world, user, hand);
    }

	public void shoot(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
		if (!getLocked(stack)) {
			world.playSoundFromEntity(null, user, getGunclass(stack).getShootSound(), SoundCategory.PLAYERS, 1, 1);

			for (int i = 1; i <= getCount(stack); i++) {
				PhaserProjectileEntity projectile = new PhaserProjectileEntity(ModEntities.PHASER_PROJECTILE, world, user, getMaxAge(stack), getDamage(stack),
					getProjectileColor(stack).getRGB(), effects);
				if(world instanceof ServerWorld serverWorld){
					projectile.setVelocity(user.getPitch(), user.getYaw(), 0.0F, 2.0f, getDivergence(stack) + (isDualWielding(user) ? 3f : 0f));
					serverWorld.spawnEntity(projectile);
				}
				user.addVelocity(projectile.getVelocity().multiply(getRecoil(stack)).negate());
			}
			if (user instanceof ServerPlayerEntity serverPlayerEntity) { serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(stack.getItem())); }
			user.fallDistance = (float) Math.abs(user.getVelocity().y) * 4;
			if (!user.getAbilities().creativeMode) { setFuel(stack, getFuel(stack) - 1); }
			if(getFuel(stack) < 1){ setLocked(stack, true); }
			user.sendMessage(fuelText(stack), true);
		} else {
			world.playSoundFromEntity(null, user, getGunclass(stack).getShootFailSound(), SoundCategory.PLAYERS, 1, 1);
			//triggerAnim(user, GeoItem.getOrAssignId(user.getStackInHand(hand), serverWorld), "shootController", "shoot");
		} user.getItemCooldownManager().set(this, getShotCooldown(stack));
    }

    @Override public void reload(ItemStack stack, World world, Entity user) {
        if(world instanceof ServerWorld) {
            if(getFuel(stack) > 0 && getLocked(stack)) {
                setLocked(stack, false);
                //triggerAnim(user, GeoItem.getOrAssignId(stack, serverWorld), "reloadController", "reload");
                world.playSoundFromEntity(null, user, getGunclass(stack).getReloadSound(), SoundCategory.PLAYERS, 3, 0);
            } else {
				//triggerAnim(user, GeoItem.getOrAssignId(stack, serverWorld), "reloadController", "reloadFail");
			}
			if(user instanceof PlayerEntity player) { player.getItemCooldownManager().set(this, getReloadCooldown(stack)); }
			else { stack.setCooldown(getReloadCooldown(stack)); }
		}
    }

	@Override public void addFuel(ItemStack stack, ItemStack otherStack, Entity entity) {
		int space = getMaxFuel(stack) - getFuel(stack);
		if (space > 0 && otherStack.isOf(getFuelItem())) {
			int x = Math.min(space, otherStack.getCount());
			if (x > 0) {
				setFuel(stack, getFuel(stack)+x);
				playFuelSound(entity);
				otherStack.decrement(x);
				setLocked(stack, true);
			}
		}
	}

    @Override public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        MutableText modeText = Text.empty();
		if(getStyles(stack) > 1){ modeText.append(Text.literal("△").formatted(StyleUtil.getStyle(stack) == 1? Formatting.RED : Formatting.GREEN)); }
        tooltip.add(Text.empty().append(fuelText(stack)).append(modeText));
		double firingRate = (20.0/ (getShotCooldown(stack) +1)) * getCount(stack);
		String firingRateString = new DecimalFormat("#.#").format(firingRate);
		Text column = Text.literal(" | ").formatted(Formatting.DARK_GRAY);
		tooltip.add(Text.empty()
			.append(Text.literal("☄ "+ getCount(stack)).formatted(TextUtil.quotientToolTipFormatting(getCount(stack), 5))).append(column)
			.append(Text.literal(getDamage(stack) < 1? "✚ " : "☠ " + Math.abs(getDamage(stack)))
				.formatted(TextUtil.quotientToolTipFormatting(Math.abs(getDamage(stack)), 20))).append(column)
			.append(Text.literal("\uD83D\uDD25 "+ firingRateString).formatted(TextUtil.quotientToolTipFormatting(firingRate, 5))));
		if(Screen.hasShiftDown()) {
			tooltip.add(Text.translatable("tooltip.item.trevorssentinels.phaser.stats"));
			tooltip.add(TextUtil.coloredText("Decal Color: #" + Integer.toHexString(getSkinColor(stack).getRGB()).substring(2), getSkinColor(stack)));
			tooltip.add(TextUtil.coloredText("Projectile Color: #" + Integer.toHexString(getProjectileColor(stack).getRGB()).substring(2), getProjectileColor(stack)));
			tooltip.add(Text.literal("Projectile Lifetime: " + getMaxAge(stack)).formatted(TextUtil.quotientToolTipFormatting(getMaxAge(stack), 4)));
			tooltip.add(Text.literal("Burst Inaccuracy: " + getDivergence(stack)).formatted(TextUtil.quotientToolTipFormatting(getDivergence(stack), 4,
				TextUtil.reverseFormattings)));
			tooltip.add(Text.literal("Burst Recoil: " + getRecoil(stack)).formatted(TextUtil.quotientToolTipFormatting(getRecoil(stack), 4)));
			tooltip.add(Text.literal("Burst Cooldown: " + getShotCooldown(stack)).formatted(TextUtil.quotientToolTipFormatting(getShotCooldown(stack), 4)));
			tooltip.add(Text.literal("Reload Cooldown: " + getReloadCooldown(stack)).formatted(TextUtil.quotientToolTipFormatting(getReloadCooldown(stack), 4)));
			PotionUtil.method_47372(stack, tooltip, 1.0f, 1.0f);
		}
		else { tooltip.add(Text.empty().append(Text.keyBind("SHIFT").formatted(Formatting.YELLOW)).append(Text.literal(" for advanced view").formatted(Formatting.DARK_GRAY))); }
        super.appendTooltip(stack, world, tooltip, context);
    }

    public Gunclass getGunclass(ItemStack stack){
        float damage = getDamage(stack);
        int count = getCount(stack);
        int cooldown = getShotCooldown(stack);
        int maxAmmo = getMaxFuel(stack);

		if(stack.getItem() instanceof LivingPhaserItem){
			if(damage > 4 && maxAmmo < 6 && count == 1) { return Gunclasses.LIVING_SNIPER; }
			else if(count > 2) { return Gunclasses.LIVING_SHOTGUN; }
			else if(cooldown < 6) { return Gunclasses.LIVING_RIFLE; }
			else { return Gunclasses.LIVING_PISTOL; }
		} else {
			if(damage > 4 && maxAmmo < 6 && count == 1) { return Gunclasses.SNIPER; }
			else if(count > 2) { return Gunclasses.SHOTGUN; }
			else if(cooldown < 6) { return Gunclasses.RIFLE; }
			else { return Gunclasses.PISTOL; }
		}
	}

	private int getIntModifier(ItemStack stack, String key){ return stack.getOrCreateSubNbt("trevorssentinels:modifiers").getInt(key); }
    private float getFloatModifier(ItemStack stack, String key){ return stack.getOrCreateSubNbt("trevorssentinels:modifiers").getFloat(key); }
	public boolean isDualWielding(PlayerEntity user){ return user.getStackInHand(Hand.MAIN_HAND).getItem() == user.getStackInHand(Hand.OFF_HAND).getItem(); }
	public void setLocked(ItemStack stack, boolean value) { stack.getOrCreateNbt().putBoolean("Locked", value); }
	public boolean getLocked(ItemStack stack) { return stack.getOrCreateNbt().getBoolean("Locked"); }

	@Override public Text getName(ItemStack stack) {
		if(stack.getNbt() != null){
			String custom_key = stack.getNbt().getString("trevorssentinels:custom_key");
			if(!custom_key.isBlank()) { return Text.translatable(custom_key); }
		}
		return super.getName(stack);
	}

	public int getCount(ItemStack stack) { return MathHelper.clamp(count + getIntModifier(stack, "Count"), 1, 8); }
    public int getShotCooldown(ItemStack stack) { return MathHelper.clamp(shotCooldown + getIntModifier(stack, "ShotCooldown"), 0, 100); }
    public int getReloadCooldown(ItemStack stack) { return MathHelper.clamp(reloadCooldown + getIntModifier(stack, "ReloadCooldown"), 1, 200); }
    public float getRecoil(ItemStack stack) { return MathHelper.clamp(recoil + getFloatModifier(stack, "Recoil"), -0.0f, 0.5f); }
    public float getDivergence(ItemStack stack) { return MathHelper.clamp(divergence + getFloatModifier(stack, "Divergence"), 0.0f, 15.0f); }
    public int getMaxAge(ItemStack stack) { return MathHelper.clamp(maxAge + getIntModifier(stack, "MaxAge"), 10, 100); }
    public float getDamage(ItemStack stack){ return MathHelper.clamp(damage + getFloatModifier(stack, "Damage"), -40f, 40f); }
	@Override public int getMaxFuel(ItemStack stack) {return MathHelper.clamp(maxAmmo + getIntModifier(stack, "MaxAmmo"), 1, 64);	}

	@Override public int getStyles(ItemStack stack) { return MathHelper.clamp(getIntModifier(stack, "Styles"), 1, 2); }
	public Color getSkinColor(ItemStack stack) {
		ItemStack stack2 = StorageItem.getStackInSlot(stack, 0);
		return new Color(!(stack2.getItem() instanceof PaintPackItem pack) ? TextUtil.WHITE.getRGB() : pack.getColor(stack2));
	}
    public Color getProjectileColor(ItemStack stack) {
		ItemStack stack2 = StorageItem.getStackInSlot(stack, 1);
		return new Color(!(stack2.getItem() instanceof PhotonicLensItem lens) ? TextUtil.PURE.getRGB() : lens.getColor(stack2));
	}
	@Override public int getItemBarColor(ItemStack stack) { return getLocked(stack)? Color.GRAY.getRGB() : getProjectileColor(stack).getRGB(); }
	@Override public boolean isItemBarVisible(ItemStack stack) { return true; }
    @Override public int getItemBarStep(ItemStack stack) { return Math.round(getFuel(stack) * 13.0F / getMaxFuel(stack)); }
    @Override public UseAction getUseAction(ItemStack stack) { return UseAction.CROSSBOW; }
    @Override public int getMaxUseTime(ItemStack stack) { return (getShotCooldown(stack)+1)*(getMaxFuel(stack)); }
	@Override public Text getSwitchMessagePrefix(ItemStack stack) { return StyleUtil.mode; }
	@Override public Text getCurrentStyleTranslation(ItemStack stack)
	{ return Text.translatable("style.item."+ trevorssentinelsMain.MOD_ID + ".phaser."+StyleUtil.getStyle(stack)); }
    @Override public Formatting getStyleSwitchFormatting(ItemStack stack){
        return switch(StyleUtil.getStyle(stack)){ case 2 -> Formatting.YELLOW; case 3 -> Formatting.GREEN; default -> Formatting.RED; };
    }
    @Override public SoundEvent getSwitchSoundEvent(ItemStack stack) { return SoundEvents.UI_BUTTON_CLICK.value(); }
    @Override public float getSwitchSoundPitch(ItemStack stack) { return 1.5f; }
    @Override public boolean allowNbtUpdateAnimation(PlayerEntity player, Hand hand, ItemStack oldStack, ItemStack newStack) { return false; }
}
