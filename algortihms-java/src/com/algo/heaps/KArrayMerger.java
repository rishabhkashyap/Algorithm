package com.algo.heaps;

import java.util.PriorityQueue;
import java.util.Queue;

public class KArrayMerger {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 9};
        int[] arr3 = {8, 10, 11};

        int[] result = mergeKSortedArray(new int[][]{arr1, arr2, arr3});
        System.out.println();
        for (int i : result) {
            System.out.print(i + "\t");
        }

    }

    private static int[] mergeKSortedArray(int[][] arr) {
        Queue<QueueNode> pq = new PriorityQueue<>();
        int size = 0;
        int[] result;
        int ind = 0;
        int m = 0;
        for (int i = 0; i < arr.length; i++) {
            QueueNode ac = new QueueNode(i, arr[i][0], 0);
            pq.add(ac);
            size += arr[i].length;
        }
        result = new int[size];

        while (!pq.isEmpty()) {
            QueueNode node = pq.poll();
            int element = node.getElement();
            int elementIndex = node.getIndex();
            int arrIndex = node.getArray();
            result[m++] = element;
            if (elementIndex + 1 < arr[arrIndex].length) {
                QueueNode nextElement = new QueueNode(arrIndex,
                        arr[arrIndex][elementIndex + 1], elementIndex + 1);
                pq.add(nextElement);
            }
        }
        return result;
    }

    private static class QueueNode implements Comparable<QueueNode> {
        private int array;
        private int element;
        private int index;

        public QueueNode(int array, int element, int index) {
            this.array = array;
            this.element = element;
            this.index = index;
        }

        public int getArray() {
            return array;
        }

        public int getElement() {
            return element;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public int compareTo(QueueNode ac) {
            // TODO Auto-generated method stub
            return this.element - ac.getElement();
        }

    }


}
