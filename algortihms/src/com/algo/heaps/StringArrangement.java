package com.algo.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class StringArrangement {
    public static void main(String[] args) {
        String str = "aaaabc";
        String result = rearrangeString(str);
        if (result != null) {
            System.out.println("Result = " + result);
        } else {
            System.out.println("Cannot arrange string");
        }


    }

    private static String rearrangeString(String str) {
        Map<Character, Integer> freqMap = getFreq(str);
        String result = "";
        Queue<CharNode> queue = new PriorityQueue<>((CharNode node1, CharNode node2) -> node2.freq - node1.freq);
        for (int i = 0; i < 25; i++) {
            char ch = (char) (i + 97);
            if (freqMap.containsKey(ch)) {
                int frequency = freqMap.get(ch);
                CharNode charNode = new CharNode(ch, frequency);
                queue.add(charNode);
            }

        }
        CharNode previous = new CharNode('#', -1);
        while (!queue.isEmpty()) {
            CharNode charNode = queue.remove();
            result = result + charNode.ch;
            if (previous.freq > 0) {
                queue.add(previous);
            }
            --charNode.freq;
            previous = charNode;
        }
        if (result.length() != str.length()) {
            result = null;
        }
        return result;

    }

    private static Map<Character, Integer> getFreq(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!freqMap.containsKey(ch)) {
                freqMap.put(ch, 1);
            } else {
                int count = freqMap.get(ch);
                ++count;
                freqMap.put(ch, count);
            }
        }
        return freqMap;
    }

    private static class CharNode {

        private char ch;
        private int freq;

        CharNode(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
}
