package com.algo.stack;

import java.util.Stack;


public class BalancedParentheses {

    public static void main(String[] args) {
        //String string = "[()]{}{[()()]()}";
        String string = "[(])";
        System.out.println("Balanced parentheses = " + balancedParentheses(string));
    }

    private static boolean balancedParentheses(String string) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            char bracket = string.charAt(i);
            if (canAddToStack(bracket)) {
                stack.push(bracket);
            } else {
                pop(stack, bracket);
            }

        }
        return stack.size() == 0 ? true : false;
    }

    private static boolean canAddToStack(char bracket) {
        return (bracket == '(' || bracket == '[' || bracket == '{') ? true : false;
    }

    private static void pop(Stack<Character> stack, char bracket) {
        char ch = stack.peek();
        switch (bracket) {
            case ']':
                if (ch == '[') {
                    stack.pop();
                }
                break;
            case ')':
                if (ch == '(') {
                    stack.pop();
                }
                break;
            case '}':
                if (ch == '{') {
                    stack.pop();
                }
        }
    }
}
