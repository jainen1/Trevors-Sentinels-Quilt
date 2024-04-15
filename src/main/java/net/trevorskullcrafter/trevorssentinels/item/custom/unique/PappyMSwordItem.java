package net.trevorskullcrafter.trevorssentinels.item.custom.unique;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.util.StyleUtil;
import net.trevorskullcrafter.trevorssentinels.util.TextUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class PappyMSwordItem extends SwordItem implements StyleUtil.StyleSwitcher {
    public PappyMSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override public int getStyles(ItemStack stack){ return 4; }
    @Override public Formatting getStyleSwitchFormatting(ItemStack stack){ return StyleUtil.getStyle(stack) % 2 == 0? Formatting.GREEN : Formatting.RED; }
    @Override public boolean hasGlint(ItemStack stack){ return getCharge(stack) == 6; }
    StatusEffectInstance[] effects = new StatusEffectInstance[]{
            new StatusEffectInstance(StatusEffects.SPEED, 1, 0),
            new StatusEffectInstance(StatusEffects.SLOWNESS, 10, 1),
            new StatusEffectInstance(StatusEffects.HUNGER, 100, 2),
            new StatusEffectInstance(StatusEffects.RESISTANCE, 1, 0) };
    Text[] paladinText = new Text[]{
            Text.literal("◇ ◇ ◇ ◇ ◇ ◇").formatted(Formatting.GRAY),
            Text.literal("◆ ◇ ◇ ◇ ◇ ◇").formatted(Formatting.DARK_GREEN),
            Text.literal("◆ ◆ ◇ ◇ ◇ ◇").formatted(Formatting.DARK_GREEN),
            Text.literal("◆ ◆ ◆ ◇ ◇ ◇").formatted(Formatting.DARK_GREEN),
            Text.literal("◆ ◆ ◆ ◆ ◇ ◇").formatted(Formatting.GREEN),
            Text.literal("◆ ◆ ◆ ◆ ◆ ◇").formatted(Formatting.GREEN) };

    @Override public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        if(world instanceof ServerWorld serverWorld) {
            if (StyleUtil.getStyle(user.getMainHandStack()) == 1) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200, 1, false, false));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 2, false, false));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 200, 2, false, false));
                serverWorld.playSoundFromEntity(null, user, SoundEvents.ENTITY_WARDEN_SONIC_CHARGE, SoundCategory.BLOCKS, 2.0F, 5.0F);
                user.sendMessage(Text.literal("Energized!").formatted(Formatting.GREEN), true);
                user.getItemCooldownManager().set(this, 200);
                return TypedActionResult.success(user.getMainHandStack());
            } else if (StyleUtil.getStyle(user.getMainHandStack()) == 4){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 5, 255, false, false));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 5, 3, false, false));
                serverWorld.playSoundFromEntity(null, user, SoundEvents.BLOCK_ANVIL_LAND, SoundCategory.BLOCKS, 2.0F, RandomGenerator.createLegacy().nextFloat());
                user.sendMessage(Text.literal("Parry!").formatted(Formatting.GRAY), true);
                user.getItemCooldownManager().set(this, 100);
                return TypedActionResult.success(user.getMainHandStack());
            }
        } return super.use(world, user, hand);
    }

    @Override public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(world instanceof ServerWorld serverWorld && selected && entity instanceof PlayerEntity player) {
            StatusEffectInstance sEI = effects[StyleUtil.getStyle(stack)-1];
            player.addStatusEffect(new StatusEffectInstance(sEI.getEffectType(), 1, sEI.getAmplifier(), false, false));
            if (StyleUtil.getStyle(stack) == 2 && getCharge(stack) == 6) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1, 4, false, false));
                player.sendMessage(Text.literal("◆ ◆ ◆ ◆ ◆ ◆").formatted(serverWorld.getTime() % 2 == 0 ? Formatting.AQUA : Formatting.DARK_AQUA), true);
            }
        } super.inventoryTick(stack, world, entity, slot, selected);
    }

    public int getCharge(ItemStack stack){
        if(stack.getSubNbt("trevorssentinels:paladin") == null) setCharge(stack, 0);
        return Objects.requireNonNull(stack.getSubNbt("trevorssentinels:paladin")).getInt("trevorssentinels:paladinCharge");
    }
    public void setCharge(ItemStack stack, int paladinCharge){
        NbtCompound nbtData = new NbtCompound();
        nbtData.putInt("trevorssentinels:paladinCharge", paladinCharge);
        stack.setSubNbt("trevorssentinels:paladin", nbtData);
    }

    @Override public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(StyleUtil.getStyle(stack) == 2){
            if(getCharge(stack) == 6){
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 77, 2, false, false));
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 77, 1, false, false));
            }
            setCharge(stack, getCharge(stack) == 6? 0 : getCharge(stack)+1);
            if(attacker instanceof PlayerEntity player) player.sendMessage(paladinText[getCharge(stack)], true);
        } else if(StyleUtil.getStyle(stack) == 3) attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 1, 1, false, false));
        return true;
    }

    @Override public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.empty().append(StyleUtil.style).append(getCurrentStyleTranslation(stack)).formatted(getStyleSwitchFormatting(stack)));
        StatusEffectInstance sEI = effects[StyleUtil.getStyle(stack)-1];
        tooltip.add(Text.empty().append(Text.literal("< ").formatted(Formatting.GRAY)).append(TextUtil.potionText(sEI, true))
                .append(Text.literal((sEI.getAmplifier() > 0? " ": "") + ">").formatted(Formatting.GRAY)));
        switch (StyleUtil.getStyle(stack)){
            case 1 -> tooltip.add(Text.literal("Right click to become energized!").formatted(Formatting.GRAY));
            case 2 -> { tooltip.add(Text.literal("Every seventh strike hits harder!").formatted(Formatting.GRAY));
                if(getCharge(stack) == 6) tooltip.add(Text.literal("◆ ◆ ◆ ◆ ◆ ◆").formatted(world == null?null:(world.getTime() % 2 == 0? Formatting.AQUA : Formatting.DARK_AQUA)));
                else tooltip.add(paladinText[getCharge(stack)]);
            }
            case 3 -> tooltip.add(Text.literal("Striking enemies satiates you!").formatted(Formatting.GRAY));
            case 4 -> tooltip.add(Text.literal("Right click to parry!").formatted(Formatting.GRAY));
        }
        tooltip.add(StyleUtil.switchText(world, 1));
        tooltip.add(Text.translatable("pillar.trevorssentinels.balance").formatted(Formatting.DARK_GREEN, Formatting.ITALIC));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
