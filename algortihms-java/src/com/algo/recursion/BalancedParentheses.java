package com.algo.recursion;

import java.util.*;

public class BalancedParentheses {
    public static void main(String[] args) {
        String str = "()())()";
        List<String> result = getValidParenthesesList(str);
        result.forEach(e -> System.out.println(e));
    }

    private static List<String> getValidParenthesesList(String str) {
        Set<String> set = new HashSet<>();
        int minAllowedRemovals = getMinAllowedRemovals(str);
        getValidParenthesesList(str, minAllowedRemovals, set);
        return new ArrayList<>(set);
    }

    private static int getMinAllowedRemovals(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            }
            if (str.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() == ')') {
                    stack.push(str.charAt(i));
                } else {
                    stack.pop();
                }
            }
        }
        return stack.size();
    }

    private static void getValidParenthesesList(String str, int minAllowedRemovals, Set<String> set) {

        if (minAllowedRemovals == 0) {
            if (isStringBalanced(str) && !set.contains(str)) {
                set.add(str);
            }
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            //Remove each parentheses and check recursively if balanced string is possible
            String result = str.substring(0, i) + str.substring(i + 1);
            getValidParenthesesList(result, minAllowedRemovals - 1, set);
        }

    }

    private static boolean isStringBalanced(String str) {
        return getMinAllowedRemovals(str) == 0;
    }
}
