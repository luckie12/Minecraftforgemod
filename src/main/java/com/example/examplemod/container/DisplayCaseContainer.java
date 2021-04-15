package com.example.examplemod.container;

import com.example.examplemod.TileEntities.*;
import com.example.examplemod.data.client.gui.*;
import com.example.examplemod.setup.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;
import net.minecraft.network.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;

import javax.annotation.*;
import java.util.*;

public class DisplayCaseContainer extends Container {

    public final DisplayCaseTileEntity te;
    private final IWorldPosCallable canInteractWithCallable;

    public DisplayCaseContainer(final int windowId, final PlayerInventory playerInv, final DisplayCaseTileEntity te){
        super(ModContainerTypes.DISPLAY_CASE_CONTAINER_TYPE.get(), windowId);
        this.te = te;
        this.canInteractWithCallable = IWorldPosCallable.create(te.getLevel(), te.getBlockPos());

        // Tile Entity
        this.addSlot(new Slot((IInventory) te, 0, 80, 35));

        //Main Player Inventory
        for (int row = 0; row < 3; row++){
            for(int col = 0; col < 9; col++){
                this.addSlot(new Slot(playerInv, col + row * 9 + 9, 8 + col * 18, 166 - (4 - row) * 18 - 10));
            }
        }

        //Player hotbar
        for(int col = 0; col < 9; col++){
            this.addSlot(new Slot(playerInv, col, 8 + col * 18, 142));
        }
    }

    public DisplayCaseContainer(final int windowId, final PlayerInventory playerInv, final PacketBuffer data){
        this(windowId, playerInv, getTileEntity(playerInv, data));
    }

    private static DisplayCaseTileEntity getTileEntity(final PlayerInventory playerInv, final PacketBuffer data){
        Objects.requireNonNull(playerInv, "Player Inventory cannot be null!");
        Objects.requireNonNull(data, "Packet Buffer cannot be null!");
        final TileEntity te = playerInv.player.level.getBlockEntity(data.readBlockPos());
        if(te instanceof DisplayCaseTileEntity){
            return (DisplayCaseTileEntity) te;
        }
        throw new IllegalStateException("Tile Entity is not correct");
    }

    @Override
    public boolean stillValid(PlayerEntity player) {
        return stillValid(canInteractWithCallable, player, ModBlocks.DISPLAY_CASE.get());
    }

    @Override
    public ItemStack quickMoveStack(PlayerEntity player, int index) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if(slot != null && slot.hasItem()){
            ItemStack stack1 = slot.getItem();
            stack = stack1.copy();
            if( index < DisplayCaseTileEntity.SLOTS && !this.moveItemStackTo(stack1, DisplayCaseTileEntity.SLOTS, this.slots.size(), true)) {
                return ItemStack.EMPTY;
            }
            if(!this.moveItemStackTo(stack1, 0, DisplayCaseTileEntity.SLOTS, false)){
                return ItemStack.EMPTY;
            }
            if(stack1.isEmpty()){
                slot.set(ItemStack.EMPTY);
            }else{
                slot.setChanged();
            }
        }
        return stack;
    }
}
