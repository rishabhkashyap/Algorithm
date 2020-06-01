package com.algo.strings;


public class RunLength {
    public static void main(String[] args) {
        System.out.println("Encoding of wwwwaaadexxxxxx = " + runLengthEncode("wwwwaaadexxxxxx"));
        System.out.println("Decoding of w4a3d1e1x6 = " + runLengthDecode("w4a3d1e1x6"));
    }

    private static String runLengthDecode(String string) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i += 2) {
            if (!isAlphabet(string.charAt(i))) {
                throw new IllegalArgumentException("Not a valid encoded string");
            }
            if (!Character.isDigit(string.charAt(i + 1))) {
                throw new IllegalArgumentException("Not a valid encoded string");
            }

            char ch = string.charAt(i);
            int count = string.charAt(i + 1) - '0';
            result.append(String.valueOf(ch).repeat(count));
        }
        return result.toString();
    }

    private static boolean isAlphabet(char ch) {
        return (ch >= 'a' && ch <= 'z') ? true : false;
    }

    private static String runLengthEncode(String string) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 0; i < string.length(); i++) {
            if (i + 1 < string.length() && string.charAt(i) == string.charAt(i + 1)) {
                ++count;
            } else {
                result.append(string.charAt(i));
                result.append(count);
                count = 1;
            }
        }
        return result.toString();
    }
}
