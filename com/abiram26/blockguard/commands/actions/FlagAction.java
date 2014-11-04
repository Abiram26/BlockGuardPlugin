package com.abiram26.blockguard.commands.actions;

import com.abiram26.blockguard.BlockGuardPlugin;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;
import com.mbserver.api.Server;
import com.mbserver.api.game.Player;

public class FlagAction implements CommandExecutor {
	/**
	 * args[0] = action
	 * 
	 * args[1] = region
	 * 
	 * args[2] = (optional) flag
	 * 
	 * args[3] = (optional) new value for flag
	 */

	public FlagAction(Server server) {
		this.s1 = server;
	}

	final Server s1;

	@Override
	public void execute(final String command, final CommandSender sender,
			final String[] args, final String label) {
		if (args.length == 0) {
			sender.sendMessage(BlockGuardPlugin.stamp + "No arguments were given!");
			return;
		}
		final CommandSender cs1;
		if (sender instanceof Player) {
			cs1 = sender;
		} else {
			cs1 = s1.getConsoleCommandSender();
		}

		if (args[0].equalsIgnoreCase("flags")) {
			s1.executeCommand(cs1, "bgra", args);
		} else if (args[0].equalsIgnoreCase("set")) {
			args[0] = "setflag";
			s1.executeCommand(cs1, "bgra", args);
		} else if (args[0].equalsIgnoreCase("get")) {
			args[0] = "getflag";
			s1.executeCommand(cs1, "bgra", args);
		} else {
			sender.sendMessage(BlockGuardPlugin.stamp
					+ "The first argument is invalid: No such action!");
			return;
		}
	}
}
