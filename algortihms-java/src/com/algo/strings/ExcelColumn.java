package com.algo.strings;

public class ExcelColumn {
    public static void main(String[] args) {
        int colId = 676;
        System.out.println("Encoded column value = " + encodeColumn(colId));
        String column = "YZ";
        System.out.println("Decode column value = " + decodeColumn(column));
    }

    private static String encodeColumn(int colId) {
        StringBuilder sb = new StringBuilder();
        while (colId != 0) {
            int remainder = (colId - 1) % 26;
            sb.append(getChar(remainder));
            colId = (colId - 1) / 26;
        }
        return sb.reverse().toString();
    }

    private static char getChar(int i) {
        return (char) (i + 'A');
    }

    private static int decodeColumn(String column) {
        int result = 0;
        int multiplier = 1;

        for (int i = column.length() - 1; i >= 0; --i) {
            result += getDigit(column.charAt(i)) * multiplier;
            multiplier *= 26;
        }
        return result;

    }

    private static int getDigit(char character) {
        return character - 'A' + 1;
    }
}
