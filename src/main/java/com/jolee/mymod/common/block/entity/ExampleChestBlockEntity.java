package com.jolee.mymod.common.block.entity;

import com.jolee.mymod.MyMod;
import com.jolee.mymod.common.block.entity.util.InventoryBlockEntity;
import com.jolee.mymod.init.BlockEntityInit;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.state.BlockState;

public class ExampleChestBlockEntity extends InventoryBlockEntity {
    public static final Component TITLE = new TranslatableComponent(
            "container." + MyMod.MOD_ID + ".example_chest");
    
    public ExampleChestBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.EXAMPLE_CHEST.get(), pos, state, 27);
    }
}
