package com.jolee.mymod.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ExampleItem extends Item{

	public ExampleItem(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		// function will be run when player uses this item
		
		if (!world.isClientSide) {
			//make sure we are on the server
			System.out.println(player.getName().getString() + 
					" has used item with hand " + hand.name());
			
		}
		
		return super.use(world, player, hand);
	}
	
	/*
	@Override
	public boolean canFitInsideContainerItems() {
		
		return super.canFitInsideContainerItems();
	}
	*/
	
	
	
}
