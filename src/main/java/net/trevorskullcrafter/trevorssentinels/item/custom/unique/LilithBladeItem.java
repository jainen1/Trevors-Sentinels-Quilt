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
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.util.StyleUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LilithBladeItem extends SwordItem implements StyleUtil.StyleSwitcher {
    public LilithBladeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public Formatting getStyleSwitchFormatting(ItemStack stack) {
        return StyleUtil.getStyle(stack) == 2? Formatting.RED : Formatting.YELLOW;
    }

    @Override public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (world instanceof ServerWorld serverWorld && hand == Hand.MAIN_HAND) {
            if(StyleUtil.getStyle(itemStack) == 2){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,200,1,false,true,false));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED,200,2,false,false,false));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,200,255,false,false,false));
                serverWorld.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_GHAST_SHOOT, SoundCategory.BLOCKS, 2.0F, 0.0F);
                user.sendMessage(Text.literal("Destroy them.").formatted(Formatting.DARK_RED),true);
                user.getItemCooldownManager().set(this,200);
            }
        } return super.use(world, user, hand);
    }

    @Override public boolean postHit(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        if(StyleUtil.getStyle(itemStack) == 1) target.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH,1,3,false,false,false));
        else target.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE,1,3,false,false,false));
        return true;
    }

    @Override public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.empty().append(StyleUtil.style).append(getCurrentStyleTranslation(itemStack)).formatted(getStyleSwitchFormatting(itemStack)));
        if (StyleUtil.getStyle(itemStack) == 1)  tooltip.add(Text.literal("Hits heal those blessed by the sun!").formatted(Formatting.GOLD));
        else {
            tooltip.add(Text.literal("Hits deal a huge amount of damage.").formatted(Formatting.GOLD));
            tooltip.add(Text.literal("Right click to channel your rage.").formatted(Formatting.DARK_RED));
        }
        tooltip.add(StyleUtil.switchText(world, 1));
        if (StyleUtil.getStyle(itemStack) == 1) {
            tooltip.add(Text.translatable("pillar.trevorssentinels.justice").formatted(Formatting.ITALIC, Formatting.YELLOW));
        } else {
            assert world != null;
            if(world.getTime() % 10 == 0) tooltip.add(Text.literal("Power").formatted(Formatting.DARK_GRAY, Formatting.ITALIC));
            else if(world.getTime() % 12 == 0) tooltip.add(Text.literal("Power").formatted(Formatting.DARK_RED, Formatting.ITALIC));
            else if((world.getTime() & 13) == 0) tooltip.add(Text.literal("Power").formatted(Formatting.YELLOW, Formatting.ITALIC));
            else if((world.getTime() % 4 == 0)) tooltip.add(Text.literal("Power").formatted(Formatting.YELLOW, Formatting.ITALIC,Formatting.OBFUSCATED));
            else tooltip.add(Text.literal("Power" ).formatted(Formatting.DARK_GRAY, Formatting.ITALIC, Formatting.OBFUSCATED));
        }
    }

    @Override public boolean hasGlint(ItemStack itemStack){ return StyleUtil.getStyle(itemStack) == 2; }
}
