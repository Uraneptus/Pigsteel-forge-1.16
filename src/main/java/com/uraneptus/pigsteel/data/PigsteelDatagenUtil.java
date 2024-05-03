package com.uraneptus.pigsteel.data;

import com.uraneptus.pigsteel.PigsteelMod;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.client.model.generators.ModelProvider;

import java.util.List;

@SuppressWarnings("unused")
public class PigsteelDatagenUtil {
    public static final String LAYER0 = "layer0";
    public static final ResourceLocation GENERATED = vanillaItemLocation("generated");
    public static final ResourceLocation HANDHELD = vanillaItemLocation("handheld");

    @SafeVarargs
    public static HolderSet<PlacedFeature> getPlacedHolderSet(BootstrapContext<?> context, ResourceKey<PlacedFeature>... placedFeatures) {
        List<Holder<PlacedFeature>> holders = new ObjectArrayList<>();
        for (ResourceKey<PlacedFeature> feature : placedFeatures) {
            holders.add(context.lookup(Registries.PLACED_FEATURE).getOrThrow(feature));
        }
        return HolderSet.direct(holders);
    }

    public static String name(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).getPath();
    }

    public static String name(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).getPath();
    }

    public static ResourceLocation modBlockLocation(String path) {
        return PigsteelMod.modPrefix(ModelProvider.BLOCK_FOLDER + "/" + path);
    }

    public static ResourceLocation modItemLocation(String path) {
        return PigsteelMod.modPrefix(ModelProvider.ITEM_FOLDER + "/" + path);
    }

    public static ResourceLocation vanillaBlockLocation(String path) {
        return new ResourceLocation(ModelProvider.BLOCK_FOLDER + "/" + path);
    }

    public static ResourceLocation vanillaItemLocation(String path) {
        return new ResourceLocation(ModelProvider.ITEM_FOLDER + "/" + path);
    }

    public static ResourceLocation craftingPath(String name) {
        return PigsteelMod.modPrefix("crafting/" + name);
    }

    public static ResourceLocation smeltingPath(String name) {
        return PigsteelMod.modPrefix("smelting/" + name);
    }

    public static ResourceLocation blastingPath(String name) {
        return PigsteelMod.modPrefix("blasting/" + name);
    }

    public static ResourceLocation smokingPath(String name) {
        return PigsteelMod.modPrefix("smoking/" + name);
    }

    public static ResourceLocation campfire_cookingPath(String name) {
        return PigsteelMod.modPrefix("campfire_cooking/" + name);
    }

    public static ResourceLocation stonecuttingPath(String name) {
        return PigsteelMod.modPrefix("stonecutting/" + name);
    }

    public static ResourceLocation smithingPath(String name) {
        return PigsteelMod.modPrefix("smithing/" + name);
    }
}