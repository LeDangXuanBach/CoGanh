package com.nlu.model;


public class Positon {
	int row;
	int col;

	public Positon(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public boolean equal(Positon posOthers) {
		return row == posOthers.row && col == posOthers.col;
	}

	@Override
	public String toString() {
		return "(" + row + "," + col + ")";
	}

}
