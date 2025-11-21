package com.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Problem: https://leetcode.com/problems/n-queens/description/

public class NQueens51 {
    public static void main(String[] args) {
        var n = 4;
        List<List<String>> result = placeQueens(n);
        System.out.println(result);
    }

    private static List<List<String>> placeQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        List<List<String>> result = new ArrayList<>();
        placeQueens(board, 0, n, result);
        return result;
    }

    private static void placeQueens(char[][] board, int i, int n, List<List<String>> result) {
        if (i == n) {
            List<String> row = new ArrayList<>();
            for (char[] arr : board) {
                row.add(new String(arr));
            }
            result.add(row);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (canPlaceQueen(board, i, j, n)) {
                board[i][j] = 'Q';
                placeQueens(board, i + 1, n, result);
                board[i][j] = '.';
            }
        }
    }

    private static boolean canPlaceQueen(char[][] board, int row, int col, int n) {
        //check all cells in same column above the current position
        for (int i = row; i >= 0; --i) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        var i = row;
        var j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            --i;
            --j;
        }
        i = row;
        j = col;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') {
                return false;
            }
            --i;
            ++j;
        }
        return true;
    }
}
