package com.algo.hashing;

import java.util.*;

//Problem: https://leetcode.com/problems/group-anagrams/

public class Anagram49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedString = String.valueOf(arr);
            List<String> list = map.getOrDefault(sortedString, new ArrayList<>());
            list.add(str);
            map.put(sortedString, list);
        }
        return new ArrayList<>(map.values());
    }
}
