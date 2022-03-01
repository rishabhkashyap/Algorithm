package com.algo.sorting.mergeSort.parallel;

import java.util.Arrays;

public class MergeSort {


    public void parallelMergeSort(int[] arr) {
        parallelMergeSort(arr, Runtime.getRuntime().availableProcessors());
    }

    private void parallelMergeSort(int[] arr, int numberOfThreads) {
        if (numberOfThreads <= 1) {
            sort(arr);
            return;
        }
        int middle = arr.length / 2;
        int[] leftArr = Arrays.copyOfRange(arr, 0, middle);
        int[] rightArr = Arrays.copyOfRange(arr, middle, arr.length);
        Thread leftThread = createThread(leftArr, numberOfThreads);
        Thread rightThread = createThread(rightArr, numberOfThreads);
        leftThread.start();
        rightThread.start();
        try {
            leftThread.join();
            rightThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        merge(leftArr, rightArr, arr);

    }

    private Thread createThread(int[] arr, int numberOfThreads) {
        return new Thread(() -> parallelMergeSort(arr, numberOfThreads / 2));
    }


    private void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int middle = arr.length / 2;
        int[] leftArr = Arrays.copyOfRange(arr, 0, middle);
        int[] rightArr = Arrays.copyOfRange(arr, middle, arr.length);
        sort(leftArr);
        sort(rightArr);
        merge(leftArr, rightArr, arr);
    }


    private void merge(int[] leftArr, int[] rightArr, int[] arr) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] < rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }

    }
}
