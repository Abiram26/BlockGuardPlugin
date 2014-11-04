package com.abiram26.blockguard.events;

import com.abiram26.blockguard.storage.RegionFlags;
import com.abiram26.blockguard.storage.RegionMembers;
import com.abiram26.blockguard.storage.Regions;
import com.mbserver.api.events.Listener;

public class PlayerInventoryListeners implements Listener {

	//private final Regions cfg1;
	//private final RegionMembers cfg2;
	//private final RegionFlags cfg3;

	public PlayerInventoryListeners(final Regions regions,
			final RegionMembers members, final RegionFlags flags) {
	//	this.cfg1 = regions;
	//	this.cfg2 = members;
		//this.cfg3 = flags;
	}
	/**
	@EventHandler
	public void onPickup(final DropPickupEvent e) {
		final Location loc1 = e.getPlayer().getLocation();
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
							&& !cfg3.getFlags().get(x).isCan_player_drop_item()) {
						e.getPlayer()
								.sendMessage(
										BlockGuardPlugin.stamp
												+ "You are not allowed to pick up dropped items in region "
												+ cfg1.getRegions().get(x)
														.getRegionName() + "!");
						e.setCancelled(true);
						return;
					}
				}
			}
		}
	}
	
	// Server doesn't recognise the method... so the event isn't added I guess
*/
}
