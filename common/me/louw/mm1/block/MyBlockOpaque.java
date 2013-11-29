package me.louw.mm1.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;

public class MyBlockOpaque extends MyBlock {

	public MyBlockOpaque(int id, int ts, String unlocalName, String localName, Material material, float hardness) {
		super(id, ts, unlocalName, localName, material, hardness);
	}

	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 0;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	protected boolean canSilkHarvest() {
		return true;
	}

}
