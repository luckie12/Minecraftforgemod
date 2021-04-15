package com.example.examplemod.setup;

import com.example.examplemod.*;
import com.example.examplemod.blocks.*;
import com.example.examplemod.container.*;
import com.example.examplemod.data.client.gui.*;
import net.minecraft.client.gui.*;
import net.minecraft.inventory.container.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.common.extensions.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.registries.*;


public class ModContainerTypes {

    public static DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, ExampleMod.MODID);

//    public static RegistryObject<ContainerType<DisplayCaseContainer>> DISPLAY_CASE_CONTAINER_TYPE = CONTAINER_TYPES.register("display_case", () -> IForgeContainerType.create(DisplayCaseContainer::new));

    public static RegistryObject<ContainerType<DisplayCaseContainer>> DISPLAY_CASE_CONTAINER_TYPE = CONTAINER_TYPES.register("display_case" , () -> {
        ContainerType<DisplayCaseContainer> type = IForgeContainerType.create(DisplayCaseContainer::new);
        ScreenManager.register(type, DisplayCaseScreen::new);
        return type;
    });

    public static final RegistryObject<ContainerType<HarvesterBlockContainer>> HARVESTER_CONTAINER = CONTAINER_TYPES.register("harvester_block", () -> IForgeContainerType.create(((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.level;
        return new HarvesterBlockContainer(windowId, world, pos, inv, inv.player);
    })));

    static void register() {}


}
