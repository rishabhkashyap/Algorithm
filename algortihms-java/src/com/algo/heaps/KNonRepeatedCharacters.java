package com.algo.heaps;

import java.util.*;

public class KNonRepeatedCharacters {
    public static void main(String[] args) {
        String string = "ABCDBAGHCHFACN";
        int k = 4;
        List<Character> result = getKNonRepeatedChars1(string, k);
        result.forEach(e -> System.out.print(e + "\t"));
        System.out.println();
        result = getKNonRepeatedCharacters2(string, k);
        result.forEach(e -> System.out.print(e + "\t"));

    }

    //Using linkedHashMap
    private static List<Character> getKNonRepeatedChars1(String string, int k) {
        List<Character> result = new ArrayList<>();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < string.length(); i++) {
            int count = map.getOrDefault(string.charAt(i), 0);
            map.put(string.charAt(i), ++count);
        }
        int i = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1 && i < k) {
                result.add(entry.getKey());
                ++i;
            }
        }
        return result;
    }

    //Using Priority queue
    private static List<Character> getKNonRepeatedCharacters2(String string, int k) {
        List<Character> result = new ArrayList<>();
        Map<Character, Pair> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            Pair pair = map.getOrDefault(string.charAt(i), new Pair());
            pair.setCount(pair.getCount() + 1);
            pair.setIndex(i);
            map.put(string.charAt(i), pair);
        }
        Queue<Pair> queue = new PriorityQueue<>((e1, e2) -> e1.getIndex() - e2.getIndex());
        for (Pair pair : map.values()) {
            if (pair.getCount() == 1) {
                queue.add(pair);
            }
        }
        int i = 0;
        while (!queue.isEmpty() && i < k) {
            Pair pair = queue.remove();
            result.add(string.charAt(pair.getIndex()));
            ++i;
        }
        return result;

    }

    private static class Pair {
        private int index;
        private int count;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
