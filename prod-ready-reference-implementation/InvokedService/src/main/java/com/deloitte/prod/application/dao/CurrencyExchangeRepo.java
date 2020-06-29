package com.deloitte.prod.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.prod.application.model.ExchangeValue;
@Repository
public interface CurrencyExchangeRepo extends JpaRepository<ExchangeValue, Integer>{

	/**
	 * Here from and to are properties of JPA Entity, so when we define a method frame it 
	 * by starting with findBy(Variable)And(variable)...
	 * JPA will do the implementation and constructs query too  
	 */
	public ExchangeValue findByFromAndTo(String f, String t);
}
