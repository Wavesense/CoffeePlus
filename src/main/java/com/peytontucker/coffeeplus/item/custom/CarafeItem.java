package com.peytontucker.coffeeplus.item.custom;

import com.peytontucker.coffeeplus.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.minecraft.item.Item.Properties;

public class CarafeItem extends BlockItem {

    public CarafeItem(Block p_i48527_1_, Properties p_i48527_2_) {
        super(p_i48527_1_, p_i48527_2_);
    }

    public ActionResultType useOn(ItemUseContext context) {

        ItemStack itemstack = context.getItemInHand();

        World world = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = world.getBlockState(blockpos);
        if (blockstate.getBlock().equals(ModBlocks.COFFEE_MAKER.get())) {
            BlockState newstate = ModBlocks.COFFEE_MAKER_WITH_CARAFE.get().defaultBlockState().setValue(HorizontalBlock.FACING, blockstate.getValue(HorizontalBlock.FACING));
            //PlayerEntity playerentity = context.getPlayer();
            //world.playSound(playerentity, blockpos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (!world.isClientSide) {
                world.setBlock(blockpos, newstate, 11);
                itemstack.shrink(1);
            }

            return ActionResultType.sidedSuccess(world.isClientSide);
        } else {
            return super.useOn(context);
        }

        //block.getDefaultState().with(RotatedPillarBlock.AXIS, originalState.get(RotatedPillarBlock.AXIS))
    }


}
