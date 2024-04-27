package com.uraneptus.pigsteel.data.server;

import com.uraneptus.pigsteel.core.registry.PigsteelBlocks;
import com.uraneptus.pigsteel.core.registry.PigsteelItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.uraneptus.pigsteel.data.PigsteelDatagenUtil.*;

@SuppressWarnings("SameParameterValue")
public class PigsteelRecipeProvider extends RecipeProvider {

    public PigsteelRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        oreCookingRecipes(RecipeCategory.MISC, PigsteelBlocks.PORKSLAG, () -> Items.IRON_INGOT, 0.7F, consumer);
        oreCookingRecipes(RecipeCategory.MISC, PigsteelItems.PIGSTEEL_CHUNK, () -> Items.IRON_NUGGET, 0.7F, consumer);
        packableBlockRecipes(PigsteelItems.PIGSTEEL_CHUNK, PigsteelBlocks.PIGSTEEL_CHUNK_BLOCK, consumer);
        tilingBlockRecipes(PigsteelItems.PIGSTEEL_CHUNK, PigsteelBlocks.UNAFFECTED_REFINED_PIGSTEEL, consumer);
        refinedToCutVariants(PigsteelBlocks.UNAFFECTED_REFINED_PIGSTEEL, Optional.of(PigsteelBlocks.WAXED_UNAFFECTED_REFINED_PIGSTEEL), PigsteelBlocks.UNAFFECTED_CUT_PIGSTEEL, PigsteelBlocks.UNAFFECTED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.UNAFFECTED_CUT_PIGSTEEL_STAIRS, consumer);
        refinedToCutVariants(PigsteelBlocks.INFECTED_REFINED_PIGSTEEL, Optional.of(PigsteelBlocks.WAXED_INFECTED_REFINED_PIGSTEEL), PigsteelBlocks.INFECTED_CUT_PIGSTEEL, PigsteelBlocks.INFECTED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.INFECTED_CUT_PIGSTEEL_STAIRS, consumer);
        refinedToCutVariants(PigsteelBlocks.CORRUPTED_REFINED_PIGSTEEL, Optional.of(PigsteelBlocks.WAXED_CORRUPTED_REFINED_PIGSTEEL), PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL, PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL_STAIRS, consumer);
        refinedToCutVariants(PigsteelBlocks.ZOMBIFIED_REFINED_PIGSTEEL, Optional.of(PigsteelBlocks.WAXED_ZOMBIFIED_REFINED_PIGSTEEL), PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL, PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL_STAIRS, consumer);
        refinedToCutVariants(PigsteelBlocks.WAXED_UNAFFECTED_REFINED_PIGSTEEL, Optional.empty(), PigsteelBlocks.WAXED_UNAFFECTED_CUT_PIGSTEEL, PigsteelBlocks.WAXED_UNAFFECTED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.WAXED_UNAFFECTED_CUT_PIGSTEEL_STAIRS, consumer);
        refinedToCutVariants(PigsteelBlocks.WAXED_INFECTED_REFINED_PIGSTEEL, Optional.empty(), PigsteelBlocks.WAXED_INFECTED_CUT_PIGSTEEL, PigsteelBlocks.WAXED_INFECTED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.WAXED_INFECTED_CUT_PIGSTEEL_STAIRS, consumer);
        refinedToCutVariants(PigsteelBlocks.WAXED_CORRUPTED_REFINED_PIGSTEEL, Optional.empty(), PigsteelBlocks.WAXED_CORRUPTED_CUT_PIGSTEEL, PigsteelBlocks.WAXED_CORRUPTED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.WAXED_CORRUPTED_CUT_PIGSTEEL_STAIRS, consumer);
        refinedToCutVariants(PigsteelBlocks.WAXED_ZOMBIFIED_REFINED_PIGSTEEL, Optional.empty(), PigsteelBlocks.WAXED_ZOMBIFIED_CUT_PIGSTEEL, PigsteelBlocks.WAXED_ZOMBIFIED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.WAXED_ZOMBIFIED_CUT_PIGSTEEL_STAIRS, consumer);
        cutToVariants(PigsteelBlocks.UNAFFECTED_CUT_PIGSTEEL, Optional.of(PigsteelBlocks.WAXED_UNAFFECTED_CUT_PIGSTEEL), PigsteelBlocks.UNAFFECTED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.UNAFFECTED_CUT_PIGSTEEL_STAIRS, consumer);
        cutToVariants(PigsteelBlocks.INFECTED_CUT_PIGSTEEL, Optional.of(PigsteelBlocks.WAXED_INFECTED_CUT_PIGSTEEL), PigsteelBlocks.INFECTED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.INFECTED_CUT_PIGSTEEL_STAIRS, consumer);
        cutToVariants(PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL, Optional.of(PigsteelBlocks.WAXED_CORRUPTED_CUT_PIGSTEEL), PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL_STAIRS, consumer);
        cutToVariants(PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL, Optional.of(PigsteelBlocks.WAXED_ZOMBIFIED_CUT_PIGSTEEL), PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL_STAIRS, consumer);
        cutToVariants(PigsteelBlocks.WAXED_UNAFFECTED_CUT_PIGSTEEL, Optional.empty(), PigsteelBlocks.WAXED_UNAFFECTED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.WAXED_UNAFFECTED_CUT_PIGSTEEL_STAIRS, consumer);
        cutToVariants(PigsteelBlocks.WAXED_INFECTED_CUT_PIGSTEEL, Optional.empty(), PigsteelBlocks.WAXED_INFECTED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.WAXED_INFECTED_CUT_PIGSTEEL_STAIRS, consumer);
        cutToVariants(PigsteelBlocks.WAXED_CORRUPTED_CUT_PIGSTEEL, Optional.empty(), PigsteelBlocks.WAXED_CORRUPTED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.WAXED_CORRUPTED_CUT_PIGSTEEL_STAIRS, consumer);
        cutToVariants(PigsteelBlocks.WAXED_ZOMBIFIED_CUT_PIGSTEEL, Optional.empty(), PigsteelBlocks.WAXED_ZOMBIFIED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.WAXED_ZOMBIFIED_CUT_PIGSTEEL_STAIRS, consumer);
        waxRecipes(PigsteelBlocks.UNAFFECTED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.WAXED_UNAFFECTED_CUT_PIGSTEEL_SLAB, consumer);
        waxRecipes(PigsteelBlocks.UNAFFECTED_CUT_PIGSTEEL_STAIRS, PigsteelBlocks.WAXED_UNAFFECTED_CUT_PIGSTEEL_STAIRS, consumer);
        waxRecipes(PigsteelBlocks.INFECTED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.WAXED_INFECTED_CUT_PIGSTEEL_SLAB, consumer);
        waxRecipes(PigsteelBlocks.INFECTED_CUT_PIGSTEEL_STAIRS, PigsteelBlocks.WAXED_INFECTED_CUT_PIGSTEEL_STAIRS, consumer);
        waxRecipes(PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.WAXED_CORRUPTED_CUT_PIGSTEEL_SLAB, consumer);
        waxRecipes(PigsteelBlocks.CORRUPTED_CUT_PIGSTEEL_STAIRS, PigsteelBlocks.WAXED_CORRUPTED_CUT_PIGSTEEL_STAIRS, consumer);
        waxRecipes(PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL_SLAB, PigsteelBlocks.WAXED_ZOMBIFIED_CUT_PIGSTEEL_SLAB, consumer);
        waxRecipes(PigsteelBlocks.ZOMBIFIED_CUT_PIGSTEEL_STAIRS, PigsteelBlocks.WAXED_ZOMBIFIED_CUT_PIGSTEEL_STAIRS, consumer);
        lanternRecipes(() -> Items.TORCH, PigsteelBlocks.UNAFFECTED_PIGSTEEL_LANTERN, consumer);
        lanternRecipes(() -> Items.SOUL_TORCH, PigsteelBlocks.UNAFFECTED_PIGSTEEL_SOUL_LANTERN, consumer);
        waxRecipes(PigsteelBlocks.UNAFFECTED_PIGSTEEL_LANTERN, PigsteelBlocks.WAXED_UNAFFECTED_PIGSTEEL_LANTERN, consumer);
        waxRecipes(PigsteelBlocks.INFECTED_PIGSTEEL_LANTERN, PigsteelBlocks.WAXED_INFECTED_PIGSTEEL_LANTERN, consumer);
        waxRecipes(PigsteelBlocks.CORRUPTED_PIGSTEEL_LANTERN, PigsteelBlocks.WAXED_CORRUPTED_PIGSTEEL_LANTERN, consumer);
        waxRecipes(PigsteelBlocks.ZOMBIFIED_PIGSTEEL_LANTERN, PigsteelBlocks.WAXED_ZOMBIFIED_PIGSTEEL_LANTERN, consumer);
        waxRecipes(PigsteelBlocks.UNAFFECTED_PIGSTEEL_SOUL_LANTERN, PigsteelBlocks.WAXED_UNAFFECTED_PIGSTEEL_SOUL_LANTERN, consumer);
        waxRecipes(PigsteelBlocks.INFECTED_PIGSTEEL_SOUL_LANTERN, PigsteelBlocks.WAXED_INFECTED_PIGSTEEL_SOUL_LANTERN, consumer);
        waxRecipes(PigsteelBlocks.CORRUPTED_PIGSTEEL_SOUL_LANTERN, PigsteelBlocks.WAXED_CORRUPTED_PIGSTEEL_SOUL_LANTERN, consumer);
        waxRecipes(PigsteelBlocks.ZOMBIFIED_PIGSTEEL_SOUL_LANTERN, PigsteelBlocks.WAXED_ZOMBIFIED_PIGSTEEL_SOUL_LANTERN, consumer);
    }


    protected static void packableBlockRecipes(Supplier<? extends ItemLike> unpacked, Supplier<? extends ItemLike> packed, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, packed.get()).define('#', unpacked.get()).pattern("###").pattern("###").pattern("###")
                .unlockedBy(getHasName(unpacked.get()), has(unpacked.get())).save(consumer, craftingPath(getItemName(packed.get())));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, unpacked.get(), 9).requires(packed.get())
                .unlockedBy(getHasName(packed.get()), has(packed.get())).save(consumer, craftingPath(getItemName(unpacked.get())));
    }

    protected static void tilingBlockRecipes(Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result.get(), 4).define('#', ingredient.get()).pattern("##").pattern("##")
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer, craftingPath(getItemName(result.get())));
    }

    protected static void oreCookingRecipes(RecipeCategory category, Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, float experience, Consumer<FinishedRecipe> consumer) {
        String resultName = getItemName(result.get());
        String ingredientName = getItemName(ingredient.get());

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient.get()), category, result.get(), experience, 200)
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer, smeltingPath(resultName + "_from_smelting" + "_" + ingredientName));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ingredient.get()), category, result.get(), experience, 100)
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer, blastingPath(resultName + "_from_blasting" + "_" + ingredientName));
    }

    protected static void stairRecipes(Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result.get(), 4).define('#', ingredient.get()).pattern("#  ").pattern("## ").pattern("###")
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer, craftingPath(getItemName(result.get())));
    }

    protected static void slabRecipes(Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result.get(), 6).define('#', ingredient.get()).pattern("###")
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer, craftingPath(getItemName(result.get())));
    }

    protected static void waxRecipes(Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, result.get()).requires(ingredient.get()).requires(Items.HONEYCOMB)
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer, craftingPath(getItemName(result.get()) + "_from_honeycomb"));
    }

    protected static void stonecutterRecipes(Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, int resultCount, Consumer<FinishedRecipe> consumer) {
        String prefix = getItemName(result.get()) + "_from_" + getItemName(ingredient.get());
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient.get()), RecipeCategory.BUILDING_BLOCKS, result.get(), resultCount)
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer, stonecuttingPath(prefix + "_stonecutting"));
    }

    protected static void lanternRecipes(Supplier<? extends ItemLike> torch, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result.get()).define('#', PigsteelItems.PIGSTEEL_CHUNK.get()).define('X', torch.get())
                .pattern("###").pattern("#X#").pattern("###").unlockedBy(getHasName(PigsteelItems.PIGSTEEL_CHUNK.get()), has(PigsteelItems.PIGSTEEL_CHUNK.get()))
                .save(consumer, craftingPath(getItemName(result.get())));
    }

    protected static void refinedToCutVariants(Supplier<? extends ItemLike> refined, Optional<Supplier<? extends ItemLike>> optionalWaxed, Supplier<? extends ItemLike> cut, Supplier<? extends ItemLike> cutSlab, Supplier<? extends ItemLike> cutStair, Consumer<FinishedRecipe> consumer) {
        tilingBlockRecipes(refined, cut, consumer);
        stonecutterRecipes(refined, cut, 4, consumer);
        stonecutterRecipes(refined, cutSlab, 8, consumer);
        stonecutterRecipes(refined, cutStair, 4, consumer);
        optionalWaxed.ifPresent(waxed -> {
            waxRecipes(refined, waxed, consumer);
        });

    }

    protected static void cutToVariants(Supplier<? extends ItemLike> cut, Optional<Supplier<? extends ItemLike>> optionalWaxed, Supplier<? extends ItemLike> cutSlab, Supplier<? extends ItemLike> cutStair, Consumer<FinishedRecipe> consumer) {
        stonecutterRecipes(cut, cutSlab, 2, consumer);
        stonecutterRecipes(cut, cutStair, 1, consumer);
        stairRecipes(cut, cutStair, consumer);
        slabRecipes(cut, cutSlab, consumer);
        optionalWaxed.ifPresent(waxed -> {
            waxRecipes(cut, waxed, consumer);
        });

    }
}
