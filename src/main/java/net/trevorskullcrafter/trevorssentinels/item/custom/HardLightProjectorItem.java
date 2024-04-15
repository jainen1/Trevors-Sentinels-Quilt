package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.util.StyleUtil;
import net.trevorskullcrafter.trevorssentinels.util.TextUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HardLightProjectorItem extends AliasedBlockItem {
    public HardLightProjectorItem(Block block, Settings settings) { super(block,settings); if (block == null) throw new RuntimeException(); }

    @Override public ActionResult useOnBlock(ItemUsageContext context) {
		PlayerEntity user = context.getPlayer(); ItemStack itemStack = user.getMainHandStack();
		if (itemStack.getDamage() < itemStack.getMaxDamage() - 1) {
			ActionResult actionResult = this.place(new ItemPlacementContext(context));
			if(actionResult.isAccepted()) { itemStack.damage(1, user, p -> p.sendToolBreakStatus(context.getHand())); }
			return actionResult;
		} else { user.sendMessage(TextUtil.coloredText("Out of charges!", TextUtil.SENTINEL_CRIMSON_T1), true); }
        return ActionResult.FAIL;
    }

    @Override public void appendTooltip(ItemStack itemStack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (StyleUtil.getStyle(itemStack) == 1) tooltip.add(Text.literal("Deploys temporary blocks of hard light.").formatted(Formatting.DARK_AQUA));
        tooltip.add(Text.literal("Blocks remaining: "+(itemStack.getMaxDamage() - itemStack.getDamage() - 1)+ " / " + (itemStack.getMaxDamage()-1))
                .formatted(itemStack.getDamage() <= (itemStack.getMaxDamage()/2)-1 ? Formatting.AQUA : ((itemStack.getDamage() < itemStack.getMaxDamage()-1) ? Formatting.YELLOW : Formatting.RED)));
		super.appendTooltip(itemStack, world, tooltip, context);
    }
}
