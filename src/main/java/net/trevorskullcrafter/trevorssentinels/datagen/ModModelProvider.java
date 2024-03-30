package net.trevorskullcrafter.trevorssentinels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.model.BlockStateModelGenerator;
import net.minecraft.data.client.model.Model;
import net.minecraft.data.client.model.Models;
import net.minecraft.item.Item;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.item.MagicItems;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.item.TechItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) { super(output); }

    @Override public void generateBlockStateModels(BlockStateModelGenerator blockStateGenerator) {
        blockStateGenerator.registerLog(ModBlocks.CAUTION_STEEL_BLOCK);

        blockStateGenerator.registerSimpleCubeAll(ModBlocks.NUCLEAR_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.NUCLEAR_ORE);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.BLACK_AGILITY_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.BLUE_AGILITY_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.ORANGE_AGILITY_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.STAINLESS_STEEL_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.RUSTED_STEEL_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.STEEL_FAN);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.LIGHT_CHAMBER_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.DARK_CHAMBER_BLOCK);

        blockStateGenerator.registerSimpleCubeAll(ModBlocks.IRON_GOLD_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.COPPER_IRON_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.ROSE_GOLD_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.WAX_INFUSED_COPPER_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.DARKSTEEL_BLOCK);

        blockStateGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_END_STONE_BRICKS);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_GALINITE_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_SNOWSTONE);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.GALINITE_BLOCK);

        BlockStateModelGenerator.BlockTexturePool steelPool = blockStateGenerator.registerCubeAllModelTexturePool(ModBlocks.STEEL_BLOCK);
        steelPool.family(ModBlocks.STEEL_FAMILY);

        BlockStateModelGenerator.BlockTexturePool smooth_snowstonePool = blockStateGenerator.registerCubeAllModelTexturePool(ModBlocks.SMOOTH_SNOWSTONE);
        smooth_snowstonePool.stairs(ModBlocks.SMOOTH_SNOWSTONE_STAIRS);
        smooth_snowstonePool.slab(ModBlocks.SMOOTH_SNOWSTONE_SLAB);
        smooth_snowstonePool.wall(ModBlocks.SMOOTH_SNOWSTONE_WALL);

        registerWoodType(blockStateGenerator, ModBlocks.VIRIDIAN_LOG, ModBlocks.VIRIDIAN_WOOD, ModBlocks.STRIPPED_VIRIDIAN_LOG, ModBlocks.STRIPPED_VIRIDIAN_WOOD,
                ModBlocks.VIRIDIAN_LEAVES, ModBlocks.VIRIDIAN_SAPLING, ModBlocks.POTTED_VIRIDIAN_SAPLING);
        BlockStateModelGenerator.BlockTexturePool viridescentPool = blockStateGenerator.registerCubeAllModelTexturePool(ModBlocks.VIRIDIAN_PLANKS);
        viridescentPool.family(ModBlocks.VIRIDIAN_FAMILY);

        registerWoodType(blockStateGenerator, ModBlocks.CERULII_LOG, ModBlocks.CERULII_WOOD, ModBlocks.STRIPPED_CERULII_LOG, ModBlocks.STRIPPED_CERULII_WOOD,
                ModBlocks.CERULII_LEAVES, ModBlocks.CERULII_SAPLING, ModBlocks.POTTED_CERULII_SAPLING);
        BlockStateModelGenerator.BlockTexturePool ceruliiPool = blockStateGenerator.registerCubeAllModelTexturePool(ModBlocks.CERULII_PLANKS);
        ceruliiPool.family(ModBlocks.CERULII_FAMILY);

        registerWoodType(blockStateGenerator, ModBlocks.CHARRED_LOG, ModBlocks.CHARRED_WOOD, ModBlocks.STRIPPED_CHARRED_LOG, ModBlocks.STRIPPED_CHARRED_WOOD,
                null, null, null);
        BlockStateModelGenerator.BlockTexturePool charredPool = blockStateGenerator.registerCubeAllModelTexturePool(ModBlocks.CHARRED_PLANKS);
        charredPool.family(ModBlocks.CHARRED_FAMILY);

        registerWoodType(blockStateGenerator, ModBlocks.MIDAS_LOG, ModBlocks.MIDAS_WOOD, ModBlocks.STRIPPED_MIDAS_LOG, ModBlocks.STRIPPED_MIDAS_WOOD,
                ModBlocks.MIDAS_LEAVES, ModBlocks.MIDAS_SAPLING, ModBlocks.POTTED_MIDAS_SAPLING);
        BlockStateModelGenerator.BlockTexturePool midasPool = blockStateGenerator.registerCubeAllModelTexturePool(ModBlocks.MIDAS_PLANKS);
        midasPool.family(ModBlocks.MIDAS_FAMILY);

        registerWoodType(blockStateGenerator, ModBlocks.PALE_LOG, ModBlocks.PALE_WOOD, ModBlocks.STRIPPED_PALE_LOG, ModBlocks.STRIPPED_PALE_WOOD,
                null, ModBlocks.PALE_SAPLING, ModBlocks.POTTED_PALE_SAPLING);
        BlockStateModelGenerator.BlockTexturePool yggdrasilPool = blockStateGenerator.registerCubeAllModelTexturePool(ModBlocks.PALE_PLANKS);
        yggdrasilPool.family(ModBlocks.PALE_FAMILY);
    }

    @Override public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		//itemModelGenerator.registerArmor()
		registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, TechItems.SCRAP_METAL_HELMET, TechItems.SCRAP_METAL_CHESTPLATE, TechItems.SCRAP_METAL_LEGGINGS, TechItems.SCRAP_METAL_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, TechItems.SCRAP_METAL_SWORD, TechItems.SCRAP_METAL_KNIFE, TechItems.SCRAP_METAL_DRILL,
			TechItems.SCRAP_METAL_CHAINSAW, TechItems.SCRAP_METAL_SHOVEL, TechItems.SCRAP_METAL_HOE);

        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, TechItems.STARSTEEL_HELMET, TechItems.STARSTEEL_CHESTPLATE, TechItems.STARSTEEL_LEGGINGS, TechItems.STARSTEEL_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, TechItems.STARSTEEL_SWORD, TechItems.STARSTEEL_KNIFE, TechItems.STARSTEEL_DRILL,
			TechItems.STARSTEEL_AXE, TechItems.STARSTEEL_SHOVEL, TechItems.STARSTEEL_HOE);

        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, MagicItems.ROSE_GOLD_HELMET, MagicItems.ROSE_GOLD_CHESTPLATE, MagicItems.ROSE_GOLD_LEGGINGS, MagicItems.ROSE_GOLD_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, MagicItems.ROSE_GOLD_SWORD, MagicItems.ROSE_GOLD_DAGGER, MagicItems.ROSE_GOLD_PICKAXE,
			MagicItems.ROSE_GOLD_BATTLEAXE, MagicItems.ROSE_GOLD_SHOVEL, MagicItems.ROSE_GOLD_SICKLE);

        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, TechItems.INDUSTRIAL_HELMET, TechItems.INDUSTRIAL_CHESTPLATE, TechItems.INDUSTRIAL_LEGGINGS, TechItems.INDUSTRIAL_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, TechItems.INDUSTRIAL_SWORD, TechItems.INDUSTRIAL_KNIFE, TechItems.TRIMETAL_PICKAXE,
			TechItems.TRIMETAL_AXE, TechItems.TRIMETAL_SHOVEL, TechItems.TRIMETAL_HOE);

        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, MagicItems.IMPERIAL_HELMET, MagicItems.IMPERIAL_CHESTPLATE, MagicItems.IMPERIAL_LEGGINGS, MagicItems.IMPERIAL_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, MagicItems.IMPERIAL_SWORD, MagicItems.IMPERIAL_GLADIUS, MagicItems.IMPERIAL_PICKAXE, MagicItems.IMPERIAL_BATTLEAXE,
			MagicItems.IMPERIAL_SHOVEL, MagicItems.IMPERIAL_SICKLE);

        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, MagicItems.UNHOLY_HELMET, MagicItems.UNHOLY_CHESTPLATE, MagicItems.UNHOLY_LEGGINGS,
			MagicItems.UNHOLY_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, MagicItems.UNHOLY_SWORD, MagicItems.UNHOLY_DAGGER, MagicItems.UNHOLY_PICKAXE,
			MagicItems.UNHOLY_BATTLEAXE, MagicItems.UNHOLY_SHOVEL, MagicItems.UNHOLY_SICKLE);

        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, TechItems.NUCLEAR_HELMET, TechItems.NUCLEAR_CHESTPLATE, TechItems.NUCLEAR_LEGGINGS, TechItems.NUCLEAR_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, TechItems.NUCLEAR_SWORD, TechItems.NUCLEAR_VIBROKNIFE, TechItems.NUCLEAR_DRILL, TechItems.NUCLEAR_AXE,
			TechItems.NUCLEAR_SHOVEL, TechItems.NUCLEAR_HOE);

        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, TechItems.NANOTECH_HELMET, TechItems.NANOTECH_CHESTPLATE, TechItems.NANOTECH_LEGGINGS, TechItems.NANOTECH_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, TechItems.NANOTECH_SWORD, TechItems.NANOTECH_VIBROKNIFE, TechItems.NANOTECH_DRILL, TechItems.NANOTECH_AXE,
			TechItems.NANOTECH_SHOVEL, TechItems.NANOTECH_HOE);

        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, MagicItems.THANATU_HELMET, MagicItems.THANATU_CHESTPLATE, MagicItems.THANATU_LEGGINGS, MagicItems.THANATU_BOOTS);

        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, MagicItems.BLACKSMITHS_WELDING_MASK, MagicItems.MAD_SCIENTISTS_LAB_COAT, TechItems.ZENITHIUM_CHESTPLATE,
			TechItems.ZENITHIUM_LEGGINGS, TechItems.ZENITHIUM_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, TechItems.ZENITHIUM_SWORD, TechItems.ZENITHIUM_DAGGER, TechItems.ZENITHIUM_PICKAXE,
			TechItems.ZENITHIUM_AXE, TechItems.ZENITHIUM_SHOVEL, TechItems.ZENITHIUM_HOE, MagicItems.MASTER_SWORD);

        //food
        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, ModItems.ANTIMILK, ModItems.ASH, ModItems.PEARFRUIT, ModItems.MIDAS_FRUIT, ModItems.BANANA, ModItems.BANANA_BREAD,
			ModItems.BROWNIE, ModItems.RICE_SEEDS, ModItems.RICE_CAKE, ModItems.GOLDEN_RICE_SEEDS, ModItems.GOLDEN_RICE_CAKE, ModItems.TORTILLA, ModItems.BURRITO,ModItems.CHORUS_COBBLER,
			TechItems.COLA_CYAN, TechItems.COLA_GREEN, TechItems.COLA_ORANGE, TechItems.MILK_CAN, TechItems.BEETROOT_SOUP_CAN, TechItems.MUSHROOM_STEW_CAN, TechItems.RABBIT_STEW_CAN,
			ModItems.SANDFISH, ModItems.COOKED_SANDFISH, ModItems.DUNE_EEL, ModItems.SMOKED_FISH, MagicItems.DUBIOUS_BACON, ModItems.FRIED_EGG, ModItems.SUSHI_ROLL);

        //progression materials
        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, TechItems.SCRAP_METAL_SHARD, ModItems.COPPER_IRON_INGOT, MagicItems.ROSE_GOLD_INGOT, MagicItems.IMPERIAL_ALLOY_INGOT,
                ModItems.GUNMETAL_INGOT, TechItems.NANOTECH_CAPSULE, TechItems.STARSTEEL_INGOT, ModItems.REDSTONE_CRYSTAL, ModItems.BLOOD_DIAMOND, MagicItems.UNHOLY_INGOT,
                TechItems.NUCLEAR_INGOT, TechItems.ZENITHIUM_CLUSTER);

        //misc
        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, TechItems.EMPTY_CAN, MagicItems.EYE_OF_RUIN, TechItems.ENERGY_CELL,
                TechItems.NUCLEAR_ROCKET, TechItems.MUSIC_DISC_ASSASSINATION_UPLOAD, TechItems.MUSIC_DISC_LAPSE_IN_JUDGEMENT,
                TechItems.MUSIC_DISC_ODE_TO_TRANQUILITY, TechItems.MUSIC_DISC_RECITAL);

        registerItems(itemModelGenerator, Models.HANDHELD, TechItems.HARD_LIGHT_PROJECTOR, TechItems.CAUTION_HARD_LIGHT_PROJECTOR, TechItems.SENTINEL_HARD_LIGHT_PROJECTOR);

        itemModelGenerator.register(ModItems.VENDOR_TOKEN, ModItems.LEGENDARY_TOKEN, Models.SINGLE_LAYER_ITEM);
        itemModelGenerator.register(MagicItems.DEMONIC_CORE, Models.SINGLE_LAYER_ITEM);

        //effect items
        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, MagicItems.GALLIUM_STOMACH, MagicItems.ONE_PENCE);

        itemModelGenerator.register(MagicItems.PALE_HANGING_SIGN, Models.SINGLE_LAYER_ITEM);
    }

    public void registerWoodType(BlockStateModelGenerator generator, Block LOG, Block WOOD, Block STRIPPED_LOG, Block STRIPPED_WOOD, Block LEAVES, Block SAPLING, Block POTTED_SAPLING){
        if (LOG != null && WOOD != null) generator.registerLog(LOG).log(LOG).wood(WOOD);
        if (STRIPPED_LOG != null && STRIPPED_WOOD != null) generator.registerLog(STRIPPED_LOG).log(STRIPPED_LOG).wood(STRIPPED_WOOD);
        if (SAPLING != null && POTTED_SAPLING != null) generator.registerFlowerPotPlant(SAPLING, POTTED_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        if(LEAVES != null) generator.registerSimpleCubeAll(LEAVES);
    }

    public void registerItems(ItemModelGenerator itemModelGenerator, Model model, Item... items){
        for (Item item:items) { itemModelGenerator.register(item, model); }
    }
}
