package net.trevorskullcrafter.trevorssentinels.item.custom.unique;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.trevorskullcrafter.trevorssentinels.item.TSItems;
import net.trevorskullcrafter.trevorssentinels.item.custom.PhaserItem;
import net.trevorskullcrafter.trevorssentinels.util.TextUtil;

import java.awt.*;

public class LivingPhaserItem extends PhaserItem {
	public LivingPhaserItem(Settings settings, int slots, int count, int shotCooldown, int reloadCooldown, float recoil, float divergence, int damage, int maxAge, int maxAmmo, StatusEffectInstance... effects) {
		super(settings, slots, count, shotCooldown, reloadCooldown, recoil, divergence, damage, maxAge, maxAmmo, effects);
	}

	@Override public Item getFuelItem() { return TSItems.Tech.MEAT_PELLET; }
	@Override public Color getColor(ItemStack stack) { return TextUtil.FLESH_PUS; }
	@Override public void playFuelSound(Entity entity) { entity.playSound(SoundEvents.ENTITY_GENERIC_EAT, 1f, 2f + entity.getWorld().getRandom().nextFloat() * 0.4F); }
}
