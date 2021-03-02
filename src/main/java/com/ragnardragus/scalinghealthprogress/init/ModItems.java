package com.ragnardragus.scalinghealthprogress.init;

import java.util.ArrayList;
import java.util.List;

import com.ragnardragus.scalinghealthprogress.items.hearts.ItemHeartContainerBlaze;
import com.ragnardragus.scalinghealthprogress.items.hearts.ItemHeartContainerDiamond;
import com.ragnardragus.scalinghealthprogress.items.hearts.ItemHeartContainerEnderDragon;
import com.ragnardragus.scalinghealthprogress.items.hearts.ItemHeartContainerEnderman;
import com.ragnardragus.scalinghealthprogress.items.hearts.ItemHeartContainerGold;
import com.ragnardragus.scalinghealthprogress.items.hearts.ItemHeartContainerGuardian;
import com.ragnardragus.scalinghealthprogress.items.hearts.ItemHeartContainerIron;
import com.ragnardragus.scalinghealthprogress.items.hearts.ItemHeartContainerVindicator;
import com.ragnardragus.scalinghealthprogress.items.hearts.ItemHeartContainerWither;
import com.ragnardragus.scalinghealthprogress.items.hearts.ItemHeartContainerWitherBoss;
import com.ragnardragus.scalinghealthprogress.items.shards.ItemBlazeShard;
import com.ragnardragus.scalinghealthprogress.items.shards.ItemEnderDragonShard;
import com.ragnardragus.scalinghealthprogress.items.shards.ItemEndermanShard;
import com.ragnardragus.scalinghealthprogress.items.shards.ItemGuardianShard;
import com.ragnardragus.scalinghealthprogress.items.shards.ItemVindicatorShard;
import com.ragnardragus.scalinghealthprogress.items.shards.ItemWitherBossShard;
import com.ragnardragus.scalinghealthprogress.items.shards.ItemWitherShard;

import net.minecraft.item.Item;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item SHARD_ENDERMAN = new ItemEndermanShard();
	public static final Item SHARD_BLAZE = new ItemBlazeShard();
	public static final Item SHARD_VINDICATOR = new ItemVindicatorShard();
	public static final Item SHARD_WITHER = new ItemWitherShard();
	public static final Item SHARD_GUARDIAN = new ItemGuardianShard();
	public static final Item SHARD_WITHER_BOSS = new ItemWitherBossShard();
	public static final Item SHARD_ENDER_DRAGON = new ItemEnderDragonShard();
	
	public static final Item HEART_ENDERMAN = new ItemHeartContainerEnderman();
	public static final Item HEART_BLAZE = new ItemHeartContainerBlaze();
	public static final Item HEART_VINDICATOR = new ItemHeartContainerVindicator();
	public static final Item HEART_WITHER = new ItemHeartContainerWither();
	public static final Item HEART_GUARDIAN = new ItemHeartContainerGuardian();
	public static final Item HEART_WITHER_BOSS = new ItemHeartContainerWitherBoss();
	public static final Item HEART_ENDER_DRAGON = new ItemHeartContainerEnderDragon();
	public static final Item HEART_IRON = new ItemHeartContainerIron();
	public static final Item HEART_GOLD = new ItemHeartContainerGold();
	public static final Item HEART_DIAMOND = new ItemHeartContainerDiamond();
}
