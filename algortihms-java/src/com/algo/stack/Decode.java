package com.algo.stack;

import java.util.Stack;
//https://leetcode.com/problems/decode-string/
public class Decode {
    public static void main(String[] args) {
        String expression = "3[a2[c]]";
        System.out.println(decodeString(expression));
    }

    private static String decodeString(String expression) {
        String result = "";
        Stack<Integer> freqStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int i = 0;
        while (i < expression.length()) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                int num = 0;
                while (Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i) - '0');
                    ++i;
                }
                freqStack.push(num);
            } else if (ch == '[') {
                stringStack.push(result);
                result = "";
                ++i;
            } else if (ch == ']') {
                int freq = freqStack.pop();
                String string = stringStack.pop();
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < freq; ++j) {
                    sb.append(result);
                }
                result = string + sb.toString();
                ++i;
            } else {
                result += ch;
                ++i;
            }

        }
        return result;
    }
}
