package com.pratikwanjari.cache.storage;

import com.pratikwanjari.cache.algorithms.Node;
import com.pratikwanjari.cache.exceptions.StorageFullException;

public interface Storage<Key,Value> {
	
	int capacity = 5;
	/*
	 * Put the key in the storage 
	 */
	void putKey(Key key,Value value);
	
	/*
	 * Get Key from the storage
	 */
	Value getValue(Key key);
	
	/*
	 * Remove the key from storage
	 * 
	 */
	void removeKey(Key key);
}
