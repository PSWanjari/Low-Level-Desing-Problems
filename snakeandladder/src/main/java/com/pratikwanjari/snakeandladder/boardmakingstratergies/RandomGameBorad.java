package com.pratikwanjari.snakeandladder.boardmakingstratergies;

import java.util.HashMap;

import com.pratikwanjari.snakeandladder.model.GameBoard;

public class RandomGameBorad implements GameBoardMakingStratergies{
	int board[][];
	@Override
	public GameBoard fillGameBoard(GameBoard gameBoard) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> s = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> l = new HashMap<Integer, Integer>();
		//adding snakes
		s.put(15, 4);
		s.put(22,18);
		s.put(45, 3);
		s.put(34, 24);
		s.put(88, 65);
		s.put(96, 78);
		
		//adding ladderrs
		l.put(4,17);
		l.put(10, 22);
		l.put(22,34);
		l.put(56, 87);
		l.put(45, 93);
		l.put(32,75);
		gameBoard.setLadders(l);
		gameBoard.setSnakes(s);
		return gameBoard;
	}

}
