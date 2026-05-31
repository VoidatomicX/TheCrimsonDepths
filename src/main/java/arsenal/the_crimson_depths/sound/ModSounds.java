package arsenal.the_crimson_depths.sound;

import arsenal.the_crimson_depths.The_crimson_depths;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent Rebellion_slash = registerSoundEvent("rebellion_slash");
    public static final SoundEvent Judgement_Cut = registerSoundEvent("judgement_cut");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(The_crimson_depths.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        The_crimson_depths.LOGGER.info("Registering Mod Sounds for " + The_crimson_depths.MOD_ID);
    }
}