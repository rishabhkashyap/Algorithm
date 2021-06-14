package com.algo.stack;

import java.util.Arrays;
import java.util.Stack;

public class NxtGreaterElementRight {
    public static void main(String[] args) {
        // int[] arr = {2, 1, 4, 3, 8, 9};
        //int[] arr={4, 5, 2, 25};
        int[] arr = {13, 7, 6, 12};
        int[] result = findNextGreatestElement(arr);
        Arrays.stream(arr).forEach(e -> System.out.print(e + "\t"));
        System.out.println();
        Arrays.stream(result).forEach(e -> System.out.print(e + "\t"));
    }

    private static int[] findNextGreatestElement(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; --i) {
            if (stack.isEmpty()) {
                result[i] = -1;
                stack.push(arr[i]);
            } else {
                while (!stack.isEmpty() && arr[i] > stack.peek()) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    result[i] = stack.peek();
                } else {
                    result[i] = -1;
                }
                stack.push(arr[i]);
            }
        }
        return result;
    }
}
