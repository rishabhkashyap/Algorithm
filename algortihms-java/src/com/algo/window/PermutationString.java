package com.algo.window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

//Problem: https://leetcode.com/problems/permutation-in-string/
public class PermutationString {
    public static void main(String[] args) {
        String pattern = "adc";
        String string = "dcda";
        System.out.println(containsPermutation(pattern, string));
        System.out.println(containsPermutation2(pattern, string));
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

    //Efficient solution, does not use hash map
    private static boolean containsPermutation2(String pattern, String string) {
        if (pattern.length() > string.length()) {
            return false;
        }
        int[] arrPattern = new int[26];
        int[] arrStr = new int[26];
        for (int i = 0; i < pattern.length(); i++) {
            arrPattern[pattern.charAt(i) - 'a']++;
            arrStr[string.charAt(i) - 'a']++;
        }
        if (Arrays.equals(arrPattern, arrStr)) {
            return true;
        }
        // 1 Window size of pattern is already covered,so consider next window which will start from pattern.length
        for (int i = pattern.length(); i < string.length(); i++) {
            //shift window towards left by 1 and add new character from string
            arrStr[string.charAt(i - pattern.length()) - 'a']--;
            arrStr[string.charAt(i) - 'a']++;
            if (Arrays.equals(arrPattern, arrStr)) {
                return true;
            }
        }
        return false;
    }
}
