package com.abiram26.blockguard.events;

import com.abiram26.blockguard.Config;
import com.abiram26.blockguard.Plugin;
import com.mbserver.api.events.BlockEvent;
import com.mbserver.api.events.EventHandler;
import com.mbserver.api.events.Listener;

public class BlockEventHandler implements Listener {
	private Config config;

	public BlockEventHandler(Config config) {
		// TODO Auto-generated constructor stub
		this.config = config;
	}

	@EventHandler
	public void onBlockAction(BlockEvent event) {
		int blockX = event.getLocation().getBlockX();
		int blockY = event.getLocation().getBlockY();
		int blockZ = event.getLocation().getBlockZ();
		if (!(event.getPlayer().hasPermission("abiram26.blockguard.*"))) {
			for (int x = 0; x < this.config.getRegions().size(); x++) {
				if (this.config.getRegions().get(x)
						.contains(blockX, blockY, blockZ)) {
					if (this.config
							.getMembers()
							.get(x)
							.hasMember(
									event.getPlayer().getName().toLowerCase()) == -1) {
						event.getPlayer().sendMessage(
								Plugin.stamp + "Region "
										+ this.config.getRegions().get(x)
												.getRegionName()
										+ " is guarded!");
						event.setCancelled(true);
						break;
					}
				}
			}
		}

	}
}
