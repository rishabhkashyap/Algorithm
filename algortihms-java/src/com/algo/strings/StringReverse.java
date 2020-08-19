package com.algo.strings;

public class StringReverse {

    public static void main(String[] args) {
        String string = "qwerty";
        System.out.println("Reversed string = " + reverse(string));
        System.out.println("Reversed string = " + reverse2(string));
    }

    private static String reverse(String string) {
        if (string.length() == 0 || string.length() == 1) {
            return string;
        }
        return string.charAt(string.length() - 1) + reverse(string.substring(0, string.length() - 1));
    }

    private static String reverse2(String string) {
        if (string.length() == 1) {
            return string;
        }
        return reverse(string.substring(1)) + string.charAt(0);
    }
}
