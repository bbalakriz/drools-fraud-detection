package com.dm.poc.fraud;

import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.dm.poc.fraud.domain.DevPatternCache;
import com.dm.poc.fraud.domain.TransactionEvent;

/**
 * {@link TransactionRepository} implementation that stores the transactions in
 * data grid.
 * 
 */
public class CachedTransactionRepository implements TransactionRepository {

	private static final String DM_GET_TRANS_CACHE = "http://10.91.141.117:8080/webapp02-0.0.1/rs/api/txnRuleCache/q";
	private static final String DM_PUT_TRANS_CACHE = "http://10.91.141.117:8080/webapp02-0.0.1/rs/api/txnRuleCache";
	private static final String DM_GET_DEVPATTERN_CACHE = "http://10.91.141.117:8080/webapp02-0.0.1/rs/api/devPatternData/q";
	private static final String DM_PUT_DEVPATTERN_CACHE = "http://10.91.141.117:8080/webapp02-0.0.1/rs/api/devPatternData";

	/** Local cache - Used only for testing */
	// private static final String DM_PUT_TRANS_CACHE =
	// "http://10.91.141.116:8080/dg-stub/rest/trans/store-trans";
	// private static final String DM_GET_TRANS_CACHE =
	// "http://10.91.141.116:8080/dg-stub/rest/trans/get-hist";

	private static final String RULE_ID = "ruleId";
	private static final String DINST_KEY = "distinctKey";
	private static final String AGG_KEY = "aggKey";
	private static final String START_TS = "fromTxnTs";
	private static final String END_TS = "toTxnTs";

	public CachedTransactionRepository() {
		super();
	}
	/**
	 * Get the historic transactions from Data Grid that matches the given criteria
	 * for the specified time period range
	 */
	@Override
	public Collection<TransactionEvent> getTransactionEvents(String ruleId, String aggKey, String distinctKey,
			long startTs, long endTs) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(DM_GET_TRANS_CACHE);

		ArrayList<TransactionEvent> resp = target.queryParam(RULE_ID, ruleId).queryParam(AGG_KEY, aggKey)
				.queryParam(DINST_KEY, distinctKey).queryParam(START_TS, startTs).queryParam(END_TS, endTs)
				.request(MediaType.APPLICATION_JSON).get(new GenericType<ArrayList<TransactionEvent>>() {
				});
		// for (TransactionEvent te : resp) {
		// System.out.println("Got transaction from DM cache.. " + te);
		// }
		client.close();

		return resp;
	}

	/** Store the given qualified transaction in DG */
	public void postTransaction(TransactionEvent te) {

		Client client = ClientBuilder.newClient();
		client.target(DM_PUT_TRANS_CACHE).request().post(Entity.entity(te, MediaType.APPLICATION_JSON));

		// System.out.println(resp.readEntity(String.class));

		client.close();
	}

	/**
	 * Get the deviation pattern amount/ count for the given rule and aggKey from
	 * Data Grid
	 */
	public DevPatternCache getDevPatternPerRule(String ruleId, String aggKey) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(DM_GET_DEVPATTERN_CACHE);

		DevPatternCache resp = target.queryParam(RULE_ID, ruleId).queryParam(AGG_KEY, aggKey)
				.request(MediaType.APPLICATION_JSON).get(DevPatternCache.class);
		// System.out.println("Got transaction from DevPattern cache.. " + resp);

		client.close();
		return resp;
	}

	/**
	 * Store the given deviation pattern amount/ count for the given rule and aggKey
	 * in DG
	 */
	public void postDevPatternPerRule(DevPatternCache dpct) {

		Client client = ClientBuilder.newClient();
		client.target(DM_PUT_DEVPATTERN_CACHE).request().post(Entity.entity(dpct, MediaType.APPLICATION_JSON));

		// System.out.println(resp.readEntity(String.class));

		client.close();
	}
}
