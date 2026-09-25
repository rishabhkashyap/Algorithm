package com.algo.stack;


import java.util.Arrays;
import java.util.Stack;

//Problem: https://leetcode.com/problems/daily-temperatures/description/
//Problem: https://neetcode.io/problems/daily-temperatures/question
public class DailyTemp739 {
    static void main() {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = findNextHighTemp(arr);
        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
    }

    private static int[] findNextHighTemp(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        var j = arr.length - 1;
        stack.push(arr.length - 1);
        result[j--] = 0;
        for (int i = arr.length - 2; i >= 0; --i) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[j--] = 0;
            } else {
                result[j--] = stack.peek() - i;
            }
            stack.push(i);
        }
        return result;
    }
}
