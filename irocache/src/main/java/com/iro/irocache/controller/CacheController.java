package com.iro.irocache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iro.irocache.service.IroCacheDTO;
import com.iro.irocache.service.IroInMemoryCache;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 
 * @author Iro
 *
 */
@RestController
@RequestMapping("/api/v1/cacheLibrary")
@Api(value="onlinestore", description="Operations available in CacheLibrary API")
public class CacheController {
	
	@Autowired
	IroInMemoryCache iroInMemoryCache; 
	
	@GetMapping("/{key}")
	@ApiOperation(value = "Get a value from CacheLibrary")
	public Object getValue(@PathVariable String key) {

	    return iroInMemoryCache.get(key);
	}
	
	@PostMapping("/cacheLibrary")
	@ApiOperation(value = "Add a value to CacheLibrary")
	public void addValue(@RequestBody IroCacheDTO iroCacheDTO) {
	     iroInMemoryCache.add(iroCacheDTO.getKey(), iroCacheDTO.getValue(), iroCacheDTO.getPeriodInMillis());
	 }
	
	@GetMapping("/size")
	@ApiOperation(value = "Get the element count from CacheLibrary")
	public long getSize() {

	    long size =  iroInMemoryCache.size();
	    return size;
	}
	
	@ApiOperation(value = "Remove a value from CacheLibrary")
    @DeleteMapping("/{key}")
    public void remove(@PathVariable String key) {
		iroInMemoryCache.remove(key);
    }

}
