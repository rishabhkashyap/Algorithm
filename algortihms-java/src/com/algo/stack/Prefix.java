package com.algo.stack;

import java.util.Stack;

public class Prefix {
    public static void main(String[] args) {
      //  String expression = "(a-b/c)*(a/k-l)";
        String expression="a/b-(c+d)-e";
        System.out.println("Prefix expression = " + convertToPrefix(expression));
    }

    private static String convertToPrefix(String expression) {
        expression = reverse(expression);
        expression = swapParenthesis(expression);
        expression=convertToPostfix(expression);
        return reverse(expression);
    }

    private static String reverse(String string) {
        if (string.length() == 1) {
            return string;
        }
        return reverse(string.substring(1)) + string.charAt(0);
    }

    private static String swapParenthesis(String expression) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                sb.append(')');
            } else if (expression.charAt(i) == ')') {
                sb.append('(');
            } else {
                sb.append(expression.charAt(i));
            }
        }
        return sb.toString();
    }

    private static String convertToPostfix(String infixExpression) {
        StringBuilder result = new StringBuilder("");
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (int i = 0; i < infixExpression.length(); i++) {
            char ch = infixExpression.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                removeFromStack(stack, result);
            } else {
                addOperandToStack(ch, stack, result);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    private static void removeFromStack(java.util.Stack<Character> stack, StringBuilder result) {
        while (!stack.isEmpty() && stack.peek() != '(') {
            result.append(stack.pop());
        }
        if (!stack.isEmpty() && stack.peek() == '(') {
            stack.pop();
        }

    }

    private static void addOperandToStack(char ch, Stack<Character> stack, StringBuilder result) {
        while (!stack.isEmpty() && getPrcedence(ch) <= getPrcedence(stack.peek())) {
            result.append(stack.pop());
        }
        stack.push(ch);
    }


    private static int getPrcedence(Character operator) {

        int preference = -1;

        switch (operator) {
            case '+':
            case '-':
                preference = 1;
                break;
            case '*':
            case '/':
                preference = 2;
                break;
            case '^':
                preference = 3;
                break;
            default:
                preference = 0;
        }
        return preference;
    }
}
