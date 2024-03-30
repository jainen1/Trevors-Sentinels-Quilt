package net.trevorskullcrafter.trevorssentinels.item;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ArmorMaterial;

public interface ModArmorMaterial extends ArmorMaterial {
	StatusEffect getStatusEffect();
}
