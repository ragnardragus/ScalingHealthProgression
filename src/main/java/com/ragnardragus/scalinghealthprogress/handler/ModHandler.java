package com.ragnardragus.scalinghealthprogress.handler;

import java.util.List;
import java.util.Random;

import com.google.common.collect.ImmutableList;
import com.ragnardragus.scalinghealthprogress.config.ModConfig;
import com.ragnardragus.scalinghealthprogress.init.ModItems;
import com.ragnardragus.scalinghealthprogress.items.hearts.BaseHeartContainer;
import com.ragnardragus.scalinghealthprogress.reference.Reference;
import com.ragnardragus.scalinghealthprogress.util.RandomUtil;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.silentchaos512.scalinghealth.item.ItemHeartContainer;
import net.silentchaos512.scalinghealth.utils.SHPlayerDataHandler;

public class ModHandler {

	private final Random rnd = new Random();

	@SubscribeEvent
	public void onItemUse(PlayerInteractEvent.RightClickItem event) {

		EntityPlayer player = event.getEntityPlayer();
		ItemStack stack = player.getHeldItemMainhand();
		SHPlayerDataHandler.PlayerData data = SHPlayerDataHandler.get(player);

		if (stack.getItem() instanceof ItemHeartContainer) {
			if (data.getHealth() > (ModConfig.heartContainerConfig.maximum_hearts_to_heart_container * 2)) {
				event.setCancellationResult(EnumActionResult.PASS);
				event.setCanceled(true);
			}
		}
	}

	@SubscribeEvent
	public void onItemTooltip(ItemTooltipEvent event) {
		ItemStack stack = event.getItemStack();
		if (stack.getItem() instanceof ItemHeartContainer) {
			if (event.getEntity() instanceof EntityPlayer) {

				EntityPlayer player = (EntityPlayer) event.getEntity();
				SHPlayerDataHandler.PlayerData data = SHPlayerDataHandler.get(player);

				TextFormatting color = data.getHealth() <= (ModConfig.heartContainerConfig.maximum_hearts_to_heart_container * 2) ? TextFormatting.GREEN : TextFormatting.RED;
				String tx = color
						+ new TextComponentTranslation("You need to have " + ModConfig.heartContainerConfig.maximum_hearts_to_heart_container + " hearts or less", false).getFormattedText();
				event.getToolTip().add(1, tx);
			}
		} else if (stack.getItem() instanceof BaseHeartContainer) {
			if (event.getEntity() instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) event.getEntity();
				SHPlayerDataHandler.PlayerData data = SHPlayerDataHandler.get(player);
				BaseHeartContainer item = (BaseHeartContainer) stack.getItem();

				String tx = item.getRequiementMessage(data).getFormattedText();
				event.getToolTip().add(1, tx);
			}
		}
	}

	@SubscribeEvent
	public void addEntityDrops(LivingDropsEvent event) {

		List<EntityItem> drops = event.getDrops();
		if (drops instanceof ImmutableList) {
			System.err
					.println("WARNING: Some mod is returning an ImmutableList, replacing drops will NOT be possible.");
			return;
		}
		
		if (event.getEntityLiving() instanceof EntityEnderman) {
			addDropsToEntity(drops, event.getEntityLiving(), 25f, ModItems.SHARD_ENDERMAN, event.getLootingLevel(), 1, 3, 3, 8);
			addDropsToEntity(drops, event.getEntityLiving(), 1f, ModItems.HEART_ENDERMAN, event.getLootingLevel(), 1, 1, 2, 2);
		}
		
		if (event.getEntityLiving() instanceof EntityBlaze) {
			addDropsToEntity(drops, event.getEntityLiving(), 25f, ModItems.SHARD_BLAZE, event.getLootingLevel(), 1, 3, 3, 8);
			addDropsToEntity(drops, event.getEntityLiving(), 1f, ModItems.HEART_BLAZE, event.getLootingLevel(), 1, 1, 1, 2);
		}
		
		if (event.getEntityLiving() instanceof EntityVindicator) {
			addDropsToEntity(drops, event.getEntityLiving(), 25f, ModItems.SHARD_VINDICATOR, event.getLootingLevel(), 1, 3, 3, 8);
			addDropsToEntity(drops, event.getEntityLiving(), 1f, ModItems.HEART_VINDICATOR, event.getLootingLevel(), 1, 1, 1, 2);
		}
		
		if (event.getEntityLiving() instanceof EntityWitherSkeleton) {
			addDropsToEntity(drops, event.getEntityLiving(), 25f, ModItems.SHARD_WITHER, event.getLootingLevel(), 1, 3, 3, 8);
			addDropsToEntity(drops, event.getEntityLiving(), 1f, ModItems.HEART_WITHER, event.getLootingLevel(), 1, 1, 1, 2);
		}
		
		if (event.getEntityLiving() instanceof EntityGuardian) {
			addDropsToEntity(drops, event.getEntityLiving(), 25f, ModItems.SHARD_GUARDIAN, event.getLootingLevel(), 1, 3, 3, 8);
			addDropsToEntity(drops, event.getEntityLiving(), 1f, ModItems.HEART_GUARDIAN, event.getLootingLevel(), 1, 1, 1, 2);
		}
		
		if (event.getEntityLiving() instanceof EntityWither) {
			addDropsToEntity(drops, event.getEntityLiving(), 100f, ModItems.SHARD_WITHER_BOSS, event.getLootingLevel(), 4, 5, 4, 6);
			addDropsToEntity(drops, event.getEntityLiving(), 5f, ModItems.HEART_WITHER_BOSS, event.getLootingLevel(), 1, 1, 1, 1);
		}
		
		if (event.getEntityLiving() instanceof EntityDragon) {
			addDropsToEntity(drops, event.getEntityLiving(), 100f, ModItems.SHARD_ENDER_DRAGON, event.getLootingLevel(), 4, 3, 4, 7);
			addDropsToEntity(drops, event.getEntityLiving(), 5f, ModItems.HEART_ENDER_DRAGON, event.getLootingLevel(), 1, 1, 1, 1);
		}
	}
	
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.getModID().equals(Reference.MODID)) {
			ConfigManager.sync(Reference.MODID, Config.Type.INSTANCE);
		}
	}
	
	private void addDropsToEntity(List<EntityItem> drops, EntityLivingBase entity, float dropPercentage, Item itemToDrop, 
			int lootingLevel, int minimumSize, int maximumSize, int minimumSizeLooting, int maximumSizeLooting) {
		if (rnd.nextFloat() < dropPercentage/100f) {
			ItemStack stack = lootingLevel < 1 ? 
					new ItemStack(itemToDrop, RandomUtil.getIntegerRandByRange(minimumSize, maximumSize), 0) : 
					new ItemStack(itemToDrop, RandomUtil.getIntegerRandByRange(minimumSizeLooting, maximumSizeLooting), 0);

			drops.add(new EntityItem(entity.getEntityWorld(), entity.posX, entity.posY, entity.posZ, stack));
		}
	}
}
