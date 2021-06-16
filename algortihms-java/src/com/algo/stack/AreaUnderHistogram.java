package com.algo.stack;

import java.util.Stack;

public class AreaUnderHistogram {
    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        // int[] arr = {2, 4};
        System.out.println("Largest area under histogram = " + findLargestArea1(arr));
    }

    private static int findLargestArea1(int[] arr) {
        int[] smallestLeft = findSmallestElementLeft(arr);
        int[] smallestRight = findSmallestElementRight(arr);
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int width = 0;
            if (smallestLeft[i] == 0 && smallestRight[i] == 0) {
                width = 1;
            } else {
                width = smallestRight[i] - smallestLeft[i] - 1;
            }

            int area = arr[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private static int[] findSmallestElementLeft(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] smallestLeft = new int[arr.length];
        stack.push(0);
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                smallestLeft[i] = stack.peek();
            } else {
                smallestLeft[i] = -1;
            }
            stack.push(i);
        }
        return smallestLeft;
    }

    private static int[] findSmallestElementRight(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] smallestRight = new int[arr.length];
        stack.push(0);
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                smallestRight[i] = stack.peek();
            } else {
                smallestRight[i] = 0;
            }
            stack.push(i);
        }

        return smallestRight;
    }
}
