package com.dg.poc.fraud.processors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.dm.poc.fraud.domain.DevPatternCache;
import com.dm.poc.fraud.domain.TransactionEvent;

public class CacheTransmission {

	private static final String PROPERTIES_FILE = "jdg.properties";
	static final String TRANS_EVENT_CACHE;
	static final String STATIC_LIST_CACHE;
	static final String DEV_PATTERN_CACHE;

	
	static {
		TRANS_EVENT_CACHE = jdgProperty("jdg.txnCacheName");
		STATIC_LIST_CACHE = jdgProperty("jdg.staticListCacheName");
		DEV_PATTERN_CACHE = jdgProperty("jdg.devPaternCacheName");
	}

	public static String loadTransactionCache(TransactionEvent txnObject) throws IOException {

		DGCacheManager manager = new DGCacheManager(TRANS_EVENT_CACHE);
		manager.addEntryToCache(txnObject.getRuleId() + txnObject.getMsgUId(), txnObject);
		//manager.stop();
		return "Transaction Event stored successfully in cache..!!";
	}

//	public String loadStaticListCache(String body) throws JsonParseException, JsonMappingException, IOException {
//
//		ObjectMapper StaticDataCacheMapper = new ObjectMapper();
//		TypeReference<List<StaticListCacheModel>> mapType = new TypeReference<List<StaticListCacheModel>>() {
//		};
//		List<StaticListCacheModel> jsonToPersonList = StaticDataCacheMapper.readValue(body, mapType);
//
//		DGCacheManager manager = new DGCacheManager(STATIC_LIST_CACHE);
//
//		jsonToPersonList.forEach(e -> {
//			manager.addEntryToCache(e.getEntryKey(), e.getEntryValue());
//
//		});
//		//manager.stop();
//		return ("Static Cache loaded with " + jsonToPersonList.size() + " Entries");
//	}

	public static String loadDevPatternDataCache(DevPatternCache dpct) throws IOException {

		DGCacheManager manager = new DGCacheManager(DEV_PATTERN_CACHE);
		manager.addEntryToCache(dpct.getRuleId() + dpct.getAggKey(), dpct);
		//manager.stop();
		return ("DevPatternCache is loaded successfully");

	}

	public static List<Object> readTxnCache(String ruleId, String aggKey, String distinctKey, long startTs,
			long endTs) throws IOException {

		DGCacheManager manager = new DGCacheManager(TRANS_EVENT_CACHE);
		List<Object> entries = new ArrayList<>(manager.getTxnCacheEntries(ruleId, aggKey, distinctKey, Long.valueOf(startTs),
				Long.valueOf(endTs)));
		//manager.stop();
		return entries;
	}

	public static DevPatternCache readDevPatternCache(String ruleId, String aggKey) throws IOException {

		DGCacheManager manager = new DGCacheManager(DEV_PATTERN_CACHE);
		DevPatternCache dpct = (DevPatternCache) manager.getEntryByKey(ruleId + aggKey);
		// manager.stop();
		return (dpct);
	}

	public Map<String, Object> readStaticListCache() throws IOException {

		DGCacheManager manager = new DGCacheManager(STATIC_LIST_CACHE);

		Map<String, Object> entries = manager.getAllEntriesAsMap();
		//manager.stop();
		return (entries);
	}

	public Collection<Object> getAllCacheData(String cacheName) throws IOException {

		DGCacheManager manager = new DGCacheManager(cacheName);
		Map<String, Object> entries = manager.getAllEntriesAsMap();
		//manager.stop();
		return (entries.values());

	}

	public void readCacheDataByKey(String cacheName, String entryKey) throws IOException {

		DGCacheManager manager = new DGCacheManager(cacheName);
		Object value = manager.getEntryByKey(entryKey);
		System.out.println("The Cache Entry is : " + value);
		//manager.stop();
	}

	public static String jdgProperty(String name) {
		Properties props = new Properties();
		try {
			props.load(DGCacheManager.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE));
		} catch (IOException ioe) {
			throw new RuntimeException(ioe);
		}
		return props.getProperty(name);
	}
}
