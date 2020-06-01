package com.algo.dp;

public class MinStepsToOne {

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Minimum steps to reach from " + n + " to 1 = " + findMinStepsToOneTopDown(n));
    }

    private static int findMinStepsToOneTopDown(int n) {
        int[] arr = new int[100];
        return findMinStepHelper(n, arr);
    }

    private static int findMinStepHelper(int n, int[] arr) {
        if (n == 1) {
            return 0;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        int option1 = Integer.MAX_VALUE;
        int option2 = Integer.MAX_VALUE;
        if (n % 3 == 0) {
            option1 = findMinStepHelper(n / 3, arr)+1;
        }
        if (n % 2 == 0) {
            option2 = findMinStepHelper(n / 2, arr)+1;
        }
        int option3 = findMinStepHelper(n - 1, arr)+1;
        arr[n] = Math.min(option1, Math.min(option2, option3));
        return arr[n];
    }
}
