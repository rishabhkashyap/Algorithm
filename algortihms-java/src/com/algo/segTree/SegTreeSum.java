package com.algo.segTree;

import java.util.Arrays;

public class SegTreeSum {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, -5, 6, 4};
        int[] segTree = new int[4 * arr.length + 1];
        buildTreeSum(arr, 0, arr.length - 1, segTree, 1);
        System.out.println("Segment tree");
        Arrays.stream(segTree, 0, 15)
                .forEach(e -> System.out.print(e + "\t"));

        int sum = querySum(segTree, 0, arr.length - 1, 0, 4, 1);
        System.out.println("\n\nSum between range 0 and 4 = " + sum);
    }

    private static int querySum(int[] segTree, int segStart, int segEnd, int qStart, int qEnd, int index) {
        if (qStart <= segStart && qEnd >= segEnd) {
            return segTree[index];
        }

        if (qStart > segEnd || qEnd < segStart) {
            return 0;
        }
        int mid = (segStart + segEnd) / 2;
        int left = querySum(segTree, segStart, mid, qStart, qEnd, 2 * index);
        int right = querySum(segTree, mid + 1, segEnd, qStart, qEnd, 2 * index + 1);
        return left + right;

    }

    private static int buildTreeSum(int[] arr, int start, int end, int[] segTree, int index) {
        if (start == end) {
            segTree[index] = arr[start];
            return segTree[index];
        }
        int mid = (start + end) / 2;
        int left = buildTreeSum(arr, start, mid, segTree, 2 * index);
        int right = buildTreeSum(arr, mid + 1, end, segTree, 2 * index + 1);
        segTree[index] = left + right;
        return segTree[index];
    }

}
