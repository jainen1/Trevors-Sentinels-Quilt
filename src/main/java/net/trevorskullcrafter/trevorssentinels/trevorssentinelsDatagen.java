package net.trevorskullcrafter.trevorssentinels;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistrySetBuilder;
import net.trevorskullcrafter.trevorssentinels.datagen.*;
import net.trevorskullcrafter.trevorssentinels.datagen.lang.EN_US_Generator;
import net.trevorskullcrafter.trevorssentinels.world.feature.ModConfiguredFeatures;

public class trevorssentinelsDatagen implements DataGeneratorEntrypoint {
    @Override public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModLootTableGenerator::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModRecipeGenerator::new);
        pack.addProvider(ModWorldGenerator::new);
        pack.addProvider(AdvancementGenerator::new);
        pack.addProvider(ItemTagGenerator::new);
        pack.addProvider(BlockTagGenerator::new);

        pack.addProvider(EN_US_Generator::new);
    }

    @Override public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
    }
}
