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
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxLen = 0;
        while (i < str.length()) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.get(ch) > 1) {
                char chLeft = str.charAt(j);
                int count = map.get(chLeft);
                if (--count == 0) {
                    map.remove(chLeft);
                } else {
                    map.put(chLeft, count);
                }
                ++j;
            }
            maxLen = Math.max(maxLen, i - j + 1);
            ++i;
        }
        return maxLen;

    }
}
