package net.trevorskullcrafter.trevorssentinels.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.effect.ModEffects;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain.*;

public class ModItems {
    public static final Item GUNMETAL_INGOT = registerItem("gunmetal_ingot", new Item(new QuiltItemSettings()));
    public static final Item COPPER_IRON_INGOT = registerItem("copper_iron_ingot", new Item(new QuiltItemSettings()));
    public static final Item ASH = registerItem("ash", new Item(new QuiltItemSettings().food(new FoodComponent.Builder().hunger(-1).saturationModifier(0.2f).build())));
    public static final Item TRANQUIL_DUST = registerItem("tranquil_dust", new Item(new QuiltItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 0), 0.6f).build())));
    public static final Item SALT = registerItem("salt", new Item(new QuiltItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(-0.5f).build())));
    public static final Item REDSTONE_CRYSTAL = registerItem("redstone_crystal", new Item(new QuiltItemSettings()));
    public static final Item BLOOD_DIAMOND = registerItem("blood_diamond", new Item(new QuiltItemSettings().fireproof()));


    public static final Item FRIED_EGG = registerItem("fried_egg", new Item(new QuiltItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build())));
    public static final Item BANANA = registerItem("banana", new Item(new QuiltItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(ModEffects.IRRADIATED, 40, 1), 0.4f).build())));
	public static final Item BANANA_BREAD = registerItem("banana_bread", new Item(new QuiltItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(ModEffects.WELL_FED, 200, 1), 0.4f).build())));
    public static final Item RICE_SEEDS = registerItem("rice_seeds", new AliasedBlockItem(ModBlocks.RICE_PLANT, new QuiltItemSettings()
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.2f).build())));
    public static final Item RICE_CAKE = registerItem("rice_cake", new Item(new QuiltItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.6f).build())));
    public static final Item SUSHI_ROLL = registerItem("sushi_roll", new Item(new QuiltItemSettings().food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8f).build())));
    public static final Item GOLDEN_RICE_SEEDS = registerItem("golden_rice_seeds", new AliasedBlockItem(ModBlocks.GOLDEN_RICE_PLANT, new QuiltItemSettings()
            .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.4f).build())));
    public static final Item GOLDEN_RICE_CAKE = registerItem("golden_rice_cake", new Item(new QuiltItemSettings()
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(1f).build())));
    public static final Item TORTILLA = registerItem("tortilla", new Item(new QuiltItemSettings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build())));
    public static final Item BURRITO = registerItem("burrito", new Item(new QuiltItemSettings().food(new FoodComponent.Builder().hunger(12).saturationModifier(2.4f).build())));
    public static final Item PEARFRUIT = registerItem("pearfruit", new Item(new QuiltItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 2400, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 2400, 1), 1.0f).alwaysEdible().build())));
    public static final Item MIDAS_FRUIT = registerItem("midas_fruit", new Item(new QuiltItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 120, 1), 1.0f).alwaysEdible().build())));
    public static final Item APPLE_JUICE = registerItem("apple_juice", new Item(new QuiltItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));
    public static final Item GOLDEN_APPLE_JUICE = registerItem("golden_apple_juice", new Item(new QuiltItemSettings()
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));
    public static final Item PEARFRUIT_JUICE = registerItem("pearfruit_juice", new Item(new QuiltItemSettings()
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build())));
    public static final Item SWEET_BERRY_JUICE = registerItem("sweet_berry_juice", new Item(new QuiltItemSettings()
            .food(new FoodComponent.Builder().hunger(3).saturationModifier(1.0f).build())));
    public static final Item BROWNIE = registerItem("brownie", new Item(new QuiltItemSettings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.5f).build())));
    public static final Item CHORUS_COBBLER = registerItem("chorus_cobbler", new Item(new QuiltItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 120, 0), 1.0f).build())));

    public static final Item CURED_BEEF = registerItem("cured_beef", new Item(new QuiltItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.6f).build())));
    public static final Item CURED_CHICKEN = registerItem("cured_chicken", new Item(new QuiltItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.8f).build())));

    public static final Item SANDFISH = registerItem("sandfish", new Item(new QuiltItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.6f).build())));
    public static final Item COOKED_SANDFISH = registerItem("cooked_sandfish", new Item(new QuiltItemSettings()
            .food(new FoodComponent.Builder().hunger(5).saturationModifier(0.6f).build())));
    public static final Item DUNE_EEL = registerItem("dune_eel", new Item(new QuiltItemSettings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).build())));
    public static final Item SMOKED_FISH = registerItem("smoked_fish", new Item(new QuiltItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0f).build())));
    public static final Item ANTIMILK = registerItem("antimilk", new ChaddBucketItem(new QuiltItemSettings().rarity(Rarity.EPIC)));


    public static final Item SENTINEL_SPAWN_EGG = registerItem("sentinel_spawn_egg",
            new SpawnEggItem(ModEntities.SENTINEL, 0xffffff, 0xD31400, new QuiltItemSettings()));
    public static final Item ROOMBA_SPAWN_EGG = registerItem("roomba_spawn_egg",
            new SpawnEggItem(ModEntities.GALINITE_ROOMBA, 0xffffff, 0xffffff, new QuiltItemSettings()));
    public static final Item FLORBUS_SPAWN_EGG = registerItem("florbus_spawn_egg",
            new SpawnEggItem(ModEntities.FLORBUS, 0xd9c996, 0xb6a269, new QuiltItemSettings()));

    public static final Item FEATHERCORN = registerItem("feathercorn", new TallBlockItem(ModBlocks.FEATHERCORN, new QuiltItemSettings()));

    public static final Item VENDOR_TOKEN = registerItem("vendor_token", new Item(new QuiltItemSettings()));
    public static final Item LEGENDARY_TOKEN = registerItem("legendary_token", new Item(new QuiltItemSettings().rarity(Rarity.EPIC)));

    public static final Item COMMON_SKIN_PACK = registerItem("common_skin_pack", new PaintPack(1, new QuiltItemSettings()));

    private static Item registerItem(String name, Item item){return Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), item);}
}
