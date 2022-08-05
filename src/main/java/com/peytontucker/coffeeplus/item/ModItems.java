package com.peytontucker.coffeeplus.item;

import com.peytontucker.coffeeplus.item.custom.CoffeeBeans;
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
            () -> new Item(new Item.Properties().group(ModItemGroup.COFFEEPLUS_GROUP)));


    public static final RegistryObject<Item> COFFEE_BEANS = ITEMS.register("coffee_beans",
            () -> new CoffeeBeans(new Item.Properties().group(ModItemGroup.COFFEEPLUS_GROUP)));

    public static final RegistryObject<Item> GROUND_COFFEE = ITEMS.register("ground_coffee",
            () -> new Item(new Item.Properties().group(ModItemGroup.COFFEEPLUS_GROUP)));

    public static final RegistryObject<Item> EMPTY_GLASS = ITEMS.register("empty_glass",
            () -> new Item(new Item.Properties().group(ModItemGroup.COFFEEPLUS_GROUP)));

    public static final RegistryObject<Item> ICED_COFFEE = ITEMS.register("iced_coffee",
            () -> new Item(new Item.Properties().group(ModItemGroup.COFFEEPLUS_GROUP)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
