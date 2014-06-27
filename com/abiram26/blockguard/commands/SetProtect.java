package com.abiram26.blockguard.commands;

import com.abiram26.blockguard.Plugin;
import com.abiram26.blockguard.model.Cuboid;
import com.abiram26.blockguard.model.Members;
import com.abiram26.blockguard.storage.Config;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;
import com.mbserver.api.game.Player;

public class SetProtect implements CommandExecutor {

	private final Plugin plugin;
	private final Config getConfig;

	public SetProtect(final Plugin plugin) {
		// TODO Auto-generated constructor stub
		this.plugin = plugin;
		this.getConfig = this.plugin.getConfig();
	}

	@Override
	public void execute(final String command, final CommandSender sender, final String[] args,
			final String label) {
		// TODO Auto-generated method stub
		// Check if sender is console
		if ((sender instanceof Player)) {
			// Sender is not console
			final Player player = (Player) sender;
			// Check if sender has the permission
			if (sender.hasPermission("abiram26.blockguard.*")) {
				// Sender has permission
				// Check if length of arguments is equal to one
				if (args.length == 1) {
					// Length of arguments is equal to one
					// Check if the region-name in the argument is taken
					if (this.getConfig.hasRegion(args[0]) == -1) {
						// The region-name in the argument is not taken
						final int x1, x2, y1, y2, z1, z2;
						
						y1 = player.getMetaData("BlockGuardY1", -1);
						y2 = player.getMetaData("BlockGuardY2", -1);
						
						// Check if positions are set
						if (y1 != -1 || y2 != -1) {
							// Positions are not null
							x1 = player.getMetaData("BlockGuardX1", null);
							x2 = player.getMetaData("BlockGuardX2", null);
							z1 = player.getMetaData("BlockGuardZ1", null);
							z2 = player.getMetaData("BlockGuardZ2", null);
							// Check if X positions are not the same
							if (x1 != x2) {
								// X Positions are not the same
								// Check if Y positions are not the same
								if (y1 != y2) {
									// Y positions are not the same
									// Check if Z positions are not the same
									if (z1 != z2) {
										// Z Positions are not the same
										// Make the region
										this.createRegion(x1, x2, y1, y2, z1, z2, args[0], player);
									} else {
										// Z Positions are the same
										sender.sendMessage(Plugin.stamp
												+ "Not guarded: Identical Z positions.");
									}
								} else {
									// Y Positions are the same
									sender.sendMessage(Plugin.stamp
											+ "Not guarded: Identical Y positions.");
								}
							} else {
								// X Positions are the same
								sender.sendMessage(Plugin.stamp
										+ "Not guarded: Identical X positions.");
							}
						} else {
							// Positions are null
							sender.sendMessage(Plugin.stamp
									+ "Not guarded: No points are set.");
						}
					} else {
						// Regionname is taken
						sender.sendMessage(Plugin.stamp
								+ "Not guarded: There already is a region with that name!");
					}
				} else {
					// Length of arguments is not equal to one
					sender.sendMessage(Plugin.stamp
							+ "Not guarded: Not enough arguments given, usage: /bgset <regionname>");
				}
			} else {
				// Sender has no permission
				sender.sendMessage(Plugin.stamp
						+ "Not Guarded: No permission to use.");
			}
		} else {
			// Sender is console
			sender.sendMessage(Plugin.stamp
					+ "Command must be executed as a player!");
		}

	}

	public void createRegion(int x1, int x2, int y1, int y2, int z1, int z2,
			final String regionName, final Player p1) {
		// Check if X1 is smaller than X2
		if (x1 < x2) {
			// TRUE
			x2 = x2 - x1 - 1;
		} else {
			// FALSE
			final int temp = x1;
			x1 = x2;
			x2 = temp - x1 - 1;
		}
		// Check if Y1 is smaller than Y2
		if (y1 < y2) {
			// TRUE
			y2 = y2 - y1 - 1;
		} else {
			// FALSE
			final int temp = y1;
			y1 = y2;
			y2 = temp - y1 - 1;
		}
		// Check if Z1 is smaller than Z2
		if (z1 < z2) {
			// TRUE
			z2 = z2 - z1 - 1;
		} else {
			// FALSE
			final int temp = z1;
			z1 = z2;
			z2 = temp - z1 - 1;
		}
		// Add a new region
		getConfig.setRegion(new Cuboid(x1, y1, z1, x2, y2, z2, regionName));
		// Add a new memberlist for that region
		getConfig.setMembers(new Members(p1.getName()));
		// Save the config
		this.plugin.saveConfig();
		// A success-message for the player
		p1.sendMessage(Plugin.stamp + "Guarded [" + x1 + "," + (x1 + x2) + "|"
				+ y1 + "," + (y1 + y2) + "|" + z1 + "," + (z1 + z2)
				+ "] with you as owner!");
	}
}
