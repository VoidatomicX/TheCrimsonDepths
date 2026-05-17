package arsenal.the_crimson_depths.datagen;

import arsenal.the_crimson_depths.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class CrimsonBlockTagGen extends FabricTagProvider.BlockTagProvider {
    public CrimsonBlockTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.Infested_Redstone_Block)
                .add(ModBlocks.Resonite_block);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.Infested_Redstone_Block)
                .add(ModBlocks.Resonite_block);

        /*getOrCreateTagBuilder(ModTags.Blocks.NEEDS_RESONITE_TOOL)
                .add(ModBlocks.Infested_Redstone_Block)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);*/

    }
}
