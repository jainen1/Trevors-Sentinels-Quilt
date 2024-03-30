package net.trevorskullcrafter.trevorssentinels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.HolderLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain.MOD_ID;

public class BlockTagGenerator extends FabricTagProvider.BlockTagProvider {
    public BlockTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) { super(output, completableFuture); }

    public static final TagKey<Block> LASER_REFLECTIVE = TagKey.of(RegistryKeys.BLOCK, new Identifier(MOD_ID, "laser_reflective"));
    public static final TagKey<Block> LASER_PROJECTILE_PASS = TagKey.of(RegistryKeys.BLOCK, new Identifier(MOD_ID, "laser_projectile_pass"));
    public static final TagKey<Block> SOLID_PROJECTILE_PASS = TagKey.of(RegistryKeys.BLOCK, new Identifier(MOD_ID, "solid_projectile_pass"));

    public static final TagKey<Block> CERULII_LOGS = TagKey.of(RegistryKeys.BLOCK, new Identifier(MOD_ID, "cerulii_logs"));
    public static final TagKey<Block> CHARRED_LOGS = TagKey.of(RegistryKeys.BLOCK, new Identifier(MOD_ID, "charred_logs"));
    public static final TagKey<Block> MIDAS_LOGS = TagKey.of(RegistryKeys.BLOCK, new Identifier(MOD_ID, "midas_logs"));
    public static final TagKey<Block> VIRIDESCENT_LOGS = TagKey.of(RegistryKeys.BLOCK, new Identifier(MOD_ID, "viridescent_logs"));
    public static final TagKey<Block> YGGDRASIL_LOGS = TagKey.of(RegistryKeys.BLOCK, new Identifier(MOD_ID, "yggdrasil_logs"));

    public static final TagKey<Block> REQUIRES_LEVEL_2 = TagKey.of(RegistryKeys.BLOCK, new Identifier(MOD_ID, "requires_level_2"));
    public static final TagKey<Block> REQUIRES_LEVEL_3 = TagKey.of(RegistryKeys.BLOCK, new Identifier(MOD_ID, "requires_level_3"));

	@Override protected void configure(HolderLookup.Provider arg) {
		getOrCreateTagBuilder(LASER_REFLECTIVE)
			.add(Blocks.IRON_BLOCK, Blocks.ICE, Blocks.CHAIN, Blocks.BELL)
			.add(ModBlocks.STEEL_BLOCK, ModBlocks.CAUTION_STEEL_BLOCK, ModBlocks.STAINLESS_STEEL_BLOCK, ModBlocks.STARSTEEL_LAMP, ModBlocks.STARSTEEL_FAN,
				ModBlocks.BATTERY, ModBlocks.FUSEBOX, ModBlocks.STEEL_LADDER, ModBlocks.BIG_RED_BUTTON, ModBlocks.BIG_RED_PLATE, ModBlocks.RECONSTRUCTION_TABLE)
			.add(ModBlocks.DARKSTEEL_BLOCK, ModBlocks.IRON_GOLD_BLOCK, ModBlocks.ROSE_GOLD_BLOCK, ModBlocks.COPPER_IRON_BLOCK);
		getOrCreateTagBuilder(SOLID_PROJECTILE_PASS)
			.addOptionalTag(BlockTags.LEAVES)
			.add(Blocks.IRON_BARS);
		getOrCreateTagBuilder(LASER_PROJECTILE_PASS)
			.addOptionalTag(new Identifier("c", "glass_blocks"))
			.addTag(SOLID_PROJECTILE_PASS);

		getOrCreateTagBuilder(CERULII_LOGS).add(ModBlocks.CERULII_LOG, ModBlocks.CERULII_WOOD, ModBlocks.STRIPPED_CERULII_LOG, ModBlocks.STRIPPED_CERULII_WOOD);
		getOrCreateTagBuilder(CHARRED_LOGS).add(ModBlocks.CHARRED_LOG, ModBlocks.CHARRED_WOOD, ModBlocks.STRIPPED_CHARRED_LOG, ModBlocks.STRIPPED_CHARRED_WOOD);
		getOrCreateTagBuilder(MIDAS_LOGS).add(ModBlocks.MIDAS_LOG, ModBlocks.MIDAS_WOOD, ModBlocks.STRIPPED_MIDAS_LOG, ModBlocks.STRIPPED_MIDAS_WOOD);
		getOrCreateTagBuilder(VIRIDESCENT_LOGS).add(ModBlocks.VIRIDIAN_LOG, ModBlocks.VIRIDIAN_WOOD, ModBlocks.STRIPPED_VIRIDIAN_LOG, ModBlocks.STRIPPED_VIRIDIAN_WOOD);
		getOrCreateTagBuilder(YGGDRASIL_LOGS).add(ModBlocks.PALE_LOG, ModBlocks.PALE_WOOD, ModBlocks.STRIPPED_PALE_LOG, ModBlocks.STRIPPED_PALE_WOOD);

		getOrCreateTagBuilder(REQUIRES_LEVEL_2).add(ModBlocks.NUCLEAR_ORE, ModBlocks.NUCLEAR_BLOCK);
		getOrCreateTagBuilder(REQUIRES_LEVEL_3).add(ModBlocks.CAUTION_HARD_LIGHT_BARRIER);
	}
}
