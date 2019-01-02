package com.sample;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlType;

import com.dg.poc.fraud.processors.CacheTransmission;
import com.dm.poc.fraud.Authenticator;
import com.dm.poc.fraud.domain.DevPatternCache;
import com.dm.poc.fraud.domain.Transaction;
import com.dm.poc.fraud.domain.TransactionEvent;

@XmlType(name="TestClass2")
public class RESTConnTest {
	public static void main(String[] args) throws Exception {
		//getDevPatternPerRule("Rule2", "1002837938249");
		//postDevPatternPerRule();
		postTestTransactions();
		//getTransactionEvents("Rule4", "1002837938249", "T1", 1543453801000L, 1543453801000L);
		// test(); 1002837938249 1543453801000
	}

	static void test() throws Exception {
		System.out.println(DATE_FORMAT.parse("20181129:080000000").getTime());
		System.out.println(DATE_FORMAT.parse("20181129:120000000").getTime());
	}

	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd:HHmmssSSS");
	private static final String DM_PUT_TRANS_CACHE = "http://10.91.141.117:8080/webapp02-0.0.1/rs/api/txnRuleCache";
	private static final String DM_GET_TRANS_CACHE = "http://10.91.141.117:8080/webapp02-0.0.1/rs/api/txnRuleCache/q";
	private static final String DM_GET_DEVPATTERN_CACHE = "http://10.91.141.117:8080/webapp02-0.0.1/rs/api/devPatternData/q";
	private static final String DM_PUT_DEVPATTERN_CACHE = "http://10.91.141.117:8080/webapp02-0.0.1/rs/api/devPatternData";

	private static final String RULE_ID = "ruleId";
	private static final String DINST_KEY = "distinctKey";
	private static final String AGG_KEY = "aggKey";
	private static final String START_TS = "fromTxnTs";
	private static final String END_TS = "toTxnTs";

	static void testCon() {
		Client client = ClientBuilder.newClient().register(new Authenticator());
		WebTarget target = client.target("http://10.91.141.116:8080/kie-server/services/rest/server/containers");
		String resp = target.request(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(resp);
		client.close();
	}

	static void postTestTransactions() throws Exception {
//		Client client = ClientBuilder.newClient();
//		WebTarget target = client.target(DM_PUT_TRANS_CACHE);

		// Rule 1 data
		TransactionEvent txn1 = new TransactionEvent("MSDUID1", "Rule1", "1002837938249", "", new BigDecimal(2000),
				new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

		TransactionEvent txn2 = new TransactionEvent("MSDUID2", "Rule1", "1002837938249", "", new BigDecimal(100),
				new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

		TransactionEvent txn3 = new TransactionEvent("MSDUID3", "Rule1", "1002837938249", "", new BigDecimal(3000),
				new Transaction(), DATE_FORMAT.parse("20181129:092000000").getTime());

		TransactionEvent txn4 = new TransactionEvent("MSDUID4", "Rule1", "1002837938249", "", new BigDecimal(109),
				new Transaction(), DATE_FORMAT.parse("20181129:092100000").getTime());

		TransactionEvent txn5 = new TransactionEvent("MSDUID5", "Rule1", "1002837938249", "", new BigDecimal(88),
				new Transaction(), DATE_FORMAT.parse("20181129:093100000").getTime());

		TransactionEvent txn6 = new TransactionEvent("MSDUID6", "Rule1", "1002837938249", "", new BigDecimal(45),
				new Transaction(), DATE_FORMAT.parse("20181129:093501000").getTime());

		// Rule 2 data
		TransactionEvent txn17 = new TransactionEvent("MSDUID17", "Rule2", "1002837938249", "", new BigDecimal(2000),
				new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

		TransactionEvent txn18 = new TransactionEvent("MSDUID18", "Rule2", "1002837938249", "", new BigDecimal(100),
				new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

		TransactionEvent txn19 = new TransactionEvent("MSDUID19", "Rule2", "1002837938249", "", new BigDecimal(3000),
				new Transaction(), DATE_FORMAT.parse("20181129:092000000").getTime());

		TransactionEvent txn20 = new TransactionEvent("MSDUID20", "Rule2", "1002837938249", "", new BigDecimal(109),
				new Transaction(), DATE_FORMAT.parse("20181129:092100000").getTime());

		TransactionEvent txn21 = new TransactionEvent("MSDUID21", "Rule2", "1002837938249", "", new BigDecimal(88),
				new Transaction(), DATE_FORMAT.parse("20181129:093100000").getTime());

		// Rule 3 data
		TransactionEvent txn7 = new TransactionEvent("MSDUID7", "Rule3", "1002837938249M1", "", new BigDecimal(2000),
				new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

		TransactionEvent txn8 = new TransactionEvent("MSDUID8", "Rule3", "1002837938249M1", "", new BigDecimal(100),
				new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

		TransactionEvent txn9 = new TransactionEvent("MSDUID9", "Rule3", "1002837938249M1", "", new BigDecimal(189),
				new Transaction(), DATE_FORMAT.parse("20181129:092000000").getTime());

		TransactionEvent txn10 = new TransactionEvent("MSDUID10", "Rule3", "1002837938249M1", "", new BigDecimal(4000),
				new Transaction(), DATE_FORMAT.parse("20181129:092100000").getTime());

		TransactionEvent txn11 = new TransactionEvent("MSDUID11", "Rule3", "1002837938249M1", "", new BigDecimal(200),
				new Transaction(), DATE_FORMAT.parse("20181129:093100000").getTime());

		// Rule 4 data
		TransactionEvent txn12 = new TransactionEvent("MSDUID12", "Rule4", "1002837938249", "T1", new BigDecimal(2000),
				new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

		TransactionEvent txn13 = new TransactionEvent("MSDUID13", "Rule4", "1002837938249", "T1", new BigDecimal(100),
				new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

		TransactionEvent txn14 = new TransactionEvent("MSDUID14", "Rule4", "1002837938249", "T1", new BigDecimal(189),
				new Transaction(), DATE_FORMAT.parse("20181129:092000000").getTime());

		TransactionEvent txn15 = new TransactionEvent("MSDUID15", "Rule4", "1002837938249", "T1", new BigDecimal(4000),
				new Transaction(), DATE_FORMAT.parse("20181129:092100000").getTime());

		TransactionEvent txn16 = new TransactionEvent("MSDUID16", "Rule4", "1002837938249", "T1", new BigDecimal(200),
				new Transaction(), DATE_FORMAT.parse("20181129:093100000").getTime());

		// Rule 5 data
		TransactionEvent txn22 = new TransactionEvent("MSDUID22", "Rule5", "1002837938249", "", new BigDecimal(2000),
				new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

		TransactionEvent txn23 = new TransactionEvent("MSDUID23", "Rule5", "1002837938249", "", new BigDecimal(100),
				new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

		TransactionEvent txn24 = new TransactionEvent("MSDUID24", "Rule5", "1002837938249", "", new BigDecimal(189),
				new Transaction(), DATE_FORMAT.parse("20181129:092000000").getTime());

		// TransactionEvent txn25 = new TransactionEvent("Rule5", "1002837938249", "",
		// new BigDecimal(4000),
		// new Transaction(), DATE_FORMAT.parse("20181129:092100000").getTime());

		// TransactionEvent txn26 = new TransactionEvent("Rule5", "1002837938249", "",
		// new BigDecimal(200),
		// new Transaction(), DATE_FORMAT.parse("20181129:093100000").getTime());

		// Rule 6 data
		TransactionEvent txn27 = new TransactionEvent("MSDUID27", "Rule6", "1002837938249", "", new BigDecimal(2000),
				new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

		TransactionEvent txn28 = new TransactionEvent("MSDUID28", "Rule6", "1002837938249", "", new BigDecimal(100),
				new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

		TransactionEvent txn29 = new TransactionEvent("MSDUID29", "Rule6", "1002837938249", "", new BigDecimal(189),
				new Transaction(), DATE_FORMAT.parse("20181129:092000000").getTime());

		TransactionEvent txn30 = new TransactionEvent("MSDUID30", "Rule6", "1002837938249", "", new BigDecimal(4000),
				new Transaction(), DATE_FORMAT.parse("20181129:092100000").getTime());

		TransactionEvent txn31 = new TransactionEvent("MSDUID31", "Rule6", "1002837938249", "", new BigDecimal(200),
				new Transaction(), DATE_FORMAT.parse("20181129:093100000").getTime());

		// Rule 7 data
		TransactionEvent txn32 = new TransactionEvent("MSDUID32", "Rule7", "1002837938249", "", new BigDecimal(2000),
				new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

		TransactionEvent txn33 = new TransactionEvent("MSDUID33", "Rule7", "1002837938249", "", new BigDecimal(100),
				new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

		TransactionEvent txn34 = new TransactionEvent("MSDUID34", "Rule7", "1002837938249", "", new BigDecimal(189),
				new Transaction(), DATE_FORMAT.parse("20181129:092000000").getTime());

		TransactionEvent txn35 = new TransactionEvent("MSDUID35", "Rule7", "1002837938249", "", new BigDecimal(4000),
				new Transaction(), DATE_FORMAT.parse("20181129:092100000").getTime());

		TransactionEvent txn36 = new TransactionEvent("MSDUID36", "Rule7", "1002837938249", "", new BigDecimal(200),
				new Transaction(), DATE_FORMAT.parse("20181129:093100000").getTime());

		// Rule 8 data
		TransactionEvent txn37 = new TransactionEvent("MSDUID37", "Rule8", "M1", "", new BigDecimal(2455),
				new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

		TransactionEvent txn38 = new TransactionEvent("MSDUID38", "Rule8", "M1", "", new BigDecimal(243),
				new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

		TransactionEvent txn39 = new TransactionEvent("MSDUID39", "Rule8", "M1", "", new BigDecimal(21),
				new Transaction(), DATE_FORMAT.parse("20181129:092000000").getTime());

		TransactionEvent txn40 = new TransactionEvent("MSDUID40", "Rule8", "M1", "", new BigDecimal(2432),
				new Transaction(), DATE_FORMAT.parse("20181129:092100000").getTime());

		TransactionEvent txn41 = new TransactionEvent("MSDUID41", "Rule8", "M1", "", new BigDecimal(3311),
				new Transaction(), DATE_FORMAT.parse("20181129:093100000").getTime());

		// Rule 9 data
		TransactionEvent txn42 = new TransactionEvent("MSDUID42", "Rule9", "1002837938249", "M1", new BigDecimal(4545),
				new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

		TransactionEvent txn43 = new TransactionEvent("MSDUID43", "Rule9", "1002837938249", "M1", new BigDecimal(311),
				new Transaction(), DATE_FORMAT.parse("20181129:091001000").getTime());

		TransactionEvent txn44 = new TransactionEvent("MSDUID44", "Rule9", "1002837938249", "M1", new BigDecimal(5634),
				new Transaction(), DATE_FORMAT.parse("20181129:092000000").getTime());

		// Rule 10 data
		TransactionEvent txn45 = new TransactionEvent("MSDUID45", "Rule10", "M1", "", new BigDecimal(7336),
				new Transaction(), DATE_FORMAT.parse("20181129:092100000").getTime());

		TransactionEvent txn46 = new TransactionEvent("MSDUID46", "Rule10", "M1", "", new BigDecimal(3311),
				new Transaction(), DATE_FORMAT.parse("20181129:093100000").getTime());

		CacheTransmission.loadTransactionCache(txn1);
		CacheTransmission.loadTransactionCache(txn2);
		CacheTransmission.loadTransactionCache(txn3);
		CacheTransmission.loadTransactionCache(txn4);
		CacheTransmission.loadTransactionCache(txn5);
		CacheTransmission.loadTransactionCache(txn6);
		CacheTransmission.loadTransactionCache(txn7);
		CacheTransmission.loadTransactionCache(txn8);
		CacheTransmission.loadTransactionCache(txn9);
		CacheTransmission.loadTransactionCache(txn10);
		CacheTransmission.loadTransactionCache(txn11);
		CacheTransmission.loadTransactionCache(txn12);
		CacheTransmission.loadTransactionCache(txn13);
		CacheTransmission.loadTransactionCache(txn14);
		CacheTransmission.loadTransactionCache(txn15);
		CacheTransmission.loadTransactionCache(txn16);
		CacheTransmission.loadTransactionCache(txn17);
		CacheTransmission.loadTransactionCache(txn18);
		CacheTransmission.loadTransactionCache(txn19);
		CacheTransmission.loadTransactionCache(txn20);
		CacheTransmission.loadTransactionCache(txn21);
		CacheTransmission.loadTransactionCache(txn22);
		CacheTransmission.loadTransactionCache(txn23);
		CacheTransmission.loadTransactionCache(txn24);
		// CacheTransmission.loadTransactionCache(txn25);
		// CacheTransmission.loadTransactionCache(txn26);
		CacheTransmission.loadTransactionCache(txn27);
		CacheTransmission.loadTransactionCache(txn28);
		CacheTransmission.loadTransactionCache(txn29);
		CacheTransmission.loadTransactionCache(txn30);
		CacheTransmission.loadTransactionCache(txn31);
		CacheTransmission.loadTransactionCache(txn32);
		CacheTransmission.loadTransactionCache(txn33);
		CacheTransmission.loadTransactionCache(txn34);
		CacheTransmission.loadTransactionCache(txn35);
		CacheTransmission.loadTransactionCache(txn36);
		CacheTransmission.loadTransactionCache(txn37);
		CacheTransmission.loadTransactionCache(txn38);
		CacheTransmission.loadTransactionCache(txn39);
		CacheTransmission.loadTransactionCache(txn40);
		CacheTransmission.loadTransactionCache(txn41);
		CacheTransmission.loadTransactionCache(txn42);
		CacheTransmission.loadTransactionCache(txn43);
		CacheTransmission.loadTransactionCache(txn44);
		CacheTransmission.loadTransactionCache(txn45);
		CacheTransmission.loadTransactionCache(txn46);
		
//		target.request().post(Entity.entity(txn1, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn2, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn3, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn4, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn5, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn6, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn7, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn8, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn9, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn10, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn11, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn12, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn13, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn14, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn15, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn16, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn17, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn18, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn19, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn20, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn21, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn22, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn23, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn24, MediaType.APPLICATION_JSON));
//		// target.request().post(Entity.entity(txn25, MediaType.APPLICATION_JSON));
//		// target.request().post(Entity.entity(txn26, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn27, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn28, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn29, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn30, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn31, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn32, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn33, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn34, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn35, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn36, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn37, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn38, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn39, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn40, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn41, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn42, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn43, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn44, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn45, MediaType.APPLICATION_JSON));
//		target.request().post(Entity.entity(txn46, MediaType.APPLICATION_JSON));
//
//		client.close();
	}

	static void getTransactionEvents(String ruleId, String aggKey, String distinctKey, long startTs, long endTs)
			throws Exception {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(DM_GET_TRANS_CACHE);

		ArrayList<TransactionEvent> resp = target.queryParam(RULE_ID, ruleId).queryParam(AGG_KEY, aggKey)
				.queryParam(DINST_KEY, distinctKey).queryParam(START_TS, startTs).queryParam(END_TS, endTs)
				.request(MediaType.APPLICATION_JSON).get(new GenericType<ArrayList<TransactionEvent>>() {
				});
		System.out.println(resp);
		client.close();
	}

	static DevPatternCache getDevPatternPerRule(String ruleId, String aggKey) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(DM_GET_DEVPATTERN_CACHE);

		DevPatternCache resp = target.queryParam(RULE_ID, ruleId).queryParam(AGG_KEY, aggKey)
				.request(MediaType.APPLICATION_JSON).get(DevPatternCache.class);
		System.out.println("Got DevPattern from DG cache.. " + resp);

		client.close();
		return resp;
	}

	static void postDevPatternPerRule() {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(DM_PUT_DEVPATTERN_CACHE);

		DevPatternCache dpct = new DevPatternCache("Rule2", "1002837938249", new BigDecimal(100),
				new Double(1));

		Response resp = target.request().post(Entity.entity(dpct, MediaType.APPLICATION_JSON));
		System.out.println(resp.readEntity(String.class));

		client.close();
	}

}
