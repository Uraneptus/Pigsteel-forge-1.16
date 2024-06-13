package com.uraneptus.pigsteel;

import com.uraneptus.pigsteel.core.registry.PigsteelBlocks;
import com.uraneptus.pigsteel.core.registry.PigsteelItems;
import com.uraneptus.pigsteel.data.client.PigsteelBlockStateProvider;
import com.uraneptus.pigsteel.data.client.PigsteelItemModelProvider;
import com.uraneptus.pigsteel.data.client.PigsteelLangProvider;
import com.uraneptus.pigsteel.data.server.PigsteelDatapackBuiltinEntriesProvider;
import com.uraneptus.pigsteel.data.server.PigsteelRecipeProvider;
import com.uraneptus.pigsteel.data.server.loot.PigsteelLootTableProvider;
import com.uraneptus.pigsteel.data.tags.PigsteelBiomeTagsProvider;
import com.uraneptus.pigsteel.data.tags.PigsteelBlockTagsProvider;
import com.uraneptus.pigsteel.data.tags.PigsteelItemTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@Mod(PigsteelMod.MOD_ID)
public class PigsteelMod {
    public static final String MOD_ID = "pigsteel";
    public static ResourceLocation modPrefix(String path) {
        return ResourceLocation.fromNamespaceAndPath(PigsteelMod.MOD_ID, path);
    }

    public PigsteelMod(IEventBus bus) {
        bus.addListener(this::gatherData);

        PigsteelItems.ITEMS.register(bus);
        PigsteelBlocks.BLOCKS.register(bus);

    }

    @SubscribeEvent
    public void gatherData(GatherDataEvent event) {
        boolean includeClient = event.includeClient();
        boolean includeServer = event.includeServer();
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(includeClient, new PigsteelLangProvider(packOutput));
        generator.addProvider(includeClient, new PigsteelBlockStateProvider(packOutput, fileHelper));
        generator.addProvider(includeClient, new PigsteelItemModelProvider(packOutput, fileHelper));
        PigsteelBlockTagsProvider blockTagsProvider = new PigsteelBlockTagsProvider(packOutput, lookupProvider, fileHelper);
        generator.addProvider(includeServer, blockTagsProvider);
        generator.addProvider(includeServer, new PigsteelItemTagsProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), fileHelper));
        generator.addProvider(includeServer, new PigsteelBiomeTagsProvider(packOutput, lookupProvider, fileHelper));
        generator.addProvider(includeServer, new PigsteelLootTableProvider(packOutput, lookupProvider));
        generator.addProvider(includeServer, new PigsteelDatapackBuiltinEntriesProvider(packOutput, lookupProvider));
        generator.addProvider(includeServer, new PigsteelRecipeProvider(packOutput, lookupProvider));
    }


}
