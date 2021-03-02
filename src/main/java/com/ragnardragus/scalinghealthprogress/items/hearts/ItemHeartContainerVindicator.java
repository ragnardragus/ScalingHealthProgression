package com.ragnardragus.scalinghealthprogress.items.hearts;

import com.ragnardragus.scalinghealthprogress.config.ModConfig;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class ItemHeartContainerVindicator extends BaseHeartContainer {

	public ItemHeartContainerVindicator() {
		super("vindicator_heart", "vindicator_heart", 
				ModConfig.vindicatorHeartConfig.minimum_hearts_to_vindicator_heart, 
				ModConfig.vindicatorHeartConfig.maximum_hearts_to_vindicator_heart, 
				ModConfig.vindicatorHeartConfig.minimum_levels_to_vindicator_heart);
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}
}
