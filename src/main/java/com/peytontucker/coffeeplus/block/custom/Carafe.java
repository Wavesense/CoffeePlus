package com.peytontucker.coffeeplus.block.custom;

import com.peytontucker.coffeeplus.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.util.stream.Stream;

//variables:
//<BLOCK_NAME> = the name of the block you are creating
//<DIRECTION_N> = the voxel shape for north... etc for other cardinal directions

import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.world.World;

public class Carafe extends HorizontalBlock {
public Carafe(Properties properties) {
        super(properties);
        }

private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(6, 0, 6, 10, 1, 10),
            Block.box(6, 5, 6, 10, 6, 10),
            Block.box(6, 0, 5, 10, 1, 6),
            Block.box(6, 0, 10, 10, 1, 11),
            Block.box(10, 0, 6, 11, 1, 10),
            Block.box(5, 0, 6, 6, 1, 10),
            Block.box(6, 1, 5, 10, 5, 6),
            Block.box(6, 1, 10, 10, 5, 11),
            Block.box(10, 1, 6, 11, 5, 10),
            Block.box(5, 1, 6, 6, 5, 10),
            Block.box(7, 5, 4, 9, 6, 6),
            Block.box(7, 1, 3, 9, 5, 4),
            Block.box(7, 0, 4, 9, 1, 5)
            ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

private static final VoxelShape SHAPE_W = Stream.of(
        Block.box(6, 0, 6, 10, 1, 10),
        Block.box(6, 5, 6, 10, 6, 10),
        Block.box(5, 0, 6, 6, 1, 10),
        Block.box(10, 0, 6, 11, 1, 10),
        Block.box(6, 0, 5, 10, 1, 6),
        Block.box(6, 0, 10, 10, 1, 11),
        Block.box(5, 1, 6, 6, 5, 10),
        Block.box(10, 1, 6, 11, 5, 10),
        Block.box(6, 1, 5, 10, 5, 6),
        Block.box(6, 1, 10, 10, 5, 11),
        Block.box(4, 5, 7, 6, 6, 9),
        Block.box(3, 1, 7, 4, 5, 9),
        Block.box(4, 0, 7, 5, 1, 9)
).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

private static final VoxelShape SHAPE_S = Stream.of(
        Block.box(6, 0, 6, 10, 1, 10),
        Block.box(6, 5, 6, 10, 6, 10),
        Block.box(6, 0, 10, 10, 1, 11),
        Block.box(6, 0, 5, 10, 1, 6),
        Block.box(5, 0, 6, 6, 1, 10),
        Block.box(10, 0, 6, 11, 1, 10),
        Block.box(6, 1, 10, 10, 5, 11),
        Block.box(6, 1, 5, 10, 5, 6),
        Block.box(5, 1, 6, 6, 5, 10),
        Block.box(10, 1, 6, 11, 5, 10),
        Block.box(7, 5, 10, 9, 6, 12),
        Block.box(7, 1, 12, 9, 5, 13),
        Block.box(7, 0, 11, 9, 1, 12)
).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

private static final VoxelShape SHAPE_E = Stream.of(
        Block.box(6, 0, 6, 10, 1, 10),
        Block.box(6, 5, 6, 10, 6, 10),
        Block.box(10, 0, 6, 11, 1, 10),
        Block.box(5, 0, 6, 6, 1, 10),
        Block.box(6, 0, 10, 10, 1, 11),
        Block.box(6, 0, 5, 10, 1, 6),
        Block.box(10, 1, 6, 11, 5, 10),
        Block.box(5, 1, 6, 6, 5, 10),
        Block.box(6, 1, 10, 10, 5, 11),
        Block.box(6, 1, 5, 10, 5, 6),
        Block.box(10, 5, 7, 12, 6, 9),
        Block.box(12, 1, 7, 13, 5, 9),
        Block.box(11, 0, 7, 12, 1, 9)
).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

@Override
public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        switch (state.getValue(FACING)) {
        case NORTH:
        return SHAPE_N;
        case WEST:
        return SHAPE_W;
        case SOUTH:
        return SHAPE_S;
        case EAST:
        return SHAPE_E;
default:
        return SHAPE_N;
        }
        }

@Override
protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        }

@Nullable
@Override
public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
        }

        @Override
        public ActionResultType use(BlockState state, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockRayTraceResult blockRayTraceResult) {
                if (world.isClientSide()) {
                        return ActionResultType.PASS;
                }

                world.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 1);
                if (!player.addItem(new ItemStack(ModItems.CARAFE.get())))
                        player.drop(new ItemStack(ModItems.CARAFE.get()), true);

                return super.use(state, world, blockPos, player, hand, blockRayTraceResult);
        }
}
