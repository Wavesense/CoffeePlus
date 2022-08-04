package com.peytontucker.coffeeplus.block;

import com.peytontucker.coffeeplus.CoffeePlus;
import com.peytontucker.coffeeplus.item.ModItemGroup;
import com.peytontucker.coffeeplus.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
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
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK) // set to rock material
                    .harvestLevel(1) // harvestable w at least stone
                    .harvestTool(ToolType.PICKAXE) // must use pickaxe
                    .setRequiresTool() // needed to require a specific tool
                    .hardnessAndResistance(5f))); // controls how fast mined


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
