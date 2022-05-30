package com.jolee.mymod.init;

import java.util.function.Function;

import javax.xml.xpath.XPathFunctionException;


import com.google.common.base.Supplier;
import com.jolee.mymod.MyMod;
import com.jolee.mymod.common.block.LightningJumperBlock;
import com.jolee.mymod.common.block.ToiletBlock;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
	
	//register blocks and both blocks and items in one class
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MyMod.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;
	
	//create the EXAMPLE_BLOCK block itself, with material metal and color purple, and create a new item that will be put in the creative tutorial tab
	//also has blast resistance and mining resistance of float 3.0f
	public static final RegistryObject<Block> EXAMPLE_BLOCK = register("example_block",
	       () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_PURPLE).strength(3.0f).sound(SoundType.METAL).requiresCorrectToolForDrops()),
	       object -> () -> new BlockItem(object.get() ,new Item.Properties().tab(MyMod.TUTORIAL_TAB)));
	
	//create exquisite sapphire ore
	public static final RegistryObject<Block> EXQUISITE_SAPPHIRE_ORE = register("exquisite_sapphire_ore",
		       () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLUE).strength(3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()),
		       object -> () -> new BlockItem(object.get() ,new Item.Properties().tab(MyMod.TUTORIAL_TAB)));
	
	//create advanced block
	public static final RegistryObject<LightningJumperBlock> LIGHTNING_JUMPER = BLOCKS.register("lightning_jumper",
            () -> new LightningJumperBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.TERRACOTTA_ORANGE)
                    .strength(8.0f, 30f).requiresCorrectToolForDrops().noOcclusion().dynamicShape()));
	
	//entity block toilet
	public static final RegistryObject<ToiletBlock> TOILET = BLOCKS.register("toilet",
            () -> new ToiletBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).noOcclusion().dynamicShape()));
	
	
	//register the block
	
	private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<? extends T> block) {
		return BLOCKS.register(name, block);
	}
	
	private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block,
			                                                    Function<RegistryObject<T>, Supplier<? extends Item>> item) {
		
		//registers block with "name" of the block, and register a block based on the item that is given
		RegistryObject<T> obj = registerBlock(name, block);
		ITEMS.register(name, item.apply(obj));
		return obj;
	}
}
