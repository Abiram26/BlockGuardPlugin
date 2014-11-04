package com.abiram26.blockguard.events;

import com.abiram26.blockguard.BlockGuardPlugin;
import com.abiram26.blockguard.storage.RegionFlags;
import com.abiram26.blockguard.storage.RegionMembers;
import com.abiram26.blockguard.storage.Regions;
import com.mbserver.api.events.EntityDamageEvent;
import com.mbserver.api.events.EntityDeathEvent;
import com.mbserver.api.events.EntityHealEvent;
import com.mbserver.api.events.EventHandler;
import com.mbserver.api.events.Listener;
import com.mbserver.api.events.PlayerPvpEvent;
import com.mbserver.api.game.Location;
import com.mbserver.api.game.Player;

public class PlayerHealthListeners implements Listener {
	private final Regions cfg1;
	private final RegionMembers cfg2;
	private final RegionFlags cfg3;

	public PlayerHealthListeners(final Regions regions, final RegionMembers members,
			final RegionFlags flags) {
		this.cfg1 = regions;
		this.cfg2 = members;
		this.cfg3 = flags;
	}

	@EventHandler
	public void pvpEvent1(final PlayerPvpEvent e) {
		final Location loc1 = e.getVictim().getLocation();
		final int blockX = loc1.getBlockX();
		final int blockY = loc1.getBlockY();
		final int blockZ = loc1.getBlockZ();
		final String w1 = loc1.getWorld().getWorldName();
		if (!(e.getAttacker().hasPermission("abiram26.blockguard.*"))) {
			for (int x = 0; x < cfg1.getRegions().size(); x++) {
				if (cfg1.getRegions().get(x).contains(blockX, blockY, blockZ, w1)) {
					
					if (cfg2.getMembers().get(x)
							.hasMember(e.getAttacker().getName()) == -1&&
							!cfg3.getFlags().get(x).isCan_player_attack_player()) {
						e.getAttacker().sendMessage(
								BlockGuardPlugin.stamp
										+ "You are not allowed to PvP in region: "
										+ cfg1.getRegions().get(x)
												.getRegionName()
										+ "!");
						e.setCancelled(true);
						return;
					}
				}
			}
		}

	}
	
	@EventHandler
	public void deathEvent (EntityDeathEvent e){
		if(!(e.getEntity() instanceof Player)){
			return;
		}
		final Player p1 = (Player) e.getEntity();
		final Location loc1 = p1.getLocation();
		final int blockX = loc1.getBlockX();
		final int blockY = loc1.getBlockY();
		final int blockZ = loc1.getBlockZ();
		final String w1 = loc1.getWorld().getWorldName();
		if (!(p1.hasPermission("abiram26.blockguard.*"))) {
			for (int x = 0; x < cfg1.getRegions().size(); x++) {
				if (cfg1.getRegions().get(x).contains(blockX, blockY, blockZ, w1)) {
					
					if (cfg2.getMembers().get(x)
							.hasMember(p1.getName()) == -1&&
							!cfg3.getFlags().get(x).isCan_player_die()) {
						p1.sendMessage(
								BlockGuardPlugin.stamp
										+ "You are not allowed to die in region: "
										+ cfg1.getRegions().get(x)
												.getRegionName()
										+ "!");
						e.setCancelled(true);
						return;
					}
				}
			}
		}
	}
	
	@EventHandler
	public void healEvent (EntityHealEvent e){
		if(!(e.getEntity() instanceof Player)){
			return;
		}
		final Player p1 = (Player) e.getEntity();
		final Location loc1 = p1.getLocation();
		final int blockX = loc1.getBlockX();
		final int blockY = loc1.getBlockY();
		final int blockZ = loc1.getBlockZ();
		final String w1 = loc1.getWorld().getWorldName();
		if (!(p1.hasPermission("abiram26.blockguard.*"))) {
			for (int x = 0; x < cfg1.getRegions().size(); x++) {
				if (cfg1.getRegions().get(x).contains(blockX, blockY, blockZ, w1)) {
					
					if (cfg2.getMembers().get(x)
							.hasMember(p1.getName()) == -1&&
							!cfg3.getFlags().get(x).isCan_player_heal()) {
						p1.sendMessage(
								BlockGuardPlugin.stamp
										+ "You are not allowed to heal in region: "
										+ cfg1.getRegions().get(x)
												.getRegionName()
										+ "!");
						e.setCancelled(true);
						return;
					}
				}
			}
		}
	}
	
	@EventHandler
	public void damageEvent (EntityDamageEvent e){
		if(!(e.getEntity() instanceof Player)){
			return;
		}
		final Player p1 = (Player) e.getEntity();
		final Location loc1 = p1.getLocation();
		final int blockX = loc1.getBlockX();
		final int blockY = loc1.getBlockY();
		final int blockZ = loc1.getBlockZ();
		final String w1 = loc1.getWorld().getWorldName();
		if (!(p1.hasPermission("abiram26.blockguard.*"))) {
			for (int x = 0; x < cfg1.getRegions().size(); x++) {
				if (cfg1.getRegions().get(x).contains(blockX, blockY, blockZ, w1)) {
					
					if (cfg2.getMembers().get(x)
							.hasMember(p1.getName()) == -1&&
							!cfg3.getFlags().get(x).isCan_player_receive_damage()) {
						p1.sendMessage(
								BlockGuardPlugin.stamp
										+ "You are not allowed to receive damage in region: "
										+ cfg1.getRegions().get(x)
												.getRegionName()
										+ "!");
						e.setCancelled(true);
						return;
					}
				}
			}
		}
	}
	
	
	
}
