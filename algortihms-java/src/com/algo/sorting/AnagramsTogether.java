package com.algo.sorting;

import java.util.*;
import java.util.stream.Collectors;

public class AnagramsTogether {

    public static void main(String[] args) {
        String[] arr = {"CARS", "REPAID", "DUES", "NOSE", "SIGNED", "LANE", "PAIRED", "ARCS",
                "GRAB", "USED", "ONES", "BRAG", "SUED", "LEAN", "SCAR", "DESIGN"};
        printAnagrams(arr);

    }

    private static void printAnagrams(String[] arr) {
        List<String> list = getSortedList(arr);
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            List<Integer> intList = new ArrayList<>();
            map.putIfAbsent(list.get(i), intList);
            map.get(list.get(i)).add(i);
        }
        for (String key : map.keySet()) {
            List<Integer> indexes = map.get(key);
            for (int i : indexes) {
                System.out.print(arr[i] + "\t");
            }
            System.out.println();
        }


    }

    private static List<String> getSortedList(String[] arr) {
        List<String> stringList = Arrays.asList(arr);
        return stringList.stream()
                .map(e -> e.toCharArray())
                .map(e -> sort(e))
                .map(e -> new String(e))
                .collect(Collectors.toList());

    }

    private static char[] sort(char[] charArr) {
        char[] copy = Arrays.copyOf(charArr, charArr.length);
        Arrays.sort(copy);
        return copy;
    }
}
