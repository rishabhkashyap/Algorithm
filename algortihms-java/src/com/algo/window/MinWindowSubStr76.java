package com.algo.window;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MinWindowSubStr76 {
    static void main() {
        String s = "a";
        String t = "b";
        System.out.println(getSubStr(s, t));
        System.out.println(getSubStr2(s, t));
    }

    private static String getSubStr(String str, String pattern) {
        int start = -1;
        int end = -1;
        int minLen = Integer.MAX_VALUE;
        Map<Character, Integer> pMap = getMap(pattern);
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        while (i < str.length()) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (contains(map, pMap)) {
                if (i - j + 1 < minLen) {
                    minLen = i - j + 1;
                    start = j;
                    end = i;
                }
                int count = map.get(str.charAt(j));
                if (--count == 0) {
                    map.remove(str.charAt(j));
                } else {
                    map.put(str.charAt(j), count);
                }
                ++j;
            }
            ++i;
        }
        return start == -1 ? "" : str.substring(start, end + 1);
    }

    private static String getSubStr2(String str, String pattern) {
        if (pattern.length() > str.length()) {
            return "";
        }
        Map<Character, Integer> patternMap = getMap(pattern);
        int required = patternMap.size();
        int found = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int minLen = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;
        while (i < str.length()) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (patternMap.containsKey(ch) && map.get(ch) >= patternMap.get(ch)) {
                ++found;
            }
            while (found == required) {
                if (i - j + 1 < minLen) {
                    start = j;
                    end = i;
                    minLen = i - j + 1;
                }
                ch = str.charAt(j);
                int count = map.get(ch);
                if (--count == 0) {
                    map.remove(ch);
                } else {
                    map.put(ch, count);
                }
                if (patternMap.containsKey(ch) && (!map.containsKey(ch) || map.get(ch) < patternMap.get(ch))) {
                    --found;
                }
                ++j;
            }
            ++i;
        }
        return start == 1 && end == -1 ? "" : str.substring(start, end + 1);
    }

    private static Map<Character, Integer> getMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }

    private static boolean contains(Map<Character, Integer> map, Map<Character, Integer> pMap) {
        Set<Character> set = pMap.keySet();
        for (Character ch : set) {
            if (!map.containsKey(ch) || map.get(ch) < pMap.get(ch)) {
                return false;
            }
        }
        return true;
    }
}
