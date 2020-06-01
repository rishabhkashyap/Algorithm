package com.algo.heaps;

import java.util.PriorityQueue;
import java.util.Queue;

public class RangeK1K2 {

    public static void main(String[] args) {
        int[] arr = {20, 8, 22, 4, 12, 10, 14};
        int k1th = 3;
        int k2th = 6;
        int sum = getSumInRange(arr, k1th, k2th);
        System.out.println("Sum in range " + k1th + "th and " + k2th + "th = " + sum);

    }

    private static int getSumInRange(int[] arr, int k1th, int k2th) {
        Queue<Integer> queue = new PriorityQueue<>();
        int difference = k2th - k1th - 1;
        int sum = 0;
        for (int element : arr) {
            queue.add(element);
        }
        while (!queue.isEmpty() && k1th > 0) {
            queue.remove();
            --k1th;
        }
        while (!queue.isEmpty() && difference > 0) {
            sum += queue.remove();
            --difference;
        }
        return sum;
    }
}
