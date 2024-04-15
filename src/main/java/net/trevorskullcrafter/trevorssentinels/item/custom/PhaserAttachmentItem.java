package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

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
}
