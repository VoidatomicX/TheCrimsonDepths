package arsenal.the_crimson_depths.items;

import arsenal.the_crimson_depths.The_crimson_depths;
import arsenal.the_crimson_depths.items.Custom.CrimsonScythe;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item Crimson_Scythe = registerItem("crimson_scythe",
            new CrimsonScythe(ToolMaterials.NETHERITE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 5, -2.8f))));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(The_crimson_depths.MOD_ID, name), item);
    }

    public static void registerModItems() {
        The_crimson_depths.LOGGER.info("Registering Mod Items for " + The_crimson_depths.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(Crimson_Scythe);
        });
    }
}