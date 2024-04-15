package net.trevorskullcrafter.trevorssentinels.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.entity.custom.ShardEntity;

public class ChainsawItem extends AxeItem {
    public ChainsawItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);
        if(world instanceof ServerWorld serverWorld && hand == Hand.MAIN_HAND){
            serverWorld.playSoundFromEntity(null, user, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.PLAYERS, 0.5F, 2.0F);
            serverWorld.playSoundFromEntity(null, user, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);

            ShardEntity shardEntity = new ShardEntity(serverWorld, user);
            shardEntity.setVelocity(user.getPitch(), user.getYaw(), 0.0f, 1.0f, 1.0f); serverWorld.spawnEntity(shardEntity);
            if (user instanceof ServerPlayerEntity serverPlayerEntity) serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(itemStack.getItem()));
            itemStack.damage(2, user, p -> p.sendToolBreakStatus(hand));
            user.getItemCooldownManager().set(this,10);
        } return super.use(world, user, hand);
    }
}
