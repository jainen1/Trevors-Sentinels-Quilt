package net.trevorskullcrafter.trevorssentinels.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.entity.custom.DaggerEntity;
import net.trevorskullcrafter.trevorssentinels.util.TextUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DaggerItem extends Item {
    private final ToolMaterial material;
    private final float attackDamage;
    private final StatusEffectInstance[] effects;
    private final float destroyChance;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public DaggerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, float destroyChance, Item.Settings settings, StatusEffectInstance... effects) {
        super(settings); this.material = toolMaterial; this.attackDamage = (float) attackDamage + toolMaterial.getAttackDamage();
        this.destroyChance = destroyChance; this.effects = effects;
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", attackDamage,
                EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", attackSpeed,
                EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    public ToolMaterial getMaterial() { return this.material; }
    public int getEnchantability() { return this.material.getEnchantability(); }
    public float getAttackDamage() { return this.attackDamage; }
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) { return !miner.isCreative(); }
    public boolean isSuitableFor(BlockState state) { return state.isOf(Blocks.COBWEB); }
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
            if(i >= 10) { if (!world.isClient) {
                DaggerEntity dagger = new DaggerEntity(world, user, stack.getItem().getDefaultStack(), attackDamage, destroyChance, effects);
                dagger.setProperties(user, user.getPitch(), user.getYaw(), 0.0f, BowItem.getPullProgress(i) * 3.0f, 0.0f);
                if (playerEntity.getAbilities().creativeMode) dagger.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
                world.spawnEntity(dagger);
                world.playSoundFromEntity(null, dagger, SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS,
                        user.isSneaking()? 0.2f : 1f, 1f);
                if (!playerEntity.getAbilities().creativeMode) stack.decrement(1);
            } playerEntity.incrementStat(Stats.USED.getOrCreateStat(stack.getItem()));
            }
        }
    }

    @Override public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        //tooltip.add(Text.literal(attackDamage+" ").append(Text.translatable("attribute.name.generic.attack_damage")).formatted(Formatting.DARK_GREEN));
        if(effects.length > 0) {if (Screen.hasShiftDown()) {
            for (StatusEffectInstance statusEffectInstance : effects) { tooltip.add(TextUtil.potionText(statusEffectInstance, true));
        }} else { tooltip.add(Text.empty().append(Text.literal("SHIFT").formatted(Formatting.YELLOW))
                .append(Text.literal(" to show status effects.").formatted(Formatting.DARK_GRAY))); }
        } super.appendTooltip(stack, world, tooltip, context);
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if((attacker.getRandom().nextFloat() % 1f) < destroyChance){
            attacker.getWorld().playSoundFromEntity(null, attacker, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.PLAYERS, 1, 1);
            stack.decrement(1);
        } return true;
    }

    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if ((double)state.getHardness(world, pos) != 0.0) { if ((miner.getRandom().nextFloat() % 1f) < destroyChance) {
            miner.getWorld().playSoundFromEntity(null, miner, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.PLAYERS, 1, 1);
            stack.decrement(1);
        }} return true;
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return (slot == EquipmentSlot.MAINHAND || slot == EquipmentSlot.OFFHAND) ? this.attributeModifiers : super.getAttributeModifiers(slot);
    }
}
