package com.dm.poc.fraud.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class DevPatternCache implements Serializable {

	private static final long serialVersionUID = -181403229462007401L;

	private String ruleId;
	private String aggKey;
	private BigDecimal amount;
	private Double count;

	public DevPatternCache() {
		super();
	}

	public DevPatternCache(String ruleId, String aggKey, BigDecimal tranAmount, Double count) {
		this.ruleId = ruleId;
		this.aggKey = aggKey;
		this.amount = tranAmount;
		this.count = count;
	}

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public String getAggKey() {
		return aggKey;
	}

	public void setAggKey(String aggKey) {
		this.aggKey = aggKey;
	}

	public Double getCount() {
		return count;
	}

	public void setCount(Double count) {
		this.count = count;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "DevPatternCacheTemplate [ruleId=" + ruleId + ", aggKey=" + aggKey + ", amount=" + amount + ", count="
				+ count + "]";
	}

}
