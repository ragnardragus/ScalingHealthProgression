package com.ragnardragus.scalinghealthprogress.items.hearts;

import com.ragnardragus.scalinghealthprogress.config.ModConfig;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class ItemHeartContainerEnderman extends BaseHeartContainer {

	public ItemHeartContainerEnderman() {
		super("enderman_heart", "enderman_heart", 
				ModConfig.endermanHeartConfig.minimum_hearts_to_enderman_heart, 
				ModConfig.endermanHeartConfig.maximum_hearts_to_enderman_heart, 
				ModConfig.endermanHeartConfig.minimum_levels_to_enderman_heart);
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}
}
