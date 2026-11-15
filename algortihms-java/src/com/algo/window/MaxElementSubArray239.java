package com.algo.window;

import java.util.*;

//Problem: https://leetcode.com/problems/sliding-window-maximum/
public class MaxElementSubArray239 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 0, 4, 2, 6};
        int k = 3;
        int[] result = findMaxElementsInAllSubArrays(arr, k);
        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
    }

    private static int[] findMaxElementsInAllSubArrays(int[] arr, int k) {
        int[] result = new int[arr.length - k + 1];
        int j = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.removeLast();
            }
            deque.add(i);
            while (deque.peek() < i - k + 1) {
                deque.removeFirst();
            }
            if (i >= k - 1) {
                result[j++] = arr[deque.peek()];
            }
        }
        return result;
    }
}
