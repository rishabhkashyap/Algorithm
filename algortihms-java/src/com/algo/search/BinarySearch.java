package com.algo.search;


//Mid can be calculated as follows
// mid = (low + high)/2
//It might cause overflow issue therefore use following method to calculate mid
// mid = low + (high - low) / 2

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key=7;
        System.out.println("Location of 7 = " + binarySearchIterative(arr, key));
        System.out.println("Location of 7 = " + binarySearchRecursive(arr, key));
        int[] arr2 = {8, 7, 6, 5, 4, 3, 2, 1};
        key=6;
        System.out.println("Location of 6 = " + binarySearchDecreasingOrder(arr2, key));
    }

    private static int binarySearchIterative(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key == arr[mid]) {
                return mid + 1;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearchRecursive(int[] arr, int key) {
        return binarySearchHelper(arr, key, 0, arr.length - 1);

    }

    private static int binarySearchHelper(int[] arr, int key, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if (key == arr[mid]) {
            return mid + 1;
        } else if (key < arr[mid]) {
            return binarySearchHelper(arr, key, low, mid - 1);
        } else {
            return binarySearchHelper(arr, key, mid + 1, high);
        }

    }

    private static int binarySearchDecreasingOrder(int[] arr, int key) {
        return binarySearchDecreasingOrder(arr, key, 0, arr.length - 1);
    }

    private static int binarySearchDecreasingOrder(int[] arr, int key, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (key == arr[mid]) {
            return mid + 1;
        } else if (key < arr[mid]) {
            return binarySearchDecreasingOrder(arr, key, mid + 1, high);
        } else {
            return binarySearchDecreasingOrder(arr, key, low, mid - 1);
        }
    }

}
