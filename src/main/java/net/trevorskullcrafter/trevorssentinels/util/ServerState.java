package net.trevorskullcrafter.trevorssentinels.util;

import net.minecraft.datafixer.DataFixTypes;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain;
import org.jetbrains.annotations.NotNull;

public class ServerState extends PersistentState {
    public int worldLevel = 1; boolean keepingTrack = true;

    private static final PersistentState.C_vpqwshwc<ServerState> type = new C_vpqwshwc<>(ServerState::new, ServerState::createFromNbt, DataFixTypes.WORLD_GEN_SETTINGS);

    @Override public NbtCompound writeNbt(NbtCompound nbt) {
        nbt.putInt("trevorssentinels:worldLevel", worldLevel);
        nbt.putBoolean("trevorssentinels:worldLevelTracking", keepingTrack);
        return nbt;
    }

    public static ServerState createFromNbt(NbtCompound tag){
        ServerState serverState = new ServerState();
        serverState.worldLevel = tag.getInt("trevorssentinels:worldLevel");
        serverState.keepingTrack = tag.getBoolean("trevorssentinels:worldLevelTracking");
        return serverState;
    }

    public static @NotNull ServerState getServerState(MinecraftServer server){
        PersistentStateManager persistentStateManager = server.getWorld(World.OVERWORLD).getPersistentStateManager();
        ServerState state = persistentStateManager.getOrCreate(type, trevorssentinelsMain.MOD_ID);
        state.markDirty();
        return state;
    }
}
