package net.trevorskullcrafter.trevorssentinels.networking.packet;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.trevorskullcrafter.trevorssentinels.item.custom.Reloadable;
import org.quiltmc.qsl.networking.api.PacketSender;

public class ReloadableC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender){
        if(player.getMainHandStack().getItem() instanceof Reloadable reloadable){ reloadable.reload(player.getMainHandStack(), player.getWorld(), player); }
        if(player.getOffHandStack().getItem() instanceof Reloadable reloadable){ reloadable.reload(player.getOffHandStack(), player.getWorld(), player); }
    }
}
