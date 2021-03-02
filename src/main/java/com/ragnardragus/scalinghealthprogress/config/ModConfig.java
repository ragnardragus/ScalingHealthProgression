package com.ragnardragus.scalinghealthprogress.config;

import com.ragnardragus.scalinghealthprogress.reference.Reference;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.RangeInt;
import net.minecraftforge.common.config.Config.RequiresMcRestart;

@Config(modid = Reference.MODID)
@LangKey(Reference.MODID + ".config.title")
public class ModConfig {

	// Heart Container
	@LangKey(Reference.MODID + ".config.heartcontainer.category")
	public static HeartContainerConfig heartContainerConfig = new HeartContainerConfig();

	public static class HeartContainerConfig {
		
		@LangKey(Reference.MODID + ".config.heartcontainer.minimum_hearts")
		@Comment({ "Set the minimum hearts to use Heart Container" })
		@RangeInt(min = 1, max = 1024)
		@RequiresMcRestart
		public int maximum_hearts_to_heart_container = 10;
	}

	// Enderman Heart
	@LangKey(Reference.MODID + ".config.enderman_heart.category")
	public static EndermanHeartConfig endermanHeartConfig = new EndermanHeartConfig();

	public static class EndermanHeartConfig {
		
		@LangKey(Reference.MODID + ".config.enderman_heart.minimum_hearts")
		@Comment({ "Set the minimum hearts to use Enderman Heart" })
		@RangeInt(min = 1, max = 1024)
		@RequiresMcRestart
		public int minimum_hearts_to_enderman_heart = 11;

		@LangKey(Reference.MODID + ".config.enderman_heart.maximum_hearts")
		@Comment({ "Set the maximum hearts to use Enderman Heart" })
		@RangeInt(min = 1, max = 1024)
		@RequiresMcRestart
		public int maximum_hearts_to_enderman_heart = 11;

		@LangKey(Reference.MODID + ".config.enderman_heart.minimum_levels")
		@Comment({ "Set the minimum levels to use Enderman Heart" })
		@RangeInt(min = 1)
		@RequiresMcRestart
		public int minimum_levels_to_enderman_heart = 5;
	}
	
	// Blaze Heart
	@LangKey(Reference.MODID + ".config.blaze_heart.category")
	public static BlazeHeartConfig blazeHeartConfig = new BlazeHeartConfig();

	public static class BlazeHeartConfig {
		
		@LangKey(Reference.MODID + ".config.blaze_heart.minimum_hearts")
		@Comment({ "Set the minimum hearts to use Blaze Heart" })
		@RangeInt(min = 1, max = 1024)
		@RequiresMcRestart
		public int minimum_hearts_to_blaze_heart = 12;

		@LangKey(Reference.MODID + ".config.blaze_heart.maximum_hearts")
		@Comment({ "Set the maximum hearts to use Blaze Heart" })
		@RangeInt(min = 1, max = 1024)
		@RequiresMcRestart
		public int maximum_hearts_to_blaze_heart = 12;

		@LangKey(Reference.MODID + ".config.blaze_heart.minimum_levels")
		@Comment({ "Set the minimum levels to use Blaze Heart" })
		@RangeInt(min = 1)
		@RequiresMcRestart
		public int minimum_levels_to_blaze_heart = 8;
	}
	
	// Blaze Heart
	@LangKey(Reference.MODID + ".config.vindicatorheart.category")
	public static VindicatorHeartConfig vindicatorHeartConfig = new VindicatorHeartConfig();
	
	public static class VindicatorHeartConfig {
		
		@LangKey(Reference.MODID + ".config.vindicator_heart.minimum_hearts")
		@Comment({ "Set the minimum hearts to use Vindicator Heart" })
		@RangeInt(min = 1, max = 1024)
		@RequiresMcRestart
		public int minimum_hearts_to_vindicator_heart = 13;

		@LangKey(Reference.MODID + ".config.vindicator_heart.maximum_hearts")
		@Comment({ "Set the maximum hearts to use Vindicator Heart" })
		@RangeInt(min = 1, max = 1024)
		@RequiresMcRestart
		public int maximum_hearts_to_vindicator_heart = 13;

		@LangKey(Reference.MODID + ".config.vindicator_heart.minimum_levels")
		@Comment({ "Set the minimum levels to use Vindicator Heart" })
		@RangeInt(min = 1)
		@RequiresMcRestart
		public int minimum_levels_to_vindicator_heart = 15;
	}
	
	@LangKey(Reference.MODID + ".config.witherheart.category")
	public static WitherHeartConfig witherHeartConfig = new WitherHeartConfig();
	
	public static class WitherHeartConfig {
		
		@LangKey(Reference.MODID + ".config.wither_heart.minimum_hearts")
		@Comment({ "Set the minimum hearts to use Wither Heart" })
		@RangeInt(min = 1, max = 1024)
		@RequiresMcRestart
		public int minimum_hearts_to_wither_heart = 14;

		@LangKey(Reference.MODID + ".config.wither_heart.maximum_hearts")
		@Comment({ "Set the maximum hearts to use Wither Heart" })
		@RangeInt(min = 1, max = 1024)
		@RequiresMcRestart
		public int maximum_hearts_to_wither_heart = 14;

		@LangKey(Reference.MODID + ".config.wither_heart.minimum_levels")
		@Comment({ "Set the minimum levels to use Wither Heart" })
		@RangeInt(min = 1)
		@RequiresMcRestart
		public int minimum_levels_to_wither_heart = 23;
	}
	
	@LangKey(Reference.MODID + ".config.guardian_heart.category")
	public static GuardianHeartConfig guardianHeartConfig = new GuardianHeartConfig();
	
	public static class GuardianHeartConfig {
		
		@LangKey(Reference.MODID + ".config.guardian_heart.minimum_hearts")
		@Comment({ "Set the minimum hearts to use Guardian Heart" })
		@RangeInt(min = 1, max = 1024)
		@RequiresMcRestart
		public int minimum_hearts_to_guardian_heart = 15;

		@LangKey(Reference.MODID + ".config.guardian_heart.maximum_hearts")
		@Comment({ "Set the maximum hearts to use Guardian Heart" })
		@RangeInt(min = 1, max = 1024)
		@RequiresMcRestart
		public int maximum_hearts_to_guardian_heart = 15;

		@LangKey(Reference.MODID + ".config.guardian_heart.minimum_levels")
		@Comment({ "Set the minimum levels to use Guardian Heart" })
		@RangeInt(min = 1)
		@RequiresMcRestart
		public int minimum_levels_to_guardian_heart = 30;
	}
	
	@LangKey(Reference.MODID + ".config.witherboss_heart.category")
	public static WitherBossHeartConfig witherBossHeartConfig = new WitherBossHeartConfig();
	
	public static class WitherBossHeartConfig {
		
		@LangKey(Reference.MODID + ".config.witherboss_heart.minimum_hearts")
		@Comment({ "Set the minimum hearts to use Wither Boss Heart" })
		@RangeInt(min = 1, max = 1024)
		@RequiresMcRestart
		public int minimum_hearts_to_witherboss_heart = 16;

		@LangKey(Reference.MODID + ".config.witherboss_heart.maximum_hearts")
		@Comment({ "Set the maximum hearts to use Wither Boss Heart" })
		@RangeInt(min = 1, max = 1024)
		@RequiresMcRestart
		public int maximum_hearts_to_guardian_heart = 16;

		@LangKey(Reference.MODID + ".config.witherboss_heart.minimum_levels")
		@Comment({ "Set the minimum levels to use Wither Boss Heart" })
		@RangeInt(min = 1)
		@RequiresMcRestart
		public int minimum_levels_to_witherboss_heart = 47;
	}
	
	@LangKey(Reference.MODID + ".config.enderdragon_heart.category")
	public static EnderDragonHeartConfig enderDragonHeartConfig = new EnderDragonHeartConfig();
	
	public static class EnderDragonHeartConfig {
		
		@LangKey(Reference.MODID + ".config.enderdragon_heart.minimum_hearts")
		@Comment({ "Set the minimum hearts to use Ender Dragon Heart" })
		@RangeInt(min = 1, max = 1024)
		@RequiresMcRestart
		public int minimum_hearts_to_enderdragon_heart = 17;

		@LangKey(Reference.MODID + ".config.enderdragon_heart.maximum_hearts")
		@Comment({ "Set the maximum hearts to use Ender Dragon Heart" })
		@RangeInt(min = 1, max = 1024)
		@RequiresMcRestart
		public int maximum_hearts_to_enderdragon_heart = 17;

		@LangKey(Reference.MODID + ".config.enderdragon_heart.minimum_levels")
		@Comment({ "Set the minimum levels to use Ender Dragon Heart" })
		@RangeInt(min = 1)
		@RequiresMcRestart
		public int minimum_levels_to_enderdragon_heart = 61;
	}
	
	@LangKey(Reference.MODID + ".config.heartcontaoner_iron.category")
	public static IronHeartConfig ironHeartConfig = new IronHeartConfig();
	
	public static class IronHeartConfig {
		
		@LangKey(Reference.MODID + ".config.heartcontainer_iron.minimum_hearts")
		@Comment({ "Set the minimum hearts to use Iron Heart" })
		@RangeInt(min = 1, max = 1024)
		@RequiresMcRestart
		public int minimum_hearts_to_iron_heart = 18;

		@LangKey(Reference.MODID + ".config.heartcontainer_iron.maximum_hearts")
		@Comment({ "Set the maximum hearts to use Iron Heart" })
		@RangeInt(min = 1, max = 1024)
		@RequiresMcRestart
		public int maximum_hearts_to_iron_heart = 18;

		@LangKey(Reference.MODID + ".config.heartcontainer_iron.minimum_levels")
		@Comment({ "Set the minimum levels to use Iron Heart" })
		@RangeInt(min = 1)
		@RequiresMcRestart
		public int minimum_levels_to_iron_heart = 77;
	}
	
	@LangKey(Reference.MODID + ".config.heartcontaoner_gold.category")
	public static GoldHeartConfig goldHeartConfig = new GoldHeartConfig();
	
	public static class GoldHeartConfig {
		
		@LangKey(Reference.MODID + ".config.heartcontainer_gold.minimum_hearts")
		@Comment({ "Set the minimum hearts to use Gold Heart" })
		@RangeInt(min = 1, max = 1024)
		@RequiresMcRestart
		public int minimum_hearts_to_gold_heart = 19;

		@LangKey(Reference.MODID + ".config.heartcontainer_gold.maximum_hearts")
		@Comment({ "Set the maximum hearts to use Gold Heart" })
		@RangeInt(min = 1, max = 1024)
		@RequiresMcRestart
		public int maximum_hearts_to_gold_heart = 19;

		@LangKey(Reference.MODID + ".config.heartcontainer_gold.minimum_levels")
		@Comment({ "Set the minimum levels to use Gold Heart" })
		@RangeInt(min = 1)
		@RequiresMcRestart
		public int minimum_levels_to_gold_heart = 86;
	}
	
	@LangKey(Reference.MODID + ".config.heartcontaoner_diamond.category")
	public static DiamondHeartConfig diamondHeartConfig = new DiamondHeartConfig();
	
	public static class DiamondHeartConfig {
		
		@LangKey(Reference.MODID + ".config.heartcontainer_diamond.minimum_hearts")
		@Comment({ "Set the minimum hearts to use Diamond Heart" })
		@RangeInt(min = 1, max = 1024)
		@RequiresMcRestart
		public int minimum_hearts_to_diamond_heart = 20;

		@LangKey(Reference.MODID + ".config.heartcontainer_diamond.maximum_hearts")
		@Comment({ "Set the maximum hearts to use Gold Heart" })
		@RangeInt(min = 1, max = 1024)
		@RequiresMcRestart
		public int maximum_hearts_to_diamond_heart = 29;

		@LangKey(Reference.MODID + ".config.heartcontainer_diamond.minimum_levels")
		@Comment({ "Set the minimum levels to use Diamond Heart" })
		@RangeInt(min = 1)
		@RequiresMcRestart
		public int minimum_levels_to_diamond_heart = 99;
	}
}
