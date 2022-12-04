package com.nlu.model;


import java.util.ArrayList;

public class BoardStatus {
	Board board;
	ArrayList<ArrayList<ArrayList<Integer>>> listStatus = new ArrayList<>();
	int count = 0;
	ArrayList<Integer> statusPointMans = new ArrayList<>();
	ArrayList<Integer> statusPointBots = new ArrayList<>();
	ArrayList<Integer> heristicStatusBoards = new ArrayList<>();

	public BoardStatus(Board board) {
		super();
		this.board = board;
	}

	public void addStatus() {
		listStatus.add(board.getArrBoard());
		int numberPiecesMan = countPiecesMan(board.getArrBoard());
		int numberPieceBot = countPiecesBot(board.getArrBoard());
		statusPointMans.add(numberPiecesMan);
		statusPointBots.add(numberPieceBot);
		heristicStatusBoards.add(numberPiecesMan - numberPieceBot);
		count++;
	}

	public int countPiecesMan(ArrayList<ArrayList<Integer>> arrBoard) {
		int heristicMan = 0;
		for (ArrayList<Integer> row : arrBoard) {
			for (Integer value : row) {
				if (value == null)
					continue;
				if (value == 1)
					heristicMan++;
			}
		}
		return heristicMan;
	}

	public int countPiecesBot(ArrayList<ArrayList<Integer>> arrBoard) {
		int heristicBot = 0;
		for (ArrayList<Integer> row : arrBoard) {
			for (Integer value : row) {
				if (value == null)
					continue;
				if (value == -1)
					heristicBot++;
			}
		}
		return heristicBot;
	}

	@Override
	public String toString() {
		String result = "";
		int count = 0;
		for (ArrayList<ArrayList<Integer>> arrBoard : listStatus) {

			for (int i = 0; i < arrBoard.size(); i++) {
				result += arrBoard.get(i) + "\t" + "\r";
			}
			Integer numberPiecesMan = statusPointMans.get(count);
			Integer numberPiecesBot = statusPointBots.get(count);
			Integer heristic = heristicStatusBoards.get(count);
			result += "\t" + numberPiecesMan + ":" + numberPiecesBot + "\t heristic:" + heristic + "\r";

			count++;
		}
		return result;
	}
}
