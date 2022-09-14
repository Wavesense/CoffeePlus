package com.peytontucker.coffeeplus.item.custom;

import com.peytontucker.coffeeplus.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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

public class CarafeItem extends BlockItem {

    public CarafeItem(Block p_i48527_1_, Properties p_i48527_2_) {
        super(p_i48527_1_, p_i48527_2_);
    }

    public ActionResultType onItemUse(ItemUseContext context) {
//        World world = context.getWorld();
//        BlockPos blockpos = context.getPos();
//        BlockState blockstate = world.getBlockState(blockpos);
//        if (blockstate == ModBlocks.COFFEE_MAKER.get().getDefaultState()) {
//            System.out.println("Coffee maker properly");
//            PlayerEntity playerentity = context.getPlayer();
//            if (!world.isRemote) {
//                world.setBlockState(blockpos, ModBlocks.COFFEE_MAKER_WITH_CARAFE.get().getDefaultState(), 11);
//            }
//            return ActionResultType.func_233537_a_(world.isRemote);
//        } else {
//            return ActionResultType.PASS;
//        }


        ItemStack itemstack = context.getItem();

        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        BlockState blockstate = world.getBlockState(blockpos);
        if (blockstate.equals(ModBlocks.COFFEE_GRINDER.get().getDefaultState())) {
            PlayerEntity playerentity = context.getPlayer();
            //world.playSound(playerentity, blockpos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (!world.isRemote) {
                world.setBlockState(blockpos, ModBlocks.COFFEE_MAKER_WITH_CARAFE.get().getDefaultState(), 11);
                itemstack.shrink(1);
            }

            return ActionResultType.func_233537_a_(world.isRemote);
        } else {
            return ActionResultType.PASS;
        }
    }


}
