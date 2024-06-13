package com.uraneptus.pigsteel.data.server.loot;

import com.uraneptus.pigsteel.common.blocks.Zombifiable;
import com.uraneptus.pigsteel.common.blocks.ZombifiableSlabBlock;
import com.uraneptus.pigsteel.core.registry.PigsteelBlocks;
import com.uraneptus.pigsteel.core.registry.PigsteelItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Set;
import java.util.stream.Collectors;

public class PigsteelBlockLoot extends BlockLootSubProvider {
    private static final Set<Item> EXPLOSION_RESISTANT = Set.of();

    protected PigsteelBlockLoot(HolderLookup.Provider provider) {
        super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return PigsteelBlocks.BLOCKS.getEntries().stream().map(DeferredHolder::get).collect(Collectors.toList());
    }

    @Override
    protected void generate() {
        PigsteelBlocks.BLOCKS.getEntries().forEach(object -> {
            Block block = object.get();
            if (!(block instanceof Zombifiable)) return;
            if (block instanceof ZombifiableSlabBlock) {
                this.createSlab(block);
            } else {
                this.dropSelf(block);
            }

        });

        this.dropSelf(PigsteelBlocks.PIGSTEEL_CHUNK_BLOCK.get());
        this.add(PigsteelBlocks.PORKSLAG.get(), this::createPorkslag);
    }

    protected LootTable.Builder createPorkslag(Block block) {
        return createSilkTouchDispatchTable(block, applyExplosionDecay(block, LootItem.lootTableItem(PigsteelItems.PIGSTEEL_CHUNK.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 6.0F))).apply(ApplyBonusCount.addOreBonusCount(this.registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE)))));
    }

    protected void createSlab(Block block) {
        add(block, createSlabItemTable(block));
    }
}
