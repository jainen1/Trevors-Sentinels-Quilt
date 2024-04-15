package net.trevorskullcrafter.trevorssentinels.item;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;
import net.trevorskullcrafter.trevorssentinels.effect.ModEffects;
import net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ModArmorMaterials implements ModArmorMaterial {
    //LEATHER - 5, (1, 2, 3, 1), 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f, 0.0f

	SCRAP_METAL("scrap_metal", 3, Util.make(new EnumMap<>(ArmorItem.ArmorSlot.class),
		(map) -> { map.put(ArmorItem.ArmorSlot.HELMET, 1); map.put(ArmorItem.ArmorSlot.CHESTPLATE, 2); map.put(ArmorItem.ArmorSlot.LEGGINGS, 1); map.put(ArmorItem.ArmorSlot.BOOTS, 1);}),
		8, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0f, 0.0f, () -> Ingredient.ofItems(TSItems.Tech.SCRAP_METAL_SHARD), ModEffects.SET_BONUS_SCRAP_METAL),

	DRYADIC("dryadic", 8, Util.make(new EnumMap<>(ArmorItem.ArmorSlot.class),
		(map) -> { map.put(ArmorItem.ArmorSlot.HELMET, 2); map.put(ArmorItem.ArmorSlot.CHESTPLATE, 6); map.put(ArmorItem.ArmorSlot.LEGGINGS, 4); map.put(ArmorItem.ArmorSlot.BOOTS, 2);}),
		7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, 0.0f, () -> Ingredient.ofItems(TSItems.Magic.ROSE_GOLD_INGOT), ModEffects.SET_BONUS_DRYADIC),

	ROSE_GOLD("rose_gold", 8, Util.make(new EnumMap<>(ArmorItem.ArmorSlot.class),
		(map) -> { map.put(ArmorItem.ArmorSlot.HELMET, 2); map.put(ArmorItem.ArmorSlot.CHESTPLATE, 6); map.put(ArmorItem.ArmorSlot.LEGGINGS, 4); map.put(ArmorItem.ArmorSlot.BOOTS, 2);}),
		7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, 0.0f, () -> Ingredient.ofItems(TSItems.Magic.ROSE_GOLD_INGOT), ModEffects.SET_BONUS_ROSE_GOLD),

	DRUIDIC("druidic", 8, Util.make(new EnumMap<>(ArmorItem.ArmorSlot.class),
		(map) -> { map.put(ArmorItem.ArmorSlot.HELMET, 2); map.put(ArmorItem.ArmorSlot.CHESTPLATE, 6); map.put(ArmorItem.ArmorSlot.LEGGINGS, 4); map.put(ArmorItem.ArmorSlot.BOOTS, 2);}),
		7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, 0.0f, () -> Ingredient.ofItems(TSItems.Magic.ROSE_GOLD_INGOT), ModEffects.SET_BONUS_DRUIDIC),

	//IRON - 15, (2, 5, 6, 2), 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, 0.0f

	STARSTEEL("starsteel", 27, Util.make(new EnumMap<>(ArmorItem.ArmorSlot.class),
		(map) -> { map.put(ArmorItem.ArmorSlot.HELMET, 3); map.put(ArmorItem.ArmorSlot.CHESTPLATE, 7); map.put(ArmorItem.ArmorSlot.LEGGINGS, 4); map.put(ArmorItem.ArmorSlot.BOOTS, 3);}),
		4, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.5f, 0.1f, () -> Ingredient.ofItems(TSItems.Tech.STARSTEEL_INGOT), ModEffects.SET_BONUS_STARSTEEL),

	IMPERIAL("imperial", 24, Util.make(new EnumMap<>(ArmorItem.ArmorSlot.class),
		(map) -> { map.put(ArmorItem.ArmorSlot.HELMET, 3); map.put(ArmorItem.ArmorSlot.CHESTPLATE, 8); map.put(ArmorItem.ArmorSlot.LEGGINGS, 6); map.put(ArmorItem.ArmorSlot.BOOTS, 3);}),
		4, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.5f, 0.1f, () -> Ingredient.ofItems(TSItems.Magic.IMPERIAL_ALLOY_INGOT), ModEffects.SET_BONUS_IMPERIAL),

	//DIAMOND - 33, (3, 6, 8, 3), 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0f, 0.0f

	//NETHERITE - 37, (3, 8, 6, 3), 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0f, 0.1f

    UNHOLY("unholy", 39, Util.make(new EnumMap<>(ArmorItem.ArmorSlot.class),
		(map) -> { map.put(ArmorItem.ArmorSlot.HELMET, 4); map.put(ArmorItem.ArmorSlot.CHESTPLATE, 10); map.put(ArmorItem.ArmorSlot.LEGGINGS, 8); map.put(ArmorItem.ArmorSlot.BOOTS, 4);}), 17, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.5f, 0.4f,
		() -> Ingredient.ofItems(TSItems.Magic.UNHOLY_INGOT), ModEffects.SET_BONUS_UNHOLY),

    NUCLEAR("nuclear", 39, Util.make(new EnumMap<>(ArmorItem.ArmorSlot.class),
		(map) -> { map.put(ArmorItem.ArmorSlot.HELMET, 4); map.put(ArmorItem.ArmorSlot.CHESTPLATE, 10); map.put(ArmorItem.ArmorSlot.LEGGINGS, 8); map.put(ArmorItem.ArmorSlot.BOOTS, 4);}), 0, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.5f, 0.4f,
		() -> Ingredient.ofItems(TSItems.Tech.NUCLEAR_INGOT), ModEffects.SET_BONUS_NUCLEAR),

    ARMA_DEI("arma_dei", 42, Util.make(new EnumMap<>(ArmorItem.ArmorSlot.class),
		(map) -> { map.put(ArmorItem.ArmorSlot.HELMET, 6); map.put(ArmorItem.ArmorSlot.CHESTPLATE, 12); map.put(ArmorItem.ArmorSlot.LEGGINGS, 8); map.put(ArmorItem.ArmorSlot.BOOTS, 5);}), 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.5f, 0.4f,
		() -> Ingredient.ofItems(Items.GOLD_INGOT), ModEffects.SET_BONUS_ARMA_DEI),

    NANOTECH("nanotech", 42, Util.make(new EnumMap<>(ArmorItem.ArmorSlot.class),
		(map) -> { map.put(ArmorItem.ArmorSlot.HELMET, 6); map.put(ArmorItem.ArmorSlot.CHESTPLATE, 12); map.put(ArmorItem.ArmorSlot.LEGGINGS, 8); map.put(ArmorItem.ArmorSlot.BOOTS, 5);}), 0, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.5f, 0.4f,
		() -> Ingredient.ofItems(TSItems.Tech.NANOTECH_CAPSULE), ModEffects.SET_BONUS_NANOTECH),

    ZENITHIUM("zenithium", 47, Util.make(new EnumMap<>(ArmorItem.ArmorSlot.class),
		(map) -> { map.put(ArmorItem.ArmorSlot.HELMET, 8); map.put(ArmorItem.ArmorSlot.CHESTPLATE, 14); map.put(ArmorItem.ArmorSlot.LEGGINGS, 10); map.put(ArmorItem.ArmorSlot.BOOTS, 7);}), 10, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 5f, 0.6f,
		() -> Ingredient.ofItems(TSItems.Tech.ZENITHIUM_CLUSTER), ModEffects.SET_BONUS_ZENITHIUM);

	private static final EnumMap<ArmorItem.ArmorSlot, Integer> base_durability = Util.make(new EnumMap<>(ArmorItem.ArmorSlot.class), (map) -> {
		map.put(ArmorItem.ArmorSlot.HELMET, 11); map.put(ArmorItem.ArmorSlot.CHESTPLATE, 16); map.put(ArmorItem.ArmorSlot.LEGGINGS, 15); map.put(ArmorItem.ArmorSlot.BOOTS, 13);
	});

	private final String name; private final int dMulti; private final EnumMap<ArmorItem.ArmorSlot, Integer> protection;
    private final int enchant; private final SoundEvent equipSound; private final float toughness;
    private final float knockRes; private final Supplier<Ingredient> repairIngredient; private final StatusEffect statusEffect;

	ModArmorMaterials(String name, int dMulti, EnumMap<ArmorItem.ArmorSlot, Integer> protection, int enchant, SoundEvent equipSound, float toughness, float knockRes,
					  Supplier<Ingredient> repairIngredient, StatusEffect statusEffect) {
		this.name = name; this.dMulti = dMulti; this.protection = protection;
		this.enchant = enchant; this.equipSound = equipSound; this.toughness = toughness;
		this.knockRes = knockRes; this.repairIngredient = repairIngredient; this.statusEffect = statusEffect;
	}

	@Override public String getName() { return trevorssentinelsMain.MOD_ID + ":" + this.name; }
	@Override public int getDurability(ArmorItem.ArmorSlot slot) { return base_durability.get(slot) * this.dMulti; }
	@Override public int getProtection(ArmorItem.ArmorSlot slot) { return this.protection.get(slot); }
	@Override public int getEnchantability() { return this.enchant; }
    @Override public SoundEvent getEquipSound() { return this.equipSound; }
	@Override public float getToughness() { return this.toughness; }
	@Override public float getKnockbackResistance() { return this.knockRes; }
	@Override public Ingredient getRepairIngredient() { return this.repairIngredient.get(); }
	@Override public StatusEffect getStatusEffect() { return statusEffect; }
}
