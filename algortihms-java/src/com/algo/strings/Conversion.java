package com.algo.strings;

public class Conversion {

    public static void main(String[] args) {
        int number = -1234;
        System.out.println("Number to string = " + numberToString(number));
        String str = "-54321ui";
        System.out.println("String to integer = " + stringToInteger(str));
    }

    private static String numberToString(int number) {
        boolean negativeNum = false;
        if (number < 0) {
            negativeNum = true;
            number = -number;
        }

        int divider = (int) Math.pow(10, Math.ceil(Math.log10(number)) - 1);

        StringBuilder stringBuilder = new StringBuilder();
        while (number != 0) {
            stringBuilder.append(number / divider);
            number %= divider;
            divider /= 10;
        }
        //stringBuilder.reverse();
        if (negativeNum) {
            stringBuilder.insert(0, "-");
        }
        return stringBuilder.toString();
    }

    private static int stringToInteger(String str) {
        boolean negativeNum = false;
        int result = 0;
        if (str.charAt(0) == '-') {
            negativeNum = true;
            str = str.substring(1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                throw new NumberFormatException("Invalid number");
            }
            result = result * 10 + str.charAt(i) - '0';
        }
        if (negativeNum) {
            result = -result;
        }
        return result;
    }
}
