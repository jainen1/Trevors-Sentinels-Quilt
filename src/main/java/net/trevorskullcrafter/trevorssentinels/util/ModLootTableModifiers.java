package net.trevorskullcrafter.trevorssentinels.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.trevorssentinels;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class ModLootTableModifiers {
    private static final Identifier GRASS_BLOCK_ID = new Identifier("minecraft", "blocks/grass");
    private static final Identifier IGLOO_STRUCTURE_CHEST_ID = new Identifier("minecraft", "chests/igloo/chest");
    private static final Identifier WITHER_SKELETON_ID = new Identifier("minecraft", "entities/wither_skeleton");
    private static final Identifier ENDERMAN_ID = new Identifier("minecraft", "entities/enderman");

    public static void modifyLootTables(){
        trevorssentinels.LOGGER.info("Placing shards in grass... (" + MOD_ID + ")");
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {

            if(id.equals(GRASS_BLOCK_ID)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .with(ItemEntry.builder(ModItems.RICE_SEEDS))
                        .with(ItemEntry.builder(ModItems.SCRAP_METAL_SHARD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if(id.equals(WITHER_SKELETON_ID)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.ASH))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 3.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if(id.equals(ENDERMAN_ID)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.TRANSITITE_SHARDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 3.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        /* .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.KILLER,
        new EntityPredicate.Builder().equipment(EntityEquipmentPredicate.Builder.create()
        .mainhand(ItemPredicate.Builder.create().items(Items.GOLDEN_SWORD).build()).build()))) */
    }
}