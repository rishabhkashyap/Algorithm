package com.algo.sorting.quicksort;

public class QuickSortMain {

    public static void main(String[] args) {
        int arr[] = {5, 4, 6, 3, 1, 8, 23};
        //int arr[] = {34, 31, 43, 12, 11, 30, 22, 21, 32};
        //int arr[] = {10, 7, 8, 9, 1, 5};
        QuickSort quick = new QuickSort(arr);
        //quick.doQuicksort(0, arr.length - 1);
        quick.iterativeQuickSort();
        for (int num : arr) {
            System.out.print(num + "\t");
        }

    }

}
