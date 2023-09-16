package com.peytontucker.coffeeplus.util;

import com.peytontucker.coffeeplus.CoffeePlus;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSoundEvents {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CoffeePlus.MOD_ID);

    public static final RegistryObject<SoundEvent> COFFEE_GRINDING =
            registerSoundEvent("coffee_grinding");

    public static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(CoffeePlus.MOD_ID, name)));
    }
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
