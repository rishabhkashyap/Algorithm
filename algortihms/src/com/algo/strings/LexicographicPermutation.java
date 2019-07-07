package com.algo.strings;

import java.util.Map;
import java.util.TreeMap;

public class LexicographicPermutation {

    public static void main(String[] args) {
        String str = "aabc";
        printPermutation(str.toCharArray());
    }

    private static void printPermutation(char[] str) {
        Map<Character, Integer> countMap = getCountMap(str);
        char[] charArr = new char[countMap.size()];
        int[] charCount = new int[countMap.size()];
        int i = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            charArr[i] = entry.getKey();
            charCount[i] = entry.getValue();
            ++i;
        }
        char[] result = new char[str.length];
        permUtil(result, charArr, charCount, 0);
    }

    private static void permUtil(char[] result, char[] charArr, int[] charCount, int level) {
        if (level == result.length) {
            printStr(result);
            return;
        }
        for (int i = 0; i < charArr.length; i++) {
            if (charCount[i] != 0) {
                result[level] = charArr[i];
                --charCount[i];
                permUtil(result, charArr, charCount, level + 1);
                ++charCount[i];
            }
        }
    }

    private static void printStr(char[] result) {
        System.out.println(String.valueOf(result));
    }

    private static Map<Character, Integer> getCountMap(char[] str) {
        Map<Character, Integer> countMap = new TreeMap<>();
        for (char ch : str) {
            if (countMap.containsKey(ch)) {
                int count = countMap.get(ch);
                ++count;
                countMap.put(ch, count);
            } else {
                countMap.put(ch, 1);
            }
        }
        return countMap;
    }
}
