package com.pratikwanjari.cache.evictionpolicies;

import java.util.HashMap;

import com.pratikwanjari.cache.algorithms.DoubleLinkedList;
import com.pratikwanjari.cache.algorithms.Node;
import com.pratikwanjari.cache.storage.Storage;

public class LRUcahceevictionpolicy<Key> implements EvictionPolicy<Key>{

	
	private DoubleLinkedList<Key> dll ;
	
	HashMap<Key, Node<Key>> mapper = new HashMap<Key, Node<Key>>();
	public LRUcahceevictionpolicy() {
		super();
		this.dll = new DoubleLinkedList<Key>();
	}

	@Override
	public Key evictKey() {
		
		Key key= dll.remove().getElement();
		mapper.remove(key);
		return key;
	}

	@Override
	public void KeyAccessed(Key key) {
		// TODO Auto-generated method stub
		if(mapper.containsKey(key))
		{
			
			Node<Key> node = mapper.get(key);
			dll.detachNodeAndmovetolast(node);
		}else {
			Node<Key> newnode = dll.addKey(key);
			mapper.put(key, newnode);
		}
		
	}

	

}
