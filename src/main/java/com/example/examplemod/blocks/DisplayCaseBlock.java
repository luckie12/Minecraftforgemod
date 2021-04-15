package com.example.examplemod.blocks;

import com.example.examplemod.TileEntities.*;
import com.example.examplemod.setup.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.fml.network.*;

import javax.annotation.*;

public class DisplayCaseBlock extends Block {

    public DisplayCaseBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntityTypes.DISPLAY_CASE_TILE_ENTITY_TYPE.get().create();
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        if(!world.isClientSide()){
            TileEntity te = world.getBlockEntity(pos);
            if(te instanceof DisplayCaseTileEntity){
                NetworkHooks.openGui((ServerPlayerEntity) player, (DisplayCaseTileEntity) te, pos);
            }
        }
        return super.use(state, world, pos, player, hand, hit);
    }
}
