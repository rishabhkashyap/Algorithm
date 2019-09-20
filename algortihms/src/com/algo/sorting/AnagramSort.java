package com.algo.sorting;

import java.util.*;

public class AnagramSort {

    public static void main(String[] args) {
        List<String> anagrams = Arrays.asList("CARS", "REPAID", "DUES", "NOSE", "SIGNED", "LANE",
                "PAIRED", "ARCS", "GRAB", "USED", "ONES", "BRAG",
                "SUED", "LEAN", "SCAR", "DESIGN");
        groupAnagrams(anagrams);
    }

    private static void groupAnagrams(List<String> anagrams) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String string : anagrams) {
            String temp = sortString(string);
            addToMap(anagramMap, temp, string);
        }
        anagramMap.forEach((key, value) -> printAnagrams(value));


    }


    private static void addToMap(Map<String, List<String>> anagramMap, String temp, String string) {
        if (anagramMap.containsKey(temp)) {
            List<String> stringList = anagramMap.get(temp);
            stringList.add(string);
            anagramMap.put(temp, stringList);
        } else {
            List<String> stringList = new ArrayList<>();
            stringList.add(string);
            anagramMap.put(temp, stringList);
        }
    }

    private static String sortString(String string) {
        char[] arr = string.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }

    private static void printAnagrams(List<String> value) {
        value.forEach(e -> System.out.print(e + "\t"));
        System.out.println();
    }
}
