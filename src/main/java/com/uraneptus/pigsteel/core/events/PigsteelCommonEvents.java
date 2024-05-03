package com.uraneptus.pigsteel.core.events;

import com.uraneptus.pigsteel.PigsteelMod;
import com.uraneptus.pigsteel.data.client.PigsteelLangProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackSelectionConfig;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.BuiltInPackSource;
import net.minecraft.server.packs.repository.KnownPack;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforgespi.locating.IModFile;

import java.util.Optional;

@EventBusSubscriber(modid = PigsteelMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class PigsteelCommonEvents {

    @SubscribeEvent
    public static void addPackFinders(AddPackFindersEvent event) {
        event.addRepositorySource(consumer -> {
            String id = "ore_revert";
            IModFile file = ModList.get().getModFileById(PigsteelMod.MOD_ID).getFile();
            PackLocationInfo info = new PackLocationInfo(id, Component.literal(PigsteelLangProvider.createTranslation("pigsteel_ore_revert")), PackSource.BUILT_IN, Optional.of(new KnownPack(PigsteelMod.MOD_ID, id, "1.2")));
            try (PathPackResources packResources = new PathPackResources(info, file.findResource("builtin/ore_revert"))) {
                consumer.accept(Pack.readMetaAndCreate(info, BuiltInPackSource.fixedResources(packResources), PackType.CLIENT_RESOURCES, new PackSelectionConfig(false, Pack.Position.TOP, false)));
            }
        });
    }
}
