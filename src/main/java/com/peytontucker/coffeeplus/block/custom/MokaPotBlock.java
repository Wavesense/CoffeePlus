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

public class MokaPotBlock extends HorizontalBlock {
    public MokaPotBlock(Properties properties) {
        super(properties);
    }

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.box(7, 8, 4, 9, 10, 5),
            Block.box(7, 9, 11, 9, 10, 13),
            Block.box(5, 0, 5, 11, 4, 11),
            Block.box(6, 4, 6, 10, 6, 10),
            Block.box(5, 6, 5, 11, 10, 11),
            Block.box(6, 10, 6, 10, 11, 10),
            Block.box(7, 11, 7, 9, 12, 9),
            Block.box(7, 6, 13, 9, 9, 14),
            Block.box(7, 5, 12, 9, 7, 13),
            Block.box(7, 9, 3, 9, 10, 4)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(4, 8, 7, 5, 10, 9),
            Block.box(11, 9, 7, 13, 10, 9),
            Block.box(5, 0, 5, 11, 4, 11),
            Block.box(6, 4, 6, 10, 6, 10),
            Block.box(5, 6, 5, 11, 10, 11),
            Block.box(6, 10, 6, 10, 11, 10),
            Block.box(7, 11, 7, 9, 12, 9),
            Block.box(13, 6, 7, 14, 9, 9),
            Block.box(12, 5, 7, 13, 7, 9),
            Block.box(3, 9, 7, 4, 10, 9)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.box(7, 8, 11, 9, 10, 12),
            Block.box(7, 9, 3, 9, 10, 5),
            Block.box(5, 0, 5, 11, 4, 11),
            Block.box(6, 4, 6, 10, 6, 10),
            Block.box(5, 6, 5, 11, 10, 11),
            Block.box(6, 10, 6, 10, 11, 10),
            Block.box(7, 11, 7, 9, 12, 9),
            Block.box(7, 6, 2, 9, 9, 3),
            Block.box(7, 5, 3, 9, 7, 4),
            Block.box(7, 9, 12, 9, 10, 13)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.box(11, 8, 7, 12, 10, 9),
            Block.box(3, 9, 7, 5, 10, 9),
            Block.box(5, 0, 5, 11, 4, 11),
            Block.box(6, 4, 6, 10, 6, 10),
            Block.box(5, 6, 5, 11, 10, 11),
            Block.box(6, 10, 6, 10, 11, 10),
            Block.box(7, 11, 7, 9, 12, 9),
            Block.box(2, 6, 7, 3, 9, 9),
            Block.box(3, 5, 7, 4, 7, 9),
            Block.box(12, 9, 7, 13, 10, 9)
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
