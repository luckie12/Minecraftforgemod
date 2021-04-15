package com.example.examplemod.setup;

import com.example.examplemod.*;
import com.example.examplemod.data.ItemTiers.*;
import com.example.examplemod.items.silveritems.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.registries.*;

public class ModItems {
    public static final RegistryObject<Item> SILVER_INGOT = Registration.ITEMS.register("silver_ingot", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));
    public static final RegistryObject<Item> SILVER_SWORD = Registration.ITEMS.register("silver_sword", () -> new SilverSword(new SilverTier(), 3, -2.4F, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> SILVER_HOE = Registration.ITEMS.register("silver_hoe", () -> new SilverHoe(new SilverTier(), 3, -2.4F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));

    static void register(){}

}
