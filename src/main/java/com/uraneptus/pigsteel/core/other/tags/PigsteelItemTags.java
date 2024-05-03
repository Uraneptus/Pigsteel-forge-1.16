package com.uraneptus.pigsteel.core.other.tags;

import com.uraneptus.pigsteel.PigsteelMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class PigsteelItemTags {

    public static final TagKey<Item> PIGSTEEL_ORES = of("pigsteel_ores");

    private static TagKey<Item> of(String id) {
        return TagKey.create(Registries.ITEM, PigsteelMod.modPrefix(id));
    }
}
