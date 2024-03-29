package com.algo.search;

import java.util.Arrays;

public class CountMaxRep {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 1, 6, 2, 9, 2, 5};
        System.out.println("Max repeated element = " + getMaxRepeatedElementBruteForce(arr));
        System.out.println("Max repeated element = " + getMaxRepeatedElementSorting(arr));
        // int[] arr1 = {3, 2, 1, 2, 2, 5};
        //  int[] arr1 = {3, 3, 4, 4, 5, 5, 2, 3, 6, 7, 8, 3};
        //int [] arr1={1,3,5,4,5,5};
        int[] arr1 = {4, 1, 5, 2, 1, 5, 9, 8, 6, 5, 3, 2, 4, 7};
        System.out.println("\nMax repeated element in range 0...k");
        System.out.println("Max repeated element = " + getMaxRepeatedElementInRange(arr1));


    }

    private static int getMaxRepeatedElementBruteForce(int[] arr) {

        int maxCount = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            int maxCountSoFar = 0;
            for (int k : arr) {
                if (arr[i] == k) {
                    ++maxCountSoFar;
                }
            }
            if (maxCountSoFar > maxCount) {
                maxCount = maxCountSoFar;
                index = i;
            }
        }
        System.out.println("Max freq = " + maxCount);
        return arr[index];
    }

    private static int getMaxRepeatedElementSorting(int[] arr) {
        Arrays.sort(arr);
        int maxCountSoFar = 1;
        int maxCount = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                ++maxCountSoFar;
            } else {
                if (maxCountSoFar > maxCount) {
                    maxCount = maxCountSoFar;
                    index = i;
                }
                maxCountSoFar = 1;
            }


        }
        System.out.println("\nMax freq = " + maxCount);
        return arr[index];

    }

    //This approach works iff
    //Given an array of size n, the array contains numbers in range from 0 to k-1 where k is a positive integer and k <= n.
    private static int getMaxRepeatedElementInRange(int[] arr) {

        int maxCount = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[arr[i] % arr.length] += arr.length;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] / arr.length > maxCount) {
                maxCount = arr[i] / arr.length;
                index = i;
            }
        }
        //Restoring orignal values of array
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = arr[i] % k;
//        }
        return index;
    }
}
