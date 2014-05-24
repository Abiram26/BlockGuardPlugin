package com.abiram26.blockguard.commands;

import com.abiram26.blockguard.Plugin;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;
import com.mbserver.api.game.Player;

public class Position1 implements CommandExecutor {

	private final Plugin plugin;
	public Position1(Plugin plugin) {
		// TODO Auto-generated constructor stub
		this.plugin = plugin;
	}

	@Override
	public void execute(String command, CommandSender sender, String[] args,
			String label) {
		// TODO Auto-generated method stub
		if (sender instanceof Player) {
			final Player player = (Player) sender;
			if (sender.hasPermission("abiram26.blockguard.*")) {
				int pos1X = player.getLocation().getBlockX();
				int pos1Y = player.getLocation().getBlockY();
				int pos1Z = player.getLocation().getBlockZ();

				player.setMetaData("BlockGuardX1", pos1X);
				player.setMetaData("BlockGuardY1", pos1Y);
				player.setMetaData("BlockGuardZ1", pos1Z);
				sender.sendMessage(Plugin.stamp + "Position 1 set! [" + pos1X
						+ "," + pos1Y + "," + pos1Z + "]");
				this.plugin.makeBorder(player);
			} else {
				sender.sendMessage(Plugin.stamp + "No permission!");
			}
		} else {
			sender.sendMessage(Plugin.stamp + "Command must be executed as a player!");
		}

	}

}
