package com.sample;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

import org.drools.core.ClassObjectFilter;
import org.drools.core.ObjectFilter;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.dm.poc.fraud.domain.PotentialFraudFact;
import com.dm.poc.fraud.domain.Transaction;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * This is a sample class to launch a rule.
 */
@XmlType(name = "TestClass1")
public class DMTest {

	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd:HHmmssSSS");

	static final Integer[] highRiskMerchantCatArray = new Integer[] { 7999, 8011, 8021, 8031, 8041, 8042, 8043, 8044 };
	static final Integer[] mccArray = new Integer[] { 7000, 8011, 8021, 8031, 8041, 8042, 8043, 8044 };
	static final String[] ctryArray = new String[] { "SG", "MY", "IN", "BR" };
	static final String[] exclCardIdArray = new String[] { "1002837938249", "1002837938290", "2002837938249",
			"1002937938249" };
	static final Integer[] mccArray2 = new Integer[] { 7000, 8011, 8021, 8031, 8041, 8042, 8043, 8044 };
	static final String[] exclCardIdArray2 = new String[] { "1002837938249", "3562837938290", "4563437938249",
			"4874937938249" };
	static final String[] mechArray2 = new String[] { "3656", "M1", "3283", "60876" };
	static final String[] mechArray3 = new String[] { "34534", "M1", "2211", "5622" };
	static final String[] mechArray4 = new String[] { "M1", "T7338", "8743", "38783" };
	static final String[] cardIdArray4 = new String[] { "10028379382491", "3143324232343", "3434343434644",
			"2324324324323" };
	static final String[] amexCardIdArray = new String[] { "1002837938249", "3143324232343", "3434343434644",
			"2324324324323" };
	static final String[] tweaMechIdArray = new String[] { "3656", "M1", "3283", "60876" };

	static final List<Integer> highRiskMerchantCatList = Arrays.asList(highRiskMerchantCatArray);
	static final List<Integer> mccList = Arrays.asList(mccArray);
	static final List<String> ctryList = Arrays.asList(ctryArray);
	static final List<String> exclCardIdList = Arrays.asList(exclCardIdArray);
	static final List<Integer> mccList2 = Arrays.asList(mccArray2);
	static final List<String> exclCardIdList2 = Arrays.asList(exclCardIdArray2);
	static final List<String> mechList2 = Arrays.asList(mechArray2);
	static final List<String> mechList3 = Arrays.asList(mechArray3);
	static final List<String> mechList4 = Arrays.asList(mechArray4);
	static final List<String> cardIdList4 = Arrays.asList(cardIdArray4);
	static final List<String> tweaMechIdList = Arrays.asList(tweaMechIdArray);
	static final List<String> amexCardIdList = Arrays.asList(amexCardIdArray);

	public static final void main(String[] args) throws Exception {
		long startTime = System.currentTimeMillis();
		// triggerRule2And10();
		jsonParsing();
		System.out.println(System.currentTimeMillis() - startTime + " ms");
		// System.out.println(new Timestamp(System.currentTimeMillis()).toString());;
	}

	static void jsonParsing() throws IOException {
		ObjectFilter filter = new ObjectFilter() {
			@Override
			public boolean accept(Object object) {
				return object.getClass().getName().equals("com.dm.poc.fraud.domain.PotentialFraudFact");
			}
		};

		Gson gs = new Gson();
		PotentialFraudFact pffIn = new PotentialFraudFact();
		ArrayList<Transaction> a = new ArrayList<Transaction>();
		Transaction e = new Transaction();
		e.setAmt(new BigDecimal(100));
		a.add(e);

		pffIn.setTransactions(a);
		// GetObjectsCommand goc = new GetObjectsCommand(filter);
		// new ClassObjectSerializationFilter(new ClassObjectFilter(new
		// PotentialFraudFact().getClass())));
		// goc.setOutIdentifier("out");

		// String jsonString = gs.toJson(pffIn);

		String jsonString = new String(Files
				.readAllBytes(Paths.get("/home/bbalasub/MyWork/Customers/DBS/rhdm-dm-poc-working-outputs-Nov16.json")));
		JsonObject pff = gs.fromJson(jsonString, JsonObject.class);
		JsonArray jsArray = pff.getAsJsonObject().getAsJsonObject("result").getAsJsonObject("execution-results")
				.getAsJsonArray("results").get(1).getAsJsonObject().getAsJsonArray("value");//.getAsJsonArray();
		
		for (int i = 0; i < jsArray.size(); i++) {
			System.out.println(jsArray.get(i).getAsJsonObject().has(("com.dm.poc.fraud.domain.PotentialFraudFact")));
		}
	}

	static void testAllRules() {

		try {

			Transaction transaction = new Transaction();
			transaction.setAmt(new BigDecimal(1000));
			transaction.setMsgUID("MSG1");
			transaction.setRqClientId("GCSP");
			transaction.setMerchantId("M1");
			transaction.setMerchantCat(8011);// Activate Rule 3
			transaction.setMerchantCat(7692);// Activate Rule 1
			transaction.setMerchantCat(7000);// Activate Rule 5,6
			transaction.setRiskScore(100);
			transaction.setCardId("1002837938249");
			transaction.setCardBrand("VISA");
			transaction.setCardPresent(2);
			transaction.setCrdAccptStcry("GRC"); // Activate Rule 2
			// t.setCrdAccptStcry("MY"); // Activate Rule 1
			// t.setTerminalId("T1");// Activate Rule 4
			transaction.setCrdAccptStcry("BR"); // Activate Rule 5,6
			transaction.setTranCur("USD"); // Activate Rule 7
			transaction.setTranStatusReason("V_091");// Activate Rule 7
			transaction.setTranCur("SGD"); // Activate Rule 8
			transaction.setTranStatusReason("V_00");// Activate Rule 8
			transaction.setCrdAccptStcry("BR"); // Activate Rule 9

			transaction.setTranTimestamp(DATE_FORMAT.parse("20181129:093601000").getTime()); // 1543455361000

			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("fd-session-stateful");

			// set the agenda group to execute
			// kSession.getAgenda().getAgendaGroup("NO_PRIO_RULES").setFocus();
			// kSession.getAgenda().getAgendaGroup("PRIO_RULES").setFocus();

			// set global variables
			kSession.setGlobal("highRiskMerchantCatList", highRiskMerchantCatList);
			kSession.setGlobal("mccList", mccList);
			kSession.setGlobal("mccList2", mccList2);
			kSession.setGlobal("ctryList", ctryList);
			kSession.setGlobal("exclCardIdList", exclCardIdList);
			kSession.setGlobal("exclCardIdList2", exclCardIdList2);
			kSession.setGlobal("mechList2", mechList2);
			kSession.setGlobal("mechList3", mechList3);
			kSession.setGlobal("mechList4", mechList4);
			kSession.setGlobal("cardIdList4", cardIdList4);

			// go !
			kSession.insert(transaction);
			kSession.fireAllRules();
			kSession.dispose();
		} catch (Throwable t) {
			t.printStackTrace();
		}

	}

	// Change noOfTransactions in rule to 4 to test locally
	public static void triggerRule4() {
		Transaction transaction = new Transaction();
		transaction.setAmt(new BigDecimal(1111));
		transaction.setMsgUID("MSGUID1000");
		transaction.setRqClientId("GCSP");
		transaction.setMerchantId("M1");
		transaction.setTerminalId("T1");// Activate Rule 4
		transaction.setMerchantCat(6011);// Activate Rule 1
		transaction.setRiskScore(100);
		transaction.setCardId("1002837938249");
		transaction.setCardBrand("VISA");
		transaction.setCardPresent(2);
		transaction.setCrdAccptStcry("BR"); // Activate Rule 1
		try {
			transaction.setTranTimestamp(DATE_FORMAT.parse("20181129:093601000").getTime()); // 1543455361000

			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("fd-session-stateful");

			// set the agenda group to execute
			// kSession.getAgenda().getAgendaGroup("NO_PRIO_RULES").setFocus();
			// kSession.getAgenda().getAgendaGroup("PRIO_RULES").setFocus();

			// set global variables
			kSession.setGlobal("highRiskMerchantCatList", highRiskMerchantCatList);
			kSession.setGlobal("mccList", mccList);
			kSession.setGlobal("mccList2", mccList2);
			kSession.setGlobal("ctryList", ctryList);
			kSession.setGlobal("exclCardIdList", exclCardIdList);
			kSession.setGlobal("exclCardIdList2", exclCardIdList2);
			kSession.setGlobal("mechList2", mechList2);
			kSession.setGlobal("mechList3", mechList3);
			kSession.setGlobal("mechList4", mechList4);
			kSession.setGlobal("cardIdList4", cardIdList4);

			// go !
			kSession.insert(transaction);

			System.out.println("================= Begin triggerRules4 =================");
			kSession.fireAllRules();

			StringBuilder sb = new StringBuilder();
			for (Object f : findFacts(kSession, "com.dm.poc.fraud.domain.PotentialFraudFact")) {
				sb.append(f.toString());
			}

			if (true == sb.toString().contains("ruleId=4") && true == sb.toString().contains("ruleId=10")) {
				System.out.println("Success criteria met for triggerRules4");
			} else {
				System.err.println("Failed triggerRules4");
			}

			kSession.dispose();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public static void triggerRule1And10() {
		Transaction transaction = new Transaction();
		transaction.setAmt(new BigDecimal(1000));
		transaction.setMsgUID("MSG1");
		transaction.setRqClientId("GCSP");
		transaction.setMerchantId("M1");
		transaction.setMerchantCat(7692);// Activate Rule 1
		transaction.setRiskScore(100);
		transaction.setCardId("1002837938249");
		transaction.setCardBrand("VISA");
		transaction.setCardPresent(2);
		transaction.setCrdAccptStcry("MY"); // Activate Rule 1
		try {
			transaction.setTranTimestamp(DATE_FORMAT.parse("20181129:093601000").getTime()); // 1543455361000

			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("fd-session-stateful");

			// set the agenda group to execute
			// kSession.getAgenda().getAgendaGroup("NO_PRIO_RULES").setFocus();
			// kSession.getAgenda().getAgendaGroup("PRIO_RULES").setFocus();

			// set global variables
			kSession.setGlobal("highRiskMerchantCatList", highRiskMerchantCatList);
			kSession.setGlobal("mccList", mccList);
			kSession.setGlobal("mccList2", mccList2);
			kSession.setGlobal("ctryList", ctryList);
			kSession.setGlobal("exclCardIdList", exclCardIdList);
			kSession.setGlobal("exclCardIdList2", exclCardIdList2);
			kSession.setGlobal("mechList2", mechList2);
			kSession.setGlobal("mechList3", mechList3);
			kSession.setGlobal("mechList4", mechList4);
			kSession.setGlobal("cardIdList4", cardIdList4);

			// go !
			kSession.insert(transaction);

			System.out.println("================= Begin triggerRules1And10 =================");
			kSession.fireAllRules();

			StringBuilder sb = new StringBuilder();
			for (Object f : findFacts(kSession, "com.dm.poc.fraud.domain.PotentialFraudFact")) {
				sb.append(f.toString());
			}

			if (true == sb.toString().contains("ruleId=1") && true == sb.toString().contains("ruleId=10")) {
				System.out.println("Success criteria met for triggerRules1And10");
			} else {
				System.err.println("Failed triggerRules1And10");
			}

			kSession.dispose();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public static void triggerRule2And10() {
		Transaction transaction = new Transaction();
		transaction.setAmt(new BigDecimal(1000));
		transaction.setMsgUID("MSG1");
		transaction.setRqClientId("GCSP");
		transaction.setMerchantId("M1");
		transaction.setMerchantCat(7692);// Activate Rule 1
		transaction.setRiskScore(100);
		transaction.setCardId("1002837938249");
		transaction.setCardBrand("VISA");
		transaction.setCardPresent(2);
		transaction.setCrdAccptStcry("BRA"); // Activate Rule 2

		try {

			transaction.setTranTimestamp(DATE_FORMAT.parse("20181129:093601000").getTime()); // 1543455361000

			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("fd-session-stateful");

			// set the agenda group to execute
			// kSession.getAgenda().getAgendaGroup("NO_PRIO_RULES").setFocus();
			// kSession.getAgenda().getAgendaGroup("PRIO_RULES").setFocus();

			// set global variables
			kSession.setGlobal("highRiskMerchantCatList", highRiskMerchantCatList);
			kSession.setGlobal("mccList", mccList);
			kSession.setGlobal("mccList2", mccList2);
			kSession.setGlobal("ctryList", ctryList);
			kSession.setGlobal("exclCardIdList", exclCardIdList);
			kSession.setGlobal("exclCardIdList2", exclCardIdList2);
			kSession.setGlobal("mechList2", mechList2);
			kSession.setGlobal("mechList3", mechList3);
			kSession.setGlobal("mechList4", mechList4);
			kSession.setGlobal("cardIdList4", cardIdList4);
			kSession.setGlobal("tweaMerchantIdList", tweaMechIdList);
			kSession.setGlobal("amexCardList", amexCardIdList);

			// go !
			kSession.insert(transaction);
			System.out.println("================= Begin testRule2 =================");
			kSession.fireAllRules();

			StringBuilder sb = new StringBuilder();
			for (Object f : findFacts(kSession, "com.dm.poc.fraud.domain.PotentialFraudFact")) {
				sb.append(f.toString());
			}

			if (true == sb.toString().contains("ruleId=2") && true == sb.toString().contains("ruleId=10")) {
				System.out.println("Success criteria met for testRule2");
			} else {
				System.err.println("Failed testRule2");
			}

			kSession.dispose();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public static Collection<Object> findFacts(final KieSession session, final String factClass) {
		ClassObjectFilter filter = new ClassObjectFilter(PotentialFraudFact.class);
		Collection<Object> results = (Collection<Object>) session.getObjects(filter);
		return results;
	}

	public static Collection<Object> findFactsz(final KieSession session, final String factClass) {
		ObjectFilter filter = new ObjectFilter() {
			@Override
			public boolean accept(Object object) {
				// System.out.println(object.getClass().getName() + " : " + factClass);
				return object.getClass().getName().equals(factClass);
			}
		};

		@SuppressWarnings("unchecked")
		Collection<Object> results = (Collection<Object>) session.getObjects(filter);
		return results;
	}

	public static void maine3213(String[] args) throws Exception {
		DateFormat DATE_FORMAT_NEW = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(DATE_FORMAT_NEW.parse("2020-06-10 16:50:28").getTime());
	}
}
