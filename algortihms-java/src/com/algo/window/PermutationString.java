package com.algo.window;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//Problem: https://leetcode.com/problems/permutation-in-string/
public class PermutationString {
    public static void main(String[] args) {
        String pattern = "ab";
        String string = "eidbaooo";
        System.out.println(containsPermutation(pattern, string));
    }


    //Similar to count anagraams problem
    private static boolean containsPermutation(String pattern, String string) {
        Map<Character, Integer> pMap = createPatternMap(pattern);
        Map<Character, Integer> strMap = new HashMap<>();
        boolean result = false;
        int i = 0;
        int j = 0;
        while (j < string.length()) {
            strMap.put(string.charAt(j), strMap.getOrDefault(string.charAt(j), 0) + 1);
            while (j - i + 1 > pattern.length()) {
                int count = strMap.get(string.charAt(i));
                --count;
                if (count == 0) {
                    strMap.remove(string.charAt(i));
                } else {
                    strMap.put(string.charAt(i), count);
                }
                ++i;
            }
            if (j - i + 1 == pattern.length()) {
                result = isPermutation(pMap, strMap);
                if (result) {
                    return result;
                }
            }
            ++j;
        }
        return result;

    }

    private static Map<Character, Integer> createPatternMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            int count = map.getOrDefault(str.charAt(i), 0);
            ++count;
            map.put(str.charAt(i), count);
        }
        return map;
    }

    private static boolean isPermutation(Map<Character, Integer> patternMap, Map<Character, Integer> strMap) {
        Set<Character> characters = patternMap.keySet();
        for (Character ch : characters) {
            if (!patternMap.get(ch).equals(strMap.get(ch))) {
                return false;
            }
        }
        return true;
    }
}
