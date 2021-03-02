package com.ragnardragus.scalinghealthprogress.items.hearts;

import com.ragnardragus.scalinghealthprogress.config.ModConfig;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class ItemHeartContainerEnderDragon extends BaseHeartContainer {

	public ItemHeartContainerEnderDragon() {
		super("enderdragon_heart", "enderdragon_heart", 
				ModConfig.enderDragonHeartConfig.minimum_hearts_to_enderdragon_heart, 
				ModConfig.enderDragonHeartConfig.maximum_hearts_to_enderdragon_heart,
				ModConfig.enderDragonHeartConfig.minimum_levels_to_enderdragon_heart);
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.EPIC;
	}
}
