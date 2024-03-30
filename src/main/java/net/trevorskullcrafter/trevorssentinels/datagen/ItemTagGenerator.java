package net.trevorskullcrafter.trevorssentinels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.HolderLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.item.BetaItems;
import net.trevorskullcrafter.trevorssentinels.item.MagicItems;
import net.trevorskullcrafter.trevorssentinels.item.TechItems;

import java.util.concurrent.CompletableFuture;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain.*;

public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {
	public ItemTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) { super(output, completableFuture); }

    public static final TagKey<Item> CROSSBOW_HOLD = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "crossbow_hold"));
    public static final TagKey<Item> ITEM_BAR_COLOR_OVERRIDE = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "item_bar_color_override"));

    public static final TagKey<Item> CERULII_LOGS = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "cerulii_logs"));
    public static final TagKey<Item> CHARRED_LOGS = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "charred_logs"));
    public static final TagKey<Item> MIDAS_LOGS = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "midas_logs"));
    public static final TagKey<Item> VIRIDIAN_LOGS = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "viridian_logs"));
    public static final TagKey<Item> PALE_LOGS = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "pale_logs"));

    public static final TagKey<EntityType<?>> MILKABLE = TagKey.of(RegistryKeys.ENTITY_TYPE, new Identifier(MOD_ID, "milkable"));

	@Override protected void configure(HolderLookup.Provider arg) {
		getOrCreateTagBuilder(CROSSBOW_HOLD)
			.add(TechItems.SCRAP_METAL_PHASER, TechItems.STARSTEEL_PHASER, TechItems.NANOTECH_PHASER, TechItems.ZENITHIUM_PHASER, TechItems.VILE_SPITTER);
		getOrCreateTagBuilder(ITEM_BAR_COLOR_OVERRIDE)
			.add(TechItems.NUCLEAR_SWORD, TechItems.NUCLEAR_DRILL, TechItems.NUCLEAR_AXE, TechItems.NUCLEAR_SHOVEL, TechItems.NUCLEAR_HOE, TechItems.NUCLEAR_HELMET,
				TechItems.NUCLEAR_CHESTPLATE, TechItems.NUCLEAR_LEGGINGS, TechItems.NUCLEAR_BOOTS, TechItems.NANOTECH_SWORD, TechItems.NANOTECH_DRILL,
				TechItems.NANOTECH_AXE, TechItems.NANOTECH_SHOVEL, TechItems.NANOTECH_HOE, TechItems.NANOTECH_HELMET, TechItems.NANOTECH_CHESTPLATE,
				TechItems.NANOTECH_LEGGINGS, TechItems.NANOTECH_BOOTS, TechItems.ZENITHIUM_SWORD, TechItems.ZENITHIUM_PICKAXE, TechItems.ZENITHIUM_AXE,
				TechItems.ZENITHIUM_SHOVEL, TechItems.ZENITHIUM_HOE, TechItems.ZENITHIUM_CHESTPLATE, TechItems.ZENITHIUM_LEGGINGS, TechItems.ZENITHIUM_BOOTS,
				MagicItems.DEMONIC_CORE, BetaItems.THANATU_BLADE, TechItems.HARD_LIGHT_PROJECTOR, TechItems.CAUTION_HARD_LIGHT_PROJECTOR, TechItems.SENTINEL_HARD_LIGHT_PROJECTOR,
				TechItems.SCRAP_METAL_PHASER, TechItems.STARSTEEL_PHASER, TechItems.NANOTECH_PHASER, TechItems.ZENITHIUM_PHASER, TechItems.VILE_SPITTER);

		getOrCreateTagBuilder(CERULII_LOGS)
			.add(ModBlocks.CERULII_LOG.asItem(), ModBlocks.CERULII_WOOD.asItem(), ModBlocks.STRIPPED_CERULII_LOG.asItem(), ModBlocks.STRIPPED_CERULII_WOOD.asItem());
		getOrCreateTagBuilder(CHARRED_LOGS)
			.add(ModBlocks.CHARRED_LOG.asItem(), ModBlocks.CHARRED_WOOD.asItem(), ModBlocks.STRIPPED_CHARRED_LOG.asItem(), ModBlocks.STRIPPED_CHARRED_WOOD.asItem());
		getOrCreateTagBuilder(MIDAS_LOGS)
			.add(ModBlocks.MIDAS_LOG.asItem(), ModBlocks.MIDAS_WOOD.asItem(), ModBlocks.STRIPPED_MIDAS_LOG.asItem(), ModBlocks.STRIPPED_MIDAS_WOOD.asItem());
		getOrCreateTagBuilder(VIRIDIAN_LOGS)
			.add(ModBlocks.VIRIDIAN_LOG.asItem(), ModBlocks.VIRIDIAN_WOOD.asItem(), ModBlocks.STRIPPED_VIRIDIAN_LOG.asItem(), ModBlocks.STRIPPED_VIRIDIAN_WOOD.asItem());
		getOrCreateTagBuilder(PALE_LOGS)
			.add(ModBlocks.PALE_LOG.asItem(), ModBlocks.PALE_WOOD.asItem(), ModBlocks.STRIPPED_PALE_LOG.asItem(), ModBlocks.STRIPPED_PALE_WOOD.asItem());
	}
}
