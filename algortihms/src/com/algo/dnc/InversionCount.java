package com.algo.dnc;

public class InversionCount {


    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
                //{1, 20, 6, 4, 5};
        Inversion inversion = new Inversion(arr);
        System.out.println("Number of inversion = " + inversion.countInversions());


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
            if (start < end) {
                int mid = (start + end) / 2;
                inversionCount = mergeSort(start, mid);
                inversionCount += mergeSort(mid + 1, end);
                inversionCount += merge(start, mid, end);

            }
            return inversionCount;
        }

        private int merge(int start, int mid, int end) {

            int i = start;
            int j = mid + 1;
            int k = start;
            int inversionCount = 0;
            while ((i <= mid) && (j <= end)) {
                if (arr[i] <= arr[j]) {
                    temp[k] = arr[i];
                    ++i;
                } else {
                    temp[k] = arr[j];
                    ++j;
                    inversionCount = inversionCount + (mid - i + 1);
                }
                ++k;
            }

            while (i <= mid) {
                temp[k++] = arr[i];
                ++i;
            }
            while (j <= end) {
                temp[k++] = arr[j];
                ++j;
            }
            for (i = start; i <= end; i++) {
                arr[i] = temp[i];
            }
            return inversionCount;
        }
    }
}
