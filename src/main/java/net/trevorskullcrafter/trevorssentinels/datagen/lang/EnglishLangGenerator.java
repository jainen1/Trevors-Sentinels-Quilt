package net.trevorskullcrafter.trevorssentinels.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.effect.ModEffects;
import net.trevorskullcrafter.trevorssentinels.item.MagicItems;
import net.trevorskullcrafter.trevorssentinels.item.ModArmory;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.item.TechItems;
import net.trevorskullcrafter.trevorssentinels.sound.ModSounds;
import net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain.MOD_ID;
import static net.trevorskullcrafter.trevorssentinels.util.LangGenUtils.*;
import static net.trevorskullcrafter.trevorssentinels.util.TextUtil.*;

public class EnglishLangGenerator extends FabricLanguageProvider {
    public EnglishLangGenerator(FabricDataOutput dataOutput) { super(dataOutput, "en_us"); }

    @Override public void generateTranslations(TranslationBuilder translationBuilder) {
		//Magic Equipment
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, VIRIDIAN), ItemTranslation.of(MagicItems.DRYADIC_HELMET),
			ItemTranslation.of(MagicItems.DRYADIC_CHESTPLATE), ItemTranslation.of(MagicItems.DRYADIC_LEGGINGS), ItemTranslation.of(MagicItems.DRYADIC_BOOTS),
			ItemTranslation.of(MagicItems.DRYADIC_SWORD), ItemTranslation.of(MagicItems.DRYADIC_DAGGER));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, ROSE_GOLD), ItemTranslation.of(MagicItems.ROSE_GOLD_INGOT),
			ItemTranslation.of(ModBlocks.ROSE_GOLD_BLOCK, "Block of Rose Gold"), ItemTranslation.of(MagicItems.ROSE_GOLD_HELMET),
			ItemTranslation.of(MagicItems.ROSE_GOLD_CHESTPLATE, "Rose Gold Cuirass"), ItemTranslation.of(MagicItems.ROSE_GOLD_LEGGINGS),
			ItemTranslation.of(MagicItems.ROSE_GOLD_BOOTS), ItemTranslation.of(MagicItems.ROSE_GOLD_SWORD), ItemTranslation.of(MagicItems.ROSE_GOLD_DAGGER),
			ItemTranslation.of(MagicItems.ROSE_GOLD_PICKAXE), ItemTranslation.of(MagicItems.ROSE_GOLD_BATTLEAXE), ItemTranslation.of(MagicItems.ROSE_GOLD_SHOVEL),
			ItemTranslation.of(MagicItems.ROSE_GOLD_SICKLE, null, "Functions as a Hoe.", null));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, VIRIDIAN), ItemTranslation.of(MagicItems.DRUIDIC_HELMET),
			ItemTranslation.of(MagicItems.DRUIDIC_CHESTPLATE), ItemTranslation.of(MagicItems.DRUIDIC_LEGGINGS), ItemTranslation.of(MagicItems.DRUIDIC_BOOTS),
			ItemTranslation.of(MagicItems.DRUIDIC_SWORD), ItemTranslation.of(MagicItems.DRUIDIC_DAGGER), ItemTranslation.of(MagicItems.DRUIDIC_BOW));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, IMPERIAL_ALLOY), ItemTranslation.of(MagicItems.IMPERIAL_ALLOY_INGOT),
			ItemTranslation.of(ModBlocks.IMPERIAL_ALLOY_BLOCK, "Block of Imperial Alloy"), ItemTranslation.of(MagicItems.IMPERIAL_HELMET),
			ItemTranslation.of(MagicItems.IMPERIAL_CHESTPLATE), ItemTranslation.of(MagicItems.IMPERIAL_LEGGINGS), ItemTranslation.of(MagicItems.IMPERIAL_BOOTS),
			ItemTranslation.of(MagicItems.IMPERIAL_SWORD), ItemTranslation.of(MagicItems.IMPERIAL_GLADIUS), ItemTranslation.of(MagicItems.IMPERIAL_PICKAXE),
			ItemTranslation.of(MagicItems.IMPERIAL_BATTLEAXE), ItemTranslation.of(MagicItems.IMPERIAL_SHOVEL),
			ItemTranslation.of(MagicItems.IMPERIAL_SICKLE, null, "Functions as a Hoe.", null));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, LIGHT_PURPLE),
			ItemTranslation.of(MagicItems.THANATU_HELMET, "Macabre Skull", "The skull of the demon king.", null),
			ItemTranslation.of(MagicItems.THANATU_CHESTPLATE, "Macabre Shoulderpads"), ItemTranslation.of(MagicItems.THANATU_LEGGINGS, "Macabre Loincloth"),
			ItemTranslation.of(MagicItems.THANATU_BOOTS, "Macabre Sandals"));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, LIGHT_PURPLE), ItemTranslation.of(MagicItems.UNHOLY_SHARDS),
			ItemTranslation.of(MagicItems.UNHOLY_INGOT, null, "Reflects only the light in darkness.", null),
			ItemTranslation.of(ModBlocks.UNHOLY_BLOCK, "Block of Unholy Alloy"), ItemTranslation.of(MagicItems.UNHOLY_HELMET),
			ItemTranslation.of(MagicItems.UNHOLY_CHESTPLATE, "Unholy Cuirass"), ItemTranslation.of(MagicItems.UNHOLY_LEGGINGS),
			ItemTranslation.of(MagicItems.UNHOLY_BOOTS), ItemTranslation.of(MagicItems.UNHOLY_SWORD), ItemTranslation.of(MagicItems.UNHOLY_DAGGER),
			ItemTranslation.of(MagicItems.UNHOLY_PICKAXE), ItemTranslation.of(MagicItems.UNHOLY_BATTLEAXE), ItemTranslation.of(MagicItems.UNHOLY_SHOVEL),
			ItemTranslation.of(MagicItems.UNHOLY_SICKLE, null, "Functions as a Hoe.", null));
		generateItems(translationBuilder, ItemTranslation.of(MagicItems.ARMA_DEI_HELMET), ItemTranslation.of(MagicItems.ARMA_DEI_CHESTPLATE),
			ItemTranslation.of(MagicItems.ARMA_DEI_LEGGINGS), ItemTranslation.of(MagicItems.ARMA_DEI_BOOTS), ItemTranslation.of(MagicItems.ARMA_DEI_SWORD),
			ItemTranslation.of(MagicItems.ARMA_DEI_DAGGER), ItemTranslation.of(MagicItems.ARMA_DEI_PICKAXE), ItemTranslation.of(MagicItems.ARMA_DEI_BATTLEAXE),
			ItemTranslation.of(MagicItems.ARMA_DEI_SHOVEL), ItemTranslation.of(MagicItems.ARMA_DEI_SICKLE, null, "Functions as a Hoe.", null));

		generateItems(translationBuilder, ItemTranslation.of(ModBlocks.WAX_INFUSED_COPPER_BLOCK, "Wax-Infused Block of Copper"));
		generateItems(translationBuilder, ItemTranslation.of(ModBlocks.STARSTEEL_LAMP));
		generateItems(translationBuilder, ItemTranslation.of(ModBlocks.STARSTEEL_FAN));
		generateItems(translationBuilder, ItemTranslation.of(ModBlocks.BATTERY));
		generateItems(translationBuilder, ItemTranslation.of(ModBlocks.FUSEBOX));
		generateItems(translationBuilder, ItemTranslation.of(ModBlocks.FANCY_COMPUTER));
		generateItems(translationBuilder, ItemTranslation.of(ModBlocks.BLACK_AGILITY_BLOCK, "Steel Magno-Repulsion Block", "Watch your step.", null));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, SENTINEL_CRIMSON_T1), ItemTranslation.of(ModBlocks.BIG_RED_BUTTON),
			ItemTranslation.of(ModBlocks.BIG_RED_PRESSURE_PLATE, null, "1500 Megawatt Super Colliding Super Plate", null));

		//Tech Equipment
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, SCRAP_METAL), ItemTranslation.of(TechItems.SCRAP_METAL_SHARD),
			ItemTranslation.of(ModBlocks.SCRAP_METAL_BLOCK), ItemTranslation.of(ModBlocks.CHISELED_SCRAP_METAL_BLOCK), ItemTranslation.of(TechItems.SCRAP_METAL_HELMET),
			ItemTranslation.of(TechItems.SCRAP_METAL_CHESTPLATE), ItemTranslation.of(TechItems.SCRAP_METAL_LEGGINGS), ItemTranslation.of(TechItems.SCRAP_METAL_BOOTS),
			ItemTranslation.of(TechItems.SCRAP_METAL_SWORD), ItemTranslation.of(TechItems.SCRAP_METAL_KNIFE), ItemTranslation.of(TechItems.SCRAP_METAL_DRILL),
			ItemTranslation.of(TechItems.SCRAP_METAL_CHAINSAW, null, "Right click to launch shards at enemies!", null),
			ItemTranslation.of(TechItems.SCRAP_METAL_SHOVEL), ItemTranslation.of(TechItems.SCRAP_METAL_HOE));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, STARSTEEL), ItemTranslation.of(TechItems.INDUSTRIAL_HELMET),
			ItemTranslation.of(TechItems.INDUSTRIAL_HARNESS), ItemTranslation.of(TechItems.INDUSTRIAL_PANTS), ItemTranslation.of(TechItems.INDUSTRIAL_BOOTS),
			ItemTranslation.of(TechItems.INDUSTRIAL_CROWBAR, null, "Rise, and... shine.", null));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, STARSTEEL), ItemTranslation.of(TechItems.STARSTEEL_INGOT),
			ItemTranslation.of(ModBlocks.STARSTEEL_BLOCK, "Block of Starsteel"),
			ItemTranslation.of(ModBlocks.CHISELED_STARSTEEL_BLOCK, "Chiseled Block of Starsteel"), ItemTranslation.of(ModBlocks.STAINLESS_STEEL_BLOCK),
			ItemTranslation.of(ModBlocks.STARSTEEL_LADDER), ItemTranslation.of(TechItems.STARSTEEL_HANGING_SIGN), ItemTranslation.of(TechItems.STARSTEEL_HANGING_SIGN),
			ItemTranslation.of(TechItems.STARSTEEL_HELMET), ItemTranslation.of(TechItems.STARSTEEL_CHESTPLATE), ItemTranslation.of(TechItems.STARSTEEL_LEGGINGS),
			ItemTranslation.of(TechItems.STARSTEEL_BOOTS), ItemTranslation.of(TechItems.STARSTEEL_SWORD), ItemTranslation.of(TechItems.STARSTEEL_KNIFE),
			ItemTranslation.of(TechItems.STARSTEEL_DRILL), ItemTranslation.of(TechItems.STARSTEEL_AXE), ItemTranslation.of(TechItems.STARSTEEL_SHOVEL),
			ItemTranslation.of(TechItems.STARSTEEL_HOE));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, NUCLEAR), ItemTranslation.of(TechItems.NUCLEAR_INGOT),
			ItemTranslation.of(ModBlocks.NUCLEAR_ORE), ItemTranslation.of(ModBlocks.NUCLEAR_BLOCK, "Nuclear Storage Block"), ItemTranslation.of(TechItems.NUCLEAR_ROCKET),
			ItemTranslation.of(TechItems.NUCLEAR_HELMET), ItemTranslation.of(TechItems.NUCLEAR_CHESTPLATE), ItemTranslation.of(TechItems.NUCLEAR_LEGGINGS),
			ItemTranslation.of(TechItems.NUCLEAR_BOOTS), ItemTranslation.of(TechItems.NUCLEAR_SWORD, null, "Irradiates enemies.", null),
			ItemTranslation.of(TechItems.NUCLEAR_VIBROKNIFE, null, "Irradiates enemies.", null), ItemTranslation.of(TechItems.NUCLEAR_DRILL),
			ItemTranslation.of(TechItems.NUCLEAR_AXE), ItemTranslation.of(TechItems.NUCLEAR_SHOVEL), ItemTranslation.of(TechItems.NUCLEAR_HOE));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, BLOOD_RED), ItemTranslation.of(TechItems.NANOTECH_CAPSULE),
			ItemTranslation.of(ModBlocks.NANOTECH_BLOCK, "Nanotech Storage Block"), ItemTranslation.of(TechItems.NANOTECH_HELMET),
			ItemTranslation.of(TechItems.NANOTECH_CHESTPLATE), ItemTranslation.of(TechItems.NANOTECH_LEGGINGS), ItemTranslation.of(TechItems.NANOTECH_BOOTS),
			ItemTranslation.of(TechItems.NANOTECH_SWORD, null, "\"I've even forgotten my name...\"", null),
			ItemTranslation.of(TechItems.NANOTECH_VIBROKNIFE), ItemTranslation.of(TechItems.NANOTECH_DRILL), ItemTranslation.of(TechItems.NANOTECH_AXE),
			ItemTranslation.of(TechItems.NANOTECH_SHOVEL), ItemTranslation.of(TechItems.NANOTECH_HOE));

		//Transcendent Equipment
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, DARK_GREEN),
			ItemTranslation.of(TechItems.ZENITHIUM_CLUSTER, null, "The concentrated essence of a galaxy.", null),
			ItemTranslation.of(TechItems.ZENITHIUM_HELMET), ItemTranslation.of(TechItems.ZENITHIUM_CHESTPLATE), ItemTranslation.of(TechItems.ZENITHIUM_LEGGINGS),
			ItemTranslation.of(TechItems.ZENITHIUM_BOOTS), ItemTranslation.of(TechItems.ZENITHIUM_SWORD), ItemTranslation.of(TechItems.ZENITHIUM_DAGGER),
			ItemTranslation.of(TechItems.ZENITHIUM_PICKAXE), ItemTranslation.of(TechItems.ZENITHIUM_AXE), ItemTranslation.of(TechItems.ZENITHIUM_SHOVEL),
			ItemTranslation.of(TechItems.ZENITHIUM_HOE));

		generateItems(translationBuilder, ItemTranslation.of(MagicItems.COPPER_GLADIUS, null, "An ornamental blade of goblin tradition.", COPPER));
		generateItems(translationBuilder, ItemTranslation.of(MagicItems.COPPER_ARM, null, "Contains a remnant of the goddess's power.", COPPER));
		//Blacksmith's Welding Mask, Mad Scientist's Lab Coat

        generateItems(translationBuilder,
			ItemTranslation.of(MagicItems.PAPPYM_BLADE, "Jade Seraphim", "Passed down through ancient tradition... and now it has found its way to you.", GREEN),
			ItemTranslation.of(MagicItems.PAPPYD_BLADE, "Hell's Flaming Fury", HELLFIRE),
			ItemTranslation.of(MagicItems.THANATU_BLADE, "Harmonious Rapture", LIGHT_PURPLE),
			ItemTranslation.of(MagicItems.MORPHEUS_BLADE, "Thunderous Legacy", AQUA),
			ItemTranslation.of(MagicItems.SKYLAR_BLADE, "Equitous Retribution", SHINY_GOLD),
			ItemTranslation.of(MagicItems.LILITH_BLADE, "Unwavering Judgement", DUNE_TAN),
			ItemTranslation.of(MagicItems.TREVOR_BLADE, "blade_null", SENTINEL_AQUA_T1),
			ItemTranslation.of(MagicItems.KINGS_BLADE, "Stainless Resolve"),
			ItemTranslation.of(ModArmory.SCARA_SHEARS, "SCARA Shears", "A military-grade threat.", DARK_PURPLE),
			ItemTranslation.of(ModArmory.MASTER_SWORD, "The Master's Sword", "From a distant universe...", AQUA));
        generateItems(translationBuilder,
			ItemTranslation.of(TechItems.LASER_PISTOL, "NUMA-28 Comet", "\"Fast and portable!\"", STARSTEEL),
			ItemTranslation.of(TechItems.LASER_TASER, "Enforcer-Standard Taser", "\"Non-lethal.\"", AQUA),
			ItemTranslation.of(TechItems.LASER_SNIPER_ECHO, "NUMA-52 Echo", "\"They'll never see it coming!\"", DUNE_TAN),
			ItemTranslation.of(TechItems.LASER_MINIGUN, "UTARI-91 Serenity", "\"Keep the peace!\"", BLUE),
			ItemTranslation.of(TechItems.LASER_RIFLE, "NUMA-63 Agnostyk", "\"Packs a punch!\"", MOSS),
			ItemTranslation.of(TechItems.SCRAP_METAL_PHASER, "NUMA-63 Agnostyk", "\"Packs a punch!\"", MOSS),
			ItemTranslation.of(TechItems.LASER_SHOTGUN, "KHAOS-66 Tremor", "\"Rip and tear!\"", HELLFIRE),
			ItemTranslation.of(TechItems.LASER_HEALER, "PW49 Firebird", "\"Those who can't do, heal!\"", SHINY_GOLD),
			ItemTranslation.of(TechItems.LASER_SNIPER, "PW88 Shadow", "\"The assassin's weapon of choice!\"", DARK_PURPLE),
			ItemTranslation.of(TechItems.LASER_SPREADER, "PW76 Pandemic", "\"Filled with a toxic bioweapon.\"", GREEN),
			ItemTranslation.of(TechItems.LASER_REVOLVER, "Drunkard's Handcannon", "\"But you have heard of me!\"", null),
			ItemTranslation.of(TechItems.VILE_SPITTER, "Vile Spitter", "\"Behold, the wrath of Xirang!\"", FLESH_PINK));
		generateItems(translationBuilder,
			ItemTranslation.of(MagicItems.RESISTANCE_ITEM, "Shield Badge", GRAY),
			ItemTranslation.of(MagicItems.FIRE_RESISTANCE_ITEM, "Flaming Badge", HELLFIRE), //shield badge, fire stuff
			ItemTranslation.of(MagicItems.JUMP_BOOST_ITEM, "Icarus' Gust", NUCLEAR),
			ItemTranslation.of(MagicItems.STRENGTH_ITEM, "Sword Badge", GRAY), //shattered sword, iron ingots?
			ItemTranslation.of(MagicItems.WEAKNESS_ITEM, "Shattered Sword", "A reminder of past failures.", null),
			ItemTranslation.of(MagicItems.REGENERATION_ITEM, "Ever-Beating Heart"), //leviathan stuff
			ItemTranslation.of(MagicItems.WATER_BREATHING_ITEM, "Abyssal Bubbles"),
			ItemTranslation.of(MagicItems.INVISIBILITY_ITEM, "Vampire's Mirror"),
			ItemTranslation.of(MagicItems.DOLPHINS_GRACE_ITEM, "Foam Dolphin Plush", "Its silky skin makes one feel hydrodynamic.", DOLPHIN),
			ItemTranslation.of(MagicItems.CONDUIT_POWER_ITEM, "Eye of the Sea"),
			ItemTranslation.of(MagicItems.NIGHT_VISION_ITEM, "Feline Eye"),
			ItemTranslation.of(MagicItems.HERO_OF_THE_VILLAGE_ITEM, "Hero's Emerald", "Gifted to heroes of legend.", NUCLEAR),
			ItemTranslation.of(MagicItems.PALADINS_BADGE, null, "The mark of a true warrior of light.", SHINY_GOLD), //flaming badge, sword badge
			ItemTranslation.of(MagicItems.CYBERNETIC_STOMACH, null, null, SCRAP_METAL),
			ItemTranslation.of(MagicItems.ONE_PENCE, "The One Pence", "Wealth, Fame, Power.", COPPER));

		generateItems(translationBuilder,
			ItemTranslation.of(ModItems.SENTINEL_SPAWN_EGG, "Sentinel Spawn Beacon", "A mindless drone for the hive.", SCRAP_METAL),
			ItemTranslation.of(ModItems.ROOMBA_SPAWN_EGG, "Sentinel Cleaning Droid", "Once a human, now a living sanitizer.", SCRAP_METAL),
			ItemTranslation.of(ModItems.FLORBUS_SPAWN_EGG, "Florbus Spawn Sac"));
		generateItems(translationBuilder, ItemTranslation.of(ModItems.VENDOR_TOKEN, null, null, VENDOR_TOKEN), ItemTranslation.of(ModItems.LEGENDARY_TOKEN));

		generateMusicDisc(translationBuilder, ItemTranslation.of(TechItems.MUSIC_DISC_ASSASSINATION_UPLOAD, "Scrapped Cassette"),
			"Kristoffer Kaufmann - Assassination Upload", ModSounds.ASSASSINATION_UPLOAD);
		generateMusicDisc(translationBuilder, ItemTranslation.of(TechItems.MUSIC_DISC_ODE_TO_TRANQUILITY, "Music Disc"),
			"Kristoffer Kaufmann - Ode to Tranquility", ModSounds.ODE_TO_TRANQUILITY);
		generateMusicDisc(translationBuilder, ItemTranslation.of(TechItems.MUSIC_DISC_LAPSE_IN_JUDGEMENT, "War-Torn Music Disc"),
			"Kristoffer Kaufmann - Lapse in Judgement", ModSounds.LAPSE_IN_JUDGEMENT);
		generateMusicDisc(translationBuilder, ItemTranslation.of(TechItems.MUSIC_DISC_RECITAL, "Aged Cassette",
			"It's in remarkably good condition.", null), "Trevor Skullcrafter - recital", ModSounds.RECITAL);

		//Wood
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, YGGDRASIL), ItemTranslation.of(ModBlocks.PALE_LOG),
			ItemTranslation.of(ModBlocks.PALE_WOOD), ItemTranslation.of(ModBlocks.STRIPPED_PALE_LOG), ItemTranslation.of(ModBlocks.STRIPPED_PALE_WOOD),
			ItemTranslation.of(ModBlocks.PALE_PLANKS), ItemTranslation.of(ModBlocks.PALE_LEAVES), ItemTranslation.of(ModBlocks.PALE_SAPLING),
			ItemTranslation.of(ModBlocks.POTTED_PALE_SAPLING), ItemTranslation.of(ModBlocks.PALE_SLAB), ItemTranslation.of(ModBlocks.PALE_STAIRS),
			ItemTranslation.of(ModBlocks.PALE_FENCE), ItemTranslation.of(ModBlocks.PALE_FENCE_GATE), ItemTranslation.of(ModBlocks.PALE_BUTTON),
			ItemTranslation.of(ModBlocks.PALE_PRESSURE_PLATE), ItemTranslation.of(ModBlocks.PALE_DOOR), ItemTranslation.of(ModBlocks.PALE_TRAPDOOR),
			ItemTranslation.of(ModBlocks.PALE_SIGN), ItemTranslation.of(ModBlocks.PALE_HANGING_SIGN), ItemTranslation.of(MagicItems.PALE_BOAT),
			ItemTranslation.of(MagicItems.PALE_CHEST_BOAT));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, CHARRED), ItemTranslation.of(ModBlocks.CHARRED_LOG),
			ItemTranslation.of(ModBlocks.CHARRED_WOOD), ItemTranslation.of(ModBlocks.STRIPPED_CHARRED_LOG), ItemTranslation.of(ModBlocks.STRIPPED_CHARRED_WOOD),
			ItemTranslation.of(ModBlocks.CHARRED_PLANKS), null, null, null, ItemTranslation.of(ModBlocks.CHARRED_SLAB), ItemTranslation.of(ModBlocks.CHARRED_STAIRS),
			ItemTranslation.of(ModBlocks.CHARRED_FENCE), ItemTranslation.of(ModBlocks.CHARRED_FENCE_GATE), ItemTranslation.of(ModBlocks.CHARRED_BUTTON),
			ItemTranslation.of(ModBlocks.CHARRED_PRESSURE_PLATE), ItemTranslation.of(ModBlocks.CHARRED_DOOR), ItemTranslation.of(ModBlocks.CHARRED_TRAPDOOR),
			ItemTranslation.of(ModBlocks.CHARRED_SIGN), ItemTranslation.of(ModBlocks.CHARRED_HANGING_SIGN), ItemTranslation.of(MagicItems.CHARRED_BOAT),
			ItemTranslation.of(MagicItems.CHARRED_CHEST_BOAT));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, MIDAS), ItemTranslation.of(ModBlocks.MIDAS_LOG),
			ItemTranslation.of(ModBlocks.MIDAS_WOOD), ItemTranslation.of(ModBlocks.STRIPPED_MIDAS_LOG), ItemTranslation.of(ModBlocks.STRIPPED_MIDAS_WOOD),
			ItemTranslation.of(ModBlocks.MIDAS_PLANKS), ItemTranslation.of(ModBlocks.MIDAS_LEAVES), ItemTranslation.of(ModBlocks.MIDAS_SAPLING),
			ItemTranslation.of(ModBlocks.POTTED_MIDAS_SAPLING), ItemTranslation.of(ModBlocks.MIDAS_SLAB), ItemTranslation.of(ModBlocks.MIDAS_STAIRS),
			ItemTranslation.of(ModBlocks.MIDAS_FENCE), ItemTranslation.of(ModBlocks.MIDAS_FENCE_GATE), ItemTranslation.of(ModBlocks.MIDAS_BUTTON),
			ItemTranslation.of(ModBlocks.MIDAS_PRESSURE_PLATE), ItemTranslation.of(ModBlocks.MIDAS_DOOR), ItemTranslation.of(ModBlocks.MIDAS_TRAPDOOR),
			ItemTranslation.of(ModBlocks.MIDAS_SIGN), ItemTranslation.of(ModBlocks.MIDAS_HANGING_SIGN), ItemTranslation.of(MagicItems.MIDAS_BOAT),
			ItemTranslation.of(MagicItems.MIDAS_CHEST_BOAT));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, VIRIDIAN), ItemTranslation.of(ModBlocks.VIRIDIAN_LOG),
			ItemTranslation.of(ModBlocks.VIRIDIAN_WOOD), ItemTranslation.of(ModBlocks.STRIPPED_VIRIDIAN_LOG), ItemTranslation.of(ModBlocks.STRIPPED_VIRIDIAN_WOOD),
			ItemTranslation.of(ModBlocks.VIRIDIAN_PLANKS), ItemTranslation.of(ModBlocks.VIRIDIAN_LEAVES), ItemTranslation.of(ModBlocks.VIRIDIAN_SAPLING),
			ItemTranslation.of(ModBlocks.POTTED_VIRIDIAN_SAPLING), ItemTranslation.of(ModBlocks.VIRIDIAN_SLAB), ItemTranslation.of(ModBlocks.VIRIDIAN_STAIRS),
			ItemTranslation.of(ModBlocks.VIRIDIAN_FENCE), ItemTranslation.of(ModBlocks.VIRIDIAN_FENCE_GATE), ItemTranslation.of(ModBlocks.VIRIDIAN_BUTTON),
			ItemTranslation.of(ModBlocks.VIRIDIAN_PRESSURE_PLATE), ItemTranslation.of(ModBlocks.VIRIDIAN_DOOR), ItemTranslation.of(ModBlocks.VIRIDIAN_TRAPDOOR),
			ItemTranslation.of(ModBlocks.VIRIDIAN_SIGN), ItemTranslation.of(ModBlocks.VIRIDIAN_HANGING_SIGN), ItemTranslation.of(MagicItems.VIRIDIAN_BOAT),
			ItemTranslation.of(MagicItems.VIRIDIAN_CHEST_BOAT));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, CERULII), ItemTranslation.of(ModBlocks.CERULII_LOG),
			ItemTranslation.of(ModBlocks.CERULII_WOOD), ItemTranslation.of(ModBlocks.STRIPPED_CERULII_LOG), ItemTranslation.of(ModBlocks.STRIPPED_CERULII_WOOD),
			ItemTranslation.of(ModBlocks.CERULII_PLANKS), ItemTranslation.of(ModBlocks.CERULII_LEAVES), ItemTranslation.of(ModBlocks.CERULII_SAPLING),
			ItemTranslation.of(ModBlocks.POTTED_CERULII_SAPLING), ItemTranslation.of(ModBlocks.CERULII_SLAB), ItemTranslation.of(ModBlocks.CERULII_STAIRS),
			ItemTranslation.of(ModBlocks.CERULII_FENCE), ItemTranslation.of(ModBlocks.CERULII_FENCE_GATE), ItemTranslation.of(ModBlocks.CERULII_BUTTON),
			ItemTranslation.of(ModBlocks.CERULII_PRESSURE_PLATE), ItemTranslation.of(ModBlocks.CERULII_DOOR), ItemTranslation.of(ModBlocks.CERULII_TRAPDOOR),
			ItemTranslation.of(ModBlocks.CERULII_SIGN), ItemTranslation.of(ModBlocks.CERULII_HANGING_SIGN), ItemTranslation.of(MagicItems.CERULII_BOAT),
			ItemTranslation.of(MagicItems.CERULII_CHEST_BOAT));

        generateStatusEffect(translationBuilder, ModEffects.REDSTONED, "Redstoned", true);
        generateStatusEffect(translationBuilder, ModEffects.FLIGHT, "Flight", true);
        generateStatusEffect(translationBuilder, ModEffects.WELL_FED, "Well-Fed", false);
        generateStatusEffect(translationBuilder, ModEffects.COSMIC_FIRE, "Cosmic Flame", false);
        generateStatusEffect(translationBuilder, ModEffects.INFESTED, "☣ Infested ☣", false);
        generateStatusEffect(translationBuilder, ModEffects.IRRADIATED, "☢ Irradiated ☢", false);

        generateItems(translationBuilder, ItemTranslation.of(ModItems.ANTIMILK, "Doctor Chadd's Ultimate Anti-Milk of Wondrous Effects",
			"Contains brief, yet unlimited, power.", null));
        generateItems(translationBuilder, ItemTranslation.of(ModItems.SALT, null, "Used for keeping meat fresh.", SALT));

		generatePot(translationBuilder, ModBlocks.TRANQUIL_ROSE, ModBlocks.POTTED_TRANQUIL_ROSE, null, "Smells delightful.", TRANQUIL);
		generatePot(translationBuilder, ModBlocks.SKULLWEED, ModBlocks.POTTED_SKULLWEED, null, "It's so cold...", SKULLWEED);

		generateItems(translationBuilder, ItemTranslation.of(ModItems.RICE_SEEDS), ItemTranslation.of(ModItems.RICE_CAKE),
			ItemTranslation.of(ModBlocks.RICE_PLANT), ItemTranslation.of(ModBlocks.RICE_BLOCK));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, SHINY_GOLD), ItemTranslation.of(ModItems.GOLDEN_RICE_SEEDS),
			ItemTranslation.of(ModItems.GOLDEN_RICE_CAKE), ItemTranslation.of(ModBlocks.GOLDEN_RICE_PLANT), ItemTranslation.of(ModBlocks.GOLDEN_RICE_BLOCK),
			ItemTranslation.of(ModBlocks.FEATHERCORN, null, "Soft and warm", null), ItemTranslation.of(ModItems.BANANA), ItemTranslation.of(ModItems.BANANA_BREAD));
		generateItems(translationBuilder, ItemTranslation.of(ModItems.SUSHI_ROLL), ItemTranslation.of(ModItems.TORTILLA), ItemTranslation.of(ModItems.BURRITO),
			ItemTranslation.of(ModItems.FRIED_EGG), ItemTranslation.of(ModItems.PEARFRUIT, null, "As good as gold.", PEARFRUIT),
			ItemTranslation.of(ModItems.PEARFRUIT_JUICE, null, PEARFRUIT), ItemTranslation.of(ModItems.APPLE_JUICE), ItemTranslation.of(ModItems.GOLDEN_APPLE_JUICE),
			ItemTranslation.of(ModItems.SWEET_BERRY_JUICE), ItemTranslation.of(ModItems.MIDAS_FRUIT, null, "22 karats", SHINY_GOLD),
			ItemTranslation.of(ModItems.BROWNIE), ItemTranslation.of(ModItems.CHORUS_COBBLER), ItemTranslation.of(ModItems.SANDFISH),
			ItemTranslation.of(ModItems.COOKED_SANDFISH), ItemTranslation.of(ModItems.DUNE_EEL), ItemTranslation.of(ModItems.SMOKED_FISH, null, SMOKED_FISH));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, STARSTEEL), ItemTranslation.of(TechItems.EMPTY_CAN),
			ItemTranslation.of(TechItems.BEETROOT_SOUP_CAN, "Can of Beetroot Soup"), ItemTranslation.of(TechItems.MUSHROOM_STEW_CAN, "Can of Mushroom Stew"),
			ItemTranslation.of(TechItems.RABBIT_STEW_CAN, "Can of Rabbit Stew"), ItemTranslation.of(TechItems.MILK_CAN, "Can of Evaporated Milk"),
			ItemTranslation.of(TechItems.COLA_ORANGE, "Can of A&L"), ItemTranslation.of(TechItems.COLA_GREEN, "Can of Trola-Cola"),
			ItemTranslation.of(TechItems.COLA_CYAN, "Can of AquaDei Lite"));

        generateItems(translationBuilder, ItemTranslation.of(ModItems.BROWNIE, null, "Comes from outer space?", null));
        generateItems(translationBuilder, ItemTranslation.of(ModItems.CHORUS_COBBLER, null, "Memah's favorite recipe", CHORUS));
        generateItems(translationBuilder, ItemTranslation.of(ModItems.SANDFISH, null, "This isn't a fish...", DUNE_TAN));
        generateItems(translationBuilder, ItemTranslation.of(ModItems.COOKED_SANDFISH, null, DUNE_TAN));
        generateItems(translationBuilder, ItemTranslation.of(ModItems.DUNE_EEL, null, "Isn't this a snake?", DUNE_TAN));

		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, FLESH_PINK),
			ItemTranslation.of(ModBlocks.FLESH_BLOCK, null, "It's strangely warm...", FLESH_PINK),
			ItemTranslation.of(ModBlocks.FLESH_VEINS, null, "They're spreading...", FLESH_PINK),
			ItemTranslation.of(ModBlocks.FLESHY_EYE, null, "It's staring...", FLESH_PINK),
			ItemTranslation.of(MagicItems.EYE_OF_RUIN, null, "What a troubling gaze...", FLESH_PINK),
			ItemTranslation.of(MagicItems.DUBIOUS_BACON, null, "Don't ask where it came from...", FLESH_PINK));

		generateItems(translationBuilder, ItemTranslation.of(ModItems.REDSTONE_CRYSTAL, "Crystallized Redstone", "Sparkles with potential.", BLOOD_RED));
		generateItems(translationBuilder, ItemTranslation.of(ModItems.BLOOD_DIAMOND, null, "Chaos itself shines through.", BLOOD_RED));
		generateItems(translationBuilder, ItemTranslation.of(ModItems.ASH, "Wither Ash", "Contains traces of dark magic.", TRANQUIL));
		generateItems(translationBuilder, ItemTranslation.of(ModItems.TRANQUIL_DUST, "Tranquil Pollen", "Useful in dark alchemy.", TRANQUIL));
		generateItems(translationBuilder, ItemTranslation.of(MagicItems.DEMONIC_CORE, "Demonic Core", "Use while crouching to bind to a location!", LIGHT_PURPLE));
        generateItems(translationBuilder, ItemTranslation.of(TechItems.DISTANCE_TRACKER, "Lifeform Tracker", "Use on a mob to track it.", SCRAP_METAL));
        generateItems(translationBuilder, ItemTranslation.of(TechItems.ENERGY_CELL, null, null, null));
        generateItems(translationBuilder, ItemTranslation.of(TechItems.GAS_CAPSULE, null, null, GAS_TEST));
		generateItems(translationBuilder, ItemTranslation.of(MagicItems.QUICKSAND_BUCKET));

		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, SENTINEL_AQUA_T1),
			ItemTranslation.of(TechItems.HARD_LIGHT_PROJECTOR, "Hard Light Projector"), ItemTranslation.of(ModBlocks.HARD_LIGHT, "Hard Light"),
			ItemTranslation.of(ModBlocks.HARD_LIGHT_BARRIER, "Hard Light Barrier", "Creative only!", null),
			ItemTranslation.of(TechItems.HOLOGRAPHIC_SIGN, "Holographic Sign"),
			ItemTranslation.of(TechItems.HOLOGRAPHIC_HANGING_SIGN, "Holographic Hanging Sign"));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, SENTINEL_GOLD_T1),
			ItemTranslation.of(TechItems.CAUTION_HARD_LIGHT_PROJECTOR, "Hard Light Projector"), ItemTranslation.of(ModBlocks.CAUTION_HARD_LIGHT, "Hard Light"),
			ItemTranslation.of(ModBlocks.CAUTION_HARD_LIGHT_BARRIER, "Hard Light Barrier", "Creative only!", null),
			ItemTranslation.of(TechItems.CAUTION_HOLOGRAPHIC_SIGN, "Holographic Sign"),
			ItemTranslation.of(TechItems.CAUTION_HOLOGRAPHIC_HANGING_SIGN, "Holographic Hanging Sign"));
		generateItemsWithParent(translationBuilder, ItemTranslation.of(null, null, SENTINEL_CRIMSON_T1),
			ItemTranslation.of(TechItems.SENTINEL_HARD_LIGHT_PROJECTOR, "Hard Light Projector"), ItemTranslation.of(ModBlocks.SENTINEL_HARD_LIGHT, "Hard Light"),
			ItemTranslation.of(ModBlocks.SENTINEL_HARD_LIGHT_BARRIER, "Hard Light Barrier", "Creative only!", null),
			ItemTranslation.of(TechItems.SENTINEL_HOLOGRAPHIC_SIGN, "Holographic Sign"),
			ItemTranslation.of(TechItems.SENTINEL_HOLOGRAPHIC_HANGING_SIGN, "Holographic Hanging Sign"));
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
			ItemTranslation.of(ModBlocks.OVERGROWN_GRASS_BLOCK), ItemTranslation.of(ModBlocks.GRASS_STAIRS), ItemTranslation.of(ModBlocks.GRASS_SLAB),
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

        translationBuilder.add(ModEntities.SCRAP_METAL_SHARD, ModItems.SCRAP_METAL_SHARD.getTranslationKey());
        translationBuilder.add(ModEntities.LASER_BEAM, "Laser Beam");
        translationBuilder.add(ModEntities.GRENADE, "Delayed Explosive");
        translationBuilder.add(ModEntities.SENTINEL, "Sentinel");
        translationBuilder.add(ModEntities.GALINITE_ROOMBA, "Sentinel Cleaning Droid");
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

		translationBuilder.add("tooltip." + MOD_ID + ".set_bonus_active", "Set bonus active!");
		translationBuilder.add("tooltip." + MOD_ID + ".set_bonus_inactive", "Set bonus inactive!");
        translationBuilder.add("tooltip." + MOD_ID + ".style", "Style: ");
        translationBuilder.add("tooltip." + MOD_ID + ".mode", "Mode: ");
        generateNumbered(translationBuilder, "tooltip." + MOD_ID + ".style_switch.", " to switch style.", " to cycle modes.");
        generateNumbered(translationBuilder, "style.item." + MOD_ID + ".pappym_blade.", "Trickster", "Paladin", "Predator", "Guardian");
        generateNumbered(translationBuilder, "style.item." + MOD_ID + ".thanatu_blade.", "Riftwalker", "Riftcaller");
        generateNumbered(translationBuilder, "style.item." + MOD_ID + ".lilith_blade.", "Holy Retribution", "ENDLESS LIGHT");
        generateNumbered(translationBuilder, "style.item." + MOD_ID + ".gun.", "Manual", "Semi-Auto ▽", "Automatic ▽△");

        if (dataOutput.getModContainer().findPath("assets/trevorssentinels/lang/en_us.existing.json").isPresent()) try {
            translationBuilder.add(dataOutput.getModContainer().findPath("assets/trevorssentinels/lang/en_us.existing.json").get());
        } catch (Exception e) { throw new RuntimeException("Failed to add existing language file!", e); }
    }
}