package com.abiram26.blockguard.commands;

import com.abiram26.blockguard.Config;
import com.abiram26.blockguard.Plugin;
import com.abiram26.blockguard.model.Cuboid;
import com.abiram26.blockguard.model.Members;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;
import com.mbserver.api.game.Player;

public class SetProtect implements CommandExecutor {

	private final Plugin plugin;
	private final Config getConfig;

	public SetProtect(Plugin plugin) {
		// TODO Auto-generated constructor stub
		this.plugin = plugin;
		this.getConfig = this.plugin.getConfig();
	}

	@Override
	public void execute(String command, CommandSender sender, String[] args,
			String label) {
		// TODO Auto-generated method stub
		final int x1, x2, y1, y2, z1, z2;
		final Player player = (Player) sender;
		// Check if sender is console
		if ((sender instanceof Player)) {
			// Sender is not console
			// Check if sender has the permission
			if (sender.hasPermission("abiram26.blockguard.*")) {
				// Sender has permission
				// Check if length of arguments is equal to one
				if (args.length == 1) {
					// Length of arguments is equal to one
					// Check if the region-name in the argument is taken
					if (this.getConfig.hasRegion(args[0].toLowerCase()) == -1) {
						// The region-name in the argument is not taken
						// Check if positions are set
						if (player.getMetaData("BlockGuardX1", null) != null
								|| player.getMetaData("BlockGuardX2", null) != null) {
							// Positions are not null
							// Check if X positions are not the same
							if (player.getMetaData("BlockGuardX1", null) != player
									.getMetaData("BlockGuardX2", null)) {
								// X Positions are not the same
								// Check if Y positions are not the same
								if (player.getMetaData("BlockGuardY1", null) != player
										.getMetaData("BlockGuardY2", null)) {
									// Y positions are not the same
									// Check if Z positions are not the same
									if (player
											.getMetaData("BlockGuardZ1", null) != player
											.getMetaData("BlockGuardZ2", null)) {
										// Z Positions are not the same
										// Check if X1 is smaller than X2
										if (player.<Integer> getMetaData(
												"BlockGuardX1", null) < player
												.<Integer> getMetaData(
														"BlockGuardX2", null)) {
											// X1 is smaller than X2
											x1 = player.getMetaData(
													"BlockGuardX1", null);
											x2 = player.<Integer> getMetaData(
													"BlockGuardX2", null)
													- x1
													- 1;
										} else {
											// X1 is bigger than X2
											x1 = player.getMetaData(
													"BlockGuardX2", null);
											x2 = player.<Integer> getMetaData(
													"BlockGuardX1", null)
													- x1
													- 1;
										}
										// Check if Y1 is smaller than Y2
										if (player.<Integer> getMetaData(
												"BlockGuardY1", null) < player
												.<Integer> getMetaData(
														"BlockGuardY2", null)) {
											// Y1 is smaller than Y2
											y1 = player.getMetaData(
													"BlockGuardY1", null);
											y2 = player.<Integer> getMetaData(
													"BlockGuardY2", null)
													- y1
													- 1;
										} else {
											// Y1 is bigger than Y2
											y1 = player.getMetaData(
													"BlockGuardY2", null);
											y2 = player.<Integer> getMetaData(
													"BlockGuardY1", null)
													- y1
													- 1;
										}
										// Check if Z1 is smaller than Z2
										if (player.<Integer> getMetaData(
												"BlockGuardZ1", null) < player
												.<Integer> getMetaData(
														"BlockGuardZ2", null)) {
											// Z1 is smaller than Z2
											z1 = player.getMetaData(
													"BlockGuardZ1", null);
											z2 = player.<Integer> getMetaData(
													"BlockGuardZ2", null)
													- z1
													- 1;
										} else {
											// Z1 is bigger than Z2
											z1 = player.getMetaData(
													"BlockGuardZ2", null);
											z2 = player.<Integer> getMetaData(
													"BlockGuardZ1", null)
													- z1
													- 1;
										}
										getConfig.setRegion(new Cuboid(x1, y1,
												z1, x2, y2, z2, args[0].toLowerCase()));
										getConfig.setMembers(new Members(player
												.getName().toLowerCase()));
										this.plugin.saveConfig();
										sender.sendMessage(Plugin.stamp + "Guarded ["
												+ x1
												+ ","
												+ (x1 + x2)
												+ "|"
												+ y1
												+ ","
												+ (y1 + y2)
												+ "|"
												+ z1
												+ ","
												+ (z1 + z2)
												+ "] with you as owner!");
									} else {
										// Z Positions are the same
										sender.sendMessage(Plugin.stamp + "Not guarded: Identical Z positions.");
									}
								} else {
									// Y Positions are the same
									sender.sendMessage(Plugin.stamp + "Not guarded: Identical Y positions.");
								}
							} else {
								// X Positions are the same
								sender.sendMessage(Plugin.stamp + "Not guarded: Identical X positions.");
							}
						} else {
							// Positions are null
							sender.sendMessage(Plugin.stamp + "Not guarded: No points are set.");
						}
					} else {
						// Regionname is taken
						sender.sendMessage(Plugin.stamp + "Not guarded: There already is a region with that name!");
					}
				} else {
					// Length of arguments is not equal to one
					sender.sendMessage(Plugin.stamp + "Not guarded: Not enough arguments given, usage: /bgset <regionname>");
				}
			} else {
				// Sender has no permission
				sender.sendMessage(Plugin.stamp + "Not Guarded: No permission to use.");
			}
		} else {
			// Sender is console
			sender.sendMessage(Plugin.stamp + "Command must be executed as a player!");
		}

	}
}
