package net.trevorskullcrafter.trevorssentinels.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.effect.ModEffects;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import net.trevorskullcrafter.trevorssentinels.item.*;
import net.trevorskullcrafter.trevorssentinels.sound.ModSounds;
import net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain.MOD_ID;
import static net.trevorskullcrafter.trevorssentinels.util.LangGenUtils.*;
import static net.trevorskullcrafter.trevorssentinels.util.LangGenUtils.stringToJsonArray;
import static net.trevorskullcrafter.trevorssentinels.util.TextUtil.*;

public class EnglishLangGenerator extends JsonLanguageProvider {
    public EnglishLangGenerator(FabricDataOutput dataOutput) { super(dataOutput, "en_us"); }

	@Override public void generateRichTranslations(JsonTranslationBuilder translationBuilder) {
		//Magic Equipment
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(VIRIDIAN), new ItemTranslation(TSItems.Magic.DRYADIC_HELMET),
			new ItemTranslation(TSItems.Magic.DRYADIC_CHESTPLATE), new ItemTranslation(TSItems.Magic.DRYADIC_LEGGINGS), new ItemTranslation(TSItems.Magic.DRYADIC_BOOTS),
			new ItemTranslation(TSItems.Magic.DRYADIC_SWORD), new ItemTranslation(TSItems.Magic.DRYADIC_DAGGER), new ItemTranslation(TSItems.Magic.ENCHANTED_LEAF));
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(ROSE_GOLD), new ItemTranslation(TSItems.Magic.ROSE_GOLD_INGOT),
			new ItemTranslation(ModBlocks.ROSE_GOLD_BLOCK).name("Block of Rose Gold"), new ItemTranslation(TSItems.Magic.ROSE_GOLD_HELMET),
			new ItemTranslation(TSItems.Magic.ROSE_GOLD_CHESTPLATE).name("Rose Gold Cuirass"), new ItemTranslation(TSItems.Magic.ROSE_GOLD_LEGGINGS),
			new ItemTranslation(TSItems.Magic.ROSE_GOLD_BOOTS), new ItemTranslation(TSItems.Magic.ROSE_GOLD_SWORD), new ItemTranslation(TSItems.Magic.ROSE_GOLD_DAGGER),
			new ItemTranslation(TSItems.Magic.ROSE_GOLD_PICKAXE), new ItemTranslation(TSItems.Magic.ROSE_GOLD_BATTLEAXE), new ItemTranslation(TSItems.Magic.ROSE_GOLD_SHOVEL),
			new ItemTranslation(TSItems.Magic.ROSE_GOLD_SICKLE).tooltip("Functions as a Hoe."));
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(VIRIDIAN), new ItemTranslation(TSItems.Magic.DRUIDIC_HELMET),
			new ItemTranslation(TSItems.Magic.DRUIDIC_CHESTPLATE), new ItemTranslation(TSItems.Magic.DRUIDIC_LEGGINGS), new ItemTranslation(TSItems.Magic.DRUIDIC_BOOTS),
			new ItemTranslation(TSItems.Magic.DRUIDIC_SWORD), new ItemTranslation(TSItems.Magic.DRUIDIC_DAGGER), new ItemTranslation(TSItems.Magic.DRUIDIC_BOW),
			new ItemTranslation(TSItems.Magic.DRUIDIC_GEM));
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(IMPERIAL_ALLOY), new ItemTranslation(TSItems.Magic.IMPERIAL_ALLOY_INGOT),
			new ItemTranslation(ModBlocks.IMPERIAL_ALLOY_BLOCK).name("Block of Imperial Alloy"), new ItemTranslation(TSItems.Magic.IMPERIAL_HELMET),
			new ItemTranslation(TSItems.Magic.IMPERIAL_CHESTPLATE), new ItemTranslation(TSItems.Magic.IMPERIAL_LEGGINGS), new ItemTranslation(TSItems.Magic.IMPERIAL_BOOTS),
			new ItemTranslation(TSItems.Magic.IMPERIAL_SWORD), new ItemTranslation(TSItems.Magic.IMPERIAL_GLADIUS), new ItemTranslation(TSItems.Magic.IMPERIAL_PICKAXE),
			new ItemTranslation(TSItems.Magic.IMPERIAL_BATTLEAXE), new ItemTranslation(TSItems.Magic.IMPERIAL_SHOVEL),
			new ItemTranslation(TSItems.Magic.IMPERIAL_SICKLE).tooltip("Functions as a Hoe."));
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(LIGHT_PURPLE),
			new ItemTranslation(TSItems.Magic.THANATU_HELMET).name("Macabre Skull").tooltip("The skull of the demon king."),
			new ItemTranslation(TSItems.Magic.THANATU_CHESTPLATE).name("Macabre Shoulderpads"), new ItemTranslation(TSItems.Magic.THANATU_LEGGINGS).name("Macabre Loincloth"),
			new ItemTranslation(TSItems.Magic.THANATU_BOOTS).name("Macabre Sandals"));
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(LIGHT_PURPLE), new ItemTranslation(TSItems.Magic.UNHOLY_SHARDS),
			new ItemTranslation(TSItems.Magic.UNHOLY_INGOT).tooltip("Reflects only the light in darkness."),
			new ItemTranslation(ModBlocks.UNHOLY_BLOCK).name("Block of Unholy Alloy"), new ItemTranslation(TSItems.Magic.UNHOLY_HELMET),
			new ItemTranslation(TSItems.Magic.UNHOLY_CHESTPLATE).name("Unholy Cuirass"), new ItemTranslation(TSItems.Magic.UNHOLY_LEGGINGS),
			new ItemTranslation(TSItems.Magic.UNHOLY_BOOTS), new ItemTranslation(TSItems.Magic.UNHOLY_SWORD), new ItemTranslation(TSItems.Magic.UNHOLY_DAGGER),
			new ItemTranslation(TSItems.Magic.UNHOLY_PICKAXE), new ItemTranslation(TSItems.Magic.UNHOLY_BATTLEAXE), new ItemTranslation(TSItems.Magic.UNHOLY_SHOVEL),
			new ItemTranslation(TSItems.Magic.UNHOLY_SICKLE).tooltip("Functions as a Hoe."));
		translationBuilder.add(new ItemTranslation(TSItems.Magic.ARMA_DEI_HELMET), new ItemTranslation(TSItems.Magic.ARMA_DEI_CHESTPLATE),
			new ItemTranslation(TSItems.Magic.ARMA_DEI_LEGGINGS), new ItemTranslation(TSItems.Magic.ARMA_DEI_BOOTS), new ItemTranslation(TSItems.Magic.ARMA_DEI_SWORD),
			new ItemTranslation(TSItems.Magic.ARMA_DEI_DAGGER), new ItemTranslation(TSItems.Magic.ARMA_DEI_PICKAXE), new ItemTranslation(TSItems.Magic.ARMA_DEI_BATTLEAXE),
			new ItemTranslation(TSItems.Magic.ARMA_DEI_SHOVEL), new ItemTranslation(TSItems.Magic.ARMA_DEI_SICKLE).tooltip("Functions as a Hoe."));

		translationBuilder.add(new ItemTranslation(ModBlocks.WAX_INFUSED_COPPER_BLOCK).name("Wax-Infused Block of Copper"));
		translationBuilder.add(new ItemTranslation(ModBlocks.STARSTEEL_LAMP));
		translationBuilder.add(new ItemTranslation(ModBlocks.STARSTEEL_FAN));
		translationBuilder.add(new ItemTranslation(ModBlocks.BATTERY));
		translationBuilder.add(new ItemTranslation(ModBlocks.FUSEBOX));
		translationBuilder.add(new ItemTranslation(ModBlocks.FANCY_COMPUTER));
		translationBuilder.add(new ItemTranslation(ModBlocks.BLACK_AGILITY_BLOCK).name("Steel Magno-Repulsion Block").tooltip("Watch your step."));
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(SENTINEL_CRIMSON_T1), new ItemTranslation(ModBlocks.BIG_RED_BUTTON),
			new ItemTranslation(ModBlocks.BIG_RED_PLATE).tooltip("1500 Megawatt Super Colliding Super Plate"));

		//Tech Equipment
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(SCRAP_METAL), new ItemTranslation(TSItems.Tech.SCRAP_METAL_SHARD),
			new ItemTranslation(ModBlocks.SCRAP_METAL_BLOCK), new ItemTranslation(ModBlocks.CHISELED_SCRAP_METAL_BLOCK), new ItemTranslation(ModBlocks.SCRAP_METAL_PILLAR),
			new ItemTranslation(TSItems.Tech.SCRAP_METAL_HELMET),
			new ItemTranslation(TSItems.Tech.SCRAP_METAL_CHESTPLATE), new ItemTranslation(TSItems.Tech.SCRAP_METAL_LEGGINGS), new ItemTranslation(TSItems.Tech.SCRAP_METAL_BOOTS),
			new ItemTranslation(TSItems.Tech.SCRAP_METAL_SWORD), new ItemTranslation(TSItems.Tech.SCRAP_METAL_KNIFE), new ItemTranslation(TSItems.Tech.SCRAP_METAL_DRILL),
			new ItemTranslation(TSItems.Tech.SCRAP_METAL_CHAINSAW).tooltip("Right click to launch shards at enemies!"),
			new ItemTranslation(TSItems.Tech.SCRAP_METAL_SHOVEL), new ItemTranslation(TSItems.Tech.SCRAP_METAL_HOE), new ItemTranslation(TSItems.Tech.SCRAP_METAL_PHASER));
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(STARSTEEL), new ItemTranslation(TSItems.Tech.INDUSTRIAL_HELMET),
			new ItemTranslation(TSItems.Tech.INDUSTRIAL_HARNESS), new ItemTranslation(TSItems.Tech.INDUSTRIAL_PANTS), new ItemTranslation(TSItems.Tech.INDUSTRIAL_BOOTS),
			new ItemTranslation(TSItems.Tech.INDUSTRIAL_CROWBAR).tooltip("Rise, and... shine."), new ItemTranslation(TSItems.Tech.INDUSTRIAL_PHASER));
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(STARSTEEL), new ItemTranslation(TSItems.Tech.STARSTEEL_INGOT),
			new ItemTranslation(ModBlocks.STARSTEEL_BLOCK).name("Block of Starsteel"), new ItemTranslation(ModBlocks.CHISELED_STARSTEEL_BLOCK).name("Chiseled Block of Starsteel"),
			new ItemTranslation(ModBlocks.STAINLESS_STEEL_BLOCK), new ItemTranslation(ModBlocks.STARSTEEL_LADDER), new ItemTranslation(TSItems.Tech.STARSTEEL_SIGN),
			new ItemTranslation(TSItems.Tech.STARSTEEL_HANGING_SIGN), new ItemTranslation(TSItems.Tech.STARSTEEL_HELMET), new ItemTranslation(TSItems.Tech.STARSTEEL_CHESTPLATE),
			new ItemTranslation(TSItems.Tech.STARSTEEL_LEGGINGS), new ItemTranslation(TSItems.Tech.STARSTEEL_BOOTS), new ItemTranslation(TSItems.Tech.STARSTEEL_SWORD),
			new ItemTranslation(TSItems.Tech.STARSTEEL_KNIFE), new ItemTranslation(TSItems.Tech.STARSTEEL_DRILL), new ItemTranslation(TSItems.Tech.STARSTEEL_AXE),
			new ItemTranslation(TSItems.Tech.STARSTEEL_SHOVEL), new ItemTranslation(TSItems.Tech.STARSTEEL_HOE), new ItemTranslation(TSItems.Tech.STARSTEEL_PHASER));
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(NUCLEAR), new ItemTranslation(TSItems.Tech.NUCLEAR_INGOT),
			new ItemTranslation(ModBlocks.NUCLEAR_ORE), new ItemTranslation(ModBlocks.NUCLEAR_BLOCK).name("Nuclear Storage Block"), new ItemTranslation(TSItems.Tech.NUCLEAR_ROCKET),
			new ItemTranslation(TSItems.Tech.NUCLEAR_HELMET), new ItemTranslation(TSItems.Tech.NUCLEAR_CHESTPLATE), new ItemTranslation(TSItems.Tech.NUCLEAR_LEGGINGS),
			new ItemTranslation(TSItems.Tech.NUCLEAR_BOOTS), new ItemTranslation(TSItems.Tech.NUCLEAR_SWORD).tooltip("Irradiates enemies."),
			new ItemTranslation(TSItems.Tech.NUCLEAR_VIBROKNIFE).tooltip("Irradiates enemies."), new ItemTranslation(TSItems.Tech.NUCLEAR_DRILL),
			new ItemTranslation(TSItems.Tech.NUCLEAR_AXE), new ItemTranslation(TSItems.Tech.NUCLEAR_SHOVEL), new ItemTranslation(TSItems.Tech.NUCLEAR_HOE),
			new ItemTranslation(TSItems.Tech.NUCLEAR_PHASER));
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(BLOOD_RED), new ItemTranslation(TSItems.Tech.NANOTECH_CAPSULE),
			new ItemTranslation(ModBlocks.NANOTECH_BLOCK).name("Nanotech Storage Block"), new ItemTranslation(TSItems.Tech.NANOTECH_HELMET),
			new ItemTranslation(TSItems.Tech.NANOTECH_CHESTPLATE), new ItemTranslation(TSItems.Tech.NANOTECH_LEGGINGS), new ItemTranslation(TSItems.Tech.NANOTECH_BOOTS),
			new ItemTranslation(TSItems.Tech.NANOTECH_SWORD).tooltip("\"I've even forgotten my name...\""),
			new ItemTranslation(TSItems.Tech.NANOTECH_VIBROKNIFE), new ItemTranslation(TSItems.Tech.NANOTECH_DRILL), new ItemTranslation(TSItems.Tech.NANOTECH_AXE),
			new ItemTranslation(TSItems.Tech.NANOTECH_SHOVEL), new ItemTranslation(TSItems.Tech.NANOTECH_HOE), new ItemTranslation(TSItems.Tech.NANOTECH_PHASER));

		//Transcendent Equipment
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(DARK_GREEN),
			new ItemTranslation(TSItems.Tech.ZENITHIUM_CLUSTER).tooltip("The concentrated essence of a galaxy."),
			new ItemTranslation(TSItems.Tech.ZENITHIUM_HELMET), new ItemTranslation(TSItems.Tech.ZENITHIUM_CHESTPLATE), new ItemTranslation(TSItems.Tech.ZENITHIUM_LEGGINGS),
			new ItemTranslation(TSItems.Tech.ZENITHIUM_BOOTS), new ItemTranslation(TSItems.Tech.ZENITHIUM_SWORD), new ItemTranslation(TSItems.Tech.ZENITHIUM_DAGGER),
			new ItemTranslation(TSItems.Tech.ZENITHIUM_PICKAXE), new ItemTranslation(TSItems.Tech.ZENITHIUM_AXE), new ItemTranslation(TSItems.Tech.ZENITHIUM_SHOVEL),
			new ItemTranslation(TSItems.Tech.ZENITHIUM_HOE), new ItemTranslation(TSItems.Tech.ZENITHIUM_PHASER));

		translationBuilder.add(new ItemTranslation(TSItems.Magic.COPPER_GLADIUS).tooltip("An ornamental blade of goblin tradition.").color(COPPER));
		//Blacksmith's Welding Mask, Mad Scientist's Lab Coat

        translationBuilder.add(
			new ItemTranslation(TSItems.Beta.PAPPYM_BLADE).name("Jade Seraphim")
				.tooltip("Passed down through ancient tradition... and now it has found its way to you.").color(GREEN),
			new ItemTranslation(TSItems.Beta.PAPPYD_BLADE).name("Hell's Flaming Fury").color(HELLFIRE),
			new ItemTranslation(TSItems.Beta.THANATU_BLADE).name("Harmonious Rapture").color(LIGHT_PURPLE),
			new ItemTranslation(TSItems.Beta.SKYLAR_BLADE).name("Equitous Retribution").color(SHINY_GOLD),
			new ItemTranslation(TSItems.Beta.LILITH_BLADE).name("Unwavering Judgement").color(DUNE_TAN),
			new ItemTranslation(TSItems.Beta.KINGS_BLADE).name("Stainless Resolve").color(WHITE),
			new ItemTranslation(ModArmory.SCARA_SHEARS).name("SCARA Shears").tooltip("A military-grade threat.").color(DARK_PURPLE),
			new ItemTranslation(ModArmory.MASTER_SWORD).name("The Master's Sword").tooltip("From a distant universe...").color(AQUA));
        translationBuilder.add(new ItemTranslation(TSItems.Tech.VILE_SPITTER).tooltip("It's alive!").color(FLESH_PINK));

		/*new ItemTranslation(TSItems.Tech.LASER_PISTOL, "NUMA-28 Comet", "\"Fast and portable!\"", STARSTEEL),
		new ItemTranslation(TSItems.Tech.LASER_TASER, "Enforcer-Standard Taser", "\"Non-lethal.\"", AQUA),
		new ItemTranslation(TSItems.Tech.LASER_SNIPER_ECHO, "NUMA-52 Echo", "\"They'll never see it coming!\"", DUNE_TAN),
		new ItemTranslation(TSItems.Tech.LASER_MINIGUN, "UTARI-91 Serenity", "\"Keep the peace!\"", BLUE),
		new ItemTranslation(TSItems.Tech.LASER_RIFLE, "NUMA-63 Agnostyk", "\"Packs a punch!\"", MOSS),
		new ItemTranslation(TSItems.Tech.LASER_SHOTGUN, "KHAOS-66 Tremor", "\"Rip and tear!\"", HELLFIRE),
		new ItemTranslation(TSItems.Tech.LASER_HEALER, "PW49 Firebird", "\"Those who can't do, heal!\"", SHINY_GOLD),
		new ItemTranslation(TSItems.Tech.LASER_SNIPER, "PW88 Shadow", "\"The assassin's weapon of choice!\"", DARK_PURPLE),
		new ItemTranslation(TSItems.Tech.LASER_SPREADER, "PW76 Pandemic", "\"Filled with a toxic bioweapon.\"", GREEN),
		new ItemTranslation(TSItems.Tech.LASER_REVOLVER, "Drunkard's Handcannon", "\"But you have heard of me!\"", null),*/

		translationBuilder.add(
			new ItemTranslation(TSItems.Tech.PAINT_PACK),
			new ItemTranslation(TSItems.Tech.PHOTONIC_LENS),
			new ItemTranslation(TSItems.Tech.COUNTERFORCE_DIFFUSER),
			new ItemTranslation(TSItems.Tech.PHASE_ASSIMILATOR),
			new ItemTranslation(TSItems.Tech.SMOKE_CAPSULE),
			new ItemTranslation(TSItems.Tech.POISON_CAPSULE),
			new ItemTranslation(TSItems.Tech.WITHER_CAPSULE),
			new ItemTranslation(TSItems.Tech.REGENERATION_CAPSULE));
		translationBuilder.add(
			new ItemTranslation(TSItems.Magic.RESISTANCE_ITEM).name("Shield Badge").color(GRAY),
			new ItemTranslation(TSItems.Magic.FIRE_RESISTANCE_ITEM).name("Flaming Badge").color(HELLFIRE), //shield badge, fire stuff
			new ItemTranslation(TSItems.Magic.JUMP_BOOST_ITEM).name("Icarus' Gust").color(NUCLEAR),
			new ItemTranslation(TSItems.Magic.STRENGTH_ITEM).name("Sword Badge").color(GRAY), //shattered sword, iron ingots?
			new ItemTranslation(TSItems.Magic.WEAKNESS_ITEM).name("Shattered Sword").tooltip("A reminder of past failures."),
			new ItemTranslation(TSItems.Magic.REGENERATION_ITEM).name("Ever-Beating Heart"), //leviathan stuff
			new ItemTranslation(TSItems.Magic.WATER_BREATHING_ITEM).name("Abyssal Bubbles"),
			new ItemTranslation(TSItems.Magic.INVISIBILITY_ITEM).name("Vampire's Mirror"),
			new ItemTranslation(TSItems.Magic.DOLPHINS_GRACE_ITEM).name("Foam Dolphin Plush").tooltip("Its silky skin makes one feel hydrodynamic.").color(DOLPHIN),
			new ItemTranslation(TSItems.Magic.CONDUIT_POWER_ITEM).name("Eye of the Sea"),
			new ItemTranslation(TSItems.Magic.NIGHT_VISION_ITEM).name("Feline Eye"),
			new ItemTranslation(TSItems.Magic.HERO_OF_THE_VILLAGE_ITEM).name("Hero's Emerald").tooltip("Gifted to heroes of legend.").color(NUCLEAR),
			new ItemTranslation(TSItems.Magic.PALADINS_BADGE).tooltip("The mark of a true warrior of light.").color(SHINY_GOLD), //flaming badge, sword badge
			new ItemTranslation(TSItems.Magic.CYBERNETIC_STOMACH).color(SCRAP_METAL),
			new ItemTranslation(TSItems.Magic.ONE_PENCE).name("The One Pence").tooltip("Wealth, Fame, Power.").color(COPPER));

		translationBuilder.add(
			new ItemTranslation(ModItems.SENTINEL_SPAWN_EGG).name("Sentinel Spawn Beacon").tooltip("A mindless drone for the hive.").color(SCRAP_METAL),
			new ItemTranslation(ModItems.ROOMBA_SPAWN_EGG).name("Sentinel Cleaning Droid").tooltip("Once a human, now a living sanitizer.").color(SCRAP_METAL),
			new ItemTranslation(ModItems.FLORBUS_SPAWN_EGG).name("Florbus Spawn Sac"));
		translationBuilder.add(new ItemTranslation(ModItems.VENDOR_TOKEN).color(VENDOR_TOKEN), new ItemTranslation(ModItems.LEGENDARY_TOKEN));

		translationBuilder.addMusicDisc(new ItemTranslation(TSItems.Tech.MUSIC_DISC_ASSASSINATION_UPLOAD).name("Scrapped Cassette"),
			stringToJsonArray("Kristoffer Kaufmann - Assassination Upload"), ModSounds.ASSASSINATION_UPLOAD);
		translationBuilder.addMusicDisc(new ItemTranslation(TSItems.Tech.MUSIC_DISC_ODE_TO_TRANQUILITY).name("Music Disc"),
			stringToJsonArray("Kristoffer Kaufmann - Ode to Tranquility"), ModSounds.ODE_TO_TRANQUILITY);
		translationBuilder.addMusicDisc(new ItemTranslation(TSItems.Tech.MUSIC_DISC_LAPSE_IN_JUDGEMENT).name("War-Torn Music Disc"),
			stringToJsonArray("Kristoffer Kaufmann - Lapse in Judgement"), ModSounds.LAPSE_IN_JUDGEMENT);
		translationBuilder.addMusicDisc(new ItemTranslation(TSItems.Tech.MUSIC_DISC_RECITAL).name("Aged Cassette").tooltip("It's in remarkably good condition."),
			stringToJsonArray("Trevor Skullcrafter - recital"), ModSounds.RECITAL);

		//Wood
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(YGGDRASIL), new ItemTranslation(ModBlocks.PALE_LOG),
			new ItemTranslation(ModBlocks.PALE_WOOD), new ItemTranslation(ModBlocks.STRIPPED_PALE_LOG), new ItemTranslation(ModBlocks.STRIPPED_PALE_WOOD),
			new ItemTranslation(ModBlocks.PALE_PLANKS), new ItemTranslation(ModBlocks.PALE_LEAVES), new ItemTranslation(ModBlocks.PALE_SAPLING),
			new ItemTranslation(ModBlocks.POTTED_PALE_SAPLING), new ItemTranslation(ModBlocks.PALE_SLAB), new ItemTranslation(ModBlocks.PALE_STAIRS),
			new ItemTranslation(ModBlocks.PALE_FENCE), new ItemTranslation(ModBlocks.PALE_FENCE_GATE), new ItemTranslation(ModBlocks.PALE_BUTTON),
			new ItemTranslation(ModBlocks.PALE_PRESSURE_PLATE), new ItemTranslation(ModBlocks.PALE_DOOR), new ItemTranslation(ModBlocks.PALE_TRAPDOOR),
			new ItemTranslation(ModBlocks.PALE_SIGN), new ItemTranslation(ModBlocks.PALE_HANGING_SIGN), new ItemTranslation(TSItems.Magic.PALE_BOAT),
			new ItemTranslation(TSItems.Magic.PALE_CHEST_BOAT));
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(CHARRED), new ItemTranslation(ModBlocks.CHARRED_LOG),
			new ItemTranslation(ModBlocks.CHARRED_WOOD), new ItemTranslation(ModBlocks.STRIPPED_CHARRED_LOG), new ItemTranslation(ModBlocks.STRIPPED_CHARRED_WOOD),
			new ItemTranslation(ModBlocks.CHARRED_PLANKS), null, null, null, new ItemTranslation(ModBlocks.CHARRED_SLAB), new ItemTranslation(ModBlocks.CHARRED_STAIRS),
			new ItemTranslation(ModBlocks.CHARRED_FENCE), new ItemTranslation(ModBlocks.CHARRED_FENCE_GATE), new ItemTranslation(ModBlocks.CHARRED_BUTTON),
			new ItemTranslation(ModBlocks.CHARRED_PRESSURE_PLATE), new ItemTranslation(ModBlocks.CHARRED_DOOR), new ItemTranslation(ModBlocks.CHARRED_TRAPDOOR),
			new ItemTranslation(ModBlocks.CHARRED_SIGN), new ItemTranslation(ModBlocks.CHARRED_HANGING_SIGN), new ItemTranslation(TSItems.Magic.CHARRED_BOAT),
			new ItemTranslation(TSItems.Magic.CHARRED_CHEST_BOAT));
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(MIDAS), new ItemTranslation(ModBlocks.MIDAS_LOG),
			new ItemTranslation(ModBlocks.MIDAS_WOOD), new ItemTranslation(ModBlocks.STRIPPED_MIDAS_LOG), new ItemTranslation(ModBlocks.STRIPPED_MIDAS_WOOD),
			new ItemTranslation(ModBlocks.MIDAS_PLANKS), new ItemTranslation(ModBlocks.MIDAS_LEAVES), new ItemTranslation(ModBlocks.MIDAS_SAPLING),
			new ItemTranslation(ModBlocks.POTTED_MIDAS_SAPLING), new ItemTranslation(ModBlocks.MIDAS_SLAB), new ItemTranslation(ModBlocks.MIDAS_STAIRS),
			new ItemTranslation(ModBlocks.MIDAS_FENCE), new ItemTranslation(ModBlocks.MIDAS_FENCE_GATE), new ItemTranslation(ModBlocks.MIDAS_BUTTON),
			new ItemTranslation(ModBlocks.MIDAS_PRESSURE_PLATE), new ItemTranslation(ModBlocks.MIDAS_DOOR), new ItemTranslation(ModBlocks.MIDAS_TRAPDOOR),
			new ItemTranslation(ModBlocks.MIDAS_SIGN), new ItemTranslation(ModBlocks.MIDAS_HANGING_SIGN), new ItemTranslation(TSItems.Magic.MIDAS_BOAT),
			new ItemTranslation(TSItems.Magic.MIDAS_CHEST_BOAT));
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(VIRIDIAN), new ItemTranslation(ModBlocks.VIRIDIAN_LOG),
			new ItemTranslation(ModBlocks.VIRIDIAN_WOOD), new ItemTranslation(ModBlocks.STRIPPED_VIRIDIAN_LOG), new ItemTranslation(ModBlocks.STRIPPED_VIRIDIAN_WOOD),
			new ItemTranslation(ModBlocks.VIRIDIAN_PLANKS), new ItemTranslation(ModBlocks.VIRIDIAN_LEAVES), new ItemTranslation(ModBlocks.VIRIDIAN_SAPLING),
			new ItemTranslation(ModBlocks.POTTED_VIRIDIAN_SAPLING), new ItemTranslation(ModBlocks.VIRIDIAN_SLAB), new ItemTranslation(ModBlocks.VIRIDIAN_STAIRS),
			new ItemTranslation(ModBlocks.VIRIDIAN_FENCE), new ItemTranslation(ModBlocks.VIRIDIAN_FENCE_GATE), new ItemTranslation(ModBlocks.VIRIDIAN_BUTTON),
			new ItemTranslation(ModBlocks.VIRIDIAN_PRESSURE_PLATE), new ItemTranslation(ModBlocks.VIRIDIAN_DOOR), new ItemTranslation(ModBlocks.VIRIDIAN_TRAPDOOR),
			new ItemTranslation(ModBlocks.VIRIDIAN_SIGN), new ItemTranslation(ModBlocks.VIRIDIAN_HANGING_SIGN), new ItemTranslation(TSItems.Magic.VIRIDIAN_BOAT),
			new ItemTranslation(TSItems.Magic.VIRIDIAN_CHEST_BOAT));
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(CERULII), new ItemTranslation(ModBlocks.CERULII_LOG),
			new ItemTranslation(ModBlocks.CERULII_WOOD), new ItemTranslation(ModBlocks.STRIPPED_CERULII_LOG), new ItemTranslation(ModBlocks.STRIPPED_CERULII_WOOD),
			new ItemTranslation(ModBlocks.CERULII_PLANKS), new ItemTranslation(ModBlocks.CERULII_LEAVES), new ItemTranslation(ModBlocks.CERULII_SAPLING),
			new ItemTranslation(ModBlocks.POTTED_CERULII_SAPLING), new ItemTranslation(ModBlocks.CERULII_SLAB), new ItemTranslation(ModBlocks.CERULII_STAIRS),
			new ItemTranslation(ModBlocks.CERULII_FENCE), new ItemTranslation(ModBlocks.CERULII_FENCE_GATE), new ItemTranslation(ModBlocks.CERULII_BUTTON),
			new ItemTranslation(ModBlocks.CERULII_PRESSURE_PLATE), new ItemTranslation(ModBlocks.CERULII_DOOR), new ItemTranslation(ModBlocks.CERULII_TRAPDOOR),
			new ItemTranslation(ModBlocks.CERULII_SIGN), new ItemTranslation(ModBlocks.CERULII_HANGING_SIGN), new ItemTranslation(TSItems.Magic.CERULII_BOAT),
			new ItemTranslation(TSItems.Magic.CERULII_CHEST_BOAT));

        translationBuilder.addStatusEffect(ModEffects.REDSTONED, stringToJsonArray("Redstoned"), true);
        translationBuilder.addStatusEffect(ModEffects.FLIGHT, stringToJsonArray("Flight"), true);
        translationBuilder.addStatusEffect(ModEffects.WELL_FED, stringToJsonArray("Well-Fed"), false);
        translationBuilder.addStatusEffect(ModEffects.COSMIC_FIRE, stringToJsonArray("Cosmic Flame"), false);
        translationBuilder.addStatusEffect(ModEffects.INFESTED, stringToJsonArray("☣ Infested ☣"), false);
        translationBuilder.addStatusEffect(ModEffects.IRRADIATED, stringToJsonArray("☢ Irradiated ☢"), false);

        translationBuilder.add(new ItemTranslation(ModItems.SALT).tooltip("Used for keeping meat fresh.").color(SALT));

		translationBuilder.addPottedPlant(ModBlocks.TRANQUIL_ROSE, ModBlocks.POTTED_TRANQUIL_ROSE, null, "Smells delightful.", TRANQUIL);
		translationBuilder.addPottedPlant(ModBlocks.SKULLWEED, ModBlocks.POTTED_SKULLWEED, null, "It's so cold...", SKULLWEED);

		translationBuilder.add(new ItemTranslation(ModItems.RICE_SEEDS), new ItemTranslation(ModItems.RICE_CAKE),
			new ItemTranslation(ModBlocks.RICE_PLANT), new ItemTranslation(ModBlocks.RICE_BLOCK));
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(SHINY_GOLD), new ItemTranslation(ModItems.MIDAS_FRUIT).tooltip("22 karats").color(SHINY_GOLD),
			new ItemTranslation(ModItems.GOLDEN_APPLE_JUICE), new ItemTranslation(ModItems.BANANA), new ItemTranslation(ModItems.BANANA_BREAD),
			new ItemTranslation(ModBlocks.FEATHERCORN).tooltip("Soft and warm."));
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(PEARFRUIT),
			new ItemTranslation(ModItems.PEARFRUIT).tooltip("As good as gold."), new ItemTranslation(ModItems.PEARFRUIT_JUICE));
		translationBuilder.add(new ItemTranslation(ModItems.SUSHI_ROLL), new ItemTranslation(ModItems.TORTILLA), new ItemTranslation(ModItems.BURRITO),
			new ItemTranslation(ModItems.FRIED_EGG), new ItemTranslation(ModItems.APPLE_JUICE), new ItemTranslation(ModItems.SWEET_BERRY_JUICE),
			new ItemTranslation(ModItems.SMOKED_FISH).color(SMOKED_FISH));
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(STARSTEEL), new ItemTranslation(TSItems.Tech.EMPTY_CAN),
			new ItemTranslation(TSItems.Tech.BEETROOT_SOUP_CAN).name("Can of Beetroot Soup"), new ItemTranslation(TSItems.Tech.MUSHROOM_STEW_CAN).name("Can of Mushroom Stew"),
			new ItemTranslation(TSItems.Tech.RABBIT_STEW_CAN).name("Can of Rabbit Stew"), new ItemTranslation(TSItems.Tech.MILK_CAN).name("Can of Evaporated Milk"),
			new ItemTranslation(TSItems.Tech.COLA_ORANGE).name("Can of A&L"), new ItemTranslation(TSItems.Tech.COLA_GREEN).name("Can of Trola-Cola"),
			new ItemTranslation(TSItems.Tech.COLA_CYAN).name("Can of AquaDei Lite"));

        translationBuilder.add(new ItemTranslation(ModItems.BROWNIE).tooltip("Comes from outer space?"));
        translationBuilder.add(new ItemTranslation(ModItems.CHORUS_COBBLER).tooltip("Memah's favorite recipe").color(CHORUS));
        translationBuilder.addItemsWithParent(new ItemTranslation(null).color(DUNE_TAN),
			new ItemTranslation(ModItems.SANDFISH).tooltip("This is not a fish..."), new ItemTranslation(ModItems.COOKED_SANDFISH),
			new ItemTranslation(ModItems.DUNE_EEL).tooltip("Isn't this a snake?"));

		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(FLESH_PINK),
			new ItemTranslation(ModBlocks.FLESH_BLOCK).tooltip("It's strangely warm..."),
			new ItemTranslation(ModBlocks.FLESH_VEINS).tooltip("They're spreading..."),
			new ItemTranslation(ModBlocks.FLESHY_EYE).tooltip("It's staring..."),
			new ItemTranslation(TSItems.Magic.EYE_OF_RUIN).tooltip("What a troubling gaze..."),
			new ItemTranslation(TSItems.Magic.DUBIOUS_BACON).tooltip("Don't ask where it came from..."));

		translationBuilder.add(new ItemTranslation(ModItems.REDSTONE_CRYSTAL).name("Crystallized Redstone").tooltip("Sparkles with potential.")
			.color(BLOOD_RED));
		translationBuilder.add(new ItemTranslation(ModItems.BLOOD_DIAMOND).tooltip("Chaos itself shines through.").color(BLOOD_RED));
		translationBuilder.add(new ItemTranslation(ModItems.ASH).name("Wither Ash").tooltip("Contains traces of dark magic.").color(TRANQUIL));
		translationBuilder.add(new ItemTranslation(ModItems.TRANQUIL_DUST).name("Tranquil Pollen").tooltip("Useful in dark alchemy.").color(TRANQUIL));
		translationBuilder.add(new ItemTranslation(TSItems.Magic.DEMONIC_CORE).name("Demonic Core").tooltip("Use while crouching to bind to a location!")
			.color(LIGHT_PURPLE));
        translationBuilder.add(new ItemTranslation(TSItems.Tech.DISTANCE_TRACKER).name("Lifeform Tracker").tooltip("Use on a mob to track it.")
			.color(SCRAP_METAL));
        translationBuilder.add(new ItemTranslation(TSItems.Tech.PLASMA_CELL).color(STARSTEEL));

		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(SENTINEL_AQUA_T1),
			new ItemTranslation(TSItems.Tech.HARD_LIGHT_PROJECTOR).name("Hard Light Projector"),
			new ItemTranslation(ModBlocks.HARD_LIGHT).name("Hard Light"),
			new ItemTranslation(ModBlocks.HARD_LIGHT_BARRIER).name("Hard Light Barrier").tooltip("Creative only!"),
			new ItemTranslation(TSItems.Tech.HOLOGRAPHIC_SIGN).name("Holographic Sign"),
			new ItemTranslation(TSItems.Tech.HOLOGRAPHIC_HANGING_SIGN).name("Holographic Hanging Sign"));
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(SENTINEL_GOLD_T1),
			new ItemTranslation(TSItems.Tech.CAUTION_HARD_LIGHT_PROJECTOR).name("Hard Light Projector"),
			new ItemTranslation(ModBlocks.CAUTION_HARD_LIGHT).name("Hard Light"),
			new ItemTranslation(ModBlocks.CAUTION_HARD_LIGHT_BARRIER).name("Hard Light Barrier").tooltip("Creative only!"),
			new ItemTranslation(TSItems.Tech.CAUTION_HOLOGRAPHIC_SIGN).name("Holographic Sign"),
			new ItemTranslation(TSItems.Tech.CAUTION_HOLOGRAPHIC_HANGING_SIGN).name("Holographic Hanging Sign"));
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(SENTINEL_CRIMSON_T1),
			new ItemTranslation(TSItems.Tech.SENTINEL_HARD_LIGHT_PROJECTOR).name("Hard Light Projector"),
			new ItemTranslation(ModBlocks.SENTINEL_HARD_LIGHT).name("Hard Light"),
			new ItemTranslation(ModBlocks.SENTINEL_HARD_LIGHT_BARRIER).name("Hard Light Barrier").tooltip("Creative only!"),
			new ItemTranslation(TSItems.Tech.SENTINEL_HOLOGRAPHIC_SIGN).name("Holographic Sign"),
			new ItemTranslation(TSItems.Tech.SENTINEL_HOLOGRAPHIC_HANGING_SIGN).name("Holographic Hanging Sign"));
		translationBuilder.add(new ItemTranslation(ModBlocks.CHAMBER_BLOCK), new ItemTranslation(ModBlocks.LIGHT_CHAMBER_BLOCK),
			new ItemTranslation(ModBlocks.DARK_CHAMBER_BLOCK), new ItemTranslation(ModBlocks.BLUE_AGILITY_BLOCK).color(SENTINEL_AQUA_T2),
			new ItemTranslation(ModBlocks.ORANGE_AGILITY_BLOCK).color(GOLD));

		//Foundation Blocks
		translationBuilder.add(new ItemTranslation(ModBlocks.CRACKED_END_STONE_BRICKS), new ItemTranslation(ModBlocks.CHISELED_END_STONE_BRICKS),
			new ItemTranslation(ModBlocks.END_STONE_BRICK_COLUMN));
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(LIGHT_PURPLE), new ItemTranslation(ModBlocks.IMPIOUS_END_STONE),
			new ItemTranslation(ModBlocks.IMPIOUS_END_STONE_BRICKS), new ItemTranslation(ModBlocks.CRACKED_IMPIOUS_END_STONE_BRICKS),
			new ItemTranslation(ModBlocks.CHISELED_IMPIOUS_END_STONE_BRICKS), new ItemTranslation(ModBlocks.IMPIOUS_END_STONE_BRICK_COLUMN));
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(LIGHT_PURPLE), new ItemTranslation(ModBlocks.DEIFIC_END_STONE),
			new ItemTranslation(ModBlocks.DEIFIC_END_STONE_BRICKS), new ItemTranslation(ModBlocks.CRACKED_DEIFIC_END_STONE_BRICKS),
			new ItemTranslation(ModBlocks.CHISELED_DEIFIC_END_STONE_BRICKS), new ItemTranslation(ModBlocks.DEIFIC_END_STONE_BRICK_COLUMN));
		translationBuilder.addItemsWithParent(new ItemTranslation(null).color(SNOWSTONE), new ItemTranslation(ModBlocks.SNOWSTONE),
			new ItemTranslation(ModBlocks.SNOWSTONE_STAIRS), new ItemTranslation(ModBlocks.SNOWSTONE_SLAB), new ItemTranslation(ModBlocks.SNOWSTONE_WALL),
			new ItemTranslation(ModBlocks.SMOOTH_SNOWSTONE), new ItemTranslation(ModBlocks.SMOOTH_SNOWSTONE_STAIRS), new ItemTranslation(ModBlocks.SMOOTH_SNOWSTONE_SLAB),
			new ItemTranslation(ModBlocks.SMOOTH_SNOWSTONE_WALL), new ItemTranslation(ModBlocks.CUT_SNOWSTONE),
			new ItemTranslation(ModBlocks.CUT_SNOWSTONE_SLAB), new ItemTranslation(ModBlocks.CHISELED_SNOWSTONE));
		translationBuilder.add(new ItemTranslation(ModBlocks.MOSS_STAIRS), new ItemTranslation(ModBlocks.MOSS_SLAB),
			new ItemTranslation(ModBlocks.DIRT_STAIRS), new ItemTranslation(ModBlocks.DIRT_SLAB), new ItemTranslation(ModBlocks.COARSE_DIRT_STAIRS),
			new ItemTranslation(ModBlocks.COARSE_DIRT_SLAB));

		translationBuilder.add(new ItemTranslation(ModBlocks.VENDOR));
		translationBuilder.add(new ItemTranslation(ModBlocks.RECONSTRUCTION_TABLE).color(SENTINEL_AQUA_T1));
		translationBuilder.add(new ItemTranslation(ModBlocks.MODIFICATION_TABLE));

        translationBuilder.add(ModSounds.FLESH_AMBIENT, stringToJsonArray("Flesh wriggles"));
        translationBuilder.add(ModSounds.BLASTER_SHOOT, stringToJsonArray("Shot laser"));
        translationBuilder.add(ModSounds.PISTOL_RELOAD, stringToJsonArray("Reloading"));
        translationBuilder.add(ModSounds.SHOTGUN_RELOAD, stringToJsonArray("Reloading"));
        translationBuilder.add(ModSounds.SNIPER_RELOAD, stringToJsonArray("Reloading"));
        translationBuilder.add(ModSounds.BIO_RELOAD, stringToJsonArray("Reloading"));
        translationBuilder.add(ModSounds.DATABASE_OPEN, stringToJsonArray("Codex opened"));
        translationBuilder.add(ModSounds.DATABASE_FLIP, stringToJsonArray("Codex flipped"));
        translationBuilder.add(ModSounds.NOTCH_UP, stringToJsonArray("Powering up"));

        translationBuilder.add(trevorssentinelsMain.SENTINELS.id(), toJsonArray(jsonTextComponent("Trevor's Sentinels", SENTINEL_AQUA_T1)));

        translationBuilder.add("trevorssentinels.database.name", "HoloCodex");
        translationBuilder.add("trevorssentinels.database.desc", "Your guide to this world of magic and technology, " +
			"this database will store all information that may be useful on your adventure.");

		translationBuilder.add("trevorssentinels", stringToJsonArray("Trevor's Sentinels"), stringToJsonArray("Obtain a Scrap Metal Shard"));
		translationBuilder.add("industrial", stringToJsonArray("Industrial"), stringToJsonArray("Obtain any industrial-tier item"));
		translationBuilder.add("ancient_metal", stringToJsonArray("Ancient Metal"), stringToJsonArray("Obtain an ingot of Imperial Alloy"));
		translationBuilder.add("ancient_metal2", stringToJsonArray("Good Soldiers Follow Orders"), stringToJsonArray("Obtain equipment made from Imperial Alloy"));
		translationBuilder.add("rose_gold", stringToJsonArray("Every Rose..."), stringToJsonArray("Obtain equipment made from Rose Gold"));
		translationBuilder.add("thanatu", stringToJsonArray("...Has its Thorn"), stringToJsonArray("Acquire the tools of the demon lord"));
		translationBuilder.add("cerberus", stringToJsonArray("False Idol"), stringToJsonArray("Defeat Cerberus, and release the seal on ancient forces"));
		translationBuilder.add("uranium", stringToJsonArray("Nuclear Age"), stringToJsonArray("Obtain equipment made from Nuclear Ingots"));
		translationBuilder.add("zenithium", stringToJsonArray("Infinity Squared"), stringToJsonArray("Acquire a cluster of Zenithium"));
		translationBuilder.add("zenithium2", stringToJsonArray("Infinity+1 Everything"), stringToJsonArray("\"Honey, where's my super suit?\""));

		translationBuilder.add("brownie", stringToJsonArray("This Edible Ain't Shi-"), stringToJsonArray("Consume a Brownie"));
		translationBuilder.add("chainsaw", stringToJsonArray("Chainsaws, Man"), stringToJsonArray("Craft a Scrap Metal Chainsaw"));
		translationBuilder.add("bacon_and_eggs", stringToJsonArray("Bacon and Eggs"), stringToJsonArray("Part of a complete breakfast!"));
		translationBuilder.add("spf", stringToJsonArray("SPF 50+"), stringToJsonArray("Obtain a Banana Boat"));

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

        translationBuilder.addNumbered(MOD_ID+".worldLevelTooLow.", stringToJsonArray(""),
			stringToJsonArray("Demonic power has too much of a hold over the world!"), stringToJsonArray("The power is too strong!"));
        translationBuilder.addNumbered("color."+MOD_ID+".worldLevelTooLow.", stringToJsonArray(""), stringToJsonArray(String.valueOf(LIGHT_PURPLE.getRGB())),
			stringToJsonArray(String.valueOf(BLUE.getRGB())));
        translationBuilder.add(MOD_ID+".worldLevelTooLow.other", "A mysterious force pushes back!");

        translationBuilder.add(ModEntities.SHARD_PROJECTILE, stringToJsonArray(TSItems.Tech.SCRAP_METAL_SHARD.getTranslationKey()));
        translationBuilder.add(ModEntities.PHASER_PROJECTILE, stringToJsonArray("Phaser Projectile"));
        translationBuilder.add(ModEntities.GRENADE, stringToJsonArray("Delayed Explosive"));
        translationBuilder.add(ModEntities.SENTINEL, stringToJsonArray("Sentinel"));
        translationBuilder.add(ModEntities.ROOMBA, stringToJsonArray("Sentinel Cleaning Droid"));
        translationBuilder.add(ModEntities.FLORBUS, stringToJsonArray("Florbus"));
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
        translationBuilder.addNumbered("tooltip." + MOD_ID + ".style_switch.", stringToJsonArray(" to switch style."), stringToJsonArray(" to cycle modes."));
        translationBuilder.addNumbered("style.item." + MOD_ID + ".pappym_blade.", stringToJsonArray("Trickster"), stringToJsonArray("Paladin"),
			stringToJsonArray("Predator"), stringToJsonArray("Guardian"));
        translationBuilder.addNumbered("style.item." + MOD_ID + ".thanatu_blade.", stringToJsonArray("Riftwalker"), stringToJsonArray("Riftcaller"));
        translationBuilder.addNumbered("style.item." + MOD_ID + ".lilith_blade.", stringToJsonArray("Holy Retribution"), stringToJsonArray("ENDLESS LIGHT"));
        translationBuilder.addNumbered("style.item." + MOD_ID + ".phaser.", stringToJsonArray("Reloading: Manual"), stringToJsonArray("Reloading: Automatic"));

        if (dataOutput.getModContainer().findPath("assets/trevorssentinels/lang/en_us.existing.json").isPresent()) try {
            translationBuilder.add(dataOutput.getModContainer().findPath("assets/trevorssentinels/lang/en_us.existing.json").get());
        } catch (Exception e) { throw new RuntimeException("Failed to add existing language file!", e); }
    }
}
