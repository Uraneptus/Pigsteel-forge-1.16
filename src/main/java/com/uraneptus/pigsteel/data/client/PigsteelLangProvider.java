package com.uraneptus.pigsteel.data.client;

import com.uraneptus.pigsteel.PigsteelMod;
import com.uraneptus.pigsteel.core.registry.PigsteelBlocks;
import com.uraneptus.pigsteel.core.registry.PigsteelItems;
import com.uraneptus.pigsteel.data.PigsteelDatagenUtil;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.Objects;
import java.util.function.Supplier;

public class PigsteelLangProvider extends LanguageProvider {

    public PigsteelLangProvider(PackOutput packOutput) {
        super(packOutput, PigsteelMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        PigsteelBlocks.SIMPLE_TRANSLATION.forEach(this::forBlock);
        addBlock(PigsteelBlocks.PIGSTEEL_CHUNK_BLOCK, "Block of Pigsteel Chunks");
        forItem(PigsteelItems.PIGSTEEL_CHUNK);
        add("trim_material.pigsteel.pigsteel", "Pigsteel");
    }

    protected void forItem(Supplier<? extends Item> item) {
        addItem(item, createTranslation(Objects.requireNonNull(PigsteelDatagenUtil.name(item.get()))));
    }

    protected void forBlock(Supplier<? extends Block> block) {
        addBlock(block, createTranslation(Objects.requireNonNull(PigsteelDatagenUtil.name(block.get()))));
    }

    public static String createTranslation(String path) {
        final StringBuilder builder = new StringBuilder();

        for (String part : path.split("_")) {
            if (!builder.isEmpty()) {
                builder.append(" ");
            }
            builder.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1));
        }
        return builder.toString();
    }
}