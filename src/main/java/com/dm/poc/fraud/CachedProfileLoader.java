package com.dm.poc.fraud;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.EntryPoint;
import org.kie.api.time.SessionClock;
import org.kie.api.time.SessionPseudoClock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dm.poc.fraud.domain.DevPatternCache;
import com.dm.poc.fraud.domain.Transaction;
import com.dm.poc.fraud.domain.TransactionEvent;
import com.dm.poc.fraud.domain.WhichAggRuleToFire;

public class CachedProfileLoader {

	private static final Logger LOGGER = LoggerFactory.getLogger(CachedProfileLoader.class);
	//private static LocalTransactionRepository ctRepository = new LocalTransactionRepository();
	private static DGCachedTransactionRepository ctRepository = new DGCachedTransactionRepository();

	/**
	 * Insert the qualified transaction into Transaction Cache in RHDG. Further,
	 * 
	 * 1. query the TransactionCache to get the set of transactions that match the
	 * given rule specific query criteria (aggregate conditions and time
	 * constraints).
	 * 
	 * 2. query the DevPatternCache to get the deviation pattern details
	 * 
	 * 3. finally, insert the obtained transaction Fact model into KieSession
	 * 
	 * 4. set the count+total deviation patterns as global variables
	 * 
	 * @param timeInMinutes
	 * @param transaction
	 * @param aggKey
	 * @param distinctKey
	 * @param kieSession
	 * @param amountThreshold
	 * @param countThreshold
	 * @param deviationPercent
	 * @param ruleId
	 */
	public static void insertAndLoadProfile(int timeInMinutes, Transaction transaction, String aggKey,
			String distinctKey, KieSession kieSession, BigDecimal amountThreshold, int countThreshold,
			Double deviationPercent, String ruleId) {

		// Insert the qualified transaction to TransactionCache
		long transTimeStamp = transaction.getTranTimestamp();
		BigDecimal transAmount = transaction.getAmt();
		String msgUID = transaction.getMsgUID();

		insertIntoTransactionCache(ruleId, msgUID, aggKey, distinctKey, transaction, transAmount, transTimeStamp);

		// Query the TransactionCache and get matching transactions
		long startTime = System.currentTimeMillis();
		Collection<Object> transactions = ctRepository.getTransactionEvents(ruleId, aggKey, distinctKey,
				transTimeStamp - TimeUnit.MINUTES.toMillis(timeInMinutes), transTimeStamp);
		LOGGER.info("Time taken to query DG cache in ms: " + (System.currentTimeMillis() - startTime));

		// If deviationPercent == 0; don't query from DevPatternCache
		if (null != deviationPercent) {
			loadDeviationFromCache(ruleId, msgUID, aggKey, countThreshold, amountThreshold, deviationPercent, kieSession);
		} else {
			kieSession.insert(new WhichAggRuleToFire(ruleId));
		}

		// Insert the transactions into kieSession
		for (Object nextTransaction : transactions) {
			insert(kieSession, "Transactions", (TransactionEvent)nextTransaction);
		}
	}

	/**
	 * Replay (Insert into KieSession) the historic transaction data retrieved from
	 * RHDG cache
	 * 
	 * @param kieSession
	 * @param stream
	 * @param txn
	 */
	private static void insert(KieSession kieSession, String stream, TransactionEvent txn) {
		SessionClock clock = kieSession.getSessionClock();
		SessionPseudoClock pseudoClock = (SessionPseudoClock) clock;
		EntryPoint ep = kieSession.getEntryPoint(stream);
		ep.insert(txn);

		// And then advance the clock.
		long advanceTime = txn.getTranTimestamp() - pseudoClock.getCurrentTime();
		if (advanceTime > 0) {
			pseudoClock.advanceTime(advanceTime, TimeUnit.MILLISECONDS);
		} else {
			// Print a warning when we don't need to advance the clock. This usually means
			// that the events are entering the system in the
			// incorrect order.
		}
	}

	private static void loadDeviationFromCache(String ruleId, String msgUID, String aggKey, int countThreshold,
			BigDecimal amountThreshold, Double deviationPercent, KieSession kieSession) {

		long startTime = System.currentTimeMillis();
		DevPatternCache dp = ctRepository.getDevPatternPerRule(ruleId, aggKey);
		LOGGER.info("Time taken to read from  DevPatternCache for msgUID:" + msgUID + " in ms: "
				+ (System.currentTimeMillis() - startTime));
		
		Double countThresholdFromCache = null;
		BigDecimal amountThresholdFromCache = null;
		Double calcCountThreshold = new Double(countThreshold);

		if (null != dp) {
			countThresholdFromCache = dp.getCount();
			amountThresholdFromCache = dp.getAmount();
		}

		if (null != countThresholdFromCache) {
			calcCountThreshold = deviationPercent / 100 * countThresholdFromCache;
		}

		if (null != amountThresholdFromCache) {
			amountThreshold = amountThresholdFromCache.multiply(new BigDecimal(deviationPercent / 100));
		}

		kieSession.insert(new WhichAggRuleToFire(ruleId, calcCountThreshold, amountThreshold));
	}

	/**
	 * Insert the qualified transaction into TransactionCache in RHDG
	 * 
	 * @param ruleId
	 * @param msgUID
	 * @param aggKey
	 * @param distinctKey
	 * @param transaction
	 * @param transAmount
	 * @param transTimeStamp
	 */
	private static void insertIntoTransactionCache(String ruleId, String msgUID, String aggKey, String distinctKey,
			Transaction cachedTransaction, BigDecimal tranAmount, long tranTimestamp) {

		long startTime = System.currentTimeMillis();
		ctRepository.postTransaction(new TransactionEvent(msgUID, ruleId, aggKey, distinctKey, tranAmount,
				cachedTransaction, tranTimestamp));

		LOGGER.info("Time taken to write to TxnCache for msgUID:" + msgUID + " in ms: "
				+ (System.currentTimeMillis() - startTime));
	}

	/**
	 * Store the given deviation pattern amount/ count for the given rule and aggKey
	 * in DG
	 * 
	 * @param ruleId
	 * @param msgUID
	 * @param aggKey
	 * @param tranAmount
	 * @param count
	 */
	public static void insertIntoDevPatternCache(String ruleId, String msgUID, String aggKey, BigDecimal tranAmount,
			Double count) {

		long startTime = System.currentTimeMillis();
		ctRepository.postDevPatternPerRule(new DevPatternCache(ruleId, aggKey, tranAmount, count));

		LOGGER.info("Time taken to write to DevPatternCache for msgUID:" + msgUID + "  in ms: "
				+ (System.currentTimeMillis() - startTime));
	}
}
