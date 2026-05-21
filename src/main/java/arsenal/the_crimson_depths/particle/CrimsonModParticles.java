package arsenal.the_crimson_depths.particle;

import arsenal.the_crimson_depths.The_crimson_depths;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CrimsonModParticles {
    public static final SimpleParticleType Pure_Resonite_Dust_Particle =
            registerParticle("pure_resonite_dust_particle", FabricParticleTypes.simple());


    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(The_crimson_depths.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        The_crimson_depths.LOGGER.info("Registering Part for" + The_crimson_depths.MOD_ID);
    }
}
