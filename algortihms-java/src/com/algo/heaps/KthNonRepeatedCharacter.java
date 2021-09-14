package com.algo.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KthNonRepeatedCharacter {

    public static void main(String[] args) {
        String str = "abcbcdeabf";
        int k = 3;
        int index = getKthNonRepeatedCharacter(str, k);
        System.out.println(k + "th non repeated character = " + str.charAt(index));
    }

    private static int getKthNonRepeatedCharacter(String str, int k) {
        Map<Character, Pair> charMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (charMap.containsKey(ch)) {
                Pair pair = charMap.get(ch);
                ++pair.count;
                charMap.put(ch, pair);
            } else {
                Pair pair = new Pair();
                pair.index = i;
                pair.count = 1;
                charMap.put(ch, pair);
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Map.Entry<Character, Pair> entry : charMap.entrySet()) {
            if (entry.getValue().count == 1) {
                queue.add(entry.getValue().index);
            }

        }
        int element = -1;
        while (!queue.isEmpty() && k > 0) {
            element = queue.remove();
            --k;
        }

        return element;

    }

    private static class Pair implements Comparable<Pair> {
        private int index;
        private int count;


        @Override
        public int compareTo(Pair o) {
            return this.index - o.index;
        }
    }
}
