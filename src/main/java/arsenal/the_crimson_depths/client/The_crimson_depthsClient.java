package arsenal.the_crimson_depths.client;

import arsenal.the_crimson_depths.entity.ModEntities;
import arsenal.the_crimson_depths.particle.CrimsonModParticles;
import arsenal.the_crimson_depths.particle.PureResoniteDust;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.render.entity.EmptyEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderer;

public class The_crimson_depthsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ParticleFactoryRegistry.getInstance().register(CrimsonModParticles.Pure_Resonite_Dust_Particle, PureResoniteDust.Factory::new);

        EntityRendererRegistry.register(ModEntities.Pure_Resonite_Slash, EmptyEntityRenderer::new);
    }
}
