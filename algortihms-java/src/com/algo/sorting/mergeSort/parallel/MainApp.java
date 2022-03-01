package com.algo.sorting.mergeSort.parallel;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        int elements[] = {6, 5, 10, 3, 2, 1, 9, 0};
       // int elements[] = {10,9,8,7,6,5,4,3,2,1,0,-1,-8};
        MergeSort mergeSort = new MergeSort();
        mergeSort.parallelMergeSort(elements);
        Arrays.stream(elements)
                .forEach(e -> System.out.print(e + "\t"));
    }
}
