package com.abiram26.blockguard.commands.selection;

import com.abiram26.blockguard.BlockGuardPlugin;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;
import com.mbserver.api.game.Player;

public class Wand implements CommandExecutor {
	private BlockGuardPlugin p1;

	public Wand(final BlockGuardPlugin plugin) {
		// TODO Auto-generated constructor stub
		this.p1 = plugin;
	}

	@Override
	public void execute(final String command, final CommandSender sender, final String[] args,
			final String label) {
		// TODO Auto-generated method stub
		// Check for MBWorldEdit Plugin
		if (p1.hasMBWorldEditPlugin()) {
			final Player p2 = (Player) sender;
			p2.sendMessage(BlockGuardPlugin.stamp + "Executing MBWorldEdit's //wand");
			p2.executeCommand("/wand", null);

		}else{
			sender.sendMessage(BlockGuardPlugin.stamp+"The MBWorldEdit is not installed.");
		}
	}

}
