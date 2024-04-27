package net.trevorskullcrafter.trevorssentinels.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

	@WrapOperation(at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;decrement(I)V"), method = "eatFood")
	public void eatFood(ItemStack instance, int amount, Operation<Void> original) {
		if (instance.getItem().isDamageable()){ instance.damage(1, ((LivingEntity) (Object) this), p -> p.sendToolBreakStatus(((LivingEntity) (Object) this).getActiveHand())); }
		else { original.call(instance, amount); }
	}
}
