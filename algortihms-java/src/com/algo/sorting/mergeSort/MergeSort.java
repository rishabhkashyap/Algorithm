package com.algo.sorting.mergeSort;

public class MergeSort {
    private int[] numbers;
    private int[] helper;

    private int number;

    public void sort(int[] values) {
        this.numbers = values;
        number = values.length;
        this.helper = new int[number];
        //mergesort(0, number - 1);
        mergeSortIterative();
    }

    private void mergesort(int low, int high) {
        // check if low is smaller than high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    public void mergeSortIterative() {
        for (int m = 1; m < numbers.length; m *= 2) {
            for (int i = 0; i < numbers.length; i += 2 * m) {
                int mid = i + m - 1;
                int high = Math.min(i + 2 * m - 1, numbers.length - 1);
                if (mid < numbers.length) {
                    merge(i, mid, high);
                }

            }
        }

    }

    private void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }
        while (j <= high) {
            numbers[k] = helper[j];
            ++j;
            ++k;
        }

    }


}
