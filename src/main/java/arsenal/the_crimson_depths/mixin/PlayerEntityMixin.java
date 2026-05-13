package arsenal.the_crimson_depths.mixin;

import arsenal.the_crimson_depths.api.BreakShieldItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

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




}