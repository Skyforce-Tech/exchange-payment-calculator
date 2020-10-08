package com.skyforce.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.skyforce.application.service.CalculatorService;

@RestController
public class CalculatorController {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());  
	
	@Autowired
	CalculatorService calculatorService;
	
	@Autowired
	Environment environment;
	
	@GetMapping("/calculate/{amount}/{date}/{currency}")
	public String calculateAmount(@PathVariable String amount,
			@PathVariable String date,
			@PathVariable String currency) {
		logger.info("Port : {}", environment.getProperty("local.server.port"));
		return calculatorService.calculateExchangeAmount(amount,date, currency);
	}
}
