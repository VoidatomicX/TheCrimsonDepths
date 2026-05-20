package arsenal.the_crimson_depths.datagen;

import arsenal.the_crimson_depths.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class CrimsonItemTagGen extends FabricTagProvider.ItemTagProvider {
    public CrimsonItemTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.Netherite_Anchor)
                .add(ModItems.Diamond_Anchor)
                .add(ModItems.Resonite_Anchor)
                .add(ModItems.Gold_Anchor)
                .add(ModItems.Iron_Anchor)
                .add(ModItems.Stone_Anchor);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.Netherite_Scythe)
                .add(ModItems.Diamond_Scythe)
                .add(ModItems.Resonite_Scythe)
                .add(ModItems.Gold_Scythe)
                .add(ModItems.Iron_Scythe)
                .add(ModItems.Stone_Scythe);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.Netherite_Lance)
                .add(ModItems.Diamond_Lance)
                .add(ModItems.Resonite_Lance)
                .add(ModItems.Gold_Lance)
                .add(ModItems.Iron_Lance)
                .add(ModItems.Stone_Lance);

        getOrCreateTagBuilder(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .add(ModItems.Netherite_Lance)
                .add(ModItems.Diamond_Lance)
                .add(ModItems.Resonite_Lance)
                .add(ModItems.Gold_Lance)
                .add(ModItems.Iron_Lance)
                .add(ModItems.Stone_Lance)
                .add(ModItems.Netherite_Scythe)
                .add(ModItems.Diamond_Scythe)
                .add(ModItems.Resonite_Scythe)
                .add(ModItems.Gold_Scythe)
                .add(ModItems.Iron_Scythe)
                .add(ModItems.Stone_Scythe);

        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE)
                .add(ModItems.Netherite_Lance)
                .add(ModItems.Diamond_Lance)
                .add(ModItems.Resonite_Lance)
                .add(ModItems.Gold_Lance)
                .add(ModItems.Iron_Lance)
                .add(ModItems.Stone_Lance)
                .add(ModItems.Netherite_Scythe)
                .add(ModItems.Diamond_Scythe)
                .add(ModItems.Resonite_Scythe)
                .add(ModItems.Gold_Scythe)
                .add(ModItems.Iron_Scythe)
                .add(ModItems.Stone_Scythe);

        getOrCreateTagBuilder(ItemTags.FIRE_ASPECT_ENCHANTABLE)
                .add(ModItems.Netherite_Lance)
                .add(ModItems.Diamond_Lance)
                .add(ModItems.Resonite_Lance)
                .add(ModItems.Gold_Lance)
                .add(ModItems.Iron_Lance)
                .add(ModItems.Stone_Lance)
                .add(ModItems.Netherite_Scythe)
                .add(ModItems.Diamond_Scythe)
                .add(ModItems.Resonite_Scythe)
                .add(ModItems.Gold_Scythe)
                .add(ModItems.Iron_Scythe)
                .add(ModItems.Stone_Scythe)
                .add(ModItems.Netherite_Anchor)
                .add(ModItems.Diamond_Anchor)
                .add(ModItems.Resonite_Anchor)
                .add(ModItems.Gold_Anchor)
                .add(ModItems.Iron_Anchor)
                .add(ModItems.Stone_Anchor);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.Resonite_Helmet)
                .add(ModItems.Resonite_Chestplate)
                .add(ModItems.Resonite_Leggings)
                .add(ModItems.Resonite_Boots);

        getOrCreateTagBuilder(ItemTags.TRIDENT_ENCHANTABLE)
                .add(ModItems.Netherite_Anchor)
                .add(ModItems.Diamond_Anchor)
                .add(ModItems.Resonite_Anchor)
                .add(ModItems.Gold_Anchor)
                .add(ModItems.Iron_Anchor)
                .add(ModItems.Stone_Anchor);

    }
}
