package com.algo.sorting.mergeSort;

import java.util.Arrays;

public class MergeSortMain {

    public static void main(String[] args) {
        MergeSort merge = new MergeSort();
        int elements[]={6,5,10,3,2,1,9,0};
        //int elements[]={5,7,-9,3,-4,2,8};
        //int elements[] = {10, 9, 7, 101, 23, 44, 12, 78, 34};
        System.out.println("Array before sorting ");
        Arrays.stream(elements).forEach(e -> System.out.print(e + "\t"));
        merge.sort(elements);
        System.out.println("\nArray after sorting ");
        for (int ele : elements) {
            System.out.print(ele + "\t");
        }

    }

}
