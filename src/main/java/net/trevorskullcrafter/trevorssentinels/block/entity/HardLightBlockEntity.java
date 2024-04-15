package net.trevorskullcrafter.trevorssentinels.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.block.custom.HardLightBlock;

public class HardLightBlockEntity extends BlockEntity {
    int lifetime;
    public HardLightBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.HARD_LIGHT, pos, state);
        lifetime = 100;
    }

    @Override protected void writeNbt(NbtCompound nbt) {
        nbt.putInt("lifetime", lifetime);
        super.writeNbt(nbt);
    }

    @Override public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        lifetime = nbt.getInt("lifetime");
    }

    public static void tick(World world, BlockPos pos, BlockState state, HardLightBlockEntity blockEntity) {
        --blockEntity.lifetime;
        if(blockEntity.lifetime < 1 && !(world.getBlockState(pos.north()).getBlock() instanceof HardLightBlock) &&
                !(world.getBlockState(pos.west()).getBlock() instanceof HardLightBlock) && !(world.getBlockState(pos.up()).getBlock() instanceof HardLightBlock)){
            world.breakBlock(pos, false);
        }
    }
}