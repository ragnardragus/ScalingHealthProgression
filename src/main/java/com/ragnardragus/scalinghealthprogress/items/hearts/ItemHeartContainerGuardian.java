package com.ragnardragus.scalinghealthprogress.items.hearts;

import com.ragnardragus.scalinghealthprogress.config.ModConfig;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class ItemHeartContainerGuardian extends BaseHeartContainer {

	public ItemHeartContainerGuardian() {
		super("guardian_heart", "guardian_heart", 
				ModConfig.guardianHeartConfig.minimum_hearts_to_guardian_heart, 
				ModConfig.guardianHeartConfig.maximum_hearts_to_guardian_heart, 
				ModConfig.guardianHeartConfig.minimum_levels_to_guardian_heart);
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}
}
