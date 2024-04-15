package net.trevorskullcrafter.trevorssentinels.block.entity;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.trevorskullcrafter.trevorssentinels.block.ModBlocks;
import net.trevorskullcrafter.trevorssentinels.trevorssentinelsMain;
import org.quiltmc.qsl.block.entity.api.QuiltBlockEntityTypeBuilder;

public class ModBlockEntities {
    public static BlockEntityType<VendorBlockEntity> VENDOR;
    public static BlockEntityType<ReconstructionTableBlockEntity> RECONSTRUCTION_TABLE;
    public static BlockEntityType<ModificationTableBlockEntity> MODIFICATION_TABLE;
    public static BlockEntityType<HardLightBlockEntity> HARD_LIGHT;

    public static void registerBlockEntities(){
        trevorssentinelsMain.LOGGER.info("Registering block entities... (" + trevorssentinelsMain.MOD_ID + ")");
        VENDOR = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(trevorssentinelsMain.MOD_ID, "vendor"),
			QuiltBlockEntityTypeBuilder.create(VendorBlockEntity::new, ModBlocks.VENDOR).build(null));

        RECONSTRUCTION_TABLE = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(trevorssentinelsMain.MOD_ID, "superforge"),
			QuiltBlockEntityTypeBuilder.create(ReconstructionTableBlockEntity::new, ModBlocks.RECONSTRUCTION_TABLE).build(null));

        MODIFICATION_TABLE = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(trevorssentinelsMain.MOD_ID, "modification_table"),
			QuiltBlockEntityTypeBuilder.create(ModificationTableBlockEntity::new, ModBlocks.MODIFICATION_TABLE).build(null));

        HARD_LIGHT = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(trevorssentinelsMain.MOD_ID, "hard_light"),
			QuiltBlockEntityTypeBuilder.create(HardLightBlockEntity::new, ModBlocks.HARD_LIGHT, ModBlocks.CAUTION_HARD_LIGHT, ModBlocks.SENTINEL_HARD_LIGHT).build(null));
    }
}
