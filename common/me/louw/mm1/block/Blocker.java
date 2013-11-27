package me.louw.mm1.block;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Blocker {

	private CreativeTabs tab;

	public Blocker(CreativeTabs tab) {
		this.tab = tab;
	}

	/**
	 * Add a block to game.
	 * 
	 * @param block
	 * 
	 */
	@SideOnly(Side.CLIENT)
	public void addBlock(Block block) {
		block.setCreativeTab(tab);

		GameRegistry.registerBlock(block, block.getUnlocalizedName());

		if (block instanceof MyBlock) {
			LanguageRegistry.addName(block, ((MyBlock) block).localName);
		} else if (block instanceof MyStairs) {
			LanguageRegistry.addName(block, ((MyStairs) block).localName);
		}
	}

	/**
	 * Add a array of blocks to the game.
	 * 
	 * @param blocks
	 */
	@SideOnly(Side.CLIENT)
	public void addBlocks(Block[] blocks) {
		for (Block block : blocks) {
			addBlock(block);
		}
	}
}