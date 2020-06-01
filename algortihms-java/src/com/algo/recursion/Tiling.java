package com.algo.recursion;

public class Tiling {


    public static void main(String[] args) {
        int n = 7;
        int m = 4;
        int count = countWays(n, m);
        System.out.println("Number of ways to lay tiles = " + count);
    }

    private static int countWays(int n, int m) {
        int[] countTable = new int[n + 1];
        countTable[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i > m) {
                countTable[i] = countTable[i - 1] + countTable[i - m];
            } else if (i < m) {
                countTable[i] = 1;
            } else if (i == m) {
                countTable[i] = 2;
            }

        }
        return countTable[n];
    }
}
