package com.uraneptus.pigsteel.common.worldgen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.List;

public class OreSlagConfiguration extends OreConfiguration {
    public static final Codec<OreSlagConfiguration> CODEC = RecordCodecBuilder.create(
            p_67849_ -> p_67849_.group(

                            Codec.list(OreConfiguration.TargetBlockState.CODEC).fieldOf("slag_targets").forGetter(p_161027_ -> p_161027_.slagTargets),
                            Codec.intRange(1, 64).fieldOf("slag_count_max").forGetter(p_161020_ -> p_161020_.slagCountMax),
                            Codec.intRange(1, 64).fieldOf("slag_width_max").forGetter(p_161020_ -> p_161020_.slagWidthMax),
                            Codec.floatRange(0.0F, 1.0F).fieldOf("slag_chance").forGetter(p_161020_ -> p_161020_.slagChance),


                            Codec.list(OreConfiguration.TargetBlockState.CODEC).fieldOf("targets").forGetter(p_161027_ -> p_161027_.targetStates),
                            Codec.intRange(0, 64).fieldOf("size").forGetter(p_161025_ -> p_161025_.size),
                            Codec.floatRange(0.0F, 1.0F).fieldOf("discard_chance_on_air_exposure").forGetter(p_161020_ -> p_161020_.discardChanceOnAirExposure)
                            )
                    .apply(p_67849_, OreSlagConfiguration::new)
    );

    public final int slagCountMax;
    public final int slagWidthMax;
    public final float slagChance;
    public final List<OreConfiguration.TargetBlockState> slagTargets;

    public OreSlagConfiguration(List<TargetBlockState> slagTargets, int slagCountMax, int slagWidthMax, float slagChance, List<TargetBlockState> targetStates, int size, float discardChance) {
        super(targetStates, size, discardChance);
        this.slagCountMax = slagCountMax;
        this.slagWidthMax = slagWidthMax;
        this.slagTargets = slagTargets;
        this.slagChance = slagChance;
    }
}
