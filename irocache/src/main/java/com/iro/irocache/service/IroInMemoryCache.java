package com.iro.irocache.service;

import org.springframework.stereotype.Service;

@Service
public interface IroInMemoryCache {
	
	void add(String key, Object value, long periodInMillis);
	 
    void remove(String key);
 
    Object get(String key);
 
    void clear();
 
    long size();

}
