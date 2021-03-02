package com.ragnardragus.scalinghealthprogress.items.hearts;

import java.util.List;

import javax.annotation.Nonnull;

import com.ragnardragus.scalinghealthprogress.items.BaseItem;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.silentchaos512.lib.util.ChatHelper;
import net.silentchaos512.lib.util.Color;
import net.silentchaos512.lib.util.EntityHelper;
import net.silentchaos512.scalinghealth.ScalingHealth;
import net.silentchaos512.scalinghealth.config.Config;
import net.silentchaos512.scalinghealth.init.ModSounds;
import net.silentchaos512.scalinghealth.lib.EnumModParticles;
import net.silentchaos512.scalinghealth.network.NetworkHandler;
import net.silentchaos512.scalinghealth.network.message.MessageDataSync;
import net.silentchaos512.scalinghealth.utils.SHPlayerDataHandler;
import net.silentchaos512.scalinghealth.utils.SHPlayerDataHandler.PlayerData;

public class BaseHeartContainer extends BaseItem {

	private int minHearts = 1;
	private int maxHearts = 1024;
	private int minLevelRequirement = 3;

	public BaseHeartContainer(String name, String registry, int minHearts, int maxHearts, int minLevelRequirement) {
		super(name, registry);
		this.minHearts = minHearts;
		this.maxHearts = maxHearts;
		this.minLevelRequirement = minLevelRequirement;
	}
	
	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
		tooltip.add(new TextComponentTranslation("item.heartcontainer_p.desc", new Object()).getFormattedText());
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);

		if (!world.isRemote) {
			SHPlayerDataHandler.PlayerData data = SHPlayerDataHandler.get(player);
			if (data == null)
				return ActionResult.newResult(EnumActionResult.PASS, stack);

			boolean healthIncreaseAllowed = isHealthIncreaseAllowed(data);
			int levelRequirement = getLevelsRequiredToUse(player, stack, healthIncreaseAllowed);

			if (player.experienceLevel < levelRequirement) {
				ChatHelper.translateStatus(player, ScalingHealth.i18n.getKey(this, "notEnoughXP"), true,
						new Object[] { Integer.valueOf(levelRequirement) });
				return ActionResult.newResult(EnumActionResult.PASS, stack);
			}

			if (!haveHeartsRequirimentToUse(data)) {
				return ActionResult.newResult(EnumActionResult.PASS, stack);
			}

			boolean consumed = (Config.Items.Heart.healthRestored > 0 && player.getHealth() < player.getMaxHealth());
			if (consumed) {
				doExtraHealing(player);
			}

			if (!healthIncreaseAllowed) {
				return useAsHealingItem(world, player, stack, levelRequirement, consumed);
			}

			useForHealthIncrease(world, player, stack, data, levelRequirement);

		}

		return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
	}

	private void useForHealthIncrease(World world, EntityPlayer player, ItemStack stack, PlayerData data,
			int levelRequirement) {
		data.incrementMaxHealth(2);
		stack.shrink(1);
		spawnParticlesAndPlaySound(world, player);
		consumeLevels(player, levelRequirement);
		incrementUseStat(player);
		NetworkHandler.INSTANCE.sendTo(new MessageDataSync(data, player), (EntityPlayerMP) player);
	}

	private void incrementUseStat(EntityPlayer player) {
		StatBase useStat = StatList.getObjectUseStats(this);
		if (useStat != null)
			player.addStat(useStat);
	}

	@Nonnull
	private ActionResult<ItemStack> useAsHealingItem(World world, EntityPlayer player, ItemStack stack,
			int levelRequirement, boolean consumed) {
		if (consumed) {
			world.playSound(null, player.getPosition(), SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F,
					1.0F + 0.1F * (float) ScalingHealth.random.nextGaussian());
			stack.shrink(1);
			consumeLevels(player, levelRequirement);
			incrementUseStat(player);
			return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
		} else {
			return ActionResult.newResult(EnumActionResult.PASS, stack);
		}
	}

	private static void doExtraHealing(EntityPlayer player) {
		int current = (int) player.getHealth();
		EntityHelper.heal(player, Config.Items.Heart.healthRestored, Config.Items.Heart.healingEvent);
		int newHealth = (int) player.getHealth();
		if (current + Config.Items.Heart.healthRestored != newHealth) {
			ScalingHealth.logHelper.warn(
					"Another mod seems to have canceled healing from a heart container (player {})",
					new Object[] { player.getName() });
		}
	}

	private int getLevelsRequiredToUse(EntityPlayer player, ItemStack stack, boolean healthIncreaseAllowed) {
		return player.capabilities.isCreativeMode ? 0 : this.minLevelRequirement;
	}

	private static boolean isHealthIncreaseAllowed(SHPlayerDataHandler.PlayerData data) {
		return (Config.Items.Heart.increaseHealth
				&& (Config.Player.Health.maxHealth == 0 || data.getMaxHealth() < Config.Player.Health.maxHealth));
	}

	private static void consumeLevels(EntityPlayer player, int amount) {
		player.experienceLevel -= amount;
	}

	private static void spawnParticlesAndPlaySound(World world, EntityPlayer player) {
		double particleX = player.posX;
		double particleY = player.posY + 0.65f * player.height;
		double particleZ = player.posZ;
		for (int i = 0; i < 40 - 10 * ScalingHealth.proxy.getParticleSettings(); ++i) {
			double xSpeed = 0.08 * ScalingHealth.random.nextGaussian();
			double ySpeed = 0.05 * ScalingHealth.random.nextGaussian();
			double zSpeed = 0.08 * ScalingHealth.random.nextGaussian();
			ScalingHealth.proxy.spawnParticles(EnumModParticles.HEART_CONTAINER, new Color(1f, 0f, 0f), world,
					particleX, particleY, particleZ, xSpeed, ySpeed, zSpeed);
		}
		ScalingHealth.proxy.playSoundOnClient(player, ModSounds.HEART_CONTAINER_USE, 0.5f,
				1.0f + 0.1f * (float) ScalingHealth.random.nextGaussian());
	}

	public boolean haveHeartsRequirimentToUse(SHPlayerDataHandler.PlayerData data) {
		return data.getHealth() >= (minHearts * 2) && data.getHealth() <= (maxHearts * 2);
	}

	public TextComponentTranslation getRequiementMessage(SHPlayerDataHandler.PlayerData data) {

		TextComponentTranslation tct = null;
		
		if (minHearts == maxHearts) {
			tct = new TextComponentTranslation("scalinghealthprogress.hearts_need_equals", maxHearts);
		} else if (minHearts == 1) {
			tct = new TextComponentTranslation("scalinghealthprogress.hearts_need_minimum", maxHearts);
		} else if (maxHearts >= 1024) {
			tct = new TextComponentTranslation("scalinghealthprogress.hearts_need_maximum", minHearts);
		} else if (minHearts < maxHearts) {
			tct = new TextComponentTranslation("scalinghealthprogress.hearts_need_range", minHearts, maxHearts);
		}
		
		TextFormatting color = haveHeartsRequirimentToUse(data) ? TextFormatting.GREEN : TextFormatting.RED;
		Style style = new Style();
		style.setColor(color);
		tct.setStyle(style);

		return tct;
	}
}
