package net.trevorskullcrafter.trevorssentinels.block.sapling;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.trevorskullcrafter.trevorssentinels.world.feature.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class PaleSaplingGenerator extends SaplingGenerator {
    public PaleSaplingGenerator() {
    }

	@Nullable @Override protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(RandomGenerator random, boolean bees) {
		if (random.nextInt(10) == 0) { return ModConfiguredFeatures.FANCY_YGGDRASIL_TREE; }
		else { return ModConfiguredFeatures.YGGDRASIL_TREE; }
	}
}
