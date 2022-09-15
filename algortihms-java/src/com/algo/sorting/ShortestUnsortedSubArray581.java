package com.algo.sorting;

import java.util.Arrays;
//Problem: https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
public class ShortestUnsortedSubArray581 {
    public static void main(String[] args) {
       // int[] arr={2,6,4,8,10,9,15};
        int[] arr = { 5, 7, 9, 13, 16, 12, 15, 8, 14, 18, 17, 20 };
        System.out.println(minLen(arr));
        System.out.println(minLen2(arr));

    }

    /*
     * 1.Find the min value when ith element is less than i-1 element ,start from left side of array
     * 2. Find max element when i th element is less than i+1 element, start from right
     * 3 find index of first element that is greater than min in left
     * 4. Find index of last element that is less than max element in right
     *
     * */
    private static int minLen(int[] arr) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                min = Math.min(min, arr[i]);
            }
        }
        for (int i = arr.length - 2; i >= 0; --i) {
            if (arr[i] > arr[i + 1]) {
                max = Math.max(max, arr[i]);
            }
        }
        if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) {
            return 0;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > min) {
                start = i;
                break;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < max) {
                end = i;
                break;
            }
        }

        return end - start + 1;

    }

    //Using sorting
    private static int minLen2(int[] arr){
        int[] temp= Arrays.copyOf(arr,arr.length);
        Arrays.sort(temp);
        int i=0;
        while (i<arr.length){
            if(temp[i]!=arr[i]){
                break;
            }
            ++i;
        }
        int start=i;
        i=arr.length-1;
        while (i>=0){
            if(arr[i]!=temp[i]){
                break;
            }
            --i;
        }
        int end=i;
        if(start==arr.length && end==-1){
            return 0;
        }
        return end-start+1;


    }
}
