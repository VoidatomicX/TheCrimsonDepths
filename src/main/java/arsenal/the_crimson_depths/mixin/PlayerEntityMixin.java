package arsenal.the_crimson_depths.mixin;

import arsenal.the_crimson_depths.api.BreakShieldItem;
import arsenal.the_crimson_depths.api.PierceArmorItem;
import arsenal.the_crimson_depths.api.PullBackItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Inject(method = "takeShieldHit", at = @At("HEAD"))
    private void crimson$anchorDisableShield(LivingEntity attacker, CallbackInfo ci) {

        if (attacker.getMainHandStack().getItem() instanceof BreakShieldItem) {

            PlayerEntity player = (PlayerEntity) (Object) this;

            player.getItemCooldownManager().set(Items.SHIELD, 100);

            player.clearActiveItem();
            player.getWorld().sendEntityStatus(player, (byte) 30);
        }
    }

    @Inject(method = "damage", at = @At("HEAD"))
    private void crimson$pierceArmor(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {

        Entity attacker = source.getAttacker();

        if (attacker instanceof PlayerEntity player) {

            if (player.getMainHandStack().getItem() instanceof PierceArmorItem) {

                LivingEntity target = (LivingEntity) (Object) this;

                for (ItemStack armorStack : target.getArmorItems()) {

                    if (armorStack.getItem() instanceof ArmorItem armorItem) {

                        int protection = armorItem.getProtection();

                        int durabilityDamage = switch (protection) {

                            case 1, 2 -> 1; // Leather / Gold

                            case 3, 4, 5 -> 2; // Chain / Iron

                            case 6, 7, 8 -> 3; // Diamond

                            default -> 5; // Netherite / Modded
                        };

                        armorStack.damage(
                                durabilityDamage,
                                target,
                                armorItem.getSlotType()
                        );
                    }
                }
            }
        }
    }

    @Inject(method = "damage", at = @At("HEAD"))
    private void crimson$criticalKnockback(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {

        Entity attackerEntity = source.getAttacker();

        if (!(attackerEntity instanceof PlayerEntity player)) {
            return;
        }

        if (!(player.getMainHandStack().getItem() instanceof PullBackItem)) {
            return;
        }

        if (!crimson$isCriticalHit(player)) {
            return;
        }

        LivingEntity target = (LivingEntity)(Object)this;

        double dx = target.getX() - player.getX();
        double dz = target.getZ() - player.getZ();

        double strength = 0.9;

        double distance = Math.sqrt(dx * dx + dz * dz);

        if (distance > 0) {

            dx /= distance;
            dz /= distance;

            target.addVelocity(-dx * strength, 0.2, -dz * strength);

            target.velocityModified = true;
        }
    }

    @Unique
    private boolean crimson$isCriticalHit(PlayerEntity player) {

        return player.fallDistance > 0.0F
                && !player.isOnGround()
                && !player.isClimbing()
                && !player.isTouchingWater()
                && !player.hasVehicle()
                && !player.isSprinting();
    }
}