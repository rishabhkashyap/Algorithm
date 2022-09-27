package com.algo.search;

import java.util.HashMap;
import java.util.Map;
//Problem:https://leetcode.com/problems/majority-element/
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(findMajorityElement(arr));
    }

    private static int findMajorityElement(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int maj = 0;
        for (int num : arr) {
            int count = map.getOrDefault(num, 0);
            ++count;
            if (count > arr.length / 2) {
                return num;
            }
            map.put(num, count);

        }
        return 0;
    }
}
