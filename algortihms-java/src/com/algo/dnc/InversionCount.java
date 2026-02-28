package com.algo.dnc;

public class InversionCount {


    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
                //{1, 20, 6, 4, 5};
        Inversion inversion = new Inversion(arr);
        System.out.println("Number of inversion = " + inversion.countInversions());


    }

    private static class Inversion {
        private final int[] arr;

        Inversion(int[] arr) {
            this.arr = arr;
        }

        private int countInversions() {
            int start = 0;
            int end = arr.length - 1;
            return mergeSort(start, end);

        }

        private int mergeSort(int start, int end) {
            int inversionCount = 0;
            if (start < end) {
                int mid = start + (end - start) / 2;
                inversionCount = mergeSort(start, mid);
                inversionCount += mergeSort(mid + 1, end);
                inversionCount += merge(start, mid, end);
            }
            return inversionCount;
        }

        private int merge(int start, int mid, int end) {
            int[] temp = new int[end - start + 1];
            int i = start;
            int j = mid + 1;
            int k = 0;
            int result = 0;
            while (i <= mid && j <= end) {
                if (arr[i] <= arr[j]) {
                    temp[k] = arr[i];
                    ++i;
                } else {
                    temp[k] = arr[j];
                    ++j;
                    result = result + (mid - i + 1);
                }
                ++k;
            }
            while (i <= mid) {
                temp[k] = arr[i];
                ++k;
                ++i;
            }
            while (j <= end) {
                temp[k++] = arr[j];
                ++j;
            }
            i = 0;
            while (i < temp.length) {
                arr[i + start] = temp[i];
                ++i;
            }
            return result;
        }
    }
}
