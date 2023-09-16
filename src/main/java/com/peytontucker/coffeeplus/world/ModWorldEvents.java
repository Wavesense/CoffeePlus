package com.peytontucker.coffeeplus.world;

import com.peytontucker.coffeeplus.CoffeePlus;
import com.peytontucker.coffeeplus.world.gen.ModFlowerGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CoffeePlus.MOD_ID)
public class ModWorldEvents {

    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModFlowerGeneration.generateFlowers(event);
    }

}
