package com.algo.window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class NonRepeatedCharacter3 {
    public static void main(String[] args) {
        // String str = "ABDEFGABEF";
        String str = "GEEKSFORGEEKS";
        System.out.println("Length of longest substring without repeated characters = "
                + longestNonRepeatedSubstr1(str));
        System.out.println("Length of longest substring without repeated characters = "
                + longestNonRepeatedSubstr2(str));

    }

    private static int longestNonRepeatedSubstr1(String str) {
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int maxLen = 0;
        while (j < str.length()) {
            while (set.contains(str.charAt(j))) {
                set.remove(str.charAt(i));
                ++i;
            }
            set.add(str.charAt(j));
            maxLen = Math.max(maxLen, j - i + 1);
            ++j;
        }
        return maxLen;
    }

    private static int longestNonRepeatedSubstr2(String str) {
        if (str.length() == 0) {
            return 0;
        }
        int len = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (j < str.length()) {
            map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);
            while (map.size() < j - i + 1) {
                int freq = map.get(str.charAt(i));
                if (--freq == 0) {
                    map.remove(str.charAt(i));
                } else {
                    map.put(str.charAt(i), freq);
                }
                ++i;
            }
            if (map.size() == j - i + 1) {
                len = Math.max(len, j - i + 1);
            }
            ++j;
        }
        return len;
    }
}
