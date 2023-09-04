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
                map.put(string.charAt(left), map.get(string.charAt(left)) - 1);
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
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxLen = Integer.MIN_VALUE;
        int maxCharFreq = 0;
        while (i < string.length() && j < string.length()) {
            map.put(string.charAt(j), map.getOrDefault(string.charAt(j), 0) + 1);
            maxCharFreq = Math.max(maxCharFreq, map.get(string.charAt(j)));
            while (j - i + 1 - maxCharFreq > k) {
                map.put(string.charAt(i), map.get(string.charAt(i)) - 1);
                ++i;
            }
            maxLen = Math.max(maxLen, j - i + 1);
            ++j;
        }
        return maxLen;
    }

}
