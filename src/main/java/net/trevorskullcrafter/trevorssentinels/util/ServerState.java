package net.trevorskullcrafter.trevorssentinels.util;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class ServerState extends PersistentState {
    public int worldLevel = 1; boolean keepingTrack = true;

    private static final Type<ServerState> type = new Type<>(ServerState::new, ServerState::createFromNbt,
            null /*Meant to be of 'DataFixTypes' enum, but accepts null*/);

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
        ServerState state = persistentStateManager.getOrCreate(type, MOD_ID);
        state.markDirty();
        return state;
    }
}