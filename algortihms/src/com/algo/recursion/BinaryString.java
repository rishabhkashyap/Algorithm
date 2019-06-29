package com.algo.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryString {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            System.out.println(countBinaryStrings(num));

        }
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
