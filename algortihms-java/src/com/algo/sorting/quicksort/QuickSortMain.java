package com.algo.sorting.quicksort;

public class QuickSortMain {

    public static void main(String[] args) {
        int arr[] = {5, 4, 6, 3, 1, 8, 23};
        //int arr[] = {34, 31, 43, 12, 11, 30, 22, 21, 32};
        //int arr[] = {10, 7, 8, 9, 1, 5};
        int[] duplicateElements = {2, 6, 5, 2, 6, 8, 6, 1, 2, 6, 2, 2, 9};
        System.out.println("Unsorted array");
        display(arr);
        QuickSort quick = new QuickSort(arr);
        //quick.doQuicksort(0, arr.length - 1);
        quick.iterativeQuickSort();
        System.out.println("Sorted array");
        display(arr);
        DutchQuickSort dutchQuickSort = new DutchQuickSort(duplicateElements);
        System.out.println("\nUnsorted array");
        display(duplicateElements);
        dutchQuickSort.sort();
        System.out.println("Sorted array");
        display(duplicateElements);

    }

    private static void display(int[] arr) {
        for (int num : arr) {
            System.out.print(num + "\t");
        }
        System.out.println();

    }

}
