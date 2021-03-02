package com.ragnardragus.scalinghealthprogress.items.hearts;

import com.ragnardragus.scalinghealthprogress.config.ModConfig;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class ItemHeartContainerWitherBoss extends BaseHeartContainer {

	public ItemHeartContainerWitherBoss() {
		super("witherboss_heart", "witherboss_heart", 
				ModConfig.witherBossHeartConfig.minimum_hearts_to_witherboss_heart, 
				ModConfig.witherBossHeartConfig.maximum_hearts_to_guardian_heart,
				ModConfig.witherBossHeartConfig.minimum_levels_to_witherboss_heart);
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.EPIC;
	}
}
