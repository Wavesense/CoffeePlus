package com.peytontucker.coffeeplus.item.custom;

import com.peytontucker.coffeeplus.block.ModBlocks;
import com.peytontucker.coffeeplus.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.world.World;

import net.minecraft.item.Item.Properties;

public class GreenCoffeeBeans extends BlockItem {
    public GreenCoffeeBeans(Block blockIn, Properties properties) {
        super(blockIn, properties);
    }
}
