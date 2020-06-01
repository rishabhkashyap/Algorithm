package com.algo.strings;

public class OddEven {
    public static void main(String[] args) {
        System.out.println("7 is = " + findNumType(7));
        System.out.println("24 is = " + findNumType(24));
    }

    private static String findNumType(int number) {
        String[] arr = {"Even", "Odd"};
        return arr[number % 2];
    }
}
