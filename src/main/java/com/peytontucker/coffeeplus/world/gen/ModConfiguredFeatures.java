package com.peytontucker.coffeeplus.world.gen;

import com.peytontucker.coffeeplus.block.ModBlocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.PlainFlowerBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;

public class ModConfiguredFeatures {

    public static final ConfiguredFeature<?,?> COFFEE_PLANT_CONFIG = Feature.FLOWER.configured((
            new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.COFFEE_PLANT.get().defaultBlockState()),
                    SimpleBlockPlacer.INSTANCE)).tries(12).build()).decorated(Features.Placements.HEIGHTMAP).count(10 );

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String p_243968_0_, ConfiguredFeature<FC, ?> p_243968_1_) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, p_243968_0_, p_243968_1_);
    }

}
