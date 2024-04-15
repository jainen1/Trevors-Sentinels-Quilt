package net.trevorskullcrafter.trevorssentinels.item.custom.unique;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
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
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.util.StyleUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

import static java.lang.Math.round;

public class ThanatuBladeItem extends SwordItem implements StyleUtil.StyleSwitcher {
    public int timePercent;

    public ThanatuBladeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override public Formatting getStyleSwitchFormatting(ItemStack stack) {
        return (StyleUtil.getStyle(stack) & 2) == 0? Formatting.DARK_PURPLE : Formatting.LIGHT_PURPLE;
    }

    @Override public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (world instanceof ServerWorld serverWorld && hand == Hand.MAIN_HAND) {
            if (StyleUtil.getStyle(itemStack) == 1) {
                if (user.isSneaking()) {
                    NbtCompound nbtData = new NbtCompound();
                    nbtData.putDouble("trevorssentinels:playerPosX", user.getX());
                    nbtData.putDouble("trevorssentinels:playerPosY", user.getY());
                    nbtData.putDouble("trevorssentinels:playerPosZ", user.getZ());
                    nbtData.putString("trevorssentinels:boundText", "Bound to " + round(user.getX()) + ", " + round(user.getY()) + ", " + round(user.getZ()));
                    itemStack.setSubNbt("trevorssentinels:harmoniousTeleportData", nbtData);

                    NbtCompound timer = new NbtCompound();
                    timer.putLong("trevorssentinels:timer", serverWorld.getTime() + 200);
                    itemStack.setSubNbt("trevorssentinels:timerHolder", timer);
                    timePercent = (int) (Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:timerHolder"))
                            .getLong("trevorssentinels:timer") - serverWorld.getTime()) / 2;

                    user.sendMessage(Text.literal(Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:harmoniousTeleportData"))
                                    .getString("trevorssentinels:boundText")).formatted(Formatting.LIGHT_PURPLE), true);
                    serverWorld.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_WARDEN_SONIC_CHARGE, SoundCategory.BLOCKS, 2.0F, 2.0F);
                    user.getItemCooldownManager().set(this, 10);
                    return TypedActionResult.success(itemStack);
                } else {
                    if (itemStack.getSubNbt("trevorssentinels:harmoniousTeleportData") != null) { user.requestTeleportAndDismount(
                            Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:harmoniousTeleportData")).getInt("trevorssentinels:playerPosX"),
                            Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:harmoniousTeleportData")).getInt("trevorssentinels:playerPosY"),
                            Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:harmoniousTeleportData")).getInt("trevorssentinels:playerPosZ"));
                        serverWorld.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_WARDEN_SONIC_BOOM, SoundCategory.BLOCKS, 2.0f, 2.0f);
                        user.getItemCooldownManager().set(this, 20);
                        return TypedActionResult.success(itemStack);
                    } else user.sendMessage(Text.literal("This item is not bound to a location!").formatted(Formatting.GRAY), true);
                }
            } else {
                LightningEntity lightningEntity = new LightningEntity(EntityType.LIGHTNING_BOLT, serverWorld);
                lightningEntity.setCosmetic(true);
                lightningEntity.setPos(user.getX(), user.getY()+50, user.getZ());
                serverWorld.spawnEntity(lightningEntity);

                user.sendMessage(Text.literal("Yeah this isn't working yet, sorry.").formatted(Formatting.DARK_PURPLE), true);
                serverWorld.playSound(null, user.getBlockPos(), SoundEvents.BLOCK_END_PORTAL_SPAWN, SoundCategory.BLOCKS, 0.5f, 1.0f);
                user.getItemCooldownManager().set(this, 200);
            }
        } return super.use(world, user, hand);
    }

    @Override public boolean postHit(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        if(StyleUtil.getStyle(itemStack) == 1){
            if(itemStack.getSubNbt("trevorssentinels:harmoniousTeleportData") != null) {
                target.requestTeleportAndDismount(
                        Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:harmoniousTeleportData")).getInt("trevorssentinels:playerPosX"),
                        Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:harmoniousTeleportData")).getInt("trevorssentinels:playerPosY"),
                        Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:harmoniousTeleportData")).getInt("trevorssentinels:playerPosZ"));
                target.getWorld().playSound(null, target.getBlockPos(), SoundEvents.ENTITY_WARDEN_SONIC_BOOM, SoundCategory.BLOCKS, 2.0F, 2.0F);
            } else target.requestTeleportAndDismount(target.getX(), target.getY() + 1, target.getZ());
        } else target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER,60,0,true,true,false));
        return true;
    }

    @Override public void inventoryTick(ItemStack itemStack, World world, Entity entity, int slot, boolean selected) {
        if(world instanceof ServerWorld serverWorld && itemStack.getSubNbt("trevorssentinels:harmoniousTeleportData") != null
			&& Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:timerHolder")).getLong("trevorssentinels:timer") <= serverWorld.getTime())
		{ itemStack.removeSubNbt("trevorssentinels:harmoniousTeleportData"); itemStack.removeSubNbt("trevorssentinels:timerHolder"); }
		super.inventoryTick(itemStack, world, entity, slot, selected);
    }

    @Override public boolean isItemBarVisible(ItemStack stack) { return stack.getSubNbt("trevorssentinels:timerHolder") != null; }

    @Override public int getItemBarStep(ItemStack stack) {
        if (stack.getHolder() != null && timePercent != 0) return Math.round(13.0F - timePercent * 13.0F / 100);
        else return super.getItemBarStep(stack);
    }

    @Override public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.empty().append(StyleUtil.style).append(getCurrentStyleTranslation(itemStack)).formatted(getStyleSwitchFormatting(itemStack)));
        if (StyleUtil.getStyle(itemStack) == 1) {
            if(itemStack.getSubNbt("trevorssentinels:harmoniousTeleportData") != null) {
                tooltip.add(Text.literal(Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:harmoniousTeleportData"))
                        .getString("trevorssentinels:boundText")).formatted(Formatting.LIGHT_PURPLE));

                tooltip.add(Text.literal("Attacks will also teleport").formatted(Formatting.ITALIC, Formatting.GRAY));
                tooltip.add(Text.literal("the target to this location.").formatted(Formatting.ITALIC, Formatting.GRAY));

                if (itemStack.getSubNbt("trevorssentinels:timerHolder") != null){
                    assert world != null;
                    tooltip.add(Text.literal("Rift " + (Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:timerHolder"))
                            .getLong("trevorssentinels:timer") - world.getTime()) / 2 + "% Stable"));
                }
            }else {
                tooltip.add(Text.literal("Hold shift and right click").formatted(Formatting.GRAY));
                tooltip.add(Text.literal("to bind to a location!").formatted(Formatting.GRAY));
            }
        } else {
            tooltip.add(Text.literal("Right click to summon allies! (WIP)").formatted(Formatting.LIGHT_PURPLE));

            tooltip.add(Text.literal("Attacks will also apply").formatted(Formatting.ITALIC, Formatting.GRAY));
            tooltip.add(Text.literal("the Crystallized debuff.").formatted(Formatting.ITALIC, Formatting.GRAY));
        }
        tooltip.add(StyleUtil.switchText(world, 1));
        tooltip.add(Text.translatable("pillar.trevorssentinels.tranquility").formatted(Formatting.DARK_PURPLE, Formatting.ITALIC));
        super.appendTooltip(itemStack, world, tooltip, context);
    }

    @Override public boolean hasGlint(ItemStack stack){ return stack.getSubNbt("trevorssentinels:timerHolder") != null; }
}
