package com.abiram26.blockguard.commands;

import com.abiram26.blockguard.Plugin;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;
import com.mbserver.api.Constructors;
import com.mbserver.api.dynamic.UILine;
import com.mbserver.api.game.Location;
import com.mbserver.api.game.Player;
import com.mbserver.api.game.World;

public class Position implements CommandExecutor {

	@Override
	public void execute(final String command, final CommandSender sender,
			final String[] args, final String label) {
		// TODO Auto-generated method stub
		// Check if commandsender is not the server
		if (sender instanceof Player) {
			final Player player = (Player) sender;
			// Check for permissions
			if (sender.hasPermission("abiram26.blockguard.*")) {
				final int posX = player.getLocation().getBlockX();
				final int posY = player.getLocation().getBlockY();
				final int posZ = player.getLocation().getBlockZ();
				// Check for command
				if (label.equalsIgnoreCase("bgpos1")
						|| label.equalsIgnoreCase("blockguardposition1")) {

					player.setMetaData("BlockGuardX1", posX);
					player.setMetaData("BlockGuardY1", posY);
					player.setMetaData("BlockGuardZ1", posZ);
					sender.sendMessage(Plugin.stamp + "Position 1 set! ["
							+ posX + "," + posY + "," + posZ + "]");
				} else {

					// TODO Auto-generated method stub

					player.setMetaData("BlockGuardX2", posX);
					player.setMetaData("BlockGuardY2", posY);
					player.setMetaData("BlockGuardZ2", posZ);
					sender.sendMessage(Plugin.stamp + "Position 2 set! ["
							+ posX + "," + posY + "," + posZ + "]");
				}
				this.makeBorder(player);
			} else {
				sender.sendMessage(Plugin.stamp + "No permission!");
			}
		} else {
			sender.sendMessage(Plugin.stamp
					+ "Command must be executed as a player!");
		}

	}

	private void makeBorder(final Player player1) {
		// TODO Auto-generated method stub
		player1.clearLines(false);
		final int yT1 = player1.getMetaData("BlockGuardY1", -1);
		final int yT2 = player1.getMetaData("BlockGuardY2", -1);
		if (yT1 != -1 && yT2 != -1) {
			final float y1 = (float) yT1;
			final float y2 = (float) yT2;
			final float x1 = player1
					.<Integer> getMetaData("BlockGuardX1", null).floatValue();
			final float x2 = player1
					.<Integer> getMetaData("BlockGuardX2", null).floatValue();
			final float z1 = player1
					.<Integer> getMetaData("BlockGuardZ1", null).floatValue();
			final float z2 = player1
					.<Integer> getMetaData("BlockGuardZ2", null).floatValue();
			final World w1 = player1.getLocation().getWorld();

			Location loc1 = Constructors.newLocation(w1, x1, y1, z1);
			Location loc2 = Constructors.newLocation(w1, x1, y1, z2);
			Location loc3 = Constructors.newLocation(w1, x1, y2, z1);
			Location loc4 = Constructors.newLocation(w1, x1, y2, z2);
			Location loc5 = Constructors.newLocation(w1, x2, y1, z1);
			Location loc6 = Constructors.newLocation(w1, x2, y1, z2);
			Location loc7 = Constructors.newLocation(w1, x2, y2, z1);
			Location loc8 = Constructors.newLocation(w1, x2, y2, z2);
			
			// bottom
			UILine bottom1 = new UILine(loc1, loc2);
			UILine bottom2 = new UILine(loc1, loc5);
			UILine bottom3 = new UILine(loc2, loc6);
			UILine bottom4 = new UILine(loc5, loc6);

			// side
			UILine side1 = new UILine(loc1, loc3);
			UILine side2 = new UILine(loc2, loc4);
			UILine side3 = new UILine(loc5, loc7);
			UILine side4 = new UILine(loc6, loc8);

			// top
			UILine top1 = new UILine(loc3, loc4);
			UILine top2 = new UILine(loc3, loc7);
			UILine top3 = new UILine(loc4, loc8);
			UILine top4 = new UILine(loc7, loc8);

			player1.drawLine(bottom1, false);
			player1.drawLine(bottom2, false);
			player1.drawLine(bottom3, false);
			player1.drawLine(bottom4, false);

			player1.drawLine(side1, false);
			player1.drawLine(side2, false);
			player1.drawLine(side3, false);
			player1.drawLine(side4, false);

			player1.drawLine(top1, false);
			player1.drawLine(top2, false);
			player1.drawLine(top3, false);
			player1.drawLine(top4, true);
		}

	}

}
