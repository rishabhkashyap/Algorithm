package com.algo.segTree.bit;

public class FenwickTreeMaxOp {


    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 7};
        FenwickTree fenwickTree = new FenwickTree(arr);
        fenwickTree.buildTree();
        System.out.println("Max = " + fenwickTree.queryMax(2));
        System.out.println("Max = " + fenwickTree.queryMax(5));

    }


    private static class FenwickTree {
        int[] bit;
        int[] arr;
        int size;

        public FenwickTree(int[] arr) {
            this.size = arr.length;
            this.bit = new int[this.size + 1];
            this.arr = arr;

        }

        public void buildTree() {
            for (int i = 0; i < this.size; i++) {
                updateTree(i + 1, this.arr[i]);
            }
        }

        public void updateTree(int i, int element) {
            while (i <= this.size) {
                bit[i] = Math.max(element, bit[i]);
                i += (i & (-i));
            }
        }


        public int queryMax(int index) {
            int max = 0;
            while (index > 0) {
                max = Math.max(max, bit[index]);
                index -= (index & (-index));
            }
            return max;
        }
    }

}
