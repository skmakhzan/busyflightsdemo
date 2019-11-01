package com.travix.medusa.crazyair.domain;

/**
 * 
 * @author skh
 *
 */

public enum CabinclassEnum {

	ECONOMY("E"), BUSINESS("B");

	private String name;

	CabinclassEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
