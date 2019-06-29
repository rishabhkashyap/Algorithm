package com.algo.recursion;

public class BinaryStringGenerator {
    public static void main(String[] args) {
        int k = 3;
        generateStrings(k);
    }

    private static void generateStrings(int k) {
        if (k <= 0) {
            return;
        }
        char[] bits = new char[k];

        //Generate all strings that starts with 0
        bits[0] = '0';
        generateStringsUtil(bits, k, 1);
        //Generate all strings that starts with 1
        bits[0] = '1';
        generateStringsUtil(bits, k, 1);

    }

    private static void generateStringsUtil(char[] bits, int k, int i) {
        if (i == k) {
            printString(bits);
            return;
        }

        if (bits[i - 1] == '1') {
            bits[i] = '0';
            generateStringsUtil(bits, k, i + 1);
        }

        if (bits[i - 1] == '0') {
            bits[i] = '0';
            generateStringsUtil(bits, k, i + 1);
            bits[i] = '1';
            generateStringsUtil(bits, k, i + 1);
        }


    }

    private static void printString(char[] bits) {
        for (int i = 0; i < bits.length; i++) {
            System.out.print(bits[i]);
        }
        System.out.println();
    }
}
