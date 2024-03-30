package net.trevorskullcrafter.trevorssentinels.item;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial{
    SCRAP_METAL(0, 37, 1.5f, 1.0f, 8, () -> Ingredient.ofItems(TechItems.SCRAP_METAL_SHARD)),
    ROSE_GOLD(1, 94, 14.0f, 1.0f, 8, () -> Ingredient.ofItems(MagicItems.ROSE_GOLD_INGOT)), //rose gold
    COPPER(2, 532, 6.0f, 2.0f, 4, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    STARSTEEL(2, 532, 6.0f, 2.0f, 4, () -> Ingredient.ofItems(TechItems.STARSTEEL_INGOT)), //industrial
    IMPERIAL_ALLOY(2, 532, 6.0f, 2.0f, 4, () -> Ingredient.ofItems(MagicItems.IMPERIAL_ALLOY_INGOT)),
    GUNMETAL(4, 131, 8.0f, 4.0f, 6, () -> Ingredient.ofItems(ModItems.GUNMETAL_INGOT)), //spacefarer
    DARKSTEEL(5, 1738, 9.0f, 5.0f, 17, () -> Ingredient.ofItems(MagicItems.UNHOLY_INGOT)),
    NUCLEAR(5, 2642, 11.0f, 6.5f, 0, () -> Ingredient.ofItems(TechItems.NUCLEAR_INGOT)),
    ARMADEI(5, 1738, 9.0f, 5.0f, 20, () -> Ingredient.ofItems(Items.GOLD_INGOT)), //arma dei
    NANOTECH(5, 2642, 11.0f, 6.0f, 0, () -> Ingredient.ofItems(TechItems.NANOTECH_CAPSULE)),
    ZENITHIUM(6, 3333, 13.0f, 8.0f, 10, () -> Ingredient.ofItems(TechItems.ZENITHIUM_CLUSTER));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override public int getDurability() { return this.itemDurability; }
    @Override public float getMiningSpeedMultiplier() { return this.miningSpeed; }
    @Override public float getAttackDamage() { return this.attackDamage; }
    @Override public int getMiningLevel() { return this.miningLevel; }
    @Override public int getEnchantability() { return this.enchantability; }
    @Override public Ingredient getRepairIngredient() { return this.repairIngredient.get(); }
}
