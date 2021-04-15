package com.example.examplemod.data.client.gui;

import com.example.examplemod.*;
import com.example.examplemod.container.*;
import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.systems.*;
import net.minecraft.client.gui.screen.inventory.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;

public class HarvesterBlockScreen extends ContainerScreen<HarvesterBlockContainer> {

    private static final ResourceLocation GUI = new ResourceLocation(ExampleMod.MODID, "textures/gui/display_case.png");

    public HarvesterBlockScreen(HarvesterBlockContainer container, PlayerInventory playerInventory, ITextComponent name) {
        super(container, playerInventory, name);
    }


    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bind(GUI);
        int relX = (this.width - this.getXSize()) / 2;
        int relY = (this.height - this.getYSize()) / 2;
        this.blit(matrixStack, relX, relY, 0, 0, this.getXSize(), this.getYSize());
    }

}
