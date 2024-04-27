package net.trevorskullcrafter.trevorssentinels.util;

import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.sign.SignType;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.command.WorldLevelCommand;
import net.trevorskullcrafter.trevorssentinels.item.ModItems;
import net.trevorskullcrafter.trevorssentinels.item.TSItems;
import org.quiltmc.qsl.command.api.CommandRegistrationCallback;
import org.quiltmc.qsl.networking.api.ServerPlayConnectionEvents;

import java.util.Objects;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain.*;

public class ModRegistries {
    public static final Identifier pale = new Identifier(MOD_ID, "pale");
    public static final Identifier charred = new Identifier(MOD_ID, "charred");
    public static final Identifier midas = new Identifier(MOD_ID, "midas");
    public static final Identifier viridian = new Identifier(MOD_ID, "viridian");
    public static final Identifier cerulii = new Identifier(MOD_ID, "cerulii");

    public static final BlockSetType PALE_WOOD = BlockSetTypeBuilder.copyOf(BlockSetType.CRIMSON).build(pale);
    public static final BlockSetType CHARRED_WOOD = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).build(charred);
    public static final BlockSetType MIDAS_WOOD = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).build(midas);
    public static final BlockSetType VIRIDIAN_WOOD = BlockSetTypeBuilder.copyOf(BlockSetType.CHERRY).build(viridian);
    public static final BlockSetType CERULII_WOOD = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).build(cerulii);

    public static final SignType PALE_SIGN_TYPE = WoodTypeBuilder.copyOf(SignType.CRIMSON).build(pale, PALE_WOOD);
    public static final SignType CHARRED_SIGN_TYPE = WoodTypeBuilder.copyOf(SignType.OAK).build(charred, CHARRED_WOOD);
    public static final SignType MIDAS_SIGN_TYPE = WoodTypeBuilder.copyOf(SignType.OAK).build(midas, MIDAS_WOOD);
    public static final SignType VIRIDIAN_SIGN_TYPE = WoodTypeBuilder.copyOf(SignType.CHERRY).build(viridian, VIRIDIAN_WOOD);
    public static final SignType CERULII_SIGN_TYPE = WoodTypeBuilder.copyOf(SignType.OAK).build(cerulii, CERULII_WOOD);

    public static final DefaultParticleType FLESH_PUS = FabricParticleTypes.simple();
    public static final DefaultParticleType MUZZLE_FLASH = FabricParticleTypes.simple();

    public static void registerModelPredicates() {
        LOGGER.info("Registering model predicates... ("+ MOD_ID + ")");
        ModelPredicateProviderRegistry.register(TSItems.Beta.PAPPYM_BLADE, new Identifier(MOD_ID, "bad"), (stack, world, entity, seed) -> {
            if (StyleUtil.getStyle(stack) == 1 || StyleUtil.getStyle(stack) == 3) return 0.2f; return 0f;}
		);
        ModelPredicateProviderRegistry.register(TSItems.Tech.LIFEFORM_TRACER, new Identifier(MOD_ID, "model"), (stack, world, entity, seed) -> {
            if(stack.getSubNbt("trevorssentinels:model") == null) return 0.0f;
            else{
                switch (Objects.requireNonNull(stack.getSubNbt("trevorssentinels:model")).getInt("trevorssentinels:modelNum")){
                    case 1 -> { return 0.5f; }
                    case 2 -> { return 0.7f; }
                    case 3 -> { return 1.0f; }
                    default -> { return 0.0f; }}
            }
        });
    }

    public static void registerFlammableBlocks(){
        LOGGER.info("Committing arson... ("+ MOD_ID + ")");
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModBlocks.PALE_LOG, 5, 5);
        registry.add(ModBlocks.PALE_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_PALE_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_PALE_WOOD, 5, 5);
        registry.add(ModBlocks.PALE_PLANKS, 5, 20);
        registry.add(ModBlocks.PALE_LEAVES, 30, 60);


        registry.add(ModBlocks.CHARRED_LOG, 2, 2);
        registry.add(ModBlocks.CHARRED_WOOD, 2, 2);
        registry.add(ModBlocks.STRIPPED_CHARRED_LOG, 2, 2);
        registry.add(ModBlocks.STRIPPED_CHARRED_WOOD, 2, 2);
        registry.add(ModBlocks.CHARRED_PLANKS, 2, 8);


        registry.add(ModBlocks.MIDAS_LOG, 3, 3);
        registry.add(ModBlocks.MIDAS_WOOD, 3, 3);
        registry.add(ModBlocks.STRIPPED_MIDAS_LOG, 3, 3);
        registry.add(ModBlocks.STRIPPED_MIDAS_WOOD, 3, 3);
        registry.add(ModBlocks.MIDAS_PLANKS, 3, 12);
        registry.add(ModBlocks.MIDAS_LEAVES, 18, 40);


        registry.add(ModBlocks.VIRIDIAN_LOG, 5, 5);
        registry.add(ModBlocks.VIRIDIAN_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_VIRIDIAN_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_VIRIDIAN_WOOD, 5, 5);
        registry.add(ModBlocks.VIRIDIAN_PLANKS, 5, 20);
        registry.add(ModBlocks.VIRIDIAN_LEAVES, 30, 60);


        registry.add(ModBlocks.CERULII_LOG, 5, 5);
        registry.add(ModBlocks.CERULII_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_CERULII_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_CERULII_WOOD, 5, 5);
        registry.add(ModBlocks.CERULII_PLANKS, 5, 20);
        registry.add(ModBlocks.CERULII_LEAVES, 30, 60);
    }

    public static void registerStrippables(){
        LOGGER.info("Stripping logs... ("+ MOD_ID + ")");
        StrippableBlockRegistry.register(ModBlocks.PALE_LOG, ModBlocks.STRIPPED_PALE_LOG);
        StrippableBlockRegistry.register(ModBlocks.PALE_WOOD, ModBlocks.STRIPPED_PALE_WOOD);

        StrippableBlockRegistry.register(ModBlocks.CHARRED_LOG, ModBlocks.STRIPPED_CHARRED_LOG);
        StrippableBlockRegistry.register(ModBlocks.CHARRED_WOOD, ModBlocks.STRIPPED_CHARRED_WOOD);

        StrippableBlockRegistry.register(ModBlocks.MIDAS_LOG, ModBlocks.STRIPPED_MIDAS_LOG);
        StrippableBlockRegistry.register(ModBlocks.MIDAS_WOOD, ModBlocks.STRIPPED_MIDAS_WOOD);

        StrippableBlockRegistry.register(ModBlocks.VIRIDIAN_LOG, ModBlocks.STRIPPED_VIRIDIAN_LOG);
        StrippableBlockRegistry.register(ModBlocks.VIRIDIAN_WOOD, ModBlocks.STRIPPED_VIRIDIAN_WOOD);

        StrippableBlockRegistry.register(ModBlocks.CERULII_LOG, ModBlocks.STRIPPED_CERULII_LOG);
        StrippableBlockRegistry.register(ModBlocks.CERULII_WOOD, ModBlocks.STRIPPED_CERULII_WOOD);
    }

    public static void registerFuels(){
        LOGGER.info("Registering fuels... ("+ MOD_ID + ")");
        FuelRegistry.INSTANCE.add(ModItems.FEATHERCORN, 200);
    }

    public static void registerWorldLevelState(){
		ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register((world, entity, killedEntity) -> {
            ServerState serverState = ServerState.getServerState(Objects.requireNonNull(entity.getServer(), "Server is null"));
            int originalLevel = serverState.worldLevel;

            if(entity instanceof WitherEntity witherEntity){
                world.createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 8f, false, World.ExplosionSourceType.MOB);
                WitherSkeletonEntity leftovers = new WitherSkeletonEntity(EntityType.WITHER_SKELETON, world);
                leftovers.setPosition(witherEntity.getPos());
                leftovers.setCustomName(TextUtil.coloredText("Cerberus, Darkness Incarnate", TextUtil.DARK_PURPLE));
                witherEntity.getWorld().spawnEntity(leftovers);
                for (PlayerEntity player:world.getPlayers()) {
                    player.sendMessage(Text.literal(witherEntity.getName().getString() + " grows restless!").formatted(Formatting.RED), false);
                }
                if(serverState.worldLevel < 2) {
                    serverState.worldLevel = 2;
                    serverState.markDirty();
                }
            }

            if(serverState.worldLevel != originalLevel){ for (PlayerEntity player:world.getPlayers()) {
                player.sendMessage(Text.empty().append(Text.literal((serverState.worldLevel > originalLevel)? "World level upgraded to " : "World level reverted to "))
                        .append(Text.literal(String.valueOf(serverState.worldLevel)).formatted(Formatting.GOLD)).append(Text.literal(" from "))
                        .append(Text.literal(String.valueOf(originalLevel)).formatted(Formatting.RED)).append(Text.literal("!")), false);
            }}
        });

        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            server.getCommandManager();
            handler.player.sendMessage(Text.literal("Welcome back, " + handler.player.getName()+"!").formatted(Formatting.GREEN), false);
            //handler.player.sendMessage(Text.translatable(new Identifier(MOD_ID, "join.");
        });
    }

    public static void registerCommands(){ CommandRegistrationCallback.EVENT.register(WorldLevelCommand::register); }

    public static void registerParticles(){
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "flesh_pus"), FLESH_PUS);
    }
}
