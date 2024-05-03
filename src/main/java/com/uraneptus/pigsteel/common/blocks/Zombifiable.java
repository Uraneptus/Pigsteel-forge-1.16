package com.uraneptus.pigsteel.common.blocks;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.uraneptus.pigsteel.core.other.tags.PigsteelBlockTags;
import com.uraneptus.pigsteel.core.registry.PigsteelBlocks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Optional;
import java.util.function.Supplier;

public interface Zombifiable extends ChangeOverTimeBlock<Zombifiable.ZombificationLevel> {
    Supplier<BiMap<Block, Block>> PREVIOUS_BY_BLOCK = Suppliers.memoize(() -> PigsteelBlocks.NEXT_BY_BLOCK.get().inverse());
    Supplier<BiMap<Block, Block>> PREVIOUS_WAXED_BY_BLOCK = Suppliers.memoize(() -> PigsteelBlocks.NEXT_WAXED_BY_BLOCK.get().inverse());
    float blockInfluence = 0.1F;
    float baseChance = 0.9F;

    default boolean canZombify(Level world, BlockState state) {
        return !world.dimensionType().ultraWarm() && getNext(state).isPresent();
    }

    @Override
    default Optional<BlockState> getNextState(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        float chance = baseChance;
        if (canZombify(pLevel, pState) && pLevel.getRandom().nextInt(9) < 2) {
            chance *= this.getChanceModifier();

            for (BlockPos blockPos : BlockPos.betweenClosed(pPos.offset(-1, -1, -1), pPos.offset(1, 1, 1))) {
                /*
                    Slow down or speed up zombification depending on adjacent blocks.
                 */
                if (pLevel.getBlockState(blockPos).is(PigsteelBlockTags.ZOMBIFICATION_DECELERATION)) {
                    chance -= blockInfluence;
                }
                else if (pLevel.getBlockState(blockPos).is(PigsteelBlockTags.ZOMBIFICATION_ACCELERATION)) {
                    chance += blockInfluence;
                }
                else if (pLevel.getBlockState(blockPos).getBlock() instanceof Zombifiable) {
                    chance -= blockInfluence / 2;
                }
            }
            if (pLevel.getRandom().nextFloat() < chance) {
                return getNext(pState);
            }
        }
        return Optional.empty();
    }

    static Optional<Block> getPrevious(Block pBlock) {
        return Optional.ofNullable(PREVIOUS_BY_BLOCK.get().get(pBlock));
    }

    static Block getFirst(Block pBlock) {
        Block block = pBlock;

        for(Block block1 = PREVIOUS_BY_BLOCK.get().get(pBlock); block1 != null; block1 = PREVIOUS_BY_BLOCK.get().get(block1)) {
            block = block1;
        }

        return block;
    }

    static Optional<Block> getNext(Block pBlock) {
        return Optional.ofNullable(PigsteelBlocks.NEXT_BY_BLOCK.get().get(pBlock));
    }

    static BlockState getFirst(BlockState pState) {
        return getFirst(pState.getBlock()).withPropertiesOf(pState);
    }

    default float getChanceModifier() {
        return this.getAge() == Zombifiable.ZombificationLevel.UNAFFECTED ? 0.89F : 1.0F;
    }

    default Optional<BlockState> getNext(BlockState state) {
        return Optional.ofNullable(PigsteelBlocks.NEXT_BY_BLOCK.get().get(state.getBlock())).map((block) -> block.withPropertiesOf(state));
    }

    static Optional<BlockState> getPrevious(BlockState state) {
        return Optional.ofNullable(PREVIOUS_BY_BLOCK.get().get(state.getBlock())).map((block) -> block.withPropertiesOf(state));
    }

    static Optional<BlockState> getPreviousWaxed(BlockState state) {
        return Optional.ofNullable(PREVIOUS_WAXED_BY_BLOCK.get().get(state.getBlock())).map((block) -> block.withPropertiesOf(state));
    }

    default boolean canRandomTick(BlockState state) {
        return Optional.ofNullable(PigsteelBlocks.NEXT_BY_BLOCK.get().get(state.getBlock())).isPresent() && !PigsteelBlocks.NEXT_WAXED_BY_BLOCK.get().containsValue(state.getBlock());
    }

    static ItemInteractionResult applyWax(ItemStack itemInHand, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (itemInHand.getItem() instanceof HoneycombItem) {
            if (PigsteelBlocks.NEXT_WAXED_BY_BLOCK.get().containsKey(state.getBlock())) {
                if (player instanceof ServerPlayer serverPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, pos, itemInHand);
                }
                level.setBlock(pos, PigsteelBlocks.NEXT_WAXED_BY_BLOCK.get().get(state.getBlock()).withPropertiesOf(state), 11);
                level.playSound(player, pos, SoundEvents.HONEYCOMB_WAX_ON, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.levelEvent(player, 3003, pos, 0);

                if (!player.isCreative() && !player.getAbilities().instabuild) {
                    itemInHand.shrink(1);
                }
                return ItemInteractionResult.sidedSuccess(true);
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    enum ZombificationLevel implements StringRepresentable {
        UNAFFECTED("", MapColor.COLOR_PURPLE),
        INFECTED("infected", MapColor.GRASS),
        CORRUPTED("corrupted", MapColor.COLOR_GREEN),
        ZOMBIFIED("zombified", MapColor.PLANT);

        ZombificationLevel(String name, MapColor mapColor) {
            this.name = name;
            this.mapColor = mapColor;
        }

        private String name;
        private MapColor mapColor;

        public MapColor getMapColor() {
            return mapColor;
        }


        @Override
        public String getSerializedName() {
            return this.name;
        }
    }
}