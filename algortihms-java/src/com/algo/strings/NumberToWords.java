package com.algo.strings;

public class NumberToWords {

    public static void main(String[] args) {
        System.out.println(convertToWordsInternational(123456));
        System.out.println(convertToWordsInternational(1000));
        System.out.println(convertToWordsInternational(12_234_456));
        System.out.println(convertToWordsInternational(100_000_000));
    }

    private static String convertToWordsInternational(int number) {
        String words = "";
        int index = 0;
        while (number > 0) {
            if (number % 1000 != 0) {
                String str = convertToWordsHelper(number % 1000);
                words = str + getPlaceValue(index) + words;
            }

            ++index;
            number /= 1000;
        }
        return words;

    }

    private static String convertToWordsHelper(int number) {
        String words = "";
        int lastDigits = number % 100;
        if (lastDigits < 10) {
            words = words + getUnit(lastDigits);
        } else if (lastDigits < 20) {
            words = words + get2Digits(lastDigits % 10);
        } else {
            words = words + getTenMultiple(lastDigits / 10) + getUnit(lastDigits % 10);
        }
        return (number >= 100) ? getUnit(number / 100) + " hundred" + words : words;


    }

    private static String getTenMultiple(int digit) {
        String[] tens = {
                "",
                "",
                " twenty",
                " thirty",
                " forty",
                " fifty",
                " sixty",
                " seventy",
                " eighty",
                " ninety"
        };

        return tens[digit];
    }

    private static String get2Digits(int digit) {
        String[] twoDigits = {
                " ten",
                " eleven",
                " twelve",
                " thirteen",
                " fourteen",
                " fifteen",
                " sixteen",
                " seventeen",
                " eighteen",
                " nineteen"
        };
        return twoDigits[digit];
    }

    private static String getUnit(int digit) {
        String[] units = {
                "",
                " one",
                " two",
                " three",
                " four",
                " five",
                " six",
                " seven",
                " eight",
                " nine"
        };

        return units[digit];
    }

    private static String getPlaceValue(int index) {
        String[] placeValue = {
                "",
                " thousand",
                " million",
                " billion"
        };
        return placeValue[index];
    }
}
