package com.example.examplemod;

import com.example.examplemod.setup.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.fluid.*;
import net.minecraft.item.*;
import net.minecraft.loot.*;
import net.minecraft.state.*;
import net.minecraft.state.properties.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;

import java.util.*;


public class SilverBlockCrops extends CropsBlock {

    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 7);

    private static final VoxelShape[] SHAPES = new VoxelShape[] {
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D)
    };

    public SilverBlockCrops(Properties builder) {
        super(builder);
        builder.harvestTool(ToolType.HOE);
        builder.requiresCorrectToolForDrops();
    }

    @Override
    protected IItemProvider getBaseSeedId() {
        return ModBlocks.SILVER_CROP.get();
    }

    @Override
    public int getMaxAge() {
        return 7;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPES[state.getValue(this.getAgeProperty())];
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader blockReader, BlockPos pos) {
        //TODO:
        //Only allowed to plant on CUSTOM FARMLAND
        if(state.is(Blocks.FARMLAND))
            return false;
        else
            return state.is(ModBlocks.CUSTOM_FARMLAND.get());
    }
}
