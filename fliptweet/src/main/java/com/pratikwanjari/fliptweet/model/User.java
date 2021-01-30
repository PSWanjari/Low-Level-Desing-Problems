package com.pratikwanjari.fliptweet.model;


import java.util.HashSet;

public class User {
	private String user_name;
	/*
	 * followers : Store the users following this users
	 * following : stores the user followed by this users
	 */
	private HashSet<String> followers;
	private HashSet<String> following;
	
	public User(String name) {
		this.user_name=name;
		followers= new HashSet<String>();
		following=new HashSet<String>();
	}
	public String getUser_name() {
		return user_name;
	}

	public HashSet<String> getFollowers() {
		return followers;
	}
	public void setFollowers(HashSet<String> followers) {
		this.followers = followers;
	}
	public HashSet<String> getFollowing() {
		return following;
	}
	public void setFollowing(HashSet<String> following) {
		this.following = following;
	}
	
	
}
