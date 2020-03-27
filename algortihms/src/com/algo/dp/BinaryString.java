package com.algo.dp;

import java.io.IOException;

public class BinaryString {

    public static void main(String[] args) throws IOException {
        System.out.println(countBinaryStrings(3));
    }

    private static int countBinaryStrings(int k) {
        int[] endwithZero = new int[k];
        int[] endWithOne = new int[k];
        endWithOne[0] = 1;
        endwithZero[0] = 1;
        for (int i = 1; i < k; i++) {
            endwithZero[i] = endWithOne[i - 1] + endwithZero[i - 1];
            endWithOne[i] = endwithZero[i - 1];
        }
        return endWithOne[k - 1] + endwithZero[k - 1];
    }
}
