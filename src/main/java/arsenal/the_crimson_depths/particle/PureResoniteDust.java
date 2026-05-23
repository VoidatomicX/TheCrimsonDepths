package arsenal.the_crimson_depths.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;

public class PureResoniteDust extends SpriteBillboardParticle {

    private final SpriteProvider spriteProvider;

    public PureResoniteDust(ClientWorld clientWorld, double x, double y, double z,
                            SpriteProvider spriteProvider,
                            double xSpeed, double ySpeed, double zSpeed) {

        super(clientWorld, x, y, z, xSpeed, ySpeed, zSpeed);

        this.spriteProvider = spriteProvider;

        this.velocityMultiplier = 0.8f;

        this.maxAge = 40;

        this.red = 1f;

        this.scale = 0.09f;

        // random starting rotation
        this.angle = this.random.nextFloat() * ((float)Math.PI * 2F);

        this.setSprite(spriteProvider.getSprite(0, 5));
    }

    @Override
    public void tick() {
        super.tick();

        // Save previous angle for smooth interpolation
        this.prevAngle = this.angle;

        // Rotation speed
        this.angle += 0.15f;

        // Animation frames
        int frame = Math.min(this.age / 10, 5);

        this.setSprite(this.spriteProvider.getSprite(frame, 5));
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Factory implements ParticleFactory<SimpleParticleType> {

        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(SimpleParticleType parameters,
                                       ClientWorld world,
                                       double x, double y, double z,
                                       double velocityX, double velocityY, double velocityZ) {

            return new PureResoniteDust(
                    world,
                    x, y, z,
                    this.spriteProvider,
                    velocityX,
                    velocityY,
                    velocityZ
            );
        }
    }
}