package com.decimation.block;

import com.decimation.ProjectDecimation;
import com.decimation.block.custom.JumpyBlock;
import com.decimation.block.custom.StatesTestBlock;
import com.decimation.item.ModCreativeModeTab;
import com.decimation.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ProjectDecimation.MOD_ID);
    // Registry Block
    public static final RegistryObject<Block> TEST_BLOCK = registerBlock("test_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
            .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS);

    public static final RegistryObject<Block> TEST_JUMPY = registerBlock("test_jumpy",
            () -> new JumpyBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.BLOCKS);

    public static final RegistryObject<Block> TEST_STATES = registerBlock("test_states",
            () -> new StatesTestBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(StatesTestBlock.CANADDEFFECT) ? 15:0)), ModCreativeModeTab.BLOCKS);
    // Registry Block end
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registryBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registryBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
