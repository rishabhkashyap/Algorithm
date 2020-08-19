package com.algo.graph;

public class Maze {
    public static void main(String[] args) {
        char[][] maze = {
                {'1', '0', '0', '0'},
                {'1', '1', '0', '1'},
                {'0', '1', '0', '0'},
                {'1', '1', '1', '1'}
        };
        System.out.println("Original maze");
        printMaze(maze);
        findPath(maze);
        System.out.println("Maze with path");
        printMaze(maze);
    }

    private static void findPath(char[][] maze) {
        findPath(maze, 0, 0);
    }

    private static boolean findPath(char[][] maze, int i, int j) {
        if (i >= maze.length || j > maze.length) {
            return false;
        }
        if (i < 0 || j < 0) {
            return false;
        }
        if (i == maze.length - 1 && j == maze.length - 1) {
            maze[maze.length - 1][maze.length - 1] = 'X';
            return true;
        }
        if (maze[i][j] == '1') {
            maze[i][j] = 'X';
            boolean moveDown = findPath(maze, i - 1, j);
            boolean moveUp = findPath(maze, i + 1, j);
            boolean moveRight = findPath(maze, i, j + 1);
            boolean moveLeft = findPath(maze, i, j - 1);
            if (moveDown || moveLeft || moveUp || moveRight) {
                return true;
            }
            maze[i][j] = '1';
        }
        return false;
    }

    private static void printMaze(char[][] maze) {
        for (char[] row : maze) {
            for (char step : row) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }
}
