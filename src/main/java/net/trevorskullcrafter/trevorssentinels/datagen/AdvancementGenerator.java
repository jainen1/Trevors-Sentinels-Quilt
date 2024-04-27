package net.trevorskullcrafter.trevorssentinels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementHolder;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.ConsumeItemCriterionTrigger;
import net.minecraft.advancement.criterion.InventoryChangedCriterionTrigger;
import net.minecraft.advancement.criterion.OnKilledCriterionTrigger;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.item.TSItems;

import java.util.function.Consumer;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain.MOD_ID;

public class AdvancementGenerator extends FabricAdvancementProvider {
    public AdvancementGenerator(FabricDataOutput output) { super(output); }

	@Override public void generateAdvancement(Consumer<AdvancementHolder> consumer) {
		AdvancementHolder trevorssentinels = Advancement.Builder.create()
			.display(TSItems.Tech.SCRAP_METAL_SHARD, Text.translatable("advancements.trevorssentinels.trevorssentinels.title"),
				Text.translatable("advancements.trevorssentinels.trevorssentinels.desc"), new Identifier("trevorssentinels:textures/block/steel_block.png"),
				AdvancementFrame.TASK, true, true, false)
			.criterion("got_sentinum_shard", InventoryChangedCriterionTrigger.Conditions.create(TSItems.Tech.SCRAP_METAL_SHARD))
			.rewards(AdvancementRewards.Builder.loot(new Identifier(MOD_ID, "grant_database")))
			.build(consumer, MOD_ID + ":trevorssentinels");

		AdvancementHolder spf = Advancement.Builder.create().parent(trevorssentinels)
			.display(TSItems.Magic.VIRIDIAN_BOAT, Text.translatable("advancements.trevorssentinels.spf.title"),
				Text.translatable("advancements.trevorssentinels.spf.desc"), null,
				AdvancementFrame.TASK, true, true, false)
			.criterion("got_banana_boat", InventoryChangedCriterionTrigger.Conditions.create(TSItems.Magic.VIRIDIAN_BOAT, TSItems.Magic.VIRIDIAN_CHEST_BOAT))
			.build(consumer, MOD_ID + ":spf");

		AdvancementHolder bacon_and_eggs = Advancement.Builder.create().parent(trevorssentinels)
			.display(ModItems.FRIED_EGG, Text.translatable("advancements.trevorssentinels.bacon_and_eggs.title"),
				Text.translatable("advancements.trevorssentinels.bacon_and_eggs.desc"), null,
				AdvancementFrame.GOAL, true, true, false)
			.criterion("eaten_egg", ConsumeItemCriterionTrigger.Conditions.create(ModItems.FRIED_EGG))
			.criterion("eaten_bacon", ConsumeItemCriterionTrigger.Conditions.create(TSItems.Magic.DUBIOUS_BACON))
			.build(consumer, MOD_ID + ":bacon_and_eggs");

		AdvancementHolder brownie = Advancement.Builder.create().parent(trevorssentinels)
			.display(ModItems.BROWNIE, Text.translatable("advancements.trevorssentinels.brownie.title"),
				Text.translatable("advancements.trevorssentinels.brownie.desc"), null,
				AdvancementFrame.GOAL, true, true, false)
			.criterion("consumed_brownie", ConsumeItemCriterionTrigger.Conditions.create(ModItems.BROWNIE))
			.rewards(AdvancementRewards.Builder.experience(420))
			.build(consumer, MOD_ID + ":brownie");

		AdvancementHolder chainsaw_man = Advancement.Builder.create().parent(trevorssentinels)
			.display(TSItems.Tech.SCRAP_METAL_CHAINSAW, Text.translatable("advancements.trevorssentinels.chainsaw_man.title"),
				Text.translatable("advancements.trevorssentinels.chainsaw_man.desc"), null,
				AdvancementFrame.GOAL, true, true, false)
			.criterion("got_chainsaw", InventoryChangedCriterionTrigger.Conditions.create(TSItems.Tech.SCRAP_METAL_CHAINSAW))
			.build(consumer, MOD_ID + ":chainsaw_man");

		AdvancementHolder ancient_metal = Advancement.Builder.create().parent(trevorssentinels)
			.display(TSItems.Magic.IMPERIAL_ALLOY_INGOT, Text.translatable("advancements.trevorssentinels.ancient_metal.title"),
				Text.translatable("advancements.trevorssentinels.ancient_metal.desc"), null,
				AdvancementFrame.TASK, true, true, false)
			.criterion("got_something", InventoryChangedCriterionTrigger.Conditions.create(TSItems.Magic.IMPERIAL_SWORD, TSItems.Magic.IMPERIAL_GLADIUS, TSItems.Magic.IMPERIAL_PICKAXE,
				TSItems.Magic.IMPERIAL_BATTLEAXE, TSItems.Magic.IMPERIAL_SHOVEL, TSItems.Magic.IMPERIAL_SICKLE, TSItems.Magic.IMPERIAL_HELMET, TSItems.Magic.IMPERIAL_CHESTPLATE,
				TSItems.Magic.IMPERIAL_LEGGINGS, TSItems.Magic.IMPERIAL_BOOTS))
			.build(consumer, MOD_ID + ":ancient_metal");

		AdvancementHolder rose_gold = Advancement.Builder.create().parent(trevorssentinels)
			.display(TSItems.Magic.ROSE_GOLD_INGOT, Text.translatable("advancements.trevorssentinels.rose_gold.title"),
				Text.translatable("advancements.trevorssentinels.rose_gold.desc"), null,
				AdvancementFrame.TASK, true, true, false)
			.criterion("got_ingot", InventoryChangedCriterionTrigger.Conditions.create(TSItems.Magic.ROSE_GOLD_INGOT))
			.build(consumer, MOD_ID + ":rose_gold");

		AdvancementHolder rose_gold_2 = Advancement.Builder.create().parent(rose_gold)
			.display(TSItems.Magic.ROSE_GOLD_INGOT, Text.translatable("advancements.trevorssentinels.rose_gold_2.title"),
				Text.translatable("advancements.trevorssentinels.rose_gold_2.desc"), null,
				AdvancementFrame.GOAL, true, true, false)
			.criterion("got_something", InventoryChangedCriterionTrigger.Conditions.create(TSItems.Magic.ROSE_GOLD_SWORD, TSItems.Magic.ROSE_GOLD_DAGGER, TSItems.Magic.ROSE_GOLD_PICKAXE,
				TSItems.Magic.ROSE_GOLD_BATTLEAXE, TSItems.Magic.ROSE_GOLD_SHOVEL, TSItems.Magic.ROSE_GOLD_SICKLE, TSItems.Magic.ROSE_GOLD_HELMET, TSItems.Magic.ROSE_GOLD_CHESTPLATE,
				TSItems.Magic.ROSE_GOLD_LEGGINGS, TSItems.Magic.ROSE_GOLD_BOOTS))
			.build(consumer, MOD_ID + ":rose_gold_2");

		AdvancementHolder thanatu = Advancement.Builder.create().parent(rose_gold_2)
			.display(TSItems.Magic.THANATU_HELMET, Text.translatable("advancements.trevorssentinels.thanatu.title"),
				Text.translatable("advancements.trevorssentinels.thanatu.desc"), null,
				AdvancementFrame.CHALLENGE, true, true, false)
			.criterion("got_sword", InventoryChangedCriterionTrigger.Conditions.create(TSItems.Beta.THANATU_BLADE))
			.criterion("got_helmet", InventoryChangedCriterionTrigger.Conditions.create(TSItems.Magic.THANATU_HELMET))
			.criterion("got_chestplate", InventoryChangedCriterionTrigger.Conditions.create(TSItems.Magic.THANATU_CHESTPLATE))
			.criterion("got_leggings", InventoryChangedCriterionTrigger.Conditions.create(TSItems.Magic.THANATU_LEGGINGS))
			.criterion("got_boots", InventoryChangedCriterionTrigger.Conditions.create(TSItems.Magic.THANATU_BOOTS))
			.build(consumer, MOD_ID + ":thanatu");

		AdvancementHolder cerberus = Advancement.Builder.create()
			.display(Items.WITHER_SKELETON_SKULL, Text.translatable("advancements.trevorssentinels.cerberus.title"),
				Text.translatable("advancements.trevorssentinels.cerberus.desc"), null,
				AdvancementFrame.CHALLENGE, true, true, true)
			.criterion("killed", OnKilledCriterionTrigger.Conditions.createKilled(EntityPredicate.Builder.create().type(EntityType.WITHER)))
			.build(consumer, MOD_ID + ":cerberus");

		AdvancementHolder uranium = Advancement.Builder.create().parent(cerberus)
			.display(TSItems.Tech.NUCLEAR_INGOT, Text.translatable("advancements.trevorssentinels.uranium.title"),
				Text.translatable("advancements.trevorssentinels.uranium.desc"), null,
				AdvancementFrame.GOAL, true, true, false)
			.criterion("got_cube", InventoryChangedCriterionTrigger.Conditions.create(TSItems.Tech.NUCLEAR_INGOT))
			.build(consumer, MOD_ID + ":uranium");

		AdvancementHolder superforge = Advancement.Builder.create().parent(uranium)
			.display(ModBlocks.RECONSTRUCTION_TABLE, Text.translatable("advancements.trevorssentinels.superforge.title"),
				Text.translatable("advancements.trevorssentinels.superforge.desc"), null,
				AdvancementFrame.GOAL, true, true, false)
			.criterion("got_superforge", InventoryChangedCriterionTrigger.Conditions.create(ModBlocks.RECONSTRUCTION_TABLE))
			.build(consumer, MOD_ID + ":superforge");

		AdvancementHolder zenithium = Advancement.Builder.create().parent(superforge)
			.display(TSItems.Tech.ZENITHIUM_CLUSTER, Text.translatable("advancements.trevorssentinels.zenithium.title"),
				Text.translatable("advancements.trevorssentinels.zenithium.desc"), null,
				AdvancementFrame.CHALLENGE, true, true, false)
			.criterion("got_cluster", InventoryChangedCriterionTrigger.Conditions.create(TSItems.Tech.ZENITHIUM_CLUSTER))
			.build(consumer, MOD_ID + ":zenithium");
	}
}
