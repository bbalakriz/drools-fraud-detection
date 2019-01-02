package com.dg.poc.fraud.processors;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.Search;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.marshall.ProtoStreamMarshaller;
import org.infinispan.protostream.SerializationContext;
import org.infinispan.protostream.annotations.ProtoSchemaBuilder;
import org.infinispan.protostream.annotations.ProtoSchemaBuilderException;
import org.infinispan.query.dsl.Query;
import org.infinispan.query.dsl.QueryFactory;
import org.infinispan.query.remote.client.ProtobufMetadataManagerConstants;

import com.dm.poc.fraud.domain.TransactionEvent;

public class DGCacheManager {

	private static final String HOTROD_SERVER_LIST = "infinispan.client.hotrod.server_list";
	private static final String PROPERTIES_FILE = "jdg.properties";

	private static RemoteCacheManager cacheManager;
	private RemoteCache<String, Object> cache;

	static {
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.addServers(jdgProperty(HOTROD_SERVER_LIST));
		cacheManager = new RemoteCacheManager(builder.build());
	}

	public DGCacheManager(String cacheName) throws ProtoSchemaBuilderException, IOException {

		cache = cacheManager.getCache(cacheName);
		if (cache == null) {
			throw new RuntimeException(
					"Cache '" + cacheName + "' not found. Please make sure the datagrid server is properly configured");
		}
	}

	public <CacheObject, EntryKey> void addEntryToCache(EntryKey entryKey, CacheObject cacheObject) {
		cache.put((String) entryKey, cacheObject);
	}

	public Object getEntryByKey(String key) {
		return cache.get(key);
	}

	public List<Object> getTxnCacheEntries(String ruleId, String aggKey, String distinctKey, long fromTxnTs,
			long toTxnTs) {

		return cache.values().parallelStream().filter(e -> ((TransactionEvent) e).getRuleId().equals(ruleId))
				.filter(e -> ((TransactionEvent) e).getAggKey().equals(aggKey))
				.filter(e -> ((TransactionEvent) e).getDistinctKey().equals(distinctKey))
				.filter(e -> ((TransactionEvent) e).getTranTimestamp() > fromTxnTs - 1)
				.filter(e -> ((TransactionEvent) e).getTranTimestamp() < toTxnTs + 1).collect(Collectors.toList());
	}

	public Map<String, Object> getAllEntriesAsMap() {
		Map<String, Object> entries = cache.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		return entries;
	}

	public void stop() {
		cacheManager.stop();
	}

	private static String jdgProperty(String name) {
		Properties props = new Properties();
		try {
			props.load(DGCacheManager.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE));
		} catch (IOException ioe) {
			throw new RuntimeException(ioe);
		}
		return props.getProperty(name);
	}

	/************************************************************************************************
	 **************************************** Unused definitions ************************************
	 ************************************************************************************************/

	@SuppressWarnings("unused")
	private static final String JDG_HOST = "jdg.host";
	@SuppressWarnings("unused")
	private static final String HOTROD_PORT = "jdg.hotrod.port";

	@SuppressWarnings("unused")
	private void registerSchemasAndMarshallers() throws ProtoSchemaBuilderException, IOException {
		SerializationContext ctx = ProtoStreamMarshaller.getSerializationContext(cacheManager);

		ProtoSchemaBuilder protoSchemaBuilder = new ProtoSchemaBuilder();
		String transactionEventFile = protoSchemaBuilder.fileName("transactionEvent.proto")
				.packageName("com.dm.poc.fraud.domain").addClass(TransactionEvent.class).build(ctx);

		RemoteCache<String, String> metadataCache = cacheManager
				.getCache(ProtobufMetadataManagerConstants.PROTOBUF_METADATA_CACHE_NAME);
		metadataCache.put("transactionEvent.proto", transactionEventFile);
		String errors = metadataCache.get(ProtobufMetadataManagerConstants.ERRORS_KEY_SUFFIX);
		if (errors != null) {
			throw new IllegalStateException("Some Protobuf schema files contain errors:\n" + errors);
		}
	}

	List<TransactionEvent> queryTransactionEventByParams(String ruleId, String aggKey, String distinctKey,
			long fromTxnTs, long toTxnTs) {
		QueryFactory qf = Search.getQueryFactory(cache);
		Query query = qf.from(TransactionEvent.class).having("ruleId").eq(ruleId).and().having("aggKey").eq(aggKey)
				.and().having("distinctKey").eq(distinctKey).and().having("tranTimestamp").between(fromTxnTs, toTxnTs)
				.build();
		List<TransactionEvent> results = query.list();
		return results;
	}

	public void getAllTxnCacheData() {
		cache.keySet().stream().forEach(key -> System.out.println(key + " = " + cache.get(key)));
	}

}
