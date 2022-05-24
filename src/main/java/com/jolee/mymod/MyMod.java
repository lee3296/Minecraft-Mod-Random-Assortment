package com.jolee.mymod;

import com.jolee.mymod.init.BlockInit;
import com.jolee.mymod.init.ItemInit;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


//lets Minecraft Forge know this is the main class and to load this class on startup
@Mod("mymod")
public class MyMod {
	
	public static final String MOD_ID = "mymod";
	
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
		
		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		
		//register the event with this class.
		MinecraftForge.EVENT_BUS.register(this);
	}
}
