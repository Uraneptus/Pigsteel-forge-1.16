package com.uraneptus.pigsteel.core.registry;

import com.uraneptus.pigsteel.PigsteelMod;
import com.uraneptus.pigsteel.common.worldgen.OreSlagConfiguration;
import com.uraneptus.pigsteel.common.worldgen.ScatteredSlagOreFeature;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class PigsteelFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(BuiltInRegistries.FEATURE, PigsteelMod.MOD_ID);

    public static final Supplier<Feature<OreSlagConfiguration>> HUGE_BLACK_MUSHROOM = FEATURES.register("scattered_slag_ore", () -> new ScatteredSlagOreFeature(OreSlagConfiguration.CODEC));

}
