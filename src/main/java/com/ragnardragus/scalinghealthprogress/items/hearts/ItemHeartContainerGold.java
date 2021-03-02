package com.ragnardragus.scalinghealthprogress.items.hearts;

import com.ragnardragus.scalinghealthprogress.config.ModConfig;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class ItemHeartContainerGold extends BaseHeartContainer {

	public ItemHeartContainerGold() {
		super("heartcontainer_gold", "heartcontainer_gold", 
				ModConfig.goldHeartConfig.minimum_hearts_to_gold_heart, 
				ModConfig.goldHeartConfig.maximum_hearts_to_gold_heart, 
				ModConfig.goldHeartConfig.minimum_levels_to_gold_heart);
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.EPIC;
	}
	
	
}
