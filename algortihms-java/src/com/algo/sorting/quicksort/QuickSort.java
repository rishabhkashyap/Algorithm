package com.algo.sorting.quicksort;

import java.util.Stack;

public class QuickSort {
    //private int size;
    private int[] numbers;

    public QuickSort(int[] numbers) {
        this.numbers = numbers;
        // this.size = numbers.length;
    }

    public void doQuicksort(int low, int high) {
        int i = low;
        int j = high;
        int pivot = numbers[low + (high - low) / 2];

        while (i <= j) {
            while (numbers[i] < pivot) {
                ++i;
            }
            while (numbers[j] > pivot) {
                --j;
            }
            if (i <= j) {
                exchange(i, j);
                ++i;
                --j;
            }
        }
        if (low < j) {
            doQuicksort(low, j);
        }
        if (high > i) {
            doQuicksort(i, high);
        }

    }

    public void iterativeQuickSort() {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(this.numbers.length - 1);
        while (!stack.isEmpty()) {
            int high = stack.pop();
            int low = stack.pop();


            int partitionIndex = partition(low, high);
            if (partitionIndex - 1 > low) {
                stack.push(low);
                stack.push(partitionIndex - 1);

            }
            if (partitionIndex + 1 < high) {
                stack.push(partitionIndex + 1);
                stack.push(high);

            }


        }
    }

    private int partition(int low, int high) {
        int pivot = numbers[high];
        int partitionIndex = low;
        for (int i = low; i < high; i++) {
            if (numbers[i] < pivot) {
                exchange(i, partitionIndex);
                ++partitionIndex;
            }
        }
        exchange(partitionIndex, high);
        return partitionIndex;
    }

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

}
