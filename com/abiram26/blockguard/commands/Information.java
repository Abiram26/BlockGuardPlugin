package com.abiram26.blockguard.commands;

import com.abiram26.blockguard.Plugin;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;

public class Information implements CommandExecutor {
	
	@Override
	public void execute(final String command, final CommandSender sender, final String[] args,
			final String label) {
		// TODO Auto-generated method stub
		sender.sendMessage(Plugin.stamp+"All commands:");
		sender.sendMessage("/bg [Shows all commands]");
		sender.sendMessage("/bgpos1 [Marks position 1, so a region can be set]");
		sender.sendMessage("/bgpos2 [Marks position 2, so a region can be set]");
		sender.sendMessage("/bgset <regionname> [Creates a region with you as the owner]");
		sender.sendMessage("/bgaddmember <regionname> <membername> [Adds a member to a region]");
		sender.sendMessage("/bgremovemember <regionname> <membername> [Removes a member from a region]");
		sender.sendMessage("/bgremoveregion <regionname> [Removes a region (and it's members)]");
		sender.sendMessage("/bgwand [Gives you the MBWorldEdit Wand-blocks]");
		sender.sendMessage("/bgregionlist [Gives you all regionnames and their owner]");
	}

}
