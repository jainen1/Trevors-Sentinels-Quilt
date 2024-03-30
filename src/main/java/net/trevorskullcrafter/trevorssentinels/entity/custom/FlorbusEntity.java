package net.trevorskullcrafter.trevorssentinels.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.FollowMobGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.entity.ModEntities;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class FlorbusEntity extends AnimalEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final RawAnimation BLINK = RawAnimation.begin().thenPlay("blink");

    public FlorbusEntity(EntityType<? extends AnimalEntity> entityType, World world) { super(entityType, world); }

    @Nullable @Override public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.FLORBUS.create(world);
    }

    public static DefaultAttributeContainer.Builder setAttributes(){
        return PassiveEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.8f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 1f);
    }

    @Override protected void initGoals(){
        this.goalSelector.add(1, new EscapeDangerGoal(this, 0.5f));
        this.goalSelector.add(2, new FollowMobGoal(this, 0.2f, 3.0f,7.0f));
        this.goalSelector.add(3, new FollowMobGoal(this, 0.2f, 3.0f,7.0f));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 0.2f, 1));
        this.goalSelector.add(5, new LookAroundGoal(this));

        this.targetSelector.add(2, new ActiveTargetGoal<>(this, FlorbusEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override protected SoundEvent getAmbientSound(){ return SoundEvents.ENTITY_STRIDER_AMBIENT; }
    @Override protected SoundEvent getHurtSound(DamageSource source){ return SoundEvents.ENTITY_STRIDER_HURT; }
    @Override protected SoundEvent getDeathSound(){ return SoundEvents.ENTITY_STRIDER_DEATH; }
    @Override protected void playStepSound(BlockPos pos, BlockState state){ this.playSound(SoundEvents.ENTITY_STRIDER_STEP, 0.25f, 0.0f); }

    @Override public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        //controllerRegistrar.add(new AnimationController<>(this, 5, state -> state.setAndContinue(WALK)));
        controllerRegistrar.add(DefaultAnimations.genericWalkController(this));
    }

    @Override public AnimatableInstanceCache getAnimatableInstanceCache() { return this.cache; }
}
