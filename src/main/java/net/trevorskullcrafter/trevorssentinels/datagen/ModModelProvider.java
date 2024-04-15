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
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.item.TSItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) { super(output); }

    @Override public void generateBlockStateModels(BlockStateModelGenerator blockStateGenerator) {
        blockStateGenerator.registerLog(ModBlocks.CHISELED_STARSTEEL_BLOCK);

        blockStateGenerator.registerSimpleCubeAll(ModBlocks.NUCLEAR_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.NUCLEAR_ORE);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.BLACK_AGILITY_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.BLUE_AGILITY_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.ORANGE_AGILITY_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.STAINLESS_STEEL_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.RUSTED_STEEL_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.STARSTEEL_FAN);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.LIGHT_CHAMBER_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.DARK_CHAMBER_BLOCK);

        blockStateGenerator.registerSimpleCubeAll(ModBlocks.IMPERIAL_ALLOY_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.COPPER_IRON_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.ROSE_GOLD_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.WAX_INFUSED_COPPER_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.UNHOLY_BLOCK);

        blockStateGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_END_STONE_BRICKS);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_SCRAP_METAL_BLOCK);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_SNOWSTONE);
        blockStateGenerator.registerSimpleCubeAll(ModBlocks.SCRAP_METAL_BLOCK);

        BlockStateModelGenerator.BlockTexturePool steelPool = blockStateGenerator.registerCubeAllModelTexturePool(ModBlocks.STARSTEEL_BLOCK);
        //steelPool.family(ModBlocks.STARSTEEL_FAMILY);

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
		registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, TSItems.Tech.SCRAP_METAL_HELMET, TSItems.Tech.SCRAP_METAL_CHESTPLATE, TSItems.Tech.SCRAP_METAL_LEGGINGS, TSItems.Tech.SCRAP_METAL_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, TSItems.Tech.SCRAP_METAL_SWORD, TSItems.Tech.SCRAP_METAL_KNIFE, TSItems.Tech.SCRAP_METAL_DRILL,
			TSItems.Tech.SCRAP_METAL_CHAINSAW, TSItems.Tech.SCRAP_METAL_SHOVEL, TSItems.Tech.SCRAP_METAL_HOE);

        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, TSItems.Tech.STARSTEEL_HELMET, TSItems.Tech.STARSTEEL_CHESTPLATE, TSItems.Tech.STARSTEEL_LEGGINGS, TSItems.Tech.STARSTEEL_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, TSItems.Tech.STARSTEEL_SWORD, TSItems.Tech.STARSTEEL_KNIFE, TSItems.Tech.STARSTEEL_DRILL,
			TSItems.Tech.STARSTEEL_AXE, TSItems.Tech.STARSTEEL_SHOVEL, TSItems.Tech.STARSTEEL_HOE);

        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, TSItems.Magic.ROSE_GOLD_HELMET, TSItems.Magic.ROSE_GOLD_CHESTPLATE, TSItems.Magic.ROSE_GOLD_LEGGINGS, TSItems.Magic.ROSE_GOLD_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, TSItems.Magic.ROSE_GOLD_SWORD, TSItems.Magic.ROSE_GOLD_DAGGER, TSItems.Magic.ROSE_GOLD_PICKAXE,
			TSItems.Magic.ROSE_GOLD_BATTLEAXE, TSItems.Magic.ROSE_GOLD_SHOVEL, TSItems.Magic.ROSE_GOLD_SICKLE);

        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, TSItems.Tech.INDUSTRIAL_HELMET, TSItems.Tech.INDUSTRIAL_HARNESS, TSItems.Tech.INDUSTRIAL_PANTS, TSItems.Tech.INDUSTRIAL_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, TSItems.Tech.INDUSTRIAL_CROWBAR, TSItems.Tech.INDUSTRIAL_KNIFE, TSItems.Tech.TRIMETAL_PICKAXE,
			TSItems.Tech.TRIMETAL_AXE, TSItems.Tech.TRIMETAL_SHOVEL, TSItems.Tech.TRIMETAL_HOE);

        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, TSItems.Magic.IMPERIAL_HELMET, TSItems.Magic.IMPERIAL_CHESTPLATE, TSItems.Magic.IMPERIAL_LEGGINGS, TSItems.Magic.IMPERIAL_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, TSItems.Magic.IMPERIAL_SWORD, TSItems.Magic.IMPERIAL_GLADIUS, TSItems.Magic.IMPERIAL_PICKAXE, TSItems.Magic.IMPERIAL_BATTLEAXE,
			TSItems.Magic.IMPERIAL_SHOVEL, TSItems.Magic.IMPERIAL_SICKLE);

        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, TSItems.Magic.UNHOLY_HELMET, TSItems.Magic.UNHOLY_CHESTPLATE, TSItems.Magic.UNHOLY_LEGGINGS,
			TSItems.Magic.UNHOLY_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, TSItems.Magic.UNHOLY_SWORD, TSItems.Magic.UNHOLY_DAGGER, TSItems.Magic.UNHOLY_PICKAXE,
			TSItems.Magic.UNHOLY_BATTLEAXE, TSItems.Magic.UNHOLY_SHOVEL, TSItems.Magic.UNHOLY_SICKLE);

        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, TSItems.Tech.NUCLEAR_HELMET, TSItems.Tech.NUCLEAR_CHESTPLATE, TSItems.Tech.NUCLEAR_LEGGINGS, TSItems.Tech.NUCLEAR_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, TSItems.Tech.NUCLEAR_SWORD, TSItems.Tech.NUCLEAR_VIBROKNIFE, TSItems.Tech.NUCLEAR_DRILL, TSItems.Tech.NUCLEAR_AXE,
			TSItems.Tech.NUCLEAR_SHOVEL, TSItems.Tech.NUCLEAR_HOE);

        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, TSItems.Tech.NANOTECH_HELMET, TSItems.Tech.NANOTECH_CHESTPLATE, TSItems.Tech.NANOTECH_LEGGINGS, TSItems.Tech.NANOTECH_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, TSItems.Tech.NANOTECH_SWORD, TSItems.Tech.NANOTECH_VIBROKNIFE, TSItems.Tech.NANOTECH_DRILL, TSItems.Tech.NANOTECH_AXE,
			TSItems.Tech.NANOTECH_SHOVEL, TSItems.Tech.NANOTECH_HOE);

        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, TSItems.Magic.THANATU_HELMET, TSItems.Magic.THANATU_CHESTPLATE, TSItems.Magic.THANATU_LEGGINGS, TSItems.Magic.THANATU_BOOTS);

        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, TSItems.Beta.BLACKSMITHS_WELDING_MASK, TSItems.Beta.MAD_SCIENTISTS_LAB_COAT, TSItems.Tech.ZENITHIUM_CHESTPLATE,
			TSItems.Tech.ZENITHIUM_LEGGINGS, TSItems.Tech.ZENITHIUM_BOOTS);
        registerItems(itemModelGenerator, Models.HANDHELD, TSItems.Tech.ZENITHIUM_SWORD, TSItems.Tech.ZENITHIUM_DAGGER, TSItems.Tech.ZENITHIUM_PICKAXE,
			TSItems.Tech.ZENITHIUM_AXE, TSItems.Tech.ZENITHIUM_SHOVEL, TSItems.Tech.ZENITHIUM_HOE);
		//TSItems.Magic.MASTER_SWORD

        //food
        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, ModItems.ASH, ModItems.PEARFRUIT, ModItems.MIDAS_FRUIT, ModItems.BANANA, ModItems.BANANA_BREAD,
			ModItems.BROWNIE, ModItems.RICE_SEEDS, ModItems.RICE_CAKE, ModItems.TORTILLA, ModItems.BURRITO, ModItems.CHORUS_COBBLER, TSItems.Tech.COLA_CYAN, TSItems.Tech.COLA_GREEN,
			TSItems.Tech.COLA_ORANGE, TSItems.Tech.MILK_CAN, TSItems.Tech.BEETROOT_SOUP_CAN, TSItems.Tech.MUSHROOM_STEW_CAN, TSItems.Tech.RABBIT_STEW_CAN, ModItems.SANDFISH, ModItems.COOKED_SANDFISH,
			ModItems.DUNE_EEL, ModItems.SMOKED_FISH, TSItems.Magic.DUBIOUS_BACON, ModItems.FRIED_EGG, ModItems.SUSHI_ROLL);

        //progression materials
        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, TSItems.Tech.SCRAP_METAL_SHARD, TSItems.Magic.ROSE_GOLD_INGOT, TSItems.Magic.IMPERIAL_ALLOY_INGOT,
			TSItems.Tech.NANOTECH_CAPSULE, TSItems.Tech.STARSTEEL_INGOT, ModItems.REDSTONE_CRYSTAL, TSItems.Magic.UNHOLY_INGOT, TSItems.Tech.NUCLEAR_INGOT, TSItems.Tech.ZENITHIUM_CLUSTER);

        //misc
        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, TSItems.Tech.EMPTY_CAN, TSItems.Magic.EYE_OF_RUIN, TSItems.Tech.PLASMA_CELL,
                TSItems.Tech.NUCLEAR_ROCKET, TSItems.Tech.MUSIC_DISC_ASSASSINATION_UPLOAD, TSItems.Tech.MUSIC_DISC_LAPSE_IN_JUDGEMENT,
                TSItems.Tech.MUSIC_DISC_ODE_TO_TRANQUILITY, TSItems.Tech.MUSIC_DISC_RECITAL);

        registerItems(itemModelGenerator, Models.HANDHELD, TSItems.Tech.HARD_LIGHT_PROJECTOR, TSItems.Tech.CAUTION_HARD_LIGHT_PROJECTOR, TSItems.Tech.SENTINEL_HARD_LIGHT_PROJECTOR);

        itemModelGenerator.register(ModItems.VENDOR_TOKEN, ModItems.LEGENDARY_TOKEN, Models.SINGLE_LAYER_ITEM);
        itemModelGenerator.register(TSItems.Magic.DEMONIC_CORE, Models.SINGLE_LAYER_ITEM);

        //effect items
        registerItems(itemModelGenerator, Models.SINGLE_LAYER_ITEM, TSItems.Magic.CYBERNETIC_STOMACH, TSItems.Magic.ONE_PENCE);

        itemModelGenerator.register(TSItems.Magic.PALE_HANGING_SIGN, Models.SINGLE_LAYER_ITEM);
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
