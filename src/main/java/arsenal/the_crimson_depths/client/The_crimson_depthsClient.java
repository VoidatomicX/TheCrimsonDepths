package arsenal.the_crimson_depths.client;

import arsenal.the_crimson_depths.particle.CrimsonModParticles;
import arsenal.the_crimson_depths.particle.PureResoniteDust;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.ParticleFactory;

public class The_crimson_depthsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ParticleFactoryRegistry.getInstance().register(CrimsonModParticles.Pure_Resonite_Dust_Particle, PureResoniteDust.Factory::new);
    }
}
