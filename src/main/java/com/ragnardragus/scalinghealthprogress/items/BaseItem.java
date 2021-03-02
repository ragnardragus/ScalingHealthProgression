package com.ragnardragus.scalinghealthprogress.items;

import com.ragnardragus.scalinghealthprogress.ScalingHealthProgress;
import com.ragnardragus.scalinghealthprogress.api.IHashModel;
import com.ragnardragus.scalinghealthprogress.init.ModItems;

import net.minecraft.item.Item;
import net.silentchaos512.scalinghealth.ScalingHealth;

public class BaseItem extends Item implements IHashModel {

	public BaseItem(String name, String registry) {
		setUnlocalizedName(name);
		setRegistryName(registry);
		setCreativeTab(ScalingHealth.creativeTab);

		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		ScalingHealthProgress.proxy.registerItemRender(this, 0, "inventory");
	}

}
