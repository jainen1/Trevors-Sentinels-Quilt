package net.trevorskullcrafter.trevorssentinels.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.effect.ModEffects;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import net.trevorskullcrafter.trevorssentinels.item.*;
import net.trevorskullcrafter.trevorssentinels.sound.ModSounds;
import net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain.MOD_ID;
import static net.trevorskullcrafter.trevorssentinels.util.LangGenUtils.*;
import static net.trevorskullcrafter.trevorssentinels.util.TextUtil.*;

public class EnglishLangGenerator extends FabricLanguageProvider {
    public EnglishLangGenerator(FabricDataOutput dataOutput) { super(dataOutput, "en_us"); }

    @Override public void generateTranslations(TranslationBuilder translationBuilder) {
		//Magic Equipment
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, VIRIDIAN), ItemTranslation.of(TSItems.Magic.DRYADIC_HELMET),
			ItemTranslation.of(TSItems.Magic.DRYADIC_CHESTPLATE), ItemTranslation.of(TSItems.Magic.DRYADIC_LEGGINGS), ItemTranslation.of(TSItems.Magic.DRYADIC_BOOTS),
			ItemTranslation.of(TSItems.Magic.DRYADIC_SWORD), ItemTranslation.of(TSItems.Magic.DRYADIC_DAGGER), ItemTranslation.of(TSItems.Magic.ENCHANTED_LEAF));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, ROSE_GOLD), ItemTranslation.of(TSItems.Magic.ROSE_GOLD_INGOT),
			ItemTranslation.of(ModBlocks.ROSE_GOLD_BLOCK, "Block of Rose Gold"), ItemTranslation.of(TSItems.Magic.ROSE_GOLD_HELMET),
			ItemTranslation.of(TSItems.Magic.ROSE_GOLD_CHESTPLATE, "Rose Gold Cuirass"), ItemTranslation.of(TSItems.Magic.ROSE_GOLD_LEGGINGS),
			ItemTranslation.of(TSItems.Magic.ROSE_GOLD_BOOTS), ItemTranslation.of(TSItems.Magic.ROSE_GOLD_SWORD), ItemTranslation.of(TSItems.Magic.ROSE_GOLD_DAGGER),
			ItemTranslation.of(TSItems.Magic.ROSE_GOLD_PICKAXE), ItemTranslation.of(TSItems.Magic.ROSE_GOLD_BATTLEAXE), ItemTranslation.of(TSItems.Magic.ROSE_GOLD_SHOVEL),
			ItemTranslation.of(TSItems.Magic.ROSE_GOLD_SICKLE, null, "Functions as a Hoe."));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, VIRIDIAN), ItemTranslation.of(TSItems.Magic.DRUIDIC_HELMET),
			ItemTranslation.of(TSItems.Magic.DRUIDIC_CHESTPLATE), ItemTranslation.of(TSItems.Magic.DRUIDIC_LEGGINGS), ItemTranslation.of(TSItems.Magic.DRUIDIC_BOOTS),
			ItemTranslation.of(TSItems.Magic.DRUIDIC_SWORD), ItemTranslation.of(TSItems.Magic.DRUIDIC_DAGGER), ItemTranslation.of(TSItems.Magic.DRUIDIC_BOW),
			ItemTranslation.of(TSItems.Magic.DRUIDIC_GEM));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, IMPERIAL_ALLOY), ItemTranslation.of(TSItems.Magic.IMPERIAL_ALLOY_INGOT),
			ItemTranslation.of(ModBlocks.IMPERIAL_ALLOY_BLOCK, "Block of Imperial Alloy"), ItemTranslation.of(TSItems.Magic.IMPERIAL_HELMET),
			ItemTranslation.of(TSItems.Magic.IMPERIAL_CHESTPLATE), ItemTranslation.of(TSItems.Magic.IMPERIAL_LEGGINGS), ItemTranslation.of(TSItems.Magic.IMPERIAL_BOOTS),
			ItemTranslation.of(TSItems.Magic.IMPERIAL_SWORD), ItemTranslation.of(TSItems.Magic.IMPERIAL_GLADIUS), ItemTranslation.of(TSItems.Magic.IMPERIAL_PICKAXE),
			ItemTranslation.of(TSItems.Magic.IMPERIAL_BATTLEAXE), ItemTranslation.of(TSItems.Magic.IMPERIAL_SHOVEL),
			ItemTranslation.of(TSItems.Magic.IMPERIAL_SICKLE, null, "Functions as a Hoe."));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, LIGHT_PURPLE),
			ItemTranslation.of(TSItems.Magic.THANATU_HELMET, "Macabre Skull", "The skull of the demon king."),
			ItemTranslation.of(TSItems.Magic.THANATU_CHESTPLATE, "Macabre Shoulderpads"), ItemTranslation.of(TSItems.Magic.THANATU_LEGGINGS, "Macabre Loincloth"),
			ItemTranslation.of(TSItems.Magic.THANATU_BOOTS, "Macabre Sandals"));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, LIGHT_PURPLE), ItemTranslation.of(TSItems.Magic.UNHOLY_SHARDS),
			ItemTranslation.of(TSItems.Magic.UNHOLY_INGOT, null, "Reflects only the light in darkness."),
			ItemTranslation.of(ModBlocks.UNHOLY_BLOCK, "Block of Unholy Alloy"), ItemTranslation.of(TSItems.Magic.UNHOLY_HELMET),
			ItemTranslation.of(TSItems.Magic.UNHOLY_CHESTPLATE, "Unholy Cuirass"), ItemTranslation.of(TSItems.Magic.UNHOLY_LEGGINGS),
			ItemTranslation.of(TSItems.Magic.UNHOLY_BOOTS), ItemTranslation.of(TSItems.Magic.UNHOLY_SWORD), ItemTranslation.of(TSItems.Magic.UNHOLY_DAGGER),
			ItemTranslation.of(TSItems.Magic.UNHOLY_PICKAXE), ItemTranslation.of(TSItems.Magic.UNHOLY_BATTLEAXE), ItemTranslation.of(TSItems.Magic.UNHOLY_SHOVEL),
			ItemTranslation.of(TSItems.Magic.UNHOLY_SICKLE, null, "Functions as a Hoe."));
		generateItems(translationBuilder, ItemTranslation.of(TSItems.Magic.ARMA_DEI_HELMET), ItemTranslation.of(TSItems.Magic.ARMA_DEI_CHESTPLATE),
			ItemTranslation.of(TSItems.Magic.ARMA_DEI_LEGGINGS), ItemTranslation.of(TSItems.Magic.ARMA_DEI_BOOTS), ItemTranslation.of(TSItems.Magic.ARMA_DEI_SWORD),
			ItemTranslation.of(TSItems.Magic.ARMA_DEI_DAGGER), ItemTranslation.of(TSItems.Magic.ARMA_DEI_PICKAXE), ItemTranslation.of(TSItems.Magic.ARMA_DEI_BATTLEAXE),
			ItemTranslation.of(TSItems.Magic.ARMA_DEI_SHOVEL), ItemTranslation.of(TSItems.Magic.ARMA_DEI_SICKLE, null, "Functions as a Hoe."));

		generateItems(translationBuilder, ItemTranslation.of(ModBlocks.WAX_INFUSED_COPPER_BLOCK, "Wax-Infused Block of Copper"));
		generateItems(translationBuilder, ItemTranslation.of(ModBlocks.STARSTEEL_LAMP));
		generateItems(translationBuilder, ItemTranslation.of(ModBlocks.STARSTEEL_FAN));
		generateItems(translationBuilder, ItemTranslation.of(ModBlocks.BATTERY));
		generateItems(translationBuilder, ItemTranslation.of(ModBlocks.FUSEBOX));
		generateItems(translationBuilder, ItemTranslation.of(ModBlocks.FANCY_COMPUTER));
		generateItems(translationBuilder, ItemTranslation.of(ModBlocks.BLACK_AGILITY_BLOCK, "Steel Magno-Repulsion Block", "Watch your step."));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, SENTINEL_CRIMSON_T1), ItemTranslation.of(ModBlocks.BIG_RED_BUTTON),
			ItemTranslation.of(ModBlocks.BIG_RED_PLATE, null, "1500 Megawatt Super Colliding Super Plate"));

		//Tech Equipment
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, SCRAP_METAL), ItemTranslation.of(TSItems.Tech.SCRAP_METAL_SHARD),
			ItemTranslation.of(ModBlocks.SCRAP_METAL_BLOCK), ItemTranslation.of(ModBlocks.CHISELED_SCRAP_METAL_BLOCK), ItemTranslation.of(ModBlocks.SCRAP_METAL_PILLAR),
			ItemTranslation.of(TSItems.Tech.SCRAP_METAL_HELMET),
			ItemTranslation.of(TSItems.Tech.SCRAP_METAL_CHESTPLATE), ItemTranslation.of(TSItems.Tech.SCRAP_METAL_LEGGINGS), ItemTranslation.of(TSItems.Tech.SCRAP_METAL_BOOTS),
			ItemTranslation.of(TSItems.Tech.SCRAP_METAL_SWORD), ItemTranslation.of(TSItems.Tech.SCRAP_METAL_KNIFE), ItemTranslation.of(TSItems.Tech.SCRAP_METAL_DRILL),
			ItemTranslation.of(TSItems.Tech.SCRAP_METAL_CHAINSAW, null, "Right click to launch shards at enemies!"),
			ItemTranslation.of(TSItems.Tech.SCRAP_METAL_SHOVEL), ItemTranslation.of(TSItems.Tech.SCRAP_METAL_HOE), ItemTranslation.of(TSItems.Tech.SCRAP_METAL_PHASER));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, STARSTEEL), ItemTranslation.of(TSItems.Tech.INDUSTRIAL_HELMET),
			ItemTranslation.of(TSItems.Tech.INDUSTRIAL_HARNESS), ItemTranslation.of(TSItems.Tech.INDUSTRIAL_PANTS), ItemTranslation.of(TSItems.Tech.INDUSTRIAL_BOOTS),
			ItemTranslation.of(TSItems.Tech.INDUSTRIAL_CROWBAR, null, "Rise, and... shine."), ItemTranslation.of(TSItems.Tech.INDUSTRIAL_PHASER));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, STARSTEEL), ItemTranslation.of(TSItems.Tech.STARSTEEL_INGOT),
			ItemTranslation.of(ModBlocks.STARSTEEL_BLOCK, "Block of Starsteel"), ItemTranslation.of(ModBlocks.CHISELED_STARSTEEL_BLOCK, "Chiseled Block of Starsteel"),
			ItemTranslation.of(ModBlocks.STAINLESS_STEEL_BLOCK), ItemTranslation.of(ModBlocks.STARSTEEL_LADDER), ItemTranslation.of(TSItems.Tech.STARSTEEL_SIGN),
			ItemTranslation.of(TSItems.Tech.STARSTEEL_HANGING_SIGN), ItemTranslation.of(TSItems.Tech.STARSTEEL_HELMET), ItemTranslation.of(TSItems.Tech.STARSTEEL_CHESTPLATE),
			ItemTranslation.of(TSItems.Tech.STARSTEEL_LEGGINGS), ItemTranslation.of(TSItems.Tech.STARSTEEL_BOOTS), ItemTranslation.of(TSItems.Tech.STARSTEEL_SWORD),
			ItemTranslation.of(TSItems.Tech.STARSTEEL_KNIFE), ItemTranslation.of(TSItems.Tech.STARSTEEL_DRILL), ItemTranslation.of(TSItems.Tech.STARSTEEL_AXE),
			ItemTranslation.of(TSItems.Tech.STARSTEEL_SHOVEL), ItemTranslation.of(TSItems.Tech.STARSTEEL_HOE), ItemTranslation.of(TSItems.Tech.STARSTEEL_PHASER));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, NUCLEAR), ItemTranslation.of(TSItems.Tech.NUCLEAR_INGOT),
			ItemTranslation.of(ModBlocks.NUCLEAR_ORE), ItemTranslation.of(ModBlocks.NUCLEAR_BLOCK, "Nuclear Storage Block"), ItemTranslation.of(TSItems.Tech.NUCLEAR_ROCKET),
			ItemTranslation.of(TSItems.Tech.NUCLEAR_HELMET), ItemTranslation.of(TSItems.Tech.NUCLEAR_CHESTPLATE), ItemTranslation.of(TSItems.Tech.NUCLEAR_LEGGINGS),
			ItemTranslation.of(TSItems.Tech.NUCLEAR_BOOTS), ItemTranslation.of(TSItems.Tech.NUCLEAR_SWORD, null, "Irradiates enemies."),
			ItemTranslation.of(TSItems.Tech.NUCLEAR_VIBROKNIFE, null, "Irradiates enemies."), ItemTranslation.of(TSItems.Tech.NUCLEAR_DRILL),
			ItemTranslation.of(TSItems.Tech.NUCLEAR_AXE), ItemTranslation.of(TSItems.Tech.NUCLEAR_SHOVEL), ItemTranslation.of(TSItems.Tech.NUCLEAR_HOE),
			ItemTranslation.of(TSItems.Tech.NUCLEAR_PHASER));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, BLOOD_RED), ItemTranslation.of(TSItems.Tech.NANOTECH_CAPSULE),
			ItemTranslation.of(ModBlocks.NANOTECH_BLOCK, "Nanotech Storage Block"), ItemTranslation.of(TSItems.Tech.NANOTECH_HELMET),
			ItemTranslation.of(TSItems.Tech.NANOTECH_CHESTPLATE), ItemTranslation.of(TSItems.Tech.NANOTECH_LEGGINGS), ItemTranslation.of(TSItems.Tech.NANOTECH_BOOTS),
			ItemTranslation.of(TSItems.Tech.NANOTECH_SWORD, null, "\"I've even forgotten my name...\""),
			ItemTranslation.of(TSItems.Tech.NANOTECH_VIBROKNIFE), ItemTranslation.of(TSItems.Tech.NANOTECH_DRILL), ItemTranslation.of(TSItems.Tech.NANOTECH_AXE),
			ItemTranslation.of(TSItems.Tech.NANOTECH_SHOVEL), ItemTranslation.of(TSItems.Tech.NANOTECH_HOE), ItemTranslation.of(TSItems.Tech.NANOTECH_PHASER));

		//Transcendent Equipment
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, DARK_GREEN),
			ItemTranslation.of(TSItems.Tech.ZENITHIUM_CLUSTER, null, "The concentrated essence of a galaxy."),
			ItemTranslation.of(TSItems.Tech.ZENITHIUM_HELMET), ItemTranslation.of(TSItems.Tech.ZENITHIUM_CHESTPLATE), ItemTranslation.of(TSItems.Tech.ZENITHIUM_LEGGINGS),
			ItemTranslation.of(TSItems.Tech.ZENITHIUM_BOOTS), ItemTranslation.of(TSItems.Tech.ZENITHIUM_SWORD), ItemTranslation.of(TSItems.Tech.ZENITHIUM_DAGGER),
			ItemTranslation.of(TSItems.Tech.ZENITHIUM_PICKAXE), ItemTranslation.of(TSItems.Tech.ZENITHIUM_AXE), ItemTranslation.of(TSItems.Tech.ZENITHIUM_SHOVEL),
			ItemTranslation.of(TSItems.Tech.ZENITHIUM_HOE), ItemTranslation.of(TSItems.Tech.ZENITHIUM_PHASER));

		generateItems(translationBuilder, ItemTranslation.of(TSItems.Magic.COPPER_GLADIUS, null, "An ornamental blade of goblin tradition.", COPPER));
		//Blacksmith's Welding Mask, Mad Scientist's Lab Coat

        generateItems(translationBuilder,
			ItemTranslation.of(TSItems.Beta.PAPPYM_BLADE, "Jade Seraphim", "Passed down through ancient tradition... and now it has found its way to you.", GREEN),
			ItemTranslation.of(TSItems.Beta.PAPPYD_BLADE, "Hell's Flaming Fury", HELLFIRE),
			ItemTranslation.of(TSItems.Beta.THANATU_BLADE, "Harmonious Rapture", LIGHT_PURPLE),
			ItemTranslation.of(TSItems.Beta.SKYLAR_BLADE, "Equitous Retribution", SHINY_GOLD),
			ItemTranslation.of(TSItems.Beta.LILITH_BLADE, "Unwavering Judgement", DUNE_TAN),
			ItemTranslation.of(TSItems.Beta.KINGS_BLADE, "Stainless Resolve", WHITE),
			ItemTranslation.of(ModArmory.SCARA_SHEARS, "SCARA Shears", "A military-grade threat.", DARK_PURPLE),
			ItemTranslation.of(ModArmory.MASTER_SWORD, "The Master's Sword", "From a distant universe...", AQUA));
        generateItems(translationBuilder, ItemTranslation.of(TSItems.Tech.VILE_SPITTER, null, "It's alive!", FLESH_PINK)

			/*ItemTranslation.of(TSItems.Tech.LASER_PISTOL, "NUMA-28 Comet", "\"Fast and portable!\"", STARSTEEL),
			ItemTranslation.of(TSItems.Tech.LASER_TASER, "Enforcer-Standard Taser", "\"Non-lethal.\"", AQUA),
			ItemTranslation.of(TSItems.Tech.LASER_SNIPER_ECHO, "NUMA-52 Echo", "\"They'll never see it coming!\"", DUNE_TAN),
			ItemTranslation.of(TSItems.Tech.LASER_MINIGUN, "UTARI-91 Serenity", "\"Keep the peace!\"", BLUE),
			ItemTranslation.of(TSItems.Tech.LASER_RIFLE, "NUMA-63 Agnostyk", "\"Packs a punch!\"", MOSS),
			ItemTranslation.of(TSItems.Tech.LASER_SHOTGUN, "KHAOS-66 Tremor", "\"Rip and tear!\"", HELLFIRE),
			ItemTranslation.of(TSItems.Tech.LASER_HEALER, "PW49 Firebird", "\"Those who can't do, heal!\"", SHINY_GOLD),
			ItemTranslation.of(TSItems.Tech.LASER_SNIPER, "PW88 Shadow", "\"The assassin's weapon of choice!\"", DARK_PURPLE),
			ItemTranslation.of(TSItems.Tech.LASER_SPREADER, "PW76 Pandemic", "\"Filled with a toxic bioweapon.\"", GREEN),
			ItemTranslation.of(TSItems.Tech.LASER_REVOLVER, "Drunkard's Handcannon", "\"But you have heard of me!\"", null),*/);
		generateItems(translationBuilder,
			ItemTranslation.of(TSItems.Tech.PAINT_PACK),
			ItemTranslation.of(TSItems.Tech.PHOTONIC_LENS),
			ItemTranslation.of(TSItems.Tech.COUNTERFORCE_DIFFUSER),
			ItemTranslation.of(TSItems.Tech.PHASE_ASSIMILATOR),
			ItemTranslation.of(TSItems.Tech.SMOKE_CAPSULE),
			ItemTranslation.of(TSItems.Tech.POISON_CAPSULE),
			ItemTranslation.of(TSItems.Tech.WITHER_CAPSULE),
			ItemTranslation.of(TSItems.Tech.REGENERATION_CAPSULE));
		generateItems(translationBuilder,
			ItemTranslation.of(TSItems.Magic.RESISTANCE_ITEM, "Shield Badge", GRAY),
			ItemTranslation.of(TSItems.Magic.FIRE_RESISTANCE_ITEM, "Flaming Badge", HELLFIRE), //shield badge, fire stuff
			ItemTranslation.of(TSItems.Magic.JUMP_BOOST_ITEM, "Icarus' Gust", NUCLEAR),
			ItemTranslation.of(TSItems.Magic.STRENGTH_ITEM, "Sword Badge", GRAY), //shattered sword, iron ingots?
			ItemTranslation.of(TSItems.Magic.WEAKNESS_ITEM, "Shattered Sword", "A reminder of past failures."),
			ItemTranslation.of(TSItems.Magic.REGENERATION_ITEM, "Ever-Beating Heart"), //leviathan stuff
			ItemTranslation.of(TSItems.Magic.WATER_BREATHING_ITEM, "Abyssal Bubbles"),
			ItemTranslation.of(TSItems.Magic.INVISIBILITY_ITEM, "Vampire's Mirror"),
			ItemTranslation.of(TSItems.Magic.DOLPHINS_GRACE_ITEM, "Foam Dolphin Plush", "Its silky skin makes one feel hydrodynamic.", DOLPHIN),
			ItemTranslation.of(TSItems.Magic.CONDUIT_POWER_ITEM, "Eye of the Sea"),
			ItemTranslation.of(TSItems.Magic.NIGHT_VISION_ITEM, "Feline Eye"),
			ItemTranslation.of(TSItems.Magic.HERO_OF_THE_VILLAGE_ITEM, "Hero's Emerald", "Gifted to heroes of legend.", NUCLEAR),
			ItemTranslation.of(TSItems.Magic.PALADINS_BADGE, null, "The mark of a true warrior of light.", SHINY_GOLD), //flaming badge, sword badge
			ItemTranslation.of(TSItems.Magic.CYBERNETIC_STOMACH, null, SCRAP_METAL),
			ItemTranslation.of(TSItems.Magic.ONE_PENCE, "The One Pence", "Wealth, Fame, Power.", COPPER));

		generateItems(translationBuilder,
			ItemTranslation.of(ModItems.SENTINEL_SPAWN_EGG, "Sentinel Spawn Beacon", "A mindless drone for the hive.", SCRAP_METAL),
			ItemTranslation.of(ModItems.ROOMBA_SPAWN_EGG, "Sentinel Cleaning Droid", "Once a human, now a living sanitizer.", SCRAP_METAL),
			ItemTranslation.of(ModItems.FLORBUS_SPAWN_EGG, "Florbus Spawn Sac"));
		generateItems(translationBuilder, ItemTranslation.of(ModItems.VENDOR_TOKEN, null, VENDOR_TOKEN), ItemTranslation.of(ModItems.LEGENDARY_TOKEN));

		generateMusicDisc(translationBuilder, ItemTranslation.of(TSItems.Tech.MUSIC_DISC_ASSASSINATION_UPLOAD, "Scrapped Cassette"),
			"Kristoffer Kaufmann - Assassination Upload", ModSounds.ASSASSINATION_UPLOAD);
		generateMusicDisc(translationBuilder, ItemTranslation.of(TSItems.Tech.MUSIC_DISC_ODE_TO_TRANQUILITY, "Music Disc"),
			"Kristoffer Kaufmann - Ode to Tranquility", ModSounds.ODE_TO_TRANQUILITY);
		generateMusicDisc(translationBuilder, ItemTranslation.of(TSItems.Tech.MUSIC_DISC_LAPSE_IN_JUDGEMENT, "War-Torn Music Disc"),
			"Kristoffer Kaufmann - Lapse in Judgement", ModSounds.LAPSE_IN_JUDGEMENT);
		generateMusicDisc(translationBuilder, ItemTranslation.of(TSItems.Tech.MUSIC_DISC_RECITAL, "Aged Cassette", "It's in remarkably good condition."),
			"Trevor Skullcrafter - recital", ModSounds.RECITAL);

		//Wood
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, YGGDRASIL), ItemTranslation.of(ModBlocks.PALE_LOG),
			ItemTranslation.of(ModBlocks.PALE_WOOD), ItemTranslation.of(ModBlocks.STRIPPED_PALE_LOG), ItemTranslation.of(ModBlocks.STRIPPED_PALE_WOOD),
			ItemTranslation.of(ModBlocks.PALE_PLANKS), ItemTranslation.of(ModBlocks.PALE_LEAVES), ItemTranslation.of(ModBlocks.PALE_SAPLING),
			ItemTranslation.of(ModBlocks.POTTED_PALE_SAPLING), ItemTranslation.of(ModBlocks.PALE_SLAB), ItemTranslation.of(ModBlocks.PALE_STAIRS),
			ItemTranslation.of(ModBlocks.PALE_FENCE), ItemTranslation.of(ModBlocks.PALE_FENCE_GATE), ItemTranslation.of(ModBlocks.PALE_BUTTON),
			ItemTranslation.of(ModBlocks.PALE_PRESSURE_PLATE), ItemTranslation.of(ModBlocks.PALE_DOOR), ItemTranslation.of(ModBlocks.PALE_TRAPDOOR),
			ItemTranslation.of(ModBlocks.PALE_SIGN), ItemTranslation.of(ModBlocks.PALE_HANGING_SIGN), ItemTranslation.of(TSItems.Magic.PALE_BOAT),
			ItemTranslation.of(TSItems.Magic.PALE_CHEST_BOAT));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, CHARRED), ItemTranslation.of(ModBlocks.CHARRED_LOG),
			ItemTranslation.of(ModBlocks.CHARRED_WOOD), ItemTranslation.of(ModBlocks.STRIPPED_CHARRED_LOG), ItemTranslation.of(ModBlocks.STRIPPED_CHARRED_WOOD),
			ItemTranslation.of(ModBlocks.CHARRED_PLANKS), null, null, null, ItemTranslation.of(ModBlocks.CHARRED_SLAB), ItemTranslation.of(ModBlocks.CHARRED_STAIRS),
			ItemTranslation.of(ModBlocks.CHARRED_FENCE), ItemTranslation.of(ModBlocks.CHARRED_FENCE_GATE), ItemTranslation.of(ModBlocks.CHARRED_BUTTON),
			ItemTranslation.of(ModBlocks.CHARRED_PRESSURE_PLATE), ItemTranslation.of(ModBlocks.CHARRED_DOOR), ItemTranslation.of(ModBlocks.CHARRED_TRAPDOOR),
			ItemTranslation.of(ModBlocks.CHARRED_SIGN), ItemTranslation.of(ModBlocks.CHARRED_HANGING_SIGN), ItemTranslation.of(TSItems.Magic.CHARRED_BOAT),
			ItemTranslation.of(TSItems.Magic.CHARRED_CHEST_BOAT));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, MIDAS), ItemTranslation.of(ModBlocks.MIDAS_LOG),
			ItemTranslation.of(ModBlocks.MIDAS_WOOD), ItemTranslation.of(ModBlocks.STRIPPED_MIDAS_LOG), ItemTranslation.of(ModBlocks.STRIPPED_MIDAS_WOOD),
			ItemTranslation.of(ModBlocks.MIDAS_PLANKS), ItemTranslation.of(ModBlocks.MIDAS_LEAVES), ItemTranslation.of(ModBlocks.MIDAS_SAPLING),
			ItemTranslation.of(ModBlocks.POTTED_MIDAS_SAPLING), ItemTranslation.of(ModBlocks.MIDAS_SLAB), ItemTranslation.of(ModBlocks.MIDAS_STAIRS),
			ItemTranslation.of(ModBlocks.MIDAS_FENCE), ItemTranslation.of(ModBlocks.MIDAS_FENCE_GATE), ItemTranslation.of(ModBlocks.MIDAS_BUTTON),
			ItemTranslation.of(ModBlocks.MIDAS_PRESSURE_PLATE), ItemTranslation.of(ModBlocks.MIDAS_DOOR), ItemTranslation.of(ModBlocks.MIDAS_TRAPDOOR),
			ItemTranslation.of(ModBlocks.MIDAS_SIGN), ItemTranslation.of(ModBlocks.MIDAS_HANGING_SIGN), ItemTranslation.of(TSItems.Magic.MIDAS_BOAT),
			ItemTranslation.of(TSItems.Magic.MIDAS_CHEST_BOAT));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, VIRIDIAN), ItemTranslation.of(ModBlocks.VIRIDIAN_LOG),
			ItemTranslation.of(ModBlocks.VIRIDIAN_WOOD), ItemTranslation.of(ModBlocks.STRIPPED_VIRIDIAN_LOG), ItemTranslation.of(ModBlocks.STRIPPED_VIRIDIAN_WOOD),
			ItemTranslation.of(ModBlocks.VIRIDIAN_PLANKS), ItemTranslation.of(ModBlocks.VIRIDIAN_LEAVES), ItemTranslation.of(ModBlocks.VIRIDIAN_SAPLING),
			ItemTranslation.of(ModBlocks.POTTED_VIRIDIAN_SAPLING), ItemTranslation.of(ModBlocks.VIRIDIAN_SLAB), ItemTranslation.of(ModBlocks.VIRIDIAN_STAIRS),
			ItemTranslation.of(ModBlocks.VIRIDIAN_FENCE), ItemTranslation.of(ModBlocks.VIRIDIAN_FENCE_GATE), ItemTranslation.of(ModBlocks.VIRIDIAN_BUTTON),
			ItemTranslation.of(ModBlocks.VIRIDIAN_PRESSURE_PLATE), ItemTranslation.of(ModBlocks.VIRIDIAN_DOOR), ItemTranslation.of(ModBlocks.VIRIDIAN_TRAPDOOR),
			ItemTranslation.of(ModBlocks.VIRIDIAN_SIGN), ItemTranslation.of(ModBlocks.VIRIDIAN_HANGING_SIGN), ItemTranslation.of(TSItems.Magic.VIRIDIAN_BOAT),
			ItemTranslation.of(TSItems.Magic.VIRIDIAN_CHEST_BOAT));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, CERULII), ItemTranslation.of(ModBlocks.CERULII_LOG),
			ItemTranslation.of(ModBlocks.CERULII_WOOD), ItemTranslation.of(ModBlocks.STRIPPED_CERULII_LOG), ItemTranslation.of(ModBlocks.STRIPPED_CERULII_WOOD),
			ItemTranslation.of(ModBlocks.CERULII_PLANKS), ItemTranslation.of(ModBlocks.CERULII_LEAVES), ItemTranslation.of(ModBlocks.CERULII_SAPLING),
			ItemTranslation.of(ModBlocks.POTTED_CERULII_SAPLING), ItemTranslation.of(ModBlocks.CERULII_SLAB), ItemTranslation.of(ModBlocks.CERULII_STAIRS),
			ItemTranslation.of(ModBlocks.CERULII_FENCE), ItemTranslation.of(ModBlocks.CERULII_FENCE_GATE), ItemTranslation.of(ModBlocks.CERULII_BUTTON),
			ItemTranslation.of(ModBlocks.CERULII_PRESSURE_PLATE), ItemTranslation.of(ModBlocks.CERULII_DOOR), ItemTranslation.of(ModBlocks.CERULII_TRAPDOOR),
			ItemTranslation.of(ModBlocks.CERULII_SIGN), ItemTranslation.of(ModBlocks.CERULII_HANGING_SIGN), ItemTranslation.of(TSItems.Magic.CERULII_BOAT),
			ItemTranslation.of(TSItems.Magic.CERULII_CHEST_BOAT));

        generateStatusEffect(translationBuilder, ModEffects.REDSTONED, "Redstoned", true);
        generateStatusEffect(translationBuilder, ModEffects.FLIGHT, "Flight", true);
        generateStatusEffect(translationBuilder, ModEffects.WELL_FED, "Well-Fed", false);
        generateStatusEffect(translationBuilder, ModEffects.COSMIC_FIRE, "Cosmic Flame", false);
        generateStatusEffect(translationBuilder, ModEffects.INFESTED, "☣ Infested ☣", false);
        generateStatusEffect(translationBuilder, ModEffects.IRRADIATED, "☢ Irradiated ☢", false);

        generateItems(translationBuilder, ItemTranslation.of(ModItems.SALT, null, "Used for keeping meat fresh.", SALT));

		generatePot(translationBuilder, ModBlocks.TRANQUIL_ROSE, ModBlocks.POTTED_TRANQUIL_ROSE, null, "Smells delightful.", TRANQUIL);
		generatePot(translationBuilder, ModBlocks.SKULLWEED, ModBlocks.POTTED_SKULLWEED, null, "It's so cold...", SKULLWEED);

		generateItems(translationBuilder, ItemTranslation.of(ModItems.RICE_SEEDS), ItemTranslation.of(ModItems.RICE_CAKE),
			ItemTranslation.of(ModBlocks.RICE_PLANT), ItemTranslation.of(ModBlocks.RICE_BLOCK));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, SHINY_GOLD),
			ItemTranslation.of(ModItems.GOLDEN_APPLE_JUICE), ItemTranslation.of(ModItems.BANANA), ItemTranslation.of(ModItems.BANANA_BREAD),
			ItemTranslation.of(ModBlocks.FEATHERCORN, null, "Soft and warm."));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, PEARFRUIT),
			ItemTranslation.of(ModItems.PEARFRUIT, null, "As good as gold.", PEARFRUIT), ItemTranslation.of(ModItems.PEARFRUIT_JUICE, null));
		generateItems(translationBuilder, ItemTranslation.of(ModItems.SUSHI_ROLL), ItemTranslation.of(ModItems.TORTILLA), ItemTranslation.of(ModItems.BURRITO),
			ItemTranslation.of(ModItems.FRIED_EGG), ItemTranslation.of(ModItems.APPLE_JUICE), ItemTranslation.of(ModItems.SWEET_BERRY_JUICE),
			ItemTranslation.of(ModItems.MIDAS_FRUIT, null, "22 karats", SHINY_GOLD), ItemTranslation.of(ModItems.SMOKED_FISH, null, SMOKED_FISH));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, STARSTEEL), ItemTranslation.of(TSItems.Tech.EMPTY_CAN),
			ItemTranslation.of(TSItems.Tech.BEETROOT_SOUP_CAN, "Can of Beetroot Soup"), ItemTranslation.of(TSItems.Tech.MUSHROOM_STEW_CAN, "Can of Mushroom Stew"),
			ItemTranslation.of(TSItems.Tech.RABBIT_STEW_CAN, "Can of Rabbit Stew"), ItemTranslation.of(TSItems.Tech.MILK_CAN, "Can of Evaporated Milk"),
			ItemTranslation.of(TSItems.Tech.COLA_ORANGE, "Can of A&L"), ItemTranslation.of(TSItems.Tech.COLA_GREEN, "Can of Trola-Cola"),
			ItemTranslation.of(TSItems.Tech.COLA_CYAN, "Can of AquaDei Lite"));

        generateItems(translationBuilder, ItemTranslation.of(ModItems.BROWNIE, null, "Comes from outer space?"));
        generateItems(translationBuilder, ItemTranslation.of(ModItems.CHORUS_COBBLER, null, "Memah's favorite recipe", CHORUS));
        generateItems(translationBuilder, ItemTranslation.of(ModItems.SANDFISH, null, "This is not a fish...", DUNE_TAN));
        generateItems(translationBuilder, ItemTranslation.of(ModItems.COOKED_SANDFISH, null, DUNE_TAN));
        generateItems(translationBuilder, ItemTranslation.of(ModItems.DUNE_EEL, null, "Isn't this a snake?", DUNE_TAN));

		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, FLESH_PINK),
			ItemTranslation.of(ModBlocks.FLESH_BLOCK, null, "It's strangely warm...", FLESH_PINK),
			ItemTranslation.of(ModBlocks.FLESH_VEINS, null, "They're spreading...", FLESH_PINK),
			ItemTranslation.of(ModBlocks.FLESHY_EYE, null, "It's staring...", FLESH_PINK),
			ItemTranslation.of(TSItems.Magic.EYE_OF_RUIN, null, "What a troubling gaze...", FLESH_PINK),
			ItemTranslation.of(TSItems.Magic.DUBIOUS_BACON, null, "Don't ask where it came from...", FLESH_PINK));

		generateItems(translationBuilder, ItemTranslation.of(ModItems.REDSTONE_CRYSTAL, "Crystallized Redstone", "Sparkles with potential.", BLOOD_RED));
		generateItems(translationBuilder, ItemTranslation.of(ModItems.BLOOD_DIAMOND, null, "Chaos itself shines through.", BLOOD_RED));
		generateItems(translationBuilder, ItemTranslation.of(ModItems.ASH, "Wither Ash", "Contains traces of dark magic.", TRANQUIL));
		generateItems(translationBuilder, ItemTranslation.of(ModItems.TRANQUIL_DUST, "Tranquil Pollen", "Useful in dark alchemy.", TRANQUIL));
		generateItems(translationBuilder, ItemTranslation.of(TSItems.Magic.DEMONIC_CORE, "Demonic Core", "Use while crouching to bind to a location!", LIGHT_PURPLE));
        generateItems(translationBuilder, ItemTranslation.of(TSItems.Tech.DISTANCE_TRACKER, "Lifeform Tracker", "Use on a mob to track it.", SCRAP_METAL));
        generateItems(translationBuilder, ItemTranslation.of(TSItems.Tech.PLASMA_CELL, null));

		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, SENTINEL_AQUA_T1),
			ItemTranslation.of(TSItems.Tech.HARD_LIGHT_PROJECTOR, "Hard Light Projector"), ItemTranslation.of(ModBlocks.HARD_LIGHT, "Hard Light"),
			ItemTranslation.of(ModBlocks.HARD_LIGHT_BARRIER, "Hard Light Barrier", "Creative only!"),
			ItemTranslation.of(TSItems.Tech.HOLOGRAPHIC_SIGN, "Holographic Sign"),
			ItemTranslation.of(TSItems.Tech.HOLOGRAPHIC_HANGING_SIGN, "Holographic Hanging Sign"));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, SENTINEL_GOLD_T1),
			ItemTranslation.of(TSItems.Tech.CAUTION_HARD_LIGHT_PROJECTOR, "Hard Light Projector"), ItemTranslation.of(ModBlocks.CAUTION_HARD_LIGHT, "Hard Light"),
			ItemTranslation.of(ModBlocks.CAUTION_HARD_LIGHT_BARRIER, "Hard Light Barrier", "Creative only!"),
			ItemTranslation.of(TSItems.Tech.CAUTION_HOLOGRAPHIC_SIGN, "Holographic Sign"),
			ItemTranslation.of(TSItems.Tech.CAUTION_HOLOGRAPHIC_HANGING_SIGN, "Holographic Hanging Sign"));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, SENTINEL_CRIMSON_T1),
			ItemTranslation.of(TSItems.Tech.SENTINEL_HARD_LIGHT_PROJECTOR, "Hard Light Projector"), ItemTranslation.of(ModBlocks.SENTINEL_HARD_LIGHT, "Hard Light"),
			ItemTranslation.of(ModBlocks.SENTINEL_HARD_LIGHT_BARRIER, "Hard Light Barrier", "Creative only!"),
			ItemTranslation.of(TSItems.Tech.SENTINEL_HOLOGRAPHIC_SIGN, "Holographic Sign"),
			ItemTranslation.of(TSItems.Tech.SENTINEL_HOLOGRAPHIC_HANGING_SIGN, "Holographic Hanging Sign"));
		generateItems(translationBuilder, ItemTranslation.of(ModBlocks.CHAMBER_BLOCK), ItemTranslation.of(ModBlocks.LIGHT_CHAMBER_BLOCK),
			ItemTranslation.of(ModBlocks.DARK_CHAMBER_BLOCK), ItemTranslation.of(ModBlocks.BLUE_AGILITY_BLOCK, null, SENTINEL_AQUA_T2),
			ItemTranslation.of(ModBlocks.ORANGE_AGILITY_BLOCK, null, GOLD));

		//Foundation Blocks
		generateItems(translationBuilder, ItemTranslation.of(ModBlocks.CRACKED_END_STONE_BRICKS), ItemTranslation.of(ModBlocks.CHISELED_END_STONE_BRICKS),
			ItemTranslation.of(ModBlocks.END_STONE_BRICK_COLUMN));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, LIGHT_PURPLE), ItemTranslation.of(ModBlocks.IMPIOUS_END_STONE),
			ItemTranslation.of(ModBlocks.IMPIOUS_END_STONE_BRICKS), ItemTranslation.of(ModBlocks.CRACKED_IMPIOUS_END_STONE_BRICKS),
			ItemTranslation.of(ModBlocks.CHISELED_IMPIOUS_END_STONE_BRICKS), ItemTranslation.of(ModBlocks.IMPIOUS_END_STONE_BRICK_COLUMN));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, LIGHT_PURPLE), ItemTranslation.of(ModBlocks.DEIFIC_END_STONE),
			ItemTranslation.of(ModBlocks.DEIFIC_END_STONE_BRICKS), ItemTranslation.of(ModBlocks.CRACKED_DEIFIC_END_STONE_BRICKS),
			ItemTranslation.of(ModBlocks.CHISELED_DEIFIC_END_STONE_BRICKS), ItemTranslation.of(ModBlocks.DEIFIC_END_STONE_BRICK_COLUMN));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, SNOWSTONE), ItemTranslation.of(ModBlocks.SNOWSTONE),
			ItemTranslation.of(ModBlocks.SNOWSTONE_STAIRS), ItemTranslation.of(ModBlocks.SNOWSTONE_SLAB), ItemTranslation.of(ModBlocks.SNOWSTONE_WALL),
			ItemTranslation.of(ModBlocks.SMOOTH_SNOWSTONE), ItemTranslation.of(ModBlocks.SMOOTH_SNOWSTONE_STAIRS), ItemTranslation.of(ModBlocks.SMOOTH_SNOWSTONE_SLAB),
			ItemTranslation.of(ModBlocks.SMOOTH_SNOWSTONE_WALL), ItemTranslation.of(ModBlocks.CUT_SNOWSTONE),
			ItemTranslation.of(ModBlocks.CUT_SNOWSTONE_SLAB), ItemTranslation.of(ModBlocks.CHISELED_SNOWSTONE));
		generateItems(translationBuilder, ItemTranslation.of(ModBlocks.MOSS_STAIRS), ItemTranslation.of(ModBlocks.MOSS_SLAB),
			ItemTranslation.of(ModBlocks.DIRT_STAIRS), ItemTranslation.of(ModBlocks.DIRT_SLAB), ItemTranslation.of(ModBlocks.COARSE_DIRT_STAIRS),
			ItemTranslation.of(ModBlocks.COARSE_DIRT_SLAB));

		generateItems(translationBuilder, ItemTranslation.of(ModBlocks.VENDOR));
		generateItems(translationBuilder, ItemTranslation.of(ModBlocks.RECONSTRUCTION_TABLE, null, SENTINEL_AQUA_T1));
		generateItems(translationBuilder, ItemTranslation.of(ModBlocks.MODIFICATION_TABLE));

        generateSound(translationBuilder, ModSounds.FLESH_AMBIENT, "Flesh wriggles");
        generateSound(translationBuilder, ModSounds.BLASTER_SHOOT, "Shot laser");
        generateSound(translationBuilder, ModSounds.PISTOL_RELOAD, "Reloading");
        generateSound(translationBuilder, ModSounds.SHOTGUN_RELOAD, "Reloading");
        generateSound(translationBuilder, ModSounds.SNIPER_RELOAD, "Reloading");
        generateSound(translationBuilder, ModSounds.BIO_RELOAD, "Reloading");
        generateSound(translationBuilder, ModSounds.DATABASE_OPEN, "Codex opened");
        generateSound(translationBuilder, ModSounds.DATABASE_FLIP, "Codex flipped");
        generateSound(translationBuilder, ModSounds.NOTCH_UP, "Powering up");

        translationBuilder.add(trevorssentinelsMain.SENTINELS.id(), "Trevor's Sentinels");

        translationBuilder.add("trevorssentinels.database.name", "HoloCodex");
        translationBuilder.add("trevorssentinels.database.desc", "Your guide to this world of magic and technology, " +
			"this database will store all information that may be useful on your adventure.");

		generateAdvancement(translationBuilder, "trevorssentinels", "Trevor's Sentinels", "Obtain a Scrap Metal Shard");
		generateAdvancement(translationBuilder, "industrial", "Industrial", "Obtain any industrial-tier item");
		generateAdvancement(translationBuilder, "ancient_metal", "Ancient Metal", "Obtain an ingot of Imperial Alloy");
		generateAdvancement(translationBuilder, "ancient_metal2", "Good Soldiers Follow Orders", "Obtain equipment made from Imperial Alloy");
		generateAdvancement(translationBuilder, "rose_gold", "Every Rose...", "Obtain equipment made from Rose Gold");
		generateAdvancement(translationBuilder, "thanatu", "...Has its Thorn", "Acquire the tools of the demon lord");
		generateAdvancement(translationBuilder, "cerberus", "False Idol", "Defeat Cerberus, and release the seal on ancient forces");
		generateAdvancement(translationBuilder, "uranium", "Nuclear Age", "Obtain equipment made from Nuclear Ingots");
		generateAdvancement(translationBuilder, "zenithium", "Infinity Squared", "Acquire a cluster of Zenithium");
		generateAdvancement(translationBuilder, "zenithium2", "Infinity+1 Everything", "\"Honey, where's my super suit?\"");

		generateAdvancement(translationBuilder, "brownie", "This Edible Ain't Shi-", "Consume a Brownie");
		generateAdvancement(translationBuilder, "chainsaw", "Chainsaws, Man", "Craft a Scrap Metal Chainsaw");
		generateAdvancement(translationBuilder, "bacon_and_eggs", "Bacon and Eggs", "Part of a complete breakfast!");
		generateAdvancement(translationBuilder, "spf", "SPF 50+", "Obtain a Banana Boat");

		translationBuilder.add("pillar.trevorssentinels.chaos", "Chaos");
		translationBuilder.add("pillar.trevorssentinels.truth", "Truth");
		translationBuilder.add("pillar.trevorssentinels.order", "Order");
        translationBuilder.add("pillar.trevorssentinels.balance", "Balance");
        translationBuilder.add("pillar.trevorssentinels.wisdom", "Wisdom");
        translationBuilder.add("pillar.trevorssentinels.tranquility", "Tranquility");
        translationBuilder.add("pillar.trevorssentinels.purity", "Purity");

        translationBuilder.add("death.attack.redstoned", "%1$s gave into the pain");
        translationBuilder.add("death.attack.infested", "%1$s didn't make it");
        translationBuilder.add("death.attack.irradiated", "%1$s ate one too many bananas");
        translationBuilder.add("death.attack.phaser_projectile", "%1$s phased away thanks to %2$s");
        translationBuilder.add("death.attack.phaser_projectile.item", "%1$s phased away thanks to %2$s and their %3$s");
        translationBuilder.add("death.attack.shard_projectile", "%2$s turned %1$s into a pincushion");
        translationBuilder.add("death.attack.shard_projectile.item", "%2$s turned %1$s into a pincushion using %3$s");
        translationBuilder.add("death.attack.dagger_projectile", "%1$s was shot through the heart, and %2$s is to blame");
        translationBuilder.add("death.attack.dagger_projectile.item", "%1$s was shot through the heart, and %2$s is to blame. They give %3$s a bad name");


        translationBuilder.add("key.category.trevorssentinels.trevorssentinels", "Trevor's Sentinels");
        translationBuilder.add("key.trevorssentinels.style_switch", "Style Switch");
        translationBuilder.add("key.trevorssentinels.reload", "Reload");

        translationBuilder.add(new Identifier(MOD_ID, "hologui").toTranslationKey(), "Sentinel HoloGUI");
        translationBuilder.add(new Identifier(MOD_ID, "vanilla_extensions").toTranslationKey(), "Vanilla Extensions");
        translationBuilder.add(new Identifier(MOD_ID, "legacy").toTranslationKey(), "Legacy Resources");

        generateNumbered(translationBuilder, MOD_ID+".worldLevelTooLow.", "",
                "Demonic power has too much of a hold over the world!", "The power is too strong!");
        generateNumbered(translationBuilder, "color."+MOD_ID+".worldLevelTooLow.", "", String.valueOf(LIGHT_PURPLE.getRGB()), String.valueOf(BLUE.getRGB()));
        translationBuilder.add(MOD_ID+".worldLevelTooLow.other", "A mysterious force pushes back!");

        translationBuilder.add(ModEntities.SHARD_PROJECTILE, TSItems.Tech.SCRAP_METAL_SHARD.getTranslationKey());
        translationBuilder.add(ModEntities.PHASER_PROJECTILE, "Phaser Projectile");
        translationBuilder.add(ModEntities.GRENADE, "Delayed Explosive");
        translationBuilder.add(ModEntities.SENTINEL, "Sentinel");
        translationBuilder.add(ModEntities.ROOMBA, "Sentinel Cleaning Droid");
        translationBuilder.add(ModEntities.FLORBUS, "Florbus");
        translationBuilder.add("entity.minecraft.villager.engineer", "§6Engineer");
        translationBuilder.add("entity.minecraft.villager.demolitionist", "§cDemolitionist");
        translationBuilder.add("entity.minecraft.villager.acolyte", "§cAcolyte");
        translationBuilder.add("entity.minecraft.villager.witherseer", "§dWitherseer");

        translationBuilder.add("gamerule.trevorssentinels:useVelocityFallDamage", "Use velocity-based fall damage");
        translationBuilder.add("gamerule.trevorssentinels:useVelocityFallDamage.description", "If enabled, fall damage will be calculated based on velocity.");
        translationBuilder.add("gamerule.trevorssentinels:milkCuresPotionEffects", "Drinking milk cures potion effects");
        translationBuilder.add("tooltip.trevorssentinels:milkCuresPotionEffects", "Effects will not be cured!");
        //translationBuilder.add("gamerule.trevorssentinels:milkCuresPotionEffects.description", "If enabled, fall damage will be calculated based on velocity.");

		translationBuilder.add("itemGroup." + MOD_ID + ".sentinels", "Trevor's Sentinels");
		translationBuilder.add("itemGroup." + MOD_ID + ".sentinels.tab.magic", "Magic");
		translationBuilder.add("itemGroup." + MOD_ID + ".sentinels.tab.tech", "Tech");
		translationBuilder.add("itemGroup." + MOD_ID + ".sentinels.tab.beta", "Beta");
		translationBuilder.add("itemGroup." + MOD_ID + ".sentinels.button.wiki", "Wiki");

		translationBuilder.add("tooltip.item.trevorssentinels.phaser.stats", "Phaser Stats:");

		translationBuilder.add("tooltip." + MOD_ID + ".set_bonus_active", "Set bonus active!");
		translationBuilder.add("tooltip." + MOD_ID + ".set_bonus_inactive", "Set bonus inactive!");
        translationBuilder.add("tooltip." + MOD_ID + ".style", "Style: ");
        translationBuilder.add("tooltip." + MOD_ID + ".mode", "Mode: ");
        generateNumbered(translationBuilder, "tooltip." + MOD_ID + ".style_switch.", " to switch style.", " to cycle modes.");
        generateNumbered(translationBuilder, "style.item." + MOD_ID + ".pappym_blade.", "Trickster", "Paladin", "Predator", "Guardian");
        generateNumbered(translationBuilder, "style.item." + MOD_ID + ".thanatu_blade.", "Riftwalker", "Riftcaller");
        generateNumbered(translationBuilder, "style.item." + MOD_ID + ".lilith_blade.", "Holy Retribution", "ENDLESS LIGHT");
        generateNumbered(translationBuilder, "style.item." + MOD_ID + ".phaser.", "Reloading: Manual", "Reloading: Automatic");

        if (dataOutput.getModContainer().findPath("assets/trevorssentinels/lang/en_us.existing.json").isPresent()) try {
            translationBuilder.add(dataOutput.getModContainer().findPath("assets/trevorssentinels/lang/en_us.existing.json").get());
        } catch (Exception e) { throw new RuntimeException("Failed to add existing language file!", e); }
    }
}
