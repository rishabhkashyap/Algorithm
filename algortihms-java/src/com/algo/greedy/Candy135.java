package com.algo.greedy;
//Problem: https://leetcode.com/problems/candy/
//Approach: https://leetcode.com/problems/candy/discuss/42774/Very-Simple-Java-Solution-with-detail-explanation
import java.util.Arrays;

public class Candy135 {
    public static void main(String[] args) {
        int[] ratings = {1, 2, 2};
        System.out.println(minCandyCount(ratings));
    }

    private static int minCandyCount(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                candies[i + 1] = candies[i] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; --i) {
            if (ratings[i - 1] > ratings[i] && candies[i - 1] < candies[i] + 1) {
                candies[i - 1] = candies[i] + 1;
            }
        }
        return Arrays.stream(candies).sum();
    }
}
