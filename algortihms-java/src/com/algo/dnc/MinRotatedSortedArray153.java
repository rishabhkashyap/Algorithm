package com.algo.dnc;

public class MinRotatedSortedArray153 {
    static void main() {
        int[] arr = {3, 4, 5, 6, 1, 2};
        System.out.println(findMinRotatedArray(arr));
        System.out.println(findMaxRotatedArray1(arr));
        System.out.println(findMaxRotatedArray2(arr));
    }

    private static int findMinRotatedArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        if (arr[low] < arr[high] || arr.length == 1) {
            return arr[low];
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                return arr[mid];
            }
            if (arr[mid] > arr[high]) { // mid is in the right part of array, so the min is strictly to the right
                low = mid + 1;
            } else {
                high = mid - 1;  // mid is in the left part of array, so the min is at mid or to the left
            }
        }
        return -1;
    }


    private static int findMaxRotatedArray1(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        if (arr[low] < arr[high] || arr.length == 1) {
            return arr[high];
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                return arr[mid - 1];
            }
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int findMaxRotatedArray2(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        if (arr[low] < arr[high] || arr.length == 1) {
            return arr[high];
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid + 1 < arr.length  && arr[mid] > arr[mid + 1]) {
                return arr[mid];
            }
            if (arr[low] <= arr[mid]) {
               low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return -1;
    }
}
