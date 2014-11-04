package com.abiram26.blockguard.events;

import com.abiram26.blockguard.BlockGuardPlugin;
import com.abiram26.blockguard.model.Cuboid;
import com.abiram26.blockguard.storage.RegionFlags;
import com.abiram26.blockguard.storage.RegionMembers;
import com.abiram26.blockguard.storage.Regions;
import com.mbserver.api.Permissible;
import com.mbserver.api.dynamic.ChatColor;
import com.mbserver.api.events.EventHandler;
import com.mbserver.api.events.Listener;
import com.mbserver.api.events.PlayerChatEvent;
import com.mbserver.api.game.Location;
import com.mbserver.api.game.Player;

public class ChatListener implements Listener {

	private final Regions cfg1;
	private final RegionMembers cfg2;
	private final RegionFlags cfg3;
	private final BlockGuardPlugin p1;

	public ChatListener(final BlockGuardPlugin plugin) {
		this.p1 = plugin;
		this.cfg1 = p1.getRegions();
		this.cfg2 = p1.getMembers();
		this.cfg3 = p1.getFlags();
	}

	@EventHandler
	public void onChat(final PlayerChatEvent event) {
		final Location loc1 = event.getPlayer().getLocation();
		final int blockX = loc1.getBlockX();
		final int blockY = loc1.getBlockY();
		final int blockZ = loc1.getBlockZ();
		final String w1 = loc1.getWorld().getWorldName();
		if (!(event.getPlayer().hasPermission("abiram26.blockguard.*"))) {
			for (int x = 0; x < cfg1.getRegions().size(); x++) {
				if (cfg1.getRegions().get(x)
						.contains(blockX, blockY, blockZ, w1)) {
					if (cfg2.getMembers().get(x)
							.hasMember(event.getPlayer().getName()) == -1) {

						final boolean canChatRegion = cfg3.getFlags().get(x)
								.isCan_player_chat();
						final boolean canChatPublic = cfg3.getFlags().get(x)
								.isCan_player_chat_public();

						if (canChatRegion && canChatPublic) {
							return;
						}

						if (!canChatRegion && !canChatPublic) {
							event.getPlayer()
									.sendMessage(
											BlockGuardPlugin.stamp
													+ "You are not allowed to chat in region: "
													+ cfg1.getRegions().get(x)
															.getRegionName()
													+ "!");

							event.setCancelled(true);
							return;
						}
						final Player sender = event.getPlayer();
						String tempMsg = event.getMessage();
						
						final String msgPart2 = p1.getServer()
								.getPermissionsHandler()
								.getColor((Permissible) sender)
								+ sender.getName()
								+ ChatColor.WHITE
								+ ": "
								+ tempMsg;
						
						if (canChatRegion && !canChatPublic) {
							final String msgPart1 = BlockGuardPlugin.stamp.replace(
									" ", "") + ChatColor.YELLOW + "[RegionChat]";
							for (Cuboid c1 : p1.getRegions().getRegions()) {
								if (c1.contains(blockX, blockY, blockZ, w1)) {
									final String rName = c1.getRegionName();
									sender.sendMessage(BlockGuardPlugin.stamp
											+ "Your message is sent to people in region "
											+ rName + "!");
									for (Player p2 : p1.getServer()
											.getPlayers()) {
										final Location playerLoc2 = p2
												.getLocation();
										final int x2 = playerLoc2.getBlockX(), y2 = playerLoc2
												.getBlockY(), z2 = playerLoc2
												.getBlockZ();
										final String w2 = playerLoc2.getWorld()
												.getWorldName();
										if (c1.contains(x2, y2, z2, w2)) {
											p2.sendMessage(msgPart1
													+ ChatColor.RED + "["
													+ rName + "]" + msgPart2);
										}
									}
								}
							}
						}
							
						if(!canChatRegion && canChatPublic){
							final String msgPart1 = BlockGuardPlugin.stamp.replace(
									" ", "") + ChatColor.YELLOW + "[Non-RegionChat]";
							for (Cuboid c1 : p1.getRegions().getRegions()) {
								if (c1.contains(blockX, blockY, blockZ, w1)) {
									final String rName = c1.getRegionName();
									sender.sendMessage(BlockGuardPlugin.stamp
											+ "Your message is sent to people in region "
											+ rName + "!");
									for (Player p2 : p1.getServer()
											.getPlayers()) {
										final Location playerLoc2 = p2
												.getLocation();
										final int x2 = playerLoc2.getBlockX(), y2 = playerLoc2
												.getBlockY(), z2 = playerLoc2
												.getBlockZ();
										final String w2 = playerLoc2.getWorld()
												.getWorldName();
										if (!c1.contains(x2, y2, z2, w2)) {
											p2.sendMessage(msgPart1
													+ ChatColor.RED + "["
													+ rName + "]" + msgPart2);
										}
									}
								}
							}
						}
					}
				}
			}
		}

	}

}
