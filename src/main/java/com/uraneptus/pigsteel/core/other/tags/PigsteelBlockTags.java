package com.uraneptus.pigsteel.core.other.tags;

import com.uraneptus.pigsteel.PigsteelMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class PigsteelBlockTags {
    public static final TagKey<Block> PIGSTEEL_ORES = of("pigsteel_ores");
    public static final TagKey<Block> PIGSTEEL_BLOCKS = of("pigsteel_blocks");
    public static final TagKey<Block> ZOMBIFICATION_DECELERATION = of("zombification_deceleration");
    public static final TagKey<Block> ZOMBIFICATION_ACCELERATION = of("zombification_acceleration");

    private static TagKey<Block> of(String id) {
        return TagKey.create(Registries.BLOCK, PigsteelMod.modPrefix(id));
    }
}
