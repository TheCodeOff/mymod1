package me.louw.mm1.handler;

import me.louw.mm1.block.Blocks;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class MyRecipeHandler {

	public static boolean SHAPELESS = false;
	public static boolean SHAPED = true;

	public MyRecipeHandler() {
	}

	public void addRecipe(boolean isShaped, ItemStack gives, Object[] costs) {
		if (isShaped) {
			GameRegistry.addShapedRecipe(gives, costs);
		} else {
			GameRegistry.addShapelessRecipe(gives, costs);
		}
	}

	public void addSmeltingRecipe(int inputID, ItemStack outputID, float xp) {
		GameRegistry.addSmelting(inputID, outputID, xp);
	}

	public void addRecipes() {
		// For creating stairs
		addRecipe(SHAPED, new ItemStack(Blocks.blokStairs, 3), new Object[] { "A  ", "AA ", "AAA", 'A', Blocks.blok });
		addRecipe(SHAPED, new ItemStack(Blocks.bronStairs, 3), new Object[] { "A  ", "AA ", "AAA", 'A', Blocks.bron });
		addRecipe(SHAPED, new ItemStack(Blocks.dustStairs, 3), new Object[] { "A  ", "AA ", "AAA", 'A', Blocks.dust });
		addRecipe(SHAPED, new ItemStack(Blocks.grensStairs, 3), new Object[] { "A  ", "AA ", "AAA", 'A', Blocks.grens });
		addRecipe(SHAPED, new ItemStack(Blocks.dwoodStairs, 3), new Object[] { "A  ", "AA ", "AAA", 'A', Blocks.dwood });
		// For exchanging types.
		addRecipe(SHAPELESS, new ItemStack(Blocks.bron, 1), new Object[] { Blocks.blok });
		addRecipe(SHAPELESS, new ItemStack(Blocks.dust, 1), new Object[] { Blocks.bron });
		addRecipe(SHAPELESS, new ItemStack(Blocks.grens, 1), new Object[] { Blocks.dust });
		addRecipe(SHAPELESS, new ItemStack(Blocks.dwood, 1), new Object[] { Blocks.grens });
		addRecipe(SHAPELESS, new ItemStack(Blocks.blok, 1), new Object[] { Blocks.dwood });
	}
}
