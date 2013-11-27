package me.louw.mm1.handler;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeHandler {

	public static boolean SHAPELESS = false;
	public static boolean SHAPED = true;

	public RecipeHandler() {
	}

	public void addRecipe(boolean isShaped, ItemStack gives, Object[] costs) {
		if (isShaped) {
			GameRegistry.addShapedRecipe(gives, costs);
		} else {
			GameRegistry.addShapelessRecipe(gives, costs);
		}
	}
	
	public void addSmeltingRecipe(int inputID, ItemStack outputID, float xp){
		GameRegistry.addSmelting(inputID, outputID, xp);
	}
}
