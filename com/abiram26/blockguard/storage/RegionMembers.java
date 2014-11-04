package com.abiram26.blockguard.storage;

import java.util.ArrayList;

import com.abiram26.blockguard.model.Members;

public class RegionMembers {
	private ArrayList<Members> members;

	/**
	 * Constructor
	 */
	public RegionMembers() {
		this.members = new ArrayList<Members>();
	}

	/**
	 * Get the 'Members'.
	 * @return An ArrayList with all members. (which is also an ArrayList)
	 */
	public ArrayList<Members> getMembers() {
		return members;
	}

	/**
	 * Add a 'Members' to the config.
	 * @param members A 'Members' to add.
	 */
	public void setMembers(final Members members) {
		this.members.add(members);
	}
}
