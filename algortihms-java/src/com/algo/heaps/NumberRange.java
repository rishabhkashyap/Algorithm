package com.algo.heaps;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class NumberRange {
    public static void main(String[] args) {
//        int[] arr1 = {3, 6, 8, 10, 15};
//        int[] arr2 = {1, 5, 12};
//        int[] arr3 = {4, 8, 15, 16};
//        int[] arr4 = {2, 6};
        int[] arr1 = {2, 3, 4, 8, 10, 15};
        int[] arr2 = {1, 5, 12};
        int[] arr3 = {7, 8, 15, 16};
        int[] arr4 = {3, 6};
        List<Integer> result = findSmallestRange(arr1, arr2, arr3, arr4);
        System.out.println("Range start = " + result.get(0) + " end = " + result.get(1));


    }

    private static List<Integer> findSmallestRange(int[]... arrs) {
        int range = Integer.MAX_VALUE;
        if (arrs == null || arrs.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty or null");
        }
        int start = 0;
        int end = 0;
        int high = Integer.MIN_VALUE;
        Queue<Node> queue = new PriorityQueue<>();
        for (int i = 0; i < arrs.length; i++) {
            queue.add(new Node(arrs[i][0], 0, i));
            high = Math.max(arrs[i][0], high);

        }
        while (true) {
            Node node = queue.remove();
            int low = node.getElement();
            int index = node.getIndex();
            int arrIndex = node.getArrIndex();
            if (range > (high - low)) {
                range = high - low;
                start = low;
                end = high;
            }
            if (index + 1 < arrs[arrIndex].length) {
                queue.add(new Node(arrs[arrIndex][index + 1], index + 1, arrIndex));
                high = Math.max(high, arrs[arrIndex][index + 1]);
            } else {
                break;
            }
        }
        return Arrays.asList(start, end);
    }

    private static class Node implements Comparable<Node> {
        private int element;
        private int index;
        private int arrIndex;

        public Node(int element, int index, int listIndex) {
            this.element = element;
            this.index = index;
            this.arrIndex = listIndex;
        }

        public int getElement() {
            return element;
        }

        public void setElement(int element) {
            this.element = element;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getArrIndex() {
            return arrIndex;
        }

        public void setArrIndex(int arrIndex) {
            this.arrIndex = arrIndex;
        }

        @Override
        public int compareTo(Node o) {
            return this.element - o.element;
        }
    }
}
