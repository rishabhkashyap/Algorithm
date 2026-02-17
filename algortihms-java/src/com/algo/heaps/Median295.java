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

    //To get median efficiently, keep data sorted in 2 heaps. Left heap contains the left sorted elements and right
    //heap contains the right sorted elements. Elements in left heap are always smaller than elements in right heap
    //Left heap is a max heap and righ heap is min heap, so to calculate median of the stream grab the peek
    //of both heaps if even and divide by 2 else whichever heap is greater, grab the peek of that heap
    private static class MedianFinder {

        private final Queue<Integer> leftHeap;

        private final Queue<Integer> rightHeap;

        public MedianFinder() {
            this.leftHeap = new PriorityQueue<>(Comparator.reverseOrder());
            this.rightHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            leftHeap.add(num);
            //This check ensures that 50 pct of bottom element are in left heap and 50 pct of top element
            // are in right heap.
            if (!rightHeap.isEmpty() && leftHeap.peek() >= rightHeap.peek()) {
                rightHeap.add(leftHeap.remove());
            }
            if (leftHeap.size() - rightHeap.size() > 1) {
                rightHeap.add(leftHeap.remove());
            }
            if (rightHeap.size() - leftHeap.size() > 1) {
                leftHeap.add(rightHeap.remove());
            }
        }

        public double findMedian() {
            if (leftHeap.isEmpty() && rightHeap.isEmpty()) {
                return 0.0;
            }
            if (leftHeap.size() > rightHeap.size()) {
                return leftHeap.peek();
            }
            if (rightHeap.size() > leftHeap.size()) {
                return rightHeap.peek();
            }
            return (double) (leftHeap.peek() + rightHeap.peek()) / 2;
        }
    }

}
