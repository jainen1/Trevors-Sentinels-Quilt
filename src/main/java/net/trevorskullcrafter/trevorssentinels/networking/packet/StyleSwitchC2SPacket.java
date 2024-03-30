package net.trevorskullcrafter.trevorssentinels.networking.packet;

import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.trevorskullcrafter.trevorssentinels.util.StyleUtil;
import org.quiltmc.qsl.networking.api.PacketSender;

public class StyleSwitchC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender){
        ItemStack stack = player.getMainHandStack();
        if (stack.getItem() instanceof StyleUtil.StyleSwitcher styledItem && styledItem.getStyles(stack) > 1){
            StyleUtil.setStyle(stack, StyleUtil.getStyle(stack) == styledItem.getStyles(stack)? 1 : StyleUtil.getStyle(stack)+1);
            styledItem.onStyleSwitch(player);
        }
    }
}
