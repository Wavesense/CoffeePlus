package com.peytontucker.coffeeplus.block;

import com.peytontucker.coffeeplus.CoffeePlus;
import com.peytontucker.coffeeplus.block.custom.CoffeeGrinder;
import com.peytontucker.coffeeplus.block.custom.CoffeePlantBlock;
import com.peytontucker.coffeeplus.block.custom.MokaPotBlock;
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
            () -> new CoffeeGrinder(AbstractBlock.Properties.create(Material.ROCK) // set to rock material
                    .harvestLevel(1) // harvestable w at least stone
                    .harvestTool(ToolType.PICKAXE) // must use pickaxe
                    .setRequiresTool() // needed to require a specific tool
                    .hardnessAndResistance(5f))); // controls how fast mined

    // Coffee Sack block.
    public static final RegistryObject<Block> COFFEE_SACK = registerBlock("coffee_sack",
            () -> new Block(AbstractBlock.Properties.create(Material.GOURD).hardnessAndResistance(1f)));

    // Coffee plant block
    // Note that we use BLOCKS.register instead of our created registerBlock method
    // this is because registerBlock automatically creates a block item. We don't want this for crops!
    public static final RegistryObject<Block> COFFEE_PLANT = BLOCKS.register("coffee_plant",
            () -> new CoffeePlantBlock(AbstractBlock.Properties.from(Blocks.CARROTS)));

    public static final RegistryObject<Block> MOKA_POT = BLOCKS.register("moka_pot",
            () -> new MokaPotBlock(AbstractBlock.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(4f)
                    .notSolid()));




    // Registers a block. This is the method that should be called to register a block.
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // Register's a block item
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.COFFEEPLUS_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
