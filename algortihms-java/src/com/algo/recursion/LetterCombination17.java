package com.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//Problem: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

public class LetterCombination17 {
    public static void main(String[] args) {
        var digits = "23";
        System.out.println(getCombinations(digits));
    }

    private static List<String> getCombinations(String digits) {
        Map<Character, List<String>> map = getKeypadMapping();
        List<String> result = new ArrayList<>();
        var temp = "";
        getCombinations(map, digits, 0, temp, result);
        return result;
    }

    private static void getCombinations(Map<Character, List<String>> map, String digits, int i, String temp, List<String> result) {
        if (i == digits.length()) {
            result.add(temp);
            return;
        }
        var digit = digits.charAt(i);
        List<String> chars = map.get(digit);
        for (String ch : chars) {
            temp += ch;
            getCombinations(map, digits, i + 1, temp, result);
            temp = temp.substring(0, temp.length() - 1);
        }
    }

    private static Map<Character, List<String>> getKeypadMapping() {
        return Map.of(
                '2', Arrays.asList("a", "b", "c"),
                '3', Arrays.asList("d", "e", "f"),
                '4', Arrays.asList("g", "h", "i"),
                '5', Arrays.asList("j", "k", "l"),
                '6', Arrays.asList("m", "n", "o"),
                '7', Arrays.asList("p", "q", "r", "s"),
                '8', Arrays.asList("t", "u", "v"),
                '9', Arrays.asList("w", "x", "y", "z")
        );
    }
}
