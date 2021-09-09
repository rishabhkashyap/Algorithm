package com.algo.heaps;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KNumber {

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        System.out.println("Approach 1");
        System.out.println(k + "th smallest element = " + findKthSmallestElement1(arr, k));
        System.out.println(k + "th largest element = " + findKthLargestElement1(arr, k));
        System.out.println("\nApproach 2");
        System.out.println(k + "th smallest element = " + findKthSmallestElement2(arr, k));
        System.out.println(k + "th largest element = " + findKthLargestElement2(arr, k));
    }

    private static int findKthSmallestElement1(int[] arr, int k) {
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

    private static int findKthSmallestElement2(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k,Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }
        for (int j = k; j < arr.length; j++) {
            if (arr[j] < queue.peek()) {
                queue.remove();
                queue.add(arr[j]);
            }
        }
        return queue.peek();
    }

    private static int findKthLargestElement1(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int kthLargest = Integer.MIN_VALUE;

        for (int element : arr) {
            queue.add(element);
        }
        int i = 0;
        while (!queue.isEmpty() && i < k) {
            kthLargest = queue.remove();
            ++i;
        }
        return kthLargest;
    }

    private static int findKthLargestElement2(int[] arr, int k) {

        Queue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] > queue.peek()) {
                queue.remove();
                queue.add(arr[i]);
            }
        }

        return queue.peek();

    }

}
