package arsenal.the_crimson_depths.items.Custom;

import arsenal.the_crimson_depths.api.BoxHitEffectItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;

public class ScytheItem extends MiningToolItem implements BoxHitEffectItem {

    public ScytheItem(ToolMaterial toolMaterial, Item.Settings settings) {
        super(toolMaterial, BlockTags.HOE_MINEABLE, settings);
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

                target.addVelocity(dx * strength, 0.2, dz * strength);
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
