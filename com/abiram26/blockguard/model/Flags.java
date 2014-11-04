package com.abiram26.blockguard.model;

public class Flags {
	private boolean can_player_break_block; //
	private boolean can_player_place_block; //
	private boolean can_player_interact_bed; //
	private boolean can_player_interact_electronic; //
	private boolean can_player_interact_chest; //
	private boolean can_player_interact_TNT; //
	private boolean can_player_interact_trashcan; //
	private boolean can_player_interact_paintbucket; //
	private boolean can_player_interact_canvas; // /
	private boolean can_player_interact_elevator; // /
	private boolean can_player_interact_door;
	private boolean can_player_open_chest; //
	private boolean can_player_execute_command; //
	private boolean can_player_attack_player; //
	private boolean can_player_attack_NPC; // /
	private boolean can_player_pickup_item; //
	private boolean can_player_drop_item; // /
	private boolean can_player_die; //
	private boolean can_player_heal; //
	private boolean can_player_receive_damage; //
	private boolean can_player_teleport; //
	private boolean can_player_chat_public; //
	private boolean can_player_chat; //
	private boolean can_player_wield; // /
	private boolean can_player_unwield; // /
	private boolean can_player_setspawn; //
	private boolean can_player_text_sign; //
	private boolean can_NPC_move; // /
	private boolean can_NPC_attack_player; // /
	private boolean can_NPC_attack_NPC; // /
	private boolean can_NPC_die; //
	private boolean can_NPC_heal; //
	private boolean can_NPC_receive_damage; //
	private boolean can_NPC_spawn; // /
	private boolean can_NPC_interact; // /
	private boolean can_grass_grow; // /
	private boolean can_plant_grow; // /
	private boolean can_tree_grow; // /
	private boolean can_TNT_explode; //
	private boolean can_block_gravitate; // /
	private boolean can_block_decay; // /

	public Flags(final boolean[] flagBooleans) {
		this.can_player_break_block = flagBooleans[0];
		this.can_player_place_block = flagBooleans[1];
		this.can_player_interact_bed = flagBooleans[2];
		this.can_player_interact_electronic = flagBooleans[3];
		this.can_player_interact_chest = flagBooleans[4];
		this.can_player_interact_TNT = flagBooleans[5];
		this.can_player_interact_trashcan = flagBooleans[6];
		this.can_player_interact_paintbucket = flagBooleans[7];
		this.can_player_interact_canvas = flagBooleans[8];
		this.can_player_interact_elevator = flagBooleans[9];
		this.can_player_open_chest = flagBooleans[10];
		this.can_player_execute_command = flagBooleans[11];
		this.can_player_attack_player = flagBooleans[12];
		this.can_player_attack_NPC = flagBooleans[13];
		this.can_player_pickup_item = flagBooleans[14];
		this.can_player_drop_item = flagBooleans[15];
		this.can_player_die = flagBooleans[16];
		this.can_player_heal = flagBooleans[17];
		this.can_player_receive_damage = flagBooleans[18];
		this.can_player_teleport = flagBooleans[19];
		this.can_player_chat_public = flagBooleans[20];
		this.can_player_chat = flagBooleans[21];
		this.can_player_wield = flagBooleans[22];
		this.can_player_unwield = flagBooleans[23];
		this.can_player_setspawn = flagBooleans[24];
		this.can_player_text_sign = flagBooleans[25];
		this.can_NPC_move = flagBooleans[26];
		this.can_NPC_attack_player = flagBooleans[27];
		this.can_NPC_attack_NPC = flagBooleans[28];
		this.can_NPC_die = flagBooleans[29];
		this.can_NPC_heal = flagBooleans[30];
		this.can_NPC_receive_damage = flagBooleans[31];
		this.can_NPC_spawn = flagBooleans[32];
		this.can_NPC_interact = flagBooleans[33];
		this.can_grass_grow = flagBooleans[34];
		this.can_plant_grow = flagBooleans[35];
		this.can_tree_grow = flagBooleans[36];
		this.can_TNT_explode = flagBooleans[37];
		this.can_block_gravitate = flagBooleans[38];
		this.can_block_decay = flagBooleans[39];
		this.can_player_interact_door=flagBooleans[40];
	}

	/**
	 * 
	 * @param flag
	 *            Enter a string of a flag (not casesensitive and '-' will be
	 *            replaced with '_')
	 * @return True, if it is a valid flag. False, if not.
	 */
	public boolean isValidFlag(String flag) {
		final String flagString = flag.toLowerCase().replace("-", "_");
		if (flagString.equals("can_player_break_block")) {
			return true;
		} else if (flagString.equals("can_player_place_block")) {
			return true;
		} else if (flagString.equals("can_player_interact_bed")) {
			return true;
		} else if (flagString.equals("can_player_interact_electronic")) {
			return true;
		} else if (flagString.equals("can_player_interact_chest")) {
			return true;
		} else if (flagString.equals("can_player_interact_tnt")) {
			return true;
		} else if (flagString.equals("can_player_interact_trashcan")) {
			return true;
		} else if (flagString.equals("can_player_interact_paintbucket")) {
			return true;
		} else if (flagString.equals("can_player_interact_canvas")) {
			return true;
		} else if (flagString.equals("can_player_interact_elevator")) {
			return true;
		} else if (flagString.equals("can_player_open_chest")) {
			return true;
		} else if (flagString.equals("can_player_execute_command")) {
			return true;
		} else if (flagString.equals("can_player_attack_player")) {
			return true;
		} else if (flagString.equals("can_player_attack_npc")) {
			return true;
		} else if (flagString.equals("can_player_pickup_item")) {
			return true;
		} else if (flagString.equals("can_player_drop_item")) {
			return true;
		} else if (flagString.equals("can_player_die")) {
			return true;
		} else if (flagString.equals("can_player_heal")) {
			return true;
		} else if (flagString.equals("can_player_receive_damage")) {
			return true;
		} else if (flagString.equals("can_player_teleport")) {
			return true;
		} else if (flagString.equals("can_player_chat_public")) {
			return true;
		} else if (flagString.equals("can_player_chat")) {
			return true;
		} else if (flagString.equals("can_player_wield")) {
			return true;
		} else if (flagString.equals("can_player_unwield")) {
			return true;
		} else if (flagString.equals("can_player_setspawn")) {
			return true;
		} else if (flagString.equals("can_player_text_sign")) {
			return true;
		} else if (flagString.equals("can_npc_move")) {
			return true;
		} else if (flagString.equals("can_npc_attack_player")) {
			return true;
		} else if (flagString.equals("can_npc_attack_npc")) {
			return true;
		} else if (flagString.equals("can_npc_die")) {
			return true;
		} else if (flagString.equals("can_npc_heal")) {
			return true;
		} else if (flagString.equals("can_npc_receive_damage")) {
			return true;
		} else if (flagString.equals("can_npc_spawn")) {
			return true;
		} else if (flagString.equals("can_npc_interact")) {
			return true;
		} else if (flagString.equals("can_grass_grow")) {
			return true;
		} else if (flagString.equals("can_plant_grow")) {
			return true;
		} else if (flagString.equals("can_tree_grow")) {
			return true;
		} else if (flagString.equals("can_tnt_explode")) {
			return true;
		} else if (flagString.equals("can_block_gravitate")) {
			return true;
		} else if (flagString.equals("can_block_decay")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean getFlag(String flag) {
		final String flagString = flag.toLowerCase().replace("-", "_");
		if (flagString.equals("can_player_break_block")) {
			return this.can_player_break_block;
		} else if (flagString.equals("can_player_place_block")) {
			return this.can_player_place_block;
		} else if (flagString.equals("can_player_interact_bed")) {
			return this.can_player_interact_bed;
		} else if (flagString.equals("can_player_interact_electronic")) {
			return this.can_player_interact_electronic;
		} else if (flagString.equals("can_player_interact_chest")) {
			return this.can_player_interact_chest;
		} else if (flagString.equals("can_player_interact_tnt")) {
			return this.can_player_interact_TNT;
		} else if (flagString.equals("can_player_interact_trashcan")) {
			return this.can_player_interact_trashcan;
		} else if (flagString.equals("can_player_interact_paintbucket")) {
			return this.can_player_interact_paintbucket;
		} else if (flagString.equals("can_player_interact_canvas")) {
			return this.can_player_interact_canvas;
		} else if (flagString.equals("can_player_interact_elevator")) {
			return this.can_player_interact_elevator;
		} else if (flagString.equals("can_player_open_chest")) {
			return this.can_player_open_chest;
		} else if (flagString.equals("can_player_execute_command")) {
			return this.can_player_execute_command;
		} else if (flagString.equals("can_player_attack_player")) {
			return this.can_player_attack_player;
		} else if (flagString.equals("can_player_attack_npc")) {
			return this.can_player_attack_NPC;
		} else if (flagString.equals("can_player_pickup_item")) {
			return this.can_player_pickup_item;
		} else if (flagString.equals("can_player_drop_item")) {
			return this.can_player_drop_item;
		} else if (flagString.equals("can_player_die")) {
			return this.can_player_die;
		} else if (flagString.equals("can_player_heal")) {
			return this.can_player_heal;
		} else if (flagString.equals("can_player_receive_damage")) {
			return this.can_player_receive_damage;
		} else if (flagString.equals("can_player_teleport")) {
			return this.can_player_teleport;
		} else if (flagString.equals("can_player_chat_public")) {
			return this.can_player_chat_public;
		} else if (flagString.equals("can_player_chat")) {
			return this.can_player_chat;
		} else if (flagString.equals("can_player_wield")) {
			return this.can_player_wield;
		} else if (flagString.equals("can_player_unwield")) {
			return this.can_player_unwield;
		} else if (flagString.equals("can_player_setspawn")) {
			return this.can_player_setspawn;
		} else if (flagString.equals("can_player_text_sign")) {
			return this.can_player_text_sign;
		} else if (flagString.equals("can_npc_move")) {
			return this.can_NPC_move;
		} else if (flagString.equals("can_npc_attack_player")) {
			return this.can_NPC_attack_player;
		} else if (flagString.equals("can_npc_attack_npc")) {
			return this.can_NPC_attack_NPC;
		} else if (flagString.equals("can_npc_die")) {
			return this.can_NPC_die;
		} else if (flagString.equals("can_npc_heal")) {
			return this.can_NPC_heal;
		} else if (flagString.equals("can_npc_receive_damage")) {
			return this.can_NPC_receive_damage;
		} else if (flagString.equals("can_npc_spawn")) {
			return this.can_NPC_spawn;
		} else if (flagString.equals("can_npc_interact")) {
			return this.can_NPC_interact;
		} else if (flagString.equals("can_grass_grow")) {
			return this.can_grass_grow;
		} else if (flagString.equals("can_plant_grow")) {
			return this.can_plant_grow;
		} else if (flagString.equals("can_tree_grow")) {
			return this.can_tree_grow;
		} else if (flagString.equals("can_tnt_explode")) {
			return this.can_TNT_explode;
		} else if (flagString.equals("can_block_gravitate")) {
			return this.can_block_gravitate;
		} else if (flagString.equals("can_block_decay")) {
			return this.can_block_decay;}
		else if (flagString.equals("can_player_place_block")) {
				return this.can_player_interact_door;
		} else {
			return false; // ?
		}
	}

	public void setFlag(String flag, boolean newSetting) {
		final String flagString = flag.toLowerCase().replace("-", "_");
		if (flagString.equals("can_player_break_block")) {
			this.can_player_break_block = newSetting;
		} else if (flagString.equals("can_player_place_block")) {
			this.can_player_place_block = newSetting;
		} else if (flagString.equals("can_player_interact_bed")) {
			this.can_player_interact_bed = newSetting;
		} else if (flagString.equals("can_player_interact_electronic")) {
			this.can_player_interact_electronic = newSetting;
		} else if (flagString.equals("can_player_interact_chest")) {
			this.can_player_interact_chest = newSetting;
		} else if (flagString.equals("can_player_interact_tnt")) {
			this.can_player_interact_TNT = newSetting;
		} else if (flagString.equals("can_player_interact_trashcan")) {
			this.can_player_interact_trashcan = newSetting;
		} else if (flagString.equals("can_player_interact_paintbucket")) {
			this.can_player_interact_paintbucket = newSetting;
		} else if (flagString.equals("can_player_interact_canvas")) {
			this.can_player_interact_canvas = newSetting;
		} else if (flagString.equals("can_player_interact_elevator")) {
			this.can_player_interact_elevator = newSetting;
		} else if (flagString.equals("can_player_open_chest")) {
			this.can_player_open_chest = newSetting;
		} else if (flagString.equals("can_player_execute_command")) {
			this.can_player_execute_command = newSetting;
		} else if (flagString.equals("can_player_attack_player")) {
			this.can_player_attack_player = newSetting;
		} else if (flagString.equals("can_player_attack_npc")) {
			this.can_player_attack_NPC = newSetting;
		} else if (flagString.equals("can_player_pickup_item")) {
			this.can_player_pickup_item = newSetting;
		} else if (flagString.equals("can_player_drop_item")) {
			this.can_player_drop_item = newSetting;
		} else if (flagString.equals("can_player_die")) {
			this.can_player_die = newSetting;
		} else if (flagString.equals("can_player_heal")) {
			this.can_player_heal = newSetting;
		} else if (flagString.equals("can_player_receive_damage")) {
			this.can_player_receive_damage = newSetting;
		} else if (flagString.equals("can_player_teleport")) {
			this.can_player_teleport = newSetting;
		} else if (flagString.equals("can_player_chat_public")) {
			this.can_player_chat_public = newSetting;
		} else if (flagString.equals("can_player_chat")) {
			this.can_player_chat = newSetting;
		} else if (flagString.equals("can_player_wield")) {
			this.can_player_wield = newSetting;
		} else if (flagString.equals("can_player_unwield")) {
			this.can_player_unwield = newSetting;
		} else if (flagString.equals("can_player_setspawn")) {
			this.can_player_setspawn = newSetting;
		} else if (flagString.equals("can_player_text_sign")) {
			this.can_player_text_sign = newSetting;
		} else if (flagString.equals("can_npc_move")) {
			this.can_NPC_move = newSetting;
		} else if (flagString.equals("can_npc_attack_player")) {
			this.can_NPC_attack_player = newSetting;
		} else if (flagString.equals("can_npc_attack_npc")) {
			this.can_NPC_attack_NPC = newSetting;
		} else if (flagString.equals("can_npc_die")) {
			this.can_NPC_die = newSetting;
		} else if (flagString.equals("can_npc_heal")) {
			this.can_NPC_heal = newSetting;
		} else if (flagString.equals("can_npc_receive_damage")) {
			this.can_NPC_receive_damage = newSetting;
		} else if (flagString.equals("can_npc_spawn")) {
			this.can_NPC_spawn = newSetting;
		} else if (flagString.equals("can_npc_interact")) {
			this.can_NPC_interact = newSetting;
		} else if (flagString.equals("can_grass_grow")) {
			this.can_grass_grow = newSetting;
		} else if (flagString.equals("can_plant_grow")) {
			this.can_plant_grow = newSetting;
		} else if (flagString.equals("can_tree_grow")) {
			this.can_tree_grow = newSetting;
		} else if (flagString.equals("can_tnt_explode")) {
			this.can_TNT_explode = newSetting;
		} else if (flagString.equals("can_block_gravitate")) {
			this.can_block_gravitate = newSetting;
		} else if (flagString.equals("can_block_decay")) {
			this.can_block_decay = newSetting;
		} else if (flagString.equals("can_player_interact_door")) {
			this.can_block_decay = newSetting;
		} else {
			// ?
		}
	}

	public boolean isCan_player_break_block() {
		return can_player_break_block;
	}

	public boolean isCan_player_place_block() {
		return can_player_place_block;
	}

	public boolean isCan_player_interact_bed() {
		return can_player_interact_bed;
	}

	public boolean isCan_player_interact_electronic() {
		return can_player_interact_electronic;
	}

	public boolean isCan_player_interact_chest() {
		return can_player_interact_chest;
	}

	public boolean isCan_player_interact_TNT() {
		return can_player_interact_TNT;
	}

	public boolean isCan_player_interact_trashcan() {
		return can_player_interact_trashcan;
	}

	public boolean isCan_player_interact_paintbucket() {
		return can_player_interact_paintbucket;
	}

	public boolean isCan_player_interact_canvas() {
		return can_player_interact_canvas;
	}

	public boolean isCan_player_interact_elevator() {
		return can_player_interact_elevator;
	}

	public boolean isCan_player_open_chest() {
		return can_player_open_chest;
	}

	public boolean isCan_player_execute_command() {
		return can_player_execute_command;
	}

	public boolean isCan_player_attack_player() {
		return can_player_attack_player;
	}

	public boolean isCan_player_attack_NPC() {
		return can_player_attack_NPC;
	}

	public boolean isCan_player_pickup_item() {
		return can_player_pickup_item;
	}

	public boolean isCan_player_drop_item() {
		return can_player_drop_item;
	}

	public boolean isCan_player_die() {
		return can_player_die;
	}

	public boolean isCan_player_heal() {
		return can_player_heal;
	}

	public boolean isCan_player_receive_damage() {
		return can_player_receive_damage;
	}

	public boolean isCan_player_teleport() {
		return can_player_teleport;
	}

	public boolean isCan_player_chat_public() {
		return can_player_chat_public;
	}

	public boolean isCan_player_chat() {
		return can_player_chat;
	}

	public boolean isCan_player_wield() {
		return can_player_wield;
	}

	public boolean isCan_player_unwield() {
		return can_player_unwield;
	}

	public boolean isCan_player_setspawn() {
		return can_player_setspawn;
	}

	public boolean isCan_player_text_sign() {
		return can_player_text_sign;
	}

	public boolean isCan_NPC_move() {
		return can_NPC_move;
	}

	public boolean isCan_NPC_attack_player() {
		return can_NPC_attack_player;
	}

	public boolean isCan_NPC_attack_NPC() {
		return can_NPC_attack_NPC;
	}

	public boolean isCan_NPC_die() {
		return can_NPC_die;
	}

	public boolean isCan_NPC_heal() {
		return can_NPC_heal;
	}

	public boolean isCan_NPC_receive_damage() {
		return can_NPC_receive_damage;
	}

	public boolean isCan_NPC_spawn() {
		return can_NPC_spawn;
	}

	public boolean isCan_NPC_interact() {
		return can_NPC_interact;
	}

	public boolean isCan_grass_grow() {
		return can_grass_grow;
	}

	public boolean isCan_plant_grow() {
		return can_plant_grow;
	}

	public boolean isCan_tree_grow() {
		return can_tree_grow;
	}

	public boolean isCan_TNT_explode() {
		return can_TNT_explode;
	}

	public boolean isCan_block_gravitate() {
		return can_block_gravitate;
	}

	public boolean isCan_block_decay() {
		return can_block_decay;
	}
	
	public boolean isCan_player_interact_door() {
		return can_player_interact_door;
	}

}
