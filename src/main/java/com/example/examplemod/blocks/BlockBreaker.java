package com.example.examplemod.blocks;

import com.example.examplemod.setup.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.state.*;
import net.minecraft.tileentity.*;
import net.minecraft.world.*;

import javax.annotation.*;

public class BlockBreaker extends Block {

    public BlockBreaker(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntityTypes.BLOCK_BREAKER_TILE_ENTITY_TYPE.get().create();
    }

}
