package arsenal.the_crimson_depths;

import arsenal.the_crimson_depths.blocks.ModBlocks;
import arsenal.the_crimson_depths.enchantment.ModEnchantmentEffects;
import arsenal.the_crimson_depths.entity.ModEntities;
import arsenal.the_crimson_depths.items.ModItems;
import arsenal.the_crimson_depths.particle.CrimsonModParticles;
import arsenal.the_crimson_depths.sound.ModSounds;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class The_crimson_depths implements ModInitializer {

    public static final String MOD_ID = "the_crimson_depths";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        CrimsonModParticles.registerParticles();
        ModEntities.registerModEntities();
        ModEnchantmentEffects.registerEnchantmentEffects();
        ModSounds.registerSounds();

    }
}
