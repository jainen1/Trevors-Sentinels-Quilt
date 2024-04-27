package net.trevorskullcrafter.trevorssentinels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonFactory;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonFactory;
import net.minecraft.data.server.recipe.TransformSmithingRecipeJsonFactory;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeCategory;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.item.TSItems;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) { super(output); }

	@Override public void generateRecipes(RecipeExporter exporter) {
		offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, TSItems.Tech.NUCLEAR_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.NUCLEAR_BLOCK);
		ShapedRecipeJsonFactory.create(RecipeCategory.TOOLS, TSItems.Tech.PLASMA_CELL)
			.pattern("#  ").pattern(" $ ").pattern("  #")
			.ingredient('#', TSItems.Tech.STARSTEEL_INGOT).ingredient('$', TSItems.Tech.NUCLEAR_INGOT)
			.criterion(FabricRecipeProvider.hasItem(TSItems.Tech.NUCLEAR_INGOT), FabricRecipeProvider.conditionsFromItem(TSItems.Tech.NUCLEAR_INGOT))
			.criterion(FabricRecipeProvider.hasItem(TSItems.Tech.STARSTEEL_INGOT), FabricRecipeProvider.conditionsFromItem(TSItems.Tech.STARSTEEL_INGOT))
			.offerTo(exporter, new Identifier("energy_cell_from_torbernite"));
		ShapedRecipeJsonFactory.create(RecipeCategory.MISC, ModBlocks.WAX_INFUSED_COPPER_BLOCK, 4)
			.pattern(" # ").pattern("#$#").pattern(" # ")
			.ingredient('#', Items.HONEYCOMB).ingredient('$', Blocks.COPPER_BLOCK)
			.criterion(FabricRecipeProvider.hasItem(Items.HONEYCOMB), FabricRecipeProvider.conditionsFromItem(Items.HONEYCOMB))
			.criterion(FabricRecipeProvider.hasItem(Blocks.COPPER_BLOCK), FabricRecipeProvider.conditionsFromItem(Blocks.COPPER_BLOCK))
			.offerTo(exporter, new Identifier("wax_infused_copper_block"));

		ShapelessRecipeJsonFactory.create(RecipeCategory.MISC, TSItems.Magic.UNHOLY_INGOT)
			.ingredient(ModItems.TRANQUIL_DUST, 4).ingredient(ModItems.ASH, 4).ingredient(Items.IRON_INGOT)
			.criterion(FabricRecipeProvider.hasItem(ModItems.TRANQUIL_DUST), FabricRecipeProvider.conditionsFromItem(ModItems.TRANQUIL_DUST))
			.criterion(FabricRecipeProvider.hasItem(ModItems.ASH), FabricRecipeProvider.conditionsFromItem(ModItems.ASH))
			.criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT), FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
			.offerTo(exporter, new Identifier("darksteel_ingot"));
		TransformSmithingRecipeJsonFactory.create(Ingredient.empty(), Ingredient.ofItems(Items.COPPER_INGOT), Ingredient.ofItems(Items.GOLD_INGOT), RecipeCategory.MISC, TSItems.Magic.ROSE_GOLD_INGOT)
			.criterion(FabricRecipeProvider.hasItem(Items.COPPER_INGOT), FabricRecipeProvider.conditionsFromItem(Items.COPPER_INGOT))
			.criterion(FabricRecipeProvider.hasItem(Items.GOLD_INGOT), FabricRecipeProvider.conditionsFromItem(Items.GOLD_INGOT))
			.offerTo(exporter, new Identifier("copper_gold"));
		TransformSmithingRecipeJsonFactory.create(Ingredient.empty(), Ingredient.ofItems(Items.GOLD_INGOT), Ingredient.ofItems(Items.COPPER_INGOT), RecipeCategory.MISC, TSItems.Magic.ROSE_GOLD_INGOT)
			.criterion(FabricRecipeProvider.hasItem(Items.GOLD_INGOT), FabricRecipeProvider.conditionsFromItem(Items.GOLD_INGOT))
			.criterion(FabricRecipeProvider.hasItem(Items.COPPER_INGOT), FabricRecipeProvider.conditionsFromItem(Items.COPPER_INGOT))
			.offerTo(exporter, new Identifier("gold_copper"));

		ShapedRecipeJsonFactory.create(RecipeCategory.TOOLS, TSItems.Magic.DEMONIC_CORE)
			.pattern("#").pattern("$").pattern("#")
			.ingredient('#', Items.AMETHYST_SHARD).ingredient('$', Items.ENDER_EYE)
			.criterion(FabricRecipeProvider.hasItem(Items.AMETHYST_SHARD), FabricRecipeProvider.conditionsFromItem(Items.AMETHYST_SHARD))
			.criterion(FabricRecipeProvider.hasItem(Items.ENDER_EYE), FabricRecipeProvider.conditionsFromItem(Items.ENDER_EYE))
			.offerTo(exporter, new Identifier("amethyst_core"));
	}
}
