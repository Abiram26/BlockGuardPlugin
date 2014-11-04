package com.abiram26.blockguard.commands;

import com.abiram26.blockguard.BlockGuardPlugin;
import com.abiram26.blockguard.model.Cuboid;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;
import com.mbserver.api.dynamic.ChatColor;
import com.mbserver.api.game.Location;
import com.mbserver.api.game.Player;

public class Coordinates implements CommandExecutor {
	final private BlockGuardPlugin p1;

	public Coordinates(final BlockGuardPlugin plugin) {
		// TODO Auto-generated constructor stub
		p1 = plugin;
	}

	@Override
	public void execute(final String command, final CommandSender sender,
			final String[] args, final String label) {
		if (!sender.hasPermission("abiram26.blockguard.*")
				&& !sender.hasPermission("abiram26.blockguard.coordinates")) {
			sender.sendMessage(BlockGuardPlugin.stamp
					+ "You do not have the permission to use this command!");
			return;
		}
		if (!(sender instanceof Player)) {
			sender.sendMessage(BlockGuardPlugin.stamp
					+ "This command must be executed as a player!");
			return;
		}
		
		if (args.length>0){
			sender.sendMessage(BlockGuardPlugin.stamp
					+ "This command does not need an argument!");
		}
		
		final Location playerLoc = ((Player) sender).getLocation();
		final int x1 = playerLoc.getBlockX();
		final int y1 = playerLoc.getBlockY();
		final int z1 = playerLoc.getBlockZ();
		final String w1 = playerLoc.getWorld().getWorldName();
		sender.sendMessage(BlockGuardPlugin.stamp + "The coordinates you have:");
		sender.sendMessage(ChatColor.WHITE + "X: " + x1);
		sender.sendMessage(ChatColor.WHITE + "Y: " + y1);
		sender.sendMessage(ChatColor.WHITE + "Z: " + z1);
		sender.sendMessage(ChatColor.WHITE + "WORLD: " + w1);
		boolean coordsMsgSent = false;
		for (Cuboid c1 : p1.getRegions().getRegions()) {
			if (c1.contains(x1, y1, z1, w1)) {
				if (!coordsMsgSent) {
					sender.sendMessage(BlockGuardPlugin.stamp + "The regions you are in:");
					coordsMsgSent = true;
				}
				sender.sendMessage(ChatColor.WHITE + c1.getRegionName());
			}
		}
	}

}
