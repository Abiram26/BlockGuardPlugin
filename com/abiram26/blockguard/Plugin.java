package com.abiram26.blockguard;

import java.util.logging.Logger;

import com.abiram26.blockguard.commands.AddMember;
import com.abiram26.blockguard.commands.Information;
import com.abiram26.blockguard.commands.Position;
import com.abiram26.blockguard.commands.RegionList;
import com.abiram26.blockguard.commands.RemMember;
import com.abiram26.blockguard.commands.RemRegion;
import com.abiram26.blockguard.commands.SetProtect;
import com.abiram26.blockguard.commands.Wand;
import com.abiram26.blockguard.events.BlockEventHandler;
import com.abiram26.blockguard.events.PvpHandler;
import com.abiram26.blockguard.events.ServerStartedListener;
import com.abiram26.blockguard.events.WandHandler;
import com.abiram26.blockguard.storage.Config;
import com.mbserver.api.MBServerPlugin;
import com.mbserver.api.Manifest;
import com.mbserver.api.PluginManager;
import com.mbserver.api.Server;

@Manifest(name = "BlockGuard", authors = "Abiram26", config = Config.class)
public class Plugin extends MBServerPlugin {

	public final static String stamp = "[BlockGuard] ";
	private boolean hasWE = false;
	private int wandPos1Id = -1;
	private int wandPos2Id = -1;

	// Permissions
	// abiram26.blockguard.set [remove+pos1+pos2+set]
	// abiram26.blockguard.* [all]
	// abiram26.blockguard.canbuild [build in protected area]
	// abiram26.blockguard.canpvp [pvp in protected area]

	@Override
	public void onEnable() {
		final PluginManager pM = this.getPluginManager();
		final Logger log1 = this.getLogger();

		// Load Config
		this.getConfig();
		this.saveConfig();

		final Config cfg = this.<Config> getConfig();
		log1.info(Plugin.stamp + cfg.getRegions().size() + " region(s) loaded!");

		// Register Handlers
		pM.registerEventHandler(new BlockEventHandler(cfg));

		pM.registerEventHandler(new PvpHandler(cfg));
		
		// Check if MBWorldEdit exists
		try {
			Class.forName("com.ikkerens.worldedit.WorldEditPlugin");
			hasWE = true;
		} catch (final ClassNotFoundException e) {
			// hadWE is false by default
		}
		
		// Register MBWorldEdit Handlers if the plugin is installed
		if (hasWE) {
			log1.info(Plugin.stamp + "MBWorldEdit found!");
			log1.info(Plugin.stamp
					+ "Implementing MBWorldEdit selection tools!");
			// Register BlockPlaces/BlockBreaks/Command
			pM.registerEventHandler(new WandHandler(this));
			// Register ServerStarted
			pM.registerEventHandler(new ServerStartedListener(this));
		}

		// Register Commands
		pM.registerCommand("blockguard", new String[] { "bg" },
				new Information());
		pM.registerCommand("blockguardposition1", new String[] { "bgpos1",
				"blockguardposition2", "bgpos2" }, new Position());
		pM.registerCommand("blockguardset", new String[] { "bgset" },
				new SetProtect(this));
		pM.registerCommand("blockguardaddmember",
				new String[] { "bgaddmember" }, new AddMember(this));
		pM.registerCommand("blockguardremovemember",
				new String[] { "bgremovemember" }, new RemMember(this));
		pM.registerCommand("blockguardremoveregion",
				new String[] { "bgremoveregion" }, new RemRegion(this));
		pM.registerCommand("blockguardwand", new String[] { "bgwand" },
				new Wand(this));
		pM.registerCommand("blockguardregionlist",
				new String[] { "bgregionlist" }, new RegionList(this));

		// Check if Memberlist size is equal to Regions size
		final int memSize = cfg.getMembers().size();
		final int regSize = cfg.getRegions().size();
		if (memSize != regSize) {
			// Something is wrong here
			if (memSize > regSize) {
				for (int x = 0; x < (memSize - regSize); x++) {
					cfg.getMembers().remove(memSize - (x + 1));
				}
			} else {
				for (int x = 0; x < (regSize - memSize); x++) {
					cfg.getRegions().remove(regSize - (x + 1));
				}
			}
		}
	}

	public void setWandPos1Id(int wandPos1Id) {
		this.wandPos1Id = wandPos1Id;
	}

	public void setWandPos2Id(int wandPos2Id) {
		this.wandPos2Id = wandPos2Id;
	}

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		final Server s1 = this.getServer();
		s1.getLogger().info(Plugin.stamp + "Saving region(s)...");

		s1.getLogger().info(
				Plugin.stamp + "Finished saving "
						+ this.<Config> getConfig().getRegions().size()
						+ " region(s)...");
		this.saveConfig();
	}

	public boolean hasMBWorldEditPlugin() {
		return hasWE;
	}

	public int getWandPos1Id() {
		return wandPos1Id;
	}

	public int getWandPos2Id() {
		return wandPos2Id;
	}

	// TO-DO list
	/**
	 *  
	 */

}
