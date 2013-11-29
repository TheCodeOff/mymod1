package me.louw.mm1.block;

import me.louw.mm1.MyMod;
import me.louw.mm1.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Blocks {

	// Blocks
	public static Block blok = new MyBlock(MyMod.ids.get(), MyBlock.UNI_TEXTURED, "blok", "Blok", Material.clay, 3F);
	public static Block bron = new MyBlock(MyMod.ids.get(), MyBlock.UNI_TEXTURED, "bron", "Bron", Material.clay, 3F);
	public static Block dust = new MyBlock(MyMod.ids.get(), MyBlock.UNI_TEXTURED, "dust", "Dust", Material.clay, 3F);
	public static Block grens = new MyBlock(MyMod.ids.get(), MyBlock.UNI_TEXTURED, "grens", "Grens", Material.clay, 3F);
	public static Block ore = new MyBlock(MyMod.ids.get(), MyBlock.UNI_TEXTURED, "ore", "Mod Ore", Material.rock, 3F);
	public static Block dwood = new MyBlock(MyMod.ids.get(), MyBlock.UNI_SIDE_TEXTURED, "dwood", "Darkwood",
			Material.rock, 3F);
	public static Block glas = new MyBlockOpaque(MyMod.ids.get(), MyBlock.UNI_TEXTURED, "glas", "Glas", Material.glass,
			2F);
	// Stairs
	public static Block blokStairs = new MyStairs(MyMod.ids.get(), blok, 0, "blokstairs", "Blok Stairs", 3F);
	public static Block bronStairs = new MyStairs(MyMod.ids.get(), bron, 0, "bronstairs", "Bron Stairs", 3F);
	public static Block dustStairs = new MyStairs(MyMod.ids.get(), dust, 0, "duststairs", "Dust Stairs", 3F);
	public static Block grensStairs = new MyStairs(MyMod.ids.get(), grens, 0, "grensstairs", "Grens Stairs", 3F);
	public static Block dwoodStairs = new MyStairs(MyMod.ids.get(), dwood, 0, "woodstairs", "Darkwood Stairs", 3F);
	// Arrays
	public static Block[] blockList = new Block[] { blok, bron, dust, grens, ore, dwood, glas, blokStairs, bronStairs,
			dustStairs, grensStairs, dwoodStairs };
	// Creative Tab
	public static CreativeTabs tabMyMod = new CreativeTabs(Reference.ID) {
		public ItemStack getIconItemStack() {
			return new ItemStack(Blocks.grens, 1, 0);
		}
	};

	public Blocks() {
		LanguageRegistry.instance().addStringLocalization("itemGroup." + Reference.ID, Reference.NAME);
	}

	/**
	 * Add a block to the game.
	 * 
	 * @param block
	 * 
	 */
	@SideOnly(Side.CLIENT)
	public void addBlock(Block block) {
		block.setCreativeTab(tabMyMod);
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
		if (block instanceof MyBlock) {
			LanguageRegistry.addName(block, ((MyBlock) block).localName);
		} else if (block instanceof MyStairs) {
			LanguageRegistry.addName(block, ((MyStairs) block).localName);
		}
	}

	/**
	 * Add a array of blockList to the game.
	 * 
	 * @param blockList
	 */
	@SideOnly(Side.CLIENT)
	public void addBlocks() {
		System.out.println("Registering Blocks");
		for (Block block : blockList) {
			addBlock(block);
		}
	}
}