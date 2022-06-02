package com.jolee.mymod;

import java.util.Optional;
import java.util.Map.Entry;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jolee.mymod.init.BlockEntityInit;
import com.jolee.mymod.init.BlockInit;
import com.jolee.mymod.init.ContainerInit;
import com.jolee.mymod.init.EntityInit;
import com.jolee.mymod.init.ItemInit;
import com.jolee.mymod.init.SoundInit;

import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;


//lets Minecraft Forge know this is the main class and to load this class on startup
@Mod("mymod")
public class MyMod {
	
	public static final String MOD_ID = "mymod";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	
	//The creative tab ID for items and blocks
	
	public static final CreativeModeTab TUTORIAL_TAB = new CreativeModeTab(MOD_ID) {
		
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			//make the creative tab have the icon of the EXAMPLE_ITEM item
			return new ItemStack(ItemInit.EXAMPLE_ITEM.get());
		}
	};
	
	/*
	
	//The creative tab for tools
    public static final CreativeModeTab TUTORIAL_BLOCKS = new CreativeModeTab(MOD_ID + "_tools") {
		
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			// TODO Auto-generated method stub
			return  new ItemStack(ItemInit.);
		}
	};
	*/
	

	public MyMod() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		SoundInit.SOUNDS.register(bus);
        BlockInit.BLOCKS.register(bus);
        BlockEntityInit.BLOCK_ENTITIES.register(bus);
        ContainerInit.CONTAINERS.register(bus);
        ItemInit.ITEMS.register(bus);
        EntityInit.ENTITIES.register(bus);
		//register the event with this class.
		//MinecraftForge.EVENT_BUS.register(this);
	}
	
	@Nonnull
	public Block retreiveBlock(ResourceLocation name) {
        final Optional<Block> block = ForgeRegistries.BLOCKS.getEntries().stream()
            .filter(entry -> entry.getKey().getRegistryName().equals(name)).map(Entry::getValue).findFirst();
        return block.orElse(Blocks.AIR);
    }
	
	public static VoxelShape calculateShapes(Direction to, VoxelShape shape) {
        final VoxelShape[] buffer = { shape, Shapes.empty() };

        final int times = (to.get2DDataValue() - Direction.NORTH.get2DDataValue() + 4) % 4;
        for (int i = 0; i < times; i++) {
            buffer[0].forAllBoxes((minX, minY, minZ, maxX, maxY,
                maxZ) -> buffer[1] = Shapes.or(buffer[1], Shapes.create(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
            buffer[0] = buffer[1];
            buffer[1] = Shapes.empty();
        }

        return buffer[0];
    }
}
