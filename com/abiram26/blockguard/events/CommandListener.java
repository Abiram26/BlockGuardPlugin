package com.abiram26.blockguard.events;

import com.abiram26.blockguard.BlockGuardPlugin;
import com.abiram26.blockguard.storage.RegionFlags;
import com.abiram26.blockguard.storage.RegionMembers;
import com.abiram26.blockguard.storage.Regions;
import com.mbserver.api.events.EventHandler;
import com.mbserver.api.events.Listener;
import com.mbserver.api.events.PreCommandEvent;
import com.mbserver.api.game.Location;
import com.mbserver.api.game.Player;

public class CommandListener implements Listener {

	private final Regions cfg1;
	private final RegionMembers cfg2;
	private final RegionFlags cfg3;

	public CommandListener(final Regions regions,
			final RegionMembers members, final RegionFlags flags) {
		this.cfg1 = regions;
		this.cfg2 = members;
		this.cfg3 = flags;
	}
	
	@EventHandler
	public void onBlockAction1(final PreCommandEvent event) {
		
		if(!(event.getSender() instanceof Player)){
			return;
		}
		final Player p1 =((Player)event.getSender());
		final Location loc1 = p1.getLocation();
		final int blockX = loc1.getBlockX();
		final int blockY = loc1.getBlockY();
		final int blockZ = loc1.getBlockZ();
		final String w1 = loc1.getWorld().getWorldName();
		if (!(p1.hasPermission("abiram26.blockguard.*"))) {
			for (int x = 0; x < cfg1.getRegions().size(); x++) {
				if (cfg1.getRegions().get(x)
						.contains(blockX, blockY, blockZ, w1)) {
					if (cfg2.getMembers().get(x)
							.hasMember(p1.getName()) == -1
							&& !cfg3.getFlags().get(x).isCan_player_execute_command()) {
							p1
									.sendMessage(
											BlockGuardPlugin.stamp
													+ "You are not allowed to execute commands in region: "
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

}
