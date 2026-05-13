package arsenal.the_crimson_depths.items.Custom;

import arsenal.the_crimson_depths.api.BreakShieldItem;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;

public class AnchorItem extends MiningToolItem implements BreakShieldItem {

    public AnchorItem(ToolMaterial toolMaterial, Item.Settings settings) {
        super(toolMaterial, BlockTags.PICKAXE_MINEABLE, settings);
    }

}
