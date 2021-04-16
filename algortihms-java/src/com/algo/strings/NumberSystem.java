package com.algo.strings;

public class NumberSystem {

    public static void main(String[] args) {
        String binary = "1100";
        String hex = "11A";
        String octal = "123";
        System.out.println("Binary to decimal = " + toDecimal(binary, 2));
        System.out.println("Hex to decimal = " + toDecimal(hex, 16));
        System.out.println("Octal to decimal = " + toDecimal(octal, 8));

        int decimal1 = 12;
        int decimal2 = 282;
        int decimal3 = 83;
        System.out.println("\nDecimal to binary = " + fromDecimal(decimal1, 2));
        System.out.println("Decimal to hex = " + fromDecimal(decimal2, 16));
        System.out.println("Decimal to octal = " + fromDecimal(decimal3, 8));
    }

    private static int toDecimal(String number, int base) {
        int result = 0;
        int multiplier = 1;
        for (int i = number.length() - 1; i >= 0; i--) {
            result += getDigit(number.charAt(i)) * multiplier;
            multiplier *= base;
        }
        return result;
    }

    private static int getDigit(char character) {
        if (character >= '0' && character <= '9') {
            return character - '0';
        } else {
            return character - 'A' + 10;
        }
    }

    private static String fromDecimal(int number, int base) {
        StringBuilder stringBuilder = new StringBuilder();
        while (number != 0) {
            stringBuilder.append(getValue(number % base));
            number /= base;
        }
        return stringBuilder.reverse().toString();
    }

    private static char getValue(int digit) {
        if (digit >= 0 && digit <= 9) {
            return (char) (digit + '0');
        } else {
            return (char) (digit - 10 + 'A');
        }
    }
}
