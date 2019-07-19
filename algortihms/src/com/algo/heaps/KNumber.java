package com.algo.heaps;

import java.util.PriorityQueue;
import java.util.Queue;

public class KNumber {

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        int kSmallest = findKthSmallestElement(arr, k);
        System.out.println(k + "th smallest element = " + kSmallest);
    }

    private static int findKthSmallestElement(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        int kthSmallest = Integer.MAX_VALUE;

        for (int element : arr) {
            queue.add(element);
        }
        int i = 0;
        while (!queue.isEmpty() && i < k) {
            kthSmallest = queue.remove();
            ++i;
        }
        return kthSmallest;
    }
}
