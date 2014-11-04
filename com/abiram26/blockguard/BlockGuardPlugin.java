// The package of this plugin
package com.abiram26.blockguard;

// Import the a Java class
import java.util.logging.Logger;

// Import classes from this plugin
import com.abiram26.blockguard.commands.Coordinates;
import com.abiram26.blockguard.commands.Information;
import com.abiram26.blockguard.commands.RegionList;
import com.abiram26.blockguard.commands.RemoveRegion;
import com.abiram26.blockguard.commands.SetRegion;
import com.abiram26.blockguard.commands.Teleport;
import com.abiram26.blockguard.commands.actions.FlagAction;
import com.abiram26.blockguard.commands.actions.MemberAction;
import com.abiram26.blockguard.commands.actions.RegionAction;
import com.abiram26.blockguard.commands.selection.Position;
import com.abiram26.blockguard.commands.selection.SelectionInfo;
import com.abiram26.blockguard.commands.selection.Wand;
import com.abiram26.blockguard.events.BlockListeners;
import com.abiram26.blockguard.events.ChatListener;
import com.abiram26.blockguard.events.CommandListener;
import com.abiram26.blockguard.events.InterActionListeners;
import com.abiram26.blockguard.events.MovementListener;
import com.abiram26.blockguard.events.NPCListeners;
import com.abiram26.blockguard.events.PlayerInventoryListeners;
import com.abiram26.blockguard.events.PositionListeners;
import com.abiram26.blockguard.events.PlayerHealthListeners;
import com.abiram26.blockguard.events.ServerStartedListener;
import com.abiram26.blockguard.events.SignListener;
import com.abiram26.blockguard.events.TNTListener;
import com.abiram26.blockguard.events.WandListener;
import com.abiram26.blockguard.events.WorldGrowthListeners;
import com.abiram26.blockguard.model.Flags;
import com.abiram26.blockguard.storage.Config;
import com.abiram26.blockguard.storage.RegionFlags;
import com.abiram26.blockguard.storage.RegionMembers;
import com.abiram26.blockguard.storage.Regions;
// Import classes from the MBServerAPI
import com.mbserver.api.MBServerPlugin;
import com.mbserver.api.Manifest;
import com.mbserver.api.PluginManager;
import com.mbserver.api.Server;
import com.mbserver.api.dynamic.ChatColor;

// Manifest
@Manifest(name = "BlockGuard", authors = "Abiram26", config = Config.class)
// Extending MBServerPlugin to make this the main class
public class BlockGuardPlugin extends MBServerPlugin {
	// Plugin Tag
	public final static String stamp = ChatColor.CYAN + "["
			+ ChatColor.GREEN + "BlockGuard" + ChatColor.CYAN + "] "
			+ ChatColor.WHITE;
	// MBWorldEdit Support
	private boolean hasWE = false;
	// Wand Block ID's
	private int wandPos1Id = -1;
	private int wandPos2Id = -1;
	// Easy config access
	private Regions regions;
	private RegionMembers members;
	private RegionFlags flags;
	// The plugin
	private BlockGuardPlugin plugin;

	// Actions when the server enables the plugin
	/**
	 * OnEnable method
	 */
	@Override
	public void onEnable() {
		plugin = this;
		// For easy access
		final PluginManager pM = this.getPluginManager();
		final Logger log1 = this.getLogger();
		// Load Config files
		// Main Config
		this.getConfig();
		this.saveConfig();
		// Regions Config
		regions = this.getServer().getConfigurationManager()
				.load(this, Regions.class);
		this.getServer().getConfigurationManager().save(this, regions);
		// Members Config
		members = this.getServer().getConfigurationManager()
				.load(this, RegionMembers.class);
		this.getServer().getConfigurationManager().save(this, members);
		// Flags Config
		flags = this.getServer().getConfigurationManager()
				.load(this, RegionFlags.class);
		this.getServer().getConfigurationManager().save(this, flags);
		// Config check
		final int memSize = members.getMembers().size();
		final int regSize = regions.getRegions().size();
		final int flgSize = flags.getFlags().size();
		// Compare if the Config files' ArrayLists sizes are equal
		if (memSize != regSize || regSize != flgSize) {
			log1.warning(BlockGuardPlugin.stamp
						+ "There is an error in the config files!");
			// Something is wrong
			if (memSize == regSize && regSize != flgSize) {
				// Fix flags
				log1.info(BlockGuardPlugin.stamp
						+ "Attempting to fix the Flags config!");
				for (int x = 0; x < (regSize - flgSize); x++) {
					this.flags.setFlags(new Flags(this.<Config> getConfig()
							.getDefaultBooleans()));
				}
			} else {
				// Plugin will NOT load
				log1.warning(BlockGuardPlugin.stamp
						+ "BlockGuard will not be loaded, until this issue has been resolved.");
				return;
			}
		}
		// A (useless) message for the amount of regions
		log1.info(BlockGuardPlugin.stamp + regions.getRegions().size()
				+ " region(s) loaded!");
		// Register Handlers
		// Block-handler
		pM.registerEventHandler(new BlockListeners(regions, members, flags));
		// PlayerHealth-handler
		pM.registerEventHandler(new PlayerHealthListeners(regions, members,
				flags));
		// Interaction-handler
		pM.registerEventHandler(new InterActionListeners(regions, members,
				flags));
		pM.registerEventHandler(new ChatListener(this));
		pM.registerEventHandler(new CommandListener(regions, members, flags));
		pM.registerEventHandler(new PositionListeners(regions, members, flags));
		pM.registerEventHandler(new NPCListeners(regions, members, flags));
		pM.registerEventHandler(new PlayerInventoryListeners(regions, members,
				flags));
		pM.registerEventHandler(new SignListener(regions, members, flags));
		pM.registerEventHandler(new TNTListener(regions, flags));
		pM.registerEventHandler(new WorldGrowthListeners(regions, members,
				flags));
		// Movement-handler (only when enabled in config)
		if (this.<Config> getConfig().isEnableMovementTracker()) {
			pM.registerEventHandler(new MovementListener(regions));
		}
		// Check if MBWorldEdit exists
		try {
			Class.forName("com.ikkerens.worldedit.WorldEditPlugin");
			hasWE = true;
		} catch (final ClassNotFoundException e) {
			// hadWE is false by default, so nothing goes here
		}
		// Register MBWorldEdit Handlers/Command if the plugin is installed
		if (hasWE) {
			log1.info(BlockGuardPlugin.stamp + "MBWorldEdit found!");
			log1.info(BlockGuardPlugin.stamp + "Added support for MBWorldEdit!");
			// Register BlockPlaces/BlockBreaks/Command
			pM.registerEventHandler(new WandListener(this));
			// Register ServerStarted to get Wand ID blocks
			pM.registerEventHandler(new ServerStartedListener(this));
			// Register WorldEdit Wand Command
			pM.registerCommand("blockguardwand", new String[] { "bgwand" },
					new Wand(this));
		}
		// Register Important Main Commands
		pM.registerCommand("blockguard", new String[] { "bg" },
				new Information());
		pM.registerCommand("blockguardposition1", new String[] { "bgpos1",
				"blockguardposition2", "bgpos2" }, new Position());
		pM.registerCommand("blockguardselectioninformation", new String[] {
				"blockguardselectioninfo", "bgselectioninformation",
				"bgselectioninfo", "bgsi" }, new SelectionInfo(this));
		pM.registerCommand("blockguardcoordinates", new String[] {
				"blockguardcoords", "bgcoordinates", "bgcoords" },
				new Coordinates(this));
		// Register Important Action Commands
		pM.registerCommand("blockguardregionaction", new String[] { "bgra" },
				new RegionAction(this));
		// Register Unimportant Action Commands
		pM.registerCommand("blockguardflagaction", new String[] { "bgfa" },
				new FlagAction(this.getServer()));
		pM.registerCommand("blockguardmemberaction", new String[] { "bgma" },
				new MemberAction());
		// Register Unimportant Commands
		pM.registerCommand("blockguardset", new String[] { "bgset" },
				new SetRegion());
		pM.registerCommand("blockguardremoveregion", new String[] {
				"bgremoveregion", "bgremregion" },
				new RemoveRegion(this.getServer()));
		pM.registerCommand("blockguardregionlist", new String[] {
				"bgregionlist", "bgrl" }, new RegionList(this));
		pM.registerCommand("blockguardteleport", new String[] { "bgtp",
				"bgteleport", "blockguardtp" }, new Teleport(this.getServer()));
	}

	/**
	 * Check if the server has MBWorldEdit installed.
	 * 
	 * @return True, if installed. False, if not installed.
	 */
	public boolean hasMBWorldEditPlugin() {
		return hasWE;
	}

	/**
	 * A method to get the ID of the first Wand block.
	 * 
	 * @return -1, if there is no MBWorldEdit installed on this server. An other
	 *         integer, if MBWorldEdit is installed. (Integer is set AFTER the
	 *         ServerStartedEvent)
	 */
	public int getWandPos1Id() {
		return wandPos1Id;
	}

	/**
	 * A method to get the ID of the second Wand block.
	 * 
	 * @return -1, if there is no MBWorldEdit installed on this server. An other
	 *         integer, if MBWorldEdit is installed. (Integer is set AFTER the
	 *         ServerStartedEvent)
	 */
	public int getWandPos2Id() {
		return wandPos2Id;
	}

	/**
	 * Used by BlockGuard itself.
	 * 
	 * @param wandPos2Id
	 *            The first Wand ID of MBWorldEdit
	 */
	public void setWandPos1Id(int wandPos1Id) {
		this.wandPos1Id = wandPos1Id;
	}

	/**
	 * Used by BlockGuard itself.
	 * 
	 * @param wandPos2Id
	 *            The second Wand ID of MBWorldEdit
	 */
	public void setWandPos2Id(int wandPos2Id) {
		this.wandPos2Id = wandPos2Id;
	}

	/**
	 * A method to get the regions config
	 * 
	 * @return Config of regions.
	 */
	public Regions getRegions() {
		return regions;
	}

	/**
	 * A method to get the members config
	 * 
	 * @return Config of members.
	 */
	public RegionMembers getMembers() {
		return members;
	}

	/**
	 * A method to get the flags config
	 * 
	 * @return Config of flags.
	 */
	public RegionFlags getFlags() {
		return flags;
	}

	/**
	 * Save every config(JSON)
	 */
	public void saveConfigs() {
		this.saveConfig();
		// Regions Config
		regions = this.getServer().getConfigurationManager()
				.load(this, Regions.class);
		this.getServer().getConfigurationManager().save(this, regions);
		// Members Config
		members = this.getServer().getConfigurationManager()
				.load(this, RegionMembers.class);
		this.getServer().getConfigurationManager().save(this, members);
		// Flags Config
		flags = this.getServer().getConfigurationManager()
				.load(this, RegionFlags.class);
		this.getServer().getConfigurationManager().save(this, flags);
	}

	// Actions when the server disables this plugin
	/**
	 * OnDisable method
	 */
	@Override
	public void onDisable() {
		final Server s1 = this.getServer();
		// Some (useless) messages
		s1.getLogger().info(BlockGuardPlugin.stamp + "Saving region(s)...");
		s1.getLogger().info(
				BlockGuardPlugin.stamp + "Finished saving "
						+ regions.getRegions().size() + " region(s)...");
		// Saving all regions (should have been saved already)
		// Config
		this.saveConfig();
		// Regions
		this.getServer().getConfigurationManager().save(this, regions);
		// Members
		this.getServer().getConfigurationManager().save(this, members);
		// Flags
		this.getServer().getConfigurationManager().save(this, flags);
		// Finalize
		this.plugin = null;
	}

	/**
	 * The BlockGuardPlugin instance
	 * 
	 * @return The BlockGuardPlugin instance
	 */
	public BlockGuardPlugin getPlugin() {
		return plugin;
	}

}
