package net.trevorskullcrafter.trevorssentinels.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.effect.ModEffects;
import net.trevorskullcrafter.trevorssentinels.item.custom.DaggerItem;
import net.trevorskullcrafter.trevorssentinels.item.custom.InfiniteEffectItem;
import net.trevorskullcrafter.trevorssentinels.item.custom.NewDaggerItem;
import net.trevorskullcrafter.trevorssentinels.item.custom.unique.PortkeyItem;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain.*;

public class MagicItems {
	public static final Item ROSE_GOLD_INGOT = registerItem("rose_gold_ingot", new Item(new QuiltItemSettings()));
	public static final Item ROSE_GOLD_HELMET = registerItem("rose_gold_helmet", new ArmorItem(ModArmorMaterials.ROSE_GOLD, ArmorItem.ArmorSlot.HELMET, new QuiltItemSettings()));
	public static final Item ROSE_GOLD_CHESTPLATE = registerItem("rose_gold_chestplate", new ArmorItem(ModArmorMaterials.ROSE_GOLD, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings()));
	public static final Item ROSE_GOLD_LEGGINGS = registerItem("rose_gold_leggings", new ArmorItem(ModArmorMaterials.ROSE_GOLD, ArmorItem.ArmorSlot.LEGGINGS, new QuiltItemSettings()));
	public static final Item ROSE_GOLD_BOOTS = registerItem("rose_gold_boots", new ArmorItem(ModArmorMaterials.ROSE_GOLD, ArmorItem.ArmorSlot.BOOTS, new QuiltItemSettings()));
	public static final Item ROSE_GOLD_SWORD = registerItem("rose_gold_sword", new SwordItem(ModToolMaterials.ROSE_GOLD, 3, -2.4f, new QuiltItemSettings()));
	public static final Item ROSE_GOLD_DAGGER = registerItem("rose_gold_dagger", new DaggerItem(ModToolMaterials.ROSE_GOLD, 1, 0, 0.85f, new QuiltItemSettings()));
	public static final Item ROSE_GOLD_PICKAXE = registerItem("rose_gold_pickaxe", new PickaxeItem(ModToolMaterials.ROSE_GOLD, 1, -2.8f, new QuiltItemSettings()));
	public static final Item ROSE_GOLD_BATTLEAXE = registerItem("rose_gold_battleaxe", new AxeItem(ModToolMaterials.ROSE_GOLD, 3, -3f, new QuiltItemSettings()));
	public static final Item ROSE_GOLD_SHOVEL = registerItem("rose_gold_shovel", new ShovelItem(ModToolMaterials.ROSE_GOLD, 1.5f, -3f, new QuiltItemSettings()));
	public static final Item ROSE_GOLD_SICKLE = registerItem("rose_gold_sickle", new HoeItem(ModToolMaterials.ROSE_GOLD, 0, -3f, new QuiltItemSettings()));

	public static final Item IMPERIAL_ALLOY_INGOT = registerItem("imperial_alloy_ingot", new Item(new QuiltItemSettings()));
	public static final Item IMPERIAL_HELMET = registerItem("imperial_helmet", new ArmorItem(ModArmorMaterials.IMPERIAL, ArmorItem.ArmorSlot.HELMET, new QuiltItemSettings()));
	public static final Item IMPERIAL_CHESTPLATE = registerItem("imperial_chestplate", new ArmorItem(ModArmorMaterials.IMPERIAL, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings()));
	public static final Item IMPERIAL_LEGGINGS = registerItem("imperial_leggings", new ArmorItem(ModArmorMaterials.IMPERIAL, ArmorItem.ArmorSlot.LEGGINGS, new QuiltItemSettings()));
	public static final Item IMPERIAL_BOOTS = registerItem("imperial_boots", new ArmorItem(ModArmorMaterials.IMPERIAL, ArmorItem.ArmorSlot.BOOTS, new QuiltItemSettings()));
	public static final Item IMPERIAL_SWORD = registerItem("imperial_sword", new SwordItem(ModToolMaterials.IMPERIAL_ALLOY, 3, -2.4f, new QuiltItemSettings()));
	public static final Item IMPERIAL_GLADIUS = registerItem("imperial_gladius", new DaggerItem(ModToolMaterials.IMPERIAL_ALLOY, 4, 2f, 0.35f, new QuiltItemSettings()));
	public static final Item IMPERIAL_PICKAXE = registerItem("imperial_pickaxe", new PickaxeItem(ModToolMaterials.IMPERIAL_ALLOY, 0,0f, new QuiltItemSettings()));
	public static final Item IMPERIAL_BATTLEAXE = registerItem("imperial_battleaxe", new AxeItem(ModToolMaterials.IMPERIAL_ALLOY, 3, -2.8f, new QuiltItemSettings()));
	public static final Item IMPERIAL_SHOVEL = registerItem("imperial_shovel", new ShovelItem(ModToolMaterials.IMPERIAL_ALLOY, 1.5f, -3f, new QuiltItemSettings()));
	public static final Item IMPERIAL_SICKLE = registerItem("imperial_sickle", new HoeItem(ModToolMaterials.IMPERIAL_ALLOY, 0, -3f, new QuiltItemSettings()));

	public static final Item UNHOLY_SHARDS = registerItem("unholy_shards", new Item(new QuiltItemSettings().fireproof()));
	public static final Item UNHOLY_INGOT = registerItem("unholy_ingot", new Item(new QuiltItemSettings().fireproof()));
	public static final Item UNHOLY_HELMET = registerItem("unholy_helmet", new ArmorItem(ModArmorMaterials.UNHOLY, ArmorItem.ArmorSlot.HELMET, new QuiltItemSettings().fireproof()));
	public static final Item UNHOLY_CHESTPLATE = registerItem("unholy_chestplate", new ArmorItem(ModArmorMaterials.UNHOLY, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings().fireproof()));
	public static final Item UNHOLY_LEGGINGS = registerItem("unholy_leggings", new ArmorItem(ModArmorMaterials.UNHOLY, ArmorItem.ArmorSlot.LEGGINGS, new QuiltItemSettings().fireproof()));
	public static final Item UNHOLY_BOOTS = registerItem("unholy_boots", new ArmorItem(ModArmorMaterials.UNHOLY, ArmorItem.ArmorSlot.BOOTS, new QuiltItemSettings().fireproof()));
	public static final Item UNHOLY_SWORD = registerItem("unholy_sword", new SwordItem(ModToolMaterials.DARKSTEEL, 3, -2.4f, new QuiltItemSettings().fireproof()));
	public static final Item UNHOLY_DAGGER = registerItem("unholy_dagger", new DaggerItem(ModToolMaterials.DARKSTEEL, 6, 2.5f, 0.15f, new QuiltItemSettings().fireproof()));
	public static final Item UNHOLY_PICKAXE = registerItem("unholy_pickaxe", new PickaxeItem(ModToolMaterials.DARKSTEEL, 0,0f, new QuiltItemSettings().fireproof()));
	public static final Item UNHOLY_BATTLEAXE = registerItem("unholy_axe", new AxeItem(ModToolMaterials.DARKSTEEL, 3, -2.8f, new QuiltItemSettings().fireproof()));
	public static final Item UNHOLY_SHOVEL = registerItem("unholy_shovel", new ShovelItem(ModToolMaterials.DARKSTEEL, 1.5f, -3f, new QuiltItemSettings().fireproof()));
	public static final Item UNHOLY_SICKLE = registerItem("unholy_hoe", new HoeItem(ModToolMaterials.DARKSTEEL, 0, -3f, new QuiltItemSettings().fireproof()));

	public static final Item THANATU_HELMET = registerItem("thanatu_helmet", new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.ArmorSlot.HELMET, new QuiltItemSettings()));
	public static final Item THANATU_CHESTPLATE = registerItem("thanatu_chestplate", new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings()));
	public static final Item THANATU_LEGGINGS = registerItem("thanatu_leggings", new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings()));
	public static final Item THANATU_BOOTS = registerItem("thanatu_boots", new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings()));


	public static final Item COPPER_GLADIUS = registerItem("copper_gladius", new NewDaggerItem(ModToolMaterials.COPPER, 2, 2f, new QuiltItemSettings()));
	public static final Item ICICLE_DAGGER = registerItem("icicle_dagger", new NewDaggerItem(ModToolMaterials.COPPER, 1, 2f, new QuiltItemSettings(),
		new StatusEffectInstance(StatusEffects.SLOWNESS, 20, 1)));


	public static final Item DEMONIC_CORE = registerItem("demonic_core", new PortkeyItem(new QuiltItemSettings().maxDamage(3)));


	public static final Item RESISTANCE_ITEM = registerItem("resistance_item", new InfiniteEffectItem(new QuiltItemSettings().maxCount(1),
		new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 0, false, false)));

	public static final Item FIRE_RESISTANCE_ITEM = registerItem("fire_resistance_item", new InfiniteEffectItem(new QuiltItemSettings().maxCount(1).fireproof(),
		new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 1, false, false),
		new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200, 0, false, false)));

	public static final Item JUMP_BOOST_ITEM = registerItem("jump_boost_item", new InfiniteEffectItem(new QuiltItemSettings().maxCount(1),
		new StatusEffectInstance(StatusEffects.JUMP_BOOST, 200, 0, false, false)));

	public static final Item DOLPHINS_GRACE_ITEM = registerItem("dolphins_grace_item", new InfiniteEffectItem(new QuiltItemSettings().maxCount(1),
		new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 200, 0, false, false)));

	public static final Item HERO_OF_THE_VILLAGE_ITEM = registerItem("hero_of_the_village_item", new InfiniteEffectItem(new QuiltItemSettings().maxCount(1),
		new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 200, 0, false, false)));

	public static final Item GALLIUM_STOMACH = registerItem("gallium_stomach", new InfiniteEffectItem(new QuiltItemSettings().maxCount(1),
		new StatusEffectInstance(ModEffects.WELL_FED, 200, 0, false, false)));

	public static final Item ONE_PENCE = registerItem("one_pence", new InfiniteEffectItem(new QuiltItemSettings().maxCount(1),
		new StatusEffectInstance(StatusEffects.LUCK, 200, 9, false, false)));

	public static final Item WEAKNESS_ITEM = registerItem("weakness_item", new InfiniteEffectItem(new QuiltItemSettings().maxCount(1),
		new StatusEffectInstance(StatusEffects.WEAKNESS, 200, 0, false, false)));

	public static final Item EYE_OF_RUIN = registerItem("eye_of_ruin", new Item(new QuiltItemSettings()));
	public static final Item DUBIOUS_BACON = registerItem("dubious_bacon", new Item(new QuiltItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.4f)
		.statusEffect(new StatusEffectInstance(ModEffects.INFESTED, 200, 0), 0.1f).build())));

	public static final Item PALE_SIGN = registerItem("pale_sign",
		new SignItem(new QuiltItemSettings().maxCount(16), ModBlocks.PALE_SIGN, ModBlocks.PALE_WALL_SIGN));
	public static final Item PALE_HANGING_SIGN = registerItem("pale_hanging_sign",
		new HangingSignItem(ModBlocks.PALE_HANGING_SIGN, ModBlocks.PALE_WALL_HANGING_SIGN, new QuiltItemSettings().maxCount(16)));
	public static final Item PALE_BOAT = registerItem("pale_boat", new BoatItem(false, BoatEntity.Variant.BIRCH, new Item.Settings().maxCount(1)));
	public static final Item PALE_CHEST_BOAT = registerItem("pale_chest_boat", new BoatItem(true, BoatEntity.Variant.BIRCH, new Item.Settings().maxCount(1)));

	public static final Item CHARRED_SIGN = registerItem("charred_sign",
		new SignItem(new QuiltItemSettings().maxCount(16), ModBlocks.CHARRED_SIGN, ModBlocks.CHARRED_WALL_SIGN));
	public static final Item CHARRED_HANGING_SIGN = registerItem("charred_hanging_sign",
		new HangingSignItem(ModBlocks.CHARRED_HANGING_SIGN, ModBlocks.CHARRED_WALL_HANGING_SIGN, new QuiltItemSettings().maxCount(16)));
	public static final Item CHARRED_BOAT = registerItem("charred_oak_boat", new BoatItem(false, BoatEntity.Variant.OAK, new Item.Settings().maxCount(1)));
	public static final Item CHARRED_CHEST_BOAT = registerItem("charred_oak_chest_boat", new BoatItem(true, BoatEntity.Variant.OAK, new Item.Settings().maxCount(1)));

	public static final Item MIDAS_SIGN = registerItem("midas_sign",
		new SignItem(new QuiltItemSettings().maxCount(16), ModBlocks.MIDAS_SIGN, ModBlocks.MIDAS_WALL_SIGN));
	public static final Item MIDAS_HANGING_SIGN = registerItem("midas_hanging_sign",
		new HangingSignItem(ModBlocks.MIDAS_HANGING_SIGN, ModBlocks.MIDAS_WALL_HANGING_SIGN, new QuiltItemSettings().maxCount(16)));
	public static final Item MIDAS_BOAT = registerItem("midas_boat", new BoatItem(false, BoatEntity.Variant.DARK_OAK, new Item.Settings().maxCount(1)));
	public static final Item MIDAS_CHEST_BOAT = registerItem("midas_chest_boat", new BoatItem(true, BoatEntity.Variant.DARK_OAK, new Item.Settings().maxCount(1)));

	public static final Item VIRIDIAN_SIGN = registerItem("viridian_sign",
		new SignItem(new QuiltItemSettings().maxCount(16), ModBlocks.VIRIDIAN_SIGN, ModBlocks.VIRIDIAN_WALL_SIGN));
	public static final Item VIRIDIAN_HANGING_SIGN = registerItem("viridian_hanging_sign",
		new HangingSignItem(ModBlocks.VIRIDIAN_HANGING_SIGN, ModBlocks.VIRIDIAN_WALL_HANGING_SIGN, new QuiltItemSettings().maxCount(16)));
	public static final Item VIRIDIAN_BOAT = registerItem("viridian_boat", new BoatItem(false, BoatEntity.Variant.JUNGLE, new Item.Settings().maxCount(1)));
	public static final Item VIRIDIAN_CHEST_BOAT = registerItem("viridian_chest_boat", new BoatItem(true, BoatEntity.Variant.JUNGLE, new Item.Settings().maxCount(1)));

	public static final Item CERULII_SIGN = registerItem("cerulii_sign",
		new SignItem(new QuiltItemSettings().maxCount(16), ModBlocks.CERULII_SIGN, ModBlocks.CERULII_WALL_SIGN));
	public static final Item CERULII_HANGING_SIGN = registerItem("cerulii_hanging_sign",
		new HangingSignItem(ModBlocks.CERULII_HANGING_SIGN, ModBlocks.CERULII_WALL_HANGING_SIGN, new QuiltItemSettings().maxCount(16)));
	public static final Item CERULII_BOAT = registerItem("cerulii_boat", new BoatItem(false, BoatEntity.Variant.JUNGLE, new Item.Settings().maxCount(1)));
	public static final Item CERULII_CHEST_BOAT = registerItem("cerulii_chest_boat", new BoatItem(true, BoatEntity.Variant.JUNGLE, new Item.Settings().maxCount(1)));

	private static Item registerItem(String name, Item item){ return Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), item); }
	public static void registerModItems(){ LOGGER.info("Registering items... (" + MOD_ID + ")"); }
}
