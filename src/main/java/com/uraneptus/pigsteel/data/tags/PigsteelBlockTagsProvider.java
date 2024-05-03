package com.uraneptus.pigsteel.data.tags;

import com.uraneptus.pigsteel.PigsteelMod;
import com.uraneptus.pigsteel.common.blocks.ZombifiableBlock;
import com.uraneptus.pigsteel.common.blocks.ZombifiableLanternBlock;
import com.uraneptus.pigsteel.core.other.tags.PigsteelBlockTags;
import com.uraneptus.pigsteel.core.registry.PigsteelBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class PigsteelBlockTagsProvider extends BlockTagsProvider {

    public PigsteelBlockTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> pProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, pProvider, PigsteelMod.MOD_ID, existingFileHelper);
    }

    @Override
    public void addTags(HolderLookup.Provider pProvider) {
        tag(PigsteelBlockTags.ZOMBIFICATION_DECELERATION)
                .add(Blocks.FIRE)
                .add(Blocks.SOUL_FIRE)
                .add(Blocks.CRIMSON_NYLIUM)
                .add(Blocks.CRIMSON_ROOTS)
                .add(Blocks.CRIMSON_FUNGUS)
                .add(Blocks.POTTED_CRIMSON_FUNGUS)
                .add(Blocks.POTTED_CRIMSON_ROOTS);

        tag(PigsteelBlockTags.ZOMBIFICATION_ACCELERATION)
                .add(Blocks.WARPED_NYLIUM)
                .add(Blocks.WARPED_ROOTS)
                .add(Blocks.WARPED_FUNGUS)
                .add(Blocks.POTTED_WARPED_FUNGUS)
                .add(Blocks.POTTED_WARPED_ROOTS);

        PigsteelBlocks.BLOCKS.getEntries().forEach(blockObject -> {
            Block block = blockObject.get();
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);

            if (block instanceof ZombifiableBlock) {
                tag(PigsteelBlockTags.PIGSTEEL_BLOCKS).add(block);
            }
            if (!(blockObject.getId().getPath().contains("refined") || block instanceof ZombifiableLanternBlock)) {
                tag(BlockTags.NEEDS_STONE_TOOL).add(block);
            }
            if (block.getDescriptionId().contains("soul")) {
                tag(BlockTags.PIGLIN_REPELLENTS).add(block);
            }
        });

        tag(PigsteelBlockTags.PIGSTEEL_ORES).add(PigsteelBlocks.PORKSLAG.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).addTag(PigsteelBlockTags.PIGSTEEL_BLOCKS).addTag(PigsteelBlockTags.PIGSTEEL_ORES);
        tag(BlockTags.BEACON_BASE_BLOCKS).addTag(PigsteelBlockTags.PIGSTEEL_BLOCKS);
        tag(Tags.Blocks.ORES).addTag(PigsteelBlockTags.PIGSTEEL_ORES);
    }
}
