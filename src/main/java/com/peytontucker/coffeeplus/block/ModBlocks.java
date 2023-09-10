package com.peytontucker.coffeeplus.block;

import com.peytontucker.coffeeplus.CoffeePlus;
import com.peytontucker.coffeeplus.block.custom.*;
import com.peytontucker.coffeeplus.item.ModItemGroup;
import com.peytontucker.coffeeplus.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.lwjgl.system.CallbackI;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, CoffeePlus.MOD_ID);

    // actual code for compressed coffee
    public static final RegistryObject<Block> COFFEE_GRINDER = registerBlock("coffee_grinder",
            () -> new CoffeeGrinder(AbstractBlock.Properties.of(Material.STONE) // set to rock material
                    .harvestLevel(1) // harvestable w at least stone
                    .harvestTool(ToolType.PICKAXE) // must use pickaxe
                    .requiresCorrectToolForDrops() // needed to require a specific tool
                    .strength(5f))); // controls how fast mined

    // Coffee Sack block.
    public static final RegistryObject<Block> COFFEE_SACK = registerBlock("coffee_sack",
            () -> new Block(AbstractBlock.Properties.of(Material.VEGETABLE).strength(1f)));

    // Coffee plant block
    // Note that we use BLOCKS.register instead of our created registerBlock method
    // this is because registerBlock automatically creates a block item. We don't want this for crops!
    public static final RegistryObject<Block> COFFEE_PLANT = BLOCKS.register("coffee_plant",
            () -> new CoffeePlantBlock(AbstractBlock.Properties.copy(Blocks.CARROTS)));

    public static final RegistryObject<Block> MOKA_POT = BLOCKS.register("moka_pot",
            () -> new MokaPotBlock(AbstractBlock.Properties
                    .of(Material.METAL)
                    .strength(4f)
                    .noOcclusion()));

    public static final RegistryObject<Block> COFFEE_MAKER_WITH_CARAFE = BLOCKS.register("coffee_maker_with_carafe",
            () -> new CoffeeMakerWithCarafe(AbstractBlock.Properties
                    .of(Material.METAL)
                    .strength(4f)
                    .noOcclusion()));

    public static final RegistryObject<Block> CARAFE = BLOCKS.register("carafe",
            () -> new Carafe(AbstractBlock.Properties
                    .of(Material.METAL)
                    .strength(4f)
                    .noOcclusion()));

    public static final RegistryObject<Block> COFFEE_MAKER = registerBlock("coffee_maker",
            () -> new CoffeeMaker(AbstractBlock.Properties
                    .of(Material.METAL)
                    .strength(4f)
                    .noOcclusion()));




    // Registers a block. This is the method that should be called to register a block.
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // Register's a block item
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ModItemGroup.COFFEEPLUS_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
