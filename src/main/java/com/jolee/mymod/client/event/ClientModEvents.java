package com.jolee.mymod.client.event;

import com.jolee.mymod.MyMod;
import com.jolee.mymod.client.renderer.ExampleEntityRenderer;
import com.jolee.mymod.client.renderer.model.ExampleEntityModel;
import com.jolee.mymod.init.BlockInit;
import com.jolee.mymod.init.EntityInit;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = MyMod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public final class ClientModEvents {

	private ClientModEvents() {
		//nothing goes here
	}
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		
		ItemBlockRenderTypes.setRenderLayer(BlockInit.LIGHTNING_JUMPER.get(),
				RenderType.cutout());
	}
	
	@SubscribeEvent
	public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		
		event.registerLayerDefinition(ExampleEntityModel.LAYER_LOCATION, ExampleEntityModel::createBodyLayer);
	}
	
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		
		event.registerEntityRenderer(EntityInit.EXAMPLE_ENTITY.get(), ExampleEntityRenderer::new);
	}
	
}
