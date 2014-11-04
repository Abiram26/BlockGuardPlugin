package com.abiram26.blockguard.commands;

import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;
import com.mbserver.api.Server;

public class Teleport implements CommandExecutor {
	final Server s1;

	public Teleport(Server server) {
		this.s1 = server;
	}

	@Override
	public void execute(String command, CommandSender sender, String[] args,
			String label) {
		String[] newArgs = new String[args.length + 1];
		newArgs[0] = "tp";
		int c = 1;
		for (String partOfArgs : args) {
			newArgs[c] = partOfArgs;
			c++;
		}
		s1.executeCommand(sender, "bgra", newArgs);
		
	}

}
