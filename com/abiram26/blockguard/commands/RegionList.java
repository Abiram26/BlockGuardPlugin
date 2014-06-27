package com.abiram26.blockguard.commands;

import com.abiram26.blockguard.Plugin;
import com.abiram26.blockguard.storage.Config;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;

public class RegionList implements CommandExecutor {
	private final Plugin p1;

	public RegionList(final Plugin plugin) {
		// TODO Auto-generated constructor stub
		this.p1 = plugin;
	}

	@Override
	public void execute(final String command, final CommandSender sender, final String[] args,
			final String label) {
		// TODO Auto-generated method stub
		final Config cfg = p1.getConfig();
		final int amountOfRegions = cfg.getRegions().size();
		sender.sendMessage(Plugin.stamp+"All regions with their owner:");
		for (int x = 0; amountOfRegions > x; x++) {
			sender.sendMessage("Region: " + cfg.getRegions().get(x).getRegionName() + " with owner: " + cfg.getMembers().get(x).getMemberList().get(0));
		}
	}

}
