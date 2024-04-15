package net.trevorskullcrafter.trevorssentinels.item.custom.unique;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PappyDSwordItem extends SwordItem {
    public PappyDSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);
        if(world instanceof ServerWorld serverWorld && hand == Hand.MAIN_HAND){
            if(!user.isSneaking()){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 5, 255,false,false,false));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,5,3,false,false,false));
                serverWorld.playSoundFromEntity(null, user, SoundEvents.BLOCK_ANVIL_LAND, SoundCategory.BLOCKS, 2.0F, new java.util.Random().nextFloat());
                user.sendMessage(Text.literal("Parry!").formatted(Formatting.GRAY),true);
                user.getItemCooldownManager().set(this, 100);
            } else {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,200,1,false,true,false));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,200,2,false,false,false));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,200,255,false,false,false));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER,200,5,false,false,false));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,240,2,false,false,false));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS,200,2,false,false,false));
                serverWorld.playSoundFromEntity(null, user, SoundEvents.ENTITY_GHAST_SHOOT, SoundCategory.BLOCKS, 2.0F, 0.0F);
                user.sendMessage(Text.literal("Enraged!").formatted(Formatting.DARK_RED),true);
                user.getItemCooldownManager().set(this, 200);
            } return TypedActionResult.success(itemStack);
        } return super.use(world, user, hand);
    }

    @Override public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int amp = RandomGenerator.createLegacy().range(1,12);
        amp = (amp >= 1 && amp <= 8)? 0 : (amp >= 9 && amp <= 11)? 1: 2;
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS,20,amp,false,false,false));
        attacker.getWorld().playSoundFromEntity(null, attacker, SoundEvents.ITEM_TRIDENT_RIPTIDE_1, SoundCategory.BLOCKS,1.0F + (0.5F*amp),1.0F + (2.0F*amp));
        return true;
    }

    @Override public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("Right click to parry!").formatted(Formatting.GRAY));
        tooltip.add(Text.literal("Sneak + right click to become enraged!").formatted(Formatting.RED));
        tooltip.add(Text.translatable("pillar.trevorssentinels.chaos").formatted(Formatting.ITALIC, Formatting.DARK_RED));
    }
}
