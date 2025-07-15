package com.algo.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Problem: https://leetcode.com/problems/letter-case-permutation/description/
public class LetterCasePermutation784 {
    public static void main(String[] args) {
        var str = "a1b2";
        List<String> result = letterPermutation1(str);
        System.out.println(result);
        result.clear();
        result = letterPermutation2(str);
        System.out.println(result);
    }

    private static List<String> letterPermutation1(String str) {
        Set<String> result = new HashSet<>();
        letterPermutation1(str, 0, "", result);
        return new ArrayList<>(result);
    }

    private static void letterPermutation1(String str, int index, String temp, Set<String> result) {
        if (temp.length() == str.length()) {
            result.add(temp);
            return;
        }
        if (index >= str.length()) {
            return;
        }
        var ch = str.charAt(index);
        if (Character.isLetter(ch)) {
            if (Character.isLowerCase(ch)) {
                letterPermutation1(str, index + 1, temp + Character.toUpperCase(ch), result);
            } else {
                letterPermutation1(str, index + 1, temp + Character.toLowerCase(ch), result);
            }
        }
        letterPermutation1(str, index + 1, temp + ch, result);
    }

    private static List<String> letterPermutation2(String str) {
        List<String> result = new ArrayList<>();
        letterPermutation2(str.toCharArray(), 0, result);
        return result;
    }

    private static void letterPermutation2(char[] arr, int index, List<String> result) {
        if (index == arr.length) {
            result.add(new String(arr));
            return;
        }
        if (Character.isUpperCase(arr[index])) {
            arr[index] = Character.toLowerCase(arr[index]);
            letterPermutation2(arr, index + 1, result);
            arr[index] = Character.toUpperCase(arr[index]);
        } else {
            arr[index] = Character.toUpperCase(arr[index]);
            letterPermutation2(arr, index + 1, result);
            arr[index] = Character.toLowerCase(arr[index]);
        }
        letterPermutation2(arr, index + 1, result);
    }
}
