package com.abiram26.blockguard.commands;

import com.abiram26.blockguard.BlockGuardPlugin;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;

public class RegionList implements CommandExecutor {
	private final BlockGuardPlugin p1;

	public RegionList(final BlockGuardPlugin plugin) {
		// TODO Auto-generated constructor stub
		this.p1 = plugin;
	}

	@Override
	public void execute(final String command, final CommandSender sender,
			final String[] args, final String label) {
		p1.getServer().executeCommand(sender, "bgra", new String[]{"regions"});
	}

}
