package com.uraneptus.pigsteel.data.client;

import com.uraneptus.pigsteel.PigsteelMod;
import com.uraneptus.pigsteel.core.registry.PigsteelBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

import static com.uraneptus.pigsteel.data.PigsteelDatagenUtil.modBlockLocation;
import static com.uraneptus.pigsteel.data.PigsteelDatagenUtil.name;

@SuppressWarnings("SameParameterValue")
public class PigsteelBlockStateProvider extends BlockStateProvider {
    public PigsteelBlockStateProvider(PackOutput packOutput, ExistingFileHelper exFileHelper) {
        super(packOutput, PigsteelMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        porkSlagBlock(PigsteelBlocks.PORKSLAG);
        basicBlock(PigsteelBlocks.PIGSTEEL_CHUNK_BLOCK);
        basicBlock(PigsteelBlocks.UNAFFECTED_REFINED_PIGSTEEL);
        basicBlock(PigsteelBlocks.INFECTED_REFINED_PIGSTEEL);
        basicBlock(PigsteelBlocks.CORRUPTED_REFINED_PIGSTEEL);
        basicBlock(PigsteelBlocks.ZOMBIFIED_REFINED_PIGSTEEL);
        basicBlockWithTextureOf(PigsteelBlocks.WAXED_UNAFFECTED_REFINED_PIGSTEEL, PigsteelBlocks.UNAFFECTED_REFINED_PIGSTEEL);
        basicBlockWithTextureOf(PigsteelBlocks.WAXED_INFECTED_REFINED_PIGSTEEL, PigsteelBlocks.INFECTED_REFINED_PIGSTEEL);
        basicBlockWithTextureOf(PigsteelBlocks.WAXED_CORRUPTED_REFINED_PIGSTEEL, PigsteelBlocks.CORRUPTED_REFINED_PIGSTEEL);
        basicBlockWithTextureOf(PigsteelBlocks.WAXED_ZOMBIFIED_REFINED_PIGSTEEL, PigsteelBlocks.ZOMBIFIED_REFINED_PIGSTEEL);
        basicBlock(PigsteelBlocks.UNAFFECTED_CUT_PIGSTEEL);
        basicBlock(PigsteelBlocks.INFECTED_CUT_PIGSTEEL);
        basicBlock(PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL);
        basicBlock(PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL);
        basicBlockWithTextureOf(PigsteelBlocks.WAXED_UNAFFECTED_CUT_PIGSTEEL, PigsteelBlocks.UNAFFECTED_CUT_PIGSTEEL);
        basicBlockWithTextureOf(PigsteelBlocks.WAXED_INFECTED_CUT_PIGSTEEL, PigsteelBlocks.INFECTED_CUT_PIGSTEEL);
        basicBlockWithTextureOf(PigsteelBlocks.WAXED_CORRUPTED_CUT_PIGSTEEL, PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL);
        basicBlockWithTextureOf(PigsteelBlocks.WAXED_ZOMBIFIED_CUT_PIGSTEEL, PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL);
        modStairsBlock(PigsteelBlocks.UNAFFECTED_CUT_PIGSTEEL_STAIRS, PigsteelBlocks.UNAFFECTED_CUT_PIGSTEEL);
        modStairsBlock(PigsteelBlocks.INFECTED_CUT_PIGSTEEL_STAIRS, PigsteelBlocks.INFECTED_CUT_PIGSTEEL);
        modStairsBlock(PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL_STAIRS, PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL);
        modStairsBlock(PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL_STAIRS, PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL);
        modStairsBlock(PigsteelBlocks.WAXED_UNAFFECTED_CUT_PIGSTEEL_STAIRS, PigsteelBlocks.UNAFFECTED_CUT_PIGSTEEL);
        modStairsBlock(PigsteelBlocks.WAXED_INFECTED_CUT_PIGSTEEL_STAIRS, PigsteelBlocks.INFECTED_CUT_PIGSTEEL);
        modStairsBlock(PigsteelBlocks.WAXED_CORRUPTED_CUT_PIGSTEEL_STAIRS, PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL);
        modStairsBlock(PigsteelBlocks.WAXED_ZOMBIFIED_CUT_PIGSTEEL_STAIRS, PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL);
        modSlabBlock(PigsteelBlocks.UNAFFECTED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.UNAFFECTED_CUT_PIGSTEEL);
        modSlabBlock(PigsteelBlocks.INFECTED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.INFECTED_CUT_PIGSTEEL);
        modSlabBlock(PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL);
        modSlabBlock(PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL);
        modSlabBlock(PigsteelBlocks.WAXED_UNAFFECTED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.UNAFFECTED_CUT_PIGSTEEL);
        modSlabBlock(PigsteelBlocks.WAXED_INFECTED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.INFECTED_CUT_PIGSTEEL);
        modSlabBlock(PigsteelBlocks.WAXED_CORRUPTED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL);
        modSlabBlock(PigsteelBlocks.WAXED_ZOMBIFIED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL);
        pigsteelLanternBlock(PigsteelBlocks.UNAFFECTED_PIGSTEEL_LANTERN);
        pigsteelLanternBlock(PigsteelBlocks.INFECTED_PIGSTEEL_LANTERN);
        pigsteelLanternBlock(PigsteelBlocks.CORRUPTED_PIGSTEEL_LANTERN);
        pigsteelLanternBlock(PigsteelBlocks.ZOMBIFIED_PIGSTEEL_LANTERN);
        pigsteelLanternBlock(PigsteelBlocks.WAXED_UNAFFECTED_PIGSTEEL_LANTERN, PigsteelBlocks.UNAFFECTED_PIGSTEEL_LANTERN);
        pigsteelLanternBlock(PigsteelBlocks.WAXED_INFECTED_PIGSTEEL_LANTERN, PigsteelBlocks.INFECTED_PIGSTEEL_LANTERN);
        pigsteelLanternBlock(PigsteelBlocks.WAXED_CORRUPTED_PIGSTEEL_LANTERN, PigsteelBlocks.CORRUPTED_PIGSTEEL_LANTERN);
        pigsteelLanternBlock(PigsteelBlocks.WAXED_ZOMBIFIED_PIGSTEEL_LANTERN, PigsteelBlocks.ZOMBIFIED_PIGSTEEL_LANTERN);
        pigsteelLanternBlock(PigsteelBlocks.UNAFFECTED_PIGSTEEL_SOUL_LANTERN);
        pigsteelLanternBlock(PigsteelBlocks.INFECTED_PIGSTEEL_SOUL_LANTERN);
        pigsteelLanternBlock(PigsteelBlocks.CORRUPTED_PIGSTEEL_SOUL_LANTERN);
        pigsteelLanternBlock(PigsteelBlocks.ZOMBIFIED_PIGSTEEL_SOUL_LANTERN);
        pigsteelLanternBlock(PigsteelBlocks.WAXED_UNAFFECTED_PIGSTEEL_SOUL_LANTERN, PigsteelBlocks.UNAFFECTED_PIGSTEEL_SOUL_LANTERN);
        pigsteelLanternBlock(PigsteelBlocks.WAXED_INFECTED_PIGSTEEL_SOUL_LANTERN, PigsteelBlocks.INFECTED_PIGSTEEL_SOUL_LANTERN);
        pigsteelLanternBlock(PigsteelBlocks.WAXED_CORRUPTED_PIGSTEEL_SOUL_LANTERN, PigsteelBlocks.CORRUPTED_PIGSTEEL_SOUL_LANTERN);
        pigsteelLanternBlock(PigsteelBlocks.WAXED_ZOMBIFIED_PIGSTEEL_SOUL_LANTERN, PigsteelBlocks.ZOMBIFIED_PIGSTEEL_SOUL_LANTERN);
    }

    private void basicBlock(Supplier<? extends Block> block) {
        simpleBlock(block.get());
    }

    private void basicBlockWithTextureOf(Supplier<? extends Block> block, Supplier<? extends Block> blockForTexture) {
        this.getVariantBuilder(block.get()).forAllStates(blockState -> ConfiguredModel.builder().modelFile(models().cubeAll(name(block.get()), modBlockLocation(name(blockForTexture.get())))).build());
    }

    private void porkSlagBlock(Supplier<? extends Block> block) {
        this.getVariantBuilder(block.get()).forAllStates(blockState -> ConfiguredModel.builder().modelFile(
                models().cubeColumn(name(block.get()), modBlockLocation(name(block.get())), modBlockLocation(name(block.get()) + "_top"))).build());
    }

    private void modStairsBlock(Supplier<? extends Block> block, Supplier<? extends Block> blockForTexture) {
        stairsBlock((StairBlock) block.get(), blockTexture(blockForTexture.get()));
    }

    private void modSlabBlock(Supplier<? extends Block> block, Supplier<? extends Block> blockForTexture) {
        slabBlock((SlabBlock) block.get(), blockTexture(blockForTexture.get()), blockTexture(blockForTexture.get()));
    }

    private void pigsteelLanternBlock(Supplier<? extends Block> block) {
        ModelFile file = models().withExistingParent(name(block.get()), modBlockLocation("template_pigsteel_lantern"))
                .texture("all", modBlockLocation(name(block.get()))).renderType("cutout");

        getVariantBuilder(block.get()).forAllStatesExcept(blockState -> ConfiguredModel.builder()
                .modelFile(file).rotationY(((int) blockState.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 180) % 360)
                .build(), BlockStateProperties.WATERLOGGED);
    }

    private void pigsteelLanternBlock(Supplier<? extends Block> block, Supplier<? extends Block> blockForTexture) {
        ModelFile file = models().withExistingParent(name(block.get()), modBlockLocation("template_pigsteel_lantern"))
                .texture("all", modBlockLocation(name(blockForTexture.get()))).renderType("cutout");

        getVariantBuilder(block.get()).forAllStatesExcept(blockState -> ConfiguredModel.builder()
                .modelFile(file).rotationY(((int) blockState.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 180) % 360)
                .build(), BlockStateProperties.WATERLOGGED);
    }
}
