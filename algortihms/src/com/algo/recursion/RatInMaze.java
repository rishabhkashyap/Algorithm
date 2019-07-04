package com.algo.recursion;

public class RatInMaze {
    private char[][] maze;
    private char[][] solution;
    private int row;
    private int column;
    private int noOfRoutes;

    public RatInMaze(int row, int column, char[][] maze) {
        this.row = row;
        this.column = column;
        this.maze = maze;
        solution = new char[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                solution[i][j] = '0';
            }
        }
    }

    public static void main(String[] args) {
        char[][] maze = {{'0', '0', '0', '0'},
                {'0', '0', 'X', '0'},
                {'0', '0', '0', 'X'},
                {'0', 'X', '0', '0'}};
        RatInMaze ratInMaze = new RatInMaze(4, 4, maze);
        ratInMaze.findPaths(0, 0);
        System.out.println("Total number of routes = " + ratInMaze.getNoOfRoutes());
    }

    public boolean findPaths(int i, int j) {
        if (i == row - 1 && j == column - 1) {
            solution[i][j] = '1';
            printPath();
            ++noOfRoutes;
            return true;
        }
        if (i >= row || j >= column) {
            return false;
        }
        if (maze[i][j] == 'X') {
            return false;
        }
        solution[i][j] = '1';
        boolean right = findPaths(i, j + 1);
        boolean down = findPaths(i + 1, j);
        solution[i][j] = '0';
        if (right || down) {
            return true;
        }
        return false;

    }

    private void printPath() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(solution[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }

    public int getNoOfRoutes() {
        return noOfRoutes;
    }
}
