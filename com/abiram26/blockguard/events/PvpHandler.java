package com.abiram26.blockguard.events;

import com.abiram26.blockguard.Plugin;
import com.abiram26.blockguard.storage.Config;
import com.mbserver.api.events.EventHandler;
import com.mbserver.api.events.Listener;
import com.mbserver.api.events.PlayerPvpEvent;

public class PvpHandler implements Listener {
	private Config config;

	public PvpHandler(final Config config) {
		// TODO Auto-generated constructor stub
		this.config = config;
	}

	@EventHandler
	public void pvpEvent(final PlayerPvpEvent e) {
		final int blockX = e.getVictim().getLocation().getBlockX();
		final int blockY = e.getVictim().getLocation().getBlockY();
		final int blockZ = e.getVictim().getLocation().getBlockZ();
		if (!(e.getAttacker().hasPermission("abiram26.blockguard.*"))) {
			for (int x = 0; x < this.config.getRegions().size(); x++) {
				if (this.config.getRegions().get(x)
						.contains(blockX, blockY, blockZ)) {
					if (this.config.getMembers().get(x)
							.hasMember(e.getAttacker().getName()) == -1) {
						e.getAttacker().sendMessage(
								Plugin.stamp + "Region "
										+ this.config.getRegions().get(x)
												.getRegionName()
										+ " is guarded!");
						e.setCancelled(true);
						break;
					}
				}
			}
		}

	}
}
