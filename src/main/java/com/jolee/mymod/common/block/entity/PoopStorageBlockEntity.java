package com.jolee.mymod.common.block.entity;

import com.jolee.mymod.MyMod;
import com.jolee.mymod.init.BlockEntityInit;
import com.jolee.mymod.common.block.entity.util.*;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.state.BlockState;

public class PoopStorageBlockEntity extends InventoryBlockEntity {
    public static final Component TITLE = new TranslatableComponent("container." + MyMod.MOD_ID + ".poop_storage");
    
    public PoopStorageBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.POOP_STORAGE.get(), pos, state, 1);
    }
}