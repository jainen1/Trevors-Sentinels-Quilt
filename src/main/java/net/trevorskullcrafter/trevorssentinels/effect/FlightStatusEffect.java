package net.trevorskullcrafter.trevorssentinels.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.player.PlayerEntity;

public class FlightStatusEffect extends StatusEffect {
    public FlightStatusEffect(StatusEffectType type, int color) { super(type, color); }

	@Override public boolean shouldApplyUpdateEffect(int tick, int amplifier) { return true; }

	@Override public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        float fallVelocity = (float) Math.abs(entity.getVelocity().y * 5);
        if (entity instanceof PlayerEntity playerEntity) {
            if(playerEntity.isSprinting()){
                if(entity.getVelocity().y < 0.6) entity.addVelocity(0, 0.15, 0);
                else entity.setVelocity(entity.getVelocity().x, 0.6, entity.getVelocity().z); entity.fallDistance = fallVelocity;
            }else if(playerEntity.isSneaking()) { entity.setVelocity(entity.getVelocity().x, 0, entity.getVelocity().z); entity.fallDistance = 0.0f; }
            entity.getMovementDirection();
        } super.applyUpdateEffect(entity, amplifier);
    }
}
