package com.dm.poc.fraud.domain;

import java.math.BigDecimal;

public class WhichAggRuleToFire {

	public WhichAggRuleToFire() {
		super();
	}
	
	public WhichAggRuleToFire(String ruleName) {
		super();
		setRuleName(ruleName);
	}

	public WhichAggRuleToFire(String ruleName, Double aCountValue, BigDecimal aTotalValue) {
		super();
		setRuleName(ruleName);
		setaTotalValue(aTotalValue);
		setaCountValue(aCountValue);
	}

	private String ruleName;
	private Double aCountValue;
	private BigDecimal aTotalValue;

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public Double getaCountValue() {
		return aCountValue;
	}

	public void setaCountValue(Double aCountValue) {
		this.aCountValue = aCountValue;
	}

	public BigDecimal getaTotalValue() {
		return aTotalValue;
	}

	public void setaTotalValue(BigDecimal aTotalValue) {
		this.aTotalValue = aTotalValue;
	}
}
