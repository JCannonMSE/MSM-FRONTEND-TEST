package com.moneysupermarket.interview.test.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moneysupermarket.interview.test.model.BlockchainInfoResponse;

@Service
public class BitcoinExchangeService {

	private static final String HTTPS_BLOCKCHAIN_INFO_TICKER = "https://blockchain.info/ticker";

	private static final TypeReference<HashMap<String, BlockchainInfoResponse>> TYPE_REFERENCE = new TypeReference<HashMap<String, BlockchainInfoResponse>>() {};

	public Map<String, BlockchainInfoResponse> getBitcoinsFromBlockchain() {
		ObjectMapper objectMapper = new ObjectMapper();
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			HttpGet httpGet = new HttpGet(HTTPS_BLOCKCHAIN_INFO_TICKER);
			HttpResponse response = httpClient.execute(httpGet);
			return objectMapper.readValue(response.getEntity().getContent(),
					TYPE_REFERENCE);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
