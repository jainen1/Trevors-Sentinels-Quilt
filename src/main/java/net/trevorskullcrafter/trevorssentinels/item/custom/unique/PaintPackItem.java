package net.trevorskullcrafter.trevorssentinels.item.custom.unique;

import net.minecraft.item.DyeableItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.trevorskullcrafter.trevorssentinels.util.TextUtil;

public class PaintPackItem extends Item implements DyeableItem {
    public PaintPackItem(Settings settings) { super(settings); }

	@Override public int getColor(ItemStack stack) {
		NbtCompound nbtCompound = stack.getSubNbt("display");
		return nbtCompound != null && nbtCompound.contains("color", NbtElement.NUMBER_TYPE) ? nbtCompound.getInt("color") : TextUtil.WHITE.getRGB();
	}
}
