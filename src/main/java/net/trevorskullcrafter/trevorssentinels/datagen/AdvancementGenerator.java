package net.trevorskullcrafter.trevorssentinels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.ConsumeItemCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.OnKilledCriterion;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.text.Text;
import net.minecraft.unmapped.C_unoypvme;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.item.MagicItems;
import net.trevorskullcrafter.trevorssentinels.item.ModArmory;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.item.TechItems;

import java.util.function.Consumer;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain.MOD_ID;

public class AdvancementGenerator extends FabricAdvancementProvider {
    public AdvancementGenerator(FabricDataOutput output) { super(output); }

	@Override public void generateAdvancement(Consumer<C_unoypvme> consumer) {
		C_unoypvme trevorssentinels = Advancement.Builder.create()
			.display(TechItems.SCRAP_METAL_SHARD, Text.translatable("advancements.trevorssentinels.trevorssentinels.title"),
				Text.translatable("advancements.trevorssentinels.trevorssentinels.desc"), new Identifier("trevorssentinels:textures/block/steel_block.png"),
				AdvancementFrame.TASK, true, true, false)
			.criterion("got_sentinum_shard", InventoryChangedCriterion.Conditions.items(TechItems.SCRAP_METAL_SHARD))
			.rewards(AdvancementRewards.Builder.loot(new Identifier(MOD_ID, "grant_database")))
			.build(consumer, MOD_ID + ":trevorssentinels");

		C_unoypvme spf = Advancement.Builder.create().parent(trevorssentinels)
			.display(ModItems.VIRIDESCENT_BOAT, Text.translatable("advancements.trevorssentinels.spf.title"),
				Text.translatable("advancements.trevorssentinels.spf.desc"), null,
				AdvancementFrame.TASK, true, true, false)
			.criterion("got_banana_boat", InventoryChangedCriterion.Conditions.items(ModItems.VIRIDESCENT_BOAT, ModItems.VIRIDESCENT_CHEST_BOAT))
			.build(consumer, MOD_ID + ":spf");

		C_unoypvme bacon_and_eggs = Advancement.Builder.create().parent(trevorssentinels)
			.display(ModItems.FRIED_EGG, Text.translatable("advancements.trevorssentinels.bacon_and_eggs.title"),
				Text.translatable("advancements.trevorssentinels.bacon_and_eggs.desc"), null,
				AdvancementFrame.GOAL, true, true, false)
			.criterion("eaten_egg", ConsumeItemCriterion.Conditions.item(ModItems.FRIED_EGG))
			.criterion("eaten_bacon", ConsumeItemCriterion.Conditions.item(MagicItems.DUBIOUS_BACON))
			.build(consumer, MOD_ID + ":bacon_and_eggs");

		C_unoypvme brownie = Advancement.Builder.create().parent(trevorssentinels)
			.display(ModItems.BROWNIE, Text.translatable("advancements.trevorssentinels.brownie.title"),
				Text.translatable("advancements.trevorssentinels.brownie.desc"), null,
				AdvancementFrame.GOAL, true, true, false)
			.criterion("consumed_brownie", ConsumeItemCriterion.Conditions.item(ModItems.BROWNIE))
			.rewards(AdvancementRewards.Builder.experience(420))
			.build(consumer, MOD_ID + ":brownie");

		C_unoypvme chainsaw_man = Advancement.Builder.create().parent(trevorssentinels)
			.display(TechItems.SCRAP_METAL_CHAINSAW, Text.translatable("advancements.trevorssentinels.chainsaw_man.title"),
				Text.translatable("advancements.trevorssentinels.chainsaw_man.desc"), null,
				AdvancementFrame.GOAL, true, true, false)
			.criterion("got_chainsaw", InventoryChangedCriterion.Conditions.items(TechItems.SCRAP_METAL_CHAINSAW))
			.build(consumer, MOD_ID + ":chainsaw_man");

		C_unoypvme ancient_metal = Advancement.Builder.create().parent(trevorssentinels)
			.display(MagicItems.IMPERIAL_ALLOY_INGOT, Text.translatable("advancements.trevorssentinels.ancient_metal.title"),
				Text.translatable("advancements.trevorssentinels.ancient_metal.desc"), null,
				AdvancementFrame.TASK, true, true, false)
			.criterion("got_something", InventoryChangedCriterion.Conditions.items(MagicItems.IMPERIAL_SWORD, MagicItems.IMPERIAL_GLADIUS, MagicItems.IMPERIAL_PICKAXE,
				MagicItems.IMPERIAL_BATTLEAXE, MagicItems.IMPERIAL_SHOVEL, MagicItems.IMPERIAL_SICKLE, MagicItems.IMPERIAL_HELMET, MagicItems.IMPERIAL_CHESTPLATE,
				MagicItems.IMPERIAL_LEGGINGS, MagicItems.IMPERIAL_BOOTS))
			.build(consumer, MOD_ID + ":ancient_metal");

		C_unoypvme trimetal = Advancement.Builder.create().parent(trevorssentinels)
			.display(ModItems.COPPER_IRON_INGOT, Text.translatable("advancements.trevorssentinels.trimetal.title"),
				Text.translatable("advancements.trevorssentinels.trimetal.desc"), null,
				AdvancementFrame.TASK, true, true, false)
			.criterion("got_something", InventoryChangedCriterion.Conditions.items(ModArmory.TRIMETAL_SWORD, ModArmory.TRIMETAL_PICKAXE,
				ModArmory.TRIMETAL_AXE, ModArmory.TRIMETAL_SHOVEL, ModArmory.TRIMETAL_HOE, ModArmory.INDUSTRIAL_HELMET, ModArmory.TRIMETAL_CHESTPLATE,
				ModArmory.TRIMETAL_LEGGINGS, ModArmory.TRIMETAL_BOOTS))
			.build(consumer, MOD_ID + ":trimetal");

		C_unoypvme rose_gold = Advancement.Builder.create().parent(trevorssentinels)
			.display(ModItems.ROSE_GOLD_INGOT, Text.translatable("advancements.trevorssentinels.rose_gold.title"),
				Text.translatable("advancements.trevorssentinels.rose_gold.desc"), null,
				AdvancementFrame.TASK, true, true, false)
			.criterion("got_ingot", InventoryChangedCriterion.Conditions.items(ModItems.ROSE_GOLD_INGOT))
			.build(consumer, MOD_ID + ":rose_gold");

		C_unoypvme rose_gold_2 = Advancement.Builder.create().parent(rose_gold)
			.display(ModItems.ROSE_GOLD_INGOT, Text.translatable("advancements.trevorssentinels.rose_gold_2.title"),
				Text.translatable("advancements.trevorssentinels.rose_gold_2.desc"), null,
				AdvancementFrame.GOAL, true, true, false)
			.criterion("got_something", InventoryChangedCriterion.Conditions.items(MagicItems.ROSE_GOLD_SWORD, MagicItems.ROSE_GOLD_DAGGER, MagicItems.ROSE_GOLD_PICKAXE,
				MagicItems.ROSE_GOLD_BATTLEAXE, MagicItems.ROSE_GOLD_SHOVEL, MagicItems.ROSE_GOLD_SICKLE, MagicItems.ROSE_GOLD_HELMET, MagicItems.ROSE_GOLD_CHESTPLATE,
				MagicItems.ROSE_GOLD_LEGGINGS, MagicItems.ROSE_GOLD_BOOTS))
			.build(consumer, MOD_ID + ":rose_gold_2");

		C_unoypvme thanatu = Advancement.Builder.create().parent(rose_gold_2)
			.display(ModArmory.THANATU_SKULL, Text.translatable("advancements.trevorssentinels.thanatu.title"),
				Text.translatable("advancements.trevorssentinels.thanatu.desc"), null,
				AdvancementFrame.CHALLENGE, true, true, false)
			.criterion("got_sword", InventoryChangedCriterion.Conditions.items(BetaItems.THANATU_BLADE))
			.criterion("got_skull", InventoryChangedCriterion.Conditions.items(ModArmory.THANATU_SKULL))
			.criterion("got_armory", InventoryChangedCriterion.Conditions.items(ModArmory.THANATU_SHOULDERPADS))
			.build(consumer, MOD_ID + ":thanatu");

		C_unoypvme cerberus = Advancement.Builder.create()
			.display(Items.WITHER_SKELETON_SKULL, Text.translatable("advancements.trevorssentinels.cerberus.title"),
				Text.translatable("advancements.trevorssentinels.cerberus.desc"), null,
				AdvancementFrame.CHALLENGE, true, true, true)
			.criterion("killed", OnKilledCriterion.Conditions.createPlayerKilledEntity(EntityPredicate.Builder.create().type(EntityType.WITHER)))
			.build(consumer, MOD_ID + ":cerberus");

		C_unoypvme uranium = Advancement.Builder.create().parent(cerberus)
			.display(TechItems.NUCLEAR_INGOT, Text.translatable("advancements.trevorssentinels.uranium.title"),
				Text.translatable("advancements.trevorssentinels.uranium.desc"), null,
				AdvancementFrame.GOAL, true, true, false)
			.criterion("got_cube", InventoryChangedCriterion.Conditions.items(TechItems.NUCLEAR_INGOT))
			.build(consumer, MOD_ID + ":uranium");

		C_unoypvme superforge = Advancement.Builder.create().parent(uranium)
			.display(ModBlocks.RECONSTRUCTION_TABLE, Text.translatable("advancements.trevorssentinels.superforge.title"),
				Text.translatable("advancements.trevorssentinels.superforge.desc"), null,
				AdvancementFrame.GOAL, true, true, false)
			.criterion("got_superforge", InventoryChangedCriterion.Conditions.items(ModBlocks.RECONSTRUCTION_TABLE))
			.build(consumer, MOD_ID + ":superforge");

		C_unoypvme zenithium = Advancement.Builder.create().parent(superforge)
			.display(TechItems.ZENITHIUM_CLUSTER, Text.translatable("advancements.trevorssentinels.zenithium.title"),
				Text.translatable("advancements.trevorssentinels.zenithium.desc"), null,
				AdvancementFrame.CHALLENGE, true, true, false)
			.criterion("got_cluster", InventoryChangedCriterion.Conditions.items(TechItems.ZENITHIUM_CLUSTER))
			.build(consumer, MOD_ID + ":zenithium");
	}
}
