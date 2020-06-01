package com.algo.dnc;

public class SortedArraySameSizeMedian {

    public static void main(String[] args) {
//        int[] arr1 = {1, 12, 15, 26, 38};
//        int[] arr2 = {2, 13, 17, 30, 45};
        int arr1[] = {1, 2, 3, 6};
        int arr2[] = {4, 6, 8, 10};
//        int[] arr1={1,3,5,6,7,8,9,11};
//        int[] arr2={1,4,6,8,12,14,15,17};
        System.out.println("Median of arr1 and arr2 = " + getMedian(arr1, arr2));
    }

    private static int getMedian(int[] arr1, int[] arr2) {
        return getMedianHelper(arr1, arr2, 0, arr1.length - 1, 0, arr2.length - 1);
    }

    private static int getMedianHelper(int[] arr1, int[] arr2, int startA, int endA, int startB, int endB) {
        if (arr1.length != arr2.length) {
            throw new IllegalArgumentException("Arrays are of different sizes");
        }

        if (arrayContains2Elements(startA, endA)) {
            return calculateMedian(arr1, arr2, startA, endA, startB, endB);
        }
        int median1 = getMedian(arr1, startA, endA);
        int median2 = getMedian(arr2, startB, endB);
        if (median1 == median2) {
            return median1;
        }
        int midIndexA = (startA + endA + 1) / 2;
        int midIndexB = (startB + endB + 1) / 2;


        if (median1 < median2) {
            startA = midIndexA;
            endB = midIndexB;
            return getMedianHelper(arr1, arr2, startA, endA, startB, endB);
        } else {
            endA = midIndexA;
            startB = midIndexB;
            return getMedianHelper(arr1, arr2, startA, endA, startB, endB);

        }
    }

    private static boolean arrayContains2Elements(int start, int end) {
        return (end - start == 1) ? true : false;
    }

    private static int calculateMedian(int[] arr1, int[] arr2, int startA, int endA, int startB, int endB) {
        return (Math.max(arr1[startA], arr2[startB]) + Math.min(arr1[endA], arr2[endB])) / 2;
    }

    private static int getMedian(int[] arr, int start, int end) {
        int n = end - start + 1;
        if (arr.length % 2 == 0) {
            return (arr[start + (n / 2 - 1)] + arr[start + n / 2]) / 2;
        } else {
            return arr[start + n / 2 - 1];
        }
    }
}
