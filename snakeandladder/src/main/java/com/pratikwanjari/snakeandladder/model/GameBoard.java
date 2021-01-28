package com.pratikwanjari.snakeandladder.model;

import java.util.HashMap;

public class GameBoard { 
	
	private int[][] board ;
	private HashMap<Integer, Integer> snakes;
	private HashMap<Integer, Integer> ladders;
	int row;
	int col;
	
	public GameBoard(int row,int col, HashMap<Integer, Integer> snakes, HashMap<Integer, Integer> ladders) {
		super();
		this.board = new int[row+1][col+1];
		this.snakes = snakes;
		this.ladders = ladders;
		this.col=col;
		this.row=row;
		int count =1;
		for(int i=1;i<=row;i++)
		{
			for(int j=1;j<col;j++)
			{
				board[i][j]=count;
				count++;
			}
		}
		
	}
	
	
	public int getRow() {
		return row;
	}


	public int getCol() {
		return col;
	}


	public int[][] getBoard() {
		return board;
	}
	public HashMap<Integer, Integer> getSnakes() {
		return snakes;
	}

	public HashMap<Integer, Integer> getLadders() {
		return ladders;
	}
	public void setSnakes(HashMap<Integer, Integer> snakes) {
		this.snakes = snakes;
	}
	public void setLadders(HashMap<Integer, Integer> ladders) {
		this.ladders = ladders;
	}
	
	

	
	
}