package com.jolee.mymod.common.block.entity;

import com.jolee.mymod.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DisplayHandBlockEntity extends BlockEntity {
    public DisplayHandBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.DISPLAY_HAND.get(), pos, state);
    }
}
