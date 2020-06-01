package com.algo.math;

public class FastMultiplication {

    private static final long N = 1000000007L;

    public static void main(String[] args) {
        long num = 7;
        long exp = 10;

        long result = fastMultiplication(num, exp);
        System.out.println("Result  without 10^7= " + result);


        result = fastModuloExp(num, exp);
        System.out.println("Result  with 10^7= " + result);


    }


    private static long fastMultiplication(long num, long exp) {

        if (exp == 0) {
            return 1;
        } else if (exp == 1) {
            return num;
        } else if (exp % 2 == 0) {
            return fastMultiplication(num * num, exp / 2);
        } else {
            return num * fastMultiplication(num * num, (exp - 1) / 2);
        }

    }


    private static long fastModuloExp(long num, long exp) {

        num = num % N;

        if (exp == 0) {
            return 1;
        } else if (exp == 1) {
            return num;
        } else if (exp % 2 == 0) {
            return fastMultiplication((num * num) % N, exp / 2);
        } else {
            return (num * fastMultiplication((num * num) % N, (exp - 1) / 2)) % N;
        }

    }
}
