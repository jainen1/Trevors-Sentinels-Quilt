package net.trevorskullcrafter.trevorssentinels.entity.damage;

import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain;

public class ModDamageSources {
    public static RegistryKey<DamageType> INFESTED = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(trevorssentinelsMain.MOD_ID, "infested"));
    public static RegistryKey<DamageType> IRRADIATED = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(trevorssentinelsMain.MOD_ID, "irradiated"));
    public static RegistryKey<DamageType> REDSTONED = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(trevorssentinelsMain.MOD_ID, "redstoned"));
    public static RegistryKey<DamageType> SHARD_PROJECTILE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(trevorssentinelsMain.MOD_ID, "shard_projectile"));
    public static RegistryKey<DamageType> PHASER_PROJECTILE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(trevorssentinelsMain.MOD_ID, "phaser_projectile"));
    public static RegistryKey<DamageType> DAGGER_PROJECTILE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(trevorssentinelsMain.MOD_ID, "dagger_projectile"));
}
