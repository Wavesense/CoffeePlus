package com.peytontucker.coffeeplus.item.drinkables;

import com.peytontucker.coffeeplus.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class IceGlassItem extends Item {

    public IceGlassItem(Properties builder) {
        super(builder);
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        return new ItemStack(ModItems.EMPTY_GLASS.get(),1);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }
}
