package arsenal.the_crimson_depths.client;

import arsenal.the_crimson_depths.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

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
}
