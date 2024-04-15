package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;

public interface StorageItem {

	default int getSlots(){ return 2; }

	static NbtList getSlotList(ItemStack stack){
		NbtCompound nbtCompound = stack.getOrCreateNbt();
		if (!nbtCompound.contains("Items")) { nbtCompound.put("Items", new NbtList()); }
		return nbtCompound.getList("Items", NbtElement.COMPOUND_TYPE);
	}

	static ItemStack getStackInSlot(ItemStack stack, int slot){ return ItemStack.fromNbt(getSlotList(stack).getCompound(slot)); }
}
