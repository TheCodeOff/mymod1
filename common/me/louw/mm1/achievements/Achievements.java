package me.louw.mm1.achievements;

import me.louw.mm1.MyMod;
import me.louw.mm1.block.Blocks;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Achievements {
	// Achievements - Blocks
	public static Achievement cGrens = new Achievement(MyMod.ids.get(), "cGrens", -6, -1, Blocks.grens,
			AchievementList.openInventory);
	public static Achievement cBlok = new Achievement(MyMod.ids.get(), "cBlok", -8, -2, Blocks.blok, cGrens);
	public static Achievement cBron = new Achievement(MyMod.ids.get(), "cBron", -8, -4, Blocks.bron, cGrens);
	public static Achievement cDust = new Achievement(MyMod.ids.get(), "cDust", -4, -3, Blocks.dust, cGrens);
	public static Achievement cDwood = new Achievement(MyMod.ids.get(), "cDwood", -4, -5, Blocks.dwood, cGrens);
	// Achievements - Stairs
	public static Achievement cGrensStairs = new Achievement(MyMod.ids.get(), "cGrensStairs", -7, 0,
			Blocks.grensStairs, cGrens);
	public static Achievement cBlokStairs = new Achievement(MyMod.ids.get(), "cBlokStairs", -9, -3, Blocks.blokStairs, cBlok);
	public static Achievement cBronStairs = new Achievement(MyMod.ids.get(), "cBronStairs", -9, -5, Blocks.bronStairs, cBron);
	public static Achievement cDustStairs = new Achievement(MyMod.ids.get(), "cDustStairs", -3, -4, Blocks.dustStairs, cDust);
	public static Achievement cDwoodStairs = new Achievement(MyMod.ids.get(), "cDwoodStairs", -3, -6, Blocks.dwoodStairs,
			cDwood);

	// Page3
	// public static AchievementPage achievementPage = new
	// AchievementPage("My Mod 1", cGrens, cBlok, cBron, cDust,
	// cDwood);

	public Achievements() {
	}

	/**
	 * Register the achievements.
	 */
	public void registerAchievements() {
		System.out.print("Registering Achievements");
		registerAchievement(cGrens, "Going Grens!", "You're on your way to grenser fields!");
		registerAchievement(cBlok, "Get Blokky", "It's time to get Blokky!");
		registerAchievement(cBron, "Get Bron", "Source");
		registerAchievement(cDust, "Get Dust", "Another one bites the dust.");
		registerAchievement(cDwood, "Get Darkwood", "The latest in dark wood..");
		registerAchievement(cGrensStairs, "Going Grens!", "One small step...");
		registerAchievement(cBlokStairs, "Blokky Stairs", "...for Hermes...");
		registerAchievement(cBronStairs, "Bronny Steps", "...one huge block...");
		registerAchievement(cDustStairs, "Dusty Staircase", "...for predators...");
		registerAchievement(cDwoodStairs, "Woody Trappe!", "...in the world!");
		// AchievementPage.registerAchievementPage(achievementPage);
	}

	private void registerAchievement(Achievement achievement, String name, String desc) {
		achievement.registerAchievement();
		LanguageRegistry.instance().addStringLocalization(achievement.statName, name);
		LanguageRegistry.instance().addStringLocalization(achievement.statName + ".desc", desc);
	}
}
