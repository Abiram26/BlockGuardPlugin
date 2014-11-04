package com.abiram26.blockguard.commands.actions;

import com.abiram26.blockguard.BlockGuardPlugin;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;
import com.mbserver.api.game.Player;

public class MemberAction implements CommandExecutor {
	/**
	 * args[0] = action
	 * 
	 * args[1] = region
	 * 
	 * args[2] = (optional) member
	 */


	public MemberAction() {
	}

	@Override
	public void execute(final String command, final CommandSender sender,
			 String[] args, final String label) {
		if(args.length==0){
			sender.sendMessage(BlockGuardPlugin.stamp
					+ "No arguments were given!");
			return;
		}
		final Player p1 = ((Player)sender);
		if(args[0].equalsIgnoreCase("members")){
			p1.executeCommand("bgra", args);
		}else if(args[0].equalsIgnoreCase("add")){
			args[0]="addmember";
			p1.executeCommand("bgra", args);
		}else if(args[0].equalsIgnoreCase("remove")){
			args[0]="remmember";
			p1.executeCommand("bgra", args);
		}else{
			sender.sendMessage(BlockGuardPlugin.stamp
					+ "The first argument is invalid: No such action!");
			return;
		}
	}
}
