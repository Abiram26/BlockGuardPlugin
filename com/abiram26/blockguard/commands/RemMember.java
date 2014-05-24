package com.abiram26.blockguard.commands;

import com.abiram26.blockguard.Config;
import com.abiram26.blockguard.Plugin;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;

public class RemMember implements CommandExecutor {
		private final Plugin plugin;
		private final Config getConfig;
	public RemMember(Plugin plugin) {
		// TODO Auto-generated constructor stub
		this.plugin=plugin;
		this.getConfig=this.plugin.getConfig();
	}

	@Override
	public void execute(String command, CommandSender sender, String[] args,
			String label) {
		// TODO Auto-generated method stub
		final int regionId;
		final int memberId;
		if (sender.hasPermission("abiram26.blockguard.*")) {

			if (args.length == 2) {
				regionId = this.getConfig.hasRegion(args[0].toLowerCase());
				if (regionId != -1) {
					memberId=this.getConfig.getMembers().get(regionId)
							.hasMember(args[1].toLowerCase());
					if (memberId!=-1) {
						this.getConfig.getMembers().get(regionId).getMemberList().remove(memberId);
						this.plugin.saveConfig();
						sender.sendMessage(Plugin.stamp + "Removed member " + args[1].toLowerCase() + " from " + this.getConfig.getRegions().get(regionId).getRegionName()+"!");
					} else {
						sender.sendMessage(Plugin.stamp + "Not removed: The region does not have that name as a member!");
					}
				} else {
					sender.sendMessage(Plugin.stamp + "Not removed: No region with that name!");
				}
			} else {
				sender.sendMessage(Plugin.stamp + "Not removed: Not enough arguments given, usage: /bgremovemember <regionname> <playername>");
			}
		} else {
			sender.sendMessage(Plugin.stamp + "Not removed: No permission to use this command!");
		}
		
	}

}
