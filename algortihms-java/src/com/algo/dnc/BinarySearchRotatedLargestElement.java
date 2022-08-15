package com.algo.dnc;

//Problem: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class BinarySearchRotatedLargestElement {
    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4};
        //int[] arr = {11, 13, 15, 17};
        System.out.println("Largest element in rotated array = " + getLargest(arr));
        System.out.println("Smallest element in rotated array = " + getSmallest(arr));
    }

    //Largest element is only element that is greater than next element in array
    private static int getLargest(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        if (arr[start] <= arr[end]) {
            return arr[end];
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return arr[mid - 1];
            } else if (mid < end && arr[mid] > arr[mid + 1]) {
                return arr[mid];
            } else if (arr[start] <= arr[mid]) {
                //Left part of array is unsorted
                start = mid + 1;
            } else {
                //Right part of array is not sorted
                end = mid - 1;
            }
        }
        return Integer.MIN_VALUE;
    }


    //Smallest element is the only element which is smaller than its previous element
    private static int getSmallest(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        //Array is sorted
        if (arr[start] <= arr[end]) {
            return arr[start];
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return arr[mid];
            } else if (mid < end && arr[mid] > arr[mid + 1]) {
                return arr[mid + 1];

            } else if (arr[start] <= arr[mid]) {
                //Left part of array is unsorted
                start = mid + 1;
            } else {
                //Right part of array is not sorted
                end = mid - 1;
            }
        }
        return -1;
    }
}
