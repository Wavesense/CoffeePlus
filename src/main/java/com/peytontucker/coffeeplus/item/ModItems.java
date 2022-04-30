package com.peytontucker.coffeeplus.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import com.peytontucker.coffeeplus.CoffeePlus;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CoffeePlus.MOD_ID);

    public static final RegistryObject<Item> MOKA_POT = ITEMS.register("moka_pot",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
