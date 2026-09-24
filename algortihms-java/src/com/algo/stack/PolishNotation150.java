package com.algo.stack;


import java.util.Set;
import java.util.Stack;


//Problem: https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
//Problem: https://neetcode.io/problems/evaluate-reverse-polish-notation/question
public class PolishNotation150 {
    static void main() {
        String[] tokens = {"1", "2", "+", "3", "*", "4", "-"};
        System.out.println(evaluatePolishNotation(tokens));
    }

    private static int evaluatePolishNotation(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (!isOperator(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int val2 = stack.pop();
                int val1 = stack.pop();
                stack.push(evaluate(val1, val2, token));
            }
        }
        return stack.peek();
    }

    private static boolean isOperator(String token) {
        Set<String> operators = Set.of("+", "-", "/", "*");
        return operators.contains(token);
    }

    private static int evaluate(int val1, int val2, String token) {
        switch (token) {
            case "+" -> {
                return val1 + val2;
            }
            case "-" -> {
                return val1 - val2;
            }
            case "/" -> {
                return val1 / val2;
            }
            case "*" -> {
                return val1 * val2;
            }
            default -> throw new IllegalArgumentException();
        }
    }
}
