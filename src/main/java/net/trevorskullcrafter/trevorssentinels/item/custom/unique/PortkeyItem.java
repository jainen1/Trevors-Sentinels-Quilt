package net.trevorskullcrafter.trevorssentinels.item.custom.unique;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

import static java.lang.Math.round;

public class PortkeyItem extends Item {
    public PortkeyItem(Settings settings) { super(settings); }

    @Override public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);
        if(world instanceof ServerWorld serverWorld && hand == Hand.MAIN_HAND){
            if(!user.isSneaking()){
                if (itemStack.getSubNbt("trevorssentinels:teleportData") != null) {
                    if(itemStack.getDamage() <= 0){
                        user.requestTeleportAndDismount(
                                Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:teleportData")).getInt("trevorssentinels:playerPosX"),
                                Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:teleportData")).getInt("trevorssentinels:playerPosY"),
                                Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:teleportData")).getInt("trevorssentinels:playerPosZ"));
                        serverWorld.playSoundFromEntity(null, user, SoundEvents.ENTITY_WARDEN_SONIC_BOOM, SoundCategory.BLOCKS, 2.0f, 2.0f);
                        user.getItemCooldownManager().set(this, 20);
                        itemStack.damage(itemStack.getMaxDamage()-1, user, p -> p.sendToolBreakStatus(hand));
                        if(itemStack.getDamage() >= 0) serverWorld.playSoundFromEntity(null, user, SoundEvents.BLOCK_RESPAWN_ANCHOR_SET_SPAWN,
                                SoundCategory.BLOCKS, 1.0f, 1.0f);
                        return TypedActionResult.success(itemStack);
                    } else user.sendMessage(Text.literal("This item must be repaired!").formatted(Formatting.YELLOW),true);
                } else user.sendMessage(Text.literal("You must first bind this item to a location!").formatted(Formatting.YELLOW),true);
            } else {
                if(itemStack.getDamage() > 0){
                    serverWorld.playSoundFromEntity(null, user, SoundEvents.BLOCK_AMETHYST_CLUSTER_BREAK, SoundCategory.BLOCKS, 1.0f,-2.0f);
                    itemStack.damage(-1, user, p -> p.sendToolBreakStatus(hand));
                    if(itemStack.getDamage() <= 0) serverWorld.playSoundFromEntity(null, user, SoundEvents.BLOCK_RESPAWN_ANCHOR_SET_SPAWN,
                            SoundCategory.BLOCKS, 1.0f,1.0f);
                    user.getItemCooldownManager().set(this,100);
                } else {
                    NbtCompound nbtData = new NbtCompound();
                    nbtData.putDouble("trevorssentinels:playerPosX", user.getX());
                    nbtData.putDouble("trevorssentinels:playerPosY", user.getY());
                    nbtData.putDouble("trevorssentinels:playerPosZ", user.getZ());
                    nbtData.putString("trevorssentinels:boundText",
                            "Bound to " + round(user.getX()) + ", " + round(user.getY()) + ", " + round(user.getZ()));
                    itemStack.setSubNbt("trevorssentinels:teleportData", nbtData);

                    user.sendMessage(Text.literal(Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:teleportData")).getString("trevorssentinels:boundText"))
                            .formatted(Formatting.DARK_PURPLE), true);
                    serverWorld.playSoundFromEntity(null, user, SoundEvents.ENTITY_WARDEN_SONIC_CHARGE, SoundCategory.BLOCKS, 2.0F, 2.0F);
                    user.getItemCooldownManager().set(this, 10);
                    return TypedActionResult.success(itemStack);
                }
            }
        } return super.use(world, user, hand);
    }

    @Override public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(itemStack.getSubNbt("trevorssentinels:teleportData") != null){
            if(itemStack.getDamage() <= 0) tooltip.add(Text.literal(Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:teleportData")).getString("trevorssentinels:boundText")).formatted(Formatting.DARK_PURPLE));
            else tooltip.add(Text.literal(Objects.requireNonNull(itemStack.getSubNbt("trevorssentinels:teleportData")).getString("trevorssentinels:boundText")).formatted(Formatting.GRAY));
        } super.appendTooltip(itemStack, world, tooltip, context);
    }

    @Override public boolean hasGlint(ItemStack stack){ return stack.getSubNbt("trevorssentinels:teleportData") != null; }
}
