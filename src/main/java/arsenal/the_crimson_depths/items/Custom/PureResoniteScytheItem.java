package arsenal.the_crimson_depths.items.Custom;

import arsenal.the_crimson_depths.entity.ScytheEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class PureResoniteScytheItem extends MiningToolItem {

    public PureResoniteScytheItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, BlockTags.HOE_MINEABLE, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!user.getAbilities().creativeMode &&
                user.getItemCooldownManager().isCoolingDown(this)) {

            return TypedActionResult.pass(user.getStackInHand(hand));
        }

        // Only apply cooldown in survival/adventure
        if (!user.getAbilities().creativeMode) {
            user.getItemCooldownManager().set(this, 45);
        }

        if (!world.isClient) {

            ScytheEntity scythe = new ScytheEntity(world, user);

            scythe.setPosition(user.getEyePos());

            scythe.setVelocity(
                    user,
                    user.getPitch(),
                    user.getYaw(),
                    0,
                    0.5f,
                    0
            );

            world.spawnEntity(scythe);
        }

        return TypedActionResult.consume(user.getStackInHand(hand));
    }


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.getWorld().isClient && isCriticalHit(attacker)) {

            double dx = attacker.getX() - target.getX();
            double dz = attacker.getZ() - target.getZ();
            double dy = attacker.getY() - target.getY();

            double strength = 0.9;
            double distance = Math.sqrt(dx * dx + dz * dz);

            if (distance > 0) {
                dx /= distance;
                dz /= distance;
                dy /= distance;

                target.addVelocity(dx * strength, dy/2, dz * strength);
                target.velocityModified = true;
            }
        }
        return super.postHit(stack, target, attacker);
    }

    private boolean isCriticalHit(LivingEntity attacker) {
        if (!(attacker instanceof PlayerEntity player)) return false;

        return player.fallDistance > 0.0F
                && !player.isOnGround()
                && !player.isClimbing()
                && !player.isTouchingWater()
                && !player.hasVehicle()
                && !player.isSprinting();
    }
}
