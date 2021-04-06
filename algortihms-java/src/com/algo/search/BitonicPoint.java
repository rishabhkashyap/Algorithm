package com.algo.search;

public class BitonicPoint {

    public static void main(String[] args) {
       // int[] arr = {6, 7, 8, 11, 9, 5, 2, 1};
        int[] arr={7, 8, 9, 12, 10, 6, 3, 2};
        System.out.println("Bitonic point using brute force = " + findBitonicPointUsingBruteForce(arr));
        System.out.println("\nBitonic point using modified binary search = " + findBitonicPointUsingBinSearch(arr));
    }

    private static int findBitonicPointUsingBruteForce(int[] arr) {

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                return arr[i];
            }

        }
        return -1;
    }

    private static int findBitonicPointUsingBinSearch(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return arr[mid];
            }
            //elements are in increasing order in first part, look in second part
            if (arr[mid - 1] < arr[mid]) {
                low = mid + 1;
            } else {
                //elements are in sorted order in second part, look in first part
                high = mid - 1;
            }
        }
        return -1;
    }
}
