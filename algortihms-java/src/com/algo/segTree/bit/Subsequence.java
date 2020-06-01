package com.algo.segTree.bit;

import java.util.Arrays;

public class Subsequence {

    public static void main(String[] args) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
        LIS lis = new LIS(arr);
        lis.buildTree();
        System.out.println("Longest increasing subsequence = " + lis.queryMax(arr.length));
    }

    static class LIS {
        private int[] arr;
        private int[] bit;
        private int size;

        public LIS(int[] arr) {
            this.arr = arr;
            this.size = arr.length;
            this.bit = new int[this.size + 1];

        }

        public void buildTree() {
            Pair[] pairs = new Pair[this.size];
            for (int i = 0; i < arr.length; i++) {
                Pair pair = new Pair(arr[i], i );
                pairs[i] = pair;
            }
            Arrays.sort(pairs);
            for (int i = 0; i < arr.length; i++) {
                updateTree(pairs[i].index,this.queryMax(i)+1 );
            }

        }

        private void updateTree(int element, int index) {
            while (index <= this.size) {
                bit[index] = Math.max(bit[index], element);
                index += index & (-index);
            }
        }

        public int queryMax(int index) {
            int max = 0;
            while (index > 0) {
                max = Math.max(max, bit[index]);
                index -= index & (-index);
            }
            return max;
        }
    }

    static class Pair implements Comparable<Pair> {
        private int element;
        private int index;

        public Pair(int element, int index) {
            this.element = element;
            this.index = index;
        }

        @Override
        public int compareTo(Pair pair) {
            if (this.element == pair.element) {
                return Math.max(this.index, pair.index);
            }
            return this.element - pair.element;
        }
    }
}
