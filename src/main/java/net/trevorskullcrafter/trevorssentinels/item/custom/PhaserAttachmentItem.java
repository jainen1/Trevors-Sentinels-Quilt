package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtil;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.util.TextUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PhaserAttachmentItem extends Item {
	int countModifier; int damageModifier; int shotCooldownModifier; int reloadCooldownModifier; float recoilModifier; float divergenceModifier; int maxAgeModifier;
	int maxAmmoModifier; boolean autoReload; boolean lingeringEffects; StatusEffectInstance[] statusEffects;

	public PhaserAttachmentItem(Settings settings, int countModifier, int damageModifier, int shotCooldownModifier, int reloadCooldownModifier, float recoilModifier,
								float divergenceModifier, int maxAgeModifier, int maxAmmoModifier, boolean autoReload, boolean lingeringEffects,
								StatusEffectInstance... statusEffects) {
		super(settings); this.countModifier = countModifier; this.damageModifier = damageModifier; this.shotCooldownModifier = shotCooldownModifier;
		this.reloadCooldownModifier = reloadCooldownModifier; this.recoilModifier = recoilModifier; this.divergenceModifier = divergenceModifier; this.maxAgeModifier = maxAgeModifier;
		this.maxAmmoModifier = maxAmmoModifier; this.autoReload = autoReload; this.lingeringEffects = lingeringEffects; this.statusEffects = statusEffects;
	}

	@Override public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		if(Screen.hasShiftDown()) {
			tooltip.add(Text.translatable("tooltip.item.trevorssentinels.phaser.modifiers"));
			if(countModifier != 0) { tooltip.add(Text.literal("Burst Projectiles: " + countModifier)
				.formatted(TextUtil.quotientToolTipFormatting(countModifier, 4))); }
			if(damageModifier != 0) { tooltip.add(Text.literal("Projectile Damage: " + damageModifier)
				.formatted(TextUtil.quotientToolTipFormatting(damageModifier, 4))); }
			if(maxAgeModifier != 0) { tooltip.add(Text.literal("Projectile Lifetime: " + maxAgeModifier)
				.formatted(TextUtil.quotientToolTipFormatting(maxAgeModifier, 4))); }
			if(divergenceModifier != 0) { tooltip.add(Text.literal("Burst Inaccuracy: " + divergenceModifier)
				.formatted(TextUtil.quotientToolTipFormatting(divergenceModifier, 4, TextUtil.reverseFormattings))); }
			if(recoilModifier != 0) { tooltip.add(Text.literal("Burst Recoil: " + recoilModifier)
				.formatted(TextUtil.quotientToolTipFormatting(recoilModifier, 4, TextUtil.reverseFormattings))); }
			if(shotCooldownModifier != 0) { tooltip.add(Text.literal("Burst Cooldown: " + shotCooldownModifier)
				.formatted(TextUtil.quotientToolTipFormatting(shotCooldownModifier, 4, TextUtil.reverseFormattings))); }
			if(reloadCooldownModifier != 0) { tooltip.add(Text.literal("Reload Cooldown: " + reloadCooldownModifier)
				.formatted(TextUtil.quotientToolTipFormatting(reloadCooldownModifier, 4, TextUtil.reverseFormattings))); }
			PotionUtil.method_47372(stack, tooltip, 1.0f, 1.0f);
		}
		else { tooltip.add(Text.empty().append(Text.keyBind("SHIFT").formatted(Formatting.YELLOW)).append(Text.literal(" to view modifiers").formatted(Formatting.DARK_GRAY))); }
		super.appendTooltip(stack, world, tooltip, context);
	}
}
