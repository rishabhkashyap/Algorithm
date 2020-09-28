package com.algo.stack;

import java.util.Stack;

public class PostfixEvaluator {
    public static void main(String[] args) {
        String expression = "231*+9-";
        System.out.println("Result = " + evaluateExpression(expression));
    }

    private static int evaluateExpression(String expression) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                int digit = ch - '0';
                stack.push(digit);
            } else {
                int result = performOperation(ch, stack);
                stack.push(result);
            }
        }
        return stack.peek();
    }

    private static int performOperation(char operator, Stack<Integer> stack) {
        int op1 = stack.pop();
        int op2 = stack.pop();
        switch (operator) {
            case '+':
                return op1 + op2;
            case '-':
                return op2 - op1;
            case '/':
                return op2 / op1;
            case '*':
                return op2 * op1;
            default:
                throw new IllegalArgumentException("Not a valid mathematical operator");
        }


    }
}
