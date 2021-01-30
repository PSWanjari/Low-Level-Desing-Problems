package com.pratikwanjari.fliptweet.model;

public class TextTweet<Value> implements Tweet<Value>{

	private String tweet_id;
	private Value tweet;
	
	public TextTweet(String tweet_id, Value tweet) {
		super();
		this.tweet_id = tweet_id;
		this.tweet = tweet;
	}
	@Override
	public void setTweet(Value tweet) {
	
		this.tweet=tweet;
	}
	@Override
	public Value getTweet() {
		
		return this.tweet;
	}
	@Override
	public String getId() {
		return this.tweet_id;
		
	}
	
	

}
