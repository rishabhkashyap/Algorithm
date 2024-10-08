package com.algo.window;
//Problem: https://leetcode.com/problems/sliding-window-maximum/description/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMax239 {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = findWindowMax(arr, k);
        Arrays.stream(result).forEach(e -> System.out.print(e + "\t"));
        result=findWindowMax2(arr,k);
        System.out.println();
        Arrays.stream(result).forEach(e -> System.out.print(e + "\t"));
    }

    private static int[] findWindowMax(int[] arr, int k) {
        int i = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[arr.length - k+1];
        int j = 0;
        while (i < arr.length) {
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.removeFirst();
            }
            if (i - k + 1 >= 0) {
                result[j++] = arr[deque.peekFirst()];
            }
            ++i;
        }
        return result;
    }

    private static int[] findWindowMax2(int[] arr, int k){
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result= new int[arr.length-k+1];
        var j=0;
        for(int i=0; i< arr.length;i++){
            while(!deque.isEmpty() && arr[deque.peekLast()]<arr[i]){
                deque.removeLast();
            }
            deque.addLast(i);
            if(i-k+1>=0){
                result[j++]=arr[deque.peekFirst()];
            }
            while(!deque.isEmpty() && deque.peekFirst()<=i-k+1){
                deque.removeFirst();
            }
        }
        return result;
    }

}
