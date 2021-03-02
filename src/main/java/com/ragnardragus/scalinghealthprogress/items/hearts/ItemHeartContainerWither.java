package com.ragnardragus.scalinghealthprogress.items.hearts;

import com.ragnardragus.scalinghealthprogress.config.ModConfig;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class ItemHeartContainerWither extends BaseHeartContainer {

	public ItemHeartContainerWither() {
		super("wither_heart", "wither_heart", 
				ModConfig.witherHeartConfig.minimum_hearts_to_wither_heart, 
				ModConfig.witherHeartConfig.maximum_hearts_to_wither_heart, 
				ModConfig.witherHeartConfig.minimum_levels_to_wither_heart);
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}
}
