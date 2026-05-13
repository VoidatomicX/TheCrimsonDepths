package arsenal.the_crimson_depths.mixin;

import arsenal.the_crimson_depths.api.BreakShieldItem;
import arsenal.the_crimson_depths.items.Custom.LanceItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Inject(method = "takeShieldHit", at = @At("HEAD"))
    private void crimson$anchorDisableShield(LivingEntity attacker, CallbackInfo ci) {

        if (attacker.getMainHandStack().getItem() instanceof BreakShieldItem) {

            PlayerEntity player = (PlayerEntity)(Object)this;

            player.getItemCooldownManager().set(Items.SHIELD, 100);

            player.clearActiveItem();
            player.getWorld().sendEntityStatus(player, (byte)30);
        }
    }

    @Inject(method = "damage", at = @At("HEAD"))
    private void crimson$pierceArmor(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {

        Entity attacker = source.getAttacker();

        if (attacker instanceof PlayerEntity player) {

            if (player.getMainHandStack().getItem() instanceof LanceItem) {

                LivingEntity target = (LivingEntity)(Object)this;

                target.setAbsorptionAmount(0);

                target.timeUntilRegen = 0;
            }
        }
    }
}