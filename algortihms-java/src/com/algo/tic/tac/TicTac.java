package com.algo.tic.tac;

import java.util.Scanner;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class TicTac {
	static int movesNumber = 0;

	public static void main(String[] args) {

		Move[][] playerMove = { 
				{ Move.O, Move.O, Move.X }, 
				{ Move.O, Move.X, Move.O },
				{ Move.X, Move.X, Move.O } };

		Move[][] ticTacToe = new Move[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				ticTacToe[i][j] = Move.BLANK;
			}
		}

		Move move = null;
		
			boolean isWinner=false;
			// System.out.print("Enter x ,y separated by space");
			// Scanner scanner = new Scanner(System.in);
			// int x = scanner.nextInt();
			// int y = scanner.nextInt();
			// System.out.println("Enter ur move");
			// String userMove = scanner.next();
			for (int i = 0; i < playerMove.length; i++) {
				for (int j = 0; j < playerMove.length; j++) {
					isWinner=playTicTac(ticTacToe, i, j, playerMove[i][j]);
					++movesNumber;
					if(isWinner) {
						break;
					}
					

				}
				if(isWinner) {
					break;
				}
			}
		    if(!isWinner && movesNumber==9) {
		    	System.out.println("Game draw !!");
		    }
			// if (userMove.equalsIgnoreCase("x")) {
			// move = Move.X;
			// } else if (userMove.equalsIgnoreCase("o")) {
			// move = Move.O;
			// } else {
			// move = Move.BLANK;
			// }

			// playTicTac(ticTacToe, x, y, move);
			// ++movesNumber;
		

	}

	private static boolean playTicTac(Move[][] ticTacToe, int i, int j, Move move) {
		boolean isWinner = true;
		if (movesNumber < 9) {
			// set players move into matrix
			if (ticTacToe[i][j] == Move.BLANK) {
				ticTacToe[i][j] = move;
			}

			// check row
			for (int k = 0; k < 3; k++) {
				if (ticTacToe[i][k] == move) {
					continue;
				} else {
					isWinner = false;
					break;
				}
			}
			if (isWinner) {
				System.out.println("Winner = " + move.toString());
				return isWinner;
			}
			isWinner = true;

			// check column
			for (int k = 0; k < 3; k++) {
				if (ticTacToe[k][j] == move) {
					continue;
				} else {
					isWinner = false;
					break;
				}
			}
			if (isWinner) {
				System.out.println("Winner = " + move.toString());
				return isWinner;
			}

			// check principal diagonals
			if (i == j) {
				isWinner = true;
				for (int k = 0; k < 3; k++) {
					if (ticTacToe[k][k] == move) {
						continue;
					} else {
						isWinner = false;
						break;
					}
				}

			}

			if (isWinner) {
				System.out.println("Winner = " + move.toString());
				return isWinner;
			}

			// check secondary diagonal
			if ((i + j) == ticTacToe.length - 1) {
				isWinner = true;
				for (int k = 0; k < 3; k++) {
					if (ticTacToe[k][(ticTacToe.length - 1) - k] == move) {
						continue;
					} else {
						isWinner = false;
						break;
					}
				}
			}
			if (isWinner) {
				System.out.println("Winner = " + move.toString());
				return isWinner;
			}
			// if none of the above condition is not true and matrix is not yet full
			// allow player to make a move
			return isWinner;

		} else {
			System.out.println("Game draw!!");
			return isWinner;
		}

	}

}
