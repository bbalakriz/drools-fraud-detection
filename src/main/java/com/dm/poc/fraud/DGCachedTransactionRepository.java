package com.dm.poc.fraud;

import java.io.IOException;
import java.util.Collection;

import com.dg.poc.fraud.processors.CacheTransmission;
import com.dm.poc.fraud.domain.DevPatternCache;
import com.dm.poc.fraud.domain.TransactionEvent;

/**
 * {@link TransactionRepository} implementation that stores the transactions in
 * data grid.
 * 
 */
public class DGCachedTransactionRepository {

	public Collection<Object> getTransactionEvents(String ruleId, String aggKey, String distinctKey, long startTs,
			long endTs) {

		Collection<Object> o = null;

		try {
			o = CacheTransmission.readTxnCache(ruleId, aggKey, distinctKey, startTs, endTs);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return o;
	}

	/** Store the given qualified transaction in DG */
	public void postTransaction(TransactionEvent te) {
		try {
			CacheTransmission.loadTransactionCache(te);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get the deviation pattern amount/ count for the given rule and aggKey from
	 * Data Grid
	 */
	public DevPatternCache getDevPatternPerRule(String ruleId, String aggKey) {
		DevPatternCache o = null;

		try {
			o = CacheTransmission.readDevPatternCache(ruleId, aggKey);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return o;
	}

	/**
	 * Store the given deviation pattern amount/ count for the given rule and aggKey
	 * in DG
	 */
	public void postDevPatternPerRule(DevPatternCache dpct) {
		try {
			CacheTransmission.loadDevPatternDataCache(dpct);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
