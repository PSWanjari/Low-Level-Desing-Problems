package com.pratikwanjari.snakeandladder.model;

import java.util.HashMap;

public class Player {
	private String player_name;
	private int position=0;
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Player(String player_name) {
		super();
		this.player_name = player_name;
	}

	
	public String getPlayer_name() {
		return player_name;
	}
	
	
}
