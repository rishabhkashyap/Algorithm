package com.algo.dp;

import java.util.HashMap;
import java.util.Map;

//Problem: https://leetcode.com/problems/target-sum/

public class TargetSum494 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        var target = 3;
        System.out.println(countTargetWays1(arr, target));
        System.out.println(countTargetWays2(arr, target));
    }


    private static int countTargetWays1(int[] arr, int target) {
        return countTargetWays1(arr, target, 0, 0);
    }

    private static int countTargetWays1(int[] arr, int target, int i, int sum) {
        if (target == sum && i == arr.length) {
            return 1;
        }
        if (i >= arr.length) {
            return 0;
        }
        return countTargetWays1(arr, target, i + 1, sum + arr[i])
                + countTargetWays1(arr, target, i + 1, sum - arr[i]);

    }

    private static int countTargetWays2(int[] arr, int target) {
        Map<String, Integer> map = new HashMap<>();
        return countTargetWays2(arr, target, 0, 0, map);
    }

    private static int countTargetWays2(int[] arr, int target, int i, int sum,
                                        Map<String, Integer> map) {
        if (target == sum && i == arr.length) {
            return 1;
        }
        if (i >= arr.length) {
            return 0;
        }
        var key = "" + i + "-" + sum;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        var count = countTargetWays2(arr, target, i + 1, sum + arr[i], map)
                + countTargetWays2(arr, target, i + 1, sum - arr[i], map);
        map.put(key, count);
        return count;
    }
}
