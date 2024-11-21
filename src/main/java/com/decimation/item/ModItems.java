package com.decimation.item;

import com.decimation.ProjectDecimation;
import com.decimation.item.custom.EightBallItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ProjectDecimation.MOD_ID);

    public static final RegistryObject<Item> LOCKPICK = ITEMS.register("lockpick",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ITEMS)));

    public static final RegistryObject<Item> RANDNUM = ITEMS.register("randnumber",
            () -> new EightBallItem(new Item.Properties().tab(ModCreativeModeTab.ITEMS).stacksTo(1 )));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }


}
