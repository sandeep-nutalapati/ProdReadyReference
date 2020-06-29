package com.deloitte.prod.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("currency-conversion-service")
public class CurrencyConfigurationProperties {

	int min;

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public String getExchange_url() {
		return exchange_url;
	}

	public void setExchange_url(String exchange_url) {
		this.exchange_url = exchange_url;
	}

	private String exchange_url;
}
