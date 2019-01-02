package com.dg.poc.fraud.domain;

import java.io.Serializable;
import java.util.List;

public class StaticListCacheModel implements Serializable {

	private static final long serialVersionUID = -181403229462007401L;

	private String entryKey;
	private List<Object> entryValue;

	public StaticListCacheModel() {

	}

	public List<Object> getEntryValue() {
		return entryValue;
	}

	public void setEntryValue(List<Object> entryValue) {
		this.entryValue = entryValue;
	}

	public String getEntryKey() {
		return entryKey;
	}

	public void setEntryKey(String entryKey) {
		this.entryKey = entryKey;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "StaticListCacheTemplate [entryKey=" + entryKey + ", entryValue=" + entryValue + "]";
	}

}
