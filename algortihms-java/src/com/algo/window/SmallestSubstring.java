package com.algo.window;

import java.util.HashMap;
import java.util.Map;

//Problem: https://leetcode.com/problems/minimum-window-substring/
public class SmallestSubstring {
    public static void main(String[] args) {
        String string = "ADOBECODEBANC";
        String pattern = "ABC";
//        String string = "a";
//        String pattern = "a";
        System.out.println(smallestSubstringLen(string, pattern));
        System.out.println(smallestSubstringLen2(string, pattern));
    }

    private static int smallestSubstringLen(String string, String pattern) {
        Map<Character, Integer> strMap = new HashMap<>();
        Map<Character, Integer> pMap = createPatternMap(pattern);
        int len = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int distinctChars = 0;
        String minSubstring = "";
        while (j < string.length()) {
            int count = strMap.getOrDefault(string.charAt(j), 0);
            strMap.put(string.charAt(j), ++count);
            if (pMap.containsKey(string.charAt(j)) && strMap.get(string.charAt(j)).equals(pMap.get(string.charAt(j)))) {
                ++distinctChars;
            }
            while (distinctChars == pMap.size() && i <= j) {
                if (len > j - i + 1) {
                    len = j - i + 1;
                    minSubstring = string.substring(i, j + 1);
                }
                strMap.put(string.charAt(i), strMap.getOrDefault(string.charAt(i), 0) - 1);
                if (pMap.containsKey(string.charAt(i)) &&
                        strMap.get(string.charAt(i)) < pMap.get(string.charAt(i))) {
                    --distinctChars;
                }
                ++i;
            }
            ++j;
        }
        System.out.println(minSubstring);
        return len;
    }

    private static int smallestSubstringLen2(String string, String pattern) {
        Map<Character, Integer> pMap = createPatternMap(pattern);
        int j = 0;
        int i = 0;
        int len = Integer.MAX_VALUE;
        int count = pMap.size();
        String minSubstring = "";
        while (j < string.length()) {
            if (pMap.containsKey(string.charAt(j))) {
                int freq = pMap.getOrDefault(string.charAt(j), 0);
                --freq;
                pMap.put(string.charAt(j), freq);
                if (freq == 0) {
                    --count;
                }
            }
            while (count == 0) {
                if (len > j - i + 1) {
                    len = j - i + 1;
                    minSubstring = string.substring(i, j + 1);
                }
                if (pMap.containsKey(string.charAt(i))) {
                    pMap.put(string.charAt(i), pMap.getOrDefault(string.charAt(i), 0) + 1);
                    if (pMap.get(string.charAt(i)) > 0) {
                        ++count;
                    }

                }
                ++i;
            }
            ++j;
        }
        System.out.println(minSubstring);
        return len;
    }

    private static Map<Character, Integer> createPatternMap(String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            int count = map.getOrDefault(pattern.charAt(i), 0);
            map.put(pattern.charAt(i), ++count);
        }
        return map;
    }

}
