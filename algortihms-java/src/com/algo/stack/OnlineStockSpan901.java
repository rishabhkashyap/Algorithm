package com.algo.stack;

//Problem: https://leetcode.com/problems/online-stock-span/description/

import java.util.Stack;

public class OnlineStockSpan901 {
    public static void main(String[] args) {
        var stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));

    }

    private static class StockSpanner {

        private final Stack<Stock> stack;

        public StockSpanner() {
            stack = new Stack<>();
        }

        public int next(int price) {
            var span = 1;
            while (!stack.isEmpty() && price >= stack.peek().value) {
                var stock = stack.pop();
                span += stock.span();
            }
            stack.push(new Stock(price, span));
            return span;
        }

        private record Stock(int value, int span) {
        }

    }
}
