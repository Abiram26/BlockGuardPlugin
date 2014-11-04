package com.abiram26.blockguard.commands;

import com.abiram26.blockguard.BlockGuardPlugin;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;

public class Information implements CommandExecutor {

	@Override
	public void execute(final String command, final CommandSender sender,
			final String[] args, final String label) {

		if (sender.hasPermission("abiram26.blockguard.*")
				|| sender.hasPermission("abiram26.blockguard.information")) {

			if (args.length == 0) {
				this.sendCommands(sender);
				this.sendPermissions(sender);
				this.sendFlags(sender);
			}else{
				if(args[0].equalsIgnoreCase("commands")){
					this.sendCommands(sender);
				}else if(args[0].equalsIgnoreCase("permissions")){
					this.sendPermissions(sender);
				}else if(args[0].equalsIgnoreCase("flags")){
					this.sendFlags(sender);
				}else{
					sender.sendMessage(BlockGuardPlugin.stamp
							+ "The first argument is not valid!");
				}
			}
		} else {
			sender.sendMessage(BlockGuardPlugin.stamp
					+ "You do not have permission to execute this command!");
		}
	}
	
	public void sendCommands(final CommandSender sender){
		// Prints all commands
		sender.sendMessage(BlockGuardPlugin.stamp + "All commands:");
		// Main command
		sender.sendMessage("/bg <optional: commands/permissions/flags> [Shows all commands, permissions and flags]");
		// Position commands
		sender.sendMessage("/bgpos1 [Marks position 1, so a region can be set]");
		sender.sendMessage("/bgpos2 [Marks position 2, so a region can be set]");
		// Region commands
		sender.sendMessage("/bgset <regionname> [Creates a region with you as the owner]");
		sender.sendMessage("/bgremoveregion <regionname> [Removes a region (and it's members)]");
		sender.sendMessage("/bgregionlist [Gives you all regionnames and their owner]");
		sender.sendMessage("/bgtp <regionname> <optional: playername> [Teleports you/player to a region]");
		sender.sendMessage("/bgcoords [Gives you your coordinates and a list in which regions you are]");
		// New region commands
		sender.sendMessage("/bgra set <regionname> [Creates a region with your as the owner]");
		sender.sendMessage("/bgra set <regionname> <player1> <player2> etc. [Creates a region with player1 as the owner]");
		sender.sendMessage("/bgra get <regionname> [Gives you all regiondetails]");
		sender.sendMessage("/bgra regions [Gives you all regionnames]");
		sender.sendMessage("/bgra <rem/remove> <regionname> [Removes a region]");
		sender.sendMessage("/bgra <tp/teleport> <regionname> [Teleports to a region]");
		sender.sendMessage("/bgra members <regionname> [Gives you the members of a region]");
		sender.sendMessage("/bgra addmember <regionname> [Adds a member to a region]");
		sender.sendMessage("/bgra <removemember/remmember> <regionname> [Removes a member from a region]");
		sender.sendMessage("/bgra flags <regionname> [Gives you all flags of a region]");
		sender.sendMessage("/bgra setflag <regionname> <canbuild/caninteract/canpvp> <true/false> [Set a new boolean for a flag of a region]");
		sender.sendMessage("/bgra getflag <regionname> <canbuild/caninteract/canpvp> [Gives you the boolean for a flag of a region]");
		// Member commands
		sender.sendMessage("/bgma add <regionname> <member> [Adds a member to the region]");
		sender.sendMessage("/bgma remove <regionname> <member> [Removes a member from the region]");
		sender.sendMessage("/bgma members <regionname> [Shows a list of all members]");
		// Flag commands
		sender.sendMessage("/bgfa set <regionname> <flag> <boolean> [Sets a new flag for a region]");
		sender.sendMessage("/bgfa get <regionname> <flag> [Gets a flag from a region]");
		sender.sendMessage("/bgfa flags <regionname> [Shows a list of all flags]");
		// Selection commands
		sender.sendMessage("/bgwand [Gives you the MBWorldEdit Wand-blocks]");
		sender.sendMessage("/bgsi [Gives information about your current selection]");
	}
	
	public void sendPermissions(final CommandSender sender){
		// Prints all permissions
		sender.sendMessage(BlockGuardPlugin.stamp + "All permissions:");
		sender.sendMessage("[WIP]");
		
	}
	
	public void sendFlags(final CommandSender sender){
		// Prints all commands
		sender.sendMessage(BlockGuardPlugin.stamp + "All flags:");
		sender.sendMessage("can_player_break_block");   
		sender.sendMessage("can_player_place_block");   
		sender.sendMessage("can_player_interact_bed");   
		sender.sendMessage("can_player_interact_electronic");   
		sender.sendMessage("can_player_interact_chest");   
		sender.sendMessage("can_player_interact_TNT");   
		sender.sendMessage("can_player_interact_trashcan");   
		sender.sendMessage("can_player_interact_paintbucket");   
		sender.sendMessage("can_player_interact_canvas");     
		sender.sendMessage("can_player_interact_elevator");     
		sender.sendMessage("can_player_interact_door");
		sender.sendMessage("can_player_open_chest");   
		sender.sendMessage("can_player_execute_command");   
		sender.sendMessage("can_player_attack_player");   
		sender.sendMessage("can_player_attack_NPC");     
		sender.sendMessage("can_player_pickup_item");   
		sender.sendMessage("can_player_drop_item");     
		sender.sendMessage("can_player_die");   
		sender.sendMessage("can_player_heal");   
		sender.sendMessage("can_player_receive_damage");   
		sender.sendMessage("can_player_teleport");   
		sender.sendMessage("can_player_chat_public");   
		sender.sendMessage("can_player_chat");   
		sender.sendMessage("can_player_wield");     
		sender.sendMessage("can_player_unwield");     
		sender.sendMessage("can_player_setspawn");   
		sender.sendMessage("can_player_text_sign");   
		sender.sendMessage("can_NPC_move");     
		sender.sendMessage("can_NPC_attack_player");     
		sender.sendMessage("can_NPC_attack_NPC");     
		sender.sendMessage("can_NPC_die");   
		sender.sendMessage("can_NPC_heal");   
		sender.sendMessage("can_NPC_receive_damage");   
		sender.sendMessage("can_NPC_spawn");     
		sender.sendMessage("can_NPC_interact");     
		sender.sendMessage("can_grass_grow");     
		sender.sendMessage("can_plant_grow");     
		sender.sendMessage("can_tree_grow");     
		sender.sendMessage("can_TNT_explode");   
		sender.sendMessage("can_block_gravitate");     
		sender.sendMessage("can_block_decay");     
	}

}
