package com.pratikwanjari.cache.storage;

import java.util.HashMap;
import java.util.Map.Entry;

import com.pratikwanjari.cache.exceptions.KeyNotFoundException;
import com.pratikwanjari.cache.exceptions.StorageFullException;
import com.pratikwanjari.cache.algorithms.*;

public class HashMapBasedStorage<Key,Value> implements Storage<Key,Value> {

	HashMap<Key, Value> hashmap ;
	int max_capacity;
	/*
	 * storage with default capacity
	 */
	public HashMapBasedStorage() {
		super();
		this.max_capacity=capacity;
	}
	
	/*
	 * Storage with custom capatiy
	 */
	public HashMapBasedStorage(int capacity) {
		super();
		this.hashmap  = new HashMap<Key,Value>();
		this.max_capacity=capacity;
	}

	@Override
	public void putKey(Key key,Value value) throws StorageFullException {
		// TODO Auto-generated method stub
		if(hashmap.containsKey(key))
		{
			this.hashmap.put(key,value);
			return;
		}
		if(this.hashmap.size()==max_capacity)
		{
			throw new StorageFullException();
		}
		
		this.hashmap.put(key,value);
		
		
	}

	@Override
	public Value getValue(Key key) throws KeyNotFoundException {
	     
		if(!hashmap.containsKey(key)) {
			System.out.println("Key not found");
			throw new KeyNotFoundException();
		}
		return this.hashmap.get(key);
	}

	@Override
	public void removeKey(Key key) {
	 hashmap.remove(key);
	
	}

	public void printmap()
	{
		System.out.println("printmap");
		for (Entry<Key, Value> item : hashmap.entrySet()) {
			System.out.print(item.getKey()+" | ");
		}
		System.out.println("");
	}
}
