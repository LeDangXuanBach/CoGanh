package com.nlu.model;


import java.util.*;

public class Board {
	ArrayList<ArrayList<Integer>> arrBoard = new ArrayList<>(5);
	public ArrayList<Chessman> chesses = new ArrayList<>();
	public BoardStatus boardStatus;
	ArrayList<Positon> listPosTake = null;

	public Board() {
		arrBoard = createArrBoard();
		boardStatus = new BoardStatus(this);
		start();
	}

	public ArrayList<Positon> getListPosTake() {
		return listPosTake;
	}

	public void setListPosTake(ArrayList<Positon> listPosTake) {
		this.listPosTake = listPosTake;
	}

	public ArrayList<ArrayList<Integer>> getArrBoard() {
		return arrBoard;
	}

	public ArrayList<ArrayList<Integer>> createArrBoard() {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>(5);
		for (int j = 0; j < 5; j++) {
			ArrayList<Integer> liChild = new ArrayList<>();
			for (int i = 0; i < 5; i++) {
				liChild.add(null);
			}
			result.add(liChild);
		}
		return result;
	}

	public void start() {
		for (int i = 0; i < 5; i++) {
			chesses.add(new Chessman(1, new Positon(0, i)));
		}
		for (int i = 0; i < 5; i++) {
			chesses.add(new Chessman(-1, new Positon(4, i)));
		}
		chesses.add(new Chessman(1, new Positon(1, 0)));
		chesses.add(new Chessman(1, new Positon(1, 4)));
		chesses.add(new Chessman(1, new Positon(2, 4)));
		chesses.add(new Chessman(-1, new Positon(2, 0)));
		chesses.add(new Chessman(-1, new Positon(3, 0)));
		chesses.add(new Chessman(-1, new Positon(3, 4)));
		update();

	}

	private void update() {
		ArrayList<ArrayList<Integer>> newArrBoard = createArrBoard();
		for (Chessman chessman : chesses) {
			newArrBoard.get(chessman.getPositon().getRow()).set(chessman.getPositon().getCol(), chessman.getValue());
		}
		arrBoard = newArrBoard;
		boardStatus.addStatus();
	}

	public Chessman posChess(int row, int col) {
		for (Chessman chessman : chesses) {
			if (chessman.getPositon().getCol() == col && chessman.getPositon().getRow() == row) {
				return chessman;
			}
		}
		return null;
	}

	public Integer posValue(int row, int col) {
		return arrBoard.get(row).get(col);
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < arrBoard.size(); i++) {
			result += arrBoard.get(i) + "\r";
		}
		return result;
	}

	// control
	public void chessMove(Chessman chessman, Positon pos) {
		for (Positon posTrue : Check.allPosCanGo(this, chessman)) {
			if (posTrue.equal(pos)) {
				chessman.move(pos);
				if (listPosTake != null) {
					ganh(listPosTake);
					listPosTake = null;
				}
				update();
				break;
			}
		}
	}

	public void ganh(ArrayList<Positon> listPosTake) {
		for (Positon pos : listPosTake) {
			for (Chessman chessman : chesses) {
				if (chessman.getPositon().equal(pos)) {
					chessman.setValue(chessman.getValue() * -1);
				}
			}
		}
	}

	public static void main(String[] args) {
		Board board = new Board();
		Chessman chess42 = board.posChess(4, 2);
		Chessman chess02 = board.posChess(0, 2);

		board.chessMove(chess42, new Positon(3, 2));
		board.chessMove(chess42, new Positon(2, 2));
		board.chessMove(chess42, new Positon(2, 3));

		board.chessMove(chess02, new Positon(1, 2));
		board.chessMove(chess02, new Positon(2, 2));
		board.chessMove(chess02, new Positon(3, 3));


		
		
		System.out.println(board.boardStatus);

	}
}

