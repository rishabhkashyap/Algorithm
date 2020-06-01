package com.algo.sorting;

import java.util.Arrays;
import java.util.List;

public class LargestNumber {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 68, 75, 7, 21, 12);

        System.out.println("Largest number formed = " + getNumber(numbers));
    }

    private static String getNumber(List<Integer> numbers) {
        numbers.sort((e1, e2) -> compareNumbers(e1, e2));
        StringBuilder stringBuilder = new StringBuilder();
        for (int number : numbers) {
            stringBuilder.append(Integer.toString(number));
        }
        return stringBuilder.toString();
    }

    private static int compareNumbers(int num1, int num2) {
        int number1 = Integer.parseInt(Integer.toString(num1) + Integer.toString(num2));
        int number2 = Integer.parseInt(Integer.toString(num2) + Integer.toString(num1));
        return number2 - number1;
    }


}
