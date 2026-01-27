package com.algo.stack;
//Problem: https://leetcode.com/problems/longest-valid-parentheses/

import java.util.Stack;

public class ValidParentheses32 {
    public static void main(String[] args) {
        String str = ")()())";
        System.out.println(validParenLen(str));
        System.out.println(validParenLen2(str));

    }


    //Brute force: generate all substring and find length of the longest valid parentheses string
    private static int validParenLen(String str) {
        int validLen = 0;
        for (int len = 1; len <= str.length(); len++) {
            for (int start = 0; start <= str.length() - len; start++) {
                int end = start + len - 1;
                if (validPren(str, start, end)) {
                    validLen = Math.max(validLen, end - start + 1);
                }
            }
        }
        return validLen;
    }

    private static boolean validPren(String str, int start, int end) {
        Stack<Character> stack = new Stack<>();
        int i = start;
        while (i <= end) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
            ++i;
        }
        return stack.isEmpty();
    }


    private static int validParenLen2(String str) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int len = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    len = Math.max(len, i - stack.peek());
                } else {
                    //Adding closing bracket index serves as a base for next valid
                    //longest parentheses string
                    stack.push(i);
                }
            }
        }
        return len;
    }
}