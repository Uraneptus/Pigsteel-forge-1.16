package com.uraneptus.pigsteel.common.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class ScatteredSlagOreFeature extends Feature<OreSlagConfiguration> {
    public ScatteredSlagOreFeature(Codec<OreSlagConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<OreSlagConfiguration> context) {
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        OreSlagConfiguration config = context.config();
        BlockPos blockpos = context.origin();
        int i = random.nextInt(config.size + 1);
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

        for (int j = 0; j < i; j++) {
            this.offsetTargetPos(mutableBlockPos, random, blockpos, Math.min(j, 7));
            BlockState blockstate = level.getBlockState(mutableBlockPos);

            for (OreSlagConfiguration.TargetBlockState oreconfiguration$targetblockstate : config.targetStates) {
                if (OreFeature.canPlaceOre(blockstate, level::getBlockState, random, config, oreconfiguration$targetblockstate, mutableBlockPos)) {
                    level.setBlock(mutableBlockPos, oreconfiguration$targetblockstate.state, 2);
                    if (random.nextFloat() < config.slagChance){
                        generateSlag(context, mutableBlockPos);
                    }
                    break;
                }
            }
        }

        return true;
    }

    public void generateSlag(FeaturePlaceContext<OreSlagConfiguration> context, BlockPos orePos){
        OreSlagConfiguration config = context.config();
        RandomSource random = context.random();
        WorldGenLevel world = context.level();

        for (int l = 0; l < random.nextIntBetweenInclusive(1, config.slagCountMax); l++) {
            int i = random.nextIntBetweenInclusive(1, config.slagWidthMax);
            int j = random.nextIntBetweenInclusive(1, config.slagWidthMax);
            int k = random.nextIntBetweenInclusive(1, config.slagWidthMax);
            float f = (float)(i + j + k) * 0.333F + 0.5F;

            for (BlockPos currentPos : BlockPos.betweenClosed(orePos.offset(-i, -j, -k), orePos.offset(i, j, k))) {
                if (currentPos.distSqr(orePos) <= (double)(f * f)) {
                    for (OreConfiguration.TargetBlockState target : config.slagTargets) {
                        if (target.target.test(world.getBlockState(currentPos), random)){
                            world.setBlock(currentPos, target.state, 3);
                        }
                    }
                }
            }

            orePos = orePos.offset(-1 + random.nextInt(2), -random.nextInt(2), -1 + random.nextInt(2));
        }
    }

    private void offsetTargetPos(BlockPos.MutableBlockPos pMutablePos, RandomSource pRandom, BlockPos pPos, int pMagnitude) {
        int i = this.getRandomPlacementInOneAxisRelativeToOrigin(pRandom, pMagnitude);
        int j = this.getRandomPlacementInOneAxisRelativeToOrigin(pRandom, pMagnitude);
        int k = this.getRandomPlacementInOneAxisRelativeToOrigin(pRandom, pMagnitude);
        pMutablePos.setWithOffset(pPos, i, j, k);
    }

    private int getRandomPlacementInOneAxisRelativeToOrigin(RandomSource pRandom, int pMagnitude) {
        return Math.round((pRandom.nextFloat() - pRandom.nextFloat()) * (float)pMagnitude);
    }
}
