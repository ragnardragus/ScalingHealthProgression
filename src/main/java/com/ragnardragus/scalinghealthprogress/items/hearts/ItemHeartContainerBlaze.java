package com.ragnardragus.scalinghealthprogress.items.hearts;

import com.ragnardragus.scalinghealthprogress.config.ModConfig;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class ItemHeartContainerBlaze extends BaseHeartContainer {

	public ItemHeartContainerBlaze() {
		super("blaze_heart", "blaze_heart", 
				ModConfig.blazeHeartConfig.minimum_hearts_to_blaze_heart, 
				ModConfig.blazeHeartConfig.maximum_hearts_to_blaze_heart, 
				ModConfig.blazeHeartConfig.minimum_levels_to_blaze_heart);
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}
}
