package com.example.examplemod.data.ItemTiers;

import com.example.examplemod.setup.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;

public class SilverTier implements IItemTier {
    @Override
    public int getUses() {
        return 99;
    }

    @Override
    public float getSpeed() {
        return 100;
    }

    @Override
    public float getAttackDamageBonus() {
        return 500;
    }

    @Override
    public int getLevel() {
        return 20;
    }

    @Override
    public int getEnchantmentValue() {
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ModItems.SILVER_INGOT.get());
    }
}
