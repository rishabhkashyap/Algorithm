package com.algo.arrays;

public class SpiralTraversal {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
//        int[][]arr={ { 1, 2, 3, 4, 5, 6 },
//                { 7, 8, 9, 10, 11, 12 },
//                { 13, 14, 15, 16, 17, 18 } };
        spiralTraversal(arr);
    }

    private static void spiralTraversal(int[][] arr) {
        int lastRow = arr.length;
        int lastCol = arr[0].length;
        int rowCounter = 0;
        int colCounter = 0;
        while ((rowCounter < lastRow) && (colCounter < lastCol)) {
            //Print first row
            for (int i = colCounter; i < lastCol; i++) {
                System.out.print(arr[rowCounter][i] + "\t");
            }
            ++rowCounter;
            //Print last column
            for (int i = rowCounter; i < lastRow; i++) {
                System.out.print(arr[i][lastCol-1] + "\t");
            }
            --lastCol;

            //Print last row of spiral
            if (rowCounter < lastRow) {
                for (int i = lastCol-1; i >= colCounter; --i) {
                    System.out.print(arr[lastRow-1][i] + "\t");
                }
                --lastRow;
            }

            //Print first column
            if (colCounter < lastCol) {
                for (int i = lastRow-1; i >= rowCounter; i--) {
                    System.out.print(arr[i][colCounter] + "\t");
                }
                ++colCounter;
            }
        }
    }
}
