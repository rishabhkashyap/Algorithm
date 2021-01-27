package com.algo.heaps;


public class HeapSort {
    private int[] arr;

    public HeapSort(int[] arr) {
        super();
        this.arr = arr;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 4, 3, 6, 2, 1, 8};
        // int[] arr = {22, 21, 3, 25, 26, 7};
        //int arr[] = { 12, 11, 13, 5, 6, 7 };
        HeapSort hs = new HeapSort(arr);
        System.out.println("Unsorted array :");
        hs.displayArr();
        hs.sort();
        System.out.println("\n\nSorted array :");
        hs.displayArr();

    }

    public void sort() {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            maxHeapify(i, arr.length);
        }
        int size = arr.length - 1;
        while (size >= 0) {
            swap(0, size);
            maxHeapify(0, size);
            --size;
        }


    }

    private void maxHeapify(int i, int size) {
        int leftChildIndex = getLeftChildIndex(i);
        int rightChildIndex = getRightChildIndex(i);
        int largestIndex = i;
        if (leftChildIndex < size && arr[leftChildIndex] > arr[largestIndex]) {
            largestIndex = leftChildIndex;
        }
        if (rightChildIndex < size && arr[rightChildIndex] > arr[largestIndex]) {
            largestIndex = rightChildIndex;
        }
        if (largestIndex != i) {
            swap(i, largestIndex);
            // Recursively heapify affected subtree
            maxHeapify(largestIndex, size);
        }

    }

    private int getRightChildIndex(int i) {
        return 2 * i + 2;
    }

    private int getLeftChildIndex(int i) {
        return 2 * i + 1;
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void displayArr() {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
