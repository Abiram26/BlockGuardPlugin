package com.abiram26.blockguard.storage;

public class Config {
	private boolean DefaultFlag_Can_player_break_block;
	private boolean DefaultFlag_Can_player_place_block;
	private boolean DefaultFlag_Can_player_interact_bed;
	private boolean DefaultFlag_Can_player_interact_electronic;
	private boolean DefaultFlag_Can_player_interact_chest;
	private boolean DefaultFlag_Can_player_interact_TNT;
	private boolean DefaultFlag_Can_player_interact_trashcan;
	private boolean DefaultFlag_Can_player_interact_paintbucket;
	private boolean DefaultFlag_Can_player_interact_canvas;
	private boolean DefaultFlag_Can_player_interact_elevator;
	private boolean DefaultFlag_Can_player_interact_door;
	private boolean DefaultFlag_Can_player_open_chest;
	private boolean DefaultFlag_Can_player_execute_command;
	private boolean DefaultFlag_Can_player_attack_player;
	private boolean DefaultFlag_Can_player_attack_NPC;
	private boolean DefaultFlag_Can_player_pickup_item;
	private boolean DefaultFlag_Can_player_drop_item;
	private boolean DefaultFlag_Can_player_die;
	private boolean DefaultFlag_Can_player_heal;
	private boolean DefaultFlag_Can_player_receive_damage;
	private boolean DefaultFlag_Can_player_teleport;
	private boolean DefaultFlag_Can_player_chat_public;
	private boolean DefaultFlag_Can_player_chat;
	private boolean DefaultFlag_Can_player_wield;
	private boolean DefaultFlag_Can_player_unwield;
	private boolean DefaultFlag_Can_player_setspawn;
	private boolean DefaultFlag_Can_player_text_sign;
	private boolean DefaultFlag_Can_NPC_move;
	private boolean DefaultFlag_Can_NPC_attack_player;
	private boolean DefaultFlag_Can_NPC_attack_NPC;
	private boolean DefaultFlag_Can_NPC_die;
	private boolean DefaultFlag_Can_NPC_heal;
	private boolean DefaultFlag_Can_NPC_receive_damage;
	private boolean DefaultFlag_Can_NPC_spawn;
	private boolean DefaultFlag_Can_NPC_interact;
	private boolean DefaultFlag_Can_grass_grow;
	private boolean DefaultFlag_Can_plant_grow;
	private boolean DefaultFlag_Can_tree_grow;
	private boolean DefaultFlag_Can_TNT_explode;
	private boolean DefaultFlag_Can_block_gravitate;
	private boolean DefaultFlag_Can_block_decay;
	private boolean automaticRegionOwnerTag;
	private int blockGuardLimitedVolumeMaximum;
	private int blockGuardLimitedLengthMinimum;
	private int blockGuardLimitedRegionMaximum;
	private boolean automaticRectangularCuboids;
	private boolean automaticOverlapCheck;
	private int overlapMaximumPercentage;
	private boolean enableMovementTracker;

	public Config() {
		DefaultFlag_Can_player_break_block = false;
		DefaultFlag_Can_player_place_block = false;
		DefaultFlag_Can_player_interact_bed = false;
		DefaultFlag_Can_player_interact_electronic = false;
		DefaultFlag_Can_player_interact_chest = false;
		DefaultFlag_Can_player_interact_TNT = false;
		DefaultFlag_Can_player_interact_trashcan = true;
		DefaultFlag_Can_player_interact_paintbucket = true;
		DefaultFlag_Can_player_interact_canvas = false;
		DefaultFlag_Can_player_interact_elevator = true;
		DefaultFlag_Can_player_interact_door = true;
		DefaultFlag_Can_player_open_chest = false;
		DefaultFlag_Can_player_execute_command = true;
		DefaultFlag_Can_player_attack_player = false;
		DefaultFlag_Can_player_attack_NPC = true;
		DefaultFlag_Can_player_pickup_item = true;
		DefaultFlag_Can_player_drop_item = true;
		DefaultFlag_Can_player_die = true;
		DefaultFlag_Can_player_heal = true;
		DefaultFlag_Can_player_receive_damage = true;
		DefaultFlag_Can_player_teleport = true;
		DefaultFlag_Can_player_chat_public = true;
		DefaultFlag_Can_player_chat = true;
		DefaultFlag_Can_player_wield = true;
		DefaultFlag_Can_player_unwield = true;
		DefaultFlag_Can_player_setspawn = false;
		DefaultFlag_Can_player_text_sign = false;
		DefaultFlag_Can_NPC_move = true;
		DefaultFlag_Can_NPC_attack_player = false;
		DefaultFlag_Can_NPC_attack_NPC = true;
		DefaultFlag_Can_NPC_die = true;
		DefaultFlag_Can_NPC_heal = true;
		DefaultFlag_Can_NPC_receive_damage = true;
		DefaultFlag_Can_NPC_spawn = true;
		DefaultFlag_Can_NPC_interact = false;
		DefaultFlag_Can_grass_grow = true;
		DefaultFlag_Can_plant_grow = true;
		DefaultFlag_Can_tree_grow = false;
		DefaultFlag_Can_TNT_explode = false;
		DefaultFlag_Can_block_gravitate = true;
		DefaultFlag_Can_block_decay = true;
		blockGuardLimitedVolumeMaximum = 30;
		automaticRegionOwnerTag = false;
		blockGuardLimitedRegionMaximum = 3;
		blockGuardLimitedLengthMinimum = 3;
		automaticRectangularCuboids = false;
		automaticOverlapCheck = false;
		overlapMaximumPercentage = 75;
		enableMovementTracker = false;
	}

	public int getBlockGuardLimitedBlockVolumeLimit() {
		return blockGuardLimitedVolumeMaximum;
	}

	public int getBlockGuardLimitedLengthMinimum() {
		return blockGuardLimitedLengthMinimum;
	}

	public int getBlockGuardLimitedVolumeMaximum() {
		return blockGuardLimitedVolumeMaximum;
	}

	public boolean isAutoRegionOwnerTag() {
		return automaticRegionOwnerTag;
	}

	public int getBlockGuardLimitedRegionMaximum() {
		return blockGuardLimitedRegionMaximum;
	}

	public boolean isAutomaticRectangularCuboids() {
		return automaticRectangularCuboids;
	}

	public boolean isAutomaticOverlapCheck() {
		return automaticOverlapCheck;
	}

	public int getOverlapMaximumPercentage() {
		return overlapMaximumPercentage;
	}

	public boolean isEnableMovementTracker() {
		return enableMovementTracker;
	}

	public boolean isDefaultFlag_Can_player_break_block() {
		return DefaultFlag_Can_player_break_block;
	}

	public boolean isDefaultFlag_Can_player_place_block() {
		return DefaultFlag_Can_player_place_block;
	}

	public boolean isDefaultFlag_Can_player_interact_bed() {
		return DefaultFlag_Can_player_interact_bed;
	}

	public boolean isDefaultFlag_Can_player_interact_electronic() {
		return DefaultFlag_Can_player_interact_electronic;
	}

	public boolean isDefaultFlag_Can_player_interact_chest() {
		return DefaultFlag_Can_player_interact_chest;
	}

	public boolean isDefaultFlag_Can_player_interact_TNT() {
		return DefaultFlag_Can_player_interact_TNT;
	}

	public boolean isDefaultFlag_Can_player_interact_trashcan() {
		return DefaultFlag_Can_player_interact_trashcan;
	}

	public boolean isDefaultFlag_Can_player_interact_paintbucket() {
		return DefaultFlag_Can_player_interact_paintbucket;
	}

	public boolean isDefaultFlag_Can_player_interact_canvas() {
		return DefaultFlag_Can_player_interact_canvas;
	}

	public boolean isDefaultFlag_Can_player_interact_elevator() {
		return DefaultFlag_Can_player_interact_elevator;
	}

	public boolean isDefaultFlag_Can_player_open_chest() {
		return DefaultFlag_Can_player_open_chest;
	}

	public boolean isDefaultFlag_Can_player_execute_command() {
		return DefaultFlag_Can_player_execute_command;
	}

	public boolean isDefaultFlag_Can_player_attack_player() {
		return DefaultFlag_Can_player_attack_player;
	}

	public boolean isDefaultFlag_Can_player_attack_NPC() {
		return DefaultFlag_Can_player_attack_NPC;
	}

	public boolean isDefaultFlag_Can_player_pickup_item() {
		return DefaultFlag_Can_player_pickup_item;
	}

	public boolean isDefaultFlag_Can_player_drop_item() {
		return DefaultFlag_Can_player_drop_item;
	}

	public boolean isDefaultFlag_Can_player_die() {
		return DefaultFlag_Can_player_die;
	}

	public boolean isDefaultFlag_Can_player_heal() {
		return DefaultFlag_Can_player_heal;
	}

	public boolean isDefaultFlag_Can_player_receive_damage() {
		return DefaultFlag_Can_player_receive_damage;
	}

	public boolean isDefaultFlag_Can_player_teleport() {
		return DefaultFlag_Can_player_teleport;
	}

	public boolean isDefaultFlag_Can_player_chat_public() {
		return DefaultFlag_Can_player_chat_public;
	}

	public boolean isDefaultFlag_Can_player_chat() {
		return DefaultFlag_Can_player_chat;
	}

	public boolean isDefaultFlag_Can_player_wield() {
		return DefaultFlag_Can_player_wield;
	}

	public boolean isDefaultFlag_Can_player_unwield() {
		return DefaultFlag_Can_player_unwield;
	}

	public boolean isDefaultFlag_Can_player_setspawn() {
		return DefaultFlag_Can_player_setspawn;
	}

	public boolean isDefaultFlag_Can_player_text_sign() {
		return DefaultFlag_Can_player_text_sign;
	}

	public boolean isDefaultFlag_Can_NPC_move() {
		return DefaultFlag_Can_NPC_move;
	}

	public boolean isDefaultFlag_Can_NPC_attack_player() {
		return DefaultFlag_Can_NPC_attack_player;
	}

	public boolean isDefaultFlag_Can_NPC_attack_NPC() {
		return DefaultFlag_Can_NPC_attack_NPC;
	}

	public boolean isDefaultFlag_Can_NPC_die() {
		return DefaultFlag_Can_NPC_die;
	}

	public boolean isDefaultFlag_Can_NPC_heal() {
		return DefaultFlag_Can_NPC_heal;
	}

	public boolean isDefaultFlag_Can_NPC_receive_damage() {
		return DefaultFlag_Can_NPC_receive_damage;
	}

	public boolean isDefaultFlag_Can_NPC_spawn() {
		return DefaultFlag_Can_NPC_spawn;
	}

	public boolean isDefaultFlag_Can_NPC_interact() {
		return DefaultFlag_Can_NPC_interact;
	}

	public boolean isDefaultFlag_Can_grass_grow() {
		return DefaultFlag_Can_grass_grow;
	}

	public boolean isDefaultFlag_Can_plant_grow() {
		return DefaultFlag_Can_plant_grow;
	}

	public boolean isDefaultFlag_Can_tree_grow() {
		return DefaultFlag_Can_tree_grow;
	}

	public boolean isDefaultFlag_Can_TNT_explode() {
		return DefaultFlag_Can_TNT_explode;
	}

	public boolean isDefaultFlag_Can_block_gravitate() {
		return DefaultFlag_Can_block_gravitate;
	}

	public boolean isDefaultFlag_Can_block_decay() {
		return DefaultFlag_Can_block_decay;
	}

	public boolean isAutomaticRegionOwnerTag() {
		return automaticRegionOwnerTag;
	}
	public boolean isDefaultFlag_Can_player_interact_door() {
		return DefaultFlag_Can_player_interact_door;
	}

	public boolean[] getDefaultBooleans() {
		boolean[] flagBooleans = new boolean[] {
				this.DefaultFlag_Can_player_break_block,
				this.DefaultFlag_Can_player_place_block,
				this.DefaultFlag_Can_player_interact_bed,
				this.DefaultFlag_Can_player_interact_electronic,
				this.DefaultFlag_Can_player_interact_chest,
				this.DefaultFlag_Can_player_interact_TNT,
				this.DefaultFlag_Can_player_interact_trashcan,
				this.DefaultFlag_Can_player_interact_paintbucket,
				this.DefaultFlag_Can_player_interact_canvas,
				this.DefaultFlag_Can_player_interact_elevator,
				this.DefaultFlag_Can_player_open_chest,
				this.DefaultFlag_Can_player_execute_command,
				this.DefaultFlag_Can_player_attack_player,
				this.DefaultFlag_Can_player_attack_NPC,
				this.DefaultFlag_Can_player_pickup_item,
				this.DefaultFlag_Can_player_drop_item,
				this.DefaultFlag_Can_player_die,
				this.DefaultFlag_Can_player_heal,
				this.DefaultFlag_Can_player_receive_damage,
				this.DefaultFlag_Can_player_teleport,
				this.DefaultFlag_Can_player_chat_public,
				this.DefaultFlag_Can_player_chat,
				this.DefaultFlag_Can_player_wield,
				this.DefaultFlag_Can_player_unwield,
				this.DefaultFlag_Can_player_setspawn,
				this.DefaultFlag_Can_player_text_sign,
				this.DefaultFlag_Can_NPC_move,
				this.DefaultFlag_Can_NPC_attack_player,
				this.DefaultFlag_Can_NPC_attack_NPC,
				this.DefaultFlag_Can_NPC_die, this.DefaultFlag_Can_NPC_heal,
				this.DefaultFlag_Can_NPC_receive_damage,
				this.DefaultFlag_Can_NPC_spawn,
				this.DefaultFlag_Can_NPC_interact,
				this.DefaultFlag_Can_grass_grow,
				this.DefaultFlag_Can_plant_grow,
				this.DefaultFlag_Can_tree_grow,
				this.DefaultFlag_Can_TNT_explode,
				this.DefaultFlag_Can_block_gravitate,
				this.DefaultFlag_Can_block_decay,
				this.DefaultFlag_Can_player_interact_door};

		return flagBooleans;
	}

}
