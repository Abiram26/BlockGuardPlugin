package com.abiram26.blockguard.events;

import com.abiram26.blockguard.storage.RegionFlags;
import com.abiram26.blockguard.storage.RegionMembers;
import com.abiram26.blockguard.storage.Regions;
import com.mbserver.api.events.EntityDamageEvent;
import com.mbserver.api.events.EntityDeathEvent;
import com.mbserver.api.events.EntityHealEvent;
import com.mbserver.api.events.EventHandler;
import com.mbserver.api.events.Listener;
import com.mbserver.api.game.Location;
import com.mbserver.api.game.npcs.NPC;

public class NPCListeners implements Listener {

	private final Regions cfg1;
	//private final RegionMembers cfg2;
	private final RegionFlags cfg3;

	public NPCListeners(final Regions regions,
			final RegionMembers members, final RegionFlags flags) {
		this.cfg1 = regions;
		//this.cfg2 = members;
		this.cfg3 = flags;
	}
	
	@EventHandler
	public void onDeath(final EntityDeathEvent e) {
		if(!( e.getEntity() instanceof NPC)){
			return;
		}
		final Location loc1 = e.getEntity().getLocation();
		final int blockX = loc1.getBlockX();
		final int blockY = loc1.getBlockY();
		final int blockZ = loc1.getBlockZ();
		final String w1 = loc1.getWorld().getWorldName();
			for (int x = 0; x < cfg1.getRegions().size(); x++) {
				if (cfg1.getRegions().get(x)
						.contains(blockX, blockY, blockZ, w1)) {
					if (!cfg3.getFlags().get(x).isCan_NPC_die()) {
						e.setCancelled(true);
						return;
					}
				}
			}
		
	}
	@EventHandler
	public void onHeal(final EntityHealEvent e) {
		if(!( e.getEntity() instanceof NPC)){
			return;
		}
		final Location loc1 = e.getEntity().getLocation();
		final int blockX = loc1.getBlockX();
		final int blockY = loc1.getBlockY();
		final int blockZ = loc1.getBlockZ();
		final String w1 = loc1.getWorld().getWorldName();
			for (int x = 0; x < cfg1.getRegions().size(); x++) {
				if (cfg1.getRegions().get(x)
						.contains(blockX, blockY, blockZ, w1)) {
					if (!cfg3.getFlags().get(x).isCan_NPC_heal()) {
						e.setCancelled(true);
						return;
					}
				}
			}
		
	}
	
	@EventHandler
	public void onDeath(final EntityDamageEvent e) {
		if(!( e.getEntity() instanceof NPC)){
			return;
		}
		final Location loc1 = e.getEntity().getLocation();
		final int blockX = loc1.getBlockX();
		final int blockY = loc1.getBlockY();
		final int blockZ = loc1.getBlockZ();
		final String w1 = loc1.getWorld().getWorldName();
			for (int x = 0; x < cfg1.getRegions().size(); x++) {
				if (cfg1.getRegions().get(x)
						.contains(blockX, blockY, blockZ, w1)) {
					if (!cfg3.getFlags().get(x).isCan_NPC_receive_damage()) {
						e.setCancelled(true);
						return;
					}
				}
			}
		
	}

}
