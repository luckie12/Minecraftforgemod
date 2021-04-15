package com.example.examplemod.data;

import com.example.examplemod.*;
import com.example.examplemod.setup.*;
import net.minecraft.data.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.util.*;

import java.util.function.*;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(ModItems.SILVER_INGOT.get(), 9).requires(ModBlocks.SILVER_BLOCK.get()).unlockedBy("has_item", has(ModItems.SILVER_INGOT.get())).save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.SILVER_BLOCK.get()).define('#', ModItems.SILVER_INGOT.get()).pattern("###").pattern("###").pattern("###").unlockedBy("has_item", has(ModItems.SILVER_INGOT.get())).save(consumer);

        CookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.SILVER_ORE.get()), ModItems.SILVER_INGOT.get(), 1.0F, 200).unlockedBy("has_item", has(ModBlocks.SILVER_ORE.get())).save(consumer, modId("silver_ingot_smelting"));
        CookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.SILVER_ORE.get()), ModItems.SILVER_INGOT.get(), 1.0F, 10).unlockedBy("has_item", has(ModBlocks.SILVER_ORE.get())).save(consumer, modId("silver_ingot_blasting"));

        ShapedRecipeBuilder.shaped(ModItems.SILVER_SWORD.get()).define('#', ModItems.SILVER_INGOT.get()).define('I', Items.STICK).pattern("#").pattern("I").pattern("I").unlockedBy("has_item", has(ModItems.SILVER_INGOT.get())).save(consumer);


    }

    private ResourceLocation modId(String path) {
        return new ResourceLocation(ExampleMod.MODID, path);
    }

}
