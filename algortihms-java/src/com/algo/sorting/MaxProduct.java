package com.algo.sorting;

import java.util.Arrays;

public class MaxProduct {

    public static void main(String[] args) {
        int[] arr = {-10, -3, 5, 6, -2};

        int maxProduct = getMaxProduct(arr);
        System.out.println("Max product of array = " + maxProduct);

    }


    private static int getMaxProduct(int[] arr) {
        int maxProd = Arrays.stream(arr).max().getAsInt();
        int maxProductSoFar = 1;
        int minProductSoFar = 1;
        for (int ele : arr) {
            if (ele == 0) {
                minProductSoFar = 1;
                maxProductSoFar = 1;
            } else {

                int temp = maxProductSoFar;
                maxProductSoFar = Math.max(Math.max(maxProductSoFar * ele, minProductSoFar * ele), ele);
                //Since max product so far is changed, using value stored int temp
                minProductSoFar = Math.min(Math.min(temp * ele, minProductSoFar * ele), ele);
                maxProd = Math.max(maxProd, maxProductSoFar);
            }

        }
        return maxProd;
    }
}
