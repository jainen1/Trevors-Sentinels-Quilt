package net.trevorskullcrafter.trevorssentinels.world.feature;

import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.int_provider.ConstantIntProvider;
import net.minecraft.world.gen.BootstrapContext;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.foliage.PineFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain;

import java.util.OptionalInt;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> CERULII_TREE = registerKey("cerulii");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FANCY_CERULII_TREE = registerKey("fancy_cerulii");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MIDAS_TREE = registerKey("midas");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FANCY_MIDAS_TREE = registerKey("fancy_midas");
    public static final RegistryKey<ConfiguredFeature<?, ?>> VIRIDESCENT_TREE = registerKey("viridescent");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FANCY_VIRIDESCENT_TREE = registerKey("fancy_viridescent");
    public static final RegistryKey<ConfiguredFeature<?, ?>> YGGDRASIL_TREE = registerKey("yggdrasil");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FANCY_YGGDRASIL_TREE = registerKey("fancy_yggdrasil");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context){
        register(context, CERULII_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.CERULII_LOG),
                new LargeOakTrunkPlacer(2, 4, 0),
                BlockStateProvider.of(ModBlocks.CERULII_LEAVES),
                new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(2), 2),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());
        register(context, FANCY_CERULII_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.CERULII_LOG),
                new LargeOakTrunkPlacer(4, 6, 0),
                BlockStateProvider.of(ModBlocks.CERULII_LEAVES),
                new LargeOakFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(6))).ignoreVines().build());
        register(context, MIDAS_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.MIDAS_LOG),
                new StraightTrunkPlacer(4, 3, 3),
                BlockStateProvider.of(ModBlocks.MIDAS_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),
                new TwoLayersFeatureSize(1, 0, 1)).build());
        register(context, FANCY_MIDAS_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.MIDAS_LOG),
                new BendingTrunkPlacer(4, 3, 3, 5, ConstantIntProvider.create(3)),
                BlockStateProvider.of(ModBlocks.MIDAS_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());
        register(context, VIRIDESCENT_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.VIRIDIAN_LOG),
                new StraightTrunkPlacer(3, 1, 1),
                BlockStateProvider.of(ModBlocks.VIRIDIAN_LEAVES),
                new PineFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), ConstantIntProvider.create(2)),
                new TwoLayersFeatureSize(1, 0, 1)).dirtProvider(BlockStateProvider.of(Blocks.COARSE_DIRT)).forceDirt().build());
        register(context, FANCY_VIRIDESCENT_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.VIRIDIAN_LOG),
                new StraightTrunkPlacer(4, 2, 1),
                BlockStateProvider.of(ModBlocks.VIRIDIAN_LEAVES),
                new PineFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(2), ConstantIntProvider.create(4)),
                new TwoLayersFeatureSize(1, 0, 1)).dirtProvider(BlockStateProvider.of(Blocks.COARSE_DIRT)).forceDirt().build());
        register(context, YGGDRASIL_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PALE_LOG),
                new StraightTrunkPlacer(4, 3, 3),
                BlockStateProvider.of(ModBlocks.PALE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),
                new TwoLayersFeatureSize(1, 0, 1)).build());
        register(context, FANCY_YGGDRASIL_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PALE_LOG),
                new BendingTrunkPlacer(4, 3, 3, 5, ConstantIntProvider.create(3)),
                BlockStateProvider.of(ModBlocks.PALE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(trevorssentinelsMain.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>>
    void register(BootstrapContext<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
