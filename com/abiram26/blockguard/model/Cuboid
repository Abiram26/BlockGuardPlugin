package com.abiram26.blockguard.model;

public class Cuboid {
	public String regionName;
	public int x, y, z, deltaX, deltaY, deltaZ;

	public Cuboid(int x, int y, int z, int deltaX, int deltaY, int deltaZ, String rName) {
		this.regionName=rName;
		this.x = x;
		this.y = y;
		this.z = z;
		this.deltaX = deltaX;
		this.deltaY = deltaY;
		this.deltaZ = deltaZ;
	}

	public boolean contains(int x1, int y1, int z1) {
		if (x1 >= this.x && x1 <= (this.x + this.deltaX) && y1 >= this.y
				&& y1 <= (this.y + this.deltaY) && z1 >= this.z
				&& z1 <= (this.z + this.deltaZ)) {
			return true;
		} else {
			return false;
		}
	}
	public String getRegionName(){
		return this.regionName;
	}
}
