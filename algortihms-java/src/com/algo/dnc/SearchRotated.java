package com.algo.dnc;

public class SearchRotated {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 1, 2, 3, 4};
        int key = 2;
        int index = search(arr, key);
        if (index >= 0) {
            System.out.println(key + " found at index = " + index);
        } else {
            System.out.println(key + " not found");
        }

    }

    private static int search(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            //First half is sorted
            if (arr[start] <= arr[mid]) {
                if (key >= arr[start] && key < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                //Second half is sorted
                if (key <= arr[end] && key > arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
