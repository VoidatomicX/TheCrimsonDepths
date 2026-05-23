/*package arsenal.the_crimson_depths.enchantment.custom;

import arsenal.the_crimson_depths.items.ModItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Rarity;

public class ReaperEnchantment extends Enchantment {

    public static final MapCodec<? extends EnchantmentEntityEffect> CODEC = ;

    public ReaperEnchantment() {
        super(Enchantment.(
                ItemTags.WEAPON_ENCHANTABLE,
                1, // weight
                1, // max level
                Enchantment.leveledCost(20, 15), // min cost per level
                Enchantment.leveledCost(50, 25), // max cost per level
                2, // anvil cost
                AttributeModifierSlot.MAINHAND;
        ));
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.isOf(ModItems.Pure_Resonite_Scythe)
                || stack.isOf(Items.BOOK)
                || stack.isOf(Items.ENCHANTED_BOOK);
    }
}*/