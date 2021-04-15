package com.example.examplemod.setup;

import com.example.examplemod.*;
import com.example.examplemod.blocks.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.item.*;
import net.minecraftforge.common.*;
import net.minecraftforge.fml.*;

import java.util.function.*;

public class ModBlocks {

    public static final RegistryObject<Block> SILVER_ORE = register("silver_ore", () -> new Block(Block.Properties.of(Material.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE).strength(2, 5).requiresCorrectToolForDrops().sound(SoundType.STONE)), ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> SILVER_BLOCK = register("silver_block", () -> new Block(Block.Properties.of(Material.METAL).strength(2, 5).sound(SoundType.METAL)), ItemGroup.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> BLOCK_BREAKER = register("block_breaker", () -> new BlockBreaker(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)), ItemGroup.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> DISPLAY_CASE = register("display_case", () -> new DisplayCaseBlock(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)), ItemGroup.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> SILVER_CROP = register("silver_crop", () -> new SilverBlockCrops(AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)), ItemGroup.TAB_MISC);

    public static final RegistryObject<Block> CUSTOM_FARMLAND = register("custom_farmland", () -> new CustomFarmLand(AbstractBlock.Properties.copy(Blocks.FARMLAND)), ItemGroup.TAB_DECORATIONS);

    public static final RegistryObject<Block> HARVESTER_BLOCK = register("harvester_block", () -> new HarvesterBlock(AbstractBlock.Properties.copy(Blocks.STONE)), ItemGroup.TAB_DECORATIONS);

//    public static final RegistryObject<MetalPressBlock> METAL_PRESS = register("metal_press", () -> new MetalPressBlock(AbstractBlock.Properties.of(Material.METAL).strength(4, 20).sound(SoundType.METAL)));

    static void register(){}

    private static <T extends Block>RegistryObject<T> registerNoItem(String name, Supplier<T> block){
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block, ItemGroup group){
        RegistryObject<T> ret = registerNoItem(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(group)));
        return ret;
    }

}
