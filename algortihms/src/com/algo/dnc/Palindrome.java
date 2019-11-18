package com.algo.dnc;

public class Palindrome {

    public static void main(String[] args) {
        int num = 12321;
        System.out.println("Number is Palindrome = " + isPalindrome(num));
    }

    private static boolean isPalindrome(int num) {
        int divisor = 1;
        while (num / divisor > 10) {
            divisor *= 10;
        }
        while (num > 0) {

            int leading = num / divisor;
            int trailing = num % 10;
            if (leading != trailing) {
                return false;
            }
            //Removing leading and trailing digits
            num = (num % divisor) / 10;
            //since 2 digits are removed divisor must be reduced
            divisor /= 100;
        }
        return true;

    }
}
