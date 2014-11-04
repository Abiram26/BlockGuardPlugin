package com.abiram26.blockguard.commands.selection;

import com.abiram26.blockguard.BlockGuardPlugin;
import com.abiram26.blockguard.model.Cuboid;
import com.abiram26.blockguard.storage.Config;
import com.abiram26.blockguard.storage.Regions;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;
import com.mbserver.api.dynamic.ChatColor;
import com.mbserver.api.game.Player;

public class SelectionInfo implements CommandExecutor {
	private final BlockGuardPlugin p1;
	private final Regions cfg;
	private final Config config;

	public SelectionInfo(BlockGuardPlugin plugin) {
		this.p1 = plugin;
		this.cfg = p1.getRegions();
		this.config = p1.<Config> getConfig();
	}

	@Override
	public void execute(String command, CommandSender sender, String[] args,
			String label) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(BlockGuardPlugin.stamp
					+ "This command must be executed as a player!");
			return;
		}
		final Player pl = (Player) sender;
		final int x1, x2, y1, y2, z1, z2;

		// Check if positions are set
		if (pl.<Integer> getMetaData("BlockGuardY2", -1) == -1
				&& pl.<Integer> getMetaData("BlockGuardY1", -1) == -1) {
			// Positions are null
			sender.sendMessage(BlockGuardPlugin.stamp
					+ "There is no selection made!");
			return;
		}
		y1 = Math.min(pl.<Integer> getMetaData("BlockGuardY1", null),
				pl.<Integer> getMetaData("BlockGuardY2", null));

		y2 = Math.max(pl.<Integer> getMetaData("BlockGuardY1", null),
				pl.<Integer> getMetaData("BlockGuardY2", null))
				- y1 + 1;
		x1 = Math.min(pl.<Integer> getMetaData("BlockGuardX1", null),
				pl.<Integer> getMetaData("BlockGuardX2", null));
		x2 = Math.max(pl.<Integer> getMetaData("BlockGuardX1", null),
				pl.<Integer> getMetaData("BlockGuardX2", null))
				- x1 + 1;
		z1 = Math.min(pl.<Integer> getMetaData("BlockGuardZ1", null),
				pl.<Integer> getMetaData("BlockGuardZ2", null));
		z2 = Math.max(pl.<Integer> getMetaData("BlockGuardZ1", null),
				pl.<Integer> getMetaData("BlockGuardZ2", null))
				- z1 + 1;

		// A region of the selection (not to add to Config!)
		final String world = pl.getLocation().getWorld().getWorldName();
		final Cuboid selection = new Cuboid(x1, y1, z1, x2, y2, z2, "-", world);

		boolean hasOverlap = false;
		float largestOverlapPercentage = 0;
		for (Cuboid c1 : cfg.getRegions()) {
			// 16-points check
			if (!c1.contains(x1, y1, z1, world)
					&& !c1.contains(x1 + x2, y1, z1, world)
					&& !c1.contains(x1 + x2, y1 + y2, z1, world)
					&& !c1.contains(x1 + x2, y1, z1 + z2, world)
					&& !c1.contains(x1 + x2, y1 + y1, z1 + z2, world)
					&& !c1.contains(x1, y1 + y2, z1, world)
					&& !c1.contains(x1, y1, z1 + z2, world)
					&& !c1.contains(x1, y1 + y2, z1 + z2, world)
					&& !selection.contains(c1.getX(), c1.getY(), c1.getZ(),
							c1.getWorldName())
					&& !selection.contains(c1.getX() + c1.getdX() - 1,
							c1.getdY(), c1.getZ(), c1.getWorldName())
					&& !selection.contains(c1.getX() + c1.getdX() - 1,
							c1.getY() + c1.getdY() - 1, c1.getZ(),
							c1.getWorldName())
					&& !selection.contains(c1.getX() + c1.getdX() - 1,
							c1.getY(), c1.getZ() + c1.getdZ() - 1,
							c1.getWorldName())
					&& !selection.contains(c1.getX() + c1.getdX() - 1,
							c1.getY() + c1.getdY() - 1, c1.getZ() + c1.getdZ()
									- 1, c1.getWorldName())
					&& !selection.contains(c1.getX(), c1.getY() + c1.getdY()
							- 1, c1.getZ(), c1.getWorldName())
					&& !selection.contains(c1.getX(), c1.getY(),
							c1.getZ() + c1.getdZ() - 1, c1.getWorldName())
					&& !selection.contains(c1.getX(), c1.getY() + c1.getdY()
							- 1, c1.getZ() + c1.getdZ() - 1, c1.getWorldName())
			) {
				// Skip checking this region

			} else {
				int blockCount = 0;
				for (int x = x1; x != (x2 + x1); x++) {
					for (int y = y1; y != (y2 + y1); y++) {
						for (int z = z1; z != (z2 + z1); z++) {
							if (c1.contains(x, y, z, world)) {
								blockCount++;
							}
						}
					}
				}
				if (blockCount == 0) {
					// Do nothing :)
				} else {
					if (!hasOverlap) {
						sender.sendMessage(BlockGuardPlugin.stamp
								+ "List of every overlapping region:");
						hasOverlap = true;
					}
					final int totalCount = c1.getdX() * c1.getdY() * c1.getdZ();
					final float percentage = (float) blockCount
							/ (float) totalCount * 100.0f;
					final String bars;
					switch((int) percentage/10){
					case 0: bars = ChatColor.LIGHT_GRAY+ "||||||||||"; break;
					case 1: bars = ChatColor.GREEN+ "|" + ChatColor.LIGHT_GRAY + "|||||||||"; break;
					case 2: bars = ChatColor.GREEN+ "||" + ChatColor.LIGHT_GRAY + "||||||||"; break;	
					case 3: bars = ChatColor.GREEN+ "|||" + ChatColor.LIGHT_GRAY + "|||||||"; break;
					case 4: bars = ChatColor.GREEN+ "|||" +ChatColor.YELLOW + "|" + ChatColor.LIGHT_GRAY + "||||||"; break;
					case 5: bars = ChatColor.GREEN+ "|||" +ChatColor.YELLOW + "||" + ChatColor.LIGHT_GRAY + "|||||"; break;
					case 6: bars = ChatColor.GREEN+ "|||" +ChatColor.YELLOW + "|||"+ ChatColor.LIGHT_GRAY + "||||"; break;
					case 7: bars = ChatColor.GREEN+ "|||" +ChatColor.YELLOW + "|||"+  ChatColor.RED + "|" +ChatColor.LIGHT_GRAY + "|||"; break;
					case 8: bars = ChatColor.GREEN+ "|||" +ChatColor.YELLOW + "|||"+  ChatColor.RED + "||" + ChatColor.LIGHT_GRAY + "||"; break;
					case 9: bars = ChatColor.GREEN+ "|||" +ChatColor.YELLOW + "|||"+  ChatColor.RED + "|||" + ChatColor.LIGHT_GRAY + "|"; break;
					case 10: bars = ChatColor.GREEN+ "|||" +ChatColor.YELLOW + "|||"+   ChatColor.RED + "|||" +ChatColor.DARK_RED + "|" ; break;
					default: bars = ChatColor.LIGHT_GRAY+ "||||||||||"; break;
					}
					sender.sendMessage(ChatColor.WHITE + "[" + bars + ChatColor.WHITE +"] "+c1.getRegionName()
							+ " overlaps your current selection with "
							+ blockCount + "/" + totalCount + " blocks. ("
							+ percentage + "%)");
					if (percentage > largestOverlapPercentage) {
						largestOverlapPercentage = percentage;
					}
				}
			}
		}

		if (config.isAutomaticOverlapCheck()) {
			pl.setMetaData("BlockGuardOverlapPercentage",
					largestOverlapPercentage);
		}

		if (!hasOverlap) {
			sender.sendMessage(BlockGuardPlugin.stamp
					+ "There were no overlapping regions!");
		}

	}
}
