package com.uraneptus.pigsteel.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.Nullable;

public class ZombifiableStairsBlock extends StairBlock implements Zombifiable {

    private ZombificationLevel zombificationLevel;

    public ZombifiableStairsBlock(ZombificationLevel zombificationLevel, BlockState baseBlockState, Properties properties) {
        super(baseBlockState, properties);
        this.zombificationLevel = zombificationLevel;
    }

    @Override
    public MapColor defaultMapColor() {
        return getAge().getMapColor();
    }

    @Override
    public void randomTick(BlockState state, ServerLevel pLevel, BlockPos pos, RandomSource random) {
        this.changeOverTime(state, pLevel, pos, random);
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack itemUsed, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        return Zombifiable.applyWax(itemUsed, state, level, pos, player, hand, result);
    }

    @Override
    @Nullable
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility action, boolean simulate) {
        if (action == ItemAbilities.AXE_SCRAPE) {
            return Zombifiable.getPrevious(state).isPresent() ? Zombifiable.getPrevious(state).get().getBlock().withPropertiesOf(state) : null;
        }
        if (action == ItemAbilities.AXE_WAX_OFF) {
            return Zombifiable.getPreviousWaxed(state).isPresent() ? Zombifiable.getPreviousWaxed(state).get().getBlock().withPropertiesOf(state) : null;
        }
        return super.getToolModifiedState(state, context, action, simulate);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return this.canRandomTick(state);
    }

    @Override
    public ZombificationLevel getAge() {
        return this.zombificationLevel;
    }

}
