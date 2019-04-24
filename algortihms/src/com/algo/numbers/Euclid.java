package com.algo.numbers;

public class Euclid {

    public static void main(String[] args) {
        int number1 = 10;
        int number2 = 15;
        int gcd = getGCD(number1, number2);
        int lcm = getLCM(number1, number2);
        System.out.println("GCD of "+number1+" and "+number2+" = "+gcd);
        System.out.println("LCM of "+number1+" and "+number2+" = "+lcm);
    }


    private static int getGCD(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        } else {
            return getGCD(number2, number1 % number2);
        }
    }

    private static int getLCM(int number1, int number2) {
        int gcd = getGCD(number1, number2);
        int lcm = (number1 * number2) / gcd;
        return lcm;

    }


}
