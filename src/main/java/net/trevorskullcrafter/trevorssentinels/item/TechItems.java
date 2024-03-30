package net.trevorskullcrafter.trevorssentinels.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.effect.ModEffects;
import net.trevorskullcrafter.trevorssentinels.item.custom.*;
import net.trevorskullcrafter.trevorssentinels.sound.ModSounds;
import net.trevorskullcrafter.trevorssentinels.util.Gunclasses;
import net.trevorskullcrafter.trevorssentinels.util.TextUtil;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import java.awt.*;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain.*;

public class TechItems {
	public static final Item SCRAP_METAL_SHARD = registerItem("scrap_metal_shard", new Item(new QuiltItemSettings()));
	public static final Item SCRAP_METAL_HELMET = registerItem("scrap_metal_helmet", new ArmorItem(ModArmorMaterials.SCRAP_METAL, ArmorItem.ArmorSlot.HELMET, new QuiltItemSettings()));
	public static final Item SCRAP_METAL_CHESTPLATE = registerItem("scrap_metal_chestplate", new ArmorItem(ModArmorMaterials.SCRAP_METAL, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings()));
	public static final Item SCRAP_METAL_LEGGINGS = registerItem("scrap_metal_leggings", new ArmorItem(ModArmorMaterials.SCRAP_METAL, ArmorItem.ArmorSlot.LEGGINGS, new QuiltItemSettings()));
	public static final Item SCRAP_METAL_BOOTS = registerItem("scrap_metal_boots", new ArmorItem(ModArmorMaterials.SCRAP_METAL, ArmorItem.ArmorSlot.BOOTS, new QuiltItemSettings()));
	public static final Item SCRAP_METAL_SWORD = registerItem("scrap_metal_sword", new SwordItem(ModToolMaterials.SCRAP_METAL, 1, -2.4f, new QuiltItemSettings()));
	public static final Item SCRAP_METAL_KNIFE = registerItem("scrap_metal_knife", new DaggerItem(ModToolMaterials.SCRAP_METAL, 1, 0, 0.9f, new QuiltItemSettings()));
	public static final Item SCRAP_METAL_DRILL = registerItem("scrap_metal_drill", new PickaxeItem(ModToolMaterials.SCRAP_METAL, 1, -2.8f, new QuiltItemSettings()));
	public static final Item SCRAP_METAL_CHAINSAW = registerItem("scrap_metal_chainsaw", new ChainsawItem(ModToolMaterials.SCRAP_METAL, 3, -3f, new QuiltItemSettings()));
	public static final Item SCRAP_METAL_SHOVEL = registerItem("scrap_metal_shovel", new ShovelItem(ModToolMaterials.SCRAP_METAL, 1.5f, -3f, new QuiltItemSettings()));
	public static final Item SCRAP_METAL_HOE = registerItem("scrap_metal_hoe", new HoeItem(ModToolMaterials.SCRAP_METAL, 0, -3f, new QuiltItemSettings()));

	public static final Item INDUSTRIAL_HELMET = registerItem("industrial_helmet", new ArmorItem(ModArmorMaterials.STARSTEEL, ArmorItem.ArmorSlot.HELMET, new QuiltItemSettings()));
	public static final Item INDUSTRIAL_CHESTPLATE = registerItem("industrial_chestplate", new ArmorItem( ModArmorMaterials.STARSTEEL, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings()));
	public static final Item INDUSTRIAL_LEGGINGS = registerItem("industrial_leggings", new ArmorItem(ModArmorMaterials.STARSTEEL, ArmorItem.ArmorSlot.LEGGINGS, new QuiltItemSettings()));
	public static final Item INDUSTRIAL_BOOTS = registerItem("industrial_boots", new ArmorItem(ModArmorMaterials.STARSTEEL, ArmorItem.ArmorSlot.BOOTS, new QuiltItemSettings()));
	public static final Item INDUSTRIAL_SWORD = registerItem("industrial_sword", new SwordItem(ModToolMaterials.STARSTEEL, 3, -2.4f, new QuiltItemSettings()));
	public static final Item INDUSTRIAL_KNIFE = registerItem("industrial_knife", new DaggerItem(ModToolMaterials.STARSTEEL, 3, 1.5f, 0.5f, new QuiltItemSettings()));
	public static final Item TRIMETAL_PICKAXE = registerItem("industrial_pickaxe", new PickaxeItem(ModToolMaterials.STARSTEEL, 1, 0f, new QuiltItemSettings()));
	public static final Item TRIMETAL_AXE = registerItem("industrial_axe", new AxeItem(ModToolMaterials.STARSTEEL, 3, -2.8f, new QuiltItemSettings()));
	public static final Item TRIMETAL_SHOVEL = registerItem("industrial_shovel", new ShovelItem(ModToolMaterials.STARSTEEL, 1.5f, -3f, new QuiltItemSettings()));
	public static final Item TRIMETAL_HOE = registerItem("industrial_hoe", new HoeItem(ModToolMaterials.STARSTEEL, 0, -3f, new QuiltItemSettings()));

	public static final Item STARSTEEL_SIGN = registerItem("starsteel_sign",
		new SignItem(new QuiltItemSettings().maxCount(16), ModBlocks.STARSTEEL_SIGN, ModBlocks.STARSTEEL_WALL_SIGN));
	public static final Item STARSTEEL_HANGING_SIGN = registerItem("starsteel_hanging_sign",
		new HangingSignItem(ModBlocks.STARSTEEL_HANGING_SIGN, ModBlocks.STARSTEEL_WALL_HANGING_SIGN, new QuiltItemSettings().maxCount(16)));

	public static final Item HOLOGRAPHIC_BLUE_SIGN = registerItem("holographic_blue_sign",
		new SignItem(new QuiltItemSettings().maxCount(16), ModBlocks.HOLOGRAPHIC_BLUE_SIGN_BLOCK, ModBlocks.HOLOGRAPHIC_BLUE_WALL_SIGN_BLOCK));
	public static final Item HOLOGRAPHIC_RED_SIGN = registerItem("holographic_red_sign",
		new SignItem(new QuiltItemSettings().maxCount(16), ModBlocks.HOLOGRAPHIC_RED_SIGN_BLOCK, ModBlocks.HOLOGRAPHIC_RED_WALL_SIGN_BLOCK));

	public static final Item STARSTEEL_INGOT = registerItem("starsteel_ingot", new Item(new QuiltItemSettings()));
	public static final Item STARSTEEL_HELMET = registerItem("starsteel_helmet", new ArmorItem(ModArmorMaterials.STARSTEEL, ArmorItem.ArmorSlot.HELMET, new QuiltItemSettings()));
	public static final Item STARSTEEL_CHESTPLATE = registerItem("starsteel_chestplate", new ArmorItem(ModArmorMaterials.STARSTEEL, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings()));
	public static final Item STARSTEEL_LEGGINGS = registerItem("starsteel_leggings", new ArmorItem(ModArmorMaterials.STARSTEEL, ArmorItem.ArmorSlot.LEGGINGS, new QuiltItemSettings()));
	public static final Item STARSTEEL_BOOTS = registerItem("starsteel_boots", new ArmorItem(ModArmorMaterials.STARSTEEL, ArmorItem.ArmorSlot.BOOTS, new QuiltItemSettings()));
	public static final Item STARSTEEL_SWORD = registerItem("starsteel_sword", new SwordItem(ModToolMaterials.STARSTEEL, 0, -2.4f, new QuiltItemSettings()));
	public static final Item STARSTEEL_KNIFE = registerItem("starsteel_knife", new DaggerItem(ModToolMaterials.STARSTEEL, 2, 0.5f, 0.3f, new QuiltItemSettings()));
	public static final Item STARSTEEL_DRILL = registerItem("starsteel_drill", new PickaxeItem(ModToolMaterials.STARSTEEL, 0, -2.8f, new QuiltItemSettings()));
	public static final Item STARSTEEL_AXE = registerItem("starsteel_axe", new AxeItem(ModToolMaterials.STARSTEEL, 3, -3f, new QuiltItemSettings()));
	public static final Item STARSTEEL_SHOVEL = registerItem("starsteel_shovel", new ShovelItem(ModToolMaterials.STARSTEEL, 1.5f, -3f, new QuiltItemSettings()));
	public static final Item STARSTEEL_HOE = registerItem("starsteel_hoe", new HoeItem(ModToolMaterials.STARSTEEL, 0, -3f, new QuiltItemSettings()));

	public static final Item NUCLEAR_INGOT = registerItem("nuclear_ingot", new Item(new QuiltItemSettings().fireproof()));
	public static final Item NUCLEAR_HELMET = registerItem("nuclear_helmet", new ArmorItem(ModArmorMaterials.NUCLEAR, ArmorItem.ArmorSlot.HELMET, new QuiltItemSettings().fireproof()));
	public static final Item NUCLEAR_CHESTPLATE = registerItem("nuclear_chestplate", new ArmorItem(ModArmorMaterials.NUCLEAR, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings().fireproof()));
	public static final Item NUCLEAR_LEGGINGS = registerItem("nuclear_leggings", new ArmorItem(ModArmorMaterials.NUCLEAR, ArmorItem.ArmorSlot.LEGGINGS, new QuiltItemSettings().fireproof()));
	public static final Item NUCLEAR_BOOTS = registerItem("nuclear_boots", new ArmorItem(ModArmorMaterials.NUCLEAR, ArmorItem.ArmorSlot.BOOTS, new QuiltItemSettings().fireproof()));
	public static final Item NUCLEAR_SWORD = registerItem("nuclear_sword", new SwordItem(ModToolMaterials.NUCLEAR, 3, -2.4f, new QuiltItemSettings().fireproof()));
	public static final Item NUCLEAR_VIBROKNIFE = registerItem("nuclear_vibroknife",
		new DaggerItem(ModToolMaterials.NUCLEAR, 1, 2.5f, 0.15f, new QuiltItemSettings().maxCount(16).fireproof(),
			new StatusEffectInstance(ModEffects.IRRADIATED, 60, 0)));
	public static final Item NUCLEAR_DRILL = registerItem("nuclear_drill", new PickaxeItem(ModToolMaterials.NUCLEAR, 0, 0, new QuiltItemSettings().fireproof()));
	public static final Item NUCLEAR_AXE = registerItem("nuclear_axe", new AxeItem(ModToolMaterials.NUCLEAR, 3, -3.1f, new QuiltItemSettings().fireproof()));
	public static final Item NUCLEAR_SHOVEL = registerItem("nuclear_shovel", new ShovelItem(ModToolMaterials.NUCLEAR, 1.5f, -3f, new QuiltItemSettings().fireproof()));
	public static final Item NUCLEAR_HOE = registerItem("nuclear_hoe", new HoeItem(ModToolMaterials.NUCLEAR, 0, -3f, new QuiltItemSettings().fireproof()));

	public static final Item NANOTECH_CAPSULE = registerItem("nanotech_capsule", new Item(new QuiltItemSettings()));
	public static final Item NANOTECH_HELMET = registerItem("nanotech_helmet", new ArmorItem(ModArmorMaterials.NANOTECH, ArmorItem.ArmorSlot.HELMET, new QuiltItemSettings().fireproof()));
	public static final Item NANOTECH_CHESTPLATE = registerItem("nanotech_chestplate", new ArmorItem(ModArmorMaterials.NANOTECH, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings().fireproof()));
	public static final Item NANOTECH_LEGGINGS = registerItem("nanotech_leggings", new ArmorItem(ModArmorMaterials.NANOTECH, ArmorItem.ArmorSlot.LEGGINGS, new QuiltItemSettings().fireproof()));
	public static final Item NANOTECH_BOOTS = registerItem("nanotech_boots", new ArmorItem(ModArmorMaterials.NANOTECH, ArmorItem.ArmorSlot.BOOTS, new QuiltItemSettings().fireproof()));
	public static final Item NANOTECH_SWORD = registerItem("nanotech_sword",
		new SwordItem(ModToolMaterials.NANOTECH, 3, -2.4f, new QuiltItemSettings().fireproof()));
	public static final Item NANOTECH_VIBROKNIFE = registerItem("nanotech_vibroknife", new DaggerItem(ModToolMaterials.NANOTECH, 1, 3f, 0.15f, new QuiltItemSettings().fireproof()));
	public static final Item NANOTECH_DRILL = registerItem("nanotech_drill", new PickaxeItem(ModToolMaterials.NANOTECH, 0, 0, new QuiltItemSettings().fireproof()));
	public static final Item NANOTECH_AXE = registerItem("nanotech_axe", new AxeItem(ModToolMaterials.NANOTECH, 3, -3.1f, new QuiltItemSettings().fireproof()));
	public static final Item NANOTECH_SHOVEL = registerItem("nanotech_shovel",
		new ShovelItem(ModToolMaterials.NANOTECH, 1.5f, -3f, new QuiltItemSettings().fireproof()));
	public static final Item NANOTECH_HOE = registerItem("nanotech_hoe", new HoeItem(ModToolMaterials.NANOTECH, 0, -3f, new QuiltItemSettings().fireproof()));

	public static final Item ZENITHIUM_CLUSTER = registerItem("zenithium_cluster", new Item(new QuiltItemSettings().fireproof()));
	public static final Item ZENITHIUM_HELMET = registerItem("zenithium_helmet", new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.ArmorSlot.HELMET, new QuiltItemSettings().fireproof()));
	public static final Item ZENITHIUM_CHESTPLATE = registerItem("zenithium_chestplate",
		new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings().fireproof()));
	public static final Item ZENITHIUM_LEGGINGS = registerItem("zenithium_leggings",
		new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.ArmorSlot.LEGGINGS, new QuiltItemSettings().fireproof()));
	public static final Item ZENITHIUM_BOOTS = registerItem("zenithium_boots", new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.ArmorSlot.BOOTS, new QuiltItemSettings()));
	public static final Item ZENITHIUM_SWORD = registerItem("zenithium_sword",
		new SwordItem(ModToolMaterials.ZENITHIUM, 3, -2.4f, new QuiltItemSettings().fireproof()));
	public static final Item ZENITHIUM_DAGGER = registerItem("zenithium_dagger", new DaggerItem(ModToolMaterials.ZENITHIUM, 1, 4f, 0, new QuiltItemSettings().fireproof()));
	public static final Item ZENITHIUM_PICKAXE = registerItem("zenithium_pickaxe",
		new PickaxeItem(ModToolMaterials.ZENITHIUM, 1, -2.8f, new QuiltItemSettings().fireproof()));
	public static final Item ZENITHIUM_AXE = registerItem("zenithium_axe", new AxeItem(ModToolMaterials.ZENITHIUM, 6, -3f, new QuiltItemSettings().fireproof()));
	public static final Item ZENITHIUM_SHOVEL = registerItem("zenithium_shovel",
		new ShovelItem(ModToolMaterials.ZENITHIUM, 1.5f, -3f, new QuiltItemSettings().fireproof()));
	public static final Item ZENITHIUM_HOE = registerItem("zenithium_hoe", new HoeItem(ModToolMaterials.ZENITHIUM, 0, -3f, new QuiltItemSettings().fireproof()));


	public static final Item LASER_PISTOL = registerItem("laser_pistol", new GunItem(new QuiltItemSettings().maxDamage(7), Gunclasses.PISTOL,
		1, 2f, 4.0f, 1.0f, 0.01f, 10, 50, 20, 5, 1, TextUtil.BLOOD_RED));

	public static final Item LASER_TASER = registerItem("laser_taser", new GunItem(new QuiltItemSettings().maxDamage(5), Gunclasses.PISTOL,
		1, 2f, 3.0f, 0.5f, 0.01f, 100, 20, 10, 1, 3, TextUtil.BLUE,
		new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 9)));

	public static final Item LASER_SNIPER_ECHO = registerItem("laser_sniper_echo", new GunItem(new QuiltItemSettings().maxDamage(4), Gunclasses.SNIPER,
		1, 2f, 1.0f, 5.0f, 0.09f,  20, 120, 52,  10, 1, TextUtil.YELLOW));

	public static final Item LASER_MINIGUN = registerItem("laser_minigun", new GunItem(new QuiltItemSettings().maxDamage(65), Gunclasses.SHOTGUN,
		3, 2f, 12.0f, 5.0f, 0.04f, 3, 200, 40,  2, 1, TextUtil.AQUA));

	public static final Item LASER_SHOTGUN = registerItem("laser_shotgun", new GunItem(new QuiltItemSettings().maxDamage(5), Gunclasses.SHOTGUN,
		6, 3f, 15.0f, 5.0f, 0.035f, 20, 100, 7, 12, 1, TextUtil.HELLFIRE));

	public static final Item LASER_SNIPER = registerItem("laser_sniper", new GunItem(new QuiltItemSettings().maxDamage(2), Gunclasses.SNIPER,
		1, 4f, 0.1f, 20.0f, 0.18f, 19, 200, 96, 20, 1, TextUtil.DARK_PURPLE));

	public static final Item LASER_HEALER = registerItem("laser_healer", new GunItem(new QuiltItemSettings().maxDamage(8), Gunclasses.PISTOL,
		1, 1f, 2.5f, 2.5f, 0.05f, 40, 150, 16, -1, 2, TextUtil.BLOOD_RED,
		new StatusEffectInstance(StatusEffects.REGENERATION, 60, 1), new StatusEffectInstance(StatusEffects.GLOWING, 60)));

	public static final Item LASER_SPREADER = registerItem("laser_spreader", new GunItem(new QuiltItemSettings().maxDamage(13), Gunclasses.GAS_LAUNCHER,
		1, 0.25f, 10.0f, 5.0f, 0.05f, 3, 150, 32, 2, 2, TextUtil.NUCLEAR,
		new StatusEffectInstance(StatusEffects.WITHER, 100, 1), new StatusEffectInstance(StatusEffects.BLINDNESS, 40)));

	public static final Item LASER_RIFLE = registerItem("laser_rifle", new GunItem(new QuiltItemSettings().maxDamage(21), Gunclasses.SHOTGUN,
		1, 2f, 2.5f, 2.5f, 0.035f, 3, 30, 48, 3, 1, TextUtil.GREEN));

	public static final Item LASER_REVOLVER = registerItem("laser_revolver", new GunItem(new QuiltItemSettings().maxDamage(7), Gunclasses.SHOTGUN,
		1, 3f, 15.0f, 5.0f, 0.075f, 3, 90, 48, 12, 3, Color.decode("11184810")));

	public static final Item VILE_SPITTER = registerItem("vile_spitter", new GunItem(new QuiltItemSettings().maxDamage(8), Gunclasses.VILE_SPITTER,
		1, 2f, 4.0f, 2.0f, 0.035f, 11, 60, 48, 8, 3, TextUtil.FLESH_PUS,
		new StatusEffectInstance(ModEffects.INFESTED, 20)));

	public static final Item PHOTONIC_LENS = registerItem("photonic_lens", new PhotonicLensItem(new QuiltItemSettings().maxCount(1)));
	public static final Item PLASMA_DIFFUSER = registerItem("plasma_diffuser", new PhaserAttachmentItem(new QuiltItemSettings().maxCount(1)));

	public static final Item SCRAP_METAL_PHASER = registerItem("scrap_metal_phaser", new PhaserItem(new QuiltItemSettings().maxCount(1)));
	public static final Item STARSTEEL_PHASER = registerItem("starsteel_phaser", new PhaserItem(new QuiltItemSettings().maxCount(1)));
	public static final Item NANOTECH_PHASER = registerItem("nanotech_phaser", new PhaserItem(new QuiltItemSettings().maxCount(1)));


	public static final Item HARD_LIGHT_PROJECTOR = registerItem("hard_light_projector", new HardLightProjectorItem(ModBlocks.HARD_LIGHT, new QuiltItemSettings().maxDamage(129)));
	public static final Item CAUTION_HARD_LIGHT_PROJECTOR = registerItem("caution_hard_light_projector", new HardLightProjectorItem(ModBlocks.CAUTION_HARD_LIGHT,
		new QuiltItemSettings().maxDamage(129)));
	public static final Item SENTINEL_HARD_LIGHT_PROJECTOR = registerItem("sentinel_hard_light_projector", new HardLightProjectorItem(ModBlocks.SENTINEL_HARD_LIGHT,
		new QuiltItemSettings().maxDamage(129)));

	public static final Item ENERGY_CELL = registerItem("energy_cell", new Item(new QuiltItemSettings()));
	public static final Item GAS_CAPSULE = registerItem("gas_capsule", new GasCapsuleItem(new QuiltItemSettings(),
		new StatusEffectInstance(StatusEffects.WITHER, 100, 1), new StatusEffectInstance(StatusEffects.BLINDNESS, 40)));
	public static final Item NUCLEAR_ROCKET = registerItem("nuclear_rocket", new NuclearRocketItem(new QuiltItemSettings().maxDamage(93)));

	public static final Item EMPTY_CAN = registerItem("empty_can", new Item(new QuiltItemSettings()));
	public static final Item BEETROOT_SOUP_CAN = registerItem("beetroot_soup_can", new CannedItem(new QuiltItemSettings()
		.food(new FoodComponent.Builder().snack().hunger(3).saturationModifier(0.6f).build())));
	public static final Item MUSHROOM_STEW_CAN = registerItem("mushroom_stew_can", new CannedItem(new QuiltItemSettings()
		.food(new FoodComponent.Builder().snack().hunger(3).saturationModifier(0.6f).build())));
	public static final Item RABBIT_STEW_CAN = registerItem("rabbit_stew_can", new CannedItem(new QuiltItemSettings()
		.food(new FoodComponent.Builder().snack().hunger(5).saturationModifier(0.6f).build())));
	public static final Item MILK_CAN = registerItem("milk_can", new CannedItem(new QuiltItemSettings()
		.food(new FoodComponent.Builder().snack().hunger(2).saturationModifier(0.3f).build())));
	public static final Item COLA_ORANGE = registerItem("cola_orange", new CannedItem(new QuiltItemSettings()
		.food(new FoodComponent.Builder().snack().hunger(2).saturationModifier(0.3f).build())));
	public static final Item COLA_GREEN = registerItem("cola_green", new CannedItem(new QuiltItemSettings()
		.food(new FoodComponent.Builder().snack().hunger(2).saturationModifier(0.3f).build())));
	public static final Item COLA_CYAN = registerItem("cola_cyan", new CannedItem(new QuiltItemSettings()
		.food(new FoodComponent.Builder().snack().hunger(2).saturationModifier(0.3f).build())));

	public static final Item MUSIC_DISC_ASSASSINATION_UPLOAD = registerItem("music_disc_assassination_upload", new MusicDiscItem
		(7, ModSounds.ASSASSINATION_UPLOAD, new QuiltItemSettings().maxCount(1).rarity(Rarity.RARE), 190));
	public static final Item MUSIC_DISC_ODE_TO_TRANQUILITY = registerItem("music_disc_ode_to_tranquility", new MusicDiscItem
		(7, ModSounds.ODE_TO_TRANQUILITY, new QuiltItemSettings().maxCount(1).rarity(Rarity.RARE), 80));
	public static final Item MUSIC_DISC_LAPSE_IN_JUDGEMENT = registerItem("music_disc_lapse_in_judgement", new MusicDiscItem
		(7, ModSounds.LAPSE_IN_JUDGEMENT, new QuiltItemSettings().maxCount(1).rarity(Rarity.RARE), 142));
	public static final Item MUSIC_DISC_RECITAL = registerItem("music_disc_recital", new MusicDiscItem
		(7, ModSounds.RECITAL, new QuiltItemSettings().maxCount(1).rarity(Rarity.RARE), 114));

	private static Item registerItem(String name, Item item){ return Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), item); }
	public static void registerModItems(){ LOGGER.info("Registering items... (" + MOD_ID + ")"); }
}
