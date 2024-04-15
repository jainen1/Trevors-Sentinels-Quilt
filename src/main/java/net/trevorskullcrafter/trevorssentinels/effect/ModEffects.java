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

	public static StatusEffect SET_BONUS_SCRAP_METAL;
	public static StatusEffect SET_BONUS_DRYADIC;
	public static StatusEffect SET_BONUS_ROSE_GOLD;
	public static StatusEffect SET_BONUS_DRUIDIC;
	public static StatusEffect SET_BONUS_STARSTEEL;
	public static StatusEffect SET_BONUS_IMPERIAL;
	public static StatusEffect SET_BONUS_UNHOLY;
	public static StatusEffect SET_BONUS_NUCLEAR;
	public static StatusEffect SET_BONUS_ARMA_DEI;
	public static StatusEffect SET_BONUS_NANOTECH;
	public static StatusEffect SET_BONUS_ZENITHIUM;

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

		SET_BONUS_SCRAP_METAL = registerStatusEffect("set_bonus_scrap_metal", new WellFedEffect(StatusEffectType.BENEFICIAL, 0x967117));
		SET_BONUS_DRYADIC = registerStatusEffect("set_bonus_dryadic", new WellFedEffect(StatusEffectType.BENEFICIAL, 0x967117));
		SET_BONUS_ROSE_GOLD = registerStatusEffect("set_bonus_rose_gold", new WellFedEffect(StatusEffectType.BENEFICIAL, 0x967117));
		SET_BONUS_DRUIDIC = registerStatusEffect("set_bonus_druidic", new WellFedEffect(StatusEffectType.BENEFICIAL, 0x967117));
		SET_BONUS_STARSTEEL = registerStatusEffect("set_bonus_starsteel", new WellFedEffect(StatusEffectType.BENEFICIAL, 0x967117));
		SET_BONUS_IMPERIAL = registerStatusEffect("set_bonus_imperial", new WellFedEffect(StatusEffectType.BENEFICIAL, 0x967117));
		SET_BONUS_UNHOLY = registerStatusEffect("set_bonus_unholy", new WellFedEffect(StatusEffectType.BENEFICIAL, 0x967117));
		SET_BONUS_NUCLEAR = registerStatusEffect("set_bonus_nuclear", new WellFedEffect(StatusEffectType.BENEFICIAL, 0x967117));
		SET_BONUS_ARMA_DEI = registerStatusEffect("set_bonus_arma_dei", new WellFedEffect(StatusEffectType.BENEFICIAL, 0x967117));
		SET_BONUS_NANOTECH = registerStatusEffect("set_bonus_nanotech", new WellFedEffect(StatusEffectType.BENEFICIAL, 0x967117));
		SET_BONUS_ZENITHIUM = registerStatusEffect("set_bonus_zenithium", new WellFedEffect(StatusEffectType.BENEFICIAL, 0x967117));
    }
}
