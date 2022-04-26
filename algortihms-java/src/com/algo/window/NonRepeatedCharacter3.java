package com.algo.window;

import java.util.HashMap;
import java.util.Map;

public class NonRepeatedCharacter3 {
    public static void main(String[] args) {
        // String str = "ABDEFGABEF";
        String str = "GEEKSFORGEEKS";
        System.out.println("Length of longest substring without repeated characters = "
                + longestNonRepeatedSubstr(str));

    }

    private static int longestNonRepeatedSubstr(String str) {
        if (str.length() == 0) {
            return 0;
        }
        int len = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (j < str.length()) {
            int count = map.getOrDefault(str.charAt(j), 0);
            map.put(str.charAt(j), ++count);
            if (map.size() == j - i + 1) {
                len = Math.max(len, j - i + 1);
            }
            while (map.size() < j - i + 1) {
                if (map.containsKey(str.charAt(i))) {
                    int freq = map.get(str.charAt(i));
                    --freq;
                    if (freq == 0) {
                        map.remove(str.charAt(i));
                    } else {
                        map.put(str.charAt(i), freq);
                    }
                }
                ++i;
            }
            ++j;
        }
        return len;
    }
}
