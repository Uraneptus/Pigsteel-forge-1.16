package com.uraneptus.pigsteel.core.events;

import com.uraneptus.pigsteel.PigsteelMod;
import com.uraneptus.pigsteel.core.registry.PigsteelBlocks;
import com.uraneptus.pigsteel.core.registry.PigsteelItems;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.function.Supplier;

@EventBusSubscriber(modid = PigsteelMod.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class PigsteelClientEvents {

    @SubscribeEvent
    public static void buildTabContents(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> tabKey = event.getTabKey();
        if (tabKey == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(PigsteelBlocks.UNAFFECTED_REFINED_PIGSTEEL);
            event.accept(PigsteelBlocks.UNAFFECTED_CUT_PIGSTEEL);
            event.accept(PigsteelBlocks.UNAFFECTED_CUT_PIGSTEEL_STAIRS);
            event.accept(PigsteelBlocks.UNAFFECTED_CUT_PIGSTEEL_SLAB);
            event.accept(PigsteelBlocks.INFECTED_REFINED_PIGSTEEL);
            event.accept(PigsteelBlocks.INFECTED_CUT_PIGSTEEL);
            event.accept(PigsteelBlocks.INFECTED_CUT_PIGSTEEL_STAIRS);
            event.accept(PigsteelBlocks.INFECTED_CUT_PIGSTEEL_SLAB);
            event.accept(PigsteelBlocks.CORRUPTED_REFINED_PIGSTEEL);
            event.accept(PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL);
            event.accept(PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL_STAIRS);
            event.accept(PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL_SLAB);
            event.accept(PigsteelBlocks.ZOMBIFIED_REFINED_PIGSTEEL);
            event.accept(PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL);
            event.accept(PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL_STAIRS);
            event.accept(PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL_SLAB);
            event.accept(PigsteelBlocks.WAXED_UNAFFECTED_REFINED_PIGSTEEL);
            event.accept(PigsteelBlocks.WAXED_UNAFFECTED_CUT_PIGSTEEL);
            event.accept(PigsteelBlocks.WAXED_UNAFFECTED_CUT_PIGSTEEL_STAIRS);
            event.accept(PigsteelBlocks.WAXED_UNAFFECTED_CUT_PIGSTEEL_SLAB);
            event.accept(PigsteelBlocks.WAXED_INFECTED_REFINED_PIGSTEEL);
            event.accept(PigsteelBlocks.WAXED_INFECTED_CUT_PIGSTEEL);
            event.accept(PigsteelBlocks.WAXED_INFECTED_CUT_PIGSTEEL_STAIRS);
            event.accept(PigsteelBlocks.WAXED_INFECTED_CUT_PIGSTEEL_SLAB);
            event.accept(PigsteelBlocks.WAXED_CORRUPTED_REFINED_PIGSTEEL);
            event.accept(PigsteelBlocks.WAXED_CORRUPTED_CUT_PIGSTEEL);
            event.accept(PigsteelBlocks.WAXED_CORRUPTED_CUT_PIGSTEEL_STAIRS);
            event.accept(PigsteelBlocks.WAXED_CORRUPTED_CUT_PIGSTEEL_SLAB);
            event.accept(PigsteelBlocks.WAXED_ZOMBIFIED_REFINED_PIGSTEEL);
            event.accept(PigsteelBlocks.WAXED_ZOMBIFIED_CUT_PIGSTEEL);
            event.accept(PigsteelBlocks.WAXED_ZOMBIFIED_CUT_PIGSTEEL_STAIRS);
            event.accept(PigsteelBlocks.WAXED_ZOMBIFIED_CUT_PIGSTEEL_SLAB);
        }
        if (tabKey == CreativeModeTabs.NATURAL_BLOCKS) {
            addBefore(Items.ANCIENT_DEBRIS, PigsteelBlocks.PORKSLAG, event);
            addAfter(Items.RAW_IRON_BLOCK, PigsteelBlocks.PIGSTEEL_CHUNK_BLOCK, event);
        }
        if (tabKey == CreativeModeTabs.INGREDIENTS) {
           addAfter(Items.RAW_IRON, PigsteelItems.PIGSTEEL_CHUNK, event);
        }
        if (tabKey == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            addAfter(Items.SOUL_LANTERN, PigsteelBlocks.WAXED_ZOMBIFIED_PIGSTEEL_SOUL_LANTERN, event);
            addAfter(Items.SOUL_LANTERN, PigsteelBlocks.WAXED_CORRUPTED_PIGSTEEL_SOUL_LANTERN, event);
            addAfter(Items.SOUL_LANTERN, PigsteelBlocks.WAXED_INFECTED_PIGSTEEL_SOUL_LANTERN, event);
            addAfter(Items.SOUL_LANTERN, PigsteelBlocks.WAXED_UNAFFECTED_PIGSTEEL_SOUL_LANTERN, event);
            addAfter(Items.SOUL_LANTERN, PigsteelBlocks.ZOMBIFIED_PIGSTEEL_SOUL_LANTERN, event);
            addAfter(Items.SOUL_LANTERN, PigsteelBlocks.CORRUPTED_PIGSTEEL_SOUL_LANTERN, event);
            addAfter(Items.SOUL_LANTERN, PigsteelBlocks.INFECTED_PIGSTEEL_SOUL_LANTERN, event);
            addAfter(Items.SOUL_LANTERN, PigsteelBlocks.UNAFFECTED_PIGSTEEL_SOUL_LANTERN, event);
            addAfter(Items.SOUL_LANTERN, PigsteelBlocks.WAXED_ZOMBIFIED_PIGSTEEL_LANTERN, event);
            addAfter(Items.SOUL_LANTERN, PigsteelBlocks.WAXED_CORRUPTED_PIGSTEEL_LANTERN, event);
            addAfter(Items.SOUL_LANTERN, PigsteelBlocks.WAXED_INFECTED_PIGSTEEL_LANTERN, event);
            addAfter(Items.SOUL_LANTERN, PigsteelBlocks.WAXED_UNAFFECTED_PIGSTEEL_LANTERN, event);
            addAfter(Items.SOUL_LANTERN, PigsteelBlocks.ZOMBIFIED_PIGSTEEL_LANTERN, event);
            addAfter(Items.SOUL_LANTERN, PigsteelBlocks.CORRUPTED_PIGSTEEL_LANTERN, event);
            addAfter(Items.SOUL_LANTERN, PigsteelBlocks.INFECTED_PIGSTEEL_LANTERN, event);
            addAfter(Items.SOUL_LANTERN, PigsteelBlocks.UNAFFECTED_PIGSTEEL_LANTERN, event);
        }
    }

    private static void addBefore(Item before, Supplier<? extends ItemLike> inputItem, BuildCreativeModeTabContentsEvent event) {
        event.insertBefore(before.getDefaultInstance(), inputItem.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    private static void addAfter(Item after, Supplier<? extends ItemLike> inputItem, BuildCreativeModeTabContentsEvent event) {
        event.insertAfter(after.getDefaultInstance(), inputItem.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }
}
