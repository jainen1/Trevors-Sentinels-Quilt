package net.trevorskullcrafter.trevorssentinels.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.effect.ModEffects;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import net.trevorskullcrafter.trevorssentinels.item.*;
import net.trevorskullcrafter.trevorssentinels.sound.ModSounds;
import net.trevorskullcrafter.trevorssentinels.util.JsonTextObject;

import java.awt.*;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain.MOD_ID;
import static net.trevorskullcrafter.trevorssentinels.util.TextUtil.*;

public class EnglishLangGenerator extends OwoLanguageProvider {
    public EnglishLangGenerator(FabricDataOutput dataOutput) { super(dataOutput, "en_us"); }

	@Override public void generateRichTranslations(OwoTranslationBuilder translationBuilder) { //tu fui, ego eris
		//Magic Equipment
		translationBuilder.addWithParent(new TranslationInfo().textColor(VIRIDIAN),
			new TranslationInfo(TSItems.Magic.DRYADIC_HELMET),
			new TranslationInfo(TSItems.Magic.DRYADIC_CHESTPLATE),
			new TranslationInfo(TSItems.Magic.DRYADIC_LEGGINGS),
			new TranslationInfo(TSItems.Magic.DRYADIC_BOOTS),
			new TranslationInfo(TSItems.Magic.DRYADIC_SWORD),
			new TranslationInfo(TSItems.Magic.DRYADIC_DAGGER),
			new TranslationInfo(TSItems.Magic.ENCHANTED_LEAF));
		translationBuilder.addWithParent(new TranslationInfo().textColor(ROSE_GOLD),
			new TranslationInfo(TSItems.Magic.ROSE_GOLD_INGOT),
			new TranslationInfo(ModBlocks.ROSE_GOLD_BLOCK).text("Block of Rose Gold"),
			new TranslationInfo(TSItems.Magic.ROSE_GOLD_HELMET),
			new TranslationInfo(TSItems.Magic.ROSE_GOLD_CHESTPLATE).text("Rose Gold Cuirass"),
			new TranslationInfo(TSItems.Magic.ROSE_GOLD_LEGGINGS),
			new TranslationInfo(TSItems.Magic.ROSE_GOLD_BOOTS),
			new TranslationInfo(TSItems.Magic.ROSE_GOLD_SWORD),
			new TranslationInfo(TSItems.Magic.ROSE_GOLD_DAGGER),
			new TranslationInfo(TSItems.Magic.ROSE_GOLD_PICKAXE),
			new TranslationInfo(TSItems.Magic.ROSE_GOLD_BATTLEAXE),
			new TranslationInfo(TSItems.Magic.ROSE_GOLD_SHOVEL),
			new TranslationInfo(TSItems.Magic.ROSE_GOLD_SICKLE).tooltip("Functions as a Hoe."));
		translationBuilder.addWithParent(new TranslationInfo().textColor(VIRIDIAN),
			new TranslationInfo(TSItems.Magic.DRUIDIC_HELMET),
			new TranslationInfo(TSItems.Magic.DRUIDIC_CHESTPLATE),
			new TranslationInfo(TSItems.Magic.DRUIDIC_LEGGINGS),
			new TranslationInfo(TSItems.Magic.DRUIDIC_BOOTS),
			new TranslationInfo(TSItems.Magic.DRUIDIC_SWORD),
			new TranslationInfo(TSItems.Magic.DRUIDIC_DAGGER),
			new TranslationInfo(TSItems.Magic.DRUIDIC_BOW),
			new TranslationInfo(TSItems.Magic.DRUIDIC_GEM));
		translationBuilder.addWithParent(new TranslationInfo().textColor(IMPERIAL_ALLOY, IMPERIAL_ALLOY2),
			new TranslationInfo(TSItems.Magic.IMPERIAL_ALLOY_INGOT),
			new TranslationInfo(ModBlocks.IMPERIAL_ALLOY_BLOCK).text("Block of Imperial Alloy"),
			new TranslationInfo(TSItems.Magic.IMPERIAL_HELMET),
			new TranslationInfo(TSItems.Magic.IMPERIAL_CHESTPLATE),
			new TranslationInfo(TSItems.Magic.IMPERIAL_LEGGINGS),
			new TranslationInfo(TSItems.Magic.IMPERIAL_BOOTS),
			new TranslationInfo(TSItems.Magic.IMPERIAL_SWORD),
			new TranslationInfo(TSItems.Magic.IMPERIAL_GLADIUS),
			new TranslationInfo(TSItems.Magic.IMPERIAL_PICKAXE),
			new TranslationInfo(TSItems.Magic.IMPERIAL_BATTLEAXE),
			new TranslationInfo(TSItems.Magic.IMPERIAL_SHOVEL),
			new TranslationInfo(TSItems.Magic.IMPERIAL_SICKLE).tooltip("Functions as a Hoe."));
		translationBuilder.addWithParent(new TranslationInfo().textColor(LIGHT_PURPLE),
			new TranslationInfo(TSItems.Magic.THANATU_HELMET).text("Macabre Skull").tooltip("The skull of the demon king."),
			new TranslationInfo(TSItems.Magic.THANATU_CHESTPLATE).text("Macabre Shoulderpads"),
			new TranslationInfo(TSItems.Magic.THANATU_LEGGINGS).text("Macabre Loincloth"),
			new TranslationInfo(TSItems.Magic.THANATU_BOOTS).text("Macabre Sandals"));
		translationBuilder.addWithParent(new TranslationInfo().textColor(LIGHT_PURPLE),
			new TranslationInfo(TSItems.Magic.UNHOLY_SHARDS),
			new TranslationInfo(TSItems.Magic.UNHOLY_INGOT).tooltip("Reflects only the light in darkness."),
			new TranslationInfo(ModBlocks.UNHOLY_BLOCK).text("Block of Unholy Alloy"),
			new TranslationInfo(TSItems.Magic.UNHOLY_HELMET),
			new TranslationInfo(TSItems.Magic.UNHOLY_CHESTPLATE).text("Unholy Cuirass"),
			new TranslationInfo(TSItems.Magic.UNHOLY_LEGGINGS),
			new TranslationInfo(TSItems.Magic.UNHOLY_BOOTS),
			new TranslationInfo(TSItems.Magic.UNHOLY_SWORD),
			new TranslationInfo(TSItems.Magic.UNHOLY_DAGGER),
			new TranslationInfo(TSItems.Magic.UNHOLY_PICKAXE),
			new TranslationInfo(TSItems.Magic.UNHOLY_BATTLEAXE),
			new TranslationInfo(TSItems.Magic.UNHOLY_SHOVEL),
			new TranslationInfo(TSItems.Magic.UNHOLY_SICKLE).tooltip("Functions as a Hoe."));
		translationBuilder.addWithParent(new TranslationInfo().textColor(RAINBOW),
			new TranslationInfo(TSItems.Magic.ARMA_DEI_HELMET),
			new TranslationInfo(TSItems.Magic.ARMA_DEI_CHESTPLATE),
			new TranslationInfo(TSItems.Magic.ARMA_DEI_LEGGINGS),
			new TranslationInfo(TSItems.Magic.ARMA_DEI_BOOTS),
			new TranslationInfo(TSItems.Magic.ARMA_DEI_SWORD),
			new TranslationInfo(TSItems.Magic.ARMA_DEI_DAGGER),
			new TranslationInfo(TSItems.Magic.ARMA_DEI_PICKAXE),
			new TranslationInfo(TSItems.Magic.ARMA_DEI_BATTLEAXE),
			new TranslationInfo(TSItems.Magic.ARMA_DEI_SHOVEL),
			new TranslationInfo(TSItems.Magic.ARMA_DEI_SICKLE).tooltip("Functions as a Hoe."));

		translationBuilder.add(new TranslationInfo(ModBlocks.WAX_INFUSED_COPPER_BLOCK).text("Wax-Infused Block of Copper"));
		translationBuilder.add(new TranslationInfo(ModBlocks.STARSTEEL_LAMP));
		translationBuilder.add(new TranslationInfo(ModBlocks.STARSTEEL_FAN));
		translationBuilder.add(new TranslationInfo(ModBlocks.BATTERY));
		translationBuilder.add(new TranslationInfo(ModBlocks.FUSEBOX));
		translationBuilder.add(new TranslationInfo(ModBlocks.FANCY_COMPUTER));
		translationBuilder.add(new TranslationInfo(ModBlocks.BLACK_AGILITY_BLOCK).text("Steel Magno-Repulsion Block").tooltip("Watch your step."));
		translationBuilder.addWithParent(new TranslationInfo().textColor(SENTINEL_CRIMSON1, SENTINEL_CRIMSON3),
			new TranslationInfo(ModBlocks.BIG_RED_BUTTON),
			new TranslationInfo(ModBlocks.BIG_RED_PLATE).tooltip("1500 Megawatt Super Colliding Super Plate"));

		//Tech Equipment
		translationBuilder.addWithParent(new TranslationInfo().textColor(SCRAP_METAL),
			new TranslationInfo(TSItems.Tech.SCRAP_METAL_SHARD),
			new TranslationInfo(ModBlocks.SCRAP_METAL_BLOCK),
			new TranslationInfo(ModBlocks.CHISELED_SCRAP_METAL_BLOCK),
			new TranslationInfo(ModBlocks.SCRAP_METAL_PILLAR),
			new TranslationInfo(TSItems.Tech.SCRAP_METAL_HELMET),
			new TranslationInfo(TSItems.Tech.SCRAP_METAL_CHESTPLATE),
			new TranslationInfo(TSItems.Tech.SCRAP_METAL_LEGGINGS),
			new TranslationInfo(TSItems.Tech.SCRAP_METAL_BOOTS),
			new TranslationInfo(TSItems.Tech.SCRAP_METAL_SWORD),
			new TranslationInfo(TSItems.Tech.SCRAP_METAL_KNIFE),
			new TranslationInfo(TSItems.Tech.SCRAP_METAL_DRILL),
			new TranslationInfo(TSItems.Tech.SCRAP_METAL_CHAINSAW).tooltip("Right click to launch shards at enemies!"),
			new TranslationInfo(TSItems.Tech.SCRAP_METAL_SHOVEL),
			new TranslationInfo(TSItems.Tech.SCRAP_METAL_HOE),
			new TranslationInfo(TSItems.Tech.SCRAP_METAL_PHASER),
			new TranslationInfo(TSItems.Tech.LIFEFORM_TRACER).tooltip("Use on a mob to track it."));
		translationBuilder.addWithParent(new TranslationInfo().textColor(STARSTEEL_BASE),
			new TranslationInfo(TSItems.Tech.INDUSTRIAL_HELMET),
			new TranslationInfo(TSItems.Tech.INDUSTRIAL_HARNESS),
			new TranslationInfo(TSItems.Tech.INDUSTRIAL_PANTS),
			new TranslationInfo(TSItems.Tech.INDUSTRIAL_BOOTS),
			new TranslationInfo(TSItems.Tech.INDUSTRIAL_CROWBAR).tooltip("Rise, and... shine."),
			new TranslationInfo(TSItems.Tech.INDUSTRIAL_PHASER));
		translationBuilder.addWithParent(new TranslationInfo().textColor(STARSTEEL),
			new TranslationInfo(TSItems.Tech.STARSTEEL_INGOT),
			new TranslationInfo(ModBlocks.STARSTEEL_BLOCK).text("Block of Starsteel"),
			new TranslationInfo(ModBlocks.CHISELED_STARSTEEL_BLOCK).text("Chiseled Block of Starsteel"),
			new TranslationInfo(ModBlocks.STAINLESS_STEEL_BLOCK),
			new TranslationInfo(ModBlocks.STARSTEEL_LADDER),
			new TranslationInfo(TSItems.Tech.STARSTEEL_SIGN),
			new TranslationInfo(TSItems.Tech.STARSTEEL_HANGING_SIGN),
			new TranslationInfo(TSItems.Tech.STARSTEEL_HELMET),
			new TranslationInfo(TSItems.Tech.STARSTEEL_CHESTPLATE),
			new TranslationInfo(TSItems.Tech.STARSTEEL_LEGGINGS),
			new TranslationInfo(TSItems.Tech.STARSTEEL_BOOTS),
			new TranslationInfo(TSItems.Tech.STARSTEEL_SWORD),
			new TranslationInfo(TSItems.Tech.STARSTEEL_KNIFE),
			new TranslationInfo(TSItems.Tech.STARSTEEL_DRILL),
			new TranslationInfo(TSItems.Tech.STARSTEEL_AXE),
			new TranslationInfo(TSItems.Tech.STARSTEEL_SHOVEL),
			new TranslationInfo(TSItems.Tech.STARSTEEL_HOE),
			new TranslationInfo(TSItems.Tech.STARSTEEL_PHASER));
		translationBuilder.addWithParent(new TranslationInfo().textColor(NUCLEAR),
			new TranslationInfo(TSItems.Tech.NUCLEAR_INGOT),
			new TranslationInfo(ModBlocks.NUCLEAR_ORE),
			new TranslationInfo(ModBlocks.NUCLEAR_BLOCK).text("Nuclear Storage Block"),
			new TranslationInfo(TSItems.Tech.NUCLEAR_ROCKET),
			new TranslationInfo(TSItems.Tech.NUCLEAR_HELMET),
			new TranslationInfo(TSItems.Tech.NUCLEAR_CHESTPLATE),
			new TranslationInfo(TSItems.Tech.NUCLEAR_LEGGINGS),
			new TranslationInfo(TSItems.Tech.NUCLEAR_BOOTS),
			new TranslationInfo(TSItems.Tech.NUCLEAR_SWORD).tooltip("Irradiates enemies."),
			new TranslationInfo(TSItems.Tech.NUCLEAR_VIBROKNIFE).tooltip("Irradiates enemies."),
			new TranslationInfo(TSItems.Tech.NUCLEAR_DRILL),
			new TranslationInfo(TSItems.Tech.NUCLEAR_AXE),
			new TranslationInfo(TSItems.Tech.NUCLEAR_SHOVEL),
			new TranslationInfo(TSItems.Tech.NUCLEAR_HOE),
			new TranslationInfo(TSItems.Tech.NUCLEAR_PHASER));
		translationBuilder.addWithParent(new TranslationInfo().textColor(NANOTECH),
			new TranslationInfo(TSItems.Tech.NANOTECH_CAPSULE),
			new TranslationInfo(ModBlocks.NANOTECH_BLOCK).text("Nanotech Storage Block"),
			new TranslationInfo(TSItems.Tech.NANOTECH_HELMET),
			new TranslationInfo(TSItems.Tech.NANOTECH_CHESTPLATE),
			new TranslationInfo(TSItems.Tech.NANOTECH_LEGGINGS),
			new TranslationInfo(TSItems.Tech.NANOTECH_BOOTS),
			new TranslationInfo(TSItems.Tech.NANOTECH_SWORD).tooltip("\"I've even forgotten my name...\""),
			new TranslationInfo(TSItems.Tech.NANOTECH_VIBROKNIFE),
			new TranslationInfo(TSItems.Tech.NANOTECH_DRILL),
			new TranslationInfo(TSItems.Tech.NANOTECH_AXE),
			new TranslationInfo(TSItems.Tech.NANOTECH_SHOVEL),
			new TranslationInfo(TSItems.Tech.NANOTECH_HOE),
			new TranslationInfo(TSItems.Tech.NANOTECH_PHASER));
		translationBuilder.addWithParent(new TranslationInfo().textColor(ZENITHIUM),
			new TranslationInfo(TSItems.Tech.ZENITHIUM_CLUSTER).tooltip("The concentrated essence of a galaxy."),
			new TranslationInfo(TSItems.Tech.ZENITHIUM_HELMET),
			new TranslationInfo(TSItems.Tech.ZENITHIUM_CHESTPLATE),
			new TranslationInfo(TSItems.Tech.ZENITHIUM_LEGGINGS),
			new TranslationInfo(TSItems.Tech.ZENITHIUM_BOOTS),
			new TranslationInfo(TSItems.Tech.ZENITHIUM_SWORD),
			new TranslationInfo(TSItems.Tech.ZENITHIUM_DAGGER),
			new TranslationInfo(TSItems.Tech.ZENITHIUM_PICKAXE),
			new TranslationInfo(TSItems.Tech.ZENITHIUM_AXE),
			new TranslationInfo(TSItems.Tech.ZENITHIUM_SHOVEL),
			new TranslationInfo(TSItems.Tech.ZENITHIUM_HOE),
			new TranslationInfo(TSItems.Tech.ZENITHIUM_PHASER));

		translationBuilder.add(new TranslationInfo(TSItems.Magic.COPPER_GLADIUS).tooltip("An ornamental blade of goblin tradition.").textColor(COPPER));
		//Blacksmith's Welding Mask, Mad Scientist's Lab Coat

        translationBuilder.add(
			new TranslationInfo(TSItems.Beta.PAPPYM_BLADE).text("Jade Seraphim")
				.tooltip("Passed down through ancient tradition... and now it has found its way to you.").textColor(GREEN),
			new TranslationInfo(TSItems.Beta.PAPPYD_BLADE).text("Hell's Flaming Fury").textColor(HELLFIRE),
			new TranslationInfo(TSItems.Beta.THANATU_BLADE).text("Harmonious Rapture").textColor(LIGHT_PURPLE),
			new TranslationInfo(TSItems.Beta.SKYLAR_BLADE).text("Equitous Retribution").textColor(SHINY_GOLD),
			new TranslationInfo(TSItems.Beta.LILITH_BLADE).text("Unwavering Judgement").textColor(DUNE_TAN),
			new TranslationInfo(TSItems.Beta.KINGS_BLADE).text("Stainless Resolve").textColor(WHITE),
			new TranslationInfo(ModArmory.SCARA_SHEARS).text("SCARA Shears").tooltip("A military-grade threat.").textColor(DARK_PURPLE),
			new TranslationInfo(ModArmory.MASTER_SWORD).text("The Master's Sword").tooltip("From a distant universe...").textColor(AQUA));

		/*new TranslationInfo(TSItems.Tech.LASER_PISTOL, "NUMA-28 Comet", "\"Fast and portable!\"", STARSTEEL),
		new TranslationInfo(TSItems.Tech.LASER_TASER, "Enforcer-Standard Taser", "\"Non-lethal.\"", AQUA),
		new TranslationInfo(TSItems.Tech.LASER_SNIPER_ECHO, "NUMA-52 Echo", "\"They'll never see it coming!\"", DUNE_TAN),
		new TranslationInfo(TSItems.Tech.LASER_MINIGUN, "UTARI-91 Serenity", "\"Keep the peace!\"", BLUE),
		new TranslationInfo(TSItems.Tech.LASER_RIFLE, "NUMA-63 Agnostyk", "\"Packs a punch!\"", MOSS),
		new TranslationInfo(TSItems.Tech.LASER_SHOTGUN, "KHAOS-66 Tremor", "\"Rip and tear!\"", HELLFIRE),
		new TranslationInfo(TSItems.Tech.LASER_HEALER, "PW49 Firebird", "\"Those who can't do, heal!\"", SHINY_GOLD),
		new TranslationInfo(TSItems.Tech.LASER_SNIPER, "PW88 Shadow", "\"The assassin's weapon of choice!\"", DARK_PURPLE),
		new TranslationInfo(TSItems.Tech.LASER_SPREADER, "PW76 Pandemic", "\"Filled with a toxic bioweapon.\"", GREEN),
		new TranslationInfo(TSItems.Tech.LASER_REVOLVER, "Drunkard's Handcannon", "\"But you have heard of me!\"", null),*/

		translationBuilder.addWithParent(new TranslationInfo().textColor(STARSTEEL),
			new TranslationInfo(TSItems.Tech.PLASMA_CELL),
			new TranslationInfo(TSItems.Tech.PAINT_PACK).textColor(RAINBOW),
			new TranslationInfo(TSItems.Tech.PHOTONIC_LENS),
			new TranslationInfo(TSItems.Tech.COUNTERFORCE_DIFFUSER),
			new TranslationInfo(TSItems.Tech.PHASE_ASSIMILATOR),
			new TranslationInfo(TSItems.Tech.AUXILIARY_PLASMA_CHAMBER),
			new TranslationInfo(TSItems.Tech.ADVANCED_BREECH_MECHANISM),
			new TranslationInfo(TSItems.Tech.SMOKE_CAPSULE),
			new TranslationInfo(TSItems.Tech.POISON_CAPSULE),
			new TranslationInfo(TSItems.Tech.WITHER_CAPSULE),
			new TranslationInfo(TSItems.Tech.REGENERATION_CAPSULE));
		translationBuilder.add(
			new TranslationInfo(TSItems.Magic.RESISTANCE_ITEM).text("Shield Badge").textColor(GRAY),
			new TranslationInfo(TSItems.Magic.FIRE_RESISTANCE_ITEM).text("Flaming Badge").textColor(HELLFIRE), //shield badge, fire stuff
			new TranslationInfo(TSItems.Magic.JUMP_BOOST_ITEM).text("Icarus' Gust").textColor(NUCLEAR),
			new TranslationInfo(TSItems.Magic.STRENGTH_ITEM).text("Sword Badge").textColor(GRAY), //shattered sword, iron ingots?
			new TranslationInfo(TSItems.Magic.WEAKNESS_ITEM).text("Shattered Sword").tooltip("A reminder of past failures."),
			new TranslationInfo(TSItems.Magic.REGENERATION_ITEM).text("Ever-Beating Heart"), //leviathan stuff
			new TranslationInfo(TSItems.Magic.WATER_BREATHING_ITEM).text("Abyssal Bubbles"),
			new TranslationInfo(TSItems.Magic.INVISIBILITY_ITEM).text("Vampire's Mirror"),
			new TranslationInfo(TSItems.Magic.DOLPHINS_GRACE_ITEM).text("Foam Dolphin Plush").tooltip("Its silky skin makes one feel hydrodynamic.").textColor(DOLPHIN),
			new TranslationInfo(TSItems.Magic.CONDUIT_POWER_ITEM).text("Eye of the Sea"),
			new TranslationInfo(TSItems.Magic.NIGHT_VISION_ITEM).text("Feline Eye"),
			new TranslationInfo(TSItems.Magic.HERO_OF_THE_VILLAGE_ITEM).text("Hero's Emerald").tooltip("Gifted to heroes of legend.").textColor(NUCLEAR),
			new TranslationInfo(TSItems.Magic.PALADINS_BADGE).tooltip("The mark of a true warrior of light.").textColor(SHINY_GOLD), //flaming badge, sword badge
			new TranslationInfo(TSItems.Magic.CYBERNETIC_STOMACH).textColor(SCRAP_METAL_BASE),
			new TranslationInfo(TSItems.Magic.ONE_PENCE).text("The One Pence").tooltip("Wealth, Fame, Power.").textColor(COPPER));

		translationBuilder.add(
			new TranslationInfo(ModItems.SENTINEL_SPAWN_EGG).text("Sentinel Spawn Beacon").tooltip("A mindless drone for the hive.").textColor(SCRAP_METAL_BASE),
			new TranslationInfo(ModItems.JANITOR_DROID_SPAWN_EGG).text("Janitor Droid").tooltip("What a waste of a soul.").textColor(SCRAP_METAL_BASE),
			new TranslationInfo(ModItems.FLORBUS_SPAWN_EGG).text("Florbus Spawn Sac"));
		translationBuilder.add(
			new TranslationInfo(ModItems.VENDOR_TOKEN).textColor(VENDOR_TOKEN),
			new TranslationInfo(ModItems.LEGENDARY_TOKEN));

		translationBuilder.addMusicDisc(new TranslationInfo(TSItems.Tech.MUSIC_DISC_ASSASSINATION_UPLOAD).text("Scrapped Cassette").textColor(SCRAP_METAL),
			jsonArrayOf(new JsonTextObject().text("Kristoffer Kaufmann - Assassination Upload")), ModSounds.ASSASSINATION_UPLOAD);
		translationBuilder.addMusicDisc(new TranslationInfo(TSItems.Tech.MUSIC_DISC_ODE_TO_TRANQUILITY).text("Music Disc"),
			jsonArrayOf(new JsonTextObject().text("Kristoffer Kaufmann - Ode to Tranquility")), ModSounds.ODE_TO_TRANQUILITY);
		translationBuilder.addMusicDisc(new TranslationInfo(TSItems.Tech.MUSIC_DISC_LAPSE_IN_JUDGEMENT).text("War-Torn Music Disc"),
			jsonArrayOf(new JsonTextObject().text("Kristoffer Kaufmann - Lapse in Judgement")), ModSounds.LAPSE_IN_JUDGEMENT);
		translationBuilder.addMusicDisc(new TranslationInfo(TSItems.Tech.MUSIC_DISC_RECITAL).text("Aged Cassette").tooltip("It's in remarkably good condition."),
			jsonArrayOf(new JsonTextObject().text("Trevor Skullcrafter - recital")), ModSounds.RECITAL);

		//Wood
		translationBuilder.addWithParent(new TranslationInfo().textColor(YGGDRASIL),
			new TranslationInfo(ModBlocks.PALE_LOG),
			new TranslationInfo(ModBlocks.PALE_WOOD),
			new TranslationInfo(ModBlocks.STRIPPED_PALE_LOG),
			new TranslationInfo(ModBlocks.STRIPPED_PALE_WOOD),
			new TranslationInfo(ModBlocks.PALE_PLANKS),
			new TranslationInfo(ModBlocks.PALE_LEAVES),
			new TranslationInfo(ModBlocks.PALE_SAPLING),
			new TranslationInfo(ModBlocks.POTTED_PALE_SAPLING),
			new TranslationInfo(ModBlocks.PALE_SLAB),
			new TranslationInfo(ModBlocks.PALE_STAIRS),
			new TranslationInfo(ModBlocks.PALE_FENCE),
			new TranslationInfo(ModBlocks.PALE_FENCE_GATE),
			new TranslationInfo(ModBlocks.PALE_BUTTON),
			new TranslationInfo(ModBlocks.PALE_PRESSURE_PLATE),
			new TranslationInfo(ModBlocks.PALE_DOOR),
			new TranslationInfo(ModBlocks.PALE_TRAPDOOR),
			new TranslationInfo(ModBlocks.PALE_SIGN),
			new TranslationInfo(ModBlocks.PALE_HANGING_SIGN),
			new TranslationInfo(TSItems.Magic.PALE_BOAT),
			new TranslationInfo(TSItems.Magic.PALE_CHEST_BOAT));
		translationBuilder.addWithParent(new TranslationInfo().textColor(CHARRED),
			new TranslationInfo(ModBlocks.CHARRED_LOG),
			new TranslationInfo(ModBlocks.CHARRED_WOOD),
			new TranslationInfo(ModBlocks.STRIPPED_CHARRED_LOG), new TranslationInfo(ModBlocks.STRIPPED_CHARRED_WOOD),
			new TranslationInfo(ModBlocks.CHARRED_PLANKS),
			null,
			null,
			null,
			new TranslationInfo(ModBlocks.CHARRED_SLAB),
			new TranslationInfo(ModBlocks.CHARRED_STAIRS),
			new TranslationInfo(ModBlocks.CHARRED_FENCE),
			new TranslationInfo(ModBlocks.CHARRED_FENCE_GATE),
			new TranslationInfo(ModBlocks.CHARRED_BUTTON),
			new TranslationInfo(ModBlocks.CHARRED_PRESSURE_PLATE),
			new TranslationInfo(ModBlocks.CHARRED_DOOR),
			new TranslationInfo(ModBlocks.CHARRED_TRAPDOOR),
			new TranslationInfo(ModBlocks.CHARRED_SIGN),
			new TranslationInfo(ModBlocks.CHARRED_HANGING_SIGN),
			new TranslationInfo(TSItems.Magic.CHARRED_BOAT),
			new TranslationInfo(TSItems.Magic.CHARRED_CHEST_BOAT));
		translationBuilder.addWithParent(new TranslationInfo().textColor(MIDAS),
			new TranslationInfo(ModBlocks.MIDAS_LOG),
			new TranslationInfo(ModBlocks.MIDAS_WOOD),
			new TranslationInfo(ModBlocks.STRIPPED_MIDAS_LOG),
			new TranslationInfo(ModBlocks.STRIPPED_MIDAS_WOOD),
			new TranslationInfo(ModBlocks.MIDAS_PLANKS),
			new TranslationInfo(ModBlocks.MIDAS_LEAVES),
			new TranslationInfo(ModBlocks.MIDAS_SAPLING),
			new TranslationInfo(ModBlocks.POTTED_MIDAS_SAPLING),
			new TranslationInfo(ModBlocks.MIDAS_SLAB),
			new TranslationInfo(ModBlocks.MIDAS_STAIRS),
			new TranslationInfo(ModBlocks.MIDAS_FENCE),
			new TranslationInfo(ModBlocks.MIDAS_FENCE_GATE),
			new TranslationInfo(ModBlocks.MIDAS_BUTTON),
			new TranslationInfo(ModBlocks.MIDAS_PRESSURE_PLATE),
			new TranslationInfo(ModBlocks.MIDAS_DOOR),
			new TranslationInfo(ModBlocks.MIDAS_TRAPDOOR),
			new TranslationInfo(ModBlocks.MIDAS_SIGN),
			new TranslationInfo(ModBlocks.MIDAS_HANGING_SIGN),
			new TranslationInfo(TSItems.Magic.MIDAS_BOAT),
			new TranslationInfo(TSItems.Magic.MIDAS_CHEST_BOAT));
		translationBuilder.addWithParent(new TranslationInfo().textColor(VIRIDIAN),
			new TranslationInfo(ModBlocks.VIRIDIAN_LOG),
			new TranslationInfo(ModBlocks.VIRIDIAN_WOOD),
			new TranslationInfo(ModBlocks.STRIPPED_VIRIDIAN_LOG),
			new TranslationInfo(ModBlocks.STRIPPED_VIRIDIAN_WOOD),
			new TranslationInfo(ModBlocks.VIRIDIAN_PLANKS),
			new TranslationInfo(ModBlocks.VIRIDIAN_LEAVES),
			new TranslationInfo(ModBlocks.VIRIDIAN_SAPLING),
			new TranslationInfo(ModBlocks.POTTED_VIRIDIAN_SAPLING),
			new TranslationInfo(ModBlocks.VIRIDIAN_SLAB),
			new TranslationInfo(ModBlocks.VIRIDIAN_STAIRS),
			new TranslationInfo(ModBlocks.VIRIDIAN_FENCE),
			new TranslationInfo(ModBlocks.VIRIDIAN_FENCE_GATE),
			new TranslationInfo(ModBlocks.VIRIDIAN_BUTTON),
			new TranslationInfo(ModBlocks.VIRIDIAN_PRESSURE_PLATE),
			new TranslationInfo(ModBlocks.VIRIDIAN_DOOR),
			new TranslationInfo(ModBlocks.VIRIDIAN_TRAPDOOR),
			new TranslationInfo(ModBlocks.VIRIDIAN_SIGN),
			new TranslationInfo(ModBlocks.VIRIDIAN_HANGING_SIGN),
			new TranslationInfo(TSItems.Magic.VIRIDIAN_BOAT),
			new TranslationInfo(TSItems.Magic.VIRIDIAN_CHEST_BOAT));
		translationBuilder.addWithParent(new TranslationInfo().textColor(CERULII),
			new TranslationInfo(ModBlocks.CERULII_LOG),
			new TranslationInfo(ModBlocks.CERULII_WOOD),
			new TranslationInfo(ModBlocks.STRIPPED_CERULII_LOG),
			new TranslationInfo(ModBlocks.STRIPPED_CERULII_WOOD),
			new TranslationInfo(ModBlocks.CERULII_PLANKS),
			new TranslationInfo(ModBlocks.CERULII_LEAVES),
			new TranslationInfo(ModBlocks.CERULII_SAPLING),
			new TranslationInfo(ModBlocks.POTTED_CERULII_SAPLING),
			new TranslationInfo(ModBlocks.CERULII_SLAB),
			new TranslationInfo(ModBlocks.CERULII_STAIRS),
			new TranslationInfo(ModBlocks.CERULII_FENCE),
			new TranslationInfo(ModBlocks.CERULII_FENCE_GATE),
			new TranslationInfo(ModBlocks.CERULII_BUTTON),
			new TranslationInfo(ModBlocks.CERULII_PRESSURE_PLATE),
			new TranslationInfo(ModBlocks.CERULII_DOOR),
			new TranslationInfo(ModBlocks.CERULII_TRAPDOOR),
			new TranslationInfo(ModBlocks.CERULII_SIGN),
			new TranslationInfo(ModBlocks.CERULII_HANGING_SIGN),
			new TranslationInfo(TSItems.Magic.CERULII_BOAT),
			new TranslationInfo(TSItems.Magic.CERULII_CHEST_BOAT));

		translationBuilder.add(
			new TranslationInfo(ModEffects.REDSTONED, false),
			new TranslationInfo(ModEffects.FLIGHT, false),
			new TranslationInfo(ModEffects.WELL_FED, false),
			new TranslationInfo(ModEffects.COSMIC_FIRE, false),
			new TranslationInfo(ModEffects.INFESTED, false),
			new TranslationInfo(ModEffects.IRRADIATED, false));

        translationBuilder.add(new TranslationInfo(ModItems.SALT).tooltip("Used for keeping meat fresh.").textColor(SALT));

		translationBuilder.addPottedPlant(ModBlocks.TRANQUIL_ROSE, ModBlocks.POTTED_TRANQUIL_ROSE, "Tranquil Rose", "Smells delightful.", TRANQUIL);
		translationBuilder.addPottedPlant(ModBlocks.SKULLWEED, ModBlocks.POTTED_SKULLWEED, "Skullweed", "It's so cold...", SKULLWEED);

		translationBuilder.add(
			new TranslationInfo(ModItems.RICE_SEEDS),
			new TranslationInfo(ModItems.RICE_CAKE),
			new TranslationInfo(ModBlocks.RICE_PLANT),
			new TranslationInfo(ModBlocks.RICE_BLOCK));
		translationBuilder.addWithParent(new TranslationInfo().textColor(SHINY_GOLD),
			new TranslationInfo(ModItems.MIDAS_FRUIT).tooltip("22 karats").textColor(SHINY_GOLD),
			new TranslationInfo(ModItems.GOLDEN_APPLE_JUICE),
			new TranslationInfo(ModItems.BANANA),
			new TranslationInfo(ModItems.BANANA_BREAD),
			new TranslationInfo(ModBlocks.FEATHERCORN).tooltip("Soft and warm."));
		translationBuilder.addWithParent(new TranslationInfo().textColor(PEARFRUIT),
			new TranslationInfo(ModItems.PEARFRUIT).tooltip("As good as gold."),
			new TranslationInfo(ModItems.PEARFRUIT_JUICE));
		translationBuilder.add(
			new TranslationInfo(ModItems.SUSHI_ROLL),
			new TranslationInfo(ModItems.TORTILLA),
			new TranslationInfo(ModItems.BURRITO),
			new TranslationInfo(ModItems.FRIED_EGG),
			new TranslationInfo(ModItems.APPLE_JUICE),
			new TranslationInfo(ModItems.SWEET_BERRY_JUICE),
			new TranslationInfo(ModItems.SMOKED_FISH).textColor(SMOKED_FISH));
		translationBuilder.addWithParent(new TranslationInfo().textColor(STARSTEEL_BASE),
			new TranslationInfo(TSItems.Tech.EMPTY_CAN),
			new TranslationInfo(TSItems.Tech.BEETROOT_SOUP_CAN).text("Can of Beetroot Soup"),
			new TranslationInfo(TSItems.Tech.MUSHROOM_STEW_CAN).text("Can of Mushroom Stew"),
			new TranslationInfo(TSItems.Tech.RABBIT_STEW_CAN).text("Can of Rabbit Stew"),
			new TranslationInfo(TSItems.Tech.MILK_CAN).text("Can of Evaporated Milk"),
			new TranslationInfo(TSItems.Tech.COLA_ORANGE).text("Can of A&L"),
			new TranslationInfo(TSItems.Tech.COLA_GREEN).text("Can of Trola-Cola"),
			new TranslationInfo(TSItems.Tech.COLA_CYAN).text("Can of AquaDei Lite"));

        translationBuilder.add(new TranslationInfo(ModItems.BROWNIE).tooltip("Comes from outer space?"));
        translationBuilder.add(new TranslationInfo(ModItems.CHORUS_COBBLER).tooltip("Memah's favorite recipe").textColor(CHORUS));
        translationBuilder.addWithParent(new TranslationInfo().textColor(DUNE_TAN),
			new TranslationInfo(ModItems.SANDFISH).tooltip("This is not a fish..."),
			new TranslationInfo(ModItems.COOKED_SANDFISH),
			new TranslationInfo(ModItems.DUNE_EEL).tooltip("Isn't this a snake?"));

		translationBuilder.addWithParent(new TranslationInfo().textColor(FLESH_PINK),
			new TranslationInfo(ModBlocks.FLESH_BLOCK).tooltip("It's strangely warm..."),
			new TranslationInfo(ModBlocks.FLESH_VEINS).tooltip("They're spreading..."),
			new TranslationInfo(ModBlocks.FLESHY_EYE).tooltip("It's staring..."),
			new TranslationInfo(TSItems.Magic.EYE_OF_RUIN).tooltip("What a troubling gaze..."),
			new TranslationInfo(TSItems.Magic.DUBIOUS_BACON).tooltip("Don't ask where it came from..."),
			new TranslationInfo(TSItems.Tech.VILE_SPITTER).tooltip("It's alive!").textColor(FLESH_PINK));

		translationBuilder.add(new TranslationInfo(ModItems.REDSTONE_CRYSTAL).text("Crystallized Redstone").tooltip("Sparkles with potential.")
			.textColor(BLOOD_RED));
		translationBuilder.add(new TranslationInfo(ModItems.BLOOD_DIAMOND).tooltip("Chaos itself shines through.").textColor(BLOOD_RED));
		translationBuilder.add(new TranslationInfo(ModItems.ASH).text("Wither Ash").tooltip("Contains traces of dark magic.").textColor(TRANQUIL));
		translationBuilder.add(new TranslationInfo(ModItems.TRANQUIL_DUST).text("Tranquil Pollen").tooltip("Useful in dark alchemy.").textColor(TRANQUIL));
		translationBuilder.add(new TranslationInfo(TSItems.Magic.DEMONIC_CORE).text("Demonic Core").tooltip("Use while crouching to bind to a location!")
			.textColor(LIGHT_PURPLE));

		translationBuilder.addWithParent(new TranslationInfo().textColor(SENTINEL_AQUA),
			new TranslationInfo(TSItems.Tech.HARD_LIGHT_PROJECTOR).text("Hard Light Projector").tooltip("Deploys temporary blocks."),
			new TranslationInfo(ModBlocks.HARD_LIGHT).text("Hard Light"),
			new TranslationInfo(ModBlocks.HARD_LIGHT_BARRIER).text("Hard Light Barrier").tooltip("Creative only!"),
			new TranslationInfo(TSItems.Tech.HOLOGRAPHIC_SIGN).text("Holographic Sign"),
			new TranslationInfo(TSItems.Tech.HOLOGRAPHIC_HANGING_SIGN).text("Holographic Hanging Sign"));
		translationBuilder.addWithParent(new TranslationInfo().textColor(SENTINEL_GOLD),
			new TranslationInfo(TSItems.Tech.CAUTION_HARD_LIGHT_PROJECTOR).text("Hard Light Projector").tooltip("Deploys temporary blocks."),
			new TranslationInfo(ModBlocks.CAUTION_HARD_LIGHT).text("Hard Light"),
			new TranslationInfo(ModBlocks.CAUTION_HARD_LIGHT_BARRIER).text("Hard Light Barrier").tooltip("Creative only!"),
			new TranslationInfo(TSItems.Tech.CAUTION_HOLOGRAPHIC_SIGN).text("Holographic Sign"),
			new TranslationInfo(TSItems.Tech.CAUTION_HOLOGRAPHIC_HANGING_SIGN).text("Holographic Hanging Sign"));
		translationBuilder.addWithParent(new TranslationInfo().textColor(SENTINEL_CRIMSON),
			new TranslationInfo(TSItems.Tech.SENTINEL_HARD_LIGHT_PROJECTOR).text("Hard Light Projector").tooltip("Deploys temporary blocks."),
			new TranslationInfo(ModBlocks.SENTINEL_HARD_LIGHT).text("Hard Light"),
			new TranslationInfo(ModBlocks.SENTINEL_HARD_LIGHT_BARRIER).text("Hard Light Barrier").tooltip("Creative only!"),
			new TranslationInfo(TSItems.Tech.SENTINEL_HOLOGRAPHIC_SIGN).text("Holographic Sign"),
			new TranslationInfo(TSItems.Tech.SENTINEL_HOLOGRAPHIC_HANGING_SIGN).text("Holographic Hanging Sign"));
		translationBuilder.add(
			new TranslationInfo(ModBlocks.CHAMBER_BLOCK),
			new TranslationInfo(ModBlocks.LIGHT_CHAMBER_BLOCK),
			new TranslationInfo(ModBlocks.DARK_CHAMBER_BLOCK),
			new TranslationInfo(ModBlocks.BLUE_AGILITY_BLOCK).textColor(SENTINEL_AQUA2),
			new TranslationInfo(ModBlocks.ORANGE_AGILITY_BLOCK).textColor(SENTINEL_GOLD2));

		//Foundation Blocks
		translationBuilder.add(
			new TranslationInfo(ModBlocks.CRACKED_END_STONE_BRICKS),
			new TranslationInfo(ModBlocks.CHISELED_END_STONE_BRICKS),
			new TranslationInfo(ModBlocks.END_STONE_BRICK_COLUMN));
		translationBuilder.addWithParent(new TranslationInfo().textColor(LIGHT_PURPLE),
			new TranslationInfo(ModBlocks.IMPIOUS_END_STONE),
			new TranslationInfo(ModBlocks.IMPIOUS_END_STONE_BRICKS),
			new TranslationInfo(ModBlocks.CRACKED_IMPIOUS_END_STONE_BRICKS),
			new TranslationInfo(ModBlocks.CHISELED_IMPIOUS_END_STONE_BRICKS),
			new TranslationInfo(ModBlocks.IMPIOUS_END_STONE_BRICK_COLUMN));
		translationBuilder.addWithParent(new TranslationInfo().textColor(LIGHT_PURPLE),
			new TranslationInfo(ModBlocks.DEIFIC_END_STONE),
			new TranslationInfo(ModBlocks.DEIFIC_END_STONE_BRICKS),
			new TranslationInfo(ModBlocks.CRACKED_DEIFIC_END_STONE_BRICKS),
			new TranslationInfo(ModBlocks.CHISELED_DEIFIC_END_STONE_BRICKS),
			new TranslationInfo(ModBlocks.DEIFIC_END_STONE_BRICK_COLUMN));
		translationBuilder.addWithParent(new TranslationInfo().textColor(SNOWSTONE, SNOWSTONE.darker()),
			new TranslationInfo(ModBlocks.SNOWSTONE),
			new TranslationInfo(ModBlocks.SNOWSTONE_STAIRS),
			new TranslationInfo(ModBlocks.SNOWSTONE_SLAB),
			new TranslationInfo(ModBlocks.SNOWSTONE_WALL),
			new TranslationInfo(ModBlocks.SMOOTH_SNOWSTONE),
			new TranslationInfo(ModBlocks.SMOOTH_SNOWSTONE_STAIRS),
			new TranslationInfo(ModBlocks.SMOOTH_SNOWSTONE_SLAB),
			new TranslationInfo(ModBlocks.SMOOTH_SNOWSTONE_WALL),
			new TranslationInfo(ModBlocks.CUT_SNOWSTONE),
			new TranslationInfo(ModBlocks.CUT_SNOWSTONE_SLAB),
			new TranslationInfo(ModBlocks.CHISELED_SNOWSTONE));
		translationBuilder.add(
			new TranslationInfo(ModBlocks.MOSS_STAIRS),
			new TranslationInfo(ModBlocks.MOSS_SLAB),
			new TranslationInfo(ModBlocks.DIRT_STAIRS),
			new TranslationInfo(ModBlocks.DIRT_SLAB),
			new TranslationInfo(ModBlocks.COARSE_DIRT_STAIRS),
			new TranslationInfo(ModBlocks.COARSE_DIRT_SLAB));

		translationBuilder.add(new TranslationInfo(ModBlocks.VENDOR));
		translationBuilder.add(new TranslationInfo(ModBlocks.RECONSTRUCTION_TABLE).textColor(SENTINEL_AQUA1));
		translationBuilder.add(new TranslationInfo(ModBlocks.MODIFICATION_TABLE));

		translationBuilder.add(
			new TranslationInfo(ModSounds.FLESH_AMBIENT).text("Flesh wriggles"),
			new TranslationInfo(ModSounds.BLASTER_SHOOT).text("Projectile fired"),
			new TranslationInfo(ModSounds.DATABASE_OPEN).text("Codex opened"),
			new TranslationInfo(ModSounds.DATABASE_FLIP).text("Codex flipped"),
			new TranslationInfo(ModSounds.NOTCH_UP).text("Powering up"));
		translationBuilder.addWithParent(new TranslationInfo().text("Phaser reloads"),
			new TranslationInfo(ModSounds.PISTOL_RELOAD),
			new TranslationInfo(ModSounds.SHOTGUN_RELOAD),
			new TranslationInfo(ModSounds.SNIPER_RELOAD),
			new TranslationInfo(ModSounds.BIO_RELOAD));

        translationBuilder.add(new TranslationInfo("trevorssentinels.database.name").text("HoloCodex").textColor(SENTINEL_AQUA));
        translationBuilder.add(new TranslationInfo("trevorssentinels.database.desc").text("Your guide to this world of magic and technology, " +
			"this database will store all information that may be useful on your adventure."));

		/*translationBuilder.add("trevorssentinels", stringToJsonArray("Trevor's Sentinels"), stringToJsonArray("Obtain a Scrap Metal Shard"));
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
		translationBuilder.add("spf", stringToJsonArray("SPF 50+"), stringToJsonArray("Obtain a Banana Boat"));*/

		translationBuilder.add(new TranslationInfo("pillar.trevorssentinels.chaos").text("Chaos").textColor(Color.RED));
		translationBuilder.add(new TranslationInfo("pillar.trevorssentinels.truth").text("Truth").textColor(Color.ORANGE));
		translationBuilder.add(new TranslationInfo("pillar.trevorssentinels.order").text("Order").textColor(Color.YELLOW));
        translationBuilder.add(new TranslationInfo("pillar.trevorssentinels.balance").text("Balance").textColor(Color.GREEN));
        translationBuilder.add(new TranslationInfo("pillar.trevorssentinels.wisdom").text("Wisdom").textColor(Color.CYAN));
        translationBuilder.add(new TranslationInfo("pillar.trevorssentinels.tranquility").text("Tranquility").textColor(Color.MAGENTA));
        translationBuilder.add(new TranslationInfo("pillar.trevorssentinels.purity").text("Purity").textColor(Color.WHITE));

        translationBuilder.add("death.attack.redstoned",
			new JsonTextObject().index(0),
			new JsonTextObject().text(" gave into the pain"));
        translationBuilder.add("death.attack.infested",
			new JsonTextObject().index(0),
			new JsonTextObject().text(" didn't make it"));
        translationBuilder.add("death.attack.irradiated",
			new JsonTextObject().index(0),
			new JsonTextObject().text(" ate one too many bananas"));
        translationBuilder.add("death.attack.phaser_projectile",
			new JsonTextObject().index(0),
			new JsonTextObject().text(" phased away thanks to "),
			new JsonTextObject().index(1));
        translationBuilder.add("death.attack.phaser_projectile.item",
			new JsonTextObject().index(0),
			new JsonTextObject().text(" phased away thanks to "),
			new JsonTextObject().index(1),
			new JsonTextObject().text(" and their "),
			new JsonTextObject().index(2));
        translationBuilder.add("death.attack.shard_projectile",
			new JsonTextObject().index(1),
			new JsonTextObject().text(" turned "),
			new JsonTextObject().index(0),
			new JsonTextObject().text(" into a pincushion"));
        translationBuilder.add("death.attack.shard_projectile.item",
			new JsonTextObject().index(1),
			new JsonTextObject().text(" turned "),
			new JsonTextObject().index(0),
			new JsonTextObject().text(" into a pincushion using "),
			new JsonTextObject().index(2));
        translationBuilder.add("death.attack.dagger_projectile",
			new JsonTextObject().index(0), //%1$s
			new JsonTextObject().text(" was shot through the heart, and "),
			new JsonTextObject().index(1), //%2$s
			new JsonTextObject().text(" is to blame"));
        translationBuilder.add("death.attack.dagger_projectile.item",
			new JsonTextObject().index(0), //%1$s
			new JsonTextObject().text(" was shot through the heart, and "),
			new JsonTextObject().index(1), //%2$s
			new JsonTextObject().text(" is to blame. They give "),
			new JsonTextObject().index(2), //%3$s
			new JsonTextObject().text(" a bad name"));

        translationBuilder.add(new TranslationInfo("key.category.trevorssentinels.trevorssentinels").text("Trevor's Sentinels"));
        translationBuilder.add(new TranslationInfo("key.trevorssentinels.style_switch").text("Style Switch"));
        translationBuilder.add(new TranslationInfo("key.trevorssentinels.reload").text("Reload"));

        translationBuilder.add(new TranslationInfo(new Identifier(MOD_ID, "hologui")).text("Sentinel HoloGUI").textColor(SENTINEL_AQUA));
        translationBuilder.add(new TranslationInfo(new Identifier(MOD_ID, "vanilla_extensions")).text("Vanilla Extensions"));
        translationBuilder.add(new TranslationInfo(new Identifier(MOD_ID, "legacy")).text("Legacy Resources"));

		translationBuilder.add(
			new TranslationInfo(ModEntities.SHARD_PROJECTILE).text(Text.translatable(TSItems.Tech.SCRAP_METAL_SHARD.getTranslationKey()).getString()),
			new TranslationInfo(ModEntities.PHASER_PROJECTILE),
			new TranslationInfo(ModEntities.DELAYED_EXPLOSIVE),
			new TranslationInfo(ModEntities.SENTINEL),
			new TranslationInfo(ModEntities.JANITOR_DROID),
			new TranslationInfo(ModEntities.FLORBUS),
			new TranslationInfo("entity.minecraft.villager.engineer").text("Engineer").textColor(AQUA),
			new TranslationInfo("entity.minecraft.villager.demolitionist").text("Demolitionist").textColor(RED),
			new TranslationInfo("entity.minecraft.villager.acolyte").text("Acolyte").textColor(LIGHT_PURPLE),
			new TranslationInfo("entity.minecraft.villager.witherseer").text("Witherseer").textColor(DARK_PURPLE));

        translationBuilder.add(new TranslationInfo("gamerule.trevorssentinels:useVelocityFallDamage").text("Use velocity-based fall damage"));
        translationBuilder.add(new TranslationInfo("gamerule.trevorssentinels:useVelocityFallDamage.description")
			.text("If enabled, fall damage will be calculated based on velocity."));
        translationBuilder.add(new TranslationInfo("gamerule.trevorssentinels:milkCuresPotionEffects").text("Drinking milk cures potion effects"));
        translationBuilder.add(new TranslationInfo("tooltip.trevorssentinels:milkCuresPotionEffects").text("Effects will not be cured!"));
        //translationBuilder.add("gamerule.trevorssentinels:milkCuresPotionEffects.description", "If enabled, fall damage will be calculated based on velocity.");

		/*translationBuilder.add("itemGroup." + MOD_ID + ".sentinels", jsonArrayOf(
			new JsonTextObject().text("T").color("#006699").underlined(true).build(),
			new JsonTextObject().text("r").color("#0079AC").underlined(true).build(),
			new JsonTextObject().text("e").color("#008CBF").underlined(true).build(),
			new JsonTextObject().text("v").color("#069FCC").underlined(true).build(),
			new JsonTextObject().text("o").color("#1AB3CC").underlined(true).build(),
			new JsonTextObject().text("r").color("#2DC6CC").underlined(true).build(),
			new JsonTextObject().text("'").color("#66CCA6").underlined(true).build(),
			new JsonTextObject().text("s ").color("#B3CC6C").underlined(true).build(),
			new JsonTextObject().text("S").color("#FFCC33").underlined(true).build(),
			new JsonTextObject().text("e").color("#FF9333").underlined(true).build(),
			new JsonTextObject().text("n").color("#FF5933").underlined(true).build(),
			new JsonTextObject().text("t").color("#F92D2D").underlined(true).build(),
			new JsonTextObject().text("i").color("#E51919").underlined(true).build(),
			new JsonTextObject().text("n").color("#D20606").underlined(true).build(),
			new JsonTextObject().text("e").color("#BF0000").underlined(true).build(),
			new JsonTextObject().text("l").color("#AC0000").underlined(true).build(),
			new JsonTextObject().text("s").color("#990000").underlined(true).build()));*/
		translationBuilder.add(new TranslationInfo("itemGroup." + MOD_ID + ".sentinels").text("Trevor's Sentinels").underlined()
			.textColor(SENTINEL_AQUA3, SENTINEL_AQUA2, SENTINEL_AQUA1, SENTINEL_GOLD2, SENTINEL_CRIMSON1, SENTINEL_CRIMSON2, SENTINEL_CRIMSON3));

		translationBuilder.add(new TranslationInfo("itemGroup." + MOD_ID + ".sentinels.tab.magic").text("Magic").textColor(SHINY_GOLD));
		translationBuilder.add(new TranslationInfo("itemGroup." + MOD_ID + ".sentinels.tab.tech").text("Tech").textColor(STARSTEEL));
		translationBuilder.add(new TranslationInfo("itemGroup." + MOD_ID + ".sentinels.tab.beta").text("Beta").textColor(CERULII).obfuscated(true));
		translationBuilder.add(new TranslationInfo("itemGroup." + MOD_ID + ".sentinels.button.wiki").text("Wiki").textColor(VIRIDIAN));

		translationBuilder.add(new TranslationInfo("tooltip.item.trevorssentinels.phaser.stats").text("Phaser Stats:"));

		translationBuilder.add(new TranslationInfo("tooltip." + MOD_ID + ".set_bonus_active").text("Set bonus active!"));
		translationBuilder.add(new TranslationInfo("tooltip." + MOD_ID + ".set_bonus_inactive").text("Set bonus inactive!"));
        translationBuilder.add(new TranslationInfo("tooltip." + MOD_ID + ".style").text("Style: "));
        translationBuilder.add(new TranslationInfo("tooltip." + MOD_ID + ".mode").text("Mode: "));
        translationBuilder.addNumbered(new TranslationInfo("tooltip." + MOD_ID + ".style_switch"),
			new TranslationInfo().text(" to switch style."),
			new TranslationInfo().text(" to cycle modes."));
        translationBuilder.addNumbered(new TranslationInfo("style.item." + MOD_ID + ".pappym_blade."),
			new TranslationInfo().text("Trickster"),
			new TranslationInfo().text("Paladin"),
			new TranslationInfo().text("Predator"),
			new TranslationInfo().text("Guardian"));
        translationBuilder.addNumbered(new TranslationInfo("style.item." + MOD_ID + ".thanatu_blade."),
			new TranslationInfo().text("Riftwalker"),
			new TranslationInfo().text("Riftcaller"));
        translationBuilder.addNumbered(new TranslationInfo("style.item." + MOD_ID + ".lilith_blade."),
			new TranslationInfo().text("Holy Retribution"),
			new TranslationInfo().text("ENDLESS LIGHT"));
        translationBuilder.addNumbered(new TranslationInfo("style.item." + MOD_ID + ".phaser."),
			new TranslationInfo().text("Reloading: Manual"),
			new TranslationInfo().text("Reloading: Automatic"));
		translationBuilder.addNumbered(new TranslationInfo(MOD_ID+".worldLevelTooLow."),
			new TranslationInfo().text("Something is wrong..."),
			new TranslationInfo().text("Demonic power has too much of a hold over the world!").textColor(LIGHT_PURPLE),
			new TranslationInfo().text("The power is too strong!").textColor(BLUE));
		translationBuilder.add(new TranslationInfo(MOD_ID+".worldLevelTooLow.other").text("A strange force pushes back!"));

        if (dataOutput.getModContainer().findPath("assets/trevorssentinels/lang/en_us.existing.json").isPresent()) try {
            translationBuilder.add(dataOutput.getModContainer().findPath("assets/trevorssentinels/lang/en_us.existing.json").get());
        } catch (Exception e) { throw new RuntimeException("Failed to add existing language file!", e); }
    }
}
