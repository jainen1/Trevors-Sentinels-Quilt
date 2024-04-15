package net.trevorskullcrafter.trevorssentinels.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.util.ModRegistries;

public class FleshBlock extends FallDamagelessBlock {
    SoundEvent randomSound;
    public FleshBlock(float damageMultiplier, SoundEvent randomSound, Settings settings) {
        super(damageMultiplier, settings);
        this.randomSound = randomSound;
    }

    @Override public void randomDisplayTick(BlockState state, World world, BlockPos pos, RandomGenerator random) {
		if (random.nextInt(200) == 0) world.playSound((double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5,
			randomSound, SoundCategory.BLOCKS, random.nextFloat() * 0.5F + 0.1F, random.nextFloat() * 0.4F + 0.8F, false);
		BlockPos.Mutable mutable = new BlockPos.Mutable();
		for(int l = 0; l < 3; ++l) {
			mutable.set(pos.getX() + MathHelper.nextInt(random, -1, 1), pos.getY() + MathHelper.nextInt(random, -1, 1), pos.getZ() + MathHelper.nextInt(random, -1, 1));
			BlockState blockState = world.getBlockState(mutable);
			if (!blockState.isFullCube(world, mutable)) world.addParticle(ModRegistries.FLESH_PUS, (double)mutable.getX() + random.nextDouble(),
				(double)mutable.getY() + random.nextDouble(), (double)mutable.getZ() + random.nextDouble(), 0.0, 0.0, 0.0);
		}
	}

	@Override public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if(itemStack.getItem() instanceof BoneMealItem && world.getBlockState(pos.offset(hit.getSide())).materialReplaceable()){
            if (world instanceof ServerWorld serverWorld) { serverWorld.setBlockState(pos.offset(hit.getSide()), ModBlocks.FLESH_VEINS.getDefaultState()
                    .with(Properties.EAST, hit.getSide() == Direction.WEST).with(Properties.WEST, hit.getSide() == Direction.EAST)
                    .with(Properties.NORTH, hit.getSide() == Direction.SOUTH).with(Properties.SOUTH, hit.getSide() == Direction.NORTH)
                    .with(Properties.UP, hit.getSide() == Direction.DOWN).with(Properties.DOWN, hit.getSide() == Direction.UP));
                serverWorld.syncWorldEvent(1505, pos.offset(hit.getSide()), 0); }
            if(!player.getAbilities().creativeMode) itemStack.decrement(1);
            return ActionResult.CONSUME;
        } return ActionResult.PASS;
    }
}
