package arsenal.the_crimson_depths.items;

import arsenal.the_crimson_depths.The_crimson_depths;
import arsenal.the_crimson_depths.items.Custom.*;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
//Scythe
    public static final Item Pure_Resonite_Scythe = registerItem("pure_resonite_scythe",
            new PureResoniteScytheItem(ResoniteToolMaterials.PURERESONITE, new Item.Settings().fireproof()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ResoniteToolMaterials.PURERESONITE, 7, -3f))));

    public static final Item Netherite_Scythe = registerItem("netherite_scythe",
            new ScytheItem(ToolMaterials.NETHERITE, new Item.Settings().fireproof()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 5, -2.8f))));

    public static final Item Diamond_Scythe = registerItem("diamond_scythe",
            new ScytheItem(ToolMaterials.DIAMOND, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 4, -2.8f))));

    public static final Item Gold_Scythe = registerItem("gold_scythe",
            new ScytheItem(ToolMaterials.GOLD, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.GOLD, 5, -2.7f))));

    public static final Item Resonite_Scythe = registerItem("resonite_scythe",
            new ScytheItem(ResoniteToolMaterials.RESONITE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ResoniteToolMaterials.RESONITE, 5, -2.6f))));

    public static final Item Iron_Scythe = registerItem("iron_scythe",
            new ScytheItem(ToolMaterials.IRON, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 3, -2.9f))));

    public static final Item Stone_Scythe = registerItem("stone_scythe",
            new ScytheItem(ToolMaterials.STONE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 1, -3.1f))));



//Lance
    public static final Item Netherite_Lance = registerItem("netherite_lance",
            new LanceItem(ToolMaterials.NETHERITE, new Item.Settings().fireproof()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 6, -2.9f))));

    public static final Item Diamond_Lance = registerItem("diamond_lance",
            new LanceItem(ToolMaterials.DIAMOND, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 5, -2.8f))));

    public static final Item Resonite_Lance = registerItem("resonite_lance",
            new LanceItem(ResoniteToolMaterials.RESONITE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ResoniteToolMaterials.RESONITE, 6, -2.7f))));

    public static final Item Gold_Lance = registerItem("gold_lance",
            new LanceItem(ToolMaterials.GOLD, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.GOLD, 6, -2.7f))));

    public static final Item Iron_Lance = registerItem("iron_lance",
            new LanceItem(ToolMaterials.IRON, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 4, -3f))));

    public static final Item Stone_Lance = registerItem("stone_lance",
            new LanceItem(ToolMaterials.STONE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 3, -3.1f))));



//Anchor
    public static final Item Pure_Resonite_Anchor = registerItem("pure_resonite_anchor",
            new PureResoniteAnchorItem(ResoniteToolMaterials.PURERESONITE, new Item.Settings().fireproof()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ResoniteToolMaterials.PURERESONITE, 4, -2.7f))));

    public static final Item Netherite_Anchor = registerItem("netherite_anchor",
            new AnchorItem(ToolMaterials.NETHERITE, new Item.Settings().fireproof()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.NETHERITE, 7, -3.1f))));

    public static final Item Diamond_Anchor = registerItem("diamond_anchor",
            new AnchorItem(ToolMaterials.DIAMOND, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 5, -2.8f))));

    public static final Item Resonite_Anchor = registerItem("resonite_anchor",
            new AnchorItem(ResoniteToolMaterials.RESONITE, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ResoniteToolMaterials.RESONITE, 5, -2.7f))));

    public static final Item Gold_Anchor = registerItem("gold_anchor",
            new AnchorItem(ToolMaterials.GOLD, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.GOLD, 5, -2.5f))));

    public static final Item Iron_Anchor = registerItem("iron_anchor",
            new AnchorItem(ToolMaterials.IRON, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.IRON, 4, -2.2f))));

    public static final Item Stone_Anchor = registerItem("stone_anchor",
            new AnchorItem(ToolMaterials.STONE, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.STONE, 2, -1.9f))));

    public static final Item Resonite_Ingot = registerItem("resonite_ingot", new Item(new Item.Settings()));
    public static final Item Raw_Resonite = registerItem("raw_resonite", new Item(new Item.Settings()));

    //Resonite Armor

    public static final Item Resonite_Helmet = registerItem("resonite_helmet",
            new ArmorItem(ResoniteArmorMaterials.RESONITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(25))));

    public static final Item Resonite_Chestplate = registerItem("resonite_chestplate",
            new ArmorItem(ResoniteArmorMaterials.RESONITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(25))));

    public static final Item Resonite_Leggings = registerItem("resonite_leggings",
            new ArmorItem(ResoniteArmorMaterials.RESONITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(25))));

    public static final Item Resonite_Boots = registerItem("resonite_boots",
            new ArmorItem(ResoniteArmorMaterials.RESONITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(25))));

//RELICS

    public static final Item Rebellion = registerItem("rebellion",
            new RebellionItem(ResoniteToolMaterials.RELICS, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ResoniteToolMaterials.RELICS, 4, -2.9f))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(The_crimson_depths.MOD_ID, name), item);
    }

    public static void registerModItems() {
        The_crimson_depths.LOGGER.info("Registering Mod Items for " + The_crimson_depths.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(Pure_Resonite_Scythe);
            entries.add(Netherite_Scythe);
            entries.add(Diamond_Scythe);
            entries.add(Resonite_Scythe);
            entries.add(Gold_Scythe);
            entries.add(Iron_Scythe);
            entries.add(Stone_Scythe);

            entries.add(Netherite_Lance);
            entries.add(Diamond_Lance);
            entries.add(Resonite_Lance);
            entries.add(Gold_Lance);
            entries.add(Iron_Lance);
            entries.add(Stone_Lance);

            entries.add(Pure_Resonite_Anchor);
            entries.add(Netherite_Anchor);
            entries.add(Diamond_Anchor);
            entries.add(Resonite_Anchor);
            entries.add(Gold_Anchor);
            entries.add(Iron_Anchor);
            entries.add(Stone_Anchor);

        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
         fabricItemGroupEntries.add(Raw_Resonite);
         fabricItemGroupEntries.add(Resonite_Ingot);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(fabricItemGroupEntries -> {
         fabricItemGroupEntries.add(Resonite_Helmet);
         fabricItemGroupEntries.add(Resonite_Chestplate);
         fabricItemGroupEntries.add(Resonite_Leggings);
         fabricItemGroupEntries.add(Resonite_Boots);

         fabricItemGroupEntries.add(Rebellion);
        });
    }
}