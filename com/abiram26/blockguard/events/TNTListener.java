package com.abiram26.blockguard.events;

import com.abiram26.blockguard.storage.RegionFlags;
import com.abiram26.blockguard.storage.Regions;
import com.mbserver.api.events.EventHandler;
import com.mbserver.api.events.Listener;
import com.mbserver.api.events.TNTExplosionEvent;
import com.mbserver.api.game.Location;

public class TNTListener implements Listener {

	private final Regions cfg1;
	private final RegionFlags cfg3;

	public TNTListener(final Regions regions, final RegionFlags flags) {
		this.cfg1 = regions;
		this.cfg3 = flags;
	}
	
	@EventHandler
	public void onTNT(final TNTExplosionEvent e) {
		final Location loc1 = e.getLocation();
		final int blockX = loc1.getBlockX();
		final int blockY = loc1.getBlockY();
		final int blockZ = loc1.getBlockZ();
		final String w1 = loc1.getWorld().getWorldName();
			for (int x = 0; x < cfg1.getRegions().size(); x++) {
				if (cfg1.getRegions().get(x)
						.contains(blockX, blockY, blockZ, w1)) {
					if (!cfg3.getFlags().get(x).isCan_TNT_explode()) {
						e.setCancelled(true);
						return;
					}
				}
			}
		
	}

}
