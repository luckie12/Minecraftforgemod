package com.example.examplemod.items.silveritems;

import com.example.examplemod.blocks.*;
import com.example.examplemod.setup.*;
import com.google.common.collect.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import javax.swing.*;

public class SilverHoe extends HoeItem {
    public SilverHoe(IItemTier itemTier, int i, float y, Properties properties) {
        super(itemTier, i, y, properties);
//        TILLABLES.put(Blocks.GRASS_BLOCK, ModBlocks.CUSTOM_FARMLAND.get().defaultBlockState());
//        TILLABLES.put(Blocks.DIRT, ModBlocks.CUSTOM_FARMLAND.get().defaultBlockState());
    }

//    @Override
//    public ActionResultType useOn(ItemUseContext context) {
//        World world = context.getLevel();
//        BlockPos pos = context.getClickedPos();
//        int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(context);
//        if (hook != 0) return hook > 0 ? ActionResultType.SUCCESS : ActionResultType.FAIL;
//        //TODO:
//        // Get the block i clicked on, if dirt, change to custom farm land
//        if (context.getClickedFace() != Direction.DOWN && world.isEmptyBlock(pos.above())) {
//            if (!world.isClientSide()) {
//                if (world.getBlockState(pos).getBlock() == Blocks.DIRT || world.getBlockState(pos).getBlock() == Blocks.GRASS_BLOCK) {
//                    System.out.println("I clicked on dirt!");
////                    if (world.getBlockState(pos.above()).getBlock().is(Blocks.AIR)) {
//                        //if air,
//                        world.setBlock(pos, ModBlocks.CUSTOM_FARMLAND.get().defaultBlockState().setValue(CustomFarmLand.MOISTURE, 0), 2);
////                    }
//                }
//            }
//            return ActionResultType.sidedSuccess(world.isClientSide);
//        }
//        return ActionResultType.PASS;
////        return super.useOn(context);
//    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        World world = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(context);
        if (hook != 0) return hook > 0 ? ActionResultType.SUCCESS : ActionResultType.FAIL;
        if (context.getClickedFace() != Direction.DOWN && world.isEmptyBlock(blockpos.above())) {
//            BlockState blockstate = world.getBlockState(blockpos).getToolModifiedState(world, blockpos, context.getPlayer(), context.getItemInHand(), net.minecraftforge.common.ToolType.HOE);
            BlockState blockstate = ModBlocks.CUSTOM_FARMLAND.get().defaultBlockState().setValue(CustomFarmLand.MOISTURE, 7);
            if (blockstate != null) {
                PlayerEntity playerentity = context.getPlayer();
                world.playSound(playerentity, blockpos, SoundEvents.HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                if (!world.isClientSide) {
                    if (world.getBlockState(blockpos).getBlock() == Blocks.DIRT || world.getBlockState(blockpos).getBlock() == Blocks.GRASS_BLOCK) {
                        world.setBlock(blockpos, blockstate, 11);
                    }
                    if (playerentity != null) {
                        context.getItemInHand().hurtAndBreak(1, playerentity, (p_220043_1_) -> {
                            p_220043_1_.broadcastBreakEvent(context.getHand());
                        });
                    }
                }

                return ActionResultType.sidedSuccess(world.isClientSide);
            }
        }

        return ActionResultType.PASS;
    }

}
