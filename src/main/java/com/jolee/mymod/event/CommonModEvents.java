package com.jolee.mymod.event;

import com.jolee.mymod.MyMod;
import com.jolee.mymod.common.entity.ExampleEntity;
import com.jolee.mymod.init.EntityInit;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = MyMod.MOD_ID, bus = Bus.MOD) //this class is subscribing to mod event bus.
//bus picks up all the events and delivers them to the game
public class CommonModEvents {

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(EntityInit.EXAMPLE_ENTITY.get(), ExampleEntity.createAttributes().build());
	}
}
