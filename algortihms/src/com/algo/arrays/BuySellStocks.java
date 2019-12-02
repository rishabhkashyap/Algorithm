package com.algo.arrays;

public class BuySellStocks {
    public static void main(String[] args) {
        int[] price = {310, 315, 275, 295, 260, 270, 290, 230, 255, 250};
        int result = getMaxProfit(price);
        System.out.println("Result = " + result);

    }

    private static int getMaxProfit(int[] price) {
        int minSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int p : price) {
            int profit = p - minSoFar;
            maxProfit = Math.max(maxProfit, profit);
            minSoFar = Math.min(p, minSoFar);
        }
        return maxProfit;
    }
}
