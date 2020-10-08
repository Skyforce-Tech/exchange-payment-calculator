package com.skyforce.application.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="sf-api-gateway")
@RibbonClient(name="currency-exchange-rate-app")
public interface CurrencyExchangeRateAppFeignClient {
	
	@RequestMapping(method = RequestMethod.GET, 
			value = "currency-exchange-rate-app/exchangerateapp/v1/getRateForSpecificDate/{userProvidedDate}/{currency}")
	String getRateWithSpecificDate(
			@PathVariable("userProvidedDate") String userProvidedDate,
			@PathVariable("currency") String currency);
}