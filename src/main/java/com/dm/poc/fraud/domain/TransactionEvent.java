package com.dm.poc.fraud.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author bbalasub
 *
 */
public class TransactionEvent implements Serializable {

	private static final long serialVersionUID = 8684630920865149738L;
	// Added on Nov 15
	private BigDecimal TranAmount;
	private Transaction CachedTransaction;
	private long TranTimestamp;
	private String AggKey;
	private String DistinctKey;
	private String RuleId;
	private String MsgUId;

	// This field has been for local testing only
	private String Key;

	public TransactionEvent() {
		super();
	}

	public TransactionEvent(String msgUId, String ruleId, String aggKey, String distinctKey, BigDecimal tranAmount,
			Transaction cachedTransaction, long tranTimestamp) {
		super();
		TranAmount = tranAmount;
		CachedTransaction = cachedTransaction;
		TranTimestamp = tranTimestamp;
		AggKey = aggKey;
		DistinctKey = distinctKey;
		RuleId = ruleId;
		MsgUId = msgUId;

		setKey(ruleId + aggKey + distinctKey);
	}

	public TransactionEvent(String ruleId, String aggKey, String distinctKey, BigDecimal tranAmount,
			Transaction cachedTransaction, long tranTimestamp) {
		super();
		TranAmount = tranAmount;
		CachedTransaction = cachedTransaction;
		TranTimestamp = tranTimestamp;
		AggKey = aggKey;
		DistinctKey = distinctKey;
		RuleId = ruleId;

		setKey(ruleId + aggKey + distinctKey);
	}

	public BigDecimal getTranAmount() {
		return TranAmount;
	}

	public void setTranAmount(BigDecimal tranAmount) {
		TranAmount = tranAmount;
	}

	public Transaction getCachedTransaction() {
		return CachedTransaction;
	}

	public void setCachedTransaction(Transaction cachedTransaction) {
		CachedTransaction = cachedTransaction;
	}

	public long getTranTimestamp() {
		return TranTimestamp;
	}

	public void setTranTimestamp(long tranTimestamp) {
		TranTimestamp = tranTimestamp;
	}

	public String getAggKey() {
		return AggKey;
	}

	public void setAggKey(String aggKey) {
		AggKey = aggKey;
	}

	public String getDistinctKey() {
		return DistinctKey;
	}

	public void setDistinctKey(String distinctKey) {
		DistinctKey = distinctKey;
	}

	public String getRuleId() {
		return RuleId;
	}

	public void setRuleId(String ruleId) {
		RuleId = ruleId;
	}

	public String getMsgUId() {
		return MsgUId;
	}

	public void setMsgUId(String msgUId) {
		this.MsgUId = msgUId;
	}

	public String getKey() {
		return Key;
	}

	public void setKey(String key) {
		Key = key;
	}

	@Override
	public String toString() {
		return "TransactionEvent [TranAmount=" + TranAmount + ", CachedTransaction=" + CachedTransaction
				+ ", TranTimestamp=" + TranTimestamp + ", AggKey=" + AggKey + ", DistinctKey=" + DistinctKey
				+ ", RuleId=" + RuleId + "]";
	}
}
