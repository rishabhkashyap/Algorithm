package com.algo.segTree.bit;

public class FenwickTreeSumOp {


    public static void main(String[] args) {
        int[] arr = {2,3,1,4,7};
        FenwickTree fenwickTree=new FenwickTree(arr);
        fenwickTree.buildTree();
        System.out.println("Sum = "+fenwickTree.query(1,2));
        System.out.println("Sum = "+fenwickTree.query(2,4));

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

        private void updateTree(int i, int element) {
            while (i <= this.size) {
                bit[i] += element;
                i += (i & (-i));
            }
        }

        public int query(int left, int right) {
            return query(right) - query(left - 1);
        }

        private int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += bit[index];
                index -= (index & (-index));
            }
            return sum;
        }
    }

}
