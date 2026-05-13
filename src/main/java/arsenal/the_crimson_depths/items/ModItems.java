package arsenal.the_crimson_depths.items;

import arsenal.the_crimson_depths.The_crimson_depths;
import arsenal.the_crimson_depths.items.Custom.AnchorItem;
import arsenal.the_crimson_depths.items.Custom.LanceItem;
import arsenal.the_crimson_depths.items.Custom.ScytheItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item Crimson_Scythe = registerItem("crimson_scythe",
            new ScytheItem(ToolMaterials.NETHERITE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 5, -2.8f))));

    public static final Item Netherite_Lance = registerItem("netherite_lance",
            new LanceItem(ToolMaterials.NETHERITE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 5, -2.8f))));

    public static final Item Netherite_Anchor = registerItem("netherite_anchor",
            new AnchorItem(ToolMaterials.NETHERITE, new Item.Settings().fireproof()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.NETHERITE, 7, -3.1f))));

    public static final Item Diamond_Anchor = registerItem("diamond_anchor",
            new AnchorItem(ToolMaterials.DIAMOND, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 5, -2.8f))));

    public static final Item Gold_Anchor = registerItem("gold_anchor",
            new AnchorItem(ToolMaterials.GOLD, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.GOLD, 5, -2.5f))));

    public static final Item Iron_Anchor = registerItem("iron_anchor",
            new AnchorItem(ToolMaterials.IRON, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.IRON, 4, -2.2f))));

    public static final Item Stone_Anchor = registerItem("stone_anchor",
            new AnchorItem(ToolMaterials.STONE, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.STONE, 2, -1.9f))));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(The_crimson_depths.MOD_ID, name), item);
    }

    public static void registerModItems() {
        The_crimson_depths.LOGGER.info("Registering Mod Items for " + The_crimson_depths.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(Crimson_Scythe);
            entries.add(Netherite_Lance);
            entries.add(Netherite_Anchor);
            entries.add(Diamond_Anchor);
            entries.add(Gold_Anchor);
            entries.add(Iron_Anchor);
            entries.add(Stone_Anchor);

        });
    }
}