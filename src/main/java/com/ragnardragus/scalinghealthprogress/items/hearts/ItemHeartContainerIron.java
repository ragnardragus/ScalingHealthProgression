package com.ragnardragus.scalinghealthprogress.items.hearts;

import com.ragnardragus.scalinghealthprogress.config.ModConfig;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class ItemHeartContainerIron extends BaseHeartContainer {

	public ItemHeartContainerIron() {
		super("heartcontainer_iron", "heartcontainer_iron", 
				ModConfig.ironHeartConfig.minimum_hearts_to_iron_heart, 
				ModConfig.ironHeartConfig.maximum_hearts_to_iron_heart, 
				ModConfig.ironHeartConfig.minimum_levels_to_iron_heart);
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.EPIC;
	}
	
	
}
