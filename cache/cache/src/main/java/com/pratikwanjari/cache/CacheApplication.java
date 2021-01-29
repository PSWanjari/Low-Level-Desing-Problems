package com.pratikwanjari.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pratikwanjari.cache.Model.Cache;
import com.pratikwanjari.cache.evictionpolicies.EvictionPolicy;
import com.pratikwanjari.cache.evictionpolicies.LRUcahceevictionpolicy;
import com.pratikwanjari.cache.storage.HashMapBasedStorage;
import com.pratikwanjari.cache.storage.Storage;

@SpringBootApplication
public class CacheApplication {

	public static void main(String[] args) {
		//SpringApplication.run(CacheApplication.class, args);
		System.out.println("Hello World");
		
		EvictionPolicy<Integer> evictionPolicy = new LRUcahceevictionpolicy<Integer>();
		Storage<Integer, String> storage = new HashMapBasedStorage<Integer, String>(3);
		Cache<Integer,String> cache = new Cache<Integer, String>(evictionPolicy, storage);
		cache.Put(1, "one");
		cache.Put(2, "two");
		cache.Put(3, "three");
		System.out.print("geting value for key : 6 ");
		System.out.println(cache.Get(6));
		cache.Put(1, "one updated");
		cache.Get(2);
		cache.Get(3);
		System.out.print("geting value for key  3: ");
		System.out.println(cache.Get(3));
		cache.Put(4, "four");
		cache.Put(5, "five");
		cache.Put(6, "six");
		System.out.println("geting value :"+cache.Get(2));
		System.out.println("putting 7");
		cache.Put(7, "seven");
		cache.Get(4);
		cache.Put(4, "four");
	}

}
