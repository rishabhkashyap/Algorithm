package com.algo.strings;

public class ExcelColumn {
    public static void main(String[] args) {
        int colId = 676;
        System.out.println("Encoded column value = " + encodeColumn(colId));
        String column = "YZ";
        System.out.println("Decode column value = " + decodeColumn(column));
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

    private static String encodeColumn(int colId) {
        StringBuilder sb = new StringBuilder();
        while (colId != 0) {
            int remainder = colId % 26;
            if (remainder == 0) {
                sb.append('Z');
                colId = colId / 26 - 1;
            } else {
                sb.append(getChar(remainder - 1));
                colId /= 26;
            }
        }
        return sb.reverse().toString();
    }

    private static char getChar(int i) {
        return (char) (i + 'A');
    }
}
