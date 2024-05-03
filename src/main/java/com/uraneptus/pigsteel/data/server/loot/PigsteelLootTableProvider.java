package com.uraneptus.pigsteel.data.server.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PigsteelLootTableProvider extends LootTableProvider {

    public PigsteelLootTableProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, Collections.emptySet(), List.of(new SubProviderEntry(PigsteelBlockLoot::new, LootContextParamSets.BLOCK)), lookupProvider);
    }

}
