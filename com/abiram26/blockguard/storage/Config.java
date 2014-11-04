package com.abiram26.blockguard.storage;

public class Config {
	private boolean default_Flag_Can_player_break_block;
	private boolean default_Flag_Can_player_place_block;
	private boolean default_Flag_Can_player_interact_bed;
	private boolean default_Flag_Can_player_interact_electronic;
	private boolean default_Flag_Can_player_interact_chest;
	private boolean default_Flag_Can_player_interact_TNT;
	private boolean default_Flag_Can_player_interact_trashcan;
	private boolean default_Flag_Can_player_interact_paintbucket;
	private boolean default_Flag_Can_player_interact_canvas;
	private boolean default_Flag_Can_player_interact_elevator;
	private boolean default_Flag_Can_player_interact_door;
	private boolean default_Flag_Can_player_open_chest;
	private boolean default_Flag_Can_player_execute_command;
	private boolean default_Flag_Can_player_attack_player;
	private boolean default_Flag_Can_player_attack_NPC;
	private boolean default_Flag_Can_player_pickup_item;
	private boolean default_Flag_Can_player_drop_item;
	private boolean default_Flag_Can_player_die;
	private boolean default_Flag_Can_player_heal;
	private boolean default_Flag_Can_player_receive_damage;
	private boolean default_Flag_Can_player_teleport;
	private boolean default_Flag_Can_player_chat_public;
	private boolean default_Flag_Can_player_chat;
	private boolean default_Flag_Can_player_wield;
	private boolean default_Flag_Can_player_unwield;
	private boolean default_Flag_Can_player_setspawn;
	private boolean default_Flag_Can_player_text_sign;
	private boolean default_Flag_Can_NPC_move;
	private boolean default_Flag_Can_NPC_attack_player;
	private boolean default_Flag_Can_NPC_attack_NPC;
	private boolean default_Flag_Can_NPC_die;
	private boolean default_Flag_Can_NPC_heal;
	private boolean default_Flag_Can_NPC_receive_damage;
	private boolean default_Flag_Can_NPC_spawn;
	private boolean default_Flag_Can_NPC_interact;
	private boolean default_Flag_Can_grass_grow;
	private boolean default_Flag_Can_plant_grow;
	private boolean default_Flag_Can_tree_grow;
	private boolean default_Flag_Can_TNT_explode;
	private boolean default_Flag_Can_block_gravitate;
	private boolean default_Flag_Can_block_decay;
	private boolean automatic_Region_Owner_Tag;
	private int blockguard_Limited_Volume_Maximum;
	private int blockguard_Limited_Length_Minimum;
	private int blockguard_Limited_Region_Maximum;
	private boolean automatic_Rectangular_Cuboids;
	private boolean automatic_Overlap_Check;
	private int overlap_Maximum_Percentage;
	private boolean enable_Movement_Tracker;

	public Config() {
		default_Flag_Can_player_break_block = false;
		default_Flag_Can_player_place_block = false;
		default_Flag_Can_player_interact_bed = false;
		default_Flag_Can_player_interact_electronic = false;
		default_Flag_Can_player_interact_chest = false;
		default_Flag_Can_player_interact_TNT = false;
		default_Flag_Can_player_interact_trashcan = true;
		default_Flag_Can_player_interact_paintbucket = true;
		default_Flag_Can_player_interact_canvas = false;
		default_Flag_Can_player_interact_elevator = true;
		default_Flag_Can_player_interact_door = true;
		default_Flag_Can_player_open_chest = false;
		default_Flag_Can_player_execute_command = true;
		default_Flag_Can_player_attack_player = false;
		default_Flag_Can_player_attack_NPC = true;
		default_Flag_Can_player_pickup_item = true;
		default_Flag_Can_player_drop_item = true;
		default_Flag_Can_player_die = true;
		default_Flag_Can_player_heal = true;
		default_Flag_Can_player_receive_damage = true;
		default_Flag_Can_player_teleport = true;
		default_Flag_Can_player_chat_public = true;
		default_Flag_Can_player_chat = true;
		default_Flag_Can_player_wield = true;
		default_Flag_Can_player_unwield = true;
		default_Flag_Can_player_setspawn = false;
		default_Flag_Can_player_text_sign = false;
		default_Flag_Can_NPC_move = true;
		default_Flag_Can_NPC_attack_player = false;
		default_Flag_Can_NPC_attack_NPC = true;
		default_Flag_Can_NPC_die = true;
		default_Flag_Can_NPC_heal = true;
		default_Flag_Can_NPC_receive_damage = true;
		default_Flag_Can_NPC_spawn = true;
		default_Flag_Can_NPC_interact = false;
		default_Flag_Can_grass_grow = true;
		default_Flag_Can_plant_grow = true;
		default_Flag_Can_tree_grow = false;
		default_Flag_Can_TNT_explode = false;
		default_Flag_Can_block_gravitate = true;
		default_Flag_Can_block_decay = true;
		blockguard_Limited_Volume_Maximum = 30;
		automatic_Region_Owner_Tag = false;
		blockguard_Limited_Region_Maximum = 3;
		blockguard_Limited_Length_Minimum = 3;
		automatic_Rectangular_Cuboids = false;
		automatic_Overlap_Check = false;
		overlap_Maximum_Percentage = 75;
		enable_Movement_Tracker = false;
	}

	public int getBlockGuardLimitedBlockVolumeLimit() {
		return blockguard_Limited_Volume_Maximum;
	}

	public int getBlockGuardLimitedLengthMinimum() {
		return blockguard_Limited_Length_Minimum;
	}

	public int getBlockGuardLimitedVolumeMaximum() {
		return blockguard_Limited_Volume_Maximum;
	}

	public boolean isAutoRegionOwnerTag() {
		return automatic_Region_Owner_Tag;
	}

	public int getBlockGuardLimitedRegionMaximum() {
		return blockguard_Limited_Region_Maximum;
	}

	public boolean isAutomaticRectangularCuboids() {
		return automatic_Rectangular_Cuboids;
	}

	public boolean isAutomaticOverlapCheck() {
		return automatic_Overlap_Check;
	}

	public int getOverlapMaximumPercentage() {
		return overlap_Maximum_Percentage;
	}

	public boolean isEnableMovementTracker() {
		return enable_Movement_Tracker;
	}

	public boolean isDefaultFlag_Can_player_break_block() {
		return default_Flag_Can_player_break_block;
	}

	public boolean isDefaultFlag_Can_player_place_block() {
		return default_Flag_Can_player_place_block;
	}

	public boolean isDefaultFlag_Can_player_interact_bed() {
		return default_Flag_Can_player_interact_bed;
	}

	public boolean isDefaultFlag_Can_player_interact_electronic() {
		return default_Flag_Can_player_interact_electronic;
	}

	public boolean isDefaultFlag_Can_player_interact_chest() {
		return default_Flag_Can_player_interact_chest;
	}

	public boolean isDefaultFlag_Can_player_interact_TNT() {
		return default_Flag_Can_player_interact_TNT;
	}

	public boolean isDefaultFlag_Can_player_interact_trashcan() {
		return default_Flag_Can_player_interact_trashcan;
	}

	public boolean isDefaultFlag_Can_player_interact_paintbucket() {
		return default_Flag_Can_player_interact_paintbucket;
	}

	public boolean isDefaultFlag_Can_player_interact_canvas() {
		return default_Flag_Can_player_interact_canvas;
	}

	public boolean isDefaultFlag_Can_player_interact_elevator() {
		return default_Flag_Can_player_interact_elevator;
	}

	public boolean isDefaultFlag_Can_player_open_chest() {
		return default_Flag_Can_player_open_chest;
	}

	public boolean isDefaultFlag_Can_player_execute_command() {
		return default_Flag_Can_player_execute_command;
	}

	public boolean isDefaultFlag_Can_player_attack_player() {
		return default_Flag_Can_player_attack_player;
	}

	public boolean isDefaultFlag_Can_player_attack_NPC() {
		return default_Flag_Can_player_attack_NPC;
	}

	public boolean isDefaultFlag_Can_player_pickup_item() {
		return default_Flag_Can_player_pickup_item;
	}

	public boolean isDefaultFlag_Can_player_drop_item() {
		return default_Flag_Can_player_drop_item;
	}

	public boolean isDefaultFlag_Can_player_die() {
		return default_Flag_Can_player_die;
	}

	public boolean isDefaultFlag_Can_player_heal() {
		return default_Flag_Can_player_heal;
	}

	public boolean isDefaultFlag_Can_player_receive_damage() {
		return default_Flag_Can_player_receive_damage;
	}

	public boolean isDefaultFlag_Can_player_teleport() {
		return default_Flag_Can_player_teleport;
	}

	public boolean isDefaultFlag_Can_player_chat_public() {
		return default_Flag_Can_player_chat_public;
	}

	public boolean isDefaultFlag_Can_player_chat() {
		return default_Flag_Can_player_chat;
	}

	public boolean isDefaultFlag_Can_player_wield() {
		return default_Flag_Can_player_wield;
	}

	public boolean isDefaultFlag_Can_player_unwield() {
		return default_Flag_Can_player_unwield;
	}

	public boolean isDefaultFlag_Can_player_setspawn() {
		return default_Flag_Can_player_setspawn;
	}

	public boolean isDefaultFlag_Can_player_text_sign() {
		return default_Flag_Can_player_text_sign;
	}

	public boolean isDefaultFlag_Can_NPC_move() {
		return default_Flag_Can_NPC_move;
	}

	public boolean isDefaultFlag_Can_NPC_attack_player() {
		return default_Flag_Can_NPC_attack_player;
	}

	public boolean isDefaultFlag_Can_NPC_attack_NPC() {
		return default_Flag_Can_NPC_attack_NPC;
	}

	public boolean isDefaultFlag_Can_NPC_die() {
		return default_Flag_Can_NPC_die;
	}

	public boolean isDefaultFlag_Can_NPC_heal() {
		return default_Flag_Can_NPC_heal;
	}

	public boolean isDefaultFlag_Can_NPC_receive_damage() {
		return default_Flag_Can_NPC_receive_damage;
	}

	public boolean isDefaultFlag_Can_NPC_spawn() {
		return default_Flag_Can_NPC_spawn;
	}

	public boolean isDefaultFlag_Can_NPC_interact() {
		return default_Flag_Can_NPC_interact;
	}

	public boolean isDefaultFlag_Can_grass_grow() {
		return default_Flag_Can_grass_grow;
	}

	public boolean isDefaultFlag_Can_plant_grow() {
		return default_Flag_Can_plant_grow;
	}

	public boolean isDefaultFlag_Can_tree_grow() {
		return default_Flag_Can_tree_grow;
	}

	public boolean isDefaultFlag_Can_TNT_explode() {
		return default_Flag_Can_TNT_explode;
	}

	public boolean isDefaultFlag_Can_block_gravitate() {
		return default_Flag_Can_block_gravitate;
	}

	public boolean isDefaultFlag_Can_block_decay() {
		return default_Flag_Can_block_decay;
	}

	public boolean isAutomaticRegionOwnerTag() {
		return automatic_Region_Owner_Tag;
	}
	public boolean isDefaultFlag_Can_player_interact_door() {
		return default_Flag_Can_player_interact_door;
	}

	public boolean[] getDefaultBooleans() {
		boolean[] flagBooleans = new boolean[] {
				this.default_Flag_Can_player_break_block,
				this.default_Flag_Can_player_place_block,
				this.default_Flag_Can_player_interact_bed,
				this.default_Flag_Can_player_interact_electronic,
				this.default_Flag_Can_player_interact_chest,
				this.default_Flag_Can_player_interact_TNT,
				this.default_Flag_Can_player_interact_trashcan,
				this.default_Flag_Can_player_interact_paintbucket,
				this.default_Flag_Can_player_interact_canvas,
				this.default_Flag_Can_player_interact_elevator,
				this.default_Flag_Can_player_open_chest,
				this.default_Flag_Can_player_execute_command,
				this.default_Flag_Can_player_attack_player,
				this.default_Flag_Can_player_attack_NPC,
				this.default_Flag_Can_player_pickup_item,
				this.default_Flag_Can_player_drop_item,
				this.default_Flag_Can_player_die,
				this.default_Flag_Can_player_heal,
				this.default_Flag_Can_player_receive_damage,
				this.default_Flag_Can_player_teleport,
				this.default_Flag_Can_player_chat_public,
				this.default_Flag_Can_player_chat,
				this.default_Flag_Can_player_wield,
				this.default_Flag_Can_player_unwield,
				this.default_Flag_Can_player_setspawn,
				this.default_Flag_Can_player_text_sign,
				this.default_Flag_Can_NPC_move,
				this.default_Flag_Can_NPC_attack_player,
				this.default_Flag_Can_NPC_attack_NPC,
				this.default_Flag_Can_NPC_die, this.default_Flag_Can_NPC_heal,
				this.default_Flag_Can_NPC_receive_damage,
				this.default_Flag_Can_NPC_spawn,
				this.default_Flag_Can_NPC_interact,
				this.default_Flag_Can_grass_grow,
				this.default_Flag_Can_plant_grow,
				this.default_Flag_Can_tree_grow,
				this.default_Flag_Can_TNT_explode,
				this.default_Flag_Can_block_gravitate,
				this.default_Flag_Can_block_decay,
				this.default_Flag_Can_player_interact_door};

		return flagBooleans;
	}

}
