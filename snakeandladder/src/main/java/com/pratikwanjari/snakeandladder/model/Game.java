package com.pratikwanjari.snakeandladder.model;

import java.util.HashMap;
import java.util.List;

public class Game {
	
	private boolean isfinished;
	private GameBoard gameboard;
	private List<Player> playersplaying;
	private int NoOfPlayerPlaying;
	public int getNoOfPlayerPlaying() {
		return NoOfPlayerPlaying;
	}
	
	public boolean isIsfinished() {
		return isfinished;
	}

	public void setIsfinished(boolean isfinished) {
		this.isfinished = isfinished;
	}

	public List<Player> getPlayersplaying() {
		return playersplaying;
	}

	public GameBoard getGameboard() {
		return gameboard;
	}

	public void setGameboard(GameBoard gameboard) {
		this.gameboard = gameboard;
	}

	public Game( GameBoard gameboard,int noofplayer, List<Player> playersplaying,boolean isfinished) {
		super();
		this.gameboard = gameboard;
		this.playersplaying = playersplaying;
		this.NoOfPlayerPlaying=noofplayer;
		this.isfinished=isfinished;
		
	}
	
	
}
