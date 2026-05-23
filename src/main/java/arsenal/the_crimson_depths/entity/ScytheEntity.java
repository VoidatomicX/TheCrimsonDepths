package arsenal.the_crimson_depths.entity;

import arsenal.the_crimson_depths.particle.CrimsonModParticles;
import com.google.common.collect.Sets;
import net.minecraft.client.sound.Sound;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ScytheEntity extends PersistentProjectileEntity {
    private final Set<StatusEffectInstance> effects = Sets.newHashSet();
    public int ticksUntilRemove = 5;
    public final List<LivingEntity> hitEntities = new ArrayList<>();

    public ScytheEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public ScytheEntity(World world, LivingEntity owner) {
        super(ModEntities.Pure_Resonite_Slash, world);
        this.setOwner(owner);
    }

    @Override
    protected ItemStack asItemStack() {
        return ItemStack.EMPTY;
    }

    @Override
    public void tick() {
        super.tick();

        for (float x = -3; x <= 3; x += 0.1f) {
            this.getWorld().addParticle(CrimsonModParticles.Pure_Resonite_Dust_Particle, this.getX() + x * Math.cos(this.getYaw()), this.getY(), this.getZ() + x * Math.sin(this.getYaw()), this.getVelocity().getX(), this.getVelocity().getY(), this.getVelocity().getZ());
        }

        if (this.inGround || this.age > 20) {
            this.ticksUntilRemove--;
        }

        if (this.ticksUntilRemove <= 0) {
            this.discard();
        }

        if (!this.getWorld().isClient) {
            for (LivingEntity livingEntity : this.getWorld().getEntitiesByClass(LivingEntity.class, this.getBoundingBox(), livingEntity -> this.getOwner() != livingEntity)) {
                if (!hitEntities.contains(livingEntity)) {
                    livingEntity.damage(this.getWorld().getDamageSources()
                            .create(DamageTypes.MAGIC, this, this.getOwner()), 12.0f);
                    for (StatusEffectInstance effect : this.effects) {
                        livingEntity.addStatusEffect(effect);
                    }
                    hitEntities.add(livingEntity);
                }
            }
        }
    }

    @Override
    protected SoundEvent getHitSound() {
        return SoundEvents.BLOCK_SCULK_HIT;
    }

    @Override
    public boolean hasNoGravity() {
        return true;
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return ItemStack.EMPTY;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
    }
}