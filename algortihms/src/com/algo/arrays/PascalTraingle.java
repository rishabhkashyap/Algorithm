package com.algo.arrays;

public class PascalTraingle {

    public static void main(String[] args) {
        createPascalTraingle(5);
    }

    private static void createPascalTraingle(int n) {
        int[][] result = new int[5][5];
        for (int line = 0; line < n; ++line) {
            for (int i = 0; i <= line; i++) {
                //Every first and last element in line is 1
                if (isFirstOrLastElement(line, i)) {
                    result[line][i] = 1;
                } else {
                    result[line][i] = result[line - 1][i - 1] + result[line - 1][i];
                }
            }
        }
        printPascalTraingle(result);
    }

    private static void printPascalTraingle(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static boolean isFirstOrLastElement(int line, int i) {
        return (line == i || i == 0) ? true : false;
    }
}
