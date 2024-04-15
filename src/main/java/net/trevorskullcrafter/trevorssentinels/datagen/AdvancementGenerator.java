package net.trevorskullcrafter.trevorssentinels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.unmapped.C_unoypvme;

import java.util.function.Consumer;

public class AdvancementGenerator extends FabricAdvancementProvider {
    public AdvancementGenerator(FabricDataOutput output) { super(output); }

	@Override public void generateAdvancement(Consumer<C_unoypvme> consumer) {
		/*
		C_unoypvme trevorssentinels = Advancement.Builder.create()
			.display(TSItems.SCRAP_METAL_SHARD, Text.translatable("advancements.trevorssentinels.trevorssentinels.title"),
				Text.translatable("advancements.trevorssentinels.trevorssentinels.desc"), new Identifier("trevorssentinels:textures/block/steel_block.png"),
				AdvancementFrame.TASK, true, true, false)
			.criterion("got_sentinum_shard", InventoryChangedCriterion.Conditions.items(TSItems.SCRAP_METAL_SHARD))
			.rewards(AdvancementRewards.Builder.loot(new Identifier(MOD_ID, "grant_database")))
			.build(consumer, MOD_ID + ":trevorssentinels");

		C_unoypvme spf = Advancement.Builder.create().parent(trevorssentinels)
			.display(Magic.VIRIDIAN_BOAT, Text.translatable("advancements.trevorssentinels.spf.title"),
				Text.translatable("advancements.trevorssentinels.spf.desc"), null,
				AdvancementFrame.TASK, true, true, false)
			.criterion("got_banana_boat", InventoryChangedCriterion.Conditions.items(Magic.VIRIDIAN_BOAT, Magic.VIRIDIAN_CHEST_BOAT))
			.build(consumer, MOD_ID + ":spf");

		C_unoypvme bacon_and_eggs = Advancement.Builder.create().parent(trevorssentinels)
			.display(ModItems.FRIED_EGG, Text.translatable("advancements.trevorssentinels.bacon_and_eggs.title"),
				Text.translatable("advancements.trevorssentinels.bacon_and_eggs.desc"), null,
				AdvancementFrame.GOAL, true, true, false)
			.criterion("eaten_egg", ConsumeItemCriterion.Conditions.item(ModItems.FRIED_EGG))
			.criterion("eaten_bacon", ConsumeItemCriterion.Conditions.item(Magic.DUBIOUS_BACON))
			.build(consumer, MOD_ID + ":bacon_and_eggs");

		C_unoypvme brownie = Advancement.Builder.create().parent(trevorssentinels)
			.display(ModItems.BROWNIE, Text.translatable("advancements.trevorssentinels.brownie.title"),
				Text.translatable("advancements.trevorssentinels.brownie.desc"), null,
				AdvancementFrame.GOAL, true, true, false)
			.criterion("consumed_brownie", ConsumeItemCriterion.Conditions.item(ModItems.BROWNIE))
			.rewards(AdvancementRewards.Builder.experience(420))
			.build(consumer, MOD_ID + ":brownie");

		C_unoypvme chainsaw_man = Advancement.Builder.create().parent(trevorssentinels)
			.display(TSItems.SCRAP_METAL_CHAINSAW, Text.translatable("advancements.trevorssentinels.chainsaw_man.title"),
				Text.translatable("advancements.trevorssentinels.chainsaw_man.desc"), null,
				AdvancementFrame.GOAL, true, true, false)
			.criterion("got_chainsaw", InventoryChangedCriterion.Conditions.items(TSItems.SCRAP_METAL_CHAINSAW))
			.build(consumer, MOD_ID + ":chainsaw_man");

		C_unoypvme ancient_metal = Advancement.Builder.create().parent(trevorssentinels)
			.display(Magic.IMPERIAL_ALLOY_INGOT, Text.translatable("advancements.trevorssentinels.ancient_metal.title"),
				Text.translatable("advancements.trevorssentinels.ancient_metal.desc"), null,
				AdvancementFrame.TASK, true, true, false)
			.criterion("got_something", InventoryChangedCriterion.Conditions.items(Magic.IMPERIAL_SWORD, Magic.IMPERIAL_GLADIUS, Magic.IMPERIAL_PICKAXE,
				Magic.IMPERIAL_BATTLEAXE, Magic.IMPERIAL_SHOVEL, Magic.IMPERIAL_SICKLE, Magic.IMPERIAL_HELMET, Magic.IMPERIAL_CHESTPLATE,
				Magic.IMPERIAL_LEGGINGS, Magic.IMPERIAL_BOOTS))
			.build(consumer, MOD_ID + ":ancient_metal");

		C_unoypvme rose_gold = Advancement.Builder.create().parent(trevorssentinels)
			.display(Magic.ROSE_GOLD_INGOT, Text.translatable("advancements.trevorssentinels.rose_gold.title"),
				Text.translatable("advancements.trevorssentinels.rose_gold.desc"), null,
				AdvancementFrame.TASK, true, true, false)
			.criterion("got_ingot", InventoryChangedCriterion.Conditions.items(Magic.ROSE_GOLD_INGOT))
			.build(consumer, MOD_ID + ":rose_gold");

		C_unoypvme rose_gold_2 = Advancement.Builder.create().parent(rose_gold)
			.display(Magic.ROSE_GOLD_INGOT, Text.translatable("advancements.trevorssentinels.rose_gold_2.title"),
				Text.translatable("advancements.trevorssentinels.rose_gold_2.desc"), null,
				AdvancementFrame.GOAL, true, true, false)
			.criterion("got_something", InventoryChangedCriterion.Conditions.items(Magic.ROSE_GOLD_SWORD, Magic.ROSE_GOLD_DAGGER, Magic.ROSE_GOLD_PICKAXE,
				Magic.ROSE_GOLD_BATTLEAXE, Magic.ROSE_GOLD_SHOVEL, Magic.ROSE_GOLD_SICKLE, Magic.ROSE_GOLD_HELMET, Magic.ROSE_GOLD_CHESTPLATE,
				Magic.ROSE_GOLD_LEGGINGS, Magic.ROSE_GOLD_BOOTS))
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
			.display(TSItems.NUCLEAR_INGOT, Text.translatable("advancements.trevorssentinels.uranium.title"),
				Text.translatable("advancements.trevorssentinels.uranium.desc"), null,
				AdvancementFrame.GOAL, true, true, false)
			.criterion("got_cube", InventoryChangedCriterion.Conditions.items(TSItems.NUCLEAR_INGOT))
			.build(consumer, MOD_ID + ":uranium");

		C_unoypvme superforge = Advancement.Builder.create().parent(uranium)
			.display(ModBlocks.RECONSTRUCTION_TABLE, Text.translatable("advancements.trevorssentinels.superforge.title"),
				Text.translatable("advancements.trevorssentinels.superforge.desc"), null,
				AdvancementFrame.GOAL, true, true, false)
			.criterion("got_superforge", InventoryChangedCriterion.Conditions.items(ModBlocks.RECONSTRUCTION_TABLE))
			.build(consumer, MOD_ID + ":superforge");

		C_unoypvme zenithium = Advancement.Builder.create().parent(superforge)
			.display(TSItems.ZENITHIUM_CLUSTER, Text.translatable("advancements.trevorssentinels.zenithium.title"),
				Text.translatable("advancements.trevorssentinels.zenithium.desc"), null,
				AdvancementFrame.CHALLENGE, true, true, false)
			.criterion("got_cluster", InventoryChangedCriterion.Conditions.items(TSItems.ZENITHIUM_CLUSTER))
			.build(consumer, MOD_ID + ":zenithium");
		 */
	}
}
