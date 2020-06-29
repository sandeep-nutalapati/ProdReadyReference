package com.deloitte.prod.application.service;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.prod.application.dao.CurrencyExchangeRepo;
import com.deloitte.prod.application.model.ExchangeValue;

@Service
public class CurrencyExchangeService {
	
	Logger logger= LoggerFactory.getLogger(CurrencyExchangeService.class);
	
	@Autowired
	private CurrencyExchangeRepo currencyExchangeRepo;

	public ExchangeValue exchage(HttpServletRequest request, String from, String to) {
		logger.info("{}",request);
		ExchangeValue ev= currencyExchangeRepo.findByFromAndTo(from, to);
		ev.setPort(request.getServerPort());
		return ev;
	}
	
	

}
