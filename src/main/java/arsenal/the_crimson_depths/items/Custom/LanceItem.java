package arsenal.the_crimson_depths.items.Custom;

import arsenal.the_crimson_depths.api.PierceArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

public class LanceItem extends MiningToolItem implements PierceArmorItem {

    public LanceItem(ToolMaterial toolMaterial, Item.Settings settings) {
        super(toolMaterial, BlockTags.SHOVEL_MINEABLE, settings);
    }
}
