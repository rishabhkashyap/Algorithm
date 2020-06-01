package com.algo.search;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Find2MissingElement {

    public static void main(String[] args) {
//        int[] arr = {1, 3, 5, 6};
//        int n = 6;
        int[] arr = {1, 2};
        int n = 4;
        System.out.println("Find 2 missing element by availability array");
        findMissingElement(arr, n);
        System.out.println("Find 2 missing element by quadratic equation");
        findMissingElementUsingEquation(arr, n);

    }

    private static void findMissingElement(int[] arr, int n) {
        boolean[] availabilityArr = new boolean[n + 1];
        for (int number : arr) {
            availabilityArr[number] = true;
        }
        for (int i = 1; i < availabilityArr.length; i++) {
            if (!availabilityArr[i]) {
                System.out.println("Missing number = " + i);
            }
        }
    }

    private static void findMissingElementUsingEquation(int[] arr, int n) {
        int sumOfMissingNumbers = sumOfNaturalNumbers(n) - getArraySum(arr);
        int productOfMissingNumbers = productOfNaturalNumbers(n) / getArrayProduct(arr);
        int d = (int) Math.sqrt(Math.pow(sumOfMissingNumbers, 2) - 4 * productOfMissingNumbers);
        int missingNumber1 = (sumOfMissingNumbers + d) / 2;
        int missingNumber2 = (sumOfMissingNumbers - d) / 2;
        System.out.println("Missing number1 = " + missingNumber1);
        System.out.println("Missing number2 = " + missingNumber2);

    }

    private static int sumOfNaturalNumbers(int n) {
        return n*(n+1)/2;
    }

    private static int productOfNaturalNumbers(int n) {
        return IntStream.range(1, n + 1).reduce((a, b) -> a * b).getAsInt();
    }

    private static int getArraySum(int[] arr) {
        return Arrays.stream(arr).sum();
    }

    private static int getArrayProduct(int[] arr) {
        return Arrays.stream(arr).reduce((a, b) -> a * b).getAsInt();
    }


}
