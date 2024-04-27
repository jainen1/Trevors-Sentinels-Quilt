package net.trevorskullcrafter.trevorssentinels;

import io.wispforest.owo.itemgroup.Icon;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import io.wispforest.owo.itemgroup.gui.ItemGroupButton;
import io.wispforest.owo.registration.reflect.FieldRegistrationHandler;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.GameRules;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.block.entity.ModBlockEntities;
import net.trevorskullcrafter.trevorssentinels.effect.ModEffects;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import net.trevorskullcrafter.trevorssentinels.entity.custom.FlorbusEntity;
import net.trevorskullcrafter.trevorssentinels.entity.custom.RoombaEntity;
import net.trevorskullcrafter.trevorssentinels.entity.custom.SentinelEntity;
import net.trevorskullcrafter.trevorssentinels.item.*;
import net.trevorskullcrafter.trevorssentinels.item.custom.PhaserItem;
import net.trevorskullcrafter.trevorssentinels.networking.ModMessages;
import net.trevorskullcrafter.trevorssentinels.potion.ModPotions;
import net.trevorskullcrafter.trevorssentinels.recipe.ModRecipes;
import net.trevorskullcrafter.trevorssentinels.util.ModLootTableModifiers;
import net.trevorskullcrafter.trevorssentinels.util.ModRegistries;
import net.trevorskullcrafter.trevorssentinels.util.TextUtil;
import net.trevorskullcrafter.trevorssentinels.villager.ModVillagers;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.QuiltLoader;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.resource.loader.api.PackActivationType;
import org.quiltmc.qsl.resource.loader.api.ResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class trevorssentinelsMain implements ModInitializer {
	public static final String MOD_ID = "trevorssentinels";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final OwoItemGroup SENTINELS = OwoItemGroup.builder(new Identifier(MOD_ID, "sentinels"), () -> Icon.of(Items.IRON_INGOT)).build();

	public static final GameRules.Key<GameRules.BooleanGameRule> USE_VELOCITY_FALL_DAMAGE =
		GameRuleRegistry.register("trevorssentinels:useVelocityFallDamage", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(false));
	public static final GameRules.Key<GameRules.BooleanGameRule> MILK_CURES_POTION_EFFECTS =
		GameRuleRegistry.register("trevorssentinels:milkCuresPotionEffects", GameRules.Category.PLAYER, GameRuleFactory.createBooleanRule(false));


	@Override public void onInitialize(ModContainer mod) {
		String[] flavors = {"ay yo, the pizza here", "touching grass is prohibited.", "*mic drop*", "I'll load the game when you fix this damn door!",
			"Error 404: tasteless joke not found", "Oh, here we go again...", "Don't you have work to be doing?"};
		LOGGER.info(MOD_ID + " : " + flavors[RandomGenerator.createLegacy().nextInt(flavors.length)]);

		QuiltLoader.getModContainer(MOD_ID).ifPresent(modContainer -> {
			ResourceLoader.registerBuiltinPack(new Identifier(MOD_ID, "hologui"), modContainer,
				PackActivationType.NORMAL, Text.translatable(new Identifier(MOD_ID, "hologui").toTranslationKey()));
			ResourceLoader.registerBuiltinPack(new Identifier(MOD_ID, "vanilla_extensions"), modContainer,
				PackActivationType.DEFAULT_ENABLED, Text.translatable(new Identifier(MOD_ID, "vanilla_extensions").toTranslationKey()));
			ResourceLoader.registerBuiltinPack(new Identifier(MOD_ID, "legacy"), modContainer,
				PackActivationType.NORMAL, Text.translatable(new Identifier(MOD_ID, "legacy").toTranslationKey()));
		});

		ModEffects.registerStatusEffects();
		ModBlocks.registerModBlocks();
		FieldRegistrationHandler.register(TSItems.class, MOD_ID, true);
		ModMessages.registerC2SPackets();
		ModArmory.registerArmory();
		ModPotions.registerPotions();
		ModEntities.registerModEntities();

		ModBlockEntities.registerBlockEntities();
		ModRecipes.registerRecipes();
		ModVillagers.registerVillagers();
		ModVillagers.registerTrades();

		//ModRegistries.registerModelPredicates();
		ModRegistries.registerWorldLevelState();
		ModRegistries.registerFlammableBlocks();
		ModRegistries.registerStrippables();
		ModRegistries.registerFuels();
		ModRegistries.registerCommands();
		ModRegistries.registerParticles();
		ModLootTableModifiers.modifyLootTables();

		FabricDefaultAttributeRegistry.register(ModEntities.SENTINEL, SentinelEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.JANITOR_DROID, RoombaEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.FLORBUS, FlorbusEntity.setAttributes());

		SENTINELS.addCustomTab(Icon.of(TSItems.Magic.IMPERIAL_GLADIUS),"magic", (context, entries) -> {
			entries.addItem(TSItems.Magic.ROSE_GOLD_HELMET);
			entries.addItem(TSItems.Magic.ROSE_GOLD_CHESTPLATE);
			entries.addItem(TSItems.Magic.ROSE_GOLD_LEGGINGS);
			entries.addItem(TSItems.Magic.ROSE_GOLD_BOOTS);

			entries.addItem(TSItems.Magic.ARMA_DEI_SWORD);
			entries.addItem(TSItems.Magic.ARMA_DEI_DAGGER);
			entries.addItem(TSItems.Magic.ARMA_DEI_PICKAXE);
			entries.addItem(TSItems.Magic.ARMA_DEI_BATTLEAXE);
			entries.addItem(TSItems.Magic.ARMA_DEI_SHOVEL);
			entries.addItem(TSItems.Magic.ARMA_DEI_SICKLE);
			entries.addItem(TSItems.Magic.ARMA_DEI_HELMET);
			entries.addItem(TSItems.Magic.ARMA_DEI_CHESTPLATE);
			entries.addItem(TSItems.Magic.ARMA_DEI_LEGGINGS);
			entries.addItem(TSItems.Magic.ARMA_DEI_BOOTS);
		}, false);
		SENTINELS.addCustomTab(Icon.of(TSItems.Tech.SENTINEL_HARD_LIGHT_PROJECTOR),"tech", (context, entries) -> {
			entries.addStack(TSItems.Tech.HARD_LIGHT_PROJECTOR.getDefaultStack());
			entries.addStack(TSItems.Tech.CAUTION_HARD_LIGHT_PROJECTOR.getDefaultStack());
			entries.addStack(TSItems.Tech.SENTINEL_HARD_LIGHT_PROJECTOR.getDefaultStack());
			entries.addItem(TSItems.Tech.PLASMA_CELL);
			entries.addItem(TSItems.Tech.PAINT_PACK);
			entries.addItem(TSItems.Tech.PHOTONIC_LENS);

			entries.addItem(TSItems.Tech.SCRAP_METAL_SWORD);
			entries.addItem(TSItems.Tech.SCRAP_METAL_KNIFE);
			entries.addItem(TSItems.Tech.SCRAP_METAL_PHASER);
			entries.addStack(PhaserItem.getPreloadedStack(TSItems.Tech.SCRAP_METAL_PHASER, "comet", 0, TextUtil.SENTINEL_CRIMSON2,
				new ItemStack(TSItems.Tech.COUNTERFORCE_DIFFUSER)));
			entries.addItem(TSItems.Tech.SCRAP_METAL_DRILL);
			entries.addItem(TSItems.Tech.SCRAP_METAL_CHAINSAW);
			entries.addItem(TSItems.Tech.SCRAP_METAL_SHOVEL);
			entries.addItem(TSItems.Tech.SCRAP_METAL_HOE);
			entries.addItem(TSItems.Tech.SCRAP_METAL_HELMET);
			entries.addItem(TSItems.Tech.SCRAP_METAL_CHESTPLATE);
			entries.addItem(TSItems.Tech.SCRAP_METAL_LEGGINGS);
			entries.addItem(TSItems.Tech.SCRAP_METAL_BOOTS);

			entries.addItem(TSItems.Tech.STARSTEEL_SWORD);
			entries.addItem(TSItems.Tech.STARSTEEL_KNIFE);
			entries.addItem(TSItems.Tech.STARSTEEL_PHASER);
			entries.addItem(TSItems.Tech.STARSTEEL_DRILL);
			entries.addItem(TSItems.Tech.STARSTEEL_AXE);
			entries.addItem(TSItems.Tech.STARSTEEL_SHOVEL);
			entries.addItem(TSItems.Tech.STARSTEEL_HOE);
			entries.addItem(TSItems.Tech.STARSTEEL_HELMET);
			entries.addItem(TSItems.Tech.STARSTEEL_CHESTPLATE);
			entries.addItem(TSItems.Tech.STARSTEEL_LEGGINGS);
			entries.addItem(TSItems.Tech.STARSTEEL_BOOTS);

			entries.addItem(TSItems.Tech.INDUSTRIAL_PHASER);
			entries.addStack(PhaserItem.getPreloadedStack(TSItems.Tech.STARSTEEL_PHASER, "lunar", 0, TextUtil.SENTINEL_GOLD1,
				new ItemStack(TSItems.Tech.PHASE_ASSIMILATOR), new ItemStack(TSItems.Tech.AUXILIARY_PLASMA_CHAMBER), new ItemStack(TSItems.Tech.AUXILIARY_PLASMA_CHAMBER)));
			entries.addItem(TSItems.Tech.NUCLEAR_PHASER);
			entries.addStack(PhaserItem.getPreloadedStack(TSItems.Tech.NUCLEAR_PHASER, "pandemic", 0, TextUtil.NUCLEAR3,
				new ItemStack(TSItems.Tech.POISON_CAPSULE), new ItemStack(TSItems.Tech.AUXILIARY_PLASMA_CHAMBER), new ItemStack(TSItems.Tech.AUXILIARY_PLASMA_CHAMBER),
				new ItemStack(TSItems.Tech.WITHER_CAPSULE), new ItemStack(TSItems.Tech.ADVANCED_BREECH_MECHANISM)));
			entries.addItem(TSItems.Tech.NANOTECH_PHASER);
			entries.addStack(PhaserItem.getPreloadedStack(TSItems.Tech.NANOTECH_PHASER, "serenity", 0, TextUtil.SENTINEL_AQUA1,
				new ItemStack(TSItems.Tech.PHASE_ASSIMILATOR), new ItemStack(TSItems.Tech.ADVANCED_BREECH_MECHANISM), new ItemStack(TSItems.Tech.ADVANCED_BREECH_MECHANISM),
				new ItemStack(TSItems.Tech.COUNTERFORCE_DIFFUSER), new ItemStack(TSItems.Tech.ADVANCED_BREECH_MECHANISM), new ItemStack(TSItems.Tech.ADVANCED_BREECH_MECHANISM)));

			entries.addItem(TSItems.Tech.ZENITHIUM_SWORD);
			entries.addItem(TSItems.Tech.ZENITHIUM_DAGGER);
			entries.addItem(TSItems.Tech.ZENITHIUM_PHASER);
			entries.addItem(TSItems.Tech.ZENITHIUM_PICKAXE);
			entries.addItem(TSItems.Tech.ZENITHIUM_AXE);
			entries.addItem(TSItems.Tech.ZENITHIUM_SHOVEL);
			entries.addItem(TSItems.Tech.ZENITHIUM_HOE);
			entries.addItem(TSItems.Tech.ZENITHIUM_HELMET);
			entries.addItem(TSItems.Tech.ZENITHIUM_CHESTPLATE);
			entries.addItem(TSItems.Tech.ZENITHIUM_LEGGINGS);
			entries.addItem(TSItems.Tech.ZENITHIUM_BOOTS);
		}, false);
		SENTINELS.addCustomTab(Icon.of(TSItems.Tech.ZENITHIUM_CLUSTER),"beta", (context, entries) -> {
			entries.addItem(TSItems.Magic.RESISTANCE_ITEM);
			entries.addItem(TSItems.Magic.FIRE_RESISTANCE_ITEM);
		}, false);
		//SENTINELS.addButton(ItemGroupButton.link(SENTINELS, Icon.of(TSItems.Tech.MUSIC_DISC_LAPSE_IN_JUDGEMENT), "wiki", "https://github.com/jainen1/Trevors-Sentinels-Quilt"));
		SENTINELS.initialize();
	}
}
