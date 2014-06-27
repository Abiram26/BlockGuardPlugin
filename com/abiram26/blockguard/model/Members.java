package com.abiram26.blockguard.model;

import java.util.ArrayList;

/**
 * 
 * @author Abiram26
 * 
 *         this.members.get(0) -> owner of region
 * 
 *         this.members.get(x) -> members of region ( where x >=1 )
 * 
 */

public class Members {

	public ArrayList<String> memberList;

	public Members(final String ownerName) {
		this.memberList = new ArrayList<String>();
		this.memberList.add(ownerName);
	}

	public ArrayList<String> getMemberList() {
		return memberList;
	}

	public int hasMember(final String inputName) {
		for (int x = 0; x < this.memberList.size(); x++) {
			if (this.memberList.get(x).equalsIgnoreCase(inputName) ) {
				return x;
			}
		}

		return -1;

	}

	public void addMember(final String inputName) {
		this.memberList.add(inputName);
	}

}
