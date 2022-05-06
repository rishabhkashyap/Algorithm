package com.algo.window;

import java.util.HashMap;
import java.util.Map;
//Problem: https://leetcode.com/problems/longest-repeating-character-replacement/
public class LongestRepeatingCharacter424 {
    public static void main(String[] args) {
        String string = "AABABBA";
        int k = 1;
        System.out.println(longestStringLen(string, k));
    }

    private static int longestStringLen(String string, int k) {
        int i = 0;
        int j = 0;
        int maxLen = Integer.MIN_VALUE;
        int maxFreq = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        while (j < string.length()) {
            map.put(string.charAt(j), map.getOrDefault(string.charAt(j), 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(string.charAt(j)));
            if (j - i + 1 - maxFreq <= k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
            while (j - i + 1 - maxFreq > k) {
                int count = map.get(string.charAt(i));
                --count;
                if (count == 0) {
                    map.remove(string.charAt(i));
                } else {
                    map.put(string.charAt(i), count);
                }
                ++i;
            }
            ++j;
        }
        return maxLen;
    }

}
