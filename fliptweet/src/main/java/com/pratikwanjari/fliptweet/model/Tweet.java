package com.pratikwanjari.fliptweet.model;

public interface Tweet<Value> {
	/*
	 * method to set tweet
	 */
	void setTweet(Value tweet);
	
	/*
	 * method to get tweet
	 */
	Value getTweet();	
	
	/*
	 * method to get id
	 */
	String getId();
	
}
