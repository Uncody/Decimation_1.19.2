package com.decimation.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab ITEMS = new CreativeModeTab("items") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.LOCKPICK.get());
        }
    };
    public static final CreativeModeTab BLOCKS = new CreativeModeTab("blocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.LOCKPICK.get());
        }
    };
}
