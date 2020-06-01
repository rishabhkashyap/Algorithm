package com.algo.numbers;


//Calculate a^b in log n times
public class FastModuloExponetial {

    public static void main(String[] args) {
        long a = 5;
        long b = 3;
        long m=100;

        long result = calculateExponent(a, b);
        System.out.println(a + "^" + b + " = " + result);
        result=calculateFastModulo(a,b,m);
        System.out.println(a + "^" + b+"%"+m + " = " + result);


    }

    private static long calculateExponent(long a, long b) {

        long explResult = 1;

        while (b > 0) {
            long result = b & 1;
            if (result == 1) {
                explResult *= a;
            }
            a = (long) Math.pow(a, 2);
            b = b >> 1;


        }
        return explResult;
    }

    private static long calculateFastModulo(long a, long b,long m) {

        long explResult = 1;

        while (b > 0) {
            long result = b & 1;
            if (result == 1) {
                explResult =(explResult*a)%m;
            }
            a = (a*a)%m;
            b = b >> 1;


        }
        return explResult;
    }
}
