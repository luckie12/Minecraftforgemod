package com.example.examplemod.TileEntities;

import com.example.examplemod.*;
import com.example.examplemod.blocks.*;
import com.example.examplemod.setup.*;
import net.minecraft.block.*;
import net.minecraft.entity.item.*;
import net.minecraft.item.*;
import net.minecraft.loot.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;

import java.util.*;

public class HarvesterBlockTileEntity extends TileEntity implements ITickableTileEntity {
    public HarvesterBlockTileEntity(TileEntityType<?> tileEntityType) {
        super(tileEntityType);
    }

    public HarvesterBlockTileEntity(){
        super(ModTileEntityTypes.HARVESTER_BLOCK_TILE_ENTITY_TYPE.get());
    }


    @Override
    public void tick() {
        //What should this block to every tick?
        Direction facingDir = getBlockState().getValue(HarvesterBlock.FACING);
        switch (facingDir){
            case NORTH:
                doBreak(getBlockPos().north());
                break;
            case SOUTH:
                doBreak(getBlockPos().south());
                break;
            case WEST:
                doBreak(getBlockPos().west());
                break;
            case EAST:
                doBreak(getBlockPos().east());
                break;
        }
    }

    void doBreak(BlockPos dir){
        if(getLevel().getBlockState(dir).is(ModBlocks.SILVER_CROP.get())){
            if(getLevel().getBlockState(dir).getValue(SilverBlockCrops.AGE) == 7){
                getLevel().setBlock(dir , ModBlocks.SILVER_CROP.get().defaultBlockState(), 0);
                ItemEntity xd = new ItemEntity(getLevel(), getBlockPos().getX(), getBlockPos().getY(), getBlockPos().getZ(), new ItemStack(ModItems.SILVER_INGOT.get(), 1));
                getLevel().addFreshEntity(xd);
            }
        }
    }

}
