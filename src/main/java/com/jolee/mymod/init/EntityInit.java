package com.jolee.mymod.init;

import com.jolee.mymod.MyMod;
import com.jolee.mymod.common.entity.ExampleEntity;
import com.jolee.mymod.common.entity.SittableEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class EntityInit {

	
	private EntityInit() {
		
		
	}
	
	public static final DeferredRegister<EntityType<?>> ENTITIES = 
			DeferredRegister.create(ForgeRegistries.ENTITIES, MyMod.MOD_ID);
	
	//registry object. create the entity
	//sized is for how big you want hitbox to be
	public static final RegistryObject<EntityType<ExampleEntity>> EXAMPLE_ENTITY = 
			ENTITIES.register("example_entity", () -> EntityType.Builder.of(ExampleEntity::new, MobCategory.CREATURE).fireImmune()
					.sized(0.8f, 0.6f).build(new ResourceLocation(MyMod.MOD_ID, "example_entity").toString()));
	
	public static final RegistryObject<EntityType<SittableEntity>> SEAT = ENTITIES.register("seat",
            () -> EntityType.Builder.<SittableEntity>of(SittableEntity::new, MobCategory.MISC).sized(1f, 1f)
                    .build(new ResourceLocation(MyMod.MOD_ID, "seat").toString()));
	
}
