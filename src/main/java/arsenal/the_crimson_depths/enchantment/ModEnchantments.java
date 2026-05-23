/*package arsenal.the_crimson_depths.enchantment;

import arsenal.the_crimson_depths.The_crimson_depths;
import arsenal.the_crimson_depths.enchantment.custom.ReaperEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public interface ModEnchantments {
    Map<Enchantment, Identifier> ENCHANTMENTS = new LinkedHashMap<>();

    Enchantment Reaper = createEnchantment("reaper", new ReaperEnchantment(), Enchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));
//    Enchantment HEFT = createEnchantment("heft", new HeftEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));

    private static Enchantment createEnchantment(String name, Enchantment enchantment) {
        ENCHANTMENTS.put(enchantment, Identifier.of(The_crimson_depths.MOD_ID, name));
        return enchantment;
    }

    private static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.getValue()));
    }
}*/