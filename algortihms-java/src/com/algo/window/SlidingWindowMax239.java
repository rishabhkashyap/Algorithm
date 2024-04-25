package com.algo.window;
//Problem: https://leetcode.com/problems/sliding-window-maximum/description/
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMax239 {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = findWindowMax(arr, k);
        Arrays.stream(result).forEach(e -> System.out.print(e + "\t"));
    }

    private static int[] findWindowMax(int[] arr, int k) {
        int i = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        while (i < arr.length) {
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            while (!deque.isEmpty() && deque.peekFirst() < i + 1 - k) {
                deque.removeFirst();
            }
            if (i + 1 >= k) {
                list.add(arr[deque.peekFirst()]);
            }
            ++i;
        }
        return list.stream().mapToInt(e -> e).toArray();
    }

}
