package com.jolee.mymod.init;

import com.jolee.mymod.MyMod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class SoundInit {

	
	public static final DeferredRegister<SoundEvent> SOUNDS = 
			DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MyMod.MOD_ID);
	
	//objects for the sound of entities
	
	//ambient for example_entity
	public static final RegistryObject<SoundEvent> EXAMPLE_ENTITY_AMBIENT =
			SOUNDS.register("entity.example_entity.ambient",
					() -> new SoundEvent(new ResourceLocation(MyMod.MOD_ID, "entity.example_entity.ambient")));
	
	//damage sound for example_entity
	public static final RegistryObject<SoundEvent> EXAMPLE_ENTITY_HURT =
			SOUNDS.register("entity.example_entity.hurt",
					() -> new SoundEvent(new ResourceLocation(MyMod.MOD_ID, "entity.example_entity.hurt")));
	
	//death sound for entity
	public static final RegistryObject<SoundEvent> EXAMPLE_ENTITY_DEATH =
			SOUNDS.register("entity.example_entity.death",
					() -> new SoundEvent(new ResourceLocation(MyMod.MOD_ID, "entity.example_entity.death")));
	
	//toilet sound
	public static final RegistryObject<SoundEvent> FART = SOUNDS.register("block.toilet.fart",
            () -> new SoundEvent(new ResourceLocation(MyMod.MOD_ID, "block.toilet.fart")));
	
	public SoundInit() {
		
	}
}
