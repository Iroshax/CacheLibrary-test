package com.iro.irocache.service;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Iro
 *
 */
public class IroCacheObject {
	
	private Object value;
    private long expiryTime;

    public IroCacheObject(Object value, long expiryTime) {
    	this.value = value;
    	this.expiryTime = expiryTime;
	}

	boolean isExpired() {
        return System.currentTimeMillis() > expiryTime;
    }

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
