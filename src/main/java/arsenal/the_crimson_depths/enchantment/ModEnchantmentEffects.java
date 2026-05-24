package arsenal.the_crimson_depths.enchantment;

import arsenal.the_crimson_depths.The_crimson_depths;
import arsenal.the_crimson_depths.enchantment.custom.ReaperEnchantmentEffect;
import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {
    public static final MapCodec<? extends EnchantmentEntityEffect> Reaper =
            registerEntityEffect("reaper", ReaperEnchantmentEffect.CODEC);


    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name,
                                                                                    MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(The_crimson_depths.MOD_ID, name), codec);
    }

    public static void registerEnchantmentEffects() {
        The_crimson_depths.LOGGER.info("Registering Mod Enchantment Effects for " + The_crimson_depths.MOD_ID);
    }
}