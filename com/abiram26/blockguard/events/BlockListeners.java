package com.abiram26.blockguard.events;

import com.abiram26.blockguard.BlockGuardPlugin;
import com.abiram26.blockguard.storage.RegionFlags;
import com.abiram26.blockguard.storage.RegionMembers;
import com.abiram26.blockguard.storage.Regions;
import com.mbserver.api.events.BlockBreakEvent;
import com.mbserver.api.events.BlockPlaceEvent;
import com.mbserver.api.events.EventHandler;
import com.mbserver.api.events.Listener;
import com.mbserver.api.game.Location;

public class BlockListeners implements Listener {
	private final Regions cfg1;
	private final RegionMembers cfg2;
	private final RegionFlags cfg3;

	public BlockListeners(final Regions regions, final RegionMembers members,
			final RegionFlags flags) {
		this.cfg1 = regions;
		this.cfg2 = members;
		this.cfg3 = flags;
	}

	@EventHandler
	public void onBlockAction1(final BlockBreakEvent event) {
		final Location loc1 = event.getLocation();
		final int blockX = loc1.getBlockX();
		final int blockY = loc1.getBlockY();
		final int blockZ = loc1.getBlockZ();
		final String w1 = loc1.getWorld().getWorldName();
		if (!(event.getPlayer().hasPermission("abiram26.blockguard.*"))) {
			for (int x = 0; x < cfg1.getRegions().size(); x++) {
				if (cfg1.getRegions().get(x)
						.contains(blockX, blockY, blockZ, w1)) {
					if (cfg2.getMembers().get(x)
							.hasMember(event.getPlayer().getName()) == -1
							&& !cfg3.getFlags().get(x).isCan_player_break_block()) {
							event.getPlayer()
									.sendMessage(
											BlockGuardPlugin.stamp
													+ "You are not allowed to destroy in region: "
													+ cfg1.getRegions().get(x)
															.getRegionName()
													+ "!");
						
						event.setCancelled(true);
						return;
					}
				}
			}
		}

	}
	
	@EventHandler
	public void onBlockAction2(final BlockPlaceEvent event) {
		final Location loc1 = event.getLocation();
		final int blockX = loc1.getBlockX();
		final int blockY = loc1.getBlockY();
		final int blockZ = loc1.getBlockZ();
		final String w1 = loc1.getWorld().getWorldName();
		if (!(event.getPlayer().hasPermission("abiram26.blockguard.*"))) {
			for (int x = 0; x < cfg1.getRegions().size(); x++) {
				if (cfg1.getRegions().get(x)
						.contains(blockX, blockY, blockZ, w1)) {
					if (cfg2.getMembers().get(x)
							.hasMember(event.getPlayer().getName()) == -1
							&& !cfg3.getFlags().get(x).isCan_player_place_block()) {
							event.getPlayer()
									.sendMessage(
											BlockGuardPlugin.stamp
													+ "You are not allowed to build in region: "
													+ cfg1.getRegions().get(x)
															.getRegionName()
													+ "!");
						
						event.setCancelled(true);
						return;
					}
				}
			}
		}

	}
	
	//TO-DO
	//can_block_gravitate & can_block_decay
	// gravitate is for blocks like sand & gravel
	// decay is for blocks like leaves
}
