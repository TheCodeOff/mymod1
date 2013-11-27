package me.louw.mm1.block;

import me.louw.mm1.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MyBlock extends Block {

	/**
	 * Just one texture
	 */
	public static int UNI_TEXTURED = 0;
	/**
	 * Side textures also
	 */
	public static int SIDE_TEXTURED = 1;

	public String localName;
	private int textureStyle;

	@SideOnly(Side.CLIENT)
	private Icon[] icons;

	/**
	 * Custom Block class
	 * 
	 * @param id
	 * @param unlocalName
	 * @param localName
	 * @param material
	 * @param hardness
	 */
	public MyBlock(int id, int textureStyle, String unlocalName, String localName, Material material, float hardness) {
		super(id, material);
		this.setUnlocalizedName(unlocalName);
		this.textureStyle = textureStyle;
		this.localName = localName;
		this.textureName = unlocalName;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		if (textureStyle == UNI_TEXTURED) {
			this.blockIcon = iconRegister.registerIcon(Reference.ID.toLowerCase() + ":" + this.getUnlocalizedName());
		} else if (textureStyle == SIDE_TEXTURED) {
			icons = new Icon[2];
			for (int i = 0; i < icons.length; i++) {
				icons[i] = iconRegister.registerIcon(Reference.ID.toLowerCase() + ":" + this.getUnlocalizedName() + i);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		if (textureStyle == UNI_TEXTURED) {
			return blockIcon;
		}
		if (par1 == 0 || par1 == 1) {
			// Top and bottom
			return icons[0];
		} else {
			// Sides
			return icons[1];
		}
	}

	public String toString() {
		return "(" + blockID + "," + getUnlocalizedName() + ")";
	}
}
