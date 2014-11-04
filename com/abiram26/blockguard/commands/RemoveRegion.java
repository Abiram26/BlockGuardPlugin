package com.abiram26.blockguard.commands;

import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;
import com.mbserver.api.Server;
import com.mbserver.api.game.Player;

public class RemoveRegion implements CommandExecutor {
	final Server s1;

	public RemoveRegion(Server server) {
		this.s1 = server;
	}

	@Override
	public void execute(final String command, final CommandSender sender,
			final String[] args, final String label) {
		
		String[] newArgs = new String[args.length + 1];
		newArgs[0] = "rem";
		int c = 1;
		for (String partOfArgs : args) {
			newArgs[c] = partOfArgs;
			c++;
		}
		if (sender instanceof Player) {
			final Player player = (Player) sender;
			player.executeCommand("bgra", newArgs);
		} else {
			s1.executeCommand(s1.getConsoleCommandSender(), "bgra", newArgs);
			}
	}
}
