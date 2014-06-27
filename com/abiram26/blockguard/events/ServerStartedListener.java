package com.abiram26.blockguard.events;

import com.abiram26.blockguard.Plugin;
import com.mbserver.api.dynamic.BlockManager;
import com.mbserver.api.events.EventHandler;
import com.mbserver.api.events.Listener;
import com.mbserver.api.events.ServerStartedEvent;
public class ServerStartedListener implements Listener {
	private final Plugin p1;
	
	public ServerStartedListener(final Plugin plugin) {
		// TODO Auto-generated constructor stub
		this.p1 = plugin;
	}

	@EventHandler
	public void onStart(final ServerStartedEvent e) {
		final BlockManager bM = p1.getBlockManager();
		
		// Wand.LEFT check
		if (p1.getWandPos1Id() == -1) {
			for (int x = 0; x < 256; x++) {
				if (bM.getBlockType(x).getName()
						.equals("Wand Pos 1")) {
					p1.setWandPos1Id(x);
				}

			}
		}
		// Wand.RIGHT check
		if (p1.getWandPos2Id() == -1) {
			for (int x = 0; x < 256; x++) {
				if (bM.getBlockType(x).getName()
						.equals("Wand Pos 2")) {
					p1.setWandPos2Id(x);
					
				}

			}
		}
	}
}
