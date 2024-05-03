package com.uraneptus.pigsteel.core.registry;

import com.uraneptus.pigsteel.PigsteelMod;
import com.uraneptus.pigsteel.core.other.PigsteelProperties;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class PigsteelItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PigsteelMod.MOD_ID);

    public static final DeferredItem<Item> PIGSTEEL_CHUNK = ITEMS.registerSimpleItem("pigsteel_chunk", PigsteelProperties.basePigsteelItem());
}
