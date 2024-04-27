package net.trevorskullcrafter.trevorssentinels.entity;

import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.entity.custom.*;
import net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain;
import org.quiltmc.qsl.entity.extensions.api.QuiltEntityTypeBuilder;

public class ModEntities {
    public static final EntityType<SentinelEntity> SENTINEL = Registry.register(
		Registries.ENTITY_TYPE, new Identifier(trevorssentinelsMain.MOD_ID, "sentinel"),
		QuiltEntityTypeBuilder.create(SpawnGroup.MONSTER, SentinelEntity::new)
			.setDimensions(EntityDimensions.fixed(0.7f, 0.6f)).build());
    public static final EntityType<RoombaEntity> JANITOR_DROID = Registry.register(
		Registries.ENTITY_TYPE, new Identifier(trevorssentinelsMain.MOD_ID, "sentinum_roomba"),
		QuiltEntityTypeBuilder.create(SpawnGroup.CREATURE, RoombaEntity::new)
			.setDimensions(EntityDimensions.fixed(0.75f, 0.2f)).build());
    public static final EntityType<FlorbusEntity> FLORBUS = Registry.register(
		Registries.ENTITY_TYPE, new Identifier(trevorssentinelsMain.MOD_ID, "florbus"),
		QuiltEntityTypeBuilder.create(SpawnGroup.CREATURE, FlorbusEntity::new)
			.setDimensions(EntityDimensions.fixed(0.8f, 1.25f)).build());

    public static final EntityType<ShardEntity> SHARD_PROJECTILE = Registry.register(
		Registries.ENTITY_TYPE, new Identifier(trevorssentinelsMain.MOD_ID, "shard_projectile"),
		QuiltEntityTypeBuilder.<ShardEntity>create(SpawnGroup.MISC, ShardEntity::new)
			.setDimensions(EntityDimensions.fixed(0.25F, 0.25F)).maxBlockTrackingRange(32).trackingTickInterval(10).build());
    public static final EntityType<DaggerEntity> DAGGER_PROJECTILE = Registry.register(
		Registries.ENTITY_TYPE, new Identifier(trevorssentinelsMain.MOD_ID, "dagger_projectile"),
		QuiltEntityTypeBuilder.<DaggerEntity>create(SpawnGroup.MISC, DaggerEntity::new)
			.setDimensions(EntityDimensions.fixed(0.35F, 0.15F)).maxBlockTrackingRange(32).trackingTickInterval(10).build());
    public static final EntityType<PhaserProjectileEntity> PHASER_PROJECTILE = Registry.register(
		Registries.ENTITY_TYPE, new Identifier(trevorssentinelsMain.MOD_ID, "phaser_projectile"),
		QuiltEntityTypeBuilder.<PhaserProjectileEntity>create(SpawnGroup.MISC, PhaserProjectileEntity::new)
			.setDimensions(EntityDimensions.fixed(0.25F, 0.25F)).makeFireImmune().maxBlockTrackingRange(32).trackingTickInterval(10).build());

	public static final EntityType<GrenadeEntity> DELAYED_EXPLOSIVE = Registry.register(
		Registries.ENTITY_TYPE, new Identifier(trevorssentinelsMain.MOD_ID, "grenade"),
		QuiltEntityTypeBuilder.<GrenadeEntity>create(SpawnGroup.MISC, GrenadeEntity::new)
			.setDimensions(EntityDimensions.fixed(0.25F, 0.25F)).maxBlockTrackingRange(32).trackingTickInterval(10).build());

	public static void registerModEntities(){ trevorssentinelsMain.LOGGER.info("Registering entities..."); }
}
