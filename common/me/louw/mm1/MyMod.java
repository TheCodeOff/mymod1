package me.louw.mm1;

import me.louw.mm1.achievements.Achievements;
import me.louw.mm1.block.Blocks;
import me.louw.mm1.entity.Entities;
import me.louw.mm1.handler.MyCraftingHandler;
import me.louw.mm1.handler.MyFuelHandler;
import me.louw.mm1.handler.MyPickupHandler;
import me.louw.mm1.handler.MyRecipeHandler;
import me.louw.mm1.proxy.CommonProxy;
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

	// Proxy
	@SidedProxy(clientSide = "me.louw.mm1.proxy.ClientProxy", serverSide = "me.louw.mm1.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	// Blocks
	private static Blocks blocker;
	// Recipes
	private static MyRecipeHandler recipes;
	// Entities
	private static Entities entities;
	// Achievements
	public static Achievements achievements;
	// ID Manager
	public static IDClaimer ids = new IDClaimer(1000);

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		blocker = new Blocks();
		recipes = new MyRecipeHandler();
		entities = new Entities();
		achievements = new Achievements();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		blocker.addBlocks();
		entities.addEntities(this);
		recipes.addRecipes();
		achievements.registerAchievements();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		GameRegistry.registerFuelHandler(new MyFuelHandler(Blocks.blockList));
		GameRegistry.registerCraftingHandler(new MyCraftingHandler());
		GameRegistry.registerPickupHandler(new MyPickupHandler());
	}
}
