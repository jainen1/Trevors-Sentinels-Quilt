package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.event.KeyInputHandler;
import net.trevorskullcrafter.trevorssentinels.util.StyleUtil;
import net.trevorskullcrafter.trevorssentinels.util.TextUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HardLightProjectorItem extends Item {
    private final Block block;
    public HardLightProjectorItem(Block block, Settings settings) { super(settings); this.block = block; }

    @Override public ActionResult useOnBlock(ItemUsageContext context) {
        //Server: giving/removing items
        //Client: rendering, particle effects, music/sound
        World world = context.getWorld(); PlayerEntity user = context.getPlayer(); BlockPos blockPos = context.getBlockPos(); ActionResult actionResult = ActionResult.FAIL;
        if(!world.isClient() && context.getHand() == Hand.MAIN_HAND && user != null){
            ItemStack itemStack = user.getMainHandStack();
            if(!KeyInputHandler.styleSwitch.isPressed()){
                if (itemStack.getDamage() < itemStack.getMaxDamage() - 1) {
                    BlockState state = block.getPlacementState(new ItemPlacementContext(context));
                    if (world.canPlace(state, blockPos.offset(context.getSide()), ShapeContext.absent())) {
                        context.getWorld().setBlockState(blockPos.offset(context.getSide()), state, 11);
                        itemStack.damage(1, user, p -> p.sendToolBreakStatus(context.getHand()));
                        BlockSoundGroup blockSoundGroup = state.getSoundGroup();
                        world.playSound(user, blockPos, blockSoundGroup.getPlaceSound(), SoundCategory.BLOCKS, (blockSoundGroup.getVolume() + 1.0F) / 2.0F, blockSoundGroup.getPitch() * 0.8F);
                        actionResult = ActionResult.SUCCESS;
                    } else user.sendMessage(Text.literal("Block placement failed!").formatted(Formatting.GOLD), true);
                } else user.sendMessage(TextUtil.coloredText("Out of charges!", TextUtil.SENTINEL_CRIMSON_T1), true);
            }
        } return actionResult;
    }

    @Override public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (StyleUtil.getStyle(itemStack) == 1) tooltip.add(Text.literal("Deploys temporary blocks of hard light.").formatted(Formatting.DARK_AQUA));
        tooltip.add(Text.literal("Blocks remaining: "+(itemStack.getMaxDamage() - itemStack.getDamage() - 1)+ " / " + (itemStack.getMaxDamage()-1))
                .formatted(itemStack.getDamage() <= (itemStack.getMaxDamage()/2)-1 ? Formatting.AQUA : ((itemStack.getDamage() < itemStack.getMaxDamage()-1) ? Formatting.YELLOW : Formatting.RED)));
        super.appendTooltip(itemStack, world, tooltip, context);
    }
}
