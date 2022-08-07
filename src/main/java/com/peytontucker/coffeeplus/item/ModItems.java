package com.peytontucker.coffeeplus.item;

import com.peytontucker.coffeeplus.block.ModBlocks;
import com.peytontucker.coffeeplus.item.custom.CoffeeBeans;
import com.peytontucker.coffeeplus.item.drinkables.DrinkableGlassItem;
import com.peytontucker.coffeeplus.item.drinkables.IceGlassItem;
import net.minecraft.advancements.criterion.MobEffectsPredicate;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import com.peytontucker.coffeeplus.CoffeePlus;

public class ModItems {

    

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CoffeePlus.MOD_ID);

    public static final RegistryObject<Item> MOKA_POT = ITEMS.register("moka_pot",
            () -> new BlockItem(ModBlocks.MOKA_POT.get(),
                    new Item.Properties().group(ModItemGroup.COFFEEPLUS_GROUP)));

    public static final RegistryObject<Item> ICE_CUBES = ITEMS.register("ice_cubes",
            () -> new Item(new Item.Properties()
                    .group(ModItemGroup.COFFEEPLUS_GROUP)
                    .food(new Food.Builder()
                            .fastToEat()
                            .setAlwaysEdible()
                            .effect(() -> new EffectInstance(Effects.SLOWNESS, 10, 0), 0.5f)
                            .build())));

    public static final RegistryObject<Item> GREEN_COFFEE_BEANS = ITEMS.register("green_coffee_beans",
            () -> new Item(new Item.Properties().group(ModItemGroup.COFFEEPLUS_GROUP)));
    public static final RegistryObject<Item> COFFEE_BEANS = ITEMS.register("coffee_beans",
            () -> new CoffeeBeans(ModBlocks.COFFEE_PLANT.get(), new Item.Properties()
                    .group(ModItemGroup.COFFEEPLUS_GROUP)
                    .food(new Food.Builder()
                            .hunger(1)
                            .saturation(0.1f)
                            .fastToEat()
                            .effect(() -> new EffectInstance(Effects.SPEED, 60, 0), 1f)
                            .setAlwaysEdible()
                            .build())));

    // Deprecated: Coffee seeds
//    public static final RegistryObject<Item> COFFEE_SEEDS = ITEMS.register("coffee_seeds",
//            () -> new BlockItem(ModBlocks.COFFEE_PLANT.get(),
//                    new Item.Properties().group(ModItemGroup.COFFEEPLUS_GROUP)));

    public static final RegistryObject<Item> GROUND_COFFEE = ITEMS.register("ground_coffee",
            () -> new Item(new Item.Properties().group(ModItemGroup.COFFEEPLUS_GROUP)));

    public static final RegistryObject<Item> EMPTY_GLASS = ITEMS.register("empty_glass",
            () -> new Item(new Item.Properties().group(ModItemGroup.COFFEEPLUS_GROUP)));

    public static final RegistryObject<Item> ICE_GLASS = ITEMS.register("ice_glass",
            () -> new IceGlassItem(new Item.Properties()
                    .group(ModItemGroup.COFFEEPLUS_GROUP)
                    .maxStackSize(1)));

    public static final RegistryObject<Item> ICED_COFFEE = ITEMS.register("iced_coffee",
            () -> new DrinkableGlassItem(new Item.Properties()
                    .group(ModItemGroup.COFFEEPLUS_GROUP)
                    .maxStackSize(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
