package com.algo.recursion;

import java.util.Arrays;

public class NBitGenrator {


    public static void main(String[] args) {
        int n = 3;

        printAllBits(n);
    }

    private static void printAllBits(int n) {
        int[] bits = new int[n];
        printAllBitsHelper(bits, n, 0);
    }

    private static void printAllBitsHelper(int[] bits, int n, int i) {
        if (i == n) {
            printArray(bits);
            return;
        }
        bits[i] = 0;
        printAllBitsHelper(bits, n, i + 1);
        bits[i] = 1;
        printAllBitsHelper(bits, n, i + 1);
    }

    private static void printArray(int[] bits) {
        Arrays.stream(bits)
                .forEach(e -> System.out.print(e));
        System.out.println();
    }
}
