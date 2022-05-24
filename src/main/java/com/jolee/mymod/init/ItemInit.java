package com.jolee.mymod.init;

import com.jolee.mymod.MyMod;
import com.jolee.mymod.item.ExampleItem;
import com.google.common.base.Supplier;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
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
	
	//create ruby item in the tutorial_tab creative tab
	public static final RegistryObject<Item> RUBY = register("ruby", () -> new Item(new Item.Properties().tab(MyMod.TUTORIAL_TAB).rarity(Rarity.EPIC)));
	//create citrine item
	public static final RegistryObject<Item> CITRINE = register("citrine", () -> new Item(new Item.Properties().tab(MyMod.TUTORIAL_TAB).rarity(Rarity.EPIC)));
	//create exquisite_sapphire item
	public static final RegistryObject<Item> EXQUISITE_SAPPHIRE = register("exquisite_sapphire", () -> new Item(new Item.Properties().tab(MyMod.TUTORIAL_TAB).rarity(Rarity.EPIC)));

	
	
	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
		return ITEMS.register(name, item);
	}
}
