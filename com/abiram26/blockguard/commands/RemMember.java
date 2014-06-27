package com.abiram26.blockguard.commands;

import com.abiram26.blockguard.Plugin;
import com.abiram26.blockguard.storage.Config;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;

public class RemMember implements CommandExecutor {
	private final Plugin plugin;

	public RemMember(final Plugin plugin) {
		// TODO Auto-generated constructor stub
		this.plugin = plugin;;
	}

	@Override
	public void execute(final String command, final CommandSender sender,
			final String[] args, final String label) {
		// TODO Auto-generated method stub
		final int regionId;
		final int memberId;
		if (sender.hasPermission("abiram26.blockguard.*")) {
			if (args.length == 2) {
				final Config cfg = this.plugin.getConfig();
				regionId = cfg.hasRegion(args[0]);
				if (regionId != -1) {
					memberId = cfg.getMembers().get(regionId)
							.hasMember(args[1]);
					if (memberId != -1) {
						cfg.getMembers().get(regionId).getMemberList()
								.remove(memberId);
						this.plugin.saveConfig();
						sender.sendMessage(Plugin.stamp
								+ "Removed member "
								+ args[1]
								+ " from "
								+ cfg.getRegions().get(regionId)
										.getRegionName() + "!");
					} else {
						sender.sendMessage(Plugin.stamp
								+ "Not removed: The region does not have that name as a member!");
					}
				} else {
					sender.sendMessage(Plugin.stamp
							+ "Not removed: No region with that name!");
				}
			} else {
				sender.sendMessage(Plugin.stamp
						+ "Not removed: Not enough arguments given, usage: /bgremovemember <regionname> <playername>");
			}
		} else {
			sender.sendMessage(Plugin.stamp
					+ "Not removed: No permission to use this command!");
		}

	}

}
