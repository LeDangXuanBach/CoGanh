package com.nlu.model;


import java.util.*;

public class Check {
	public static ArrayList<Positon> allPosCanGo(Board board, Chessman chessman) {
		ArrayList<Positon> result = new ArrayList<>();
		ArrayList<Positon> mustMove = new ArrayList<>();

		int row = chessman.getPositon().getRow();
		int col = chessman.getPositon().getCol();

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (i == 0 && j == 0)
					continue;
				int rowMove1 = row + i;
				int colMove1 = col + j;
				if (rowMove1 < 0 || rowMove1 > 4 || colMove1 < 0 || colMove1 > 4)
					continue;

				if (posSpecial(row, col, rowMove1, colMove1))
					continue;
				Integer v = board.posValue(rowMove1, colMove1);
				// vi tri co the di ke tiep phai la null va trong pham vi ban co
				if (v == null && rowMove1 >= 0 && rowMove1 <= 4 && colMove1 >= 0 && colMove1 <= 4) {
					result.add(new Positon(rowMove1, colMove1));
					ArrayList<Positon> listPosTake = listPosTake(board, chessman, rowMove1, colMove1);
					if (isTake(listPosTake)) {
						board.setListPosTake(listPosTake);
						mustMove.add(new Positon(rowMove1, colMove1));
					}
				}

			}
		}
		if (mustMove.size() > 0) {
//			System.out.println("doi phuong da mo duong, ban phai ganh");
//			System.out.println(mustMove);
			return mustMove;
		}
		return result;
	}

	private static boolean isTake(ArrayList<Positon> listPosTake) {
		return listPosTake.size() > 0;
	}

	private static boolean posSpecial(int row, int col, int rowMove1, int colMove1) {
		// vi tri 0;1 va 0;3
		if ((row == 0 && col == 1)
				&& ((rowMove1 == row + 1 && colMove1 == col - 1) || (rowMove1 == row + 1 && colMove1 == col + 1)))
			return true;
		if ((row == 0 && col == 3)
				&& ((rowMove1 == row + 1 && colMove1 == col - 1) || (rowMove1 == row + 1 && colMove1 == col + 1)))
			return true;
		// vi tri 1;0 va 1;4
		if ((row == 1 && col == 0)
				&& ((rowMove1 == row - 1 && colMove1 == col + 1) || (rowMove1 == row + 1 && colMove1 == col + 1)))
			return true;
		if ((row == 1 && col == 4)
				&& ((rowMove1 == row - 1 && colMove1 == col - 1) || (rowMove1 == row + 1 && colMove1 == col - 1)))
			return true;
		// vi tri 3;0 va 3;4
		if ((row == 3 && col == 0)
				&& ((rowMove1 == row - 1 && colMove1 == col + 1) || (rowMove1 == row + 1 && colMove1 == col + 1)))
			return true;
		if ((row == 3 && col == 4)
				&& ((rowMove1 == row - 1 && colMove1 == col - 1) || (rowMove1 == row + 1 && colMove1 == col - 1)))
			return true;
		// vi tri 4;1 va 4;3
		if ((row == 4 && col == 1)
				&& ((rowMove1 == row - 1 && colMove1 == col - 1) || (rowMove1 == row - 1 && colMove1 == col + 1)))
			return true;
		if ((row == 4 && col == 3)
				&& ((rowMove1 == row - 1 && colMove1 == col - 1) || (rowMove1 == row - 1 && colMove1 == col + 1)))
			return true;
		return false;
	}

	public static ArrayList<Positon> listPosTake(Board board, Chessman chessman, int rowMove1, int colMove1) {
		ArrayList<Positon> result = new ArrayList<>();
		try {
			// 2 ben trai phai
			if (board.posValue(rowMove1 + 1, colMove1) == (chessman.getValue() * -1)
					&& board.posValue(rowMove1 - 1, colMove1) == (chessman.getValue() * -1)) {
				System.out.println(1);
				board.posValue(rowMove1 + 1, colMove1);
				board.posValue(rowMove1 - 1, colMove1);
				result.add(new Positon(rowMove1 + 1, colMove1));
				result.add(new Positon(rowMove1 - 1, colMove1));
			}
			// 2 ben tren duoi
			if (board.posValue(rowMove1, colMove1 + 1) == (chessman.getValue() * -1)
					&& board.posValue(rowMove1, colMove1 - 1) == (chessman.getValue() * -1)) {
				System.out.println(2);
				result.add(new Positon(rowMove1, colMove1 + 1));
				result.add(new Positon(rowMove1, colMove1 - 1));
			}
			// 2 ben duong cheo trai qua phai
			if (board.posValue(rowMove1 + 1, colMove1 - 1) == (chessman.getValue() * -1)
					&& board.posValue(rowMove1 - 1, colMove1 + 1) == (chessman.getValue() * -1)) {
				System.out.println(3);
				result.add(new Positon(rowMove1 + 1, colMove1 - 1));
				result.add(new Positon(rowMove1 - 1, colMove1 + 1));
			}
			// 2 ben duong cheo phai qua trai
			if (board.posValue(rowMove1 + 1, colMove1 + 1) == (chessman.getValue() * -1)
					&& board.posValue(rowMove1 - 1, colMove1 - 1) == (chessman.getValue() * -1)) {
				System.out.println(4);
				result.add(new Positon(rowMove1 + 1, colMove1 + 1));
				result.add(new Positon(rowMove1 - 1, colMove1 - 1));
			}
		} catch (Exception e) {
		}
		return result;
	}

}