package com.algo.graph;

import java.util.HashSet;
import java.util.Set;
//Problem: https://leetcode.com/problems/word-search/description/

public class WordSearch79 {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        var word = "ABCCED";
        System.out.println(wordExist(board, word));
    }

    //Time complexity O(m * n * 4^length of word
    //m: number of rows
    //n: number of columns
    private static boolean wordExist(char[][] board, String word) {
        Set<Location> visited = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int i, int j, String word, int index, Set<Location> visited) {
        if (index == word.length()) {
            return true;
        }
        var rows = board.length;
        var cols = board[0].length;
        if (i < 0 || i >= rows || j < 0 || j >= cols || index >= word.length()) {
            return false;
        }
        var loc = new Location(i, j);
        if (visited.contains(loc)) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        visited.add(loc);
        var result = dfs(board, i + 1, j, word, index + 1, visited)
                || dfs(board, i - 1, j, word, index + 1, visited)
                || dfs(board, i, j + 1, word, index + 1, visited)
                || dfs(board, i, j - 1, word, index + 1, visited);
        visited.remove(loc);
        return result;
    }

    private record Location(int i, int j) {
    }
}
