package com.algo.strings;

public class Substrings {

    public static void main(String[] args) {
        String string = "abcd";
        printAllSubstring(string);
    }

    private static void printAllSubstring(String string) {
        for (int len = 1; len <= string.length(); len++) {
            for (int start = 0; start <=string.length() - len; start++) {
                int end = start + len;
                System.out.println(string.substring(start, end));

            }
        }
    }
}
