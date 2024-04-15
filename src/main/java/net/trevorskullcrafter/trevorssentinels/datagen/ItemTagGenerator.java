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
import net.trevorskullcrafter.trevorssentinels.item.TSItems;

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
			.add(TSItems.Tech.SCRAP_METAL_PHASER, TSItems.Tech.STARSTEEL_PHASER, TSItems.Tech.NANOTECH_PHASER, TSItems.Tech.ZENITHIUM_PHASER, TSItems.Tech.VILE_SPITTER);
		getOrCreateTagBuilder(ITEM_BAR_COLOR_OVERRIDE)
			.add(TSItems.Tech.NUCLEAR_SWORD, TSItems.Tech.NUCLEAR_DRILL, TSItems.Tech.NUCLEAR_AXE, TSItems.Tech.NUCLEAR_SHOVEL, TSItems.Tech.NUCLEAR_HOE, TSItems.Tech.NUCLEAR_HELMET,
				TSItems.Tech.NUCLEAR_CHESTPLATE, TSItems.Tech.NUCLEAR_LEGGINGS, TSItems.Tech.NUCLEAR_BOOTS, TSItems.Tech.NANOTECH_SWORD, TSItems.Tech.NANOTECH_DRILL,
				TSItems.Tech.NANOTECH_AXE, TSItems.Tech.NANOTECH_SHOVEL, TSItems.Tech.NANOTECH_HOE, TSItems.Tech.NANOTECH_HELMET, TSItems.Tech.NANOTECH_CHESTPLATE,
				TSItems.Tech.NANOTECH_LEGGINGS, TSItems.Tech.NANOTECH_BOOTS, TSItems.Tech.ZENITHIUM_SWORD, TSItems.Tech.ZENITHIUM_PICKAXE, TSItems.Tech.ZENITHIUM_AXE,
				TSItems.Tech.ZENITHIUM_SHOVEL, TSItems.Tech.ZENITHIUM_HOE, TSItems.Tech.ZENITHIUM_CHESTPLATE, TSItems.Tech.ZENITHIUM_LEGGINGS, TSItems.Tech.ZENITHIUM_BOOTS,
				TSItems.Magic.DEMONIC_CORE, TSItems.Beta.THANATU_BLADE, TSItems.Tech.HARD_LIGHT_PROJECTOR, TSItems.Tech.CAUTION_HARD_LIGHT_PROJECTOR, TSItems.Tech.SENTINEL_HARD_LIGHT_PROJECTOR,
				TSItems.Tech.SCRAP_METAL_PHASER, TSItems.Tech.STARSTEEL_PHASER, TSItems.Tech.NANOTECH_PHASER, TSItems.Tech.ZENITHIUM_PHASER, TSItems.Tech.VILE_SPITTER);

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
