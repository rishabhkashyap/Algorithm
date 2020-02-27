package com.algo.strings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println("IX = " + romanToInt("IX"));
    }

    private static int romanToInt(String roman) {
        int result = 0;
        int i = 0;
        Map<Character, Integer> map = getRomanNumeralMap();
        while (i < roman.length()) {
            if (i + 1 < roman.length()) {
                if (isGreater(roman.charAt(i), roman.charAt(i + 1))) {
                    result += map.get(roman.charAt(i));
                    ++i;
                } else {
                    result += (map.get(roman.charAt(i + 1)) - map.get(roman.charAt(i)));
                    i += 2;
                }

            } else {
                result += map.get(roman.charAt(i));
                ++i;
            }

        }
        return result;
    }

    private static boolean isGreater(char ch1, char ch2) {
        Map<Character, Integer> map = getRomanNumeralMap();
        if (!(map.containsKey(ch1) && map.containsKey(ch2))) {
            throw new NoSuchElementException("One of the roman numeral is invalid");
        }
        return map.get(ch1) > map.get(ch2);
    }


    private static Map<Character, Integer> getRomanNumeralMap() {
        Map<Character, Integer> map = new LinkedHashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        return map;
    }
}
