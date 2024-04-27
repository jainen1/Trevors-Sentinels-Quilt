package net.trevorskullcrafter.trevorssentinels.mixin;

import com.mojang.datafixers.util.Pair;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.trevorskullcrafter.trevorssentinels.effect.ModEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Items.class)
public class FoodComponentMixin {
    @ModifyArg(method= "<clinit>", slice= @Slice(from= @At(value= "CONSTANT", args = "stringValue=glow_berries"), to = @At(value = "CONSTANT", args = "stringValue=honeycomb")),
            at= @At(value= "INVOKE", target= "Lnet/minecraft/item/Item$Settings;food(Lnet/minecraft/item/FoodComponent;)Lnet/minecraft/item/Item$Settings;"))
    private static FoodComponent glow_berries(FoodComponent foodComponent){ return copyWithEffect(foodComponent, new StatusEffectInstance(StatusEffects.GLOWING, 100), 0.85f); }

    @ModifyArg(method= "<clinit>", slice= @Slice(from= @At(value= "CONSTANT", args = "stringValue=milk_bucket"), to = @At(value = "CONSTANT", args = "stringValue=pufferfish_bucket")),
            at= @At(value= "INVOKE", target= "Lnet/minecraft/item/MilkBucketItem;<init>(Lnet/minecraft/item/Item$Settings;)V"))
    private static Item.Settings milk_bucket(Item.Settings settings){
        return settings.food(new FoodComponent.Builder().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 3600), 0.8f).build());
    }

    @ModifyArg(method= "<clinit>", slice= @Slice(from= @At(value= "CONSTANT", args = "stringValue=redstone"), to = @At(value = "CONSTANT", args = "stringValue=saddle")),
            at= @At(value= "INVOKE", target= "Lnet/minecraft/item/AliasedBlockItem;<init>(Lnet/minecraft/block/Block;Lnet/minecraft/item/Item$Settings;)V"))
    private static Item.Settings redstone(Item.Settings settings){
        return settings.food(new FoodComponent.Builder().statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 200), 0.85f).build());
    }

    @Unique private static FoodComponent copyWithEffect(FoodComponent foodComponent, StatusEffectInstance statusEffectInstance, float f){
        FoodComponent.Builder foodComponentBuilder = new FoodComponent.Builder().hunger(foodComponent.getHunger()).saturationModifier(foodComponent.getSaturationModifier());
        if(foodComponent.isMeat()){ foodComponentBuilder.meat(); }
        if(foodComponent.isSnack()){ foodComponentBuilder.snack(); }
        if(foodComponent.isAlwaysEdible()){ foodComponentBuilder.alwaysEdible(); }

        foodComponent.getStatusEffects().add(Pair.of(statusEffectInstance, f));
        for(Pair<StatusEffectInstance, Float> pair : foodComponent.getStatusEffects()){ foodComponentBuilder.statusEffect(pair.getFirst(), pair.getSecond()); }
        return foodComponentBuilder.build();
    }
}
