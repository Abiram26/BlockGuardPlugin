package com.abiram26.blockguard;

import com.abiram26.blockguard.commands.AddMember;
import com.abiram26.blockguard.commands.Information;
import com.abiram26.blockguard.commands.Position1;
import com.abiram26.blockguard.commands.Position2;
import com.abiram26.blockguard.commands.RemMember;
import com.abiram26.blockguard.commands.RemRegion;
import com.abiram26.blockguard.commands.SetProtect;
import com.abiram26.blockguard.events.BlockEventHandler;
import com.abiram26.blockguard.events.PvpHandler;
import com.mbserver.api.Constructors;
import com.mbserver.api.MBServerPlugin;
import com.mbserver.api.Manifest;
import com.mbserver.api.dynamic.UILine;
import com.mbserver.api.game.Location;
import com.mbserver.api.game.Player;

@Manifest(name = "BlockGuard", authors = "Abiram26", config = Config.class)
public class Plugin extends MBServerPlugin {

	public final static String stamp = "[BlockGuard] ";

	@Override
	public void onEnable() {
		this.getConfig();
		this.saveConfig();

		this.getServer()
				.getLogger()
				.info(Plugin.stamp
						+ ((Config) this.getConfig()).getRegions().size()
						+ " region(s) loaded!");

		this.getPluginManager().registerEventHandler(
				new BlockEventHandler((Config) this.getConfig()));
		this.getPluginManager().registerEventHandler(
				new PvpHandler((Config) this.getConfig()));
		this.getPluginManager().registerCommand("blockguard",
				new String[] { "bg" }, new Information());
		this.getPluginManager().registerCommand("blockguardposition1",
				new String[] { "bgpos1" }, new Position1(this));
		this.getPluginManager().registerCommand("blockguardposition2",
				new String[] { "bgpos2" }, new Position2(this));
		this.getPluginManager().registerCommand("blockguardset",
				new String[] { "bgset" }, new SetProtect(this));
		this.getPluginManager().registerCommand("blockguardaddmember",
				new String[] { "bgaddmember" }, new AddMember(this));
		this.getPluginManager().registerCommand("blockguardremovemember",
				new String[] { "bgremovemember" }, new RemMember(this));
		this.getPluginManager().registerCommand("blockguardremoveregion",
				new String[] { "bgremoveregion" }, new RemRegion(this));

	}

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		this.getServer().getLogger().info(Plugin.stamp + "Saving region(s)...");
		this.saveConfig();
		this.getServer()
				.getLogger()
				.info(Plugin.stamp + "Finished saving "
						+ ((Config) this.getConfig()).getRegions().size()
						+ " region(s)...");
	}

	public void makeBorder(Player player1) {
		player1.clearLines(false);
		if ((player1.getMetaData("BlockGuardX1", null) != player1.getMetaData(
				"BlockGuardX2", null))
				&& player1.getMetaData("BlockGuardX2", null) != null) {
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
