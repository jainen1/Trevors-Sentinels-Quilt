package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.trevorskullcrafter.trevorssentinels.item.TSItems;
import net.trevorskullcrafter.trevorssentinels.util.TextUtil;

import java.util.Optional;

public interface FuelableItem {
	default void addFuel(ItemStack stack, ItemStack otherStack, Entity entity) {
		int space = getMaxFuel(stack) - getFuel(stack);
		if (space > 0 && otherStack.isOf(getFuelItem())) {
			int x = Math.min(space, otherStack.getCount());
			if (x > 0) {
				setFuel(stack, getFuel(stack)+x);
				playFuelSound(entity);
				otherStack.decrement(x);
			}
		}
	}

	default Optional<ItemStack> removeFuel(ItemStack stack, Entity entity) {
		if (getFuel(stack) == 0) { return Optional.empty(); }
		else {
			int x = Math.min(getFuel(stack), 64);
			if(x > 0) {
				setFuel(stack, getFuel(stack)-x);
				playFuelSound(entity);
			}
			return Optional.of(new ItemStack(getFuelItem(), x));
		}
	}

	default void onClicked(ItemStack thisStack, ItemStack otherStack, PlayerEntity player, StackReference cursorStackReference){
		if (otherStack.isEmpty()) { removeFuel(thisStack, player).ifPresent(cursorStackReference::set); }
		else { addFuel(thisStack, otherStack, player); }
	}

	default void onClickedOnOther(ItemStack thisStack, Slot otherSlot, PlayerEntity player){
		ItemStack otherStack = otherSlot.getStack();
		if (otherStack.isEmpty()) { removeFuel(thisStack, player).ifPresent((removedStack) -> addFuel(thisStack, otherSlot.insertStack(removedStack), player)); }
		else { addFuel(thisStack, otherStack, player); }
	}

	default Text fuelText(ItemStack stack){
		int ammo = getFuel(stack); int maxAmmo = getMaxFuel(stack);
		return Text.empty().append(Text.literal(String.valueOf(ammo)).formatted(TextUtil.quotientToolTipFormatting(ammo, maxAmmo)))
			.append(Text.literal(" / " + maxAmmo +" ⚡ ").formatted(Formatting.GRAY));
	}

	default Item getFuelItem(){ return TSItems.Tech.PLASMA_CELL; }
	default int getMaxFuel(ItemStack stack) { return 64; }
	default int getFuel(ItemStack stack) { return stack.getOrCreateNbt().getInt("Fuel"); }
	default void setFuel(ItemStack stack, int fuel) { stack.getOrCreateNbt().putInt("Fuel", Math.min(fuel, getMaxFuel(stack))); }
	default void playFuelSound(Entity entity) { entity.playSound(SoundEvents.BLOCK_CHAIN_PLACE, 1f, 2f + entity.getWorld().getRandom().nextFloat() * 0.4F); }
}
