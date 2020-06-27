package com.deloitte.prod.model;

import java.math.BigDecimal;

/**
 * @author 
 *
 */
public class ProdDetail {

	private Integer appId;
	private String appName;
	private Integer noOfservices;
	private Integer noOfdbCalls;
	private BigDecimal sla;
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public Integer getNoOfservices() {
		return noOfservices;
	}
	public void setNoOfservices(Integer noOfservices) {
		this.noOfservices = noOfservices;
	}
	public Integer getNoOfdbCalls() {
		return noOfdbCalls;
	}
	public void setNoOfdbCalls(Integer noOfdbCalls) {
		this.noOfdbCalls = noOfdbCalls;
	}
	public BigDecimal getSla() {
		return sla;
	}
	public void setSla(BigDecimal sla) {
		this.sla = sla;
	}
	@Override
	public String toString() {
		return "ProdDetail [appId=" + appId + ", appName=" + appName + ", noOfservices=" + noOfservices
				+ ", noOfdbCalls=" + noOfdbCalls + ", sla=" + sla + "]";
	}
	
	
}
