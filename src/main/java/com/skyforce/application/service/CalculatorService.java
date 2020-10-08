package com.skyforce.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyforce.application.config.CurrencyExchangeRateAppFeignClient;

@Service
public class CalculatorService {
	
	@Autowired
	CurrencyExchangeRateAppFeignClient client;
	
	public String calculateExchangeAmount(String amount,String date, String currency) {
		return Double.toString(
				Double.parseDouble(amount) * 
				Double.parseDouble(client.getRateWithSpecificDate(date, currency))
				);
	}
}
