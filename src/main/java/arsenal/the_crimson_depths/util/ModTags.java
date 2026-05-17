package arsenal.the_crimson_depths.util;

import arsenal.the_crimson_depths.The_crimson_depths;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_RESONITE_TOOL = createTag("needs_resonite_tool");
        public static final TagKey<Block> INCORRECT_FOR_RESONITE_TOOL = createTag("incorrect_for_resonite_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(The_crimson_depths.MOD_ID, name));
        }
    }

}
