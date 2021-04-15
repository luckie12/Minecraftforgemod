package com.example.examplemod.items.silveritems;

import com.example.examplemod.setup.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class SilverSword extends SwordItem {


    public SilverSword(IItemTier iItemTier, int i, float y, Properties properties) {
        super(iItemTier, i, y, properties);
        properties.rarity(Rarity.EPIC);
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity livingEntity, LivingEntity livingEntity2) {
        Item item = this.getItem();
        System.out.println("I hurt enemy with " + item);
        return super.hurtEnemy(itemStack, livingEntity, livingEntity2);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("\u00A7bHello bitch ass\u00A7b"));
    }
}
