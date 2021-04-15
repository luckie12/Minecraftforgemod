package com.example.examplemod.data;

import com.example.examplemod.setup.*;
import com.google.common.collect.*;
import com.mojang.datafixers.util.*;
import net.minecraft.block.*;
import net.minecraft.data.*;
import net.minecraft.data.loot.*;
import net.minecraft.item.*;
import net.minecraft.loot.*;
import net.minecraft.util.*;
import net.minecraftforge.fml.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(
                Pair.of(ModBlockLootTables::new, LootParameterSets.BLOCK)
        );
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
        map.forEach((x1, x2) -> LootTableManager.validate(validationtracker, x1, x2));
    }

    public static class ModBlockLootTables extends BlockLootTables {
        @Override
        protected void addTables() {
            dropSelf(ModBlocks.SILVER_BLOCK.get());
            dropSelf(ModBlocks.SILVER_ORE.get());
//            dropSelf(Blocks.DIAMOND_BLOCK, dropWhenSilkTouch(Blocks.DIAMOND_BLOCK));
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return Registration.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());
        }
    }

}
