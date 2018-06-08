package com.moneysupermarket.interview.test.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moneysupermarket.interview.test.model.BlockchainInfoResponse;

@RestController
@RequestMapping("/api/bitcoin")
public class BitcoinExchangeController {

	@GetMapping(path="")
	public List<BlockchainInfoResponse> getAllBlockchainCurrencies(){
		return null;
	}
	
	@GetMapping(path="")
	public BlockchainInfoResponse getBlockchainCurrency(@PathVariable("currency") String currency){
		return null;
	}
}
