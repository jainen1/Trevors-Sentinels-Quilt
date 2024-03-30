package net.trevorskullcrafter.trevorssentinels;

import io.wispforest.owo.itemgroup.Icon;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import io.wispforest.owo.itemgroup.gui.ItemGroupButton;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.random.RandomGenerator;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.effect.ModEffects;
import net.trevorskullcrafter.trevorssentinels.item.MagicItems;
import net.trevorskullcrafter.trevorssentinels.item.TechItems;
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

		MagicItems.registerModItems();
		TechItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEffects.registerStatusEffects();

		SENTINELS.addCustomTab(Icon.of(MagicItems.IMPERIAL_GLADIUS),"magic", (context, entries) -> {
			entries.addItem(MagicItems.ROSE_GOLD_HELMET);
			entries.addItem(MagicItems.ROSE_GOLD_CHESTPLATE);
			entries.addItem(MagicItems.ROSE_GOLD_LEGGINGS);
			entries.addItem(MagicItems.ROSE_GOLD_BOOTS);
		}, false);
		SENTINELS.addCustomTab(Icon.of(TechItems.HARD_LIGHT_PROJECTOR),"tech", (context, entries) -> {
			entries.addItem(TechItems.HARD_LIGHT_PROJECTOR);
			entries.addItem(TechItems.CAUTION_HARD_LIGHT_PROJECTOR);
			entries.addItem(TechItems.SENTINEL_HARD_LIGHT_PROJECTOR);
		}, false);
		SENTINELS.addCustomTab(Icon.of(TechItems.ZENITHIUM_CLUSTER),"beta", (context, entries) -> {
			entries.addItem(MagicItems.RESISTANCE_ITEM);
			entries.addItem(MagicItems.FIRE_RESISTANCE_ITEM);
		}, false);
		SENTINELS.addButton(ItemGroupButton.link(SENTINELS, Icon.of(TechItems.MUSIC_DISC_ODE_TO_TRANQUILITY), "wiki", "about:blank"));
		SENTINELS.initialize();
	}
}
