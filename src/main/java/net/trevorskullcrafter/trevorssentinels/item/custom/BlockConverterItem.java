package net.trevorskullcrafter.trevorssentinels.item.custom;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.Optional;
import java.util.function.Supplier;

public class BlockConverterItem extends Item {
	public static Supplier<BiMap<Block, Block>> CONVERSION_BLOCKS; SoundEvent sound; float volume; float pitch;
	public BlockConverterItem(Settings settings, SoundEvent sound, float volume, float pitch, ImmutableBiMap<Block, Block> conversions) {
		super(settings); this.sound = sound; this.volume = volume; this.pitch = pitch;
		CONVERSION_BLOCKS = Suppliers.memoize(() -> conversions);
	}

	@Override public ActionResult useOnBlock(ItemUsageContext context) {
		World world = context.getWorld();
		BlockPos blockPos = context.getBlockPos();
		BlockState blockState = world.getBlockState(blockPos);
		return getConvertedState(blockState).map(state -> {
			PlayerEntity playerEntity = context.getPlayer();
			ItemStack itemStack = context.getStack();
			if (playerEntity instanceof ServerPlayerEntity) {
				Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity)playerEntity, blockPos, itemStack);
			}

			itemStack.decrement(1);
			world.setBlockState(blockPos, state, Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
			world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.create(playerEntity, state));
			world.playSound(blockPos, sound, SoundCategory.BLOCKS, volume, pitch, false);
			//serverWorld.spawnParticles();
			return ActionResult.success(world.isClient);
		}).orElse(ActionResult.PASS);
	}

	public static Optional<BlockState> getConvertedState(BlockState state) {
		return Optional.ofNullable(CONVERSION_BLOCKS.get().get(state.getBlock())).map(block -> block.getStateWithProperties(state));
	}
}
