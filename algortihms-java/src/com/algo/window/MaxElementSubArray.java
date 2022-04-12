package com.algo.window;

import java.util.*;

//Problem: https://leetcode.com/problems/sliding-window-maximum/
public class MaxElementSubArray {

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
//        int k = 3;
//        int[] arr = {7, 2, 4};
//        int k = 2;
        int[] arr = {1, 3, 1, 2, 0, 5};
        int k = 3;
        List<Integer> maxElements = findMaxElementsInAllSubArrays1(arr, k);
        maxElements.forEach(e -> System.out.print(e + "\t"));
        System.out.println();
        int[] result = findMaxElementsInAllSubArrays2(arr, k);
        Arrays.stream(result).forEach(e -> System.out.print(e + "\t"));

    }

    private static List<Integer> findMaxElementsInAllSubArrays1(int[] arr, int k) {
        List<Integer> maxElements = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            addToWindow(deque, arr, i);
        }
        for (int i = k; i < arr.length; i++) {
            if (!deque.isEmpty()) {

                maxElements.add(arr[deque.peek()]);
            }
            // Remove the elements which
            // are out of this window
            removeFromWindow(deque, k, i);
            addToWindow(deque, arr, i);
        }
        //Loop doesn't add last element of window
        if (!deque.isEmpty()) {

            maxElements.add(arr[deque.peek()]);
        }
        return maxElements;
    }

    private static void addToWindow(Deque<Integer> deque, int[] arr, int index) {
        while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[index]) {
            deque.removeLast();
        }
        deque.addLast(index);
    }

    private static void removeFromWindow(Deque<Integer> deque, int k, int index) {
        while (!deque.isEmpty() && deque.peekFirst() <= index - k) {
            deque.removeFirst();
        }
    }

    private static int[] findMaxElementsInAllSubArrays2(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if (i >= k - 1) {
                if (!deque.isEmpty()) {
                    result.add(arr[deque.peek()]);
                }
            }
        }
        int[] resultArr = new int[result.size()];
        int m = 0;
        for (int ele : result) {
            resultArr[m++] = ele;
        }
        return resultArr;
    }
}
