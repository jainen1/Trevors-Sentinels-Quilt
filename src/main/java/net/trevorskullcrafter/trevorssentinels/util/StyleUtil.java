package net.trevorskullcrafter.trevorssentinels.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.event.KeyInputHandler;

import static net.trevorskullcrafter.trevorssentinels.util.TextUtil.GOLD;
import static net.trevorskullcrafter.trevorssentinels.util.TextUtil.SENTINEL_AQUA_T1;

public class StyleUtil {
    public static final Text style = TextUtil.coloredText("tooltip.trevorssentinels.style", GOLD);
    public static final Text mode = TextUtil.coloredText("tooltip.trevorssentinels.mode", SENTINEL_AQUA_T1);

    @Environment(EnvType.CLIENT) public static Text switchText(World world, int mode){
        if (world instanceof ClientWorld) return Text.literal(Text.keyBind(KeyInputHandler.styleSwitch.getTranslationKey()).getString().toUpperCase())
                .formatted(Formatting.YELLOW).append(Text.translatable("tooltip.trevorssentinels.style_switch."+ mode).formatted(Formatting.DARK_GRAY));
        return Text.literal("ERROR LOADING KEYBIND").formatted(Formatting.RED);
    }

    public static int getStyle(ItemStack stack){
        NbtCompound nbt = stack.getOrCreateNbt();
        if (!nbt.contains("trevorssentinels:Style")) { setStyle(stack, 1); }
        return nbt.getInt("trevorssentinels:Style");
    }
    public static void setStyle(ItemStack stack, int newStyle){ stack.getOrCreateNbt().putInt("trevorssentinels:Style", newStyle); }

    public interface StyleSwitcher {
        default SoundEvent getSwitchSoundEvent(ItemStack stack){ return SoundEvents.BLOCK_END_PORTAL_FRAME_FILL; }
        default float getSwitchSoundVolume(ItemStack stack){ return 1.0f; }
        default float getSwitchSoundPitch(ItemStack stack){ return (StyleUtil.getStyle(stack) % 2) == 0? 1.0F : 1.2F; }
        default int getStyles(ItemStack stack) { return 2; }
        default Formatting getStyleSwitchFormatting(ItemStack stack){ return StyleUtil.getStyle(stack) == 2? Formatting.GREEN : Formatting.RED; }
        default Text getSwitchMessagePrefix(ItemStack stack) { return StyleUtil.style; }
        default Text getCurrentStyleTranslation(ItemStack stack) { return Text.translatable("style."+stack.getTranslationKey()+"."+StyleUtil.getStyle(stack)); }

        default void sendSwitchSound(ServerPlayerEntity player, ItemStack stack){
            player.getServerWorld().playSoundFromEntity(null, player, getSwitchSoundEvent(stack), SoundCategory.BLOCKS, getSwitchSoundVolume(stack), getSwitchSoundPitch(stack));
        }

        default void sendSwitchMessage(ServerPlayerEntity player, ItemStack stack){
            player.sendMessage(Text.empty().append(getSwitchMessagePrefix(stack)).append(getCurrentStyleTranslation(stack)).formatted(getStyleSwitchFormatting(stack)), true);
        }

        default void onStyleSwitch(ServerPlayerEntity player){ ItemStack stack = player.getMainHandStack(); sendSwitchSound(player, stack); sendSwitchMessage(player, stack); }
    }
}
