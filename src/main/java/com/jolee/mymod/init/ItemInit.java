package com.jolee.mymod.init;

import com.jolee.mymod.MyMod;
import com.jolee.mymod.item.ClickerItem;
import com.jolee.mymod.item.ExampleItem;
import com.google.common.base.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

//class that stores all the items for the mod

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MyMod.MOD_ID);

	
	//.tab adds it to the creative tab
	//creates the item itself
	public static final RegistryObject<Item> EXAMPLE_ITEM = register("example_item",
			() -> new ExampleItem(new Item.Properties().tab(MyMod.TUTORIAL_TAB)));
	
	//get the block example_block in item form
	//public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block",
			//() -> new BlockItem(BlockInit.EXAMPLE_BLOCK.get(), new Item.Properties().tab(MyMod.TUTORIAL_TAB)));
	
	//create ruby item in the tutorial_tab creative tab
	public static final RegistryObject<Item> RUBY = register("ruby", () -> new Item(new Item.Properties().tab(MyMod.TUTORIAL_TAB).rarity(Rarity.EPIC)));
	//create citrine item
	public static final RegistryObject<Item> CITRINE = register("citrine", () -> new Item(new Item.Properties().tab(MyMod.TUTORIAL_TAB).rarity(Rarity.EPIC)));
	//create exquisite_sapphire item
	public static final RegistryObject<Item> EXQUISITE_SAPPHIRE = register("exquisite_sapphire", () -> new Item(new Item.Properties().tab(MyMod.TUTORIAL_TAB).rarity(Rarity.EPIC)));
    
	//create advanced item. destroys item when used and comes back when used again
	public static final RegistryObject<ClickerItem> CLICKER = 
			ITEMS.register("clicker", () -> new ClickerItem(new Item.Properties().tab(MyMod.TUTORIAL_TAB).rarity(Rarity.EPIC)));

	
	//TODO: create ruby tools and armor
	
	//create spawn egg for example_entity AKA Mud Frog
	//hexadeciaml fields are first and secondary colors of the spawn egg item
	public static final RegistryObject<ForgeSpawnEggItem> EXAMPLE_ENTITY_SPAWN_EGG =
			ITEMS.register("example_entity_spawn_egg",
					() -> new ForgeSpawnEggItem(EntityInit.EXAMPLE_ENTITY, 0xa87f32, 0x89a832, new Item.Properties().tab(MyMod.TUTORIAL_TAB)
							.tab(CreativeModeTab.TAB_MISC).stacksTo(64)));
	

	
	
	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
		return ITEMS.register(name, item);
	}
}
