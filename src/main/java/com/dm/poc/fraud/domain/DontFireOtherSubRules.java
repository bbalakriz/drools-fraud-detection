package com.dm.poc.fraud.domain;

public class DontFireOtherSubRules {

	public DontFireOtherSubRules() {
		super();
	}
	
	public DontFireOtherSubRules(String name) {
		super();
		setName(name);
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
