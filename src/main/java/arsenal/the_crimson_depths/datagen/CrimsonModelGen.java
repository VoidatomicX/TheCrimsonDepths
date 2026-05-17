package arsenal.the_crimson_depths.datagen;

import arsenal.the_crimson_depths.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.item.ArmorItem;

public class CrimsonModelGen extends FabricModelProvider {

    public CrimsonModelGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {


    itemModelGenerator.registerArmor(((ArmorItem) ModItems.Resonite_Helmet));
    itemModelGenerator.registerArmor(((ArmorItem) ModItems.Resonite_Chestplate));
    itemModelGenerator.registerArmor(((ArmorItem) ModItems.Resonite_Leggings));
    itemModelGenerator.registerArmor(((ArmorItem) ModItems.Resonite_Boots));
    }
}
