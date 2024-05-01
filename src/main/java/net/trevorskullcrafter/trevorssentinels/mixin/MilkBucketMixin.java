package net.trevorskullcrafter.trevorssentinels.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain.MILK_CURES_POTION_EFFECTS;

@Mixin(MilkBucketItem.class)
public abstract class MilkBucketMixin extends ItemMixin {
    @WrapWithCondition(method = "finishUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;clearStatusEffects()Z"))
    private boolean milkCuresPotionEffects(LivingEntity instance) { return instance.getWorld().getGameRules().getBooleanValue(MILK_CURES_POTION_EFFECTS); }

	@Inject(method = "finishUsing", at = @At(value = "RETURN", target = "Lnet/minecraft/item/ItemStack;decrement(I)V"))
	private void finishUsing(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir){
		if(stack.isFood()) { user.eatFood(world, stack); }
	}

    @Override public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context, CallbackInfo ci) {
		boolean cures = world != null && world.getGameRules().getBooleanValue(MILK_CURES_POTION_EFFECTS);
		if(cures){ tooltip.add(Text.translatable("tooltip.trevorssentinels:milkCuresPotionEffects").formatted(Formatting.RED)); }
		trevorssentinelsMain.LOGGER.info("milk cures potion effects: {}", cures);
		super.appendTooltip(stack, world, tooltip, context, ci);
    }
}
