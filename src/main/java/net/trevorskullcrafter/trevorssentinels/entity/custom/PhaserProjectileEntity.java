package net.trevorskullcrafter.trevorssentinels.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.thrown.ThrownEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.trevorskullcrafter.trevorssentinels.datagen.BlockTagGenerator;
import net.trevorskullcrafter.trevorssentinels.entity.damage.ModDamageSources;
import net.trevorskullcrafter.trevorssentinels.util.TextUtil;

public class PhaserProjectileEntity extends ThrownEntity {
    private static final TrackedData<Integer> COLOR = DataTracker.registerData(PhaserProjectileEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> AGE = DataTracker.registerData(PhaserProjectileEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> LIFETIME = DataTracker.registerData(PhaserProjectileEntity.class, TrackedDataHandlerRegistry.INTEGER);
    public float damage;StatusEffectInstance[] effects;

    public PhaserProjectileEntity(EntityType<? extends PhaserProjectileEntity> type, World world) { super(type, world); }

    public PhaserProjectileEntity(EntityType<? extends PhaserProjectileEntity> type, double x, double y, double z, World world,
								  int lifetime, float damage, int color, StatusEffectInstance... effects) {
        this(type, world); this.setPosition(x, y, z); this.damage = damage; this.effects = effects;
		this.dataTracker.set(COLOR, color); this.dataTracker.set(LIFETIME, lifetime);
    }

    public PhaserProjectileEntity(EntityType<? extends PhaserProjectileEntity> type, World world, LivingEntity owner,
								  int lifetime, float damage, int color, StatusEffectInstance... effects) {
        this(type, owner.getX(), owner.getEyeY(), owner.getZ(), world, lifetime, damage, color, effects); setOwner(owner);
    }

    public void setVelocity(float pitch, float yaw, float roll, float speed, float divergence) {
        float x = -MathHelper.sin(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
        float y = -MathHelper.sin((pitch + roll) * 0.017453292F);
        float z = MathHelper.cos(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
        super.setVelocity(x, y, z, speed, divergence);
    }

    @Override public void tick() {
		super.tick();
		if(!getWorld().isClient()) {
			if(this.getAge() >= getLifetime() || getVelocity().length() <= 0.2f) { this.discard(); }
			else { this.setAge(this.getAge()+1); }
		}
	}

    @Override protected void onCollision(HitResult hitResult) {
        HitResult.Type type = hitResult.getType();
        if(hitResult.getType() != HitResult.Type.MISS && getWorld() instanceof ServerWorld serverWorld) {
            if (type == HitResult.Type.ENTITY && ((EntityHitResult) hitResult).getEntity() instanceof LivingEntity entity) {
                if (damage < 1) {
                    entity.heal(Math.abs(damage));
                    serverWorld.spawnParticles(ParticleTypes.HEART, getX(), getY(), getZ(), (int) damage, 0, 0, 0, 0.01);
                    serverWorld.playSound(null, getX(), getY(), getZ(), SoundEvents.BLOCK_NOTE_BLOCK_BELL.value(), SoundCategory.PLAYERS, 1, 1);
                } else {
                    entity.damage(new DamageSource(entity.getWorld().getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).getHolderOrThrow(ModDamageSources.PHASER_PROJECTILE)), damage);
                    doExplosion(serverWorld);
                }
                if (effects != null) { for (StatusEffectInstance sEI : effects) { entity.addStatusEffect(new StatusEffectInstance(sEI.getEffectType(),
                        sEI.getDuration(), sEI.getAmplifier(), sEI.isAmbient(), sEI.shouldShowParticles(), sEI.shouldShowIcon())); }}
                entity.addVelocity((getVelocity().multiply(0.1)));
                this.discard();
            } else if (type == HitResult.Type.BLOCK) {
                BlockHitResult blockHitResult = (BlockHitResult) hitResult;
                BlockState state = serverWorld.getBlockState(blockHitResult.getBlockPos());
                if(collidesWithStateAtPos(blockHitResult.getBlockPos(), state)){
                    state.onProjectileHit(serverWorld, state, blockHitResult, this);
                    doExplosion(serverWorld);
                    reflect(state, blockHitResult);
                }
            }
        }

        if (type == HitResult.Type.ENTITY) {
            this.onEntityHit((EntityHitResult)hitResult);
            this.getWorld().emitGameEvent(GameEvent.PROJECTILE_LAND, hitResult.getPos(), new GameEvent.Context(this, null));
        } else if (type == HitResult.Type.BLOCK) {
            BlockHitResult blockHitResult = (BlockHitResult)hitResult;
            this.onBlockHit(blockHitResult);
            BlockPos blockPos = blockHitResult.getBlockPos();
            this.getWorld().emitGameEvent(GameEvent.PROJECTILE_LAND, blockPos, new GameEvent.Context(this, this.getWorld().getBlockState(blockPos)));
        }
    }

    public void reflect(BlockState state, BlockHitResult blockHitResult){
        if(state.isIn(BlockTagGenerator.LASER_REFLECTIVE)){
            Direction sideHit = blockHitResult.getSide();
            setVelocity(this.getVelocity().x * ((sideHit == Direction.EAST || sideHit == Direction.WEST)? -1: 0),
                    (this.getVelocity().y * ((sideHit == Direction.UP || sideHit == Direction.DOWN)? -1: 0)),
                    (this.getVelocity().z * ((sideHit == Direction.NORTH || sideHit == Direction.SOUTH)? -1: 0)), (float) getVelocity().length()-0.2f, 0);
        } else { this.discard(); }
    }

    public void doExplosion(ServerWorld serverWorld){
        serverWorld.spawnParticles(ParticleTypes.SMOKE, getX(), getY(), getZ(), (int) damage, 0, 0, 0, 0.05);
        serverWorld.spawnParticles(ParticleTypes.FLAME, getX(), getY(), getZ(), (int) damage / 2, 0, 0, 0, 0.02);
        serverWorld.playSound(null, getX(), getY(), getZ(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1, 1);
    }

    @Override protected float getGravity() { return 0.0F; }
    @Override protected void initDataTracker() { this.dataTracker.startTracking(COLOR, TextUtil.BLOOD_RED.getRGB());
		this.dataTracker.startTracking(LIFETIME, 20); this.dataTracker.startTracking(AGE, 0); }
    @Override public boolean collidesWithStateAtPos(BlockPos pos, BlockState state) { return !state.isIn(BlockTagGenerator.LASER_PROJECTILE_PASS); }
    public void setColor(Integer color) { this.getDataTracker().set(COLOR, color); }
    public Integer getColor() { return this.getDataTracker().get(COLOR); }
	public void setAge(Integer age) { this.getDataTracker().set(AGE, age); }
	public Integer getAge() { return this.getDataTracker().get(AGE); }
	public void setLifetime(Integer age) { this.getDataTracker().set(LIFETIME, age); }
	public Integer getLifetime() { return this.getDataTracker().get(LIFETIME); }

	@Override protected void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Color", getColor());
        nbt.putInt("Age", getAge());
        nbt.putInt("Lifetime", getLifetime());
    }

    @Override protected void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setColor(nbt.getInt("Color"));
        this.setAge(nbt.getInt("Age"));
        this.setLifetime(nbt.getInt("Lifetime"));
    }
}
