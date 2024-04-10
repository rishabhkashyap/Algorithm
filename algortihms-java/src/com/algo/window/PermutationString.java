package com.algo.window;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

//Problem: https://leetcode.com/problems/permutation-in-string/
public class PermutationString {
    public static void main(String[] args) {
        String pattern = "ab";
        String string = "eidbaooo";
        System.out.println(containsPermutation(pattern, string));
    }


    //Similar to count anagrams problem
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
                    return true;
                }
            }
            ++j;
        }
        return false;

    }

    private static Map<Character, Integer> createPatternMap(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(c -> 1)));
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
