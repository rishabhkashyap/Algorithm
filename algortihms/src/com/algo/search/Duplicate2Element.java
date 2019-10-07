package com.algo.search;

import java.util.stream.IntStream;

public class Duplicate2Element {
    public static void main(String[] args) {
        int[] arr = {4, 2, 4, 5, 2, 3, 1};
        int n = 5;
        printDuplicateElements(arr, n);
        System.out.println();
        printDuplicate(arr);

    }

    private static void printDuplicateElements(int[] arr, int n) {
        int sum = 0;
        int product = 1;
        for (int element : arr) {
            sum += element;
            product += product;
        }
        int nSum = n * (n + 1) / 2;
        sum = sum - nSum;
        int nProduct = IntStream.range(1, n + 1)
                .sum();
        product = product / nProduct;
        int difference = (int) Math.sqrt(sum * sum - 4 * product);
        int num1 = (sum + difference) / 2;
        int num2 = (sum - difference) / 2;
        System.out.println("Repeated number1 = " + num1);
        System.out.println("Repeated number2 = " + num2);

    }

    private static void printDuplicate(int[] arr) {
        int[] freq = new int[arr.length];
        for (int num : arr) {
            ++freq[num];
        }

        for (int i = 0; i < arr.length; ++i) {
            if (freq[i] >= 2) {
                System.out.println("Repeated number1 = " + i);
            }
        }
    }
}
