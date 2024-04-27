package net.trevorskullcrafter.trevorssentinels.item.custom.unique;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.item.custom.CannedItem;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain.MILK_CURES_POTION_EFFECTS;

public class CannedMilkItem extends CannedItem {
	public CannedMilkItem(Settings settings) { super(settings); }

	@Override public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		if(world.getGameRules().getBooleanValue(MILK_CURES_POTION_EFFECTS)){ user.clearStatusEffects(); }
		return super.finishUsing(stack, world, user);
	}
}
