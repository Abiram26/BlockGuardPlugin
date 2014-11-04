package com.abiram26.blockguard.storage;

import java.util.ArrayList;

import com.abiram26.blockguard.model.Cuboid;

public class Regions {
	private ArrayList<Cuboid> regions;

	public Regions() {
		this.regions = new ArrayList<Cuboid>();
	}

	public ArrayList<Cuboid> getRegions() {
		return regions;
	}

	public void setRegion(final Cuboid newregion) {
		this.regions.add(newregion);
	}

	/**
	 * 
	 * @param inputRegionName
	 *            (String) is a possible regionname
	 * @return is the ID of the region. When -1 is returned, then there is no
	 *         regionname matching the String.
	 */
	public int getRegion(final String inputRegionName) {
		for (int x = 0; x < this.regions.size(); x++) {
			if (this.regions.get(x).getRegionName()
					.equalsIgnoreCase(inputRegionName)) {
				return x;
			}
		}
		return -1;
	}
}
