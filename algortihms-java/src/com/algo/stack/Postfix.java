package com.algo.stack;

import java.util.Stack;

public class Postfix {
    public static void main(String[] args) {
        String infixExpression = "a+b*(c^d-e)^(f+g*h)-i";
        //String infixExpression = "a+b";
        System.out.println("Postfix expression = " + convertToPostfix(infixExpression));
    }

    private static String convertToPostfix(String infixExpression) {
        StringBuilder result = new StringBuilder("");
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < infixExpression.length(); i++) {
            char ch = infixExpression.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                removeFromStack(stack, result);
            } else {
                addOperatorToStack(ch, stack, result);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    private static void removeFromStack(Stack<Character> stack, StringBuilder result) {
        while (!stack.isEmpty() && stack.peek() != '(') {
            result.append(stack.pop());
        }
        if (!stack.isEmpty() && stack.peek() == '(') {
            stack.pop();
        }

    }

    private static void addOperatorToStack(char ch, Stack<Character> stack, StringBuilder result) {
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
