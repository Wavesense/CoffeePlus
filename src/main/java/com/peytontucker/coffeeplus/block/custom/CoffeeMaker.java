package com.peytontucker.coffeeplus.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
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

public class CoffeeMaker extends HorizontalBlock {
public CoffeeMaker(Properties properties) {
        super(properties);
        }

private static final VoxelShape SHAPE_N = Stream.of(
        Block.makeCuboidShape(3, 0, 2, 13, 1, 14),
        Block.makeCuboidShape(3, 1, 10, 13, 9, 14),
        Block.makeCuboidShape(3, 9, 2, 13, 14, 14),
        Block.makeCuboidShape(7, 8, 5, 9, 9, 7),
        Block.makeCuboidShape(11, 1, 2, 13, 2, 10),
        Block.makeCuboidShape(5, 1, 9, 11, 2, 10),
        Block.makeCuboidShape(3, 1, 2, 5, 2, 10),
        Block.makeCuboidShape(10, 11, 1, 11, 12, 2),
        Block.makeCuboidShape(8, 11, 1, 9, 12, 2)
).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

private static final VoxelShape SHAPE_W = Stream.of(
        Block.makeCuboidShape(2, 0, 3, 14, 1, 13),
        Block.makeCuboidShape(10, 1, 3, 14, 9, 13),
        Block.makeCuboidShape(2, 9, 3, 14, 14, 13),
        Block.makeCuboidShape(5, 8, 7, 7, 9, 9),
        Block.makeCuboidShape(2, 1, 3, 10, 2, 5),
        Block.makeCuboidShape(9, 1, 5, 10, 2, 11),
        Block.makeCuboidShape(2, 1, 11, 10, 2, 13),
        Block.makeCuboidShape(1, 11, 5, 2, 12, 6),
        Block.makeCuboidShape(1, 11, 7, 2, 12, 8)
).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

private static final VoxelShape SHAPE_S = Stream.of(
        Block.makeCuboidShape(3, 0, 2, 13, 1, 14),
        Block.makeCuboidShape(3, 1, 2, 13, 9, 6),
        Block.makeCuboidShape(3, 9, 2, 13, 14, 14),
        Block.makeCuboidShape(7, 8, 9, 9, 9, 11),
        Block.makeCuboidShape(3, 1, 6, 5, 2, 14),
        Block.makeCuboidShape(5, 1, 6, 11, 2, 7),
        Block.makeCuboidShape(11, 1, 6, 13, 2, 14),
        Block.makeCuboidShape(5, 11, 14, 6, 12, 15),
        Block.makeCuboidShape(7, 11, 14, 8, 12, 15)
).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

private static final VoxelShape SHAPE_E = Stream.of(
        Block.makeCuboidShape(2, 0, 3, 14, 1, 13),
        Block.makeCuboidShape(2, 1, 3, 6, 9, 13),
        Block.makeCuboidShape(2, 9, 3, 14, 14, 13),
        Block.makeCuboidShape(9, 8, 7, 11, 9, 9),
        Block.makeCuboidShape(6, 1, 11, 14, 2, 13),
        Block.makeCuboidShape(6, 1, 5, 7, 2, 11),
        Block.makeCuboidShape(6, 1, 3, 14, 2, 5),
        Block.makeCuboidShape(14, 11, 10, 15, 12, 11),
        Block.makeCuboidShape(14, 11, 8, 15, 12, 9)
).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

@Override
public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        switch (state.get(HORIZONTAL_FACING)) {
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
protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING);
        }

@Nullable
@Override
public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
        }
        }
