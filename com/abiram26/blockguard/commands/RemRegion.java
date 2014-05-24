package com.abiram26.blockguard.commands;

import com.abiram26.blockguard.Config;
import com.abiram26.blockguard.Plugin;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;

public class RemRegion implements CommandExecutor {
	private final Plugin plugin;
	private final Config getConfig;

	public RemRegion(Plugin plugin) {
		// TODO Auto-generated constructor stub
		this.plugin = plugin;
		this.getConfig = this.plugin.getConfig();
	}

	@Override
	public void execute(String command, CommandSender sender, String[] args,
			String label) {
		// TODO Auto-generated method stub
		final int regionId;
		if (sender.hasPermission("abiram26.blockguard.*")) {

			if (args.length == 1) {
				regionId = this.getConfig.hasRegion(args[0].toLowerCase());
				if (regionId != -1) {
					final String regionName = this.getConfig.getRegions()
							.get(regionId).getRegionName();
					this.getConfig.getRegions().remove(regionId);
					this.getConfig.getMembers().remove(regionId);
					this.plugin.saveConfig();
					sender.sendMessage(Plugin.stamp + "Removed region "
							+ regionName);
				} else {
					sender.sendMessage(Plugin.stamp
							+ "Not unguarded: No region with that name!");
				}
			} else {
				sender.sendMessage(Plugin.stamp
						+ "Not unguarded: Not enough arguments given, usage: /bgremoveregion <regionname>");
			}
		} else {
			sender.sendMessage(Plugin.stamp
					+ "Not unguarded: No permission to use this command!");
		}

	}

}
