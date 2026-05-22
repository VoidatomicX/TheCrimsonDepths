package arsenal.the_crimson_depths.mixin;

import arsenal.the_crimson_depths.api.BoxHitEffectItem;
import arsenal.the_crimson_depths.particle.CrimsonModParticles;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "damage", at = @At("HEAD"))
    private void Crimson$weaponEffects(
            DamageSource source,
            float amount,
            CallbackInfoReturnable<Boolean> cir
    ) {

        LivingEntity target = (LivingEntity) (Object) this;

        if (!(source.getAttacker() instanceof PlayerEntity player)) {
            return;
        }

        ItemStack stack = player.getMainHandStack();

        if (!(stack.getItem() instanceof BoxHitEffectItem)) {
            return;
        }

        if (!(target.getWorld() instanceof ServerWorld serverWorld)) {
            return;
        }

        Vec3d velocity = target.getVelocity();

        target.setVelocity(
                velocity.x,
                1.0D,
                velocity.z
        );

        target.velocityDirty = true;

        // BOX PARTICLES
        Box box = target.getBoundingBox();

        double step = 0.15D;

        for (double x = box.minX; x <= box.maxX; x += step) {
            for (double y = box.minY; y <= box.maxY; y += step) {
                for (double z = box.minZ; z <= box.maxZ; z += step) {

                    boolean edgeX = x <= box.minX + step || x >= box.maxX - step;
                    boolean edgeY = y <= box.minY + step || y >= box.maxY - step;
                    boolean edgeZ = z <= box.minZ + step || z >= box.maxZ - step;

                    // Only spawn on edges/surface
                    if (edgeX || edgeY || edgeZ) {

                        serverWorld.spawnParticles(
                                CrimsonModParticles.Pure_Resonite_Dust_Particle, // your particle
                                x,
                                y,
                                z,
                                1,
                                0.0,
                                0.0,
                                0.0,
                                0.0
                        );
                    }
                }
            }
        }

        player.getItemCooldownManager().remove(stack.getItem());
    }
}