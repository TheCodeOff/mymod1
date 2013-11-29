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
	 * One side texture also
	 */
	public static int UNI_SIDE_TEXTURED = 1;
	/**
	 * Multiple side textures also
	 */
	public static int MULTI_SIDE_TEXTURED = 2;

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
		} else if (textureStyle == UNI_SIDE_TEXTURED) {
			icons = new Icon[2];
			for (int i = 0; i < icons.length; i++) {
				icons[i] = iconRegister.registerIcon(Reference.ID.toLowerCase() + ":" + this.getUnlocalizedName() + i);
			}
		} else if (textureStyle == MULTI_SIDE_TEXTURED) {
			icons = new Icon[5];
			for (int i = 0; i < icons.length; i++) {
				icons[i] = iconRegister.registerIcon(Reference.ID.toLowerCase() + ":" + this.getUnlocalizedName() + i);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		if (textureStyle == UNI_TEXTURED) {
			return blockIcon;
		} else if (textureStyle == UNI_SIDE_TEXTURED) {
			if (side == 0 || side == 1) {
				// Top and bottom
				return icons[0];
			} else {
				// Sides
				return icons[1];
			}

		} else if (textureStyle == MULTI_SIDE_TEXTURED) {
			if (side == 0 || side == 1) {
				// Top and bottom
				return icons[0];
			} else {
				// Sides
				return icons[side - 1];
			}
		}
		return icons[0];
	}

	public String toString() {
		return "(" + blockID + "," + getUnlocalizedName() + ")";
	}
}
