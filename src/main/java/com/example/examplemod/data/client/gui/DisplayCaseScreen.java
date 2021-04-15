package com.example.examplemod.data.client.gui;

import com.example.examplemod.*;
import com.example.examplemod.container.*;
import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.systems.*;
import net.minecraft.client.gui.screen.inventory.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class DisplayCaseScreen extends ContainerScreen<DisplayCaseContainer> {

    private static final ResourceLocation DISPLAY_CASE_GUI = new ResourceLocation(ExampleMod.MODID, "textures/gui/display_case.png");

    public DisplayCaseScreen(DisplayCaseContainer containerIn, PlayerInventory playerInventoryIn, ITextComponent titleIn) {
        super(containerIn, playerInventoryIn, titleIn);

        this.leftPos = 0;
        this.topPos = 0;
        this.inventoryLabelX = 175;
        this.inventoryLabelY = 201;

    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTick, int mouseX, int mouseY) {
        RenderSystem.color4f(1f, 1f, 1f, 1f);
        this.minecraft.textureManager.bind(DISPLAY_CASE_GUI);
        int x = (this.width = this.getXSize()) / 2;
        int y = (this.height = this.getYSize()) / 2;
        this.blit(matrixStack, x, y, 0,0, this.getXSize(), this.getYSize());
    }
}
