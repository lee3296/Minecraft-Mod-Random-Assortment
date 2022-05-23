package com.jolee.mymod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;


//lets Minecraft Forge know this is the main class and to load this class on startup
@Mod("mymod")
public class MyMod {

	public MyMod() {
		
		//register the event with this class.
		MinecraftForge.EVENT_BUS.register(this);
	}
}
