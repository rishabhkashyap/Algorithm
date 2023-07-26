package com.algo.window;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//Problem: https://leetcode.com/problems/longest-repeating-character-replacement/
public class LongestRepeatingCharacter424 {
    public static void main(String[] args) {
        String string = "AABABBA";
        int k = 1;
        System.out.println(longestStringLen1(string, k));
        System.out.println(longestStringLen2(string, k));
    }


    private static int longestStringLen1(String string, int k) {
        int left = 0;
        int right = 0;
        int maxLen = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        while (left < string.length() && right < string.length()) {
            map.put(string.charAt(right), map.getOrDefault(string.charAt(right), 0) + 1);
            int maxRepeatingCharFreq = getMaxRepeatingChar(map);
            while (right - left + 1 - maxRepeatingCharFreq > k) {
                int count = map.get(string.charAt(left));
                if (--count == 0) {
                    map.remove(string.charAt(left));
                } else {
                    map.put(string.charAt(left), count);
                }
                ++left;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            ++right;
        }
        return maxLen;
    }

    private static int getMaxRepeatingChar(Map<Character, Integer> map) {
        return map.values().stream().max(Comparator.comparingInt(e -> e)).get();
    }

    //Similar to consecutive ones(leetcode problem no 1004)
    //Instead of looping through all values in map, just check current maxFrq value with the
    //latest character whose frequency is updated
    private static int longestStringLen2(String string, int k) {
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
