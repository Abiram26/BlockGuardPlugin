package com.abiram26.blockguard.storage;

import java.util.ArrayList;

import com.abiram26.blockguard.model.Cuboid;
import com.abiram26.blockguard.model.Members;

public class Config {
	private ArrayList<Members> members;
	private ArrayList<Cuboid> regions;

	public Config() {
		this.regions = new ArrayList<Cuboid>();
		this.members = new ArrayList<Members>();
	}

	public ArrayList<Cuboid> getRegions() {
		return regions;
	}

	public void setRegion(Cuboid newregion) {
		this.regions.add(newregion);
	}

	public ArrayList<Members> getMembers() {
		return members;
	}

	public void setMembers(Members members) {
		this.members.add(members);
	}

	public int hasRegion(String inputRegionName) {
		for (int x = 0; x < this.regions.size(); x++) {
			if (this.regions.get(x).getRegionName().equalsIgnoreCase(inputRegionName)){
				return x;
			}
		}
		return -1;
	}

}
