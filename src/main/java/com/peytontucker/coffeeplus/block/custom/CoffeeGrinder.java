package com.peytontucker.coffeeplus.block.custom;

import com.peytontucker.coffeeplus.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class CoffeeGrinder extends Block {
    public CoffeeGrinder(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity playerEntity, Hand handIn, BlockRayTraceResult hit) {
        if(!world.isRemote()) {
            ItemStack heldItemStack = playerEntity.getHeldItem(handIn);
            rightClickWithCertainItemStack(heldItemStack, playerEntity, world);
        }
        return ActionResultType.SUCCESS;
    }

    private void rightClickWithCertainItemStack(ItemStack heldItemStack, PlayerEntity playerEntity, World world) {
        if (heldItemStack.getItem() == Items.ICE) {
            heldItemStack.setCount(heldItemStack.getCount() - 1);

            if (!playerEntity.addItemStackToInventory(new ItemStack(ModItems.ICE_CUBES.get())))
                playerEntity.dropItem(new ItemStack(ModItems.ICE_CUBES.get()), true);
        }
    }
}