package com.algo.dnc;

public class LowerBound {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 33, 65};
        int key = 3;
        int pos = getFirstOccurence(arr, key);
        System.out.println("First occurrence of " + key + " = " + pos);
    }

    private static int getFirstOccurence(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        int pos = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == key) {
                pos = mid;
                end = mid - 1;
                //To find last occurrence
                //start=mid+1;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return pos;
    }
}
