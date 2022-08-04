package com.peytontucker.coffeeplus.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup COFFEEPLUS_GROUP = new ItemGroup("coffeePlusTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.MOKA_POT.get());
        }
    };
}
