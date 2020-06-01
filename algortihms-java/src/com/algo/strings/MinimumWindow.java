package com.algo.strings;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindow {

    public static void main(String[] args) {
//        String string = "this is a test string";
//        String pattern = "tist";
//        String string = "tutorial cup";
//        String pattern = "oti";
        String string = "zaaskzaazaaasbjdskk";
        String pattern = "zsk";
        System.out.println(findSmallestWindow(string, pattern));
    }

    private static String findSmallestWindow(String string, String pattern) {
        Map<Character, Integer> stringMap = new HashMap<>();
        Map<Character, Integer> patternMap = getPatternMap(pattern);
        int minWindowLength = Integer.MAX_VALUE;
        String window = null;
        int freqCountInWindow = 0;
        int right = 0;
        int left = 0;
        while (right < string.length()) {
            addCharacterToMap(stringMap, string.charAt(right));
            if (patternMap.containsKey(string.charAt(right))
                    && requiredCharacterFound(stringMap, patternMap, string.charAt(right))) {
                ++freqCountInWindow;
            }
            while (freqCountInWindow == patternMap.size() && left <= right) {
                int minWindowLengthSoFar = right - left + 1;
                if (minWindowLength > minWindowLengthSoFar) {
                    minWindowLength = minWindowLengthSoFar;
                    window = string.substring(left, right + 1);
                }
                removeCharacterFromMap(stringMap, string.charAt(left));
                if (patternMap.containsKey(string.charAt(left))
                        && isRequiredCharacterLow(stringMap, patternMap, string.charAt(left))) {
                    --freqCountInWindow;
                }
                ++left;
            }
            ++right;
        }
        return window;
    }

    private static Map<Character, Integer> getPatternMap(String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                int count = map.get(pattern.charAt(i));
                map.put(pattern.charAt(i), ++count);
            } else {
                map.put(pattern.charAt(i), 1);
            }
        }
        return map;
    }

    private static void addCharacterToMap(Map<Character, Integer> stringMap, char character) {
        int count = stringMap.getOrDefault(character, 0);
        stringMap.put(character, ++count);
    }

    private static boolean requiredCharacterFound(Map<Character, Integer> stringMap,
                                                  Map<Character, Integer> patternMap,
                                                  char character) {
        return stringMap.get(character) == patternMap.get(character) ? true : false;
    }

    private static boolean isRequiredCharacterLow(Map<Character, Integer> stringMap,
                                                  Map<Character, Integer> patternMap,
                                                  char character) {
        return stringMap.get(character) < patternMap.get(character) ? true : false;
    }

    private static void removeCharacterFromMap(Map<Character, Integer> stringMap, char character) {
        int count = stringMap.get(character);
        stringMap.put(character, --count);
    }
}
