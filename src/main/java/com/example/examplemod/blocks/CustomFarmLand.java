package com.example.examplemod.blocks;

import net.minecraft.block.*;
import net.minecraft.state.*;
import net.minecraft.tags.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.server.*;

import java.util.*;

public class CustomFarmLand extends FarmlandBlock {

    public static final IntegerProperty MOISTURE = IntegerProperty.create("moisture", 0, 7);

    public CustomFarmLand(Properties builder) {
        super(builder);
        this.registerDefaultState(this.stateDefinition.any().setValue(MOISTURE, Integer.valueOf(0)));
    }

    private static boolean isNearLava(IWorldReader worldReader, BlockPos pos) {
        for(BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-4, 0, -4), pos.offset(4, 1, 4))) {
            if (worldReader.getFluidState(blockpos).is(FluidTags.LAVA)) {
                return true;
            }
        }

        return net.minecraftforge.common.FarmlandWaterManager.hasBlockWaterTicket(worldReader, pos);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld serverWorld, BlockPos pos, Random rand) {
        int i = state.getValue(MOISTURE);
        if (!isNearLava(serverWorld, pos) && !serverWorld.isRainingAt(pos.above())) {
            if (i > 0) {
                serverWorld.setBlock(pos, state.setValue(MOISTURE, Integer.valueOf(i - 1)), 2);
            } else if (!isUnderCrops(serverWorld, pos)) {
                turnToDirt(state, serverWorld, pos);
            }
        } else if (i < 7) {
            serverWorld.setBlock(pos, state.setValue(MOISTURE, Integer.valueOf(7)), 2);
        }

    }

    private boolean isUnderCrops(IBlockReader blockReader, BlockPos pos) {
        BlockState plant = blockReader.getBlockState(pos.above());
        BlockState state = blockReader.getBlockState(pos);
        return plant.getBlock() instanceof net.minecraftforge.common.IPlantable && state.canSustainPlant(blockReader, pos, Direction.UP, (net.minecraftforge.common.IPlantable)plant.getBlock());
    }

}
