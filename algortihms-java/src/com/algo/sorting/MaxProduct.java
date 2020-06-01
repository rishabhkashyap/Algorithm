package com.algo.sorting;

public class MaxProduct {

    public static void main(String[] args) {
        int[] arr = {-10, -3, 5, 6, -2};

        int maxProduct = getMaxProduct(arr);
        System.out.println("Max product of array = " + maxProduct);

    }


    private static int getMaxProduct(int[] arr) {

        int maxProductSoFar = Integer.MIN_VALUE;
        int maxProduct = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxProduct *= arr[i];
            if (maxProduct > maxProductSoFar) {
                maxProductSoFar = maxProduct;
            }
            if (maxProduct < 0) {
                maxProduct = 1;
            }
        }
        return maxProductSoFar;

    }
}
