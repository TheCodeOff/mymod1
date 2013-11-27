package me.louw.mm1.handler;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class MyFuelHandler implements IFuelHandler {

	private Block[] usableBlocks;

	public MyFuelHandler(Block[] usableBlocks) {
		this.usableBlocks = usableBlocks;
	}

	@Override
	public int getBurnTime(ItemStack fuel) {
		for(int i = 0; i < usableBlocks.length; i++){
			if(fuel.itemID == usableBlocks[i].blockID){
				return 1000;
			}
		}
		return 0;
	}

}
