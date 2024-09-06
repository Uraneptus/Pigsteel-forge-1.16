package com.uraneptus.pigsteel.data.server;

import com.uraneptus.pigsteel.PigsteelMod;
import com.uraneptus.pigsteel.core.other.tags.PigsteelBiomeTags;
import com.uraneptus.pigsteel.core.registry.PigsteelBlocks;
import com.uraneptus.pigsteel.data.PigsteelDatagenUtil;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class PigsteelDatapackBuiltinEntriesProvider extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder SET_BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ConfiguredFeatures::create)
            .add(Registries.PLACED_FEATURE, PlacedFeatures::create)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, PBiomeModifiers::create);

    public PigsteelDatapackBuiltinEntriesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, SET_BUILDER, Set.of(PigsteelMod.MOD_ID));
    }

    public static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_PIGSTEEL_ORE = ResourceKey.create(Registries.CONFIGURED_FEATURE, PigsteelMod.modPrefix("pigsteel_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_PIGSTEEL_ORE_EXTRA = ResourceKey.create(Registries.CONFIGURED_FEATURE, PigsteelMod.modPrefix("pigsteel_ore_extra"));
    public static final ResourceKey<PlacedFeature> PLACED_PIGSTEEL_ORE = ResourceKey.create(Registries.PLACED_FEATURE, PigsteelMod.modPrefix("pigsteel_ore"));
    public static final ResourceKey<PlacedFeature> PLACED_PIGSTEEL_ORE_EXTRA = ResourceKey.create(Registries.PLACED_FEATURE, PigsteelMod.modPrefix("pigsteel_ore_extra"));

    private static class ConfiguredFeatures {

        public static void create(BootstrapContext<ConfiguredFeature<?, ?>> context) {
            register(context, PigsteelDatapackBuiltinEntriesProvider.CONFIGURED_PIGSTEEL_ORE, () -> addPigsteelOreConfig(5, 0.5F));
            register(context, PigsteelDatapackBuiltinEntriesProvider.CONFIGURED_PIGSTEEL_ORE_EXTRA, () -> addPigsteelOreConfig(9, 0.0F));
        }

        private static ConfiguredFeature<?, ?> addPigsteelOreConfig(int veinSize, float discardChanceOnAirExposure) {
            return new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.BASE_STONE_NETHER), PigsteelBlocks.PORKSLAG.get().defaultBlockState(), veinSize, discardChanceOnAirExposure));
        }

        private static void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> featureKey, Supplier<? extends ConfiguredFeature<?, ?>> feature) {
            context.register(featureKey, feature.get());
        }
    }

    private static class PlacedFeatures {
        public static void create(BootstrapContext<PlacedFeature> context) {
            register(context, PigsteelDatapackBuiltinEntriesProvider.PLACED_PIGSTEEL_ORE, addOreFeature(context, PigsteelDatapackBuiltinEntriesProvider.CONFIGURED_PIGSTEEL_ORE, 0, 128, 12));
            register(context, PigsteelDatapackBuiltinEntriesProvider.PLACED_PIGSTEEL_ORE_EXTRA, addOreFeature(context, PigsteelDatapackBuiltinEntriesProvider.CONFIGURED_PIGSTEEL_ORE_EXTRA, 0, 128, 14));

        }

        private static PlacedFeature addOreFeature(BootstrapContext<PlacedFeature> context, ResourceKey<ConfiguredFeature<?, ?>> configureFeature, int minHeight, int maxHeight, int count) {
            return addFeaturePlacement(context.lookup(Registries.CONFIGURED_FEATURE).get(configureFeature).orElseThrow(), HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)), CountPlacement.of(count), InSquarePlacement.spread(), BiomeFilter.biome());
        }

        private static PlacedFeature addFeaturePlacement(Holder<ConfiguredFeature<?, ?>> configureFeature, PlacementModifier... placementModifiers) {
            return new PlacedFeature(configureFeature, List.of(placementModifiers));
        }

        private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> featureKey, PlacedFeature feature) {
            context.register(featureKey, feature);
        }
    }

    private static class PBiomeModifiers {
        public static void create(BootstrapContext<BiomeModifier> context) {
            register(context, "pigsteel_ore", () -> addFeatureModifier(context, PigsteelDatagenUtil.getPlacedHolderSet(context, PigsteelDatapackBuiltinEntriesProvider.PLACED_PIGSTEEL_ORE), PigsteelBiomeTags.PIGSTEEL_GENERATE_IN, GenerationStep.Decoration.UNDERGROUND_ORES));
            register(context, "pigsteel_ore_extra", () -> addFeatureModifier(context, PigsteelDatagenUtil.getPlacedHolderSet(context, PigsteelDatapackBuiltinEntriesProvider.PLACED_PIGSTEEL_ORE_EXTRA), PigsteelBiomeTags.HAS_EXTRA_PIGSTEEL, GenerationStep.Decoration.UNDERGROUND_ORES));
        }

        private static BiomeModifiers.AddFeaturesBiomeModifier addFeatureModifier(BootstrapContext<BiomeModifier> context, HolderSet<PlacedFeature> placedSet, TagKey<Biome> biomeTag, GenerationStep.Decoration decoration) {
            return new BiomeModifiers.AddFeaturesBiomeModifier(context.lookup(Registries.BIOME).getOrThrow(biomeTag), placedSet, decoration);
        }

        private static BiomeModifiers.AddSpawnsBiomeModifier addSingleSpawnModifier(BootstrapContext<BiomeModifier> context, TagKey<Biome> biomeTag, EntityType<?> entity, int weight, int minCount, int maxCount) {
            return BiomeModifiers.AddSpawnsBiomeModifier.singleSpawn(context.lookup(Registries.BIOME).getOrThrow(biomeTag), new MobSpawnSettings.SpawnerData(entity, weight, minCount, maxCount));
        }

        private static void register(BootstrapContext<BiomeModifier> context, String name, Supplier<? extends BiomeModifier> modifier) {
            context.register(ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, PigsteelMod.modPrefix(name)), modifier.get());
        }
    }
}
