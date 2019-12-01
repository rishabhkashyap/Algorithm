package com.algo.heaps;

public class HeapCheck {
    public static void main(String[] args) {
        //int[] heap = {10, 9, 6, 2, 1};
        int[] heap = {90, 15, 10, 7, 12, 2};
        //int[] heap={1,2,3,4,5,6};
        //boolean result = isMaxHeapRecursive(heap);
        boolean result = isMaxHeapRecursive(heap);
        System.out.println("heap is max heap = " + result);
    }

    private static boolean isMaxHeapRecursive(int[] heap) {
        return isMaxHeapRecursiveHelper(heap, heap.length-1, 0);
    }

    private static boolean isMaxHeapRecursiveHelper(int[] heap, int size, int i) {
        if (2 * i + 2 > size) {
            return true;
        }
        boolean left = heap[i] > heap[2 * i + 1] && isMaxHeapRecursiveHelper(heap, size, 2 * i + 1);
        boolean right = heap[i] > heap[2 * i + 2] && isMaxHeapRecursiveHelper(heap, size, 2 * i + 2);
        return left && right;
    }

    private static boolean isMaxHeapIterative(int[] heap) {
        boolean isMaxHeap = true;
        int size = heap.length;
        for (int i = 0; i < heap.length / 2; i++) {
            int rightIndex = 2 * i + 1;
            int leftIndex = 2 * i + 2;
            if (rightIndex < size && leftIndex < size && (heap[i] < heap[rightIndex]
                    || heap[i] < heap[rightIndex])) {
                isMaxHeap = false;
                break;
            }
        }
        return isMaxHeap;
    }

    private static boolean isMinHeapRecursive(int[] heap) {
        return isMinHeapRecursiveHelper(heap, heap.length-1, 0);
    }

    private static boolean isMinHeapRecursiveHelper(int[] heap, int size, int i) {
        if (2 * i + 2 > size) {
            return true;
        }
        boolean left = heap[i] < heap[2 * i + 1] && isMinHeapRecursiveHelper(heap, size, 2 * i + 1);
        boolean right = heap[i] < heap[2 * i + 2] && isMinHeapRecursiveHelper(heap, size, 2 * i + 2);
        return left && right;
    }

}
