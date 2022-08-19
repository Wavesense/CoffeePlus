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

public class Carafe extends HorizontalBlock {
public Carafe(Properties properties) {
        super(properties);
        }

private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(6, 0, 6, 10, 1, 10),
            Block.makeCuboidShape(6, 5, 6, 10, 6, 10),
            Block.makeCuboidShape(6, 0, 5, 10, 1, 6),
            Block.makeCuboidShape(6, 0, 10, 10, 1, 11),
            Block.makeCuboidShape(10, 0, 6, 11, 1, 10),
            Block.makeCuboidShape(5, 0, 6, 6, 1, 10),
            Block.makeCuboidShape(6, 1, 5, 10, 5, 6),
            Block.makeCuboidShape(6, 1, 10, 10, 5, 11),
            Block.makeCuboidShape(10, 1, 6, 11, 5, 10),
            Block.makeCuboidShape(5, 1, 6, 6, 5, 10),
            Block.makeCuboidShape(7, 5, 4, 9, 6, 6),
            Block.makeCuboidShape(7, 1, 3, 9, 5, 4),
            Block.makeCuboidShape(7, 0, 4, 9, 1, 5)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

private static final VoxelShape SHAPE_W = Stream.of(
        Block.makeCuboidShape(6, 0, 6, 10, 1, 10),
        Block.makeCuboidShape(6, 5, 6, 10, 6, 10),
        Block.makeCuboidShape(5, 0, 6, 6, 1, 10),
        Block.makeCuboidShape(10, 0, 6, 11, 1, 10),
        Block.makeCuboidShape(6, 0, 5, 10, 1, 6),
        Block.makeCuboidShape(6, 0, 10, 10, 1, 11),
        Block.makeCuboidShape(5, 1, 6, 6, 5, 10),
        Block.makeCuboidShape(10, 1, 6, 11, 5, 10),
        Block.makeCuboidShape(6, 1, 5, 10, 5, 6),
        Block.makeCuboidShape(6, 1, 10, 10, 5, 11),
        Block.makeCuboidShape(4, 5, 7, 6, 6, 9),
        Block.makeCuboidShape(3, 1, 7, 4, 5, 9),
        Block.makeCuboidShape(4, 0, 7, 5, 1, 9)
).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

private static final VoxelShape SHAPE_S = Stream.of(
        Block.makeCuboidShape(6, 0, 6, 10, 1, 10),
        Block.makeCuboidShape(6, 5, 6, 10, 6, 10),
        Block.makeCuboidShape(6, 0, 10, 10, 1, 11),
        Block.makeCuboidShape(6, 0, 5, 10, 1, 6),
        Block.makeCuboidShape(5, 0, 6, 6, 1, 10),
        Block.makeCuboidShape(10, 0, 6, 11, 1, 10),
        Block.makeCuboidShape(6, 1, 10, 10, 5, 11),
        Block.makeCuboidShape(6, 1, 5, 10, 5, 6),
        Block.makeCuboidShape(5, 1, 6, 6, 5, 10),
        Block.makeCuboidShape(10, 1, 6, 11, 5, 10),
        Block.makeCuboidShape(7, 5, 10, 9, 6, 12),
        Block.makeCuboidShape(7, 1, 12, 9, 5, 13),
        Block.makeCuboidShape(7, 0, 11, 9, 1, 12)
).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

private static final VoxelShape SHAPE_E = Stream.of(
        Block.makeCuboidShape(6, 0, 6, 10, 1, 10),
        Block.makeCuboidShape(6, 5, 6, 10, 6, 10),
        Block.makeCuboidShape(10, 0, 6, 11, 1, 10),
        Block.makeCuboidShape(5, 0, 6, 6, 1, 10),
        Block.makeCuboidShape(6, 0, 10, 10, 1, 11),
        Block.makeCuboidShape(6, 0, 5, 10, 1, 6),
        Block.makeCuboidShape(10, 1, 6, 11, 5, 10),
        Block.makeCuboidShape(5, 1, 6, 6, 5, 10),
        Block.makeCuboidShape(6, 1, 10, 10, 5, 11),
        Block.makeCuboidShape(6, 1, 5, 10, 5, 6),
        Block.makeCuboidShape(10, 5, 7, 12, 6, 9),
        Block.makeCuboidShape(12, 1, 7, 13, 5, 9),
        Block.makeCuboidShape(11, 0, 7, 12, 1, 9)
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
