package com.dm.poc.fraud.domain;

import java.io.Serializable;
import java.util.List;

public class PotentialFraudFact implements Serializable{

	private static final long serialVersionUID = 2467427527620957260L;

	public PotentialFraudFact() {
		super();
	}

	public PotentialFraudFact(String alertId, String msgUId, String ruleId, String ruleName, int priority,
			String rqDateTime, String cardNo, String channel, List<Transaction> transactions, boolean isLog,
			boolean isEmail, boolean isSms, boolean isCase) {
		super();
		this.alertId = alertId;
		this.msgUId = msgUId;
		this.ruleId = ruleId;
		this.ruleName = ruleName;
		this.priority = priority;
		this.rqDateTime = rqDateTime;
		this.cardNo = cardNo;
		this.channel = channel;
		this.transactions = transactions;
		this.isLog = isLog;
		this.isEmail = isEmail;
		this.isSms = isSms;
		this.isCase = isCase;
	}

	private String alertId;
	private String msgUId;
	private String ruleId;
	private String ruleName;
	private int priority;
	private String rqDateTime;
	private String cardNo;
	private String channel;
	private List<Transaction> transactions;
	private boolean isLog;
	private boolean isEmail;
	private boolean isSms;
	private boolean isCase;

	public String getAlertId() {
		return alertId;
	}

	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}

	public String getMsgUId() {
		return msgUId;
	}

	public void setMsgUId(String msgUId) {
		this.msgUId = msgUId;
	}

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getRqDateTime() {
		return rqDateTime;
	}

	public void setRqDateTime(String rqDateTime) {
		this.rqDateTime = rqDateTime;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public boolean isLog() {
		return isLog;
	}

	public void setLog(boolean isLog) {
		this.isLog = isLog;
	}

	public boolean isEmail() {
		return isEmail;
	}

	public void setEmail(boolean isEmail) {
		this.isEmail = isEmail;
	}

	public boolean isSms() {
		return isSms;
	}

	public void setSms(boolean isSms) {
		this.isSms = isSms;
	}

	public boolean isCase() {
		return isCase;
	}

	public void setCase(boolean isCase) {
		this.isCase = isCase;
	}

	@Override
	public String toString() {
		return "PotentialFraudFact [alertId=" + alertId + ", msgUId=" + msgUId + ", ruleId=" + ruleId + ", ruleName="
				+ ruleName + ", priority=" + priority + ", rqDateTime=" + rqDateTime + ", cardNo=" + cardNo
				+ ", channel=" + channel + ", transactions=" + transactions + ", isLog=" + isLog + ", isEmail="
				+ isEmail + ", isSms=" + isSms + ", isCase=" + isCase + "]";
	}
}
