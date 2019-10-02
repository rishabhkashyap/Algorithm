package com.algo.search;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstDuplicate {

    public static void main(String[] args) {
        int[] arr = {10, 5, 3, 4, 3, 5, 6};
        int[] temp = arr;
//        int duplicate = getFirstDuplicate(arr);
        int duplicate = getFirstDuplicateUsingHash(arr);
        System.out.println("First repeated element in array = " + duplicate);
    }

    private static int getFirstDuplicate(int[] arr) {
        int[] temp = Arrays.copyOf(arr, arr.length);
        int duplicate = -1;
        Arrays.sort(temp);
        for (int number : arr) {
            int freq = getFreq(temp, number);
            if (freq > 1) {
                duplicate = number;
                break;
            }
        }
        return duplicate;
    }

    private static int getFreq(int[] temp, int number) {
        int count = 0;
        int start = getFirstOccurence(temp, number);
        int end = getLastOccurence(temp, number);
        for (int i = start; i <= end; i++) {
            ++count;
        }
        return count;

    }

    private static int getFirstOccurence(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        int pos = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == key) {
                pos = mid;
                end = mid - 1;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return pos;
    }

    private static int getLastOccurence(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        int pos = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == key) {
                pos = mid;
                start = mid + 1;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return pos;
    }

    private static int getFirstDuplicateUsingHash(int[] arr) {
        int firstRepeated = -1;
        Map<Integer, Integer> freqMap = new LinkedHashMap<>();
        for (int number : arr) {
            if (freqMap.containsKey(number)) {
                int count = freqMap.get(number);
                ++count;
                freqMap.put(number, count);
            } else {
                freqMap.put(number, 1);
            }
        }
        Set<Integer> keySet = freqMap.keySet();
        for (int number : keySet) {
            if (freqMap.get(number) > 1) {
                firstRepeated = number;
                break;
            }
        }
        return firstRepeated;
    }
}
