package com.iro.irocache.service;

public class IroCacheDTO {
	
	private Object value;
	private String key;
	private long periodInMillis;
	
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public long getPeriodInMillis() {
		return periodInMillis;
	}
	public void setPeriodInMillis(long periodInMillis) {
		this.periodInMillis = periodInMillis;
	}

}
