package net.trevorskullcrafter.trevorssentinels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.class_8790;
import net.minecraft.data.server.recipe.ShapedRecipeJsonFactory;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonFactory;
import net.minecraft.data.server.recipe.TransformSmithingRecipeJsonFactory;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeCategory;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.item.MagicItems;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.item.TechItems;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) { super(output); }

	@Override public void generateRecipes(class_8790 exporter) {
		//offerReversibleCompactingRecipesWithCompactedItemGroup(exporter, RecipeCategory.MISC, ModBlocks.NUCLEAR_BLOCK, RecipeCategory.BUILDING_BLOCKS, TechItems.NUCLEAR_INGOT, );
		ShapedRecipeJsonFactory.create(RecipeCategory.TOOLS, TechItems.PLASMA_CELL)
			.pattern("#  ").pattern(" $ ").pattern("  #")
			.ingredient('#', TechItems.STARSTEEL_INGOT).ingredient('$', TechItems.NUCLEAR_INGOT)
			.criterion(FabricRecipeProvider.hasItem(TechItems.NUCLEAR_INGOT), FabricRecipeProvider.method_10426(TechItems.NUCLEAR_INGOT))
			.criterion(FabricRecipeProvider.hasItem(TechItems.STARSTEEL_INGOT), FabricRecipeProvider.method_10426(TechItems.STARSTEEL_INGOT))
			.method_17972(exporter, new Identifier("energy_cell_from_torbernite"));
		ShapedRecipeJsonFactory.create(RecipeCategory.MISC, ModBlocks.WAX_INFUSED_COPPER_BLOCK, 4)
			.pattern(" # ").pattern("#$#").pattern(" # ")
			.ingredient('#', Items.HONEYCOMB).ingredient('$', Blocks.COPPER_BLOCK)
			.criterion(FabricRecipeProvider.hasItem(Items.HONEYCOMB), FabricRecipeProvider.method_10426(Items.HONEYCOMB))
			.criterion(FabricRecipeProvider.hasItem(Blocks.COPPER_BLOCK), FabricRecipeProvider.method_10426(Blocks.COPPER_BLOCK))
			.method_17972(exporter, new Identifier("wax_infused_copper_block"));

		ShapelessRecipeJsonFactory.create(RecipeCategory.MISC, MagicItems.UNHOLY_INGOT)
			.ingredient(ModItems.TRANQUIL_DUST, 4).ingredient(ModItems.ASH, 4).ingredient(Items.IRON_INGOT)
			.criterion(FabricRecipeProvider.hasItem(ModItems.TRANQUIL_DUST), FabricRecipeProvider.method_10426(ModItems.TRANQUIL_DUST))
			.criterion(FabricRecipeProvider.hasItem(ModItems.ASH), FabricRecipeProvider.method_10426(ModItems.ASH))
			.criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT), FabricRecipeProvider.method_10426(Items.IRON_INGOT))
			.method_17972(exporter, new Identifier("darksteel_ingot"));
		TransformSmithingRecipeJsonFactory.create(Ingredient.empty(), Ingredient.ofItems(Items.COPPER_INGOT), Ingredient.ofItems(Items.GOLD_INGOT), RecipeCategory.MISC, MagicItems.ROSE_GOLD_INGOT)
			.criterion(FabricRecipeProvider.hasItem(Items.COPPER_INGOT), FabricRecipeProvider.method_10426(Items.COPPER_INGOT))
			.criterion(FabricRecipeProvider.hasItem(Items.GOLD_INGOT), FabricRecipeProvider.method_10426(Items.GOLD_INGOT))
			.method_48537(exporter, new Identifier("copper_gold"));
		TransformSmithingRecipeJsonFactory.create(Ingredient.empty(), Ingredient.ofItems(Items.GOLD_INGOT), Ingredient.ofItems(Items.COPPER_INGOT), RecipeCategory.MISC, MagicItems.ROSE_GOLD_INGOT)
			.criterion(FabricRecipeProvider.hasItem(Items.GOLD_INGOT), FabricRecipeProvider.method_10426(Items.GOLD_INGOT))
			.criterion(FabricRecipeProvider.hasItem(Items.COPPER_INGOT), FabricRecipeProvider.method_10426(Items.COPPER_INGOT))
			.method_48537(exporter, new Identifier("gold_copper"));

		ShapedRecipeJsonFactory.create(RecipeCategory.TOOLS, MagicItems.DEMONIC_CORE)
			.pattern("#").pattern("$").pattern("#")
			.ingredient('#', Items.AMETHYST_SHARD).ingredient('$', Items.ENDER_EYE)
			.method_17972(exporter, new Identifier("amethyst_core"));
	}
}
