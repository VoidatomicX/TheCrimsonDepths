package arsenal.the_crimson_depths.datagen;

import arsenal.the_crimson_depths.blocks.ModBlocks;
import arsenal.the_crimson_depths.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CrimsonRecipeGen extends FabricRecipeProvider {
    public CrimsonRecipeGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> Resonite_Smeltables = List.of(ModItems.Raw_Resonite, ModBlocks.Infested_Redstone_Block);

        offerSmelting(recipeExporter, Resonite_Smeltables, RecipeCategory.MISC, ModItems.Resonite_Ingot, 0.25f,208,"resonite_ingot");
        offerBlasting(recipeExporter, Resonite_Smeltables, RecipeCategory.MISC, ModItems.Resonite_Ingot, 0.25f,104,"resonite_ingot");

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.Diamond_Anchor, 1)
                .pattern("RRR")
                .pattern(" BR")
                .pattern("S R")
                .input('S', Items.STICK)
                .input('R', Items.DIAMOND)
                .input('B', Blocks.DIAMOND_BLOCK)
                .criterion(hasItem(ModItems.Diamond_Anchor), conditionsFromItem(ModItems.Diamond_Anchor))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.Gold_Anchor, 1)
                .pattern("RRR")
                .pattern(" BR")
                .pattern("S R")
                .input('S', Items.STICK)
                .input('R', Items.GOLD_INGOT)
                .input('B', Blocks.GOLD_BLOCK)
                .criterion(hasItem(ModItems.Gold_Anchor), conditionsFromItem(ModItems.Gold_Anchor))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.Iron_Anchor, 1)
                .pattern("RRR")
                .pattern(" BR")
                .pattern("S R")
                .input('S', Items.STICK)
                .input('R', Items.IRON_INGOT)
                .input('B', Blocks.IRON_BLOCK)
                .criterion(hasItem(ModItems.Iron_Anchor), conditionsFromItem(ModItems.Iron_Anchor))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.Stone_Anchor, 1)
                .pattern("RRR")
                .pattern(" BR")
                .pattern("S R")
                .input('S', Items.STICK)
                .input('R', Items.COBBLESTONE)
                .input('B', Blocks.SMOOTH_STONE)
                .criterion(hasItem(ModItems.Stone_Anchor), conditionsFromItem(ModItems.Stone_Anchor))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.Diamond_Scythe, 1)
                .pattern("RRR")
                .pattern(" S ")
                .pattern("S  ")
                .input('S', Items.STICK)
                .input('R', Items.DIAMOND)
                .criterion(hasItem(ModItems.Diamond_Scythe), conditionsFromItem(ModItems.Diamond_Scythe))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.Gold_Scythe, 1)
                .pattern("RRR")
                .pattern(" S ")
                .pattern("S  ")
                .input('S', Items.STICK)
                .input('R', Items.GOLD_INGOT)
                .criterion(hasItem(ModItems.Gold_Scythe), conditionsFromItem(ModItems.Gold_Scythe))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.Iron_Scythe, 1)
                .pattern("RRR")
                .pattern(" S ")
                .pattern("S  ")
                .input('S', Items.STICK)
                .input('R', Items.IRON_INGOT)
                .criterion(hasItem(ModItems.Iron_Scythe), conditionsFromItem(ModItems.Iron_Scythe))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.Stone_Scythe, 1)
                .pattern("RRR")
                .pattern(" S ")
                .pattern("S  ")
                .input('S', Items.STICK)
                .input('R', Items.COBBLESTONE)
                .criterion(hasItem(ModItems.Stone_Scythe), conditionsFromItem(ModItems.Stone_Scythe))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.Diamond_Lance, 1)
                .pattern(" RR")
                .pattern(" SR")
                .pattern("S  ")
                .input('S', Items.STICK)
                .input('R', Items.DIAMOND)
                .criterion(hasItem(ModItems.Diamond_Lance), conditionsFromItem(ModItems.Diamond_Lance))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.Gold_Lance, 1)
                .pattern(" RR")
                .pattern(" SR")
                .pattern("S  ")
                .input('S', Items.STICK)
                .input('R', Items.GOLD_INGOT)
                .criterion(hasItem(ModItems.Gold_Lance), conditionsFromItem(ModItems.Gold_Lance))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.Iron_Lance, 1)
                .pattern(" RR")
                .pattern(" SR")
                .pattern("S  ")
                .input('S', Items.STICK)
                .input('R', Items.IRON_INGOT)
                .criterion(hasItem(ModItems.Iron_Lance), conditionsFromItem(ModItems.Iron_Lance))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.Stone_Lance, 1)
                .pattern(" RR")
                .pattern(" SR")
                .pattern("S  ")
                .input('S', Items.STICK)
                .input('R', Items.COBBLESTONE)
                .criterion(hasItem(ModItems.Stone_Lance), conditionsFromItem(ModItems.Stone_Lance))
                .offerTo(recipeExporter);



    }
}
