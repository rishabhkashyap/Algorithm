package com.algo.strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class LookAndSay {
    public static void main(String[] args) {
        printSeries(7);
    }

    private static void printSeries(int n) {
        String next = "1";
        for (int i = 0; i < n; i++) {
            System.out.print(next + "\t");
            next = nextNumber(next);
        }
    }

    private static String nextNumber(String next) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;

        for (int i = 0; i < next.length(); i++) {
            if (i + 1 < next.length() && next.charAt(i) == next.charAt(i + 1)) {
                ++count;
            } else {
                stringBuilder.append(count);
                stringBuilder.append(next.charAt(i));
                count = 1;
            }
        }
        return stringBuilder.toString();
    }


    private static Map<Character, Integer> getCountMap(String next) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < next.length(); i++) {
            if (map.containsKey(next.charAt(i))) {
                int count = map.get(next.charAt(i));
                ++count;
                map.put(next.charAt(i), count);
            } else {
                map.put(next.charAt(i), 1);
            }
        }
        return map;
    }
}
