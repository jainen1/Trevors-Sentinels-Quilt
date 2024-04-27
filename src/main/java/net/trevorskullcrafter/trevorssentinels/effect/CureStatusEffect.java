package net.trevorskullcrafter.trevorssentinels.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import org.quiltmc.qsl.entity.effect.api.StatusEffectRemovalReason;

import java.util.Objects;

public class CureStatusEffect extends StatusEffect {
	StatusEffect cures;
    public CureStatusEffect(StatusEffectType type, int color, StatusEffect cures) { super(type, color); this.cures = cures; }

	@Override public boolean shouldApplyUpdateEffect(int tick, int amplifier) { return tick % 10 == 0; }

	@Override public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		StatusEffectInstance wither = entity.getStatusEffect(cures);
		if(wither != null){
			int thisDuration = Objects.requireNonNull(entity.getStatusEffect(this)).getDuration();
			int witherDuration = wither.getDuration();

			int result = amplifier - wither.getAmplifier();
			int result2 = thisDuration - witherDuration;
			entity.removeStatusEffect(cures, StatusEffectRemovalReason.DRANK_MILK);
			entity.removeStatusEffect(this, StatusEffectRemovalReason.DRANK_MILK);

			if(result > 0){ entity.addStatusEffect(new StatusEffectInstance(this, result2, Math.abs(result)-1)); }
			else if(result < 0) { entity.addStatusEffect(new StatusEffectInstance(cures, -result2, Math.abs(-result)-1)); }
			else if(result2 > 0){ entity.addStatusEffect(new StatusEffectInstance(this, result2, 0)); }
			else if(result2 < 0){ entity.addStatusEffect(new StatusEffectInstance(cures, -result2, 0)); }
		}
    }
}
