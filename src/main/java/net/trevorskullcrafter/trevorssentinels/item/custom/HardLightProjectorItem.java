package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.trevorskullcrafter.trevorssentinels.util.TextUtil;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.List;

public class HardLightProjectorItem extends AliasedBlockItem implements FuelableItem {
	public int maxFuel; public Color color;
    public HardLightProjectorItem(Block block, Color color, int maxFuel, Settings settings) {
		super(block,settings); this.color = color; this.maxFuel = maxFuel; if (block == null) throw new RuntimeException();
	}

	@Override public ItemStack getDefaultStack() {
		ItemStack stack = super.getDefaultStack();
		setFuel(stack, getMaxFuel(stack));
		return stack;
	}

	@Override public ActionResult place(ItemPlacementContext context) {
		BlockPos blockPos = context.getBlockPos();
		World world = context.getWorld();
		PlayerEntity player = context.getPlayer();
		ItemStack stack = context.getStack();

		if(getFuel(stack) > 0 && this.getBlock().enabledIn(context.getWorld().getEnabledFlags()) && context.canPlace()){
			BlockState blockState = this.getPlacementState(context);
			BlockState blockState2 = world.getBlockState(blockPos);
			if (blockState != null && this.place(context, blockState)) {
				if (blockState2.isOf(blockState.getBlock())) {
					blockState2 = this.placeFromTag(blockPos, world, stack, blockState2);
					this.postPlacement(blockPos, world, player, stack, blockState2);
					blockState2.getBlock().onPlaced(world, blockPos, blockState2, player, stack);
					if (player instanceof ServerPlayerEntity) { Criteria.PLACED_BLOCK.trigger((ServerPlayerEntity) player, blockPos, stack); }
				}

				BlockSoundGroup blockSoundGroup = blockState2.getSoundGroup();
				world.playSound(player, blockPos, getPlaceSound(blockState2), SoundCategory.BLOCKS,
					(blockSoundGroup.getVolume() + 1.0F) / 2.0F, blockSoundGroup.getPitch() * 0.8F);
				world.emitGameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Context.create(player, blockState2));
				if (player == null || !player.getAbilities().creativeMode) { setFuel(stack, getFuel(stack) - 1); }
				return ActionResult.success(world.isClient);
			}
		} else { if(player != null) { player.sendMessage(TextUtil.coloredText("Out of charges!", TextUtil.SENTINEL_CRIMSON1), true); }}
		return ActionResult.FAIL;
	}

	@Override public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(fuelText(stack));
		super.appendTooltip(stack, world, tooltip, context);
    }

	@Override public int getMaxFuel(ItemStack stack) { return maxFuel; }
	@Override public int getItemBarStep(ItemStack stack) { return Math.round(getFuel(stack) * 13.0F / getMaxFuel(stack)); }
	@Override public int getItemBarColor(ItemStack stack) { return color.getRGB(); }
	@Override public boolean isItemBarVisible(ItemStack stack) { return getFuel(stack) != getMaxFuel(stack); }
}
