package com.abiram26.blockguard.commands;

import com.abiram26.blockguard.BlockGuardPlugin;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;
import com.mbserver.api.game.Player;

public class SetRegion implements CommandExecutor {


	public SetRegion() {
	}

	@Override
	public void execute(final String command, final CommandSender sender,
			final String[] args, final String label) {
		// TODO Auto-generated method stub
		// Check if sender is console
		if ((sender instanceof Player)) {
			// Sender is not console
			final Player player = (Player) sender;
			String[] newArgs = new String[args.length+1];
			newArgs[0]= "set";
			int c = 1;
			for(String partOfArgs: args){
				newArgs[c]=partOfArgs;
				c++;
			}
			player.executeCommand("bgra", newArgs);
		} else {
			// Sender is console
			sender.sendMessage(BlockGuardPlugin.stamp
					+ "Command must be executed as a player!");
		}

	}

}
