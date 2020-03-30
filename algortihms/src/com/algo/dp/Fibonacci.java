package com.algo.dp;

public class Fibonacci {

    public static void main(String[] args) {
        int position = 7;
        System.out.println(position + " th fibonacci number = " + computeNthFibonacciNumRecursion(position));
        System.out.println(position + " th fibonacci number = " + computeNthFibonacciNumber(position));
        System.out.println(position + " th fibonacci number = " + computeNthFibonacciBottomUp(position));
    }

    private static int computeNthFibonacciNumber(int n) {
        int[] arr = new int[n + 1];
        return fibonacciHelper(n, arr);
    }

    private static int fibonacciHelper(int n, int[] arr) {
        if (n <= 1) {
            return n;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        arr[n] = fibonacciHelper(n - 1, arr) + fibonacciHelper(n - 2, arr);
        return arr[n];
    }

    private static int computeNthFibonacciNumRecursion(int position) {
        if (position <= 1) {
            return position;
        }
        return computeNthFibonacciNumRecursion(position - 1) + computeNthFibonacciNumRecursion(position - 2);
    }

    private static int computeNthFibonacciBottomUp(int n) {
        int[] arr = new int[n + 1];
        arr[0]=0;
        arr[1]=1;
        for (int i = 2; i <= n; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
