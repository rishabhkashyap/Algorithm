package com.algo.window;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegative {
    public static void main(String[] args) {
//        int[] arr = {-8, 2, 3, -6, 10};
//        int k = 2;
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        List<Integer> result = findFirstNegative(arr, k);
        System.out.println(result);

    }

    private static List<Integer> findFirstNegative(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            if (arr[j] < 0) {
                queue.add(arr[j]);
            }
            if (j - i + 1 > k) {
                if (arr[i] < 0 && queue.peek() == arr[i]) {
                    queue.remove();
                }
                ++i;
            }
            if (j - i + 1 == k) {
                result.add(queue.peek() != null ? queue.peek() : 0);
            }
            ++j;
        }
        return result;
    }
}
