package arsenal.the_crimson_depths.items.Custom;

import arsenal.the_crimson_depths.api.BreakShieldItem;
import net.minecraft.block.BlockKeys;
import net.minecraft.item.Item;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

public class LanceItem extends MiningToolItem implements BreakShieldItem {

    public LanceItem(ToolMaterial toolMaterial, Item.Settings settings) {
        super(toolMaterial, BlockTags.SHOVEL_MINEABLE, settings);
    }
}
