package com.algo.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Location of 7 = " + binarySearchIterative(arr, 7));
        System.out.println("Location of 7 = " + binarySearchRecursive(arr, 7));
        int[] arr2 = {8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("Location of 7 =>" + binarySearchDecreasingOrder(arr2, 7));
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
        return binarySeachHelper(arr, key, 0, arr.length - 1);

    }

    private static int binarySeachHelper(int[] arr, int key, int low, int high) {

        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (key == arr[mid]) {
                return mid + 1;
            } else if (key < arr[mid]) {
                return binarySeachHelper(arr, key, low, mid - 1);
            } else {
                return binarySeachHelper(arr, key, mid + 1, high);
            }
        }
        return -1;

    }

    private static int binarySearchDecreasingOrder(int[] arr, int key) {
        return binarySearchDecreasingOrder(arr, key, 0, arr.length - 1);
    }

    private static int binarySearchDecreasingOrder(int[] arr, int key, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (key == arr[mid]) {
                return mid + 1;
            } else if (key < arr[mid]) {
                return binarySearchDecreasingOrder(arr, key, mid + 1, high);
            } else if (key > arr[mid]) {
                return binarySearchDecreasingOrder(arr, key, low, mid + 1);
            }

        }
        return -1;
    }


}
