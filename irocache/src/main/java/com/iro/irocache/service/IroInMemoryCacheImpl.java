package com.iro.irocache.service;

import java.util.HashMap;
import java.util.Optional;
import org.springframework.stereotype.Service;
/**
 * 
 * @author Iro
 *
 */
@Service
public class IroInMemoryCacheImpl implements IroInMemoryCache{
	
	private static final int CLEAN_UP_PERIOD_IN_SEC = 5;
	 
    private final HashMap<String, IroCacheObject> cache = new HashMap<>();
 
    /**
     * remove values from cache after certain time
     */
    public IroInMemoryCacheImpl() {
        Thread cleanerThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(CLEAN_UP_PERIOD_IN_SEC * 1000);
                    cache.entrySet().removeIf(entry -> Optional.ofNullable(entry.getValue()).map(IroCacheObject::isExpired).orElse(false));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        cleanerThread.setDaemon(true);
        cleanerThread.start();
    }
    
	@Override
    public void add(String key, Object value, long periodInMillis) {
        if (key == null) {
            return;
        }
        if (value == null) {
            cache.remove(key);
        } else {
            long expiryTime = System.currentTimeMillis() + periodInMillis;
            cache.put(key, (new IroCacheObject(value, expiryTime)));
        }
    }
 
    @Override
    public void remove(String key) {
        cache.remove(key);
    }
 
    @Override
    public Object get(String key) {
        return Optional.ofNullable(cache.get(key));
    }
 
    @Override
    public void clear() {
        cache.clear();
    }

	@Override
	public long size() {
		
		return cache.size();

	}
	    
}


