package com.algo.window;


//Problem: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
public class MaxVowels1456 {
    public static void main(String[] args) {
        String string = "abciiidef";
        int k = 3;
        System.out.println(findMaxVowels(string, k));
    }

    private static int findMaxVowels(String string, int k) {
        int i = 0;
        int j = 0;
        int maxCount = 0;
        int vowelCount = 0;
        while (j < string.length()) {
            if (isVowel(string.charAt(j))) {
                ++vowelCount;
            }
            while (j - i + 1 > k) {
                if (isVowel(string.charAt(i))) {
                    --vowelCount;
                }
                ++i;
            }
            if (j - i + 1 == k) {
                maxCount = Math.max(maxCount, vowelCount);
            }
            ++j;
        }
        return maxCount;

    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
