package com.algo.window;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
       // System.out.println(minSubstring);
        return len;
    }

    private static String smallestSubstringLen2(String str, String t) {
        Map<Character, Integer> tMap = createPatternMap(t);
        int i = 0;
        int j = 0;
        int start = 0;
        int end = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        Map<Character, Integer> strMap = new HashMap<>();
        while (j < str.length()) {
            strMap.put(str.charAt(j), strMap.getOrDefault(str.charAt(j), 0) + 1);
            if (tMap.containsKey(str.charAt(j)) && strMap.get(str.charAt(j)).equals(tMap.get(str.charAt(j)))) {
                ++count;
            }
            while (count == tMap.size()) {
                if (minLen > j - i + 1) {
                    minLen = j - i + 1;
                    start = i;
                    end = j;
                }
                if (tMap.containsKey(str.charAt(i))) {
                    int freq = strMap.get(str.charAt(i));
                    if (--freq == 0) {
                        strMap.remove(str.charAt(i));
                    } else {
                        strMap.put(str.charAt(i), freq);
                    }
                    if (freq < tMap.get(str.charAt(i))) {
                        --count;
                    }
                }
                ++i;
            }
            ++j;
        }
        return minLen == Integer.MAX_VALUE ? "" : str.substring(start, end + 1);

    }

    private static Map<Character, Integer> createPatternMap(String pattern) {
        return pattern.chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
    }

}
