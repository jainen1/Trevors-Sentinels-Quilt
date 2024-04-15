package net.trevorskullcrafter.trevorssentinels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.item.TSItems;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) { super(dataOutput); }

    @Override public void generate() {
        addDrop(ModBlocks.DIRT_SLAB);
        addDrop(ModBlocks.DIRT_STAIRS);
        addDrop(ModBlocks.COARSE_DIRT_SLAB);
        addDrop(ModBlocks.COARSE_DIRT_STAIRS);
        addDrop(ModBlocks.MOSS_SLAB);
        addDrop(ModBlocks.MOSS_STAIRS);
        addDrop(ModBlocks.COPPER_IRON_BLOCK);
        addDrop(ModBlocks.ROSE_GOLD_BLOCK);
        addDrop(ModBlocks.IMPERIAL_ALLOY_BLOCK);
        addDrop(ModBlocks.LIGHT_CHAMBER_BLOCK);
        addDrop(ModBlocks.DARK_CHAMBER_BLOCK);

        addDrop(ModBlocks.BATTERY);
        addDrop(ModBlocks.FUSEBOX);
        addDrop(ModBlocks.NUCLEAR_BLOCK);
        addDrop(ModBlocks.BIG_RED_BUTTON);
        addDrop(ModBlocks.BIG_RED_PLATE);
        addDrop(ModBlocks.BLACK_AGILITY_BLOCK);
        addDrop(ModBlocks.BLUE_AGILITY_BLOCK);
        addDrop(ModBlocks.CHISELED_STARSTEEL_BLOCK);
        addDrop(ModBlocks.CHISELED_END_STONE_BRICKS);
        addDrop(ModBlocks.CRACKED_END_STONE_BRICKS);
        addDrop(ModBlocks.END_STONE_BRICK_COLUMN);
        addDrop(ModBlocks.SCRAP_METAL_BLOCK);
        addDrop(ModBlocks.SCRAP_METAL_PILLAR);
        addDrop(ModBlocks.CHISELED_SCRAP_METAL_BLOCK);
        addDrop(ModBlocks.SNOWSTONE);
        addDrop(ModBlocks.SNOWSTONE_SLAB);
        addDrop(ModBlocks.SNOWSTONE_STAIRS);
        addDrop(ModBlocks.SMOOTH_SNOWSTONE);
        addDrop(ModBlocks.SMOOTH_SNOWSTONE_SLAB);
        addDrop(ModBlocks.SMOOTH_SNOWSTONE_STAIRS);
        addDrop(ModBlocks.CHISELED_SNOWSTONE);
        addDrop(ModBlocks.SNOWSTONE_WALL);
        addDrop(ModBlocks.CUT_SNOWSTONE);
        addDrop(ModBlocks.CUT_SNOWSTONE_SLAB);
        addDrop(ModBlocks.ORANGE_AGILITY_BLOCK);
        addDrop(ModBlocks.UNHOLY_BLOCK);
        addDrop(ModBlocks.STARSTEEL_BLOCK);
        addDrop(ModBlocks.STAINLESS_STEEL_BLOCK);
        addDrop(ModBlocks.RUSTED_STEEL_BLOCK);
        addDrop(ModBlocks.WAX_INFUSED_COPPER_BLOCK);
        addDrop(ModBlocks.STARSTEEL_FAN);
        addDrop(ModBlocks.STARSTEEL_LADDER);
        addDrop(ModBlocks.STARSTEEL_LAMP);
        addDrop(ModBlocks.RECONSTRUCTION_TABLE);
        addDrop(ModBlocks.TRANQUIL_ROSE);
        addPottedPlantDrops(ModBlocks.POTTED_TRANQUIL_ROSE);
        addDrop(ModBlocks.SKULLWEED);
        addPottedPlantDrops(ModBlocks.POTTED_SKULLWEED);

        addDrop(ModBlocks.STARSTEEL_SIGN, TSItems.Tech.STARSTEEL_SIGN);
        addDrop(ModBlocks.STARSTEEL_WALL_SIGN, TSItems.Tech.STARSTEEL_SIGN);
        addDrop(ModBlocks.STARSTEEL_HANGING_SIGN, TSItems.Tech.STARSTEEL_HANGING_SIGN);
        addDrop(ModBlocks.STARSTEEL_WALL_HANGING_SIGN, TSItems.Tech.STARSTEEL_HANGING_SIGN);

        addDrop(ModBlocks.HOLOGRAPHIC_SIGN, TSItems.Tech.HOLOGRAPHIC_SIGN);
        addDrop(ModBlocks.HOLOGRAPHIC_WALL_SIGN, TSItems.Tech.HOLOGRAPHIC_SIGN);
		addDrop(ModBlocks.HOLOGRAPHIC_HANGING_SIGN, TSItems.Tech.HOLOGRAPHIC_HANGING_SIGN);
		addDrop(ModBlocks.HOLOGRAPHIC_WALL_HANGING_SIGN, TSItems.Tech.HOLOGRAPHIC_HANGING_SIGN);

		addDrop(ModBlocks.CAUTION_HOLOGRAPHIC_SIGN, TSItems.Tech.CAUTION_HOLOGRAPHIC_SIGN);
		addDrop(ModBlocks.CAUTION_HOLOGRAPHIC_WALL_SIGN, TSItems.Tech.CAUTION_HOLOGRAPHIC_SIGN);
		addDrop(ModBlocks.CAUTION_HOLOGRAPHIC_HANGING_SIGN, TSItems.Tech.CAUTION_HOLOGRAPHIC_SIGN);
		addDrop(ModBlocks.CAUTION_HOLOGRAPHIC_WALL_HANGING_SIGN, TSItems.Tech.CAUTION_HOLOGRAPHIC_SIGN);

		addDrop(ModBlocks.SENTINEL_HOLOGRAPHIC_SIGN, TSItems.Tech.SENTINEL_HOLOGRAPHIC_SIGN);
		addDrop(ModBlocks.SENTINEL_HOLOGRAPHIC_WALL_SIGN, TSItems.Tech.SENTINEL_HOLOGRAPHIC_SIGN);
		addDrop(ModBlocks.SENTINEL_HOLOGRAPHIC_HANGING_SIGN, TSItems.Tech.SENTINEL_HOLOGRAPHIC_SIGN);
		addDrop(ModBlocks.SENTINEL_HOLOGRAPHIC_WALL_HANGING_SIGN, TSItems.Tech.SENTINEL_HOLOGRAPHIC_SIGN);

        addDrop(ModBlocks.FLESH_BLOCK);
        add(ModBlocks.FLESHY_EYE, silkDrop(ModBlocks.FLESHY_EYE, TSItems.Magic.EYE_OF_RUIN));

        addDrop(ModBlocks.VIRIDIAN_BUTTON);
        addDrop(ModBlocks.VIRIDIAN_DOOR);
        addDrop(ModBlocks.VIRIDIAN_FENCE);
        addDrop(ModBlocks.VIRIDIAN_FENCE_GATE);
        add(ModBlocks.VIRIDIAN_LEAVES, leavesWithFruitDrop(ModBlocks.VIRIDIAN_LEAVES, ModItems.BANANA, ModBlocks.VIRIDIAN_SAPLING, 0.25f));
        addDrop(ModBlocks.VIRIDIAN_LOG);
        addDrop(ModBlocks.VIRIDIAN_PLANKS);
        addDrop(ModBlocks.VIRIDIAN_PRESSURE_PLATE);
        addDrop(ModBlocks.VIRIDIAN_SAPLING);
        addPottedPlantDrops(ModBlocks.POTTED_VIRIDIAN_SAPLING);
        addDrop(ModBlocks.VIRIDIAN_SIGN, TSItems.Magic.VIRIDIAN_SIGN);
        addDrop(ModBlocks.VIRIDIAN_SLAB);
        addDrop(ModBlocks.VIRIDIAN_STAIRS);
        addDrop(ModBlocks.VIRIDIAN_TRAPDOOR);
        addDrop(ModBlocks.VIRIDIAN_WALL_SIGN, TSItems.Magic.VIRIDIAN_SIGN);
        addDrop(ModBlocks.VIRIDIAN_HANGING_SIGN, TSItems.Magic.VIRIDIAN_HANGING_SIGN);
        addDrop(ModBlocks.VIRIDIAN_WALL_HANGING_SIGN, TSItems.Magic.VIRIDIAN_HANGING_SIGN);
        addDrop(ModBlocks.VIRIDIAN_WOOD);
        addDrop(ModBlocks.STRIPPED_VIRIDIAN_LOG);
        addDrop(ModBlocks.STRIPPED_VIRIDIAN_WOOD);

        addDrop(ModBlocks.CERULII_BUTTON);
        addDrop(ModBlocks.CERULII_DOOR);
        addDrop(ModBlocks.CERULII_FENCE);
        addDrop(ModBlocks.CERULII_FENCE_GATE);
        add(ModBlocks.CERULII_LEAVES, leavesDrops(ModBlocks.CERULII_LEAVES, ModBlocks.CERULII_SAPLING, 0.25f));
        addDrop(ModBlocks.CERULII_LOG);
        addDrop(ModBlocks.CERULII_PLANKS);
        addDrop(ModBlocks.CERULII_PRESSURE_PLATE);
        addDrop(ModBlocks.CERULII_SAPLING);
        addPottedPlantDrops(ModBlocks.POTTED_CERULII_SAPLING);
        addDrop(ModBlocks.CERULII_SIGN, TSItems.Magic.CERULII_SIGN);
        addDrop(ModBlocks.CERULII_SLAB);
        addDrop(ModBlocks.CERULII_STAIRS);
        addDrop(ModBlocks.CERULII_TRAPDOOR);
        addDrop(ModBlocks.CERULII_WALL_SIGN, TSItems.Magic.CERULII_SIGN);
        addDrop(ModBlocks.CERULII_HANGING_SIGN, TSItems.Magic.CERULII_HANGING_SIGN);
        addDrop(ModBlocks.CERULII_WALL_HANGING_SIGN, TSItems.Magic.CERULII_HANGING_SIGN);
        addDrop(ModBlocks.CERULII_WOOD);
        addDrop(ModBlocks.STRIPPED_CERULII_LOG);
        addDrop(ModBlocks.STRIPPED_CERULII_WOOD);

        addDrop(ModBlocks.CHARRED_BUTTON);
        addDrop(ModBlocks.CHARRED_DOOR);
        addDrop(ModBlocks.CHARRED_FENCE);
        addDrop(ModBlocks.CHARRED_FENCE_GATE);
        addDrop(ModBlocks.CHARRED_LOG);
        addDrop(ModBlocks.CHARRED_PLANKS);
        addDrop(ModBlocks.CHARRED_PRESSURE_PLATE);
        addDrop(ModBlocks.CHARRED_SIGN, TSItems.Magic.CHARRED_SIGN);
        addDrop(ModBlocks.CHARRED_SLAB);
        addDrop(ModBlocks.CHARRED_STAIRS);
        addDrop(ModBlocks.CHARRED_TRAPDOOR);
        addDrop(ModBlocks.CHARRED_WALL_SIGN, TSItems.Magic.CHARRED_SIGN);
        addDrop(ModBlocks.CHARRED_HANGING_SIGN, TSItems.Magic.CHARRED_HANGING_SIGN);
        addDrop(ModBlocks.CHARRED_WALL_HANGING_SIGN, TSItems.Magic.CHARRED_HANGING_SIGN);
        addDrop(ModBlocks.CHARRED_WOOD);
        addDrop(ModBlocks.STRIPPED_CHARRED_LOG);
        addDrop(ModBlocks.STRIPPED_CHARRED_WOOD);

        addDrop(ModBlocks.MIDAS_BUTTON);
        addDrop(ModBlocks.MIDAS_DOOR);
        addDrop(ModBlocks.MIDAS_FENCE);
        addDrop(ModBlocks.MIDAS_FENCE_GATE);
        add(ModBlocks.MIDAS_LEAVES, leavesWithFruitDrop(ModBlocks.MIDAS_LEAVES, ModItems.MIDAS_FRUIT, ModBlocks.MIDAS_SAPLING, 0.25f));
        addDrop(ModBlocks.MIDAS_LOG);
        addDrop(ModBlocks.MIDAS_PLANKS);
        addDrop(ModBlocks.MIDAS_PRESSURE_PLATE);
        addDrop(ModBlocks.MIDAS_SAPLING);
        addPottedPlantDrops(ModBlocks.POTTED_MIDAS_SAPLING);
        addDrop(ModBlocks.MIDAS_SIGN, TSItems.Magic.MIDAS_SIGN);
        addDrop(ModBlocks.MIDAS_SLAB);
        addDrop(ModBlocks.MIDAS_STAIRS);
        addDrop(ModBlocks.MIDAS_TRAPDOOR);
        addDrop(ModBlocks.MIDAS_WALL_SIGN, TSItems.Magic.MIDAS_SIGN);
        addDrop(ModBlocks.MIDAS_HANGING_SIGN, TSItems.Magic.MIDAS_HANGING_SIGN);
        addDrop(ModBlocks.MIDAS_WALL_HANGING_SIGN, TSItems.Magic.MIDAS_HANGING_SIGN);
        addDrop(ModBlocks.MIDAS_WOOD);
        addDrop(ModBlocks.STRIPPED_MIDAS_LOG);
        addDrop(ModBlocks.STRIPPED_MIDAS_WOOD);

        addDrop(ModBlocks.PALE_BUTTON);
        addDrop(ModBlocks.PALE_DOOR);
        addDrop(ModBlocks.PALE_FENCE);
        addDrop(ModBlocks.PALE_FENCE_GATE);
        add(ModBlocks.PALE_SAPLING, leavesWithFruitDrop(ModBlocks.PALE_LEAVES, ModItems.PEARFRUIT, ModBlocks.PALE_SAPLING, 0.25f));
        addDrop(ModBlocks.PALE_LOG);
        addDrop(ModBlocks.PALE_PLANKS);
        addDrop(ModBlocks.PALE_PRESSURE_PLATE);
        addDrop(ModBlocks.PALE_SAPLING);
        addPottedPlantDrops(ModBlocks.POTTED_PALE_SAPLING);
        addDrop(ModBlocks.PALE_SIGN, TSItems.Magic.PALE_SIGN);
        addDrop(ModBlocks.PALE_SLAB);
        addDrop(ModBlocks.PALE_STAIRS);
        addDrop(ModBlocks.PALE_TRAPDOOR);
        addDrop(ModBlocks.PALE_WALL_SIGN, TSItems.Magic.PALE_SIGN);
        addDrop(ModBlocks.PALE_HANGING_SIGN, TSItems.Magic.PALE_HANGING_SIGN);
        addDrop(ModBlocks.PALE_WALL_HANGING_SIGN, TSItems.Magic.PALE_HANGING_SIGN);
        addDrop(ModBlocks.PALE_WOOD);
        addDrop(ModBlocks.STRIPPED_PALE_LOG);
        addDrop(ModBlocks.STRIPPED_PALE_WOOD);

        add(ModBlocks.NUCLEAR_ORE, oreDrops(ModBlocks.NUCLEAR_ORE, TSItems.Tech.NUCLEAR_INGOT));
    }

    public LootTable.Builder silkDrop(Block silk, Item noSilk){
        return dropsWithSilkTouch(silk, applyExplosionDecay(silk, ItemEntry.builder(noSilk)));
    }

    public LootTable.Builder leavesWithFruitDrop(Block leaves, Item fruit, Block drop, float... chance) {
        return this.leavesDrops(leaves, drop, chance).pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                .conditionally(WITHOUT_SHEARS_OR_SILK_TOUCH).with(((LeafEntry.Builder<?>)this.applySurvivesExplosionCondition(leaves, ItemEntry.builder(fruit)))
                        .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, 0.005F, 0.00555F, 0.00625F, 0.00833F, 0.025F))));
    }
}
