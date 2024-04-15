package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.entity.custom.DaggerEntity;
import net.trevorskullcrafter.trevorssentinels.util.TextUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NewDaggerItem extends SwordItem {
    private final ToolMaterial material;
    private final StatusEffectInstance[] effects;

    public NewDaggerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, StatusEffectInstance... effects) {
        super(toolMaterial, attackDamage, attackSpeed, settings); this.material = toolMaterial; this.effects = effects;
    }

	public ToolMaterial getMaterial() { return material; }
	public int getDurability() { return this.material.getDurability(); }

    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (state.isOf(Blocks.COBWEB)) { return 7.5F; }
        else { return state.isIn(BlockTags.SWORD_EFFICIENT) ? 1.25F : 1.0F; }
    }

    @Override public UseAction getUseAction(ItemStack stack) { return UseAction.SPEAR; }
    @Override public int getMaxUseTime(ItemStack stack) { return 72000; }
    @Override public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return TypedActionResult.consume(user.getStackInHand(hand));
    }

    @Override public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity playerEntity) {
            int i = this.getMaxUseTime(stack) - remainingUseTicks;
            if(i >= 10) { if (world instanceof ServerWorld serverWorld) {
                DaggerEntity dagger = new DaggerEntity(serverWorld, user, stack.getItem().getDefaultStack(), getAttackDamage(), getDurability(), effects);
                dagger.setProperties(user, user.getPitch(), user.getYaw(), 0.0f, BowItem.getPullProgress(i) * 3.0f, 0.0f);
                if (playerEntity.getAbilities().creativeMode) dagger.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
                serverWorld.spawnEntity(dagger);
                serverWorld.playSoundFromEntity(null, dagger, SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS,
                        user.isSneaking()? 0.2f : 1f, 1f);
                if (!playerEntity.getAbilities().creativeMode) stack.decrement(1);
            } playerEntity.incrementStat(Stats.USED.getOrCreateStat(stack.getItem()));
            }
        }
    }

    @Override public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        //tooltip.add(Text.literal(attackDamage+" ").append(Text.translatable("attribute.name.generic.attack_damage")).formatted(Formatting.DARK_GREEN));
        if(effects.length > 0) {if (stack.getHolder() instanceof PlayerEntity player && player.isSneaking()) {
            for (StatusEffectInstance statusEffectInstance : effects) { tooltip.add(TextUtil.potionText(statusEffectInstance, true));
        }} else { tooltip.add(Text.empty().append(Text.literal("SHIFT").formatted(Formatting.YELLOW))
                .append(Text.literal(" to show status effects.").formatted(Formatting.DARK_GRAY))); }
        } super.appendTooltip(stack, world, tooltip, context);
    }
}
