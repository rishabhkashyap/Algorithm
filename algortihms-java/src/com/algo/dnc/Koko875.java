package com.algo.dnc;

import java.util.Arrays;


//Problem: https://leetcode.com/problems/koko-eating-bananas/description/
public class Koko875 {
    static void main() {
        int[] arr = {3, 6, 7, 11};
        int h = 8;
        System.out.println(findEatingSpeed(arr, h));
    }

    private static int findEatingSpeed(int[] arr, int h) {
        int low = 1;
        int high = Arrays.stream(arr).max().getAsInt();
        int result = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canFinishBananas(arr, h, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private static boolean canFinishBananas(int[] arr, int h, int mid) {
        int hours = 0;
        for (int num : arr) {
            if (num % mid == 0) {
                hours += (num / mid);
            } else {
                hours += (num / mid) + 1;
            }
            if (hours > h) {
                return false;
            }
        }
        return true;
    }
}
