package com.abiram26.blockguard.events;

import com.abiram26.blockguard.BlockGuardPlugin;
import com.mbserver.api.events.BlockBreakEvent;
import com.mbserver.api.events.BlockPlaceEvent;
import com.mbserver.api.events.EventHandler;
import com.mbserver.api.events.EventPriority;
import com.mbserver.api.events.Listener;
import com.mbserver.api.events.PreCommandEvent;
import com.mbserver.api.events.RunMode;
import com.mbserver.api.game.Location;
import com.mbserver.api.game.Player;

public class WandListener implements Listener {
	private final BlockGuardPlugin p1;

	public WandListener(final BlockGuardPlugin plugin) {
		// TODO Auto-generated constructor stub
		this.p1 = plugin;
	}

	@EventHandler(concurrency = RunMode.THREADED, priority = EventPriority.HIGH)
	public void onBreak(final BlockBreakEvent e) {
		final int blockId = e.getPlayer().getHandItem();
		// Check if the block is broken using the Wand
		if (blockId == p1.getWandPos1Id()) {
			final Player p2 = e.getPlayer();
			final Location loc5 = e.getBlock().getLocation();
			p2.setMetaData("BlockGuardX1", loc5.getBlockX());
			p2.setMetaData("BlockGuardY1", loc5.getBlockY());
			p2.setMetaData("BlockGuardZ1", loc5.getBlockZ());
			p2.sendMessage(BlockGuardPlugin.stamp + "Registered Wand Position 1 block!");
		} else if (blockId == p1.getWandPos2Id()) {
			final Player p2 = e.getPlayer();
			final Location loc6 = e.getBlock().getLocation();
			p2.setMetaData("BlockGuardX2", loc6.getBlockX());
			p2.setMetaData("BlockGuardY2", loc6.getBlockY());
			p2.setMetaData("BlockGuardZ2", loc6.getBlockZ());
			p2.sendMessage(BlockGuardPlugin.stamp + "Registered Wand Position 2 block!");
		}

	}

	@EventHandler(concurrency = RunMode.THREADED, priority = EventPriority.HIGH)
	public void onPlace(final BlockPlaceEvent e) {
		final int blockId = e.getBlock().getBlockID();
		// Check if placed block is a WandBlock
		if (blockId == p1.getWandPos1Id()) {
			final Player p2 = e.getPlayer();
			final Location loc1 = e.getBlock().getLocation();
			p2.setMetaData("BlockGuardX1", loc1.getBlockX());
			p2.setMetaData("BlockGuardY1", loc1.getBlockY());
			p2.setMetaData("BlockGuardZ1", loc1.getBlockZ());
			p2.sendMessage(BlockGuardPlugin.stamp + "Registered Wand Position 1 block!");
		} else if (blockId == p1.getWandPos2Id()) {
			final Player p2 = e.getPlayer();
			final Location loc3 = e.getBlock().getLocation();
			p2.setMetaData("BlockGuardX2", loc3.getBlockX());
			p2.setMetaData("BlockGuardY2", loc3.getBlockY());
			p2.setMetaData("BlockGuardZ2", loc3.getBlockZ());
			p2.sendMessage(BlockGuardPlugin.stamp + "Registered Wand Position 2 block!");
		}

	}

	@EventHandler(concurrency = RunMode.THREADED, priority = EventPriority.HIGH)
	public void onCmd(final PreCommandEvent e) {
		if (e.getSender() instanceof Player) {
			final Player p3 = (Player) e.getSender();
			final String cmd = e.getLabel();

			if (cmd.equals("/pos1") || cmd.equals("/pos2"))
				// Check permissions
				if (p3.hasPermission("ikkerens.worldedit.*")
						|| p3.hasPermission("ikkerens.worldedit.pos1")
						|| p3.hasPermission("ikkerens.worldedit.pos2")) {
					final Location loc1 = p3.getLocation();
					if (cmd.equals("/pos1")) {
						p3.setMetaData("BlockGuardX1", loc1.getBlockX());
						p3.setMetaData("BlockGuardY1", loc1.getBlockY());
						p3.setMetaData("BlockGuardZ1", loc1.getBlockZ());
						p3.sendMessage(BlockGuardPlugin.stamp
								+ "Registered Wand Position 1 command!");
					} else {
						p3.setMetaData("BlockGuardX2", loc1.getBlockX());
						p3.setMetaData("BlockGuardY2", loc1.getBlockY());
						p3.setMetaData("BlockGuardZ2", loc1.getBlockZ());
						p3.sendMessage(BlockGuardPlugin.stamp
								+ "Registered Wand Position 2 command!");
					}
				}
		}

	}

}
