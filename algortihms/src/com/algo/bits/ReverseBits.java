package com.algo.bits;

public class ReverseBits {

    public static void main(String[] args) {
        System.out.print("Reversed bits = " + reverseBits(10));
    }

    private static int reverseBits(int n) {
        int rev = 0;
        while (n > 0) {
            rev <<= 1;
            int andResult = n & 1;
            if (andResult == 1) {
                rev ^= 1;
            }
            n = n >> 1;
        }
        return rev;
    }
}
