package me.louw.mm1.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class MyStairs extends BlockStairs {

	public String localName;

	/**
	 * Create new custom stairs block.
	 * 
	 * @param id
	 * @param block
	 * @param metadata
	 */
	public MyStairs(int id, Block block, int metadata, String unlocalName, String localName, float hardness) {
		super(id, block, metadata);
		this.setUnlocalizedName(unlocalName);
		this.localName = localName;
		this.setHardness(hardness);
	}

}