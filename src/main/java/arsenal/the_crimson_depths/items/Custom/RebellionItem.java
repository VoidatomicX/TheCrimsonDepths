package arsenal.the_crimson_depths.items.Custom;

import arsenal.the_crimson_depths.sound.ModSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

public class RebellionItem extends SwordItem {
    public RebellionItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        target.getWorld().playSound(
                null,
                target.getBlockPos(),
                ModSounds.Rebellion_slash,
                SoundCategory.PLAYERS,
                1.0F,
                1.8F
        );

        target.getWorld().playSound(
                null,
                target.getBlockPos(),
                SoundEvents.ITEM_MACE_SMASH_GROUND,
                SoundCategory.PLAYERS,
                0.5F,
                1.0F
        );


        return super.postHit(stack, target, attacker);
    }
}
