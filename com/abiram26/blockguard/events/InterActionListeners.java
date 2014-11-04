package com.abiram26.blockguard.events;

import com.abiram26.blockguard.BlockGuardPlugin;
import com.abiram26.blockguard.storage.RegionFlags;
import com.abiram26.blockguard.storage.RegionMembers;
import com.abiram26.blockguard.storage.Regions;
import com.mbserver.api.events.BedSleepEvent;
import com.mbserver.api.events.ChestOpenEvent;
import com.mbserver.api.events.ChestTransactionEvent;
import com.mbserver.api.events.CopperWiringInteractEvent;
import com.mbserver.api.events.DoorInteractEvent;
import com.mbserver.api.events.EventHandler;
import com.mbserver.api.events.Listener;
import com.mbserver.api.events.PaintBucketInteractEvent;
import com.mbserver.api.events.TNTInteractEvent;
import com.mbserver.api.events.TrashcanInteractEvent;
import com.mbserver.api.game.Location;

public class InterActionListeners implements Listener {
	private final Regions cfg1;
	private final RegionMembers cfg2;
	private final RegionFlags cfg3;

	public InterActionListeners(final Regions regions,
			final RegionMembers members, final RegionFlags flags) {
		this.cfg1 = regions;
		this.cfg2 = members;
		this.cfg3 = flags;
	}

	@EventHandler
	public void onInterAct1(final BedSleepEvent e) {
		final Location loc1 = e.getLocation();
		final int blockX = loc1.getBlockX();
		final int blockY = loc1.getBlockY();
		final int blockZ = loc1.getBlockZ();
		final String w1 = loc1.getWorld().getWorldName();
		if (!(e.getPlayer().hasPermission("abiram26.blockguard.*"))) {
			for (int x = 0; x < cfg1.getRegions().size(); x++) {
				if (cfg1.getRegions().get(x)
						.contains(blockX, blockY, blockZ, w1)) {
					if (cfg2.getMembers().get(x)
							.hasMember(e.getPlayer().getName()) == -1
							&& !cfg3.getFlags().get(x).isCan_player_interact_bed()) {
						e.getPlayer()
								.sendMessage(
										BlockGuardPlugin.stamp
												+ "You are not allowed to interact with a bed in region "
												+ cfg1.getRegions().get(x)
														.getRegionName() + "!");
						e.setCancelled(true);
						return;
					}
				}
			}
		}
	}
	@EventHandler
	public void onInterAct2(final CopperWiringInteractEvent e) {
		final Location loc1 = e.getLocation();
		final int blockX = loc1.getBlockX();
		final int blockY = loc1.getBlockY();
		final int blockZ = loc1.getBlockZ();
		final String w1 = loc1.getWorld().getWorldName();
		if (!(e.getPlayer().hasPermission("abiram26.blockguard.*"))) {
			for (int x = 0; x < cfg1.getRegions().size(); x++) {
				if (cfg1.getRegions().get(x)
						.contains(blockX, blockY, blockZ, w1)) {
					if (cfg2.getMembers().get(x)
							.hasMember(e.getPlayer().getName()) == -1
							&& !cfg3.getFlags().get(x).isCan_player_interact_electronic()) {
						e.getPlayer()
								.sendMessage(
										BlockGuardPlugin.stamp
												+ "You are not allowed to interact with electronics in region "
												+ cfg1.getRegions().get(x)
														.getRegionName() + "!");
						e.setCancelled(true);
						return;
					}
				}
			}
		}
	}
	@EventHandler
	public void onInterAct3(final ChestTransactionEvent e) {
		final Location loc1 = e.getLocation();
		final int blockX = loc1.getBlockX();
		final int blockY = loc1.getBlockY();
		final int blockZ = loc1.getBlockZ();
		final String w1 = loc1.getWorld().getWorldName();
		if (!(e.getPlayer().hasPermission("abiram26.blockguard.*"))) {
			for (int x = 0; x < cfg1.getRegions().size(); x++) {
				if (cfg1.getRegions().get(x)
						.contains(blockX, blockY, blockZ, w1)) {
					if (cfg2.getMembers().get(x)
							.hasMember(e.getPlayer().getName()) == -1
							&& !cfg3.getFlags().get(x).isCan_player_interact_chest()) {
						e.getPlayer()
								.sendMessage(
										BlockGuardPlugin.stamp
												+ "You are not allowed to interact with chests in region "
												+ cfg1.getRegions().get(x)
														.getRegionName() + "!");
						e.setCancelled(true);
						return;
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onInterAct4(final TNTInteractEvent e) {
		final Location loc1 = e.getLocation();
		final int blockX = loc1.getBlockX();
		final int blockY = loc1.getBlockY();
		final int blockZ = loc1.getBlockZ();
		final String w1 = loc1.getWorld().getWorldName();
		if (!(e.getPlayer().hasPermission("abiram26.blockguard.*"))) {
			for (int x = 0; x < cfg1.getRegions().size(); x++) {
				if (cfg1.getRegions().get(x)
						.contains(blockX, blockY, blockZ, w1)) {
					if (cfg2.getMembers().get(x)
							.hasMember(e.getPlayer().getName()) == -1
							&& !cfg3.getFlags().get(x).isCan_player_interact_TNT()) {
						e.getPlayer()
								.sendMessage(
										BlockGuardPlugin.stamp
												+ "You are not allowed to interact with TNT in region "
												+ cfg1.getRegions().get(x)
														.getRegionName() + "!");
						e.setCancelled(true);
						return;
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onInterAct5(final TrashcanInteractEvent e) {
		final Location loc1 = e.getLocation();
		final int blockX = loc1.getBlockX();
		final int blockY = loc1.getBlockY();
		final int blockZ = loc1.getBlockZ();
		final String w1 = loc1.getWorld().getWorldName();
		if (!(e.getPlayer().hasPermission("abiram26.blockguard.*"))) {
			for (int x = 0; x < cfg1.getRegions().size(); x++) {
				if (cfg1.getRegions().get(x)
						.contains(blockX, blockY, blockZ, w1)) {
					if (cfg2.getMembers().get(x)
							.hasMember(e.getPlayer().getName()) == -1
							&& !cfg3.getFlags().get(x).isCan_player_interact_trashcan()) {
						e.getPlayer()
								.sendMessage(
										BlockGuardPlugin.stamp
												+ "You are not allowed to interact with trashcans in region "
												+ cfg1.getRegions().get(x)
														.getRegionName() + "!");
						e.setCancelled(true);
						return;
					}
				}
			}
		}
	}
	@EventHandler
	public void onInterAct6(final PaintBucketInteractEvent e) {
		final Location loc1 = e.getLocation();
		final int blockX = loc1.getBlockX();
		final int blockY = loc1.getBlockY();
		final int blockZ = loc1.getBlockZ();
		final String w1 = loc1.getWorld().getWorldName();
		if (!(e.getPlayer().hasPermission("abiram26.blockguard.*"))) {
			for (int x = 0; x < cfg1.getRegions().size(); x++) {
				if (cfg1.getRegions().get(x)
						.contains(blockX, blockY, blockZ, w1)) {
					if (cfg2.getMembers().get(x)
							.hasMember(e.getPlayer().getName()) == -1
							&& !cfg3.getFlags().get(x).isCan_player_interact_paintbucket()) {
						e.getPlayer()
								.sendMessage(
										BlockGuardPlugin.stamp
												+ "You are not allowed to interact with paintbuckets in region "
												+ cfg1.getRegions().get(x)
														.getRegionName() + "!");
						e.setCancelled(true);
						return;
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onInterAct9(final ChestOpenEvent e) {
		final Location loc1 = e.getLocation();
		final int blockX = loc1.getBlockX();
		final int blockY = loc1.getBlockY();
		final int blockZ = loc1.getBlockZ();
		final String w1 = loc1.getWorld().getWorldName();
		if (!(e.getPlayer().hasPermission("abiram26.blockguard.*"))) {
			for (int x = 0; x < cfg1.getRegions().size(); x++) {
				if (cfg1.getRegions().get(x)
						.contains(blockX, blockY, blockZ, w1)) {
					if (cfg2.getMembers().get(x)
							.hasMember(e.getPlayer().getName()) == -1
							&& !cfg3.getFlags().get(x).isCan_player_open_chest()) {
						e.getPlayer()
								.sendMessage(
										BlockGuardPlugin.stamp
												+ "You are not allowed to open chests in region "
												+ cfg1.getRegions().get(x)
														.getRegionName() + "!");
						e.setCancelled(true);
						return;
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onInteract10(final DoorInteractEvent e){
		final Location loc1 = e.getLocation();
		final int blockX = loc1.getBlockX();
		final int blockY = loc1.getBlockY();
		final int blockZ = loc1.getBlockZ();
		final String w1 = loc1.getWorld().getWorldName();
		if (!(e.getPlayer().hasPermission("abiram26.blockguard.*"))) {
			for (int x = 0; x < cfg1.getRegions().size(); x++) {
				if (cfg1.getRegions().get(x)
						.contains(blockX, blockY, blockZ, w1)) {
					if (cfg2.getMembers().get(x)
							.hasMember(e.getPlayer().getName()) == -1
							&& !cfg3.getFlags().get(x).isCan_player_interact_door()) {
						e.getPlayer()
								.sendMessage(
										BlockGuardPlugin.stamp
												+ "You are not allowed to interact with doors in region "
												+ cfg1.getRegions().get(x)
														.getRegionName() + "!");
						e.setCancelled(true);
						return;
					}
				}
			}
		}
		
		
	}
	
	//TO-DO
	//can_player_interact_canvas
	//can_player_interact_elevator
	//Canvas = painting -> flag might never work...
	//Elevator interaction is the up and down movement
	
}
