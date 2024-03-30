package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;

public interface StorageItem {
	static NbtList getSlots(ItemStack stack){
		NbtCompound nbtCompound = stack.getOrCreateNbt();
		if (!nbtCompound.contains("Items")) { nbtCompound.put("Items", new NbtList()); }
		return nbtCompound.getList("Items", NbtElement.COMPOUND_TYPE);
	}

	static ItemStack getSlotStack(ItemStack stack, int slot){ return ItemStack.fromNbt(getSlots(stack).getCompound(slot)); }
	static void setSlotStack(ItemStack stack, int slot, ItemStack otherStack){
		/*NbtCompound nbtStack = new NbtCompound();
		otherStack.writeNbt(nbtStack);
		getSlots(stack).add(slot, nbtStack); */
		getSlots(stack).add(slot, otherStack.writeNbt(new NbtCompound()));
	}
	static boolean addSlotStack(ItemStack stack, ItemStack otherStack, int startSlot){
		if(!(stack.getItem() instanceof PhaserItem)) { return false; }
		for(int slot = startSlot; slot <= ((PhaserItem) stack.getItem()).slots; slot++){
			if(getSlotStack(stack, slot).isEmpty()){
				setSlotStack(stack, slot, otherStack);
				return true;
			}
		}
		return false;
	}
}
