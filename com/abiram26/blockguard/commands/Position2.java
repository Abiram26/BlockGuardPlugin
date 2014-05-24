package com.abiram26.blockguard.commands;

import com.abiram26.blockguard.Plugin;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;
import com.mbserver.api.Constructors;
import com.mbserver.api.dynamic.UILine;
import com.mbserver.api.game.Location;
import com.mbserver.api.game.Player;

public class Position2 implements CommandExecutor {

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
				this.makeBorder(player);
			} else {
				sender.sendMessage(Plugin.stamp + "No permission!");
			}
		} else {
			sender.sendMessage(Plugin.stamp + "Command must be executed as a player!");
		}
	}

	private void makeBorder(Player player1) {
		// TODO Auto-generated method stub
		player1.clearLines(true);
		if ((player1.getMetaData("BlockGuardX1", null) != player1.getMetaData(
				"BlockGuardX2", null))
				&& player1.getMetaData("BlockGuardX1", null) != null) {
			Location loc1 = Constructors.newLocation(player1.getLocation()
					.getWorld(),
					player1.<Integer> getMetaData("BlockGuardX1", null)
							.floatValue(),
					player1.<Integer> getMetaData("BlockGuardY1", null)
							.floatValue(),
					player1.<Integer> getMetaData("BlockGuardZ1", null)
							.floatValue());
			Location loc2 = Constructors.newLocation(player1.getLocation()
					.getWorld(),
					player1.<Integer> getMetaData("BlockGuardX1", null)
							.floatValue(),
					player1.<Integer> getMetaData("BlockGuardY1", null)
							.floatValue(),
					player1.<Integer> getMetaData("BlockGuardZ2", null)
							.floatValue());
			Location loc3 = Constructors.newLocation(player1.getLocation()
					.getWorld(),
					player1.<Integer> getMetaData("BlockGuardX1", null)
							.floatValue(),
					player1.<Integer> getMetaData("BlockGuardY2", null)
							.floatValue(),
					player1.<Integer> getMetaData("BlockGuardZ1", null)
							.floatValue());
			Location loc4 = Constructors.newLocation(player1.getLocation()
					.getWorld(),
					player1.<Integer> getMetaData("BlockGuardX1", null)
							.floatValue(),
					player1.<Integer> getMetaData("BlockGuardY2", null)
							.floatValue(),
					player1.<Integer> getMetaData("BlockGuardZ2", null)
							.floatValue());
			Location loc5 = Constructors.newLocation(player1.getLocation()
					.getWorld(),
					player1.<Integer> getMetaData("BlockGuardX2", null)
							.floatValue(),
					player1.<Integer> getMetaData("BlockGuardY1", null)
							.floatValue(),
					player1.<Integer> getMetaData("BlockGuardZ1", null)
							.floatValue());
			Location loc6 = Constructors.newLocation(player1.getLocation()
					.getWorld(),
					player1.<Integer> getMetaData("BlockGuardX2", null)
							.floatValue(),
					player1.<Integer> getMetaData("BlockGuardY1", null)
							.floatValue(),
					player1.<Integer> getMetaData("BlockGuardZ2", null)
							.floatValue());
			Location loc7 = Constructors.newLocation(player1.getLocation()
					.getWorld(),
					player1.<Integer> getMetaData("BlockGuardX2", null)
							.floatValue(),
					player1.<Integer> getMetaData("BlockGuardY2", null)
							.floatValue(),
					player1.<Integer> getMetaData("BlockGuardZ1", null)
							.floatValue());
			Location loc8 = Constructors.newLocation(player1.getLocation()
					.getWorld(),
					player1.<Integer> getMetaData("BlockGuardX2", null)
							.floatValue(),
					player1.<Integer> getMetaData("BlockGuardY2", null)
							.floatValue(),
					player1.<Integer> getMetaData("BlockGuardZ2", null)
							.floatValue());
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

			player1.drawLine(bottom1);
			player1.drawLine(bottom2);
			player1.drawLine(bottom3);
			player1.drawLine(bottom4);

			player1.drawLine(side1);
			player1.drawLine(side2);
			player1.drawLine(side3);
			player1.drawLine(side4);

			player1.drawLine(top1);
			player1.drawLine(top2);
			player1.drawLine(top3);
			player1.drawLine(top4);
		}
	}

}
