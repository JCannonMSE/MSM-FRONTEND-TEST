package com.moneysupermarket.interview.test.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.moneysupermarket.interview.test.model.BlockchainInfoResponse;
import com.moneysupermarket.interview.test.service.BitcoinExchangeService;

@RunWith(MockitoJUnitRunner.class)
public class BitcointExchangeControllerTest {

	@Mock
	private BitcoinExchangeService mockService;
	private List<BlockchainInfoResponse> mapOfBlockchainInfoResponses = new ArrayList<>();
	private BlockchainInfoResponse currencyOneResponse = new BlockchainInfoResponse(1111.11, 1111.12, 1111.13, 1111.14, "1ONE");
	private BlockchainInfoResponse currencyTwoResponse = new BlockchainInfoResponse(2222.21, 2222.22, 2222.23, 2222.24, "2TWO");
	private BlockchainInfoResponse differentNameCurrencyResponse = new BlockchainInfoResponse(1234.56, 1234.78, 1234.56, 1234.9, "DIF");
	
	@InjectMocks
	private BitcoinExchangeController underTest;
	
	@Before
	public void setup() {
		mapOfBlockchainInfoResponses.add(differentNameCurrencyResponse);		
		mapOfBlockchainInfoResponses.add(currencyOneResponse);
		mapOfBlockchainInfoResponses.add(currencyTwoResponse);
		Mockito.when(mockService.getBitcoinsFromBlockchain()).thenReturn(mapOfBlockchainInfoResponses);
	}
	
	@Test
	public void testGetAllBlockchainCurrencies() {
		List<BlockchainInfoResponse> testResult = underTest.getAllBlockchainCurrencies();
		int i = 0;
		for (BlockchainInfoResponse entry : testResult) {
			switch(i) {
				case 0:
					assertEquals(currencyOneResponse, entry);
					break;
				case 1:
					assertEquals(currencyTwoResponse, entry);
					break;
				case 2:
					assertEquals(differentNameCurrencyResponse, entry);
					break;
				default:
					fail("Too Many Responses Returned");
					break;
			}
			i++;
		}
	}

	@Test
	public void testGetBlockchainCurrency() {
		fail("Not yet implemented");
	}

}
