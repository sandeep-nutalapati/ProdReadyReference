package com.deloitte.prod.application.model;

import java.math.BigDecimal;

public class CurrencyConversionDto {

	private Integer id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal calcAmount;
	private Integer port;

	public CurrencyConversionDto() {
	}

	public CurrencyConversionDto(Integer id, String from, String to, BigDecimal conversionMultiple,
			BigDecimal quantity, BigDecimal calcAmount) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.calcAmount = calcAmount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getCalcAmount() {
		return calcAmount;
	}

	public void setCalcAmount(BigDecimal calcAmount) {
		this.calcAmount = calcAmount;
	}
	
	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

}
