package com.example.examplemod.setup;

import com.example.examplemod.*;
import com.example.examplemod.TileEntities.*;
import com.example.examplemod.blocks.*;
import com.example.examplemod.blocks.metalpress.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.registries.*;

import java.util.function.*;


public class ModTileEntityTypes {

//    public static final RegistryObject<TileEntityType<MetalPressTileEntity>> METAL_PRESS = register(
//            "metal_press",
//            MetalPressTileEntity::new,
//            ModBlocks.METAL_PRESS
//    );

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ExampleMod.MODID);


    public static final RegistryObject<TileEntityType<BlockBreakerTileEntity>> BLOCK_BREAKER_TILE_ENTITY_TYPE = register(
        "block_breaker",
        BlockBreakerTileEntity::new,
        ModBlocks.BLOCK_BREAKER
    );

    public static final RegistryObject<TileEntityType<DisplayCaseTileEntity>> DISPLAY_CASE_TILE_ENTITY_TYPE = register(
            "display_case",
            DisplayCaseTileEntity::new,
            ModBlocks.DISPLAY_CASE
    );

    public static final RegistryObject<TileEntityType<HarvesterBlockTileEntity>> HARVESTER_BLOCK_TILE_ENTITY_TYPE = register(
            "harvester_block",
            HarvesterBlockTileEntity::new,
            ModBlocks.HARVESTER_BLOCK
    );


    static void register() {}

    private static <T extends TileEntity>RegistryObject<TileEntityType<T>> register(String name, Supplier<T> factory, RegistryObject<? extends Block> block){
        return Registration.TILE_ENTITIES.register(name, () -> {
            //noinspection ConstantConditions
            return TileEntityType.Builder.of(factory, block.get()).build(null);
        });
    }

}
