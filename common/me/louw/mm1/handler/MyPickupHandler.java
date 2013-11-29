package me.louw.mm1.handler;

import me.louw.mm1.achievements.Achievements;
import me.louw.mm1.block.Blocks;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.IPickupNotifier;

public class MyPickupHandler implements IPickupNotifier {

	public MyPickupHandler() {

	}

	@Override
	public void notifyPickup(EntityItem item, EntityPlayer player) {
		if (item.getEntityItem().itemID == Blocks.grens.blockID) {
			player.addStat(Achievements.cGrens, 1);
		} else if (item.getEntityItem().itemID == Blocks.blok.blockID) {
			player.addStat(Achievements.cBlok, 1);
		} else if (item.getEntityItem().itemID == Blocks.bron.blockID) {
			player.addStat(Achievements.cBron, 1);
		} else if (item.getEntityItem().itemID == Blocks.dust.blockID) {
			player.addStat(Achievements.cDust, 1);
		} else if (item.getEntityItem().itemID == Blocks.dwood.blockID) {
			player.addStat(Achievements.cDwood, 1);
		}
	}

}
