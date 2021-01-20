package com.algo.sorting.quicksort;

public class DutchQuickSort {
    private int[] arr;

    public DutchQuickSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        sort(0, arr.length - 1);
    }

    private void sort(int start, int end) {
        if (start >= end) {
            return;
        }
        Partition partition = getPartition(start, end);
        sort(start, partition.getX());
        sort(partition.getY(), end);
    }

    private Partition getPartition(int start, int end) {

        int mid = start;
        int pivot = arr[end];
        while (mid <= end) {

            if (arr[mid] < pivot) {
                swap(start, mid);
                ++start;
                ++mid;
            } else if (arr[mid] == pivot) {
                ++mid;
            } else if (arr[mid] > pivot) {
                swap(mid, end);
                --end;
            }

        }
        return new Partition(start-1, mid);
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private class Partition {
        private int x;
        private int y;

        public Partition(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
