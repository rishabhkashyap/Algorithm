package com.algo.search;

import java.util.HashMap;
import java.util.Map;

public class OddCount {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
        System.out.println("Element with odd count using hash table = " + findOddCountElementUsingHashset(arr));
        System.out.println("Element with odd count using XOR operation = " + findOddCountElementUsingXOR(arr));
    }

    private static int findOddCountElementUsingHashset(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int ele : arr) {
            int count = map.getOrDefault(ele, 0);
            ++count;
            map.put(ele, count);
        }
        for(int key:map.keySet()){
            if(map.get(key)%2!=-0){
                return key;
            }
        }
        return -1;
    }

    private static int findOddCountElementUsingXOR(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result ^ arr[i];
        }
        return result;
    }
}
