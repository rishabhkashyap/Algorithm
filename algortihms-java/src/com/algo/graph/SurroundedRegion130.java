package com.algo.graph;

import java.util.LinkedList;
import java.util.Queue;

//Problem: https://leetcode.com/problems/surrounded-regions/description/
public class SurroundedRegion130 {
    public static void main(String[] args) {
        char[][] board = {{'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O'}};
        changeBoard(board);
        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
    }

    private static void changeBoard(char[][] board) {
        var rows = board.length;
        var cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //check for cell that is 0 and a border cell
                //Both BFS and DFS works for this approach
                if (board[i][j] == 'O' && (i == 0 || j == 0 || i == rows - 1 || j == cols - 1)) {
                    performDFS(board, i, j);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void performDFS(char[][] board, int i, int j) {
        var rows = board.length;
        var cols = board[0].length;
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return;
        }
        if (board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'T';
        int[][] neighbours = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] neighbour : neighbours) {
            performDFS(board, i + neighbour[0], j + neighbour[1]);
        }
    }

    private static void performBFS(char[][] board, int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        var rows = board.length;
        var cols = board[0].length;
        queue.add(new Point(i, j));
        board[i][j] = 'T';
        int[][] neighbours = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            var temp = queue.remove();
            for (int[] neighbour : neighbours) {
                var next = new Point(temp.x + neighbour[0], temp.y + neighbour[1]);
                if (next.x >= 0 && next.x < rows && next.y >= 0 && next.y < cols
                        && board[next.x][next.y] == 'O') {
                    board[next.x][next.y] = 'T';
                    queue.add(next);
                }
            }
        }
    }

    private record Point(int x, int y) {
    }
}
