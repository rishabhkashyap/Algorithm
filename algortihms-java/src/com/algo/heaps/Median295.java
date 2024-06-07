package com.algo.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
//Problem: https://leetcode.com/problems/find-median-from-data-stream/description/

public class Median295 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }

    private static class MedianFinder {

        private final Queue<Integer> maxHeap;

        private final Queue<Integer> minHeap;

        public MedianFinder() {
            this.maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            this.minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            maxHeap.add(num);
            if (!maxHeap.isEmpty() && !minHeap.isEmpty()
                    && (maxHeap.peek() >= minHeap.peek())) {
                minHeap.add(maxHeap.remove());
            }
            if (!maxHeap.isEmpty() && maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.remove());
            }
            if (!minHeap.isEmpty() && minHeap.size() - maxHeap.size() > 1) {
                maxHeap.add(minHeap.remove());
            }
        }

        public double findMedian() {
            if (maxHeap.isEmpty() && minHeap.isEmpty()) {
                return 0.0;
            }
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            }
            if (minHeap.size() > maxHeap.size()) {
                return minHeap.peek();
            }
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        }
    }
}
