package com.pratikwanjari.fliptweet.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;import java.util.Map.Entry;

import org.apache.commons.lang3.RandomStringUtils;

import com.pratikwanjari.fliptweet.model.TextTweet;
import com.pratikwanjari.fliptweet.model.Tweet;
import com.pratikwanjari.fliptweet.model.User;

public class FlipTweetOnlinePlatform {
	//local data storage
	private HashMap<User, HashMap<String,Tweet<String>>> user_tweet_mapper;
	//Key: Tweetid, Value : User_name
	private HashMap<String,String> tweetshiddenfrom;
	//private HashMap<String, HashSet<User>> tweetsHideFromMultipleuser ;
	
	public FlipTweetOnlinePlatform() {
		user_tweet_mapper= new HashMap<User, HashMap<String,Tweet<String>>>();
		tweetshiddenfrom= new HashMap<String , String>();
	}
	
	public String addTweet(User user,String tweet)
	{
		String tweettoken = RandomStringUtils.random(8, true, true);
		TextTweet<String> newtweet = new TextTweet<String>(tweettoken,tweet);
		if(user_tweet_mapper.containsKey(user))
		{
			HashMap<String,Tweet<String>> tweets = user_tweet_mapper.get(user);
			tweets.put(tweettoken,newtweet);
			user_tweet_mapper.put(user, tweets);
		}else {
			HashMap<String,Tweet<String>> tweets= new HashMap<String, Tweet<String>>();
			tweets.put(tweettoken,newtweet);
			user_tweet_mapper.put(user, tweets);
		}
		System.out.println("tweet added succesfully");
		return "tweet "+tweet+" id: "+tweettoken;
	}
	public HashMap<String, Tweet<String>> allTweetDoneByUser(User user){
		HashMap<String, Tweet<String>> map =user_tweet_mapper.get(user);
		return map;
				
	}
	
	public HashSet<User> getalluserbyusername(String username)
	{
		HashSet<User> list = new HashSet<User>();
		for (Entry<User, HashMap<String, Tweet<String>>> item : user_tweet_mapper.entrySet()) {
			if(item.getKey().getUser_name().equals(username))
			{
				list.add(item.getKey());
			}
		}
		
		return list;
	}
	
	public void HideTweetFromUser(String tweetid,String username)
	{
		tweetshiddenfrom.put(tweetid, username);
	}
	public void deleteTweetByID(String tweetid)
	{
		for (Entry<User, HashMap<String, Tweet<String>>> item : user_tweet_mapper.entrySet()) {
			item.getValue().remove(tweetid);
		}
	}
}
