package com.dm.poc.fraud;

import java.util.Collection;

import com.dm.poc.fraud.domain.TransactionEvent;

/**
 * Repository of transactions. Provides functionality to retrieve collections of
 * transactions based on the provided ruleId/aggkey/distinctKey and/or timestamp
 * of the transaction.
 * 
 * 
 */
public interface TransactionRepository {

	/**
	 * Retrieves all transactions of a given query criteria within a time period.
	 * @param ruleId
	 * @param aggKey
	 * @param distinctKey
	 * @param startTs
	 * @param endTs
	 * @return
	 */
	Collection<TransactionEvent> getTransactionEvents(String ruleId, String aggKey, String distinctKey, long startTs,
			long endTs);
}
