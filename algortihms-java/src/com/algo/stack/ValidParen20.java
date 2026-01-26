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
        Set<Character> set = Set.of('(', '{', '[');
        Stack<Character> stack = new Stack<>();
        for (char ch : string.toCharArray()) {
            if (set.contains(ch)) {
                stack.push(ch);
            } else {
                var openBracket = getOpenBracket(ch);
                if (!stack.isEmpty() && stack.peek() == openBracket) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static char getOpenBracket(char ch) {
        return switch (ch) {
            case ']' -> '[';
            case '}' -> '{';
            case ')' -> '(';
            default -> throw new IllegalArgumentException();
        };
    }

}
