package com.jolee.mymod.client.renderer;

import com.jolee.mymod.MyMod;
import com.jolee.mymod.client.renderer.model.ExampleEntityModel;
import com.jolee.mymod.common.entity.ExampleEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ExampleEntityRenderer<Type extends ExampleEntity> 
	extends MobRenderer<Type, ExampleEntityModel<Type>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(MyMod.MOD_ID,
			"textures/entities/example_entity.png");
	
	public ExampleEntityRenderer(Context context) {
		//last parameter is shadow size
		super(context, new ExampleEntityModel<>(context.bakeLayer(ExampleEntityModel.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(Type entity) {
		return TEXTURE;
	}

	
	
	
}
