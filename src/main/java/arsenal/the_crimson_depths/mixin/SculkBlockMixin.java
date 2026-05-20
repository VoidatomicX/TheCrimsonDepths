package arsenal.the_crimson_depths.mixin;

import arsenal.the_crimson_depths.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SculkBlock;
import net.minecraft.block.entity.SculkSpreadManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SculkBlock.class)
public class SculkBlockMixin {

    @Inject(method = "spread", at = @At("HEAD"))
    private static void crimson$spreadInfestation(
            SculkSpreadManager.Cursor cursor,
            WorldAccess world,
            BlockPos catalystPos,
            Random random,
            SculkSpreadManager spreadManager,
            boolean shouldConvertToBlock,
            CallbackInfoReturnable<Integer> cir
    ) {

        for (Direction direction : Direction.values()) {

            BlockPos checkPos = catalystPos.offset(direction);
            BlockState state = world.getBlockState(checkPos);

            if (state.isOf(Blocks.REDSTONE_ORE)) {

                world.setBlockState(
                        checkPos,
                        ModBlocks.Infested_Redstone_Block.getDefaultState(),
                        Block.NOTIFY_ALL
                );
            }

            if (state.isOf(Blocks.DEEPSLATE_REDSTONE_ORE)) {

                world.setBlockState(
                        checkPos,
                        ModBlocks.Infested_Redstone_Block.getDefaultState(),
                        Block.NOTIFY_ALL
                );
            }
        }
    }
}