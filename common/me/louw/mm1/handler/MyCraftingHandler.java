package me.louw.mm1.handler;

import me.louw.mm1.achievements.Achievements;
import me.louw.mm1.block.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class MyCraftingHandler implements ICraftingHandler{

	public MyCraftingHandler(){
		
	}

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) {
		if (item.itemID == Blocks.grens.blockID) {
			player.addStat(Achievements.cGrens, 1);
		} else if (item.itemID == Blocks.blok.blockID) {
			player.addStat(Achievements.cBlok, 1);
		} else if (item.itemID == Blocks.bron.blockID) {
			player.addStat(Achievements.cBron, 1);
		} else if (item.itemID == Blocks.dust.blockID) {
			player.addStat(Achievements.cDust, 1);
		} else if (item.itemID == Blocks.dwood.blockID) {
			player.addStat(Achievements.cDwood, 1);
		}
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {

	}

}
