package com.dm.poc.fraud.domain;

public class DontFireNoPrioRules {

	public DontFireNoPrioRules() {
		super();
	}
	
	public DontFireNoPrioRules(Class<?> c) {
		super();
		this.clazz = c;
	}

	private Class<?> clazz;

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
