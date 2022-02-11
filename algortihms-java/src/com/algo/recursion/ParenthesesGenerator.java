package com.algo.recursion;

import java.util.ArrayList;
import java.util.List;

public class ParenthesesGenerator {
    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateBalancedString(n);
        result.forEach(e -> System.out.println(e));
    }

    private static List<String> generateBalancedString(int n) {
        String str = "";
        List<String> list = new ArrayList<>();
        generateBalancedString(str, n, n, list);
        return list;
    }

    private static void generateBalancedString(String str, int open, int close, List<String> list) {
        if (open == 0 && close == 0) {
            list.add(str);
            return;
        }
        if (open > 0) {
            generateBalancedString(str + '(', open - 1, close, list);
        }
        if (close > 0 && close > open) {
            generateBalancedString(str + ')', open, close - 1, list);
        }
    }
}
