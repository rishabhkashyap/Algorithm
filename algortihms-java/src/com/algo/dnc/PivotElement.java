package com.algo.dnc;

public class PivotElement {
    public static void main(String[] args) {
        // int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int[] arr = {5, 6, 7, 10, 1, 2, 3, 4};
        int pivot = findPivot(arr);
        if (pivot >= 0) {
            System.out.println("Pivot element = " + pivot);
        }
    }

    private static int findPivot(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid + 1]) {
                return arr[mid + 1];
            }
            if (arr[low] < arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
