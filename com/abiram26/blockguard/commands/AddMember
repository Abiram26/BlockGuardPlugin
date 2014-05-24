package com.abiram26.blockguard.commands;

import com.abiram26.blockguard.Config;
import com.abiram26.blockguard.Plugin;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;

public class AddMember implements CommandExecutor {

	private final Plugin plugin;
	private final Config getConfig;

	public AddMember(Plugin plugin) {
		this.plugin = plugin;
		this.getConfig = this.plugin.getConfig();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(String command, CommandSender sender, String[] args,
			String label) {
		// TODO Auto-generated method stub
		final int regionId;
		if (sender.hasPermission("abiram26.blockguard.*")) {

			if (args.length == 2) {
				regionId = this.getConfig.hasRegion(args[0].toLowerCase());
				if (regionId != -1) {
					if (this.getConfig.getMembers().get(regionId)
							.hasMember(args[1].toLowerCase())==-1) {
						this.getConfig.getMembers().get(regionId)
								.addMember(args[1].toLowerCase());
						this.plugin.saveConfig();
						sender.sendMessage(Plugin.stamp + "Added member "
								+ args[1].toLowerCase()
								+ " to "
								+ this.getConfig.getRegions().get(regionId)
										.getRegionName() + "!");
					} else {
						sender.sendMessage(Plugin.stamp + "Not added: The region already has that name as a member!");
					}
				} else {
					sender.sendMessage(Plugin.stamp + "Not added: No region with that name!");
				}
			} else {
				sender.sendMessage(Plugin.stamp + "Not added: Not enough arguments given, usage: /bgaddmember <regionname> <playername>");
			}
		} else {
			sender.sendMessage(Plugin.stamp + "Not added: No permission to use this command!");
		}

	}
}
