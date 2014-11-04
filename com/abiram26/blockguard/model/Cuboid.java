package com.abiram26.blockguard.model;

import java.util.ArrayList;

import com.mbserver.api.game.Location;
import com.mbserver.api.game.Player;

/**
 * 
 * @author Abiram26
 * 
 */
public class Cuboid {

	private String regionName, worldName;
	private int x, y, z, dX, dY, dZ;

	/**
	 * 
	 * @param x
	 *            The lowest x-coordinate of the region.
	 * @param y
	 *            The lowest y-coordinate of the region.
	 * @param z
	 *            The lowest z-coordinate of the region.
	 * @param deltaX
	 *            The difference between the highest x-coordinate and the lowest
	 *            x-coordinate of the region. (Amount of blocks)
	 * @param deltaY
	 *            The difference between the highest x-coordinate and the lowest
	 *            x-coordinate of the region. (Amount of blocks)
	 * @param deltaZ
	 *            The difference between the highest x-coordinate and the lowest
	 *            x-coordinate of the region. (Amount of blocks)
	 * @param rName
	 *            The regionname of the region.
	 * @param world
	 *            The worldname, where the region is in.
	 */
	public Cuboid(final int x, final int y, final int z, final int deltaX,
			final int deltaY, final int deltaZ, final String rName,
			final String world) {
		this.regionName = rName;
		this.x = x;
		this.y = y;
		this.z = z;
		this.dX = deltaX;
		this.dY = deltaY;
		this.dZ = deltaZ;
		this.worldName = world;
	}

	/**
	 * 
	 * @param x1
	 *            An x-coordinate.
	 * @param y1
	 *            An y-coordinate.
	 * @param z1
	 *            An z-coordinate
	 * @param world1
	 *            A worldname.
	 * @return True, if the coordinate is in the region. False, if not. (The
	 *         worldname is checked as well)
	 */
	public boolean contains(final int x1, final int y1, final int z1,
			final String world1) {
		if (!world1.equalsIgnoreCase(this.worldName)) {
			return false;
		}
		if (x1 >= this.x && x1 <= (this.x + this.dX - 1) && y1 >= this.y
				&& y1 <= (this.y + this.dY - 1) && z1 >= this.z
				&& z1 <= (this.z + this.dZ - 1)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param loc1
	 *            A location.
	 * @return True, if the coordinate is in the region. False, if not. (The
	 *         world does matter)
	 */
	public boolean contains(final Location loc1) {
		if (!loc1.getWorld().getWorldName().equalsIgnoreCase(this.worldName)) {
			return false;
		}
		final int x1 = loc1.getBlockX();
		final int y1 = loc1.getBlockY();
		final int z1 = loc1.getBlockZ();
		if (x1 >= this.x && x1 <= (this.x + this.dX - 1) && y1 >= this.y
				&& y1 <= (this.y + this.dY - 1) && z1 >= this.z
				&& z1 <= (this.z + this.dZ - 1)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 
	 * @return The regionname of the region.
	 */
	public String getRegionName() {
		return this.regionName;
	}
	/**
	 * 
	 * @param playersOnServer Send an array with players on the server. (getServer.getPlayers())
	 * @return A String array with the playernames, who are in the region.
	 */
	public String[] containsPlayers(final Player[] playersOnServer) {
		final ArrayList<String> playerNames = new ArrayList<String>();
		for (Player p1 : playersOnServer) {
			if (this.contains(p1.getLocation())) {
				playerNames.add(p1.getDisplayName());
			}
		}
		return (String[]) playerNames.toArray();
	}
/**
 * 
 * @param regionName Set a new regionname for the region.
 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
/**
 * 
 * @return The lowest x-coordinate
 */
	public int getX() {
		return x;
	}
	/**
	 * 
	 * @return The lowest y-coordinate
	 */
	public int getY() {
		return y;
	}
	/**
	 * 
	 * @return The lowest z-coordinate
	 */
	public int getZ() {
		return z;
	}
	/**
	 * 
	 * @return The difference between the lowest and highest x-coordinate. (in amount of blocks)
	 */
	public int getdX() {
		return dX;
	}
	/**
	 * 
	 * @return The difference between the lowest and highest y-coordinate. (in amount of blocks)
	 */
	public int getdY() {
		return dY;
	}/**
	 * 
	 * @return The difference between the lowest and highest y-coordinate. (in amount of blocks)
	 */

	public int getdZ() {
		return dZ;
	}
	/**
	 * 
	 * @return The worldname, where this region is in.
	 */
	public String getWorldName() {
		return worldName;
	}
}

