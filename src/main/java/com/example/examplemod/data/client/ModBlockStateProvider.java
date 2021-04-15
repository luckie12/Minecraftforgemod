package com.example.examplemod.data.client;


import com.example.examplemod.*;
import com.example.examplemod.setup.*;
import net.minecraft.data.*;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.*;

public class ModBlockStateProvider extends BlockStateProvider {


    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, ExampleMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.SILVER_BLOCK.get());
        simpleBlock(ModBlocks.SILVER_ORE.get());
        getVariantBuilder(ModBlocks.SILVER_CROP.get()).forAllStates(state -> ConfiguredModel.builder().modelFile(models().withExistingParent("silver_crop_stage" + state.getValue(SilverBlockCrops.AGE), "block/crop").texture("crop", "test:block/silver_crop_stage" + state.getValue(SilverBlockCrops.AGE))).build());
        simpleBlock(ModBlocks.DISPLAY_CASE.get());
    }
}