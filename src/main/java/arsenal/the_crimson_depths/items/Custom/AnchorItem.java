package arsenal.the_crimson_depths.items.Custom;

import arsenal.the_crimson_depths.api.BreakShieldItem;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class AnchorItem extends MiningToolItem implements BreakShieldItem {

    public AnchorItem(ToolMaterial toolMaterial, Item.Settings settings) {
        super(toolMaterial, BlockTags.PICKAXE_MINEABLE, settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ItemStack stack = user.getStackInHand(hand);

        int riptideLevel = (int) EnchantmentHelper.getTridentSpinAttackStrength(stack, user);

        if (riptideLevel > 0 && user.isTouchingWaterOrRain()) {
            user.setCurrentHand(hand);
            return TypedActionResult.consume(stack);
        }

        return TypedActionResult.pass(stack);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {

        if (!(user instanceof PlayerEntity player)) {
            return;
        }

        int useTime = this.getMaxUseTime(stack, user) - remainingUseTicks;

        // Must charge for at least 10 ticks
        if (useTime < 10) {
            return;
        }

        int riptideLevel = (int) EnchantmentHelper.getTridentSpinAttackStrength(stack, player);

        if (riptideLevel <= 0 || !player.isTouchingWaterOrRain()) {
            return;
        }

        Vec3d rotation = player.getRotationVec(1.0F);

        float speed = 3.0F + riptideLevel;

        player.addVelocity(
                rotation.x * speed,
                rotation.y * speed,
                rotation.z * speed
        );

        player.useRiptide(20, 8.0F, stack);

        stack.damage(
                1,
                player,
                LivingEntity.getSlotForHand(player.getActiveHand())
        );

        world.playSound(
                null,
                player.getX(),
                player.getY(),
                player.getZ(),
                SoundEvents.ITEM_TRIDENT_RIPTIDE_3,
                player.getSoundCategory(),
                1.0F,
                1.0F
        );

        player.incrementStat(Stats.USED.getOrCreateStat(this));
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 72000;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPEAR;
    }
}