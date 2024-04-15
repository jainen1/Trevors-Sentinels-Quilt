package net.trevorskullcrafter.trevorssentinels.item.custom.unique;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class DistanceTrackerItem extends Item {
    LivingEntity attachedMob; double distance; Text text1; Text text2; float pitch; int timeTick;
    public DistanceTrackerItem(Settings settings) { super(settings); }

    @Override public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if(!user.getWorld().isClient() && hand == Hand.MAIN_HAND) attachedMob = entity; return super.useOnEntity(stack, user, entity, hand);
    }

    @Override public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(entity instanceof PlayerEntity playerEntity) {
            if (world instanceof ServerWorld serverWorld) {
                if (attachedMob != null && attachedMob.isAlive()) {
                    distance = (double) Math.round(Math.sqrt(Math.pow(attachedMob.getBlockX() - entity.getBlockX(), 2) +
                            Math.pow(attachedMob.getBlockY() - entity.getBlockY(), 2) + Math.pow(attachedMob.getBlockZ() - entity.getBlockZ(), 2)) * 10) / 10;
                    if (distance < 100) {
                        int newState; String newCont = distance + "m"; Formatting form1; Formatting form2;
                        if (distance >= 50) { newState = 0; newCont = "88.8m"; form1 = Formatting.DARK_GRAY; form2 = Formatting.DARK_GRAY; pitch = 0f; timeTick = 40; }
                        else if (distance >= 25) { newState = 1; form1 = Formatting.DARK_GREEN; form2 = Formatting.GREEN; pitch = 0.9f; timeTick = 20; }
                        else if (distance >= 10) { newState = 2; form1 = Formatting.GOLD; form2 = Formatting.YELLOW; pitch = 1.0f; timeTick = 10; }
                        else { newState = 3; newCont = "0" + newCont; form1 = Formatting.DARK_RED; form2 = Formatting.RED; pitch = 1.2f; timeTick = 2; }
                        text1 = Text.literal(newCont).formatted(form1); text2 = Text.literal(newCont).formatted(form2);
                        resetNbt(stack, newState);
                    }
                } else {
                    resetNbt(stack, 0);
                    text1 = null; text2 = null; pitch = 0f; timeTick = 0; attachedMob = null;
                }
            } else if (distance < 100 && text1 != null && text2 != null && selected) {
                if ((world.getTime() & timeTick) == 0) {
                    playerEntity.sendMessage(text1, true);
                    if (pitch != 0f) entity.playSound(SoundEvents.BLOCK_METAL_PRESSURE_PLATE_CLICK_OFF, 0.5f, pitch);
                } else playerEntity.sendMessage(text2, true);
            }
        } super.inventoryTick(stack, world, entity, slot, selected);
    }

    public void resetNbt(ItemStack stack, int state){
        if((stack.getSubNbt("trevorssentinels:model") == null) || (Objects.requireNonNull(stack.getSubNbt("trevorssentinels:model"))
                .getInt("trevorssentinels:modelNum") != state)){
            NbtCompound nbtData = new NbtCompound(); nbtData.putInt("trevorssentinels:modelNum", state); stack.setSubNbt("trevorssentinels:model", nbtData);
        }
    }

    @Override public boolean allowNbtUpdateAnimation(PlayerEntity player, Hand hand, ItemStack oldStack, ItemStack newStack) { return false; }
    @Override public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(attachedMob == null) tooltip.add(Text.literal("Tracking system offline.").formatted(Formatting.DARK_RED));
        else tooltip.add(Text.literal("Tracking system online...").formatted(Formatting.GOLD));
        super.appendTooltip(itemStack, world, tooltip, context);
    }
}
