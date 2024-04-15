package net.trevorskullcrafter.trevorssentinels.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class ModificationTableBlockEntity extends BlockEntity {
    public ModificationTableBlockEntity(BlockPos pos, BlockState state) { super(ModBlockEntities.MODIFICATION_TABLE, pos, state); }
}
