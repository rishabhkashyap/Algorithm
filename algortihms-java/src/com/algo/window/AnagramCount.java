package com.algo.window;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/

public class AnagramCount {
    public static void main(String[] args) {
        String str = "cbaebabacd";
        String pattern = "abc";
        System.out.println(countAnagrams1(str, pattern));
        System.out.println(countAnagrams2(str, pattern));
    }

    private static int countAnagrams1(String str, String pattern) {
        Map<Character, Integer> patternMap = createPatternMap(pattern);
        int i = 0;
        int j = 0;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (j < str.length()) {
            int charFreq = map.getOrDefault(str.charAt(j), 0);
            map.put(str.charAt(j), ++charFreq);
            if (j - i + 1 > pattern.length()) {
                if (map.containsKey(str.charAt(i))) {
                    charFreq = map.get(str.charAt(i));
                    --charFreq;
                    if (charFreq == 0) {
                        map.remove(str.charAt(i));
                    } else {
                        map.put(str.charAt(i), charFreq);
                    }
                    ++i;
                }
            }
            if (j - i + 1 == pattern.length()) {
                if (isAnagram(patternMap, map)) {
                    ++count;
                }
            }
            ++j;

        }
        return count;
    }

    private static boolean isAnagram(Map<Character, Integer> patternMap, Map<Character, Integer> strMap) {
        Set<Character> characters = patternMap.keySet();
        for (Character ch : characters) {
            if (!patternMap.get(ch).equals(strMap.get(ch))) {
                return false;
            }
        }
        return true;
    }

    private static int countAnagrams2(String str, String pattern) {
        Map<Character, Integer> map = createPatternMap(pattern);
        int distinctChars = map.size();
        int count = 0;
        int i = 0;
        int j = 0;
        while (j < str.length()) {
            if (map.containsKey(str.charAt(j))) {
                int freq = map.get(str.charAt(j));
                if (freq > 0) {
                    --freq;
                    map.put(str.charAt(j), freq);
                    if (freq == 0) {
                        --distinctChars;
                    }
                }
            }
            if (j - i + 1 > pattern.length()) {
                if (map.containsKey(str.charAt(i))) {
                    int freq = map.get(str.charAt(i++));
                    if (freq == 0) {
                        map.put(str.charAt(i), 1);
                        ++distinctChars;
                    } else {
                        map.put(str.charAt(i), ++freq);
                    }
                }
            }
            if (j - i + 1 == pattern.length() && distinctChars == 0) {
                ++count;
            }
            ++j;
        }
        return count;
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
}
