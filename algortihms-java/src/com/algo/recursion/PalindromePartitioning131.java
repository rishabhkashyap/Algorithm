package com.algo.recursion;


import java.util.ArrayList;
import java.util.List;

//Problem: https://leetcode.com/problems/palindrome-partitioning/description/
public class PalindromePartitioning131 {
    public static void main(String[] args) {
        String str = "aab";
        List<List<String>> result = getPartitions(str);
        result.forEach(System.out::println);
    }

    private static List<List<String>> getPartitions(String str) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        helper(str, list, result);
        return result;
    }

    private static void helper(String str, List<String> list, List<List<String>> result) {
        if (str.length() == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            var prefix = str.substring(0, i + 1);
            var rest = str.substring(i + 1);
            if (isPalindrome(prefix)) {
                list.add(prefix);
                helper(rest, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String str) {
        var start = 0;
        var end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            ++start;
            --end;
        }
        return true;
    }
}