package com.algo.window;

import java.util.HashMap;
import java.util.Map;

public class KUniqueCharSubStr {
    public static void main(String[] args) {
        String str = "aabbcc";
        int k = 3;
        String result = findLongestSubStr(str, k);
        System.out.println("Longest substring with k unique characters = " + result);
    }

    private static String findLongestSubStr(String str, int k) {
        int i = 0;
        int j = 0;
        String result = "";
        int len = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        while (j < str.length()) {
            int count = map.getOrDefault(str.charAt(j), 0);
            map.put(str.charAt(j), ++count);
            if (map.size() == k) {
                if (len < j - i + 1) {
                    len = j - i + 1;
                    result = str.substring(i, j + 1);
                }
            }
            while (map.size() > k) {
                if (map.containsKey(str.charAt(i))) {
                    int freq = map.get(str.charAt(i));
                    if (--freq == 0) {
                        map.remove(str.charAt(i));
                    } else {
                        map.put(str.charAt(i), freq);
                    }
                }
                ++i;
            }
            ++j;
        }
        return result;

    }
}
