package com.abiram26.blockguard.commands;

import com.abiram26.blockguard.Plugin;
import com.abiram26.blockguard.storage.Config;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;

public class RemRegion implements CommandExecutor {
	private final Plugin plugin;

	public RemRegion(final Plugin plugin) {
		// TODO Auto-generated constructor stub
		this.plugin = plugin;
	}

	@Override
	public void execute(final String command,final CommandSender sender,final String[] args,
			final String label) {
		// TODO Auto-generated method stub
		final int regionId;
		if (sender.hasPermission("abiram26.blockguard.*")) {

			if (args.length == 1) {
				final Config cfg = this.plugin.getConfig();
				regionId = cfg.hasRegion(args[0]);
				if (regionId != -1) {
					final String regionName = cfg.getRegions()
							.get(regionId).getRegionName();
					cfg.getRegions().remove(regionId);
					cfg.getMembers().remove(regionId);
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
