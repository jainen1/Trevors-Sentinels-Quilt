package net.trevorskullcrafter.trevorssentinels.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain.MOD_ID;

public class ModEffects {
    public static StatusEffect REDSTONED;
    public static StatusEffect FLIGHT;
    public static StatusEffect COSMIC_FIRE;
    public static StatusEffect WELL_FED;
    public static StatusEffect INFESTED;
    public static StatusEffect IRRADIATED;

    public static StatusEffect registerStatusEffect(String name, StatusEffect effect){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(MOD_ID, name), effect);
    }

    public static void registerStatusEffects(){
        REDSTONED = registerStatusEffect("redstoned", new RedstonedStatusEffect(StatusEffectType.NEUTRAL, 0xd90012));
        FLIGHT = registerStatusEffect("flight", new FlightStatusEffect(StatusEffectType.BENEFICIAL, 0x5c7bc1));
        COSMIC_FIRE = registerStatusEffect("cosmic_fire", new FireStatusEffect(StatusEffectType.HARMFUL, 0xD31400));
        WELL_FED = registerStatusEffect("well_fed", new WellFedEffect(StatusEffectType.BENEFICIAL, 0x967117));
        INFESTED = registerStatusEffect("infested", new InfestedStatusEffect(StatusEffectType.HARMFUL, 0x94AF61));
        IRRADIATED = registerStatusEffect("irradiated", new IrradiatedStatusEffect(StatusEffectType.HARMFUL, 0xDEE93B));
    }
}
