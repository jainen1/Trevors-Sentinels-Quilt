package net.trevorskullcrafter.trevorssentinels.item;

import io.wispforest.owo.registration.annotations.RegistryNamespace;
import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.*;
import net.minecraft.util.Rarity;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.effect.ModEffects;
import net.trevorskullcrafter.trevorssentinels.item.custom.*;
import net.trevorskullcrafter.trevorssentinels.item.custom.unique.*;
import net.trevorskullcrafter.trevorssentinels.sound.ModSounds;
import net.trevorskullcrafter.trevorssentinels.util.Gunclasses;
import net.trevorskullcrafter.trevorssentinels.util.TextUtil;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class TSItems implements ItemRegistryContainer {
	@RegistryNamespace("trevorssentinels")
	public static class Tech implements ItemRegistryContainer {
		public static final Item SCRAP_METAL_SHARD = new Item(new QuiltItemSettings());
		public static final Item SCRAP_METAL_HELMET = new ArmorItem(ModArmorMaterials.SCRAP_METAL, ArmorItem.ArmorSlot.HELMET, new QuiltItemSettings());
		public static final Item SCRAP_METAL_CHESTPLATE = new ArmorItem(ModArmorMaterials.SCRAP_METAL, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings());
		public static final Item SCRAP_METAL_LEGGINGS = new ArmorItem(ModArmorMaterials.SCRAP_METAL, ArmorItem.ArmorSlot.LEGGINGS, new QuiltItemSettings());
		public static final Item SCRAP_METAL_BOOTS = new ArmorItem(ModArmorMaterials.SCRAP_METAL, ArmorItem.ArmorSlot.BOOTS, new QuiltItemSettings());
		public static final Item SCRAP_METAL_SWORD = new SwordItem(ModToolMaterials.SCRAP_METAL, 1, -2.4f, new QuiltItemSettings());
		public static final Item SCRAP_METAL_KNIFE = new DaggerItem(ModToolMaterials.SCRAP_METAL, 1, 0, 0.9f, new QuiltItemSettings());
		public static final Item SCRAP_METAL_DRILL = new PickaxeItem(ModToolMaterials.SCRAP_METAL, 1, -2.8f, new QuiltItemSettings());
		public static final Item SCRAP_METAL_CHAINSAW = new ChainsawItem(ModToolMaterials.SCRAP_METAL, 3, -3f, new QuiltItemSettings());
		public static final Item SCRAP_METAL_SHOVEL = new ShovelItem(ModToolMaterials.SCRAP_METAL, 1.5f, -3f, new QuiltItemSettings());
		public static final Item SCRAP_METAL_HOE = new HoeItem(ModToolMaterials.SCRAP_METAL, 0, -3f, new QuiltItemSettings());

		public static final Item INDUSTRIAL_HELMET = new ArmorItem(ModArmorMaterials.STARSTEEL, ArmorItem.ArmorSlot.HELMET, new QuiltItemSettings());
		public static final Item INDUSTRIAL_HARNESS = new ArmorItem( ModArmorMaterials.STARSTEEL, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings());
		public static final Item INDUSTRIAL_PANTS = new ArmorItem(ModArmorMaterials.STARSTEEL, ArmorItem.ArmorSlot.LEGGINGS, new QuiltItemSettings());
		public static final Item INDUSTRIAL_BOOTS = new ArmorItem(ModArmorMaterials.STARSTEEL, ArmorItem.ArmorSlot.BOOTS, new QuiltItemSettings());
		public static final Item INDUSTRIAL_CROWBAR = new SwordItem(ModToolMaterials.STARSTEEL, 3, -2.4f, new QuiltItemSettings());
		public static final Item INDUSTRIAL_KNIFE = new DaggerItem(ModToolMaterials.STARSTEEL, 3, 1.5f, 0.5f, new QuiltItemSettings());
		public static final Item TRIMETAL_PICKAXE = new PickaxeItem(ModToolMaterials.STARSTEEL, 1, 0f, new QuiltItemSettings());
		public static final Item TRIMETAL_AXE = new AxeItem(ModToolMaterials.STARSTEEL, 3, -2.8f, new QuiltItemSettings());
		public static final Item TRIMETAL_SHOVEL = new ShovelItem(ModToolMaterials.STARSTEEL, 1.5f, -3f, new QuiltItemSettings());
		public static final Item TRIMETAL_HOE = new HoeItem(ModToolMaterials.STARSTEEL, 0, -3f, new QuiltItemSettings());

		public static final Item STARSTEEL_SIGN = new SignItem(new QuiltItemSettings().maxCount(16), ModBlocks.STARSTEEL_SIGN, ModBlocks.STARSTEEL_WALL_SIGN);
		public static final Item STARSTEEL_HANGING_SIGN = new HangingSignItem(ModBlocks.STARSTEEL_HANGING_SIGN, ModBlocks.STARSTEEL_WALL_HANGING_SIGN, new QuiltItemSettings().maxCount(16));
		public static final Item HOLOGRAPHIC_SIGN = new SignItem(new QuiltItemSettings().maxCount(16), ModBlocks.HOLOGRAPHIC_SIGN, ModBlocks.HOLOGRAPHIC_WALL_SIGN);
		public static final Item HOLOGRAPHIC_HANGING_SIGN = new HangingSignItem(ModBlocks.HOLOGRAPHIC_HANGING_SIGN, ModBlocks.HOLOGRAPHIC_WALL_HANGING_SIGN, new QuiltItemSettings().maxCount(16));
		public static final Item CAUTION_HOLOGRAPHIC_SIGN = new SignItem(new QuiltItemSettings().maxCount(16), ModBlocks.CAUTION_HOLOGRAPHIC_SIGN, ModBlocks.CAUTION_HOLOGRAPHIC_WALL_SIGN);
		public static final Item CAUTION_HOLOGRAPHIC_HANGING_SIGN = new HangingSignItem(ModBlocks.CAUTION_HOLOGRAPHIC_HANGING_SIGN, ModBlocks.CAUTION_HOLOGRAPHIC_WALL_HANGING_SIGN, new QuiltItemSettings().maxCount(16));
		public static final Item SENTINEL_HOLOGRAPHIC_SIGN = new SignItem(new QuiltItemSettings().maxCount(16), ModBlocks.SENTINEL_HOLOGRAPHIC_SIGN, ModBlocks.SENTINEL_HOLOGRAPHIC_WALL_SIGN);
		public static final Item SENTINEL_HOLOGRAPHIC_HANGING_SIGN = new HangingSignItem(ModBlocks.SENTINEL_HOLOGRAPHIC_HANGING_SIGN, ModBlocks.SENTINEL_HOLOGRAPHIC_WALL_HANGING_SIGN, new QuiltItemSettings().maxCount(16));

		public static final Item STARSTEEL_INGOT = new Item(new QuiltItemSettings());
		public static final Item STARSTEEL_HELMET = new ArmorItem(ModArmorMaterials.STARSTEEL, ArmorItem.ArmorSlot.HELMET, new QuiltItemSettings());
		public static final Item STARSTEEL_CHESTPLATE = new ArmorItem(ModArmorMaterials.STARSTEEL, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings());
		public static final Item STARSTEEL_LEGGINGS = new ArmorItem(ModArmorMaterials.STARSTEEL, ArmorItem.ArmorSlot.LEGGINGS, new QuiltItemSettings());
		public static final Item STARSTEEL_BOOTS = new ArmorItem(ModArmorMaterials.STARSTEEL, ArmorItem.ArmorSlot.BOOTS, new QuiltItemSettings());
		public static final Item STARSTEEL_SWORD = new SwordItem(ModToolMaterials.STARSTEEL, 0, -2.4f, new QuiltItemSettings());
		public static final Item STARSTEEL_KNIFE = new DaggerItem(ModToolMaterials.STARSTEEL, 2, 0.5f, 0.3f, new QuiltItemSettings());
		public static final Item STARSTEEL_DRILL = new PickaxeItem(ModToolMaterials.STARSTEEL, 0, -2.8f, new QuiltItemSettings());
		public static final Item STARSTEEL_AXE = new AxeItem(ModToolMaterials.STARSTEEL, 3, -3f, new QuiltItemSettings());
		public static final Item STARSTEEL_SHOVEL = new ShovelItem(ModToolMaterials.STARSTEEL, 1.5f, -3f, new QuiltItemSettings());
		public static final Item STARSTEEL_HOE = new HoeItem(ModToolMaterials.STARSTEEL, 0, -3f, new QuiltItemSettings());

		public static final Item NUCLEAR_INGOT = new Item(new QuiltItemSettings().fireproof());
		public static final Item NUCLEAR_HELMET = new ArmorItem(ModArmorMaterials.NUCLEAR, ArmorItem.ArmorSlot.HELMET, new QuiltItemSettings().fireproof());
		public static final Item NUCLEAR_CHESTPLATE = new ArmorItem(ModArmorMaterials.NUCLEAR, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings().fireproof());
		public static final Item NUCLEAR_LEGGINGS = new ArmorItem(ModArmorMaterials.NUCLEAR, ArmorItem.ArmorSlot.LEGGINGS, new QuiltItemSettings().fireproof());
		public static final Item NUCLEAR_BOOTS = new ArmorItem(ModArmorMaterials.NUCLEAR, ArmorItem.ArmorSlot.BOOTS, new QuiltItemSettings().fireproof());
		public static final Item NUCLEAR_SWORD = new SwordItem(ModToolMaterials.NUCLEAR, 3, -2.4f, new QuiltItemSettings().fireproof());
		public static final Item NUCLEAR_VIBROKNIFE =
			new DaggerItem(ModToolMaterials.NUCLEAR, 1, 2.5f, 0.15f, new QuiltItemSettings().maxCount(16).fireproof(),
				new StatusEffectInstance(ModEffects.IRRADIATED, 60, 0));
		public static final Item NUCLEAR_DRILL = new PickaxeItem(ModToolMaterials.NUCLEAR, 0, 0, new QuiltItemSettings().fireproof());
		public static final Item NUCLEAR_AXE = new AxeItem(ModToolMaterials.NUCLEAR, 3, -3.1f, new QuiltItemSettings().fireproof());
		public static final Item NUCLEAR_SHOVEL = new ShovelItem(ModToolMaterials.NUCLEAR, 1.5f, -3f, new QuiltItemSettings().fireproof());
		public static final Item NUCLEAR_HOE = new HoeItem(ModToolMaterials.NUCLEAR, 0, -3f, new QuiltItemSettings().fireproof());

		public static final Item NANOTECH_CAPSULE = new Item(new QuiltItemSettings().fireproof().food(new FoodComponent.Builder().statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 3), 1.0f).alwaysEdible().build()));
		public static final Item NANOTECH_HELMET = new ArmorItem(ModArmorMaterials.NANOTECH, ArmorItem.ArmorSlot.HELMET, new QuiltItemSettings().fireproof());
		public static final Item NANOTECH_CHESTPLATE = new ArmorItem(ModArmorMaterials.NANOTECH, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings().fireproof());
		public static final Item NANOTECH_LEGGINGS = new ArmorItem(ModArmorMaterials.NANOTECH, ArmorItem.ArmorSlot.LEGGINGS, new QuiltItemSettings().fireproof());
		public static final Item NANOTECH_BOOTS = new ArmorItem(ModArmorMaterials.NANOTECH, ArmorItem.ArmorSlot.BOOTS, new QuiltItemSettings().fireproof());
		public static final Item NANOTECH_SWORD = new SwordItem(ModToolMaterials.NANOTECH, 3, -2.4f, new QuiltItemSettings().fireproof());
		public static final Item NANOTECH_VIBROKNIFE = new DaggerItem(ModToolMaterials.NANOTECH, 1, 3f, 0.15f, new QuiltItemSettings().fireproof());
		public static final Item NANOTECH_DRILL = new PickaxeItem(ModToolMaterials.NANOTECH, 0, 0, new QuiltItemSettings().fireproof());
		public static final Item NANOTECH_AXE = new AxeItem(ModToolMaterials.NANOTECH, 3, -3.1f, new QuiltItemSettings().fireproof());
		public static final Item NANOTECH_SHOVEL = new ShovelItem(ModToolMaterials.NANOTECH, 1.5f, -3f, new QuiltItemSettings().fireproof());
		public static final Item NANOTECH_HOE = new HoeItem(ModToolMaterials.NANOTECH, 0, -3f, new QuiltItemSettings().fireproof());

		public static final Item ZENITHIUM_CLUSTER = new Item(new QuiltItemSettings().fireproof());
		public static final Item ZENITHIUM_HELMET = new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.ArmorSlot.HELMET, new QuiltItemSettings().fireproof());
		public static final Item ZENITHIUM_CHESTPLATE = new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings().fireproof());
		public static final Item ZENITHIUM_LEGGINGS = new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.ArmorSlot.LEGGINGS, new QuiltItemSettings().fireproof());
		public static final Item ZENITHIUM_BOOTS = new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.ArmorSlot.BOOTS, new QuiltItemSettings());
		public static final Item ZENITHIUM_SWORD = new SwordItem(ModToolMaterials.ZENITHIUM, 3, -2.4f, new QuiltItemSettings().fireproof());
		public static final Item ZENITHIUM_DAGGER = new DaggerItem(ModToolMaterials.ZENITHIUM, 1, 4f, 0, new QuiltItemSettings().fireproof());
		public static final Item ZENITHIUM_PICKAXE = new PickaxeItem(ModToolMaterials.ZENITHIUM, 1, -2.8f, new QuiltItemSettings().fireproof());
		public static final Item ZENITHIUM_AXE = new AxeItem(ModToolMaterials.ZENITHIUM, 6, -3f, new QuiltItemSettings().fireproof());
		public static final Item ZENITHIUM_SHOVEL = new ShovelItem(ModToolMaterials.ZENITHIUM, 1.5f, -3f, new QuiltItemSettings().fireproof());
		public static final Item ZENITHIUM_HOE = new HoeItem(ModToolMaterials.ZENITHIUM, 0, -3f, new QuiltItemSettings().fireproof());


	/*public static final Item LASER_TASER = registerItem("laser_taser", new GunItem(new QuiltItemSettings().maxDamage(5), Gunclasses.PISTOL,
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
		1, 3f, 15.0f, 5.0f, 0.075f, 3, 90, 48, 12, 3, Color.decode("11184810")));*/

		public static final Item DISTANCE_TRACKER = new DistanceTrackerItem(new QuiltItemSettings().maxCount(1));

		public static final Item PLASMA_CELL = new Item(new QuiltItemSettings());
		public static final Item PAINT_PACK = new PaintPackItem(new QuiltItemSettings());
		public static final Item PHOTONIC_LENS = new PhotonicLensItem(new QuiltItemSettings().maxCount(1));
		public static final Item COUNTERFORCE_DIFFUSER = new PhaserAttachmentItem(new QuiltItemSettings().maxCount(1),
			1, -2, 0, 0, -3.0f, 2.0f, 0, 0, false, false);
		public static final Item PHASE_ASSIMILATOR = new PhaserAttachmentItem(new QuiltItemSettings().maxCount(1),
			-2, 4, 0, 0, 2.0f, -3.0f, 2, 0, false, false);
		public static final Item AUXILIARY_PLASMA_CHAMBER = new PhaserAttachmentItem(new QuiltItemSettings().maxCount(1),
			0, 0, -1, -2, 0, 0, 0, 2, false, false);
		public static final Item ADVANCED_BREECH_MECHANISM = new PhaserAttachmentItem(new QuiltItemSettings().maxCount(1),
			0, 0, -4, -10, 0, 0, 10, 0, false, false);
		public static final Item SMOKE_CAPSULE = new PhaserAttachmentItem(new QuiltItemSettings().maxCount(1),
			0, 0, 0, 0, 0, 0, 0, 0, false, false,
			new StatusEffectInstance(StatusEffects.BLINDNESS, 40));
		public static final Item POISON_CAPSULE = new PhaserAttachmentItem(new QuiltItemSettings().maxCount(1),
			0, 0, 0, 0, 0, 0, 0, 0, false, false,
			new StatusEffectInstance(StatusEffects.POISON, 40));
		public static final Item WITHER_CAPSULE = new PhaserAttachmentItem(new QuiltItemSettings().maxCount(1),
			0, 0, 0, 0, 0, 0, 0, 0, false, false,
			new StatusEffectInstance(StatusEffects.WITHER, 40, 1));
		public static final Item REGENERATION_CAPSULE =  new PhaserAttachmentItem(new QuiltItemSettings().maxCount(1),
			0, 0, 0, 0, 0, 0, 0, 0, false, false,
			new StatusEffectInstance(StatusEffects.REGENERATION, 40, 1));

		public static final Item SCRAP_METAL_PHASER = new PhaserItem(new QuiltItemSettings().maxCount(1), 3, 1, 10, 50, 0.01f, 4.0f, 5, 60, 4);
		public static final Item INDUSTRIAL_PHASER = new PhaserItem(new QuiltItemSettings().maxCount(1), 4, 3, 20, 100, 0.03f, 12.0f, 6, 7, 4);
		public static final Item STARSTEEL_PHASER = new PhaserItem(new QuiltItemSettings().maxCount(1), 5, 1, 10, 50, 0.025f, 2.0f, 7, 60, 8);
		public static final Item NUCLEAR_PHASER = new PhaserItem(new QuiltItemSettings().maxCount(1), 7, 1, 10, 50, 0.025f, 2.0f, 9, 60, 8);
		public static final Item NANOTECH_PHASER = new PhaserItem(new QuiltItemSettings().maxCount(1), 9, 1, 10, 50, 0.035f, 1.0f, 12, 60, 12);
		public static final Item ZENITHIUM_PHASER = new PhaserItem(new QuiltItemSettings().maxCount(1), 9, 1, 10, 50, 0.04f, 0.0f, 16, 60, 16);
		public static final Item VILE_SPITTER = new GunItem(new QuiltItemSettings().maxDamage(8), Gunclasses.VILE_SPITTER,
			1, 2f, 4.0f, 2.0f, 0.035f, 11, 60, 48, 8, 3, TextUtil.FLESH_PUS,
			new StatusEffectInstance(ModEffects.INFESTED, 20));

		public static final Item HARD_LIGHT_PROJECTOR = new HardLightProjectorItem(ModBlocks.HARD_LIGHT, new QuiltItemSettings().maxDamage(129));
		public static final Item CAUTION_HARD_LIGHT_PROJECTOR = new HardLightProjectorItem(ModBlocks.CAUTION_HARD_LIGHT, new QuiltItemSettings().maxDamage(129));
		public static final Item SENTINEL_HARD_LIGHT_PROJECTOR = new HardLightProjectorItem(ModBlocks.SENTINEL_HARD_LIGHT, new QuiltItemSettings().maxDamage(129));
		public static final Item NUCLEAR_ROCKET = new NuclearRocketItem(new QuiltItemSettings().maxDamage(93));

		public static final Item EMPTY_CAN = new Item(new QuiltItemSettings());
		public static final Item BEETROOT_SOUP_CAN = new CannedItem(new QuiltItemSettings().food(new FoodComponent.Builder().snack().hunger(3).saturationModifier(0.6f).build()));
		public static final Item MUSHROOM_STEW_CAN = new CannedItem(new QuiltItemSettings().food(new FoodComponent.Builder().snack().hunger(3).saturationModifier(0.6f).build()));
		public static final Item RABBIT_STEW_CAN = new CannedItem(new QuiltItemSettings().food(new FoodComponent.Builder().snack().hunger(5).saturationModifier(0.6f).build()));
		public static final Item MILK_CAN = new CannedItem(new QuiltItemSettings().food(new FoodComponent.Builder().snack().hunger(2).saturationModifier(0.3f).build()));
		public static final Item COLA_ORANGE = new CannedItem(new QuiltItemSettings().food(new FoodComponent.Builder().snack().hunger(2).saturationModifier(0.3f).build()));
		public static final Item COLA_GREEN = new CannedItem(new QuiltItemSettings().food(new FoodComponent.Builder().snack().hunger(2).saturationModifier(0.3f).build()));
		public static final Item COLA_CYAN = new CannedItem(new QuiltItemSettings().food(new FoodComponent.Builder().snack().hunger(2).saturationModifier(0.3f).build()));

		public static final Item MUSIC_DISC_ASSASSINATION_UPLOAD = new MusicDiscItem(7, ModSounds.ASSASSINATION_UPLOAD, new QuiltItemSettings().maxCount(1).rarity(Rarity.RARE), 190);
		public static final Item MUSIC_DISC_ODE_TO_TRANQUILITY = new MusicDiscItem(7, ModSounds.ODE_TO_TRANQUILITY, new QuiltItemSettings().maxCount(1).rarity(Rarity.RARE), 80);
		public static final Item MUSIC_DISC_LAPSE_IN_JUDGEMENT = new MusicDiscItem(7, ModSounds.LAPSE_IN_JUDGEMENT, new QuiltItemSettings().maxCount(1).rarity(Rarity.RARE), 142);
		public static final Item MUSIC_DISC_RECITAL = new MusicDiscItem(7, ModSounds.RECITAL, new QuiltItemSettings().maxCount(1).rarity(Rarity.RARE), 114);
	}

	@RegistryNamespace("trevorssentinels")
	public static class Magic implements ItemRegistryContainer {
		public static final Item ENCHANTED_LEAF = new Item(new QuiltItemSettings());
		public static final Item DRYADIC_HELMET = new ArmorItem(ModArmorMaterials.DRYADIC, ArmorItem.ArmorSlot.HELMET, new QuiltItemSettings());
		public static final Item DRYADIC_CHESTPLATE = new ArmorItem(ModArmorMaterials.DRYADIC, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings());
		public static final Item DRYADIC_LEGGINGS = new ArmorItem(ModArmorMaterials.DRYADIC, ArmorItem.ArmorSlot.LEGGINGS, new QuiltItemSettings());
		public static final Item DRYADIC_BOOTS = new ArmorItem(ModArmorMaterials.DRYADIC, ArmorItem.ArmorSlot.BOOTS, new QuiltItemSettings());
		public static final Item DRYADIC_SWORD = new SwordItem(ModToolMaterials.DRYADIC, 3, -2.4f, new QuiltItemSettings());
		public static final Item DRYADIC_DAGGER = new DaggerItem(ModToolMaterials.DRYADIC, 1, 0, 0.85f, new QuiltItemSettings());

		public static final Item ROSE_GOLD_INGOT = new Item(new QuiltItemSettings());
		public static final Item ROSE_GOLD_HELMET = new ArmorItem(ModArmorMaterials.ROSE_GOLD, ArmorItem.ArmorSlot.HELMET, new QuiltItemSettings());
		public static final Item ROSE_GOLD_CHESTPLATE = new ArmorItem(ModArmorMaterials.ROSE_GOLD, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings());
		public static final Item ROSE_GOLD_LEGGINGS = new ArmorItem(ModArmorMaterials.ROSE_GOLD, ArmorItem.ArmorSlot.LEGGINGS, new QuiltItemSettings());
		public static final Item ROSE_GOLD_BOOTS = new ArmorItem(ModArmorMaterials.ROSE_GOLD, ArmorItem.ArmorSlot.BOOTS, new QuiltItemSettings());
		public static final Item ROSE_GOLD_SWORD = new SwordItem(ModToolMaterials.ROSE_GOLD, 3, -2.4f, new QuiltItemSettings());
		public static final Item ROSE_GOLD_DAGGER = new DaggerItem(ModToolMaterials.ROSE_GOLD, 1, 0, 0.85f, new QuiltItemSettings());
		public static final Item ROSE_GOLD_PICKAXE = new PickaxeItem(ModToolMaterials.ROSE_GOLD, 1, -2.8f, new QuiltItemSettings());
		public static final Item ROSE_GOLD_BATTLEAXE = new AxeItem(ModToolMaterials.ROSE_GOLD, 3, -3f, new QuiltItemSettings());
		public static final Item ROSE_GOLD_SHOVEL = new ShovelItem(ModToolMaterials.ROSE_GOLD, 1.5f, -3f, new QuiltItemSettings());
		public static final Item ROSE_GOLD_SICKLE = new HoeItem(ModToolMaterials.ROSE_GOLD, 0, -3f, new QuiltItemSettings());

		public static final Item DRUIDIC_GEM = new Item(new QuiltItemSettings());
		public static final Item DRUIDIC_HELMET = new ArmorItem(ModArmorMaterials.DRUIDIC, ArmorItem.ArmorSlot.HELMET, new QuiltItemSettings());
		public static final Item DRUIDIC_CHESTPLATE = new ArmorItem(ModArmorMaterials.DRUIDIC, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings());
		public static final Item DRUIDIC_LEGGINGS = new ArmorItem(ModArmorMaterials.DRUIDIC, ArmorItem.ArmorSlot.LEGGINGS, new QuiltItemSettings());
		public static final Item DRUIDIC_BOOTS = new ArmorItem(ModArmorMaterials.DRUIDIC, ArmorItem.ArmorSlot.BOOTS, new QuiltItemSettings());
		public static final Item DRUIDIC_SWORD = new SwordItem(ModToolMaterials.DRUIDIC, 3, -2.4f, new QuiltItemSettings());
		public static final Item DRUIDIC_DAGGER = new DaggerItem(ModToolMaterials.DRUIDIC, 1, 0, 0.85f, new QuiltItemSettings());
		public static final Item DRUIDIC_BOW = new BowItem(new QuiltItemSettings());

		public static final Item IMPERIAL_ALLOY_INGOT = new Item(new QuiltItemSettings());
		public static final Item IMPERIAL_HELMET = new ArmorItem(ModArmorMaterials.IMPERIAL, ArmorItem.ArmorSlot.HELMET, new QuiltItemSettings());
		public static final Item IMPERIAL_CHESTPLATE = new ArmorItem(ModArmorMaterials.IMPERIAL, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings());
		public static final Item IMPERIAL_LEGGINGS = new ArmorItem(ModArmorMaterials.IMPERIAL, ArmorItem.ArmorSlot.LEGGINGS, new QuiltItemSettings());
		public static final Item IMPERIAL_BOOTS = new ArmorItem(ModArmorMaterials.IMPERIAL, ArmorItem.ArmorSlot.BOOTS, new QuiltItemSettings());
		public static final Item IMPERIAL_SWORD = new SwordItem(ModToolMaterials.IMPERIAL_ALLOY, 3, -2.4f, new QuiltItemSettings());
		public static final Item IMPERIAL_GLADIUS = new DaggerItem(ModToolMaterials.IMPERIAL_ALLOY, 4, 2f, 0.35f, new QuiltItemSettings());
		public static final Item IMPERIAL_PICKAXE = new PickaxeItem(ModToolMaterials.IMPERIAL_ALLOY, 0,0f, new QuiltItemSettings());
		public static final Item IMPERIAL_BATTLEAXE = new AxeItem(ModToolMaterials.IMPERIAL_ALLOY, 3, -2.8f, new QuiltItemSettings());
		public static final Item IMPERIAL_SHOVEL = new ShovelItem(ModToolMaterials.IMPERIAL_ALLOY, 1.5f, -3f, new QuiltItemSettings());
		public static final Item IMPERIAL_SICKLE = new HoeItem(ModToolMaterials.IMPERIAL_ALLOY, 0, -3f, new QuiltItemSettings());

		public static final Item UNHOLY_SHARDS = new Item(new QuiltItemSettings().fireproof());
		public static final Item UNHOLY_INGOT = new Item(new QuiltItemSettings().fireproof());
		public static final Item UNHOLY_HELMET = new ArmorItem(ModArmorMaterials.UNHOLY, ArmorItem.ArmorSlot.HELMET, new QuiltItemSettings().fireproof());
		public static final Item UNHOLY_CHESTPLATE = new ArmorItem(ModArmorMaterials.UNHOLY, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings().fireproof());
		public static final Item UNHOLY_LEGGINGS = new ArmorItem(ModArmorMaterials.UNHOLY, ArmorItem.ArmorSlot.LEGGINGS, new QuiltItemSettings().fireproof());
		public static final Item UNHOLY_BOOTS = new ArmorItem(ModArmorMaterials.UNHOLY, ArmorItem.ArmorSlot.BOOTS, new QuiltItemSettings().fireproof());
		public static final Item UNHOLY_SWORD = new SwordItem(ModToolMaterials.UNHOLY, 3, -2.4f, new QuiltItemSettings().fireproof());
		public static final Item UNHOLY_DAGGER = new DaggerItem(ModToolMaterials.UNHOLY, 6, 2.5f, 0.15f, new QuiltItemSettings().fireproof());
		public static final Item UNHOLY_PICKAXE = new PickaxeItem(ModToolMaterials.UNHOLY, 0,0f, new QuiltItemSettings().fireproof());
		public static final Item UNHOLY_BATTLEAXE = new AxeItem(ModToolMaterials.UNHOLY, 3, -2.8f, new QuiltItemSettings().fireproof());
		public static final Item UNHOLY_SHOVEL = new ShovelItem(ModToolMaterials.UNHOLY, 1.5f, -3f, new QuiltItemSettings().fireproof());
		public static final Item UNHOLY_SICKLE = new HoeItem(ModToolMaterials.UNHOLY, 0, -3f, new QuiltItemSettings().fireproof());

		public static final Item ARMA_DEI_HELMET = new ArmorItem(ModArmorMaterials.ARMA_DEI, ArmorItem.ArmorSlot.HELMET, new QuiltItemSettings().fireproof());
		public static final Item ARMA_DEI_CHESTPLATE = new ArmorItem(ModArmorMaterials.ARMA_DEI, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings().fireproof());
		public static final Item ARMA_DEI_LEGGINGS = new ArmorItem(ModArmorMaterials.ARMA_DEI, ArmorItem.ArmorSlot.LEGGINGS, new QuiltItemSettings().fireproof());
		public static final Item ARMA_DEI_BOOTS = new ArmorItem(ModArmorMaterials.ARMA_DEI, ArmorItem.ArmorSlot.BOOTS, new QuiltItemSettings().fireproof());
		public static final Item ARMA_DEI_SWORD = new SwordItem(ModToolMaterials.ARMA_DEI, 3, -2.4f, new QuiltItemSettings().fireproof());
		public static final Item ARMA_DEI_DAGGER = new DaggerItem(ModToolMaterials.ARMA_DEI, 6, 2.5f, 0.15f, new QuiltItemSettings().fireproof());
		public static final Item ARMA_DEI_PICKAXE = new PickaxeItem(ModToolMaterials.ARMA_DEI, 0,0f, new QuiltItemSettings().fireproof());
		public static final Item ARMA_DEI_BATTLEAXE = new AxeItem(ModToolMaterials.ARMA_DEI, 3, -2.8f, new QuiltItemSettings().fireproof());
		public static final Item ARMA_DEI_SHOVEL = new ShovelItem(ModToolMaterials.ARMA_DEI, 1.5f, -3f, new QuiltItemSettings().fireproof());
		public static final Item ARMA_DEI_SICKLE = new HoeItem(ModToolMaterials.ARMA_DEI, 0, -3f, new QuiltItemSettings().fireproof());

		public static final Item THANATU_HELMET = new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.ArmorSlot.HELMET, new QuiltItemSettings());
		public static final Item THANATU_CHESTPLATE = new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings());
		public static final Item THANATU_LEGGINGS = new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings());
		public static final Item THANATU_BOOTS = new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings());


		public static final Item COPPER_GLADIUS = new NewDaggerItem(ModToolMaterials.COPPER, 2, 2f, new QuiltItemSettings());
		public static final Item ICICLE_DAGGER = new NewDaggerItem(ModToolMaterials.COPPER, 1, 2f, new QuiltItemSettings(),
			new StatusEffectInstance(StatusEffects.SLOWNESS, 20, 1));

		public static final Item DEMONIC_CORE = new PortkeyItem(new QuiltItemSettings().maxDamage(3));

		public static final Item RESISTANCE_ITEM = new InfiniteEffectItem(new QuiltItemSettings().maxCount(1),
			new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 0, false, false));

		public static final Item FIRE_RESISTANCE_ITEM = new InfiniteEffectItem(new QuiltItemSettings().maxCount(1).fireproof(),
			new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 1, false, false),
			new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200, 0, false, false));

		public static final Item JUMP_BOOST_ITEM = new InfiniteEffectItem(new QuiltItemSettings().maxCount(1),
			new StatusEffectInstance(StatusEffects.JUMP_BOOST, 200, 0, false, false));

		public static final Item STRENGTH_ITEM = new InfiniteEffectItem(new QuiltItemSettings().maxCount(1),
			new StatusEffectInstance(StatusEffects.STRENGTH, 200, 0, false, false));

		public static final Item WEAKNESS_ITEM = new InfiniteEffectItem(new QuiltItemSettings().maxCount(1),
			new StatusEffectInstance(StatusEffects.WEAKNESS, 200, 0, false, false));

		public static final Item REGENERATION_ITEM = new InfiniteEffectItem(new QuiltItemSettings().maxCount(1),
			new StatusEffectInstance(StatusEffects.REGENERATION, 200, 0, false, false));

		public static final Item WATER_BREATHING_ITEM = new InfiniteEffectItem(new QuiltItemSettings().maxCount(1),
			new StatusEffectInstance(StatusEffects.WATER_BREATHING, 200, 0, false, false));

		public static final Item INVISIBILITY_ITEM = new InfiniteEffectItem(new QuiltItemSettings().maxCount(1),
			new StatusEffectInstance(StatusEffects.INVISIBILITY, 200, 0, false, false));

		public static final Item DOLPHINS_GRACE_ITEM = new InfiniteEffectItem(new QuiltItemSettings().maxCount(1),
			new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 200, 0, false, false));

		public static final Item CONDUIT_POWER_ITEM = new InfiniteEffectItem(new QuiltItemSettings().maxCount(1),
			new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 200, 0, false, false));

		public static final Item NIGHT_VISION_ITEM = new InfiniteEffectItem(new QuiltItemSettings().maxCount(1),
			new StatusEffectInstance(StatusEffects.WEAKNESS, 200, 0, false, false));

		public static final Item HERO_OF_THE_VILLAGE_ITEM = new InfiniteEffectItem(new QuiltItemSettings().maxCount(1),
			new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 200, 0, false, false));

		public static final Item PALADINS_BADGE = new InfiniteEffectItem(new QuiltItemSettings().maxCount(1),
			new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 0, false, false),
			new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200, 0, false, false),
			new StatusEffectInstance(StatusEffects.STRENGTH, 200, 0, false, false));

		public static final Item CYBERNETIC_STOMACH = new InfiniteEffectItem(new QuiltItemSettings().maxCount(1),
			new StatusEffectInstance(ModEffects.WELL_FED, 200, 0, false, false));

		public static final Item ONE_PENCE = new InfiniteEffectItem(new QuiltItemSettings().maxCount(1),
			new StatusEffectInstance(StatusEffects.LUCK, 200, 9, false, false));

		public static final Item EYE_OF_RUIN = new Item(new QuiltItemSettings());
		public static final Item DUBIOUS_BACON = new Item(new QuiltItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.4f)
			.statusEffect(new StatusEffectInstance(ModEffects.INFESTED, 200, 0), 0.1f).build()));

		public static final Item PALE_SIGN = new SignItem(new QuiltItemSettings().maxCount(16), ModBlocks.PALE_SIGN, ModBlocks.PALE_WALL_SIGN);
		public static final Item PALE_HANGING_SIGN = new HangingSignItem(ModBlocks.PALE_HANGING_SIGN, ModBlocks.PALE_WALL_HANGING_SIGN, new QuiltItemSettings().maxCount(16));
		public static final Item PALE_BOAT = new BoatItem(false, BoatEntity.Variant.BIRCH, new Item.Settings().maxCount(1));
		public static final Item PALE_CHEST_BOAT = new BoatItem(true, BoatEntity.Variant.BIRCH, new Item.Settings().maxCount(1));

		public static final Item CHARRED_SIGN = new SignItem(new QuiltItemSettings().maxCount(16), ModBlocks.CHARRED_SIGN, ModBlocks.CHARRED_WALL_SIGN);
		public static final Item CHARRED_HANGING_SIGN = new HangingSignItem(ModBlocks.CHARRED_HANGING_SIGN, ModBlocks.CHARRED_WALL_HANGING_SIGN, new QuiltItemSettings().maxCount(16));
		public static final Item CHARRED_BOAT = new BoatItem(false, BoatEntity.Variant.OAK, new Item.Settings().maxCount(1));
		public static final Item CHARRED_CHEST_BOAT = new BoatItem(true, BoatEntity.Variant.OAK, new Item.Settings().maxCount(1));

		public static final Item MIDAS_SIGN = new SignItem(new QuiltItemSettings().maxCount(16), ModBlocks.MIDAS_SIGN, ModBlocks.MIDAS_WALL_SIGN);
		public static final Item MIDAS_HANGING_SIGN = new HangingSignItem(ModBlocks.MIDAS_HANGING_SIGN, ModBlocks.MIDAS_WALL_HANGING_SIGN, new QuiltItemSettings().maxCount(16));
		public static final Item MIDAS_BOAT =  new BoatItem(false, BoatEntity.Variant.DARK_OAK, new Item.Settings().maxCount(1));
		public static final Item MIDAS_CHEST_BOAT = new BoatItem(true, BoatEntity.Variant.DARK_OAK, new Item.Settings().maxCount(1));

		public static final Item VIRIDIAN_SIGN = new SignItem(new QuiltItemSettings().maxCount(16), ModBlocks.VIRIDIAN_SIGN, ModBlocks.VIRIDIAN_WALL_SIGN);
		public static final Item VIRIDIAN_HANGING_SIGN = new HangingSignItem(ModBlocks.VIRIDIAN_HANGING_SIGN, ModBlocks.VIRIDIAN_WALL_HANGING_SIGN, new QuiltItemSettings().maxCount(16));
		public static final Item VIRIDIAN_BOAT = new BoatItem(false, BoatEntity.Variant.JUNGLE, new Item.Settings().maxCount(1));
		public static final Item VIRIDIAN_CHEST_BOAT = new BoatItem(true, BoatEntity.Variant.JUNGLE, new Item.Settings().maxCount(1));

		public static final Item CERULII_SIGN = new SignItem(new QuiltItemSettings().maxCount(16), ModBlocks.CERULII_SIGN, ModBlocks.CERULII_WALL_SIGN);
		public static final Item CERULII_HANGING_SIGN = new HangingSignItem(ModBlocks.CERULII_HANGING_SIGN, ModBlocks.CERULII_WALL_HANGING_SIGN, new QuiltItemSettings().maxCount(16));
		public static final Item CERULII_BOAT = new BoatItem(false, BoatEntity.Variant.JUNGLE, new Item.Settings().maxCount(1));
		public static final Item CERULII_CHEST_BOAT = new BoatItem(true, BoatEntity.Variant.JUNGLE, new Item.Settings().maxCount(1));
	}

	@RegistryNamespace("trevorssentinels")
	public static class Beta implements ItemRegistryContainer {
		//public static final Item JUMP_DRIVE = new JumpItemv2(ModArmorMaterials.IMPERIAL, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings().maxDamage(100)));
		//public static final Item JETPACK = new JetpackItem(ModArmorMaterials.NUCLEAR, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings().maxDamage(100)));

		public static final Item PAPPYM_BLADE = new PappyMSwordItem(ModToolMaterials.ZENITHIUM,0,-2.5f, new QuiltItemSettings().fireproof().maxDamage(1200));
		public static final Item PAPPYD_BLADE = new PappyDSwordItem(ModToolMaterials.ZENITHIUM,0,-2.5f, new QuiltItemSettings().fireproof());
		public static final Item THANATU_BLADE = new ThanatuBladeItem(ModToolMaterials.ZENITHIUM, 3,-2.8f, new QuiltItemSettings().fireproof());
		public static final Item SKYLAR_BLADE = new SkylarBladeItem(ModToolMaterials.ZENITHIUM,0,-2.4f, new QuiltItemSettings().fireproof());
		public static final Item LILITH_BLADE = new LilithBladeItem(ModToolMaterials.ZENITHIUM,-5,-2.4f, new QuiltItemSettings().fireproof());
		public static final Item KINGS_BLADE = new KingsBladeItem(ModToolMaterials.ZENITHIUM,3,-2.4f, new QuiltItemSettings().fireproof());

		public static final Item BLACKSMITHS_WELDING_MASK = new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.ArmorSlot.HELMET, new QuiltItemSettings());
		public static final Item MAD_SCIENTISTS_LAB_COAT = new ArmorItem(ModArmorMaterials.ZENITHIUM, ArmorItem.ArmorSlot.CHESTPLATE, new QuiltItemSettings());
	}
}
