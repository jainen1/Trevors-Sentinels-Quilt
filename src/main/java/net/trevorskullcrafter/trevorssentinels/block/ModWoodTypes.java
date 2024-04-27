package net.trevorskullcrafter.trevorssentinels.block;

import net.minecraft.block.WoodTypes;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;
import net.trevorskullcrafter.trevorssentinels.world.feature.ModConfiguredFeatures;

import java.util.Optional;

public class ModWoodTypes {
	public static WoodTypes PALE = new WoodTypes("pale", 0.1f, Optional.empty(), Optional.empty(), Optional.of(ModConfiguredFeatures.PALE_TREE),
		Optional.of(ModConfiguredFeatures.FANCY_PALE_TREE), Optional.empty(), Optional.empty());
	public static WoodTypes MIDAS = new WoodTypes("midas", 0.1f, Optional.empty(), Optional.empty(), Optional.of(ModConfiguredFeatures.MIDAS_TREE),
		Optional.of(ModConfiguredFeatures.FANCY_MIDAS_TREE), Optional.empty(), Optional.empty());
	public static WoodTypes VIRIDIAN = new WoodTypes("viridian", 0.1f, Optional.empty(), Optional.empty(), Optional.of(ModConfiguredFeatures.VIRIDIAN_TREE),
		Optional.of(ModConfiguredFeatures.FANCY_VIRIDIAN_TREE), Optional.empty(), Optional.empty());
	public static WoodTypes CERULII = new WoodTypes("cerulii", 0.1f, Optional.empty(), Optional.empty(), Optional.of(ModConfiguredFeatures.CERULII_TREE),
		Optional.of(ModConfiguredFeatures.FANCY_CERULII_TREE), Optional.empty(), Optional.empty());

	public static WoodTypes SPRUCE = new WoodTypes("spruce", 0.5F,Optional.of(TreeConfiguredFeatures.MEGA_SPRUCE),
		Optional.of(TreeConfiguredFeatures.MEGA_PINE), Optional.of(TreeConfiguredFeatures.SPRUCE), Optional.empty(), Optional.empty(), Optional.empty());
}
