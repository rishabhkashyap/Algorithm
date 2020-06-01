package com.algo.segTree;

import java.util.Arrays;

public class SegTree {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, -5, 6, 4};
        int[] segTree = new int[4 * arr.length + 1];
        buildTree(arr, 0, arr.length - 1, segTree, 1);
        System.out.println("Segment tree");
        Arrays.stream(segTree, 1, 14)
                .forEach(e -> System.out.print(e + "\t"));
//        System.out.println("\n\nMinimum value between indices " + "0 and 5 = "
//                + queryMinElement(segTree, 0, arr.length - 1, 4, 5, 1));
        //updateNode(segTree, 0, arr.length - 1, 1, 10, 3);
        updateInRange(segTree, 0, arr.length - 1, 2, 3, 10, 1);
        System.out.println("\n\nsegment tree after update");
        Arrays.stream(segTree, 1, 14)
                .forEach(e -> System.out.print(e + "\t"));

        System.out.println("\n\nMinimum value between indeices " + "0 and 5 = "
                + queryMinElement(segTree, 0, arr.length - 1, 2, 3, 1));
    }

    private static void buildTree(int[] arr, int start, int end, int[] segTree, int index) {
        if (start == end) {
            segTree[index] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        buildTree(arr, start, mid, segTree, 2 * index);
        buildTree(arr, mid + 1, end, segTree, 2 * index + 1);
        segTree[index] = Math.min(segTree[2 * index], segTree[2 * index + 1]);

    }

    public static int queryMinElement(int[] segTree, int segStart, int segEnd, int qStart, int qEnd, int index) {

        //Complete overlap
        if (qStart <= segStart && qEnd >= segEnd) {
            return segTree[index];
        }
        //No Overlap
        if (qEnd < segStart || qStart > segEnd) {
            return Integer.MAX_VALUE;
        }
        int mid = (segStart + segEnd) / 2;
        //partial overlap
        int leftMin = queryMinElement(segTree, segStart, mid, qStart, qEnd, 2 * index);
        int rightMin = queryMinElement(segTree, mid + 1, segEnd, qStart, qEnd, 2 * index + 1);
        return Math.min(leftMin, rightMin);

    }

    public static void updateNode(int[] segTree, int segStart, int segEnd, int index, int inc, int arrIndex) {

        if ((arrIndex < segStart) || (arrIndex > segEnd)) {
            return;
        }
        if (segStart == segEnd) {
            segTree[index] += inc;
            return;
        }

        int mid = (segStart + segEnd) / 2;
        updateNode(segTree, segStart, mid, 2 * index, inc, arrIndex);
        updateNode(segTree, mid + 1, segEnd, 2 * index + 1, inc, arrIndex);
        segTree[index] = Math.min(segTree[2 * index], segTree[2 * index + 1]);


    }


    public static void updateInRange(int[] segTree, int segStart, int segEnd, int qStart, int qEnd, int inc, int index) {
        if ((qStart > segEnd) || (qEnd < segStart)) {
            return;
        }
        if (segStart == segEnd) {
            segTree[index] += inc;
            return;
        }
        int mid = (segStart + segEnd) / 2;
        updateInRange(segTree, segStart, mid, qStart, qEnd, inc, 2 * index);
        updateInRange(segTree, mid + 1, segEnd, qStart, qEnd, inc, 2 * index + 1);
        segTree[index] = Math.min(segTree[2 * index], segTree[2 * index + 1]);


    }
}
