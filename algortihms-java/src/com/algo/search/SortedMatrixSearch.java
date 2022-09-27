package com.algo.search;

//Problem: https://leetcode.com/problems/search-a-2d-matrix/

public class SortedMatrixSearch {
    public static void main(String[] args) {
        int[][] arr = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};

        findElement(arr, 29);
    }

    private static void findElement(int[][] arr, int key) {
        int i = 0;
        int j = arr[0].length - 1;
        while ((i < arr.length && j >= 0)) {
            if (key == arr[i][j]) {
                System.out.println(key + " found at row = " + i + " col = " + j);
                break;
            }else if(key>arr[i][j]){
                ++i;
            }else{
                --j;
            }
        }
    }
}
