package com.abiram26.blockguard.storage;

import java.util.ArrayList;

import com.abiram26.blockguard.model.Flags;

public class RegionFlags {
	private ArrayList<Flags> flags;

	public RegionFlags() {
		this.flags = new ArrayList<Flags>();
	}

	public ArrayList<Flags> getFlags() {
		return flags;
	}

	public void setFlags(final Flags flag) {
		this.flags.add(flag);

	}
}
