package com.algo.dnc;

public class BinarySearchRotatedLargestElement {
    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4};
        System.out.println("Largest element in rotated array = " + getLargest(arr));
        System.out.println("Smallest element in rotated array = " + getSmallest(arr));
    }

    private static int getLargest(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int pivot = -99999;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] < arr[mid - 1]) {
                pivot = arr[mid - 1];
                break;
            } else if (arr[mid] > arr[mid + 1]) {
                pivot = arr[mid];
                break;
            } else if (arr[start] >= arr[mid]) {
                //Left part of array is unsorted
                end = mid - 1;
            } else if (arr[end] <= arr[mid]) {
                //Right part of array is not sorted
                start = mid + 1;
            }
        }
        return pivot;
    }

    private static int getSmallest(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int pivot = -99999;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > arr[mid - 1]) {
                pivot = arr[mid - 1];
                break;
            } else if (arr[mid] < arr[mid + 1]) {
                pivot = arr[mid];
                break;
            } else if (arr[start] >= arr[mid]) {
                //Left part of array is unsorted
                end = mid - 1;
            } else if (arr[end] <= arr[mid]) {
                //Right part of array is not sorted
                start = mid + 1;
            }
        }
        return pivot;
    }
}
