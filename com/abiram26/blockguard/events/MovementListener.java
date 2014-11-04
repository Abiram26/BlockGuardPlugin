package com.abiram26.blockguard.events;

import com.abiram26.blockguard.BlockGuardPlugin;
import com.abiram26.blockguard.model.Cuboid;
import com.abiram26.blockguard.storage.Regions;
import com.mbserver.api.events.EventHandler;
import com.mbserver.api.events.Listener;
import com.mbserver.api.events.PlayerMoveEvent;
import com.mbserver.api.game.Location;

public class MovementListener implements Listener {

	private final Regions cfg1;

	public MovementListener(Regions regions) {
		cfg1 = regions;

	}

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		
		final Location loc1 = e.getTargetLocation();
		final int blockX = loc1.getBlockX();
		final int blockY = loc1.getBlockY();
		final int blockZ = loc1.getBlockZ();
		final String w1 = loc1.getWorld().getWorldName();
		final Cuboid curRegion = e.getPlayer().getMetaData(
				"BlockGuardCurrentRegion",
				new Cuboid(0, 0, 0, 1, 1, 1, "FakeBlockGuardRegionName",
						"world"));
		if (!curRegion.contains(blockX, blockY, blockZ, w1)
				|| curRegion.getRegionName().equals("FakeBlockGuardRegionName")) {
			if (!curRegion.getRegionName().equals("FakeBlockGuardRegionName")) {
				e.getPlayer().sendMessage(
						BlockGuardPlugin.stamp + "You left region "
								+ curRegion.getRegionName() + "!");
			}

			for (Cuboid c1 : cfg1.getRegions()) {
				if (c1.contains(blockX, blockY, blockZ, w1)) {
					e.getPlayer().setMetaData("BlockGuardCurrentRegion", c1);
					e.getPlayer().sendMessage(
							BlockGuardPlugin.stamp + "You entered region "
									+ c1.getRegionName() + "!");
					return;
				}
			}
			e.getPlayer().setMetaData(
					"BlockGuardCurrentRegion",
					new Cuboid(0, 0, 0, 1, 1, 1, "FakeBlockGuardRegionName",
							"world"));
		}

	}

}
