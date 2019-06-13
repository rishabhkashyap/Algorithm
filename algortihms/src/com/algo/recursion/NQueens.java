package com.algo.recursion;

public class NQueens {

    public static void main(String[] args) {
        int numberOfQueens = 5;
        int[][] board = new int[numberOfQueens][numberOfQueens];
        board[0][0] = 0;
        arrangeQueen(board, 0, numberOfQueens);
    }

    private static boolean arrangeQueen(int[][] board, int i, int numberOfQueens) {
        if (i == numberOfQueens) {
            //Base case
            printBoard(board, numberOfQueens);
            return true;
        }
        for (int j = 0; j < numberOfQueens; j++) {

            //Check is it safe to place queen at current position

            if (isSafeToPlaceQueen(board, i, j, numberOfQueens)) {
                board[i][j] = 1;
                //Check if next queen can be placed at safe place ,if not backtrack and look for
                //new position of current queen
                boolean nextQueenPlaced = arrangeQueen(board, i + 1, numberOfQueens);
                if (nextQueenPlaced) {
                    return true;
                }
                board[i][j] = 0;

            }

        }
        return false;
    }

    //Check for 3 things:
    //1.Is there any queen in previous row but in same column?
    //2.Is there any queen placed at left diagonal?
    //3.Is there any queen placed at right diagonal?


    private static boolean isSafeToPlaceQueen(int[][] board, int i, int j, int numberOfQueens) {

        int x = i;
        int y = j;
        //Checking current column where queen will be placed
        for (int row = 0; row < i; ++row) {
            if (board[row][j] == 1) {
                return false;
            }
        }
        //check left diagonal
        while (x >= 0 && y >= 0) {
            if (board[x][y] == 1) {
                return false;
            }
            --x;
            --y;
        }

        //check right diagonal

        x = i;
        y = j;
        while (x >= 0 && y < numberOfQueens) {
            if (board[x][y] == 1) {
                return false;
            }
            --x;
            ++y;
        }
        return true;


    }

    private static void printBoard(int[][] board, int numberOfQueens) {

        for (int i = 0; i < numberOfQueens; i++) {
            System.out.println();
            for (int j = 0; j < numberOfQueens; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q \t");
                } else {
                    System.out.print("_ \t");
                }
            }
        }
        System.out.println();


    }
}
