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
import com.mbserver.api.MBServerPlugin;
import com.mbserver.api.Manifest;

@Manifest(name = "BlockGuard", authors = "Abiram26", config = Config.class)
public class Plugin extends MBServerPlugin {

	public final static String stamp = "[BlockGuard] ";

	// Permissions
	// abiram26.blockguard.set [remove+pos1+pos2+set]
	// abiram26.blockguard.* [all]
	// abiram26.blockguard.canbuild [build in protected area]
	// abiram26.blockguard.canpvp [pvp in protected area]

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
				new String[] { "bgpos1" }, new Position1());
		this.getPluginManager().registerCommand("blockguardposition2",
				new String[] { "bgpos2" }, new Position2());
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
}
