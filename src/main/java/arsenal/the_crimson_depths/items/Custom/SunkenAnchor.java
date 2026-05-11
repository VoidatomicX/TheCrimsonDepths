package arsenal.the_crimson_depths.items.Custom;

import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Hand;

public class SunkenAnchor extends MiningToolItem {

    public SunkenAnchor(ToolMaterial toolMaterial, Item.Settings settings) {
        super(toolMaterial, BlockTags.PICKAXE_MINEABLE, settings);
    }

}
