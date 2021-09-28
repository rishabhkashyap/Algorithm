package com.algo.heaps;

import java.util.Arrays;

public class MinMaxHeap {

    public static void main(String[] args) {
        int[] minHeap ={1,3,6,5,9,8};
                //{3, 5, 9, 6, 8, 20, 10, 12, 18};
        convertToMaxHeap(minHeap);
        Arrays.stream(minHeap)
                .forEach(e -> System.out.print(e + "\t"));
    }

    private static void convertToMaxHeap(int[] minHeap) {
        for (int i = (minHeap.length - 1) / 2; i >= 0; i--) {
            heapify(minHeap, i);
        }
    }

    private static void heapify(int[] minHeap, int i) {
        int top = minHeap[i];
        int largeIndex = i;
        int size = minHeap.length;

        int left = getLeftIndex(i);
        int right = getRightIndex(i);
        if (left < size && minHeap[left] > minHeap[largeIndex]) {
            largeIndex = left;
        }
        if (right < size && minHeap[right] > minHeap[largeIndex]) {
            largeIndex = right;
        }
        if (largeIndex != i) {
            int temp = minHeap[i];
            minHeap[i] = minHeap[largeIndex];
            minHeap[largeIndex] = temp;
            heapify(minHeap, largeIndex);
        }


    }

    private static int getRightIndex(int i) {
        return 2 * i + 2;
    }

    private static int getLeftIndex(int i) {
        return 2 * i + 1;
    }
}
