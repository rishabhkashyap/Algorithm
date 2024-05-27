package com.algo.heaps;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

//Problem: https://leetcode.com/problems/kth-largest-element-in-an-array/description/
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

    //Better solution
    private static int findKthSmallestElement2(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int num : arr) {
            if (queue.size() < k) {
                queue.add(num);
            } else {
                if (queue.peek() > num) {
                    queue.remove();
                    queue.add(num);
                }
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

    //Better solution
    private static int findKthLargestElement2(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k);
        for (int num : arr) {
            if (queue.size() < k) {
                queue.add(num);
            } else {
                if (queue.peek() < num) {
                    queue.remove();
                    queue.add(num);
                }
            }
        }
        return queue.peek();

    }

}
