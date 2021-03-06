package com.algo.search;

import java.util.*;

public class FirstDuplicate {

    public static void main(String[] args) {
        int[] arr = {10, 5, 3, 4, 3, 5, 6, 7, 6};
        System.out.println("First repeated element in array using location = " + getFirstDuplicate(arr));
        System.out.println("First repeated element in array using hashing = " + getFirstDuplicateUsingHash(arr));
        System.out.println("First repeated element in array using hash set = " + getFirstDuplicateUsingHashset(arr));

    }

    private static int getFirstDuplicate(int[] arr) {
        int[] temp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);
        for (int number : arr) {
            if (getFreq(temp, number) > 1) {
                return number;
            }
        }
        return -1;
    }


    private static int getFreq(int[] arr, int element) {
        int startIndex = getFirstOccurrence(arr, element);
        int endIndex = getLastOccurrence(arr, element);
        return endIndex - startIndex + 1;
    }

    private static int getFirstOccurrence(int[] arr, int key) {
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

    private static int getLastOccurrence(int[] arr, int key) {
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
        Map<Integer, Integer> freqMap = new LinkedHashMap<>();
        for (int number : arr) {
            int count = freqMap.getOrDefault(number, 0);
            ++count;
            freqMap.put(number, count);

        }
        Set<Integer> keySet = freqMap.keySet();
        for (int number : keySet) {
            if (freqMap.get(number) > 1) {
                return number;
            }
        }
        return -1;
    }

    private static int getFirstDuplicateUsingHashset(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int index = -1;
        for (int i = arr.length - 1; i >= 0; --i) {
            if (set.contains(arr[i])) {
                index = i;
            } else {
                set.add(arr[i]);
            }
        }
        return index != -1 ? arr[index] : -1;
    }
}
