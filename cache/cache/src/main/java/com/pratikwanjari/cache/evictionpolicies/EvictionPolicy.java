package com.pratikwanjari.cache.evictionpolicies;

public interface EvictionPolicy<Key> {

	/*
	 * get method to evict the key
	 */
	public Key evictKey();
	
	/*
	 *To make changes when the key is accessed 
	 */
	public void KeyAccessed(Key key);
}
