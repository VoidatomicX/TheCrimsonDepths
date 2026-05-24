package arsenal.the_crimson_depths.client;

import arsenal.the_crimson_depths.datagen.*;
import arsenal.the_crimson_depths.enchantment.ModEnchantments;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class The_crimson_depthsDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(CrimsonModelGen::new);
        pack.addProvider(CrimsonLootTableGen::new);
        pack.addProvider(CrimsonRecipeGen::new);
        pack.addProvider(CrimsonBlockTagGen::new);
        pack.addProvider(CrimsonItemTagGen::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.ENCHANTMENT, ModEnchantments::bootstrap);
    }
}
