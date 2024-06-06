package com.algo.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
//Problem: https://leetcode.com/problems/maximum-frequency-stack/
public class MaxFreqStack895 {
    public static void main(String[] args) {
        FreqStack stack = new FreqStack();
        stack.push(5);
        stack.push(7);
        stack.push(5);
        stack.push(7);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("=======================");
        FreqStack2 stack2 = new FreqStack2();
        stack2.push(5);
        stack2.push(7);
        stack2.push(5);
        stack2.push(7);
        stack2.push(4);
        stack2.push(5);
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
    }

    private static class FreqStack {
        private final Map<Integer, Integer> map;
        private final Queue<Data> queue;
        private int id;


        public FreqStack() {
            this.map = new HashMap<>();
            this.queue = new PriorityQueue<>(
                    (e1, e2) -> e2.freq != e1.freq ? e2.freq - e1.freq : e2.id - e1.id);
            this.id = 0;
        }

        public void push(int val) {
            var freq = this.map.getOrDefault(val, 0) + 1;
            map.put(val, freq);
            ++id;
            queue.add(new Data(val, freq, id));
        }

        public int pop() {
            var data = queue.remove();
            var freq = data.freq;
            if (--freq == 0) {
                map.remove(data.value);
            } else {
                map.put(data.value, freq);
            }
            return data.value;
        }


        private record Data(int value, int freq, int id) {
        }
    }

    private static class FreqStack2 {
        private final Map<Integer, Integer> map;
        private final Map<Integer, Stack<Integer>> stackMap;
        private int max;


        public FreqStack2() {
            this.map = new HashMap<>();
            this.stackMap = new HashMap<>();
            this.max = 0;
        }

        public void push(int val) {
            var freq = this.map.getOrDefault(val, 0) + 1;
            max = Math.max(max, freq);
            map.put(val, freq);
            var stack = stackMap.getOrDefault(freq, new Stack<>());
            stack.add(val);
            stackMap.put(freq, stack);
        }

        public int pop() {
            var stack = stackMap.get(max);
            var value = stack.pop();
            if (stack.isEmpty()) {
                stackMap.remove(max);
                --max;
            }
            var freq = map.get(value);
            if (--freq == 0) {
                map.remove(value);
            } else {
                map.put(value, freq);
            }
            return value;
        }
    }
}
