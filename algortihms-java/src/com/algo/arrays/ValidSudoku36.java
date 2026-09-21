package com.algo.arrays;

import java.util.HashSet;
import java.util.Set;

//Problem: https://leetcode.com/problems/valid-sudoku/description/
//Problem: https://leetcode.com/problems/valid-sudoku/description/
public class ValidSudoku36 {
    static void main() {
        char[][] board = {{'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku1(board));
        System.out.println(isValidSudoku2(board));
    }

    //Naive and easiest solution
    private static boolean isValidSudoku1(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (!set.add("row:" + i + ":" + board[i][j]) || !set.add("col:" + j + ":" + board[i][j])
                            || !set.add("zone:" + i / 3 + "_" + j / 3 + ":" + board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //bitmask solution
    private static boolean isValidSudoku2(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] box = new int[9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int mask = 1 << (board[i][j] - '0');
                    var boxId = (i / 3 * 3) + j / 3;
                    if (((row[i] & mask) != 0) || ((col[j] & mask) != 0)
                            || ((box[boxId] & mask) != 0)) {
                        return false;
                    }
                    row[i] |= mask;
                    col[j] |= mask;
                    box[boxId] |= mask;
                }
            }
        }
        return true;
    }


}
