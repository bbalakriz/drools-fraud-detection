package com.dm.poc.fraud;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dm.poc.fraud.domain.DevPatternCache;
import com.dm.poc.fraud.domain.Transaction;
import com.dm.poc.fraud.domain.TransactionEvent;

/**
 * Simple {@link TransactionRepository} implementation that stores the
 * transactions in memory. Used for local testing when data grid is not
 * available
 * 
 */
public class LocalTransactionRepository implements TransactionRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(LocalTransactionRepository.class);

	private Map<String, List<TransactionEvent>> tEvents;

	public LocalTransactionRepository() {
		tEvents = new HashMap<String, List<TransactionEvent>>();

		// Load the facts/events from sample hard coded data.
		List<TransactionEvent> loadedTransactions = getTransactions();

		for (TransactionEvent nextTransaction : loadedTransactions) {
			List<TransactionEvent> cardTransactions = tEvents.get(nextTransaction.getKey());

			if (cardTransactions == null) {
				cardTransactions = new ArrayList<TransactionEvent>();
				tEvents.put(nextTransaction.getKey(), cardTransactions);
			}

			cardTransactions.add(nextTransaction);
		}

		System.out.println("Loaded hard coded transactions for " + tEvents.size() + " aggKeys.");
	}

	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd:HHmmssSSS");

	List<TransactionEvent> getTransactions() {
		List<TransactionEvent> transList = new ArrayList<TransactionEvent>();

		try {
			// Rule 1 data
			TransactionEvent txn1 = new TransactionEvent("Rule1", "1002837938249", "", new BigDecimal(2000),
					new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

			TransactionEvent txn2 = new TransactionEvent("Rule1", "1002837938249", "", new BigDecimal(100),
					new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

			TransactionEvent txn3 = new TransactionEvent("Rule1", "1002837938249", "", new BigDecimal(3000),
					new Transaction(), DATE_FORMAT.parse("20181129:092000000").getTime());

			TransactionEvent txn4 = new TransactionEvent("Rule1", "1002837938249", "", new BigDecimal(109),
					new Transaction(), DATE_FORMAT.parse("20181129:092100000").getTime());

			TransactionEvent txn5 = new TransactionEvent("Rule1", "1002837938249", "", new BigDecimal(88),
					new Transaction(), DATE_FORMAT.parse("20181129:093100000").getTime());

			TransactionEvent txn6 = new TransactionEvent("Rule1", "1002837938249", "", new BigDecimal(45),
					new Transaction(), DATE_FORMAT.parse("20181129:093501000").getTime());

			// Rule 1 data
			TransactionEvent txn17 = new TransactionEvent("Rule2", "1002837938249", "", new BigDecimal(2000),
					new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

			TransactionEvent txn18 = new TransactionEvent("Rule2", "1002837938249", "", new BigDecimal(100),
					new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

			TransactionEvent txn19 = new TransactionEvent("Rule2", "1002837938249", "", new BigDecimal(3000),
					new Transaction(), DATE_FORMAT.parse("20181129:092000000").getTime());

			TransactionEvent txn20 = new TransactionEvent("Rule2", "1002837938249", "", new BigDecimal(109),
					new Transaction(), DATE_FORMAT.parse("20181129:092100000").getTime());

			TransactionEvent txn21 = new TransactionEvent("Rule2", "1002837938249", "", new BigDecimal(88),
					new Transaction(), DATE_FORMAT.parse("20181129:093100000").getTime());

			// Rule 3 data
			TransactionEvent txn7 = new TransactionEvent("Rule3", "1002837938249M1", "", new BigDecimal(2000),
					new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

			TransactionEvent txn8 = new TransactionEvent("Rule3", "1002837938249M1", "", new BigDecimal(100),
					new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

			TransactionEvent txn9 = new TransactionEvent("Rule3", "1002837938249M1", "", new BigDecimal(189),
					new Transaction(), DATE_FORMAT.parse("20181129:092000000").getTime());

			TransactionEvent txn10 = new TransactionEvent("Rule3", "1002837938249M1", "", new BigDecimal(4000),
					new Transaction(), DATE_FORMAT.parse("20181129:092100000").getTime());

			TransactionEvent txn11 = new TransactionEvent("Rule3", "1002837938249M1", "", new BigDecimal(200),
					new Transaction(), DATE_FORMAT.parse("20181129:093100000").getTime());

			// Rule 4 data
			TransactionEvent txn12 = new TransactionEvent("Rule4", "1002837938249", "T1", new BigDecimal(2000),
					new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

			TransactionEvent txn13 = new TransactionEvent("Rule4", "1002837938249", "T1", new BigDecimal(100),
					new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

			TransactionEvent txn14 = new TransactionEvent("Rule4", "1002837938249", "T1", new BigDecimal(189),
					new Transaction(), DATE_FORMAT.parse("20181129:092000000").getTime());

			TransactionEvent txn15 = new TransactionEvent("Rule4", "1002837938249", "T1", new BigDecimal(4000),
					new Transaction(), DATE_FORMAT.parse("20181129:092100000").getTime());

			TransactionEvent txn16 = new TransactionEvent("Rule4", "1002837938249", "T1", new BigDecimal(200),
					new Transaction(), DATE_FORMAT.parse("20181129:093100000").getTime());

			// Rule 5 data
			TransactionEvent txn22 = new TransactionEvent("Rule5", "1002837938249", "", new BigDecimal(2000),
					new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

			TransactionEvent txn23 = new TransactionEvent("Rule5", "1002837938249", "", new BigDecimal(100),
					new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

			TransactionEvent txn24 = new TransactionEvent("Rule5", "1002837938249", "", new BigDecimal(189),
					new Transaction(), DATE_FORMAT.parse("20181129:092000000").getTime());

			// TransactionEvent txn25 = new TransactionEvent("Rule5", "1002837938249", "",
			// new BigDecimal(4000),
			// new Transaction(), DATE_FORMAT.parse("20181129:092100000").getTime());

			// TransactionEvent txn26 = new TransactionEvent("Rule5", "1002837938249", "",
			// new BigDecimal(200),
			// new Transaction(), DATE_FORMAT.parse("20181129:093100000").getTime());

			// Rule 6 data
			TransactionEvent txn27 = new TransactionEvent("Rule6", "1002837938249", "", new BigDecimal(2000),
					new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

			TransactionEvent txn28 = new TransactionEvent("Rule6", "1002837938249", "", new BigDecimal(100),
					new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

			TransactionEvent txn29 = new TransactionEvent("Rule6", "1002837938249", "", new BigDecimal(189),
					new Transaction(), DATE_FORMAT.parse("20181129:092000000").getTime());

			TransactionEvent txn30 = new TransactionEvent("Rule6", "1002837938249", "", new BigDecimal(4000),
					new Transaction(), DATE_FORMAT.parse("20181129:092100000").getTime());

			TransactionEvent txn31 = new TransactionEvent("Rule6", "1002837938249", "", new BigDecimal(200),
					new Transaction(), DATE_FORMAT.parse("20181129:093100000").getTime());

			// Rule 7 data
			TransactionEvent txn32 = new TransactionEvent("Rule7", "1002837938249", "", new BigDecimal(2000),
					new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

			TransactionEvent txn33 = new TransactionEvent("Rule7", "1002837938249", "", new BigDecimal(100),
					new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

			TransactionEvent txn34 = new TransactionEvent("Rule7", "1002837938249", "", new BigDecimal(189),
					new Transaction(), DATE_FORMAT.parse("20181129:092000000").getTime());

			TransactionEvent txn35 = new TransactionEvent("Rule7", "1002837938249", "", new BigDecimal(4000),
					new Transaction(), DATE_FORMAT.parse("20181129:092100000").getTime());

			TransactionEvent txn36 = new TransactionEvent("Rule7", "1002837938249", "", new BigDecimal(200),
					new Transaction(), DATE_FORMAT.parse("20181129:093100000").getTime());

			// Rule 8 data
			TransactionEvent txn37 = new TransactionEvent("Rule8", "M1", "", new BigDecimal(2455), new Transaction(),
					DATE_FORMAT.parse("20181129:091001000").getTime());

			TransactionEvent txn38 = new TransactionEvent("Rule8", "M1", "", new BigDecimal(243), new Transaction(),
					DATE_FORMAT.parse("20181129:091001000").getTime());

			TransactionEvent txn39 = new TransactionEvent("Rule8", "M1", "", new BigDecimal(21), new Transaction(),
					DATE_FORMAT.parse("20181129:092000000").getTime());

			TransactionEvent txn40 = new TransactionEvent("Rule8", "M1", "", new BigDecimal(2432), new Transaction(),
					DATE_FORMAT.parse("20181129:092100000").getTime());

			TransactionEvent txn41 = new TransactionEvent("Rule8", "M1", "", new BigDecimal(3311), new Transaction(),
					DATE_FORMAT.parse("20181129:093100000").getTime());

			// Rule 9 data
			TransactionEvent txn42 = new TransactionEvent("Rule9", "1002837938249", "M1", new BigDecimal(4545),
					new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

			TransactionEvent txn43 = new TransactionEvent("Rule9", "1002837938249", "M1", new BigDecimal(311),
					new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

			TransactionEvent txn44 = new TransactionEvent("Rule9", "1002837938249", "M1", new BigDecimal(5634),
					new Transaction(), DATE_FORMAT.parse("20181129:092000000").getTime());

			// Rule 10 data
			TransactionEvent txn45 = new TransactionEvent("Rule10", "M1", "", new BigDecimal(7336), new Transaction(),
					DATE_FORMAT.parse("20181129:092100000").getTime());

			TransactionEvent txn46 = new TransactionEvent("Rule10", "M1", "", new BigDecimal(3311), new Transaction(),
					DATE_FORMAT.parse("20181129:093100000").getTime());

			transList.add(txn1);
			transList.add(txn2);
			transList.add(txn3);
			transList.add(txn4);
			transList.add(txn5);

			transList.add(txn6);
			transList.add(txn7);
			transList.add(txn8);
			transList.add(txn9);
			transList.add(txn10);

			transList.add(txn11);
			transList.add(txn12);
			transList.add(txn13);
			transList.add(txn14);
			transList.add(txn15);

			transList.add(txn16);
			transList.add(txn17);
			transList.add(txn18);
			transList.add(txn19);
			transList.add(txn20);
			transList.add(txn21);

			transList.add(txn22);
			transList.add(txn23);
			transList.add(txn24);
			// transList.add(txn25);
			// transList.add(txn26);

			transList.add(txn27);
			transList.add(txn28);
			transList.add(txn29);
			transList.add(txn30);
			transList.add(txn31);

			transList.add(txn32);
			transList.add(txn33);
			transList.add(txn34);
			transList.add(txn35);
			transList.add(txn36);

			transList.add(txn37);
			transList.add(txn38);
			transList.add(txn39);
			transList.add(txn40);
			transList.add(txn41);

			transList.add(txn42);
			transList.add(txn43);
			transList.add(txn44);

			transList.add(txn45);
			transList.add(txn46);

			// TODO Remember to insert in the reverse order. For some reason, the forward
			// order reverses during insert into drools
		} catch (NumberFormatException nfe) {
			LOGGER.error("Error parsing data");
		} catch (ParseException pe) {
			LOGGER.error("Error parsing data");
		}

		return transList;
	}

	@Override
	public Collection<TransactionEvent> getTransactionEvents(String ruleId, String aggKey, String distinctKey,
			long startTs, long endTs) {

		StringBuilder queryKey = new StringBuilder(ruleId);
		queryKey.append(aggKey);
		if (null != distinctKey) {
			queryKey.append(distinctKey);
		}

		Collection<TransactionEvent> col = tEvents.get(queryKey.toString());
		if (null == col)
			return Collections.emptyList();

		return col.stream().filter(txn -> (txn.getTranTimestamp() >= startTs && txn.getTranTimestamp() <= endTs))
				.collect(Collectors.toList());

	}

	public void postTransaction(TransactionEvent te) {

	}

	/**
	 * Get the deviation pattern amount/ count for the given rule and aggKey from
	 * Data Grid
	 */
	public DevPatternCache getDevPatternPerRule(String ruleId, String aggKey) {

		return null;
	}

	/**
	 * Store the given deviation pattern amount/ count for the given rule and aggKey
	 * in DG
	 */
	public void postDevPatternPerRule(DevPatternCache dpct) {

	}
}
