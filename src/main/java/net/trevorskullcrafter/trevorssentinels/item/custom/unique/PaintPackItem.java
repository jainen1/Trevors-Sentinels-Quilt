package net.trevorskullcrafter.trevorssentinels.item.custom.unique;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PaintPackItem extends Item {
    public PaintPackItem(Settings settings) {
        super(settings);
    }

    @Override public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    public int getItemSkinData(Item item){ return 1; }
}
