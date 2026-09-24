package com.algo.stack;

import java.util.Set;
import java.util.Stack;

//Problem: https://leetcode.com/problems/valid-parentheses/description/

public class ValidParen20 {
    public static void main(String[] args) {
        var string = "()[]{}";
        System.out.println(isValidString(string));
    }

    private static boolean isValidString(String string) {
        if (string == null || string.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (stack.isEmpty() || stack.pop() != charToRemove(ch)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private static char charToRemove(char ch) {
        return switch (ch) {
            case ']' -> '[';
            case '}' -> '{';
            case ')' -> '(';
            default -> throw new IllegalArgumentException();
        };
    }

}
