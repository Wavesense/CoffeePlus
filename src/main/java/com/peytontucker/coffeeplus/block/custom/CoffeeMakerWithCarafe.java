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

import net.minecraft.block.AbstractBlock.Properties;

public class CoffeeMakerWithCarafe extends HorizontalBlock {
    public CoffeeMakerWithCarafe(Properties properties) {
        super(properties);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(3, 0, 2, 13, 1, 14),
            Block.box(3, 1, 10, 13, 9, 14),
            Block.box(3, 9, 2, 13, 14, 14),
            Block.box(7, 8, 5, 9, 9, 7),
            Block.box(11, 1, 2, 13, 2, 10),
            Block.box(5, 1, 9, 11, 2, 10),
            Block.box(3, 1, 2, 5, 2, 10),
            Block.box(10, 11, 1, 11, 12, 2),
            Block.box(8, 11, 1, 9, 12, 2),
            Block.box(6, 1, 4, 10, 2, 8),
            Block.box(6, 6, 4, 10, 7, 8),
            Block.box(6, 1, 3, 10, 2, 4),
            Block.box(6, 1, 8, 10, 2, 9),
            Block.box(10, 1, 4, 11, 2, 8),
            Block.box(5, 1, 4, 6, 2, 8),
            Block.box(6, 2, 3, 10, 6, 4),
            Block.box(6, 2, 8, 10, 6, 9),
            Block.box(10, 2, 4, 11, 6, 8),
            Block.box(5, 2, 4, 6, 6, 8),
            Block.box(7, 6, 2, 9, 7, 4),
            Block.box(7, 2, 1, 9, 6, 2),
            Block.box(7, 1, 2, 9, 2, 3)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.box(2, 0, 3, 14, 1, 13),
            Block.box(10, 1, 3, 14, 9, 13),
            Block.box(2, 9, 3, 14, 14, 13),
            Block.box(5, 8, 7, 7, 9, 9),
            Block.box(2, 1, 3, 10, 2, 5),
            Block.box(9, 1, 5, 10, 2, 11),
            Block.box(2, 1, 11, 10, 2, 13),
            Block.box(1, 11, 5, 2, 12, 6),
            Block.box(1, 11, 7, 2, 12, 8),
            Block.box(4, 1, 6, 8, 2, 10),
            Block.box(4, 6, 6, 8, 7, 10),
            Block.box(3, 1, 6, 4, 2, 10),
            Block.box(8, 1, 6, 9, 2, 10),
            Block.box(4, 1, 5, 8, 2, 6),
            Block.box(4, 1, 10, 8, 2, 11),
            Block.box(3, 2, 6, 4, 6, 10),
            Block.box(8, 2, 6, 9, 6, 10),
            Block.box(4, 2, 5, 8, 6, 6),
            Block.box(4, 2, 10, 8, 6, 11),
            Block.box(2, 6, 7, 4, 7, 9),
            Block.box(1, 2, 7, 2, 6, 9),
            Block.box(2, 1, 7, 3, 2, 9)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.box(3, 0, 2, 13, 1, 14),
            Block.box(3, 1, 2, 13, 9, 6),
            Block.box(3, 9, 2, 13, 14, 14),
            Block.box(7, 8, 9, 9, 9, 11),
            Block.box(3, 1, 6, 5, 2, 14),
            Block.box(5, 1, 6, 11, 2, 7),
            Block.box(11, 1, 6, 13, 2, 14),
            Block.box(5, 11, 14, 6, 12, 15),
            Block.box(7, 11, 14, 8, 12, 15),
            Block.box(6, 1, 8, 10, 2, 12),
            Block.box(6, 6, 8, 10, 7, 12),
            Block.box(6, 1, 12, 10, 2, 13),
            Block.box(6, 1, 7, 10, 2, 8),
            Block.box(5, 1, 8, 6, 2, 12),
            Block.box(10, 1, 8, 11, 2, 12),
            Block.box(6, 2, 12, 10, 6, 13),
            Block.box(6, 2, 7, 10, 6, 8),
            Block.box(5, 2, 8, 6, 6, 12),
            Block.box(10, 2, 8, 11, 6, 12),
            Block.box(7, 6, 12, 9, 7, 14),
            Block.box(7, 2, 14, 9, 6, 15),
            Block.box(7, 1, 13, 9, 2, 14)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.box(2, 0, 3, 14, 1, 13),
            Block.box(2, 1, 3, 6, 9, 13),
            Block.box(2, 9, 3, 14, 14, 13),
            Block.box(9, 8, 7, 11, 9, 9),
            Block.box(6, 1, 11, 14, 2, 13),
            Block.box(6, 1, 5, 7, 2, 11),
            Block.box(6, 1, 3, 14, 2, 5),
            Block.box(14, 11, 10, 15, 12, 11),
            Block.box(14, 11, 8, 15, 12, 9),
            Block.box(8, 1, 6, 12, 2, 10),
            Block.box(8, 6, 6, 12, 7, 10),
            Block.box(12, 1, 6, 13, 2, 10),
            Block.box(7, 1, 6, 8, 2, 10),
            Block.box(8, 1, 10, 12, 2, 11),
            Block.box(8, 1, 5, 12, 2, 6),
            Block.box(12, 2, 6, 13, 6, 10),
            Block.box(7, 2, 6, 8, 6, 10),
            Block.box(8, 2, 10, 12, 6, 11),
            Block.box(8, 2, 5, 12, 6, 6),
            Block.box(12, 6, 7, 14, 7, 9),
            Block.box(14, 2, 7, 15, 6, 9),
            Block.box(13, 1, 7, 14, 2, 9)
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
}
