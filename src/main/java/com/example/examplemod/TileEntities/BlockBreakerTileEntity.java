package com.example.examplemod.TileEntities;

import com.example.examplemod.setup.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.*;
import net.minecraft.world.*;

public class BlockBreakerTileEntity extends TileEntity implements ITickableTileEntity{


    public BlockBreakerTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public BlockBreakerTileEntity() {
        super(ModTileEntityTypes.BLOCK_BREAKER_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {
        for(BlockPos blockpos : BlockPos.betweenClosed(getBlockPos().offset(-4, 0, -4), getBlockPos().offset(4, 1, 4))) {
            getLevel().setBlock(blockpos, Blocks.AIR.defaultBlockState(), 0);
            // TODO: Break blocks and drop items
        }
    }
}
