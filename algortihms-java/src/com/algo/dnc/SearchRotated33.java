package com.algo.dnc;


//Problem: https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchRotated33 {
    public static void main(String[] args) {
//        int[] arr = {5, 6, 7, 8, 9, 1, 2, 3, 4};
//        int key = 2;
//        int[] arr = {4, 5, 6, 7, 0, 1, 2};
//        int key = 0;
        int[] arr = {3,1};
        int key = 3;
        int index = search1(arr, key);
        if (index >= 0) {
            System.out.println(key + " found at index = " + index);
        } else {
            System.out.println(key + " not found");
        }
        System.out.println(+key + " found at index = " + findLoc(arr, key));

    }

    private static int search1(int[] arr, int key) {
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

    //Find location of the smallest element in sorted rotated array
    //for that index array is divided into 2 sorted array, use binary search to find target element
    private static int findLoc(int[] arr, int key) {
        int pivotIndex = findPivotIndex(arr);
        int locLeft = binarySearch(arr, 0, pivotIndex-1, key);
        int locRight = binarySearch(arr, pivotIndex, arr.length - 1, key);
        return locLeft != -1 ? locLeft : locRight;
    }

    private static int findPivotIndex(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        if(arr[low]<=arr[arr.length-1]){
            return low;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid + 1 < arr.length && arr[mid] >arr[mid + 1]) {
                return mid+1;
            } else if (mid - 1 >= 0 && arr[mid - 1] > arr[mid]) {
                return mid;
            } else if (arr[low] <= arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
