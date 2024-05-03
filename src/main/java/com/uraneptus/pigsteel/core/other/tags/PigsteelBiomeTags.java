package com.uraneptus.pigsteel.core.other.tags;

import com.uraneptus.pigsteel.PigsteelMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class PigsteelBiomeTags {
    public static final TagKey<Biome> HAS_EXTRA_PIGSTEEL = of("has_extra_pigsteel");
    public static final TagKey<Biome> PIGSTEEL_GENERATE_IN = of("pigsteel_generates_in");
    public static final TagKey<Biome> HAS_PIGSTEEL_MINE = of("has_pigsteel_mine");

    private static TagKey<Biome> of(String id) {
        return TagKey.create(Registries.BIOME, PigsteelMod.modPrefix(id));
    }
}
