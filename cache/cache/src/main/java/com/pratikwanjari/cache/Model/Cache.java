package com.pratikwanjari.cache.Model;

import com.pratikwanjari.cache.evictionpolicies.EvictionPolicy;
import com.pratikwanjari.cache.exceptions.StorageFullException;
import com.pratikwanjari.cache.storage.Storage;

public class Cache<Key,Value> {
	
	private EvictionPolicy<Key> evictionPolicy;
	private Storage<Key,Value> storage;
	
	public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key,Value> storage) {
		super();
		this.evictionPolicy = evictionPolicy;
		this.storage = storage;
	}
	
	/*
	 * add the key
	 */
	public void Put(Key key,Value value)
	{
		try {
			
			storage.putKey(key,value);
			evictionPolicy.KeyAccessed(key);
			System.out.println("putting key "+key+" value "+value);
		}catch (StorageFullException e) {
			// TODO: handle exception
			System.out.println("Storage full");
			Key removekey = evictionPolicy.evictKey();
			System.out.println("evict key "+removekey);
			storage.removeKey(removekey);
			storage.putKey(key,value);
			evictionPolicy.KeyAccessed(key);
			System.out.println("putting key "+key+" value "+value);
		}
		
		
	}
	
	/*
	 * get key
	 */
	public Value Get(Key key)
	{ 
		Value value=null;
		try {
			
			value =storage.getValue(key);
			System.out.println(value);
			evictionPolicy.KeyAccessed(key);
			
		
		}catch (Exception e) {
			System.out.println("Hit the database to get value for key "+key);
		}
		
		return value;
	}
	
	
	
	
	
}
