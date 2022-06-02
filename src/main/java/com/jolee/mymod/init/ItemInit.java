package com.jolee.mymod.init;

import com.jolee.mymod.MyMod;
import com.jolee.mymod.item.ClickerItem;
import com.jolee.mymod.item.ExampleItem;
import com.google.common.base.Supplier;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
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

	//toilet item
	public static final RegistryObject<BlockItem> TOILET_ITEM = ITEMS.register("toilet",
            () -> new BlockItem(BlockInit.TOILET.get(), new Item.Properties().tab(MyMod.TUTORIAL_TAB)));
	
	public static final RegistryObject<BlockItem> DRAWER_ITEM = ITEMS.register("drawer",
	        () -> new BlockItem(BlockInit.DRAWER.get(), new Item.Properties().tab(MyMod.TUTORIAL_TAB)));
	    
	public static final RegistryObject<BlockItem> EXAMPLE_CHEST_ITEM = ITEMS.register("example_chest",
	        () -> new BlockItem(BlockInit.EXAMPLE_CHEST.get(), new Item.Properties().tab(MyMod.TUTORIAL_TAB)));
	    
	public static final RegistryObject<BlockItem> POOP_STORAGE_ITEM = ITEMS.register("poop_storage",
	        () -> new BlockItem(BlockInit.POOP_STORAGE.get(), new Item.Properties().tab(MyMod.TUTORIAL_TAB)));
	    
	public static final RegistryObject<BlockItem> DISPLAY_HAND_ITEM = ITEMS.register("display_hand",
	        () -> new BlockItem(BlockInit.DISPLAY_HAND.get(), new Item.Properties().tab(MyMod.TUTORIAL_TAB)));
	    
	public static final RegistryObject<BlockItem> ENERGY_STORAGE_ITEM = ITEMS.register("energy_storage",
	        () -> new BlockItem(BlockInit.ENERGY_STORAGE.get(), new Item.Properties().tab(MyMod.TUTORIAL_TAB)));
	    
	public static final RegistryObject<BlockItem> ENERGY_GENERATOR_ITEM = ITEMS.register("energy_generator",
	        () -> new BlockItem(BlockInit.ENERGY_GENERATOR.get(), new Item.Properties().tab(MyMod.TUTORIAL_TAB)));
	
	
	
	//TODO: create ruby tools and armor
	
	//create spawn egg for example_entity AKA Mud Frog
	//hexadeciaml fields are first and secondary colors of the spawn egg item
	public static final RegistryObject<ForgeSpawnEggItem> EXAMPLE_ENTITY_SPAWN_EGG =
			ITEMS.register("example_entity_spawn_egg",
					() -> new ForgeSpawnEggItem(EntityInit.EXAMPLE_ENTITY, 0xa87f32, 0x89a832, new Item.Properties().tab(MyMod.TUTORIAL_TAB)
							.tab(CreativeModeTab.TAB_MISC).stacksTo(64)));
	
	//create item for lightning jumper
	public static final RegistryObject<Item> LIGHTNING_JUMPER_BLOCK_ITEM = ITEMS.register("lightning_jumper",
			() -> new BlockItem(BlockInit.LIGHTNING_JUMPER.get(), new Item.Properties().tab(MyMod.TUTORIAL_TAB)));
	
	public static final RegistryObject<Item> BEANS = ITEMS.register("beans",
	        () -> new Item(new Item.Properties().tab(MyMod.TUTORIAL_TAB)
	            .food(new FoodProperties.Builder().nutrition(5).saturationMod(4.5f)
	                .effect(() -> new MobEffectInstance(MobEffects.JUMP, 360, 4), 0.7f)
	                .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 500, 2), 0.2f).build())));
	    
	public static final RegistryObject<Item> POOP = ITEMS.register("poop",
	        () -> new Item(new Item.Properties().tab(MyMod.TUTORIAL_TAB)
	            .food(new FoodProperties.Builder().nutrition(50).saturationMod(5f)
	                .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 5), 1f)
	                .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 500, 64), 1f).build())));
	    
	// Tools
    public static final RegistryObject<SwordItem> BEAN_SWORD = ITEMS.register("bean_sword",
        () -> new SwordItem(ToolMaterialInit.BEANS, 20, 5f, new Item.Properties().tab(MyMod.TUTORIAL_TAB)));
    
    public static final RegistryObject<PickaxeItem> BEAN_PICKAXE = ITEMS.register("bean_pickaxe",
        () -> new PickaxeItem(ToolMaterialInit.BEANS, 20, 5f, new Item.Properties().tab(MyMod.TUTORIAL_TAB)));
    
    public static final RegistryObject<ShovelItem> BEAN_SHOVEL = ITEMS.register("bean_shovel",
        () -> new ShovelItem(ToolMaterialInit.BEANS, 20, 5f, new Item.Properties().tab(MyMod.TUTORIAL_TAB)));
    
    public static final RegistryObject<AxeItem> BEAN_AXE = ITEMS.register("bean_axe",
        () -> new AxeItem(ToolMaterialInit.BEANS, 20, 5f, new Item.Properties().tab(MyMod.TUTORIAL_TAB)));
    
    public static final RegistryObject<HoeItem> BEAN_HOE = ITEMS.register("bean_hoe",
        () -> new HoeItem(ToolMaterialInit.BEANS, 20, 5f, new Item.Properties().tab(MyMod.TUTORIAL_TAB)));
    
    // Armor
    public static final RegistryObject<ArmorItem> BEAN_HELMET = ITEMS.register("bean_helmet",
        () -> new ArmorItem(ArmorMaterialInit.BEANS, EquipmentSlot.HEAD,
            new Item.Properties().tab(MyMod.TUTORIAL_TAB)));
    
    public static final RegistryObject<ArmorItem> BEAN_CHESTPLATE = ITEMS.register("bean_chestplate",
        () -> new ArmorItem(ArmorMaterialInit.BEANS, EquipmentSlot.CHEST,
            new Item.Properties().tab(MyMod.TUTORIAL_TAB)));
    
    public static final RegistryObject<ArmorItem> BEAN_LEGGINGS = ITEMS.register("bean_leggings",
        () -> new ArmorItem(ArmorMaterialInit.BEANS, EquipmentSlot.LEGS,
            new Item.Properties().tab(MyMod.TUTORIAL_TAB)));
    
    public static final RegistryObject<ArmorItem> BEAN_BOOTS = ITEMS.register("bean_boots",
        () -> new ArmorItem(ArmorMaterialInit.BEANS, EquipmentSlot.FEET,
            new Item.Properties().tab(MyMod.TUTORIAL_TAB)));    
	

	
	
	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
		return ITEMS.register(name, item);
	}
}
