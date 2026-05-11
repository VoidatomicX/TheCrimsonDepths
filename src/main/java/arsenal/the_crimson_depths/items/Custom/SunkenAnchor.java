package arsenal.the_crimson_depths.items.Custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SunkenAnchor extends PickaxeItem {

    public SunkenAnchor(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        world.playSound(
                null,
                user.getX(),
                user.getY(),
                user.getZ(),
                SoundEvents.ITEM_TRIDENT_THROW,
                SoundCategory.PLAYERS,
                1.0F,
                1.0F
        );

        if (!world.isClient) {
            ThrownItemEntity anchorEntity = new ThrownItemEntity(world, user) {

                @Override
                protected Item getDefaultItem() {
                    return stack.getItem();
                }
            };

            anchorEntity.setItem(stack.copy());
            anchorEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 2.0F, 1.0F);

            world.spawnEntity(anchorEntity);
        }

        if (!user.getAbilities().creativeMode) {
            stack.decrement(1);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));

        return TypedActionResult.success(stack, world.isClient());
    }
}
