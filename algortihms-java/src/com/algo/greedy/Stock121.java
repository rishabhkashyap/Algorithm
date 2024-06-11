package com.algo.greedy;

public class Stock121 {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(findMaxProfit(arr));
    }

    private static int findMaxProfit(int[] arr) {
        var profit = 0;
        var buy = Integer.MAX_VALUE;
        for (int price : arr) {
            var currProfit = price - buy;
            profit = Math.max(profit, currProfit);
            buy = Math.min(buy, price);
        }
        return profit;
    }
}
