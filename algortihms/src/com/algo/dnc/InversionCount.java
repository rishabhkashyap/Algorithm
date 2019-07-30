package com.algo.dnc;

public class InversionCount {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Inversion inversion = new Inversion(arr);


    }


    private static class Inversion {
        private int[] arr;
        private int[] temp;

        Inversion(int[] arr) {
            this.arr = arr;
            this.temp = new int[arr.length];

        }

        private int countInversions() {
            int start = 0;
            int end = arr.length - 1;
            return mergeSort(start, end);

        }

        private int mergeSort(int start, int end) {
            int inversionCount = 0;
            if (start <= end) {
                int mid = (start + end) / 2;
                inversionCount = mergeSort(start, mid);
                inversionCount += mergeSort(mid + 1, end);
                inversionCount += merge(start, mid, end);

            }
            return inversionCount;
        }

        private int merge(int start, int mid, int end) {

            int i = start;
            int j = mid;
            int k = 0;
            int inversionCount = 0;
            while ((i <= mid - 1) && (j <= end)) {
                if (arr[i] <= arr[j]) {
                    temp[k] = arr[i];
                    ++i;
                } else {
                    inversionCount += mid - i;

                }
            }
            return inversionCount;
        }
    }
}
