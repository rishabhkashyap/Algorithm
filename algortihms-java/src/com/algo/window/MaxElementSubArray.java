package com.algo.window;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class MaxElementSubArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        List<Integer> maxElements = findMaxElementsInAllSubArrays(arr, k);
        maxElements.forEach(e -> System.out.print(e + "\t"));

    }

    private static List<Integer> findMaxElementsInAllSubArrays(int[] arr, int k) {
        List<Integer> maxElements = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            addToWindow(deque, arr, i);
        }
        for (int i = k; i < arr.length; i++) {
            maxElements.add(arr[deque.peek()]);
            // Remove the elements which
            // are out of this window
            removeFromWindow(deque, k, i);
            addToWindow(deque, arr, i);
        }
        //Loop doesn't add last element of window
        maxElements.add(arr[deque.peek()]);
        return maxElements;
    }

    private static void addToWindow(Deque<Integer> deque, int[] arr, int index) {
        while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[index]) {
            deque.removeLast();
        }
        deque.addLast(index);
    }

    private static void removeFromWindow(Deque<Integer> deque, int k, int index) {
        while (!deque.isEmpty() && deque.peek() <= index - k) {
            deque.removeFirst();
        }
    }
}
