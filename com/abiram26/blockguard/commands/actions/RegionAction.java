package com.abiram26.blockguard.commands.actions;

import java.util.Arrays;

import com.abiram26.blockguard.BlockGuardPlugin;
import com.abiram26.blockguard.model.Cuboid;
import com.abiram26.blockguard.model.Flags;
import com.abiram26.blockguard.model.Members;
import com.abiram26.blockguard.storage.Config;
import com.abiram26.blockguard.storage.RegionFlags;
import com.abiram26.blockguard.storage.RegionMembers;
import com.abiram26.blockguard.storage.Regions;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;
import com.mbserver.api.dynamic.ChatColor;
import com.mbserver.api.game.Player;

public class RegionAction implements CommandExecutor {

	/**
	 * args[0] = action
	 * 
	 * <regions> = 1 arg - /bgra regions
	 * 
	 * <get> = 2 args - /bgra get <regionname>
	 * 
	 * <set> = 2 args -> max args - /bgra set <regionname> <name> <name> <name>
	 * 
	 * <rem> = 2 args - /bgra rem <regionname>
	 * 
	 * <remove> = 2 args - /bgra remove <regionname>
	 * 
	 * <rename> = 3 args - /bgra rename <regionnameOLD> <regionnameNEW>
	 * 
	 * <teleport> = 2 args -> 3 args - /bgra teleport <regionname> <name>
	 * 
	 * <tp> 2 args -> 3 args - /bgra tp <regionname> <name>
	 * 
	 * <members> = 2 args - /bgra members <regionname>
	 * 
	 * <addmember> = 3 args - /bgra addmember <regionname> <name>
	 * 
	 * <removemember> = 3 args - /bgra removemember <regionname> <name>
	 * 
	 * <remmember> = 3 args - /bgra remmember <regionname> <name>
	 * 
	 * <flags> = 2 args - /bgra flags <regionname>
	 * 
	 * <getflag> = 3 args - /bgra getflag <regionname> <flag>
	 * 
	 * <setflag> = 4 args - /bgra setflag <regionname> <flag> <boolean>
	 * 
	 * args[1] = regionname
	 * 
	 * args[2] = membername / flagname (optional)
	 * 
	 * args[3] = membername / flagboolean(optional)
	 */

	private final BlockGuardPlugin p1;
	private final Config cfg1;
	private final Regions cfg2;
	private final RegionMembers cfg3;
	private final RegionFlags cfg4;

	public RegionAction(final BlockGuardPlugin plugin) {
		p1 = plugin;
		cfg1 = p1.<Config> getConfig();
		cfg2 = p1.getRegions();
		cfg3 = p1.getMembers();
		cfg4 = p1.getFlags();
	}

	@Override
	public void execute(final String command, final CommandSender sender,
			final String[] args, final String label) {
		// Check if amount of args are okay
		if (args.length < 1) {
			sender.sendMessage(BlockGuardPlugin.stamp
					+ "No arguments were given!");
			return;
		}

		if (args.length < 2 && !args[0].equalsIgnoreCase("regions")) {
			sender.sendMessage(BlockGuardPlugin.stamp
					+ "Not enough arguments were given!");
			return;
		}

		// Check if the first argument is correct
		if (!args[0].equalsIgnoreCase("set")
				&& !args[0].equalsIgnoreCase("regions")
				&& !args[0].equalsIgnoreCase("get")
				&& !args[0].equalsIgnoreCase("members")
				&& !args[0].equalsIgnoreCase("addmember")
				&& !args[0].equalsIgnoreCase("removemember")
				&& !args[0].equalsIgnoreCase("remmember")
				&& !args[0].equalsIgnoreCase("flags")
				&& !args[0].equalsIgnoreCase("teleport")
				&& !args[0].equalsIgnoreCase("tp")
				&& !args[0].equalsIgnoreCase("remove")
				&& !args[0].equalsIgnoreCase("rem")
				&& !args[0].equalsIgnoreCase("rename")
				&& !args[0].equalsIgnoreCase("getflag")
				&& !args[0].equalsIgnoreCase("setflag")) {
			sender.sendMessage(BlockGuardPlugin.stamp
					+ "The first argument is invalid: No such action!");
			return;
		}
		// Check if the second argument is correct
		final int regionId;
		if (!args[0].equalsIgnoreCase("regions")) {
			regionId = cfg2.getRegion(args[1]);
		} else {
			regionId = -1;
		}

		if (regionId == -1 && !args[0].equalsIgnoreCase("set")
				&& !args[0].equalsIgnoreCase("regions")) {
			sender.sendMessage(BlockGuardPlugin.stamp
					+ "The second argument is invalid: no such region ("
					+ args[1] + ")");
			return;
		}

		// Check if the second argument is correct with /bgra set
		if (args[0].equalsIgnoreCase("set") && regionId != -1) {
			sender.sendMessage(BlockGuardPlugin.stamp
					+ "The second argument is invalid: region is taken ("
					+ args[1] + ")");
			return;
		}

		// Check if the player if a member if the region
		final int isMemberHimself;
		if (!args[0].equalsIgnoreCase("set")
				&& !args[0].equalsIgnoreCase("regions")) {

			isMemberHimself = cfg3.getMembers().get(regionId)
					.hasMember(sender.getName());
		} else {
			isMemberHimself = -1;
		}

		// Check if the player has the membership permission or if it has every
		// permission
		boolean hasPerms = sender.hasPermission("abiram26.blockguard.*")
				|| isMemberHimself != -1;

		// Check individual perms
		if (!hasPerms) {
			if ((args[0].equalsIgnoreCase("set") && (sender
					.hasPermission("abiram26.blockguard.setregion") || sender
					.hasPermission("abiram26.blockguard.setregion.limited")))
					|| (args[0].equalsIgnoreCase("regions") && sender
							.hasPermission("abiram26.blockguard.getregions"))
					|| (args[0].equalsIgnoreCase("get") && sender
							.hasPermission("abiram26.blockguard.getregion"))
					|| (args[0].equalsIgnoreCase("members") && sender
							.hasPermission("abiram26.blockguard.getmembers"))
					|| (args[0].equalsIgnoreCase("addmember") && sender
							.hasPermission("abiram26.blockguard.addmember"))
					|| (args[0].equalsIgnoreCase("removemember") && sender
							.hasPermission("abiram26.blockguard.removemember"))
					|| (args[0].equalsIgnoreCase("remmember") && sender
							.hasPermission("abiram26.blockguard.removemember"))
					|| (args[0].equalsIgnoreCase("flags") && sender
							.hasPermission("abiram26.blockguard.getflags"))
					|| (args[0].equalsIgnoreCase("teleport") && (sender
							.hasPermission("abiram26.blockguard.teleport") || sender
							.hasPermission("abiram26.blockguard.teleport.other")))
					|| (args[0].equalsIgnoreCase("tp") && (sender
							.hasPermission("abiram26.blockguard.teleport") || sender
							.hasPermission("abiram26.blockguard.teleport.other")))
					|| (args[0].equalsIgnoreCase("remove") && sender
							.hasPermission("abiram26.blockguard.removeregion"))
					|| (args[0].equalsIgnoreCase("rem") && sender
							.hasPermission("abiram26.blockguard.removeregion"))
					|| (args[0].equalsIgnoreCase("rename") && sender
							.hasPermission("abiram26.blockguard.renameregion"))
					|| (args[0].equalsIgnoreCase("getflag") && sender
							.hasPermission("abiram26.blockguard.getflag"))
					|| (args[0].equalsIgnoreCase("setflag") && sender
							.hasPermission("abiram26.blockguard.setflag"))) {
				hasPerms = true;
			}
		}

		if (!hasPerms) {
			if (isMemberHimself == -1) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "You are not a member of region " + args[1] + "!");
				return;
			}
			sender.sendMessage(BlockGuardPlugin.stamp
					+ "You do not have permission to use this command!");
			return;
		}

		// Check if the third argument is correct
		if (args.length > 2) {
			if ((args[1].equalsIgnoreCase("getflag") || args[1]
					.equalsIgnoreCase("setflag"))) {
				if (!cfg4.getFlags().get(regionId).isValidFlag(args[3])) {
					sender.sendMessage(BlockGuardPlugin.stamp
							+ "The third argument is invalid: no such flag!");
					return;
				}
			}

			// Check if the third argument is correct when using remove member

			if (args[1].equalsIgnoreCase("remmember")
					|| args[1].equalsIgnoreCase("removemember")) {
				if (cfg3.getMembers().get(regionId).hasMember(args[2]) == -1) {
					sender.sendMessage(BlockGuardPlugin.stamp
							+ "The third argument is invalid: the region does not have this member!");
					return;
				}
			}

			if (args[0].equalsIgnoreCase("rename")) {
				final int newRegionId;
				newRegionId = cfg2.getRegion(args[2]);
				if (newRegionId != -1) {
					sender.sendMessage(BlockGuardPlugin.stamp
							+ "The third argument is invalid: there already is a region with this name!");
				}
			}
		}

		// Check if the fourth argument is correct
		if (args.length > 3) {
			if (args[1].equalsIgnoreCase("setflag")) {
				if (!args[3].equalsIgnoreCase("true")
						&& args[3].equalsIgnoreCase("false")) {
					sender.sendMessage(BlockGuardPlugin.stamp
							+ "The fourth argument is invalid: invalid boolean!");
					return;
				}
			}
		}
		// Checking which sub-command to execute
		if (args[0].equalsIgnoreCase("set")) {
			// if args = 2, then commandsender = owner
			// else args[2] = owner and args[3->] = member
			if (!(sender instanceof Player)) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "This command should be executed as a player!");
				return;
			}

			if (args.length == 1) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "Not enough arguments were given!");
				return;
			}

			final Player pl = (Player) sender;
			if (!pl.hasPermission("abiram26.blockguard.*")) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "You do not have permission to use this command!");
				return;
			}
			final int x1, x2, y1, y2, z1, z2;

			// Check if positions are set
			if (pl.<Integer> getMetaData("BlockGuardY2", -1) != -1
					&& pl.<Integer> getMetaData("BlockGuardY1", -1) != -1) {
				// Positions are not null
				if (cfg1.isAutomaticRectangularCuboids()) {
					y1 = 0;
					y2 = 128;
				} else {
					y1 = Math.min(
							pl.<Integer> getMetaData("BlockGuardY1", null),
							pl.<Integer> getMetaData("BlockGuardY2", null));

					y2 = Math.max(
							pl.<Integer> getMetaData("BlockGuardY1", null),
							pl.<Integer> getMetaData("BlockGuardY2", null))
							- y1 + 1;
				}
				x1 = Math.min(pl.<Integer> getMetaData("BlockGuardX1", null),
						pl.<Integer> getMetaData("BlockGuardX2", null));
				x2 = Math.max(pl.<Integer> getMetaData("BlockGuardX1", null),
						pl.<Integer> getMetaData("BlockGuardX2", null))
						- x1
						+ 1;
				z1 = Math.min(pl.<Integer> getMetaData("BlockGuardZ1", null),
						pl.<Integer> getMetaData("BlockGuardZ2", null));
				z2 = Math.max(pl.<Integer> getMetaData("BlockGuardZ1", null),
						pl.<Integer> getMetaData("BlockGuardZ2", null))
						- z1
						+ 1;
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
							if (sender
									.hasPermission("abiram26.blockguard.setregion.limited")
									&& !sender
											.hasPermission("abiram26.blockguard.setregion")
									&& !sender
											.hasPermission("abiram26.blockguard.*")) {
								// 3 Checks
								// - Check amount of regions
								// - Check volume
								// - Check minimumlength
								int amount = 0;
								for (Members m1 : cfg3.getMembers()) {
									if (m1.getMemberList()
											.get(0)
											.equalsIgnoreCase(
													pl.getDisplayName())) {
										amount++;
									}
								}
								if (amount > cfg1
										.getBlockGuardLimitedRegionMaximum()) {
									sender.sendMessage(BlockGuardPlugin.stamp
											+ "You cannot make new BlockGuard protected regions!");
									return;
								}

								final int volume = x2 * y2 * z2;
								if (volume > cfg1
										.getBlockGuardLimitedVolumeMaximum()) {
									sender.sendMessage(BlockGuardPlugin.stamp
											+ "The selection contains too many blocks! Please make the selection smaller!");
									return;

								}

								if (x2 < cfg1
										.getBlockGuardLimitedLengthMinimum()) {
									sender.sendMessage(BlockGuardPlugin.stamp
											+ "One of the lengths of your selection is too small (X-axis side)!");
									return;
								}
								if (y2 < cfg1
										.getBlockGuardLimitedLengthMinimum()) {
									sender.sendMessage(BlockGuardPlugin.stamp
											+ "One of the lengths of your selection is too small (Y-axis side)!");
									return;
								}
								if (z2 < cfg1
										.getBlockGuardLimitedLengthMinimum()) {
									sender.sendMessage(BlockGuardPlugin.stamp
											+ "One of the lengths of your selection is too small (Z-axis side)!");
									return;
								}

							}
							if (cfg1.isAutomaticOverlapCheck()) {
								this.p1.getServer().executeCommand(sender,
										"bgsi", new String[0]);
								final float percentage = pl.getMetaData(
										"BlockGuardOverlapPercentage", 0.0f);
								if (percentage >= cfg1
										.getOverlapMaximumPercentage()) {
									sender.sendMessage(BlockGuardPlugin.stamp
											+ "The selection overlapped a region with "
											+ percentage
											+ "%, while it may only overlap with "
											+ cfg1.getOverlapMaximumPercentage()
											+ "%!");
									return;
								}
							}

							// Add a new memberlist for that region
							if (args.length == 2) {
								cfg3.setMembers(new Members(pl.getName()));
							} else if (args.length == 3) {
								cfg3.setMembers(new Members(args[2]));
							} else {
								final Members m1 = new Members(args[2]);
								for (int c = 3; c < args.length; c++) {
									m1.addMember(args[c]);
								}
								cfg3.setMembers(m1);
							}
							final String regionName;
							// Add a new region
							if (cfg1.isAutoRegionOwnerTag()) {
								final String latestOwner = cfg3.getMembers()
										.get(cfg3.getMembers().size() - 1)
										.getMemberList().get(0);
								regionName = latestOwner + "-" + args[1];
								int newRegionId = cfg2.getRegion(regionName);
								if (newRegionId != -1) {
									pl.sendMessage(BlockGuardPlugin.stamp
											+ "There already is a region with this name!");
									// Remove the newly created memberlist
									cfg3.getMembers().remove(
											cfg3.getMembers().size() - 1);
									// Save memberlist
									this.p1.getServer()
											.getConfigurationManager()
											.save(this.p1, cfg3);
									return;
								}
								cfg2.setRegion(new Cuboid(x1, y1, z1, x2, y2,
										z2, regionName, pl.getLocation()
												.getWorld().getWorldName()));
							} else {
								regionName = args[1];
								cfg2.setRegion(new Cuboid(x1, y1, z1, x2, y2,
										z2, regionName, pl.getLocation()
												.getWorld().getWorldName()));
							}
							// Create array of flags
							
							// Add a new flaggroup
							cfg4.setFlags(new Flags(cfg1.getDefaultBooleans()));

							// Save the config
							this.p1.getServer().getConfigurationManager()
									.save(this.p1, cfg2);
							this.p1.getServer().getConfigurationManager()
									.save(this.p1, cfg3);
							this.p1.getServer().getConfigurationManager()
									.save(this.p1, cfg4);
							// A success-message for the player
							pl.sendMessage(BlockGuardPlugin.stamp
									+ "BlockGuarded " + regionName + "!");
							pl.sendMessage(ChatColor.WHITE
									+ "Coordinates: ["
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
									+ " in world: "
									+ pl.getLocation().getWorld()
											.getWorldName() + "]");
							pl.sendMessage(ChatColor.WHITE
									+ "Members: "
									+ Arrays.toString(cfg3.getMembers()
											.get(cfg3.getMembers().size() - 1)
											.getMemberList().toArray()));
							pl.sendMessage(ChatColor.WHITE
									+ "Flags: [Default flags]");
						} else {
							// Z Positions are the same
							sender.sendMessage(BlockGuardPlugin.stamp
									+ "Not guarded: Identical Z positions.");
						}
					} else {
						// Y Positions are the same
						sender.sendMessage(BlockGuardPlugin.stamp
								+ "Not guarded: Identical Y positions.");
					}
				} else {
					// X Positions are the same
					sender.sendMessage(BlockGuardPlugin.stamp
							+ "Not guarded: Identical X positions.");
				}
			} else {
				// Positions are null
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "Not guarded: No points are set.");
			}
			return;
		} else if (args[0].equalsIgnoreCase("regions")) {

			if (args.length > 1) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "Too many arguments were given!");
				return;
			}

			final int amountOfRegions = cfg2.getRegions().size();
			sender.sendMessage(BlockGuardPlugin.stamp + "All regions ("
					+ amountOfRegions + ")");
			if (amountOfRegions == 0) {
				sender.sendMessage("There are currently no BlockGuard regions");
			} else {
				for (int x = 0; x < cfg2.getRegions().size(); x++) {
					sender.sendMessage("Region "
							+ cfg2.getRegions().get(x).getRegionName()
							+ " with owner "
							+ cfg3.getMembers().get(x).getMemberList().get(0));

				}
			}
			return;
		} else if (args[0].equalsIgnoreCase("get")) {

			if (args.length > 2) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "Too many arguments were given!");
				return;
			}
			if (args.length == 1) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "Not enough arguments were given!");
				return;

			}

			Cuboid r1 = cfg2.getRegions().get(regionId);
			Members m1 = cfg3.getMembers().get(regionId);
			Flags f1 = cfg4.getFlags().get(regionId);

			sender.sendMessage(BlockGuardPlugin.stamp
					+ "All details of region " + args[1]);
			sender.sendMessage("Region details: ");
			sender.sendMessage("- Region's name: " + args[1]);
			sender.sendMessage("- Region's world: " + r1.getWorldName());
			sender.sendMessage("- Region's X-coordinate: " + r1.getX());
			sender.sendMessage("- Region's Y-coordinate: " + r1.getY());
			sender.sendMessage("- Region's Z-coordinate: " + r1.getZ());
			sender.sendMessage("- Region's delta X: " + r1.getdX());
			sender.sendMessage("- Region's delta Y: " + r1.getdY());
			sender.sendMessage("- Region's delta Z: " + r1.getdZ());
			sender.sendMessage("Region members: ");
			sender.sendMessage("- Region's owner: " + m1.getMemberList().get(0));
			for (int c = 1; c < m1.getMemberList().size(); c++) {
				sender.sendMessage("- Region's member: "
						+ m1.getMemberList().get(c));
			}
			sender.sendMessage("Region flags: ");
			sender.sendMessage("- Region's can_player_break_block flag: " + 
				 f1.isCan_player_break_block());
			 sender.sendMessage("- Region's can_player_place_block flag: " + 
				 f1.isCan_player_place_block());
			 sender.sendMessage("- Region's can_player_interact_bed flag: " + 
				 f1.isCan_player_interact_bed());
			 sender.sendMessage("- Region's can_player_interact_electronic flag: " + 
				 f1.isCan_player_interact_electronic());
			 sender.sendMessage("- Region's can_player_interact_chest flag: " + 
				 f1.isCan_player_interact_chest());
			 sender.sendMessage("- Region's can_player_interact_tnt flag: " + 
				 f1.isCan_player_interact_TNT());
			 sender.sendMessage("- Region's can_player_interact_trashcan flag: " + 
				 f1.isCan_player_interact_trashcan());
			 sender.sendMessage("- Region's can_player_interact_paintbucket flag: " + 
				 f1.isCan_player_interact_paintbucket());
			 sender.sendMessage("- Region's can_player_interact_canvas flag: " + 
				 f1.isCan_player_interact_canvas());
			 sender.sendMessage("- Region's can_player_interact_elevator flag: " + 
				 f1.isCan_player_interact_elevator());
			 sender.sendMessage("- Region's can_player_open_chest flag: " + 
				 f1.isCan_player_open_chest());
			 sender.sendMessage("- Region's can_player_execute_command flag: " + 
				 f1.isCan_player_execute_command());
			 sender.sendMessage("- Region's can_player_attack_player flag: " + 
				 f1.isCan_player_attack_player());
			 sender.sendMessage("- Region's can_player_attack_npc flag: " + 
				 f1.isCan_player_attack_NPC());
			 sender.sendMessage("- Region's can_player_pickup_item flag: " + 
				 f1.isCan_player_pickup_item());
			 sender.sendMessage("- Region's can_player_drop_item flag: " + 
				 f1.isCan_player_drop_item());
			 sender.sendMessage("- Region's can_player_die flag: " + 
				 f1.isCan_player_die());
			 sender.sendMessage("- Region's can_player_heal flag: " + 
				 f1.isCan_player_heal());
			 sender.sendMessage("- Region's can_player_receive_damage flag: " + 
				 f1.isCan_player_receive_damage());
			 sender.sendMessage("- Region's can_player_teleport flag: " + 
				 f1.isCan_player_teleport());
			 sender.sendMessage("- Region's can_player_chat_public flag: " + 
				 f1.isCan_player_chat_public());
			 sender.sendMessage("- Region's can_player_chat flag: " + 
				 f1.isCan_player_chat());
			 sender.sendMessage("- Region's can_player_wield flag: " + 
				 f1.isCan_player_wield());
			 sender.sendMessage("- Region's can_player_unwield flag: " + 
				 f1.isCan_player_unwield());
			 sender.sendMessage("- Region's can_player_setspawn flag: " + 
				 f1.isCan_player_setspawn());
			 sender.sendMessage("- Region's can_player_text_sign flag: " + 
				 f1.isCan_player_text_sign());
			 sender.sendMessage("- Region's can_npc_move flag: " + 
				 f1.isCan_NPC_move());
			 sender.sendMessage("- Region's can_npc_attack_player flag: " + 
				 f1.isCan_NPC_attack_player());
			 sender.sendMessage("- Region's can_npc_attack_npc flag: " + 
				 f1.isCan_NPC_attack_NPC());
			 sender.sendMessage("- Region's can_npc_die flag: " + 
				 f1.isCan_NPC_die());
			 sender.sendMessage("- Region's can_npc_heal flag: " + 
				 f1.isCan_NPC_heal());
			 sender.sendMessage("- Region's can_npc_receive_damage flag: " + 
				 f1.isCan_NPC_receive_damage());
			 sender.sendMessage("- Region's can_npc_spawn flag: " + 
				 f1.isCan_NPC_spawn());
			 sender.sendMessage("- Region's can_npc_interact flag: " + 
				 f1.isCan_NPC_interact());
			 sender.sendMessage("- Region's can_grass_grow flag: " + 
				 f1.isCan_grass_grow());
			 sender.sendMessage("- Region's can_plant_grow flag: " + 
				 f1.isCan_plant_grow());
			 sender.sendMessage("- Region's can_tree_grow flag: " + 
				 f1.isCan_tree_grow());
			 sender.sendMessage("- Region's can_tnt_explode flag: " + 
				 f1.isCan_TNT_explode());
			 sender.sendMessage("- Region's can_block_gravitate flag: " + 
				 f1.isCan_block_gravitate());
			 sender.sendMessage("- Region's can_block_decay flag: " + 
				 f1.isCan_block_decay());
			 sender.sendMessage("- Region's can_player_place_block flag: " + 
					 f1.isCan_player_interact_door());
			return;
			
		} else if (args[0].equalsIgnoreCase("members")) {
			if (args.length > 2) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "Too many arguments were given!");
				return;
			}
			if (args.length == 1) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "Not enough arguments were given!");
				return;

			}
			final Members m1 = cfg3.getMembers().get(regionId);

			sender.sendMessage(BlockGuardPlugin.stamp + "All region members: ");
			sender.sendMessage("- Region's owner: " + m1.getMemberList().get(0));
			for (int c = 1; c < m1.getMemberList().size(); c++) {
				sender.sendMessage("- Region's member: "
						+ m1.getMemberList().get(c));
			}
			return;
		} else if (args[0].equalsIgnoreCase("addmember")) {
			// check if the argument name already is a member
			// else add
			if (args.length > 3) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "Too many arguments were given!");
				return;
			}
			if (args.length < 3) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "Not enough arguments were given!");
				return;

			}
			if (cfg3.getMembers().get(regionId).hasMember(args[2]) != -1) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "The region already has this member!");

			} else {
				cfg3.getMembers().get(regionId).addMember(args[2]);
				sender.sendMessage(BlockGuardPlugin.stamp + "Added member "
						+ args[2] + " to region " + args[1] + "!");
				// Save the config
				this.p1.getServer().getConfigurationManager()
						.save(this.p1, cfg3);
			}
			return;
		} else if (args[0].equalsIgnoreCase("removemember")
				|| args[0].equalsIgnoreCase("remmember")) {
			// check if the argument name already is not a member & not the last
			// member
			// else add
			if (args.length > 3) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "Too many arguments were given!");
				return;
			}
			if (args.length < 2) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "Not enough arguments were given!");
				return;

			}

			final int memberId = cfg3.getMembers().get(regionId)
					.hasMember(args[2]);
			if (memberId == -1) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "The region does not have this member!");
				return;
			}
			if (cfg3.getMembers().get(regionId).getMemberList().size() == 1) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "The region must have at least one member!");
				return;
			}
			cfg3.getMembers().get(regionId).getMemberList().remove(memberId);
			sender.sendMessage(BlockGuardPlugin.stamp + "Removed member "
					+ args[2] + " from region " + args[1] + "!");
			// Save the config
			this.p1.getServer().getConfigurationManager().save(this.p1, cfg3);

			return;
		} else if (args[0].equalsIgnoreCase("flags")) {

			if (args.length > 2) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "Too many arguments were given!");
				return;
			}
			if (args.length == 1) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "Not enough arguments were given!");
				return;

			}
			final Flags f1 = cfg4.getFlags().get(regionId);
			sender.sendMessage(BlockGuardPlugin.stamp + "All region flags: ");
			sender.sendMessage("- Region's can_player_break_block flag: " + 
					 f1.isCan_player_break_block());
				 sender.sendMessage("- Region's can_player_place_block flag: " + 
					 f1.isCan_player_place_block());
				 sender.sendMessage("- Region's can_player_interact_bed flag: " + 
					 f1.isCan_player_interact_bed());
				 sender.sendMessage("- Region's can_player_interact_electronic flag: " + 
					 f1.isCan_player_interact_electronic());
				 sender.sendMessage("- Region's can_player_interact_chest flag: " + 
					 f1.isCan_player_interact_chest());
				 sender.sendMessage("- Region's can_player_interact_tnt flag: " + 
					 f1.isCan_player_interact_TNT());
				 sender.sendMessage("- Region's can_player_interact_trashcan flag: " + 
					 f1.isCan_player_interact_trashcan());
				 sender.sendMessage("- Region's can_player_interact_paintbucket flag: " + 
					 f1.isCan_player_interact_paintbucket());
				 sender.sendMessage("- Region's can_player_interact_canvas flag: " + 
					 f1.isCan_player_interact_canvas());
				 sender.sendMessage("- Region's can_player_interact_elevator flag: " + 
					 f1.isCan_player_interact_elevator());
				 sender.sendMessage("- Region's can_player_open_chest flag: " + 
					 f1.isCan_player_open_chest());
				 sender.sendMessage("- Region's can_player_execute_command flag: " + 
					 f1.isCan_player_execute_command());
				 sender.sendMessage("- Region's can_player_attack_player flag: " + 
					 f1.isCan_player_attack_player());
				 sender.sendMessage("- Region's can_player_attack_npc flag: " + 
					 f1.isCan_player_attack_NPC());
				 sender.sendMessage("- Region's can_player_pickup_item flag: " + 
					 f1.isCan_player_pickup_item());
				 sender.sendMessage("- Region's can_player_drop_item flag: " + 
					 f1.isCan_player_drop_item());
				 sender.sendMessage("- Region's can_player_die flag: " + 
					 f1.isCan_player_die());
				 sender.sendMessage("- Region's can_player_heal flag: " + 
					 f1.isCan_player_heal());
				 sender.sendMessage("- Region's can_player_receive_damage flag: " + 
					 f1.isCan_player_receive_damage());
				 sender.sendMessage("- Region's can_player_teleport flag: " + 
					 f1.isCan_player_teleport());
				 sender.sendMessage("- Region's can_player_chat_public flag: " + 
					 f1.isCan_player_chat_public());
				 sender.sendMessage("- Region's can_player_chat flag: " + 
					 f1.isCan_player_chat());
				 sender.sendMessage("- Region's can_player_wield flag: " + 
					 f1.isCan_player_wield());
				 sender.sendMessage("- Region's can_player_unwield flag: " + 
					 f1.isCan_player_unwield());
				 sender.sendMessage("- Region's can_player_setspawn flag: " + 
					 f1.isCan_player_setspawn());
				 sender.sendMessage("- Region's can_player_text_sign flag: " + 
					 f1.isCan_player_text_sign());
				 sender.sendMessage("- Region's can_npc_move flag: " + 
					 f1.isCan_NPC_move());
				 sender.sendMessage("- Region's can_npc_attack_player flag: " + 
					 f1.isCan_NPC_attack_player());
				 sender.sendMessage("- Region's can_npc_attack_npc flag: " + 
					 f1.isCan_NPC_attack_NPC());
				 sender.sendMessage("- Region's can_npc_die flag: " + 
					 f1.isCan_NPC_die());
				 sender.sendMessage("- Region's can_npc_heal flag: " + 
					 f1.isCan_NPC_heal());
				 sender.sendMessage("- Region's can_npc_receive_damage flag: " + 
					 f1.isCan_NPC_receive_damage());
				 sender.sendMessage("- Region's can_npc_spawn flag: " + 
					 f1.isCan_NPC_spawn());
				 sender.sendMessage("- Region's can_npc_interact flag: " + 
					 f1.isCan_NPC_interact());
				 sender.sendMessage("- Region's can_grass_grow flag: " + 
					 f1.isCan_grass_grow());
				 sender.sendMessage("- Region's can_plant_grow flag: " + 
					 f1.isCan_plant_grow());
				 sender.sendMessage("- Region's can_tree_grow flag: " + 
					 f1.isCan_tree_grow());
				 sender.sendMessage("- Region's can_tnt_explode flag: " + 
					 f1.isCan_TNT_explode());
				 sender.sendMessage("- Region's can_block_gravitate flag: " + 
					 f1.isCan_block_gravitate());
				 sender.sendMessage("- Region's can_block_decay flag: " + 
					 f1.isCan_block_decay());
				 sender.sendMessage("- Region's can_player_place_block flag: " + 
						 f1.isCan_player_interact_door());
			return;
		} else if (args[0].equalsIgnoreCase("teleport")
				|| args[0].equalsIgnoreCase("tp")) {

			if (args.length > 3) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "Too many arguments were given!");
				return;
			}
			if (args.length == 1) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "Not enough arguments were given!");
				return;

			}
			final Cuboid c1 = cfg2.getRegions().get(regionId);
			final int avgX = (int) (c1.getX() + 0.5 * c1.getdX());
			int topY = c1.getY() + c1.getdY();
			final int avgZ = (int) (c1.getZ() + 0.5 * c1.getdZ());

			if (topY > 125) {
				topY = 125;
			}

			if (args.length == 3) {
				Player target = this.p1.getServer().getPlayer(args[2]);
				if (target == null) {
					sender.sendMessage(BlockGuardPlugin.stamp
							+ "No player found with this name!");
					return;
				}

				if (!sender.hasPermission("abiram26.blockguard.teleport.other")
						&& isMemberHimself == -1
						&& !sender.hasPermission("abiram26.blockguard.*")) {
					sender.sendMessage(BlockGuardPlugin.stamp
							+ "You do not have the permission to teleport other players!");
					return;
				}

				target.teleport(avgX, topY, avgZ);
				target.sendMessage(BlockGuardPlugin.stamp
						+ "You have been teleported to region " + args[1]
						+ " by " + sender.getName());
				sender.sendMessage(BlockGuardPlugin.stamp + "You teleported "
						+ target.getDisplayName() + " to region " + args[1]);

			} else {
				// args.length==2
				if (!sender.hasPermission("abiram26.blockguard.teleport")
						&& isMemberHimself == -1
						&& !sender.hasPermission("abiram26.blockguard.*")) {
					sender.sendMessage(BlockGuardPlugin.stamp
							+ "You do not have the permission to teleport yourself!");
					return;
				}

				if (!(sender instanceof Player)) {
					sender.sendMessage(BlockGuardPlugin.stamp
							+ "Command must be executed as a player!");
					return;
				}

				((Player) sender).teleport(avgX, topY, avgZ);
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "You teleported to region " + args[1]);
			}

			return;

		} else if (args[0].equalsIgnoreCase("remove")
				|| args[0].equalsIgnoreCase("rem")) {
			if (args.length > 2) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "Too many arguments were given!");
				return;
			}
			if (args.length == 1) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "Not enough arguments were given!");
				return;
			}
			cfg2.getRegions().remove(regionId);
			cfg3.getMembers().remove(regionId);
			cfg4.getFlags().remove(regionId);
			sender.sendMessage(BlockGuardPlugin.stamp + "Region " + args[1]
					+ " is removed!");
			// Save the config
			this.p1.getServer().getConfigurationManager().save(this.p1, cfg2);
			this.p1.getServer().getConfigurationManager().save(this.p1, cfg3);
			this.p1.getServer().getConfigurationManager().save(this.p1, cfg4);
			return;
		} else if (args[0].equalsIgnoreCase("rename")) {
			// 'New regionname is already taken'-check is already done
			// Rename
			this.cfg2.getRegions().get(regionId).setRegionName(args[2]);
			sender.sendMessage(BlockGuardPlugin.stamp + "Renamed " + args[1]
					+ " to " + args[2] + "!");
			// Save
			this.p1.getServer().getConfigurationManager().save(this.p1, cfg2);
			// Return
			return;
		} else if (args[0].equalsIgnoreCase("getflag")) {
			// third argument check is already done above
			if (args.length > 3) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "Too many arguments were given!");
				return;
			}
			if (args.length < 3) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "Not enough arguments were given!");
				return;

			}
			final Flags f1 = cfg4.getFlags().get(regionId);

			sender.sendMessage(BlockGuardPlugin.stamp + "The " + args[2]
					+ " flag of region " + args[1] + " is "
					+ f1.getFlag(args[2]));
			return;
		} else if (args[0].equalsIgnoreCase("setflag")) {
			// third argument check is already done above
			if (args.length > 4) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "Too many arguments were given!");
				return;
			}
			if (args.length < 4) {
				sender.sendMessage(BlockGuardPlugin.stamp
						+ "Not enough arguments were given!");
				return;
			}
			final boolean newFlagSetting;
			if (args[3].equalsIgnoreCase("true")) {
				newFlagSetting = true;
			} else {
				newFlagSetting = false;
			}

			cfg4.getFlags().get(regionId).setFlag(args[2], newFlagSetting);
			sender.sendMessage(BlockGuardPlugin.stamp + "The " + args[2]
					+ " flag of region " + args[1] + " is set to "
					+ newFlagSetting);

			// Save the config
			this.p1.getServer().getConfigurationManager().save(this.p1, cfg4);
			return;
		} // no else because that would be dead code :|

		// 'dead-code'
		sender.sendMessage(BlockGuardPlugin.stamp
				+ "An error occured: Please report this to Abiram with this message: "
				+ ChatColor.RED + Arrays.toString(args));
		return;

	}
}
