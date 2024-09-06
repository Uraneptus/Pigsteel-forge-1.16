package com.uraneptus.pigsteel.data.tags;

import com.uraneptus.pigsteel.PigsteelMod;
import com.uraneptus.pigsteel.core.other.tags.PigsteelBiomeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.internal.NeoForgeBiomeTagsProvider;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class PigsteelBiomeTagsProvider extends BiomeTagsProvider {
    public PigsteelBiomeTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> pProvider, @Nullable ExistingFileHelper fileHelper) {
        super(packOutput, pProvider, PigsteelMod.MOD_ID, fileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(PigsteelBiomeTags.HAS_EXTRA_PIGSTEEL).add(Biomes.BASALT_DELTAS);
        tag(PigsteelBiomeTags.PIGSTEEL_GENERATE_IN).addTag(Tags.Biomes.IS_NETHER);
    }
}
