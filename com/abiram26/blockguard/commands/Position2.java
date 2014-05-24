package com.abiram26.blockguard.commands;

import com.abiram26.blockguard.Plugin;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;
import com.mbserver.api.game.Player;

public class Position2 implements CommandExecutor {
private final Plugin plugin;
	public Position2(Plugin plugin) {
		// TODO Auto-generated constructor stub
		this.plugin = plugin;
	}

	@Override
	public void execute(String command, CommandSender sender, String[] args,
			String label) {
		if (sender instanceof Player) {
			final Player player = (Player) sender;
			if (sender.hasPermission("abiram26.blockguard.*")) {
				int pos2X = player.getLocation().getBlockX();
				int pos2Y = player.getLocation().getBlockY();
				int pos2Z = player.getLocation().getBlockZ();
				// TODO Auto-generated method stub

				player.setMetaData("BlockGuardX2", pos2X);
				player.setMetaData("BlockGuardY2", pos2Y);
				player.setMetaData("BlockGuardZ2", pos2Z);
				sender.sendMessage(Plugin.stamp + "Position 2 set! [" + pos2X
						+ "," + pos2Y + "," + pos2Z + "]");
				this.plugin.makeBorder(player);
			} else {
				sender.sendMessage(Plugin.stamp + "No permission!");
			}
		} else {
			sender.sendMessage(Plugin.stamp + "Command must be executed as a player!");
		}
	}

}
