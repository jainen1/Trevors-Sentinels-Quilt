package net.trevorskullcrafter.trevorssentinels.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.effect.StatusEffects;

public class FireStatusEffect extends StatusEffect {
    public FireStatusEffect(StatusEffectType type, int color) { super(type, color); }

	@Override  public boolean shouldApplyUpdateEffect(int tick, int amplifier) { return true; }

	@Override public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(!entity.isWet()) entity.setOnFire(true);
        else{
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, amplifier));
            entity.removeStatusEffect(ModEffects.COSMIC_FIRE);
        }
    }
}
