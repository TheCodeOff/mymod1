package me.louw.mm1;

import me.louw.mm1.block.Blocker;
import me.louw.mm1.block.MyBlock;
import me.louw.mm1.block.MyStairs;
import me.louw.mm1.handler.MyFuelHandler;
import me.louw.mm1.handler.RecipeHandler;
import me.louw.mm1.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.ID, version = Reference.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class MyMod {

	private static Blocker blocker;
	private static Block[] blocks;
	private static RecipeHandler recipes;
	private static IDClaimer ids = new IDClaimer(500);

	/*---------------------------------------- Blocks -----------------------------------------*/
	public static Block blok = new MyBlock(ids.get(), MyBlock.UNI_TEXTURED, "blok", "Blok", Material.clay, 3F);
	public static Block bron = new MyBlock(ids.get(), MyBlock.UNI_TEXTURED, "bron", "Bron", Material.clay, 3F);
	public static Block dust = new MyBlock(ids.get(), MyBlock.UNI_TEXTURED, "dust", "Dust", Material.clay, 3F);
	public static Block grens = new MyBlock(ids.get(), MyBlock.UNI_TEXTURED, "grens", "Grens", Material.clay, 3F);
	public static Block ore = new MyBlock(ids.get(), MyBlock.UNI_TEXTURED, "ore", "Mod Ore", Material.rock, 3F);
	public static Block dwood = new MyBlock(ids.get(), MyBlock.SIDE_TEXTURED, "dwood", "Darkwood", Material.rock, 3F);
	/*---------------------------------------- Stairs -----------------------------------------*/
	public static Block blokStairs = new MyStairs(ids.get(), blok, 0, "blokstairs", "Blok Stairs", 3F);
	public static Block bronStairs = new MyStairs(ids.get(), bron, 0, "bronstairs", "Bron Stairs", 3F);
	public static Block dustStairs = new MyStairs(ids.get(), dust, 0, "duststairs", "Dust Stairs", 3F);
	public static Block grensStairs = new MyStairs(ids.get(), grens, 0, "grensstairs", "Grens Stairs", 3F);
	public static Block dwoodStairs = new MyStairs(ids.get(), dwood, 0, "woodstairs", "Darkwood Stairs", 3F);

	@SidedProxy(clientSide = "me.louw.mm1.proxy.ClientProxy", serverSide = "me.louw.mm1.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		blocker = new Blocker(CreativeTabs.tabBlock);
		recipes = new RecipeHandler();
		blocks = new Block[] { blok, bron, dust, grens, ore, dwood, blokStairs, bronStairs, dustStairs, grensStairs,
				dwoodStairs };
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		blocker.addBlocks(blocks);
		recipes.addRecipe(RecipeHandler.SHAPED, new ItemStack(blocks[3]), new Object[] { "AAA", "AAA", "AAA", 'A',
				blocks[2] });
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		GameRegistry.registerFuelHandler(new MyFuelHandler(blocks));
	}
}
