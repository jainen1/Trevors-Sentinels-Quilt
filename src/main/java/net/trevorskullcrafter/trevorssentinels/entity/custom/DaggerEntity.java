package net.trevorskullcrafter.trevorssentinels.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import net.trevorskullcrafter.trevorssentinels.item.TechItems;
import net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain;
import org.jetbrains.annotations.Nullable;

public class DaggerEntity extends PersistentProjectileEntity {
    private static final TrackedData<ItemStack> STORED_STACK = DataTracker.registerData(DaggerEntity.class, TrackedDataHandlerRegistry.ITEM_STACK);
    private StatusEffectInstance[] effects;
    private float destroyChance;
    private boolean dealtDamage;

    public DaggerEntity(EntityType<? extends DaggerEntity> entityType, World world) { super(entityType, world); }

    public DaggerEntity(World world, LivingEntity owner, ItemStack stack, float damage, float destroyChance, StatusEffectInstance... effects) {
        super(ModEntities.DAGGER, owner, world);
        this.dataTracker.set(STORED_STACK, stack.copy()); this.setDamage(damage); this.effects = effects; this.destroyChance = destroyChance;
    }

    public DaggerEntity(World world, double x, double y, double z, ItemStack stack, float damage, float destroyChance, StatusEffectInstance... effects) {
        super(ModEntities.DAGGER, x, y, z, world);
        this.dataTracker.set(STORED_STACK, stack.copy()); this.setDamage(damage); this.effects = effects; this.destroyChance = destroyChance;
    }

    @Override public boolean isCritical() { return getVelocity().length() > 5; }
    @Override public boolean isCollidable() { return inGround; }
    @Override public ActionResult interact(PlayerEntity player, Hand hand) {
        if (!this.getWorld().isClient && (this.inGround || this.isNoClip()) && this.shake <= 0 && tryPickup(player)) {
            trevorssentinelsMain.LOGGER.info("dagger pickup - success");
            player.sendPickup(this, 1);
            this.discard();
            return ActionResult.SUCCESS;
        }
		trevorssentinelsMain.LOGGER.info("dagger pickup - fail");
        return ActionResult.PASS;
    }

	@Override public void onPlayerCollision(PlayerEntity player) {}
	@Override protected float getDragInWater() { return 0.7333f; }
    @Override protected SoundEvent getHitSound() { return SoundEvents.ITEM_TRIDENT_HIT_GROUND; }
    //@Override public boolean shouldRender(double cameraX, double cameraY, double cameraZ) { return true; }

    @Nullable protected EntityHitResult getEntityCollision(Vec3d currentPosition, Vec3d nextPosition) {
        return this.dealtDamage ? null : super.getEntityCollision(currentPosition, nextPosition);
    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        this.dealtDamage = true;
        if (entity.damage(getDamageSources().mobProjectile(this, getOwner() instanceof LivingEntity livingEntity? livingEntity : null), (float) getDamage())) {
            if (entity.getType() == EntityType.ENDERMAN) return;
            if (entity instanceof LivingEntity livingEntity){
                this.onHit(livingEntity);
                for(StatusEffectInstance effect : effects) livingEntity.addStatusEffect(new StatusEffectInstance(effect.getEffectType(), effect.getDuration(),
                        effect.getAmplifier(), effect.isAmbient(), effect.shouldShowParticles(), effect.shouldShowIcon()));
            }
        }
        this.setVelocity(this.getVelocity().multiply(-0.01, -0.1, -0.01));
        this.playSound(SoundEvents.ITEM_TRIDENT_HIT, 1.0f, 1.0F);
    }

    @Override protected void onCollision(HitResult hitResult) {
        if((hitResult.getType() == HitResult.Type.ENTITY || hitResult.getType() == HitResult.Type.BLOCK) && (random.nextFloat() % 1f) < destroyChance) {
            if(getWorld() instanceof ServerWorld serverWorld) {
                ParticleEffect particleEffect = new ItemStackParticleEffect(ParticleTypes.ITEM, this.asItemStack());
                serverWorld.spawnParticles(particleEffect, getX(), getY(), getZ(), 8, 0, 0, 0, 0.1);
                serverWorld.playSound(null, getX(), getY(), getZ(), SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.PLAYERS, 1, 1);
                this.discard();
            }
        } super.onCollision(hitResult);
    }

    protected void initDataTracker() { super.initDataTracker(); this.dataTracker.startTracking(STORED_STACK, TechItems.SCRAP_METAL_KNIFE.getDefaultStack()); }
    @Override public ItemStack asItemStack() { return dataTracker.get(STORED_STACK); }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        ItemStack itemStack = this.asItemStack();
        if (!itemStack.isEmpty()) { nbt.put("StoredStack", itemStack.writeNbt(new NbtCompound())); }
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        ItemStack itemStack = ItemStack.fromNbt(nbt.getCompound("StoredStack"));
		if (!itemStack.isOf(this.asItemStack().getItem()) || itemStack.hasNbt()) { this.getDataTracker().set(STORED_STACK, itemStack.copy()); }
	}
}
