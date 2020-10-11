package com.algo.stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int[] stocks = {100, 80, 60, 70, 60, 75, 85};
        int[] span = findStockSpan1(stocks);
        Arrays.stream(span).forEach(e -> System.out.print(e + "\t"));
        System.out.println("\n");
        span = findStockSpan2(stocks);
        Arrays.stream(span).forEach(e -> System.out.print(e + "\t"));
    }

    private static int[] findStockSpan1(int[] stocks) {
        int[] span = new int[stocks.length];
        span[0] = 1;
        for (int i = 1; i < stocks.length; i++) {
            int count = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (stocks[j] < stocks[i]) {
                    ++count;
                }
            }
            span[i] = count;
        }
        return span;
    }

    private static int[] findStockSpan2(int[] stocks) {
        int[] span = new int[stocks.length];
        Stack<Integer> stack = new Stack<>();
        span[0] = 1;
        stack.push(0);
        for (int i = 1; i < stocks.length; i++) {
            int index = i;
            while (!stack.isEmpty() && stocks[stack.peek()] < stocks[i]) {
                stack.pop();
            }
            //if stack is empty then i+1 is the span for that price
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        return span;
    }
}
