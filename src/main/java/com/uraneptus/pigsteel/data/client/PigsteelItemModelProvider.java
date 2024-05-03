package com.uraneptus.pigsteel.data.client;

import com.uraneptus.pigsteel.PigsteelMod;
import com.uraneptus.pigsteel.core.registry.PigsteelBlocks;
import com.uraneptus.pigsteel.core.registry.PigsteelItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

import static com.uraneptus.pigsteel.data.PigsteelDatagenUtil.*;

@SuppressWarnings({"unused", "SameParameterValue"})
public class PigsteelItemModelProvider extends ItemModelProvider {

    public PigsteelItemModelProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, PigsteelMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(PigsteelItems.PIGSTEEL_CHUNK);
        basicBlockItem(PigsteelBlocks.PORKSLAG);
        basicBlockItem(PigsteelBlocks.PIGSTEEL_CHUNK_BLOCK);
        basicBlockItem(PigsteelBlocks.UNAFFECTED_REFINED_PIGSTEEL);
        basicBlockItem(PigsteelBlocks.INFECTED_REFINED_PIGSTEEL);
        basicBlockItem(PigsteelBlocks.CORRUPTED_REFINED_PIGSTEEL);
        basicBlockItem(PigsteelBlocks.ZOMBIFIED_REFINED_PIGSTEEL);
        basicBlockItem(PigsteelBlocks.WAXED_UNAFFECTED_REFINED_PIGSTEEL);
        basicBlockItem(PigsteelBlocks.WAXED_INFECTED_REFINED_PIGSTEEL);
        basicBlockItem(PigsteelBlocks.WAXED_CORRUPTED_REFINED_PIGSTEEL);
        basicBlockItem(PigsteelBlocks.WAXED_ZOMBIFIED_REFINED_PIGSTEEL);
        basicBlockItem(PigsteelBlocks.UNAFFECTED_CUT_PIGSTEEL);
        basicBlockItem(PigsteelBlocks.INFECTED_CUT_PIGSTEEL);
        basicBlockItem(PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL);
        basicBlockItem(PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL);
        basicBlockItem(PigsteelBlocks.WAXED_UNAFFECTED_CUT_PIGSTEEL);
        basicBlockItem(PigsteelBlocks.WAXED_INFECTED_CUT_PIGSTEEL);
        basicBlockItem(PigsteelBlocks.WAXED_CORRUPTED_CUT_PIGSTEEL);
        basicBlockItem(PigsteelBlocks.WAXED_ZOMBIFIED_CUT_PIGSTEEL);
        basicBlockItem(PigsteelBlocks.UNAFFECTED_CUT_PIGSTEEL_STAIRS);
        basicBlockItem(PigsteelBlocks.INFECTED_CUT_PIGSTEEL_STAIRS);
        basicBlockItem(PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL_STAIRS);
        basicBlockItem(PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL_STAIRS);
        basicBlockItem(PigsteelBlocks.WAXED_UNAFFECTED_CUT_PIGSTEEL_STAIRS);
        basicBlockItem(PigsteelBlocks.WAXED_INFECTED_CUT_PIGSTEEL_STAIRS);
        basicBlockItem(PigsteelBlocks.WAXED_CORRUPTED_CUT_PIGSTEEL_STAIRS);
        basicBlockItem(PigsteelBlocks.WAXED_ZOMBIFIED_CUT_PIGSTEEL_STAIRS);
        basicBlockItem(PigsteelBlocks.UNAFFECTED_CUT_PIGSTEEL_SLAB);
        basicBlockItem(PigsteelBlocks.INFECTED_CUT_PIGSTEEL_SLAB);
        basicBlockItem(PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL_SLAB);
        basicBlockItem(PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL_SLAB);
        basicBlockItem(PigsteelBlocks.WAXED_UNAFFECTED_CUT_PIGSTEEL_SLAB);
        basicBlockItem(PigsteelBlocks.WAXED_INFECTED_CUT_PIGSTEEL_SLAB);
        basicBlockItem(PigsteelBlocks.WAXED_CORRUPTED_CUT_PIGSTEEL_SLAB);
        basicBlockItem(PigsteelBlocks.WAXED_ZOMBIFIED_CUT_PIGSTEEL_SLAB);
        blockItemWithItemTexture(PigsteelBlocks.UNAFFECTED_PIGSTEEL_LANTERN);
        blockItemWithItemTexture(PigsteelBlocks.INFECTED_PIGSTEEL_LANTERN);
        blockItemWithItemTexture(PigsteelBlocks.CORRUPTED_PIGSTEEL_LANTERN);
        blockItemWithItemTexture(PigsteelBlocks.ZOMBIFIED_PIGSTEEL_LANTERN);
        blockItemWithDiffItemTexture(PigsteelBlocks.WAXED_UNAFFECTED_PIGSTEEL_LANTERN, PigsteelBlocks.UNAFFECTED_PIGSTEEL_LANTERN);
        blockItemWithDiffItemTexture(PigsteelBlocks.WAXED_INFECTED_PIGSTEEL_LANTERN, PigsteelBlocks.INFECTED_PIGSTEEL_LANTERN);
        blockItemWithDiffItemTexture(PigsteelBlocks.WAXED_CORRUPTED_PIGSTEEL_LANTERN, PigsteelBlocks.CORRUPTED_PIGSTEEL_LANTERN);
        blockItemWithDiffItemTexture(PigsteelBlocks.WAXED_ZOMBIFIED_PIGSTEEL_LANTERN, PigsteelBlocks.ZOMBIFIED_PIGSTEEL_LANTERN);
        blockItemWithItemTexture(PigsteelBlocks.UNAFFECTED_PIGSTEEL_SOUL_LANTERN);
        blockItemWithItemTexture(PigsteelBlocks.INFECTED_PIGSTEEL_SOUL_LANTERN);
        blockItemWithItemTexture(PigsteelBlocks.CORRUPTED_PIGSTEEL_SOUL_LANTERN);
        blockItemWithItemTexture(PigsteelBlocks.ZOMBIFIED_PIGSTEEL_SOUL_LANTERN);
        blockItemWithDiffItemTexture(PigsteelBlocks.WAXED_UNAFFECTED_PIGSTEEL_SOUL_LANTERN, PigsteelBlocks.UNAFFECTED_PIGSTEEL_SOUL_LANTERN);
        blockItemWithDiffItemTexture(PigsteelBlocks.WAXED_INFECTED_PIGSTEEL_SOUL_LANTERN, PigsteelBlocks.INFECTED_PIGSTEEL_SOUL_LANTERN);
        blockItemWithDiffItemTexture(PigsteelBlocks.WAXED_CORRUPTED_PIGSTEEL_SOUL_LANTERN, PigsteelBlocks.CORRUPTED_PIGSTEEL_SOUL_LANTERN);
        blockItemWithDiffItemTexture(PigsteelBlocks.WAXED_ZOMBIFIED_PIGSTEEL_SOUL_LANTERN, PigsteelBlocks.ZOMBIFIED_PIGSTEEL_SOUL_LANTERN);
    }

    private void basicBlockItem(Supplier<? extends Block> blockForItem) {
        withExistingParent(name(blockForItem.get()), modBlockLocation(name(blockForItem.get())));
    }

    private void basicItem(Supplier<? extends Item> item) {
        basicItem(item.get());
    }

    private void basicItemHandheld(Supplier<? extends Item> item) {
        withExistingParent(name(item.get()), HANDHELD)
                .texture(LAYER0, modItemLocation(name(item.get())));
    }

    private void blockItemWithItemTexture(Supplier<? extends Block> blockForItem) {
        basicItem(blockForItem.get().asItem());
    }

    private void blockItemWithDiffItemTexture(Supplier<? extends Block> block, Supplier<? extends Block> blockForTexture) {
        withExistingParent(name(block.get()), GENERATED)
                .texture(LAYER0, modItemLocation(name(blockForTexture.get())));
    }

}
