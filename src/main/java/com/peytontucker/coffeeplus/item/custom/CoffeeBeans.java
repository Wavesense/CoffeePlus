package com.peytontucker.coffeeplus.item.custom;

import com.peytontucker.coffeeplus.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.world.World;

public class CoffeeBeans extends Item {
    public CoffeeBeans(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getWorld();

        if(!world.isRemote) {
            PlayerEntity playerEntity = context.getPlayer();
            BlockState clickedBlock = world.getBlockState(context.getPos());

            rightClickOnCertainBlockState(clickedBlock, context, playerEntity);
        }

        return super.onItemUseFirst(stack, context);
    }

    private void rightClickOnCertainBlockState(BlockState clickedBlock, ItemUseContext context, PlayerEntity playerEntity) {

        //when the player is holding coffee beans and right-clicks on a coffee grinder block...
        if (clickedBlock.getBlock() == ModBlocks.COFFEE_GRINDER.get()) {

            //decrement item count by 1
            context.getItem().setCount(context.getItem().getCount()-1);
        }
    }
}
