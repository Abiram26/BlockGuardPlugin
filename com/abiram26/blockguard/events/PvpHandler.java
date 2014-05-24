package com.abiram26.blockguard.events;

import com.abiram26.blockguard.Config;
import com.abiram26.blockguard.Plugin;
import com.mbserver.api.events.EventHandler;
import com.mbserver.api.events.Listener;
import com.mbserver.api.events.PlayerPvpEvent;

public class PvpHandler implements Listener {
	private Config config;

	public PvpHandler(Config config) {
		// TODO Auto-generated constructor stub
		this.config = config;
	}

	@EventHandler
	public void pvpEvent(PlayerPvpEvent e) {
		int blockX = e.getVictim().getLocation().getBlockX();
		int blockY = e.getVictim().getLocation().getBlockY();
		int blockZ = e.getVictim().getLocation().getBlockZ();
		if (!(e.getAttacker().hasPermission("abiram26.blockguard.*"))) {
			for (int x = 0; x < this.config.getRegions().size(); x++) {
				if (this.config.getRegions().get(x)
						.contains(blockX, blockY, blockZ)) {
					if (this.config.getMembers().get(x)
							.hasMember(e.getAttacker().getName().toLowerCase()) == -1) {
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
