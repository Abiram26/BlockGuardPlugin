package com.abiram26.blockguard.commands;

import com.abiram26.blockguard.Plugin;
import com.abiram26.blockguard.storage.Config;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;

public class AddMember implements CommandExecutor {

	private final Plugin plugin;;

	public AddMember(final Plugin plugin) {
		this.plugin = plugin;;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(final String command, final CommandSender sender, final String[] args,
			final String label) {
		// TODO Auto-generated method stub
		final int regionId;
		if (sender.hasPermission("abiram26.blockguard.*")) {
			if (args.length == 2) {
				final Config cfg= this.plugin.getConfig();
				regionId = cfg.hasRegion(args[0]);
				if (regionId != -1) {
					if (cfg.getMembers().get(regionId)
							.hasMember(args[1])==-1) {
						cfg.getMembers().get(regionId)
								.addMember(args[1]);
						this.plugin.saveConfig();
						sender.sendMessage(Plugin.stamp + "Added member "
								+ args[1]
								+ " to "
								+ cfg.getRegions().get(regionId)
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
