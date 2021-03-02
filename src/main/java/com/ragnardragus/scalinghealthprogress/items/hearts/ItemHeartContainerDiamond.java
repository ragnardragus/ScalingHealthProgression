package com.ragnardragus.scalinghealthprogress.items.hearts;

import com.ragnardragus.scalinghealthprogress.config.ModConfig;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class ItemHeartContainerDiamond extends BaseHeartContainer {

	public ItemHeartContainerDiamond() {
		super("heartcontainer_diamond", "heartcontainer_diamond", 
				ModConfig.diamondHeartConfig.minimum_hearts_to_diamond_heart, 
				ModConfig.diamondHeartConfig.maximum_hearts_to_diamond_heart, 
				ModConfig.diamondHeartConfig.minimum_levels_to_diamond_heart);
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.EPIC;
	}
	
	
}
