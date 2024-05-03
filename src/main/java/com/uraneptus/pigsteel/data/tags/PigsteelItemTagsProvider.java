package com.uraneptus.pigsteel.data.tags;

import com.uraneptus.pigsteel.PigsteelMod;
import com.uraneptus.pigsteel.core.other.tags.PigsteelItemTags;
import com.uraneptus.pigsteel.core.registry.PigsteelBlocks;
import com.uraneptus.pigsteel.core.registry.PigsteelItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unchecked")
public class PigsteelItemTagsProvider extends ItemTagsProvider {

    public PigsteelItemTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> pProvider, CompletableFuture<TagLookup<Block>> blockProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, pProvider, blockProvider, PigsteelMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(PigsteelItemTags.PIGSTEEL_ORES).add(PigsteelBlocks.PORKSLAG.get().asItem());
        tag(Tags.Items.ORES).addTag(PigsteelItemTags.PIGSTEEL_ORES);
        tag(ItemTags.TRIM_MATERIALS).add(PigsteelItems.PIGSTEEL_CHUNK.get());
    }
}
