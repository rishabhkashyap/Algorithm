package com.algo.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//Problem: https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description/
public class SmallestRange632 {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(4, 10, 15, 24, 26));
        list.add(List.of(4, 10, 15, 24, 26));
        list.add(List.of(0, 9, 12, 20));
        list.add(List.of(5, 18, 22, 30));
        int[] result = findSmallestRange(list);
        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
    }

    private static int[] findSmallestRange(List<List<Integer>> list) {
        var max = Integer.MIN_VALUE;
        var start = 0;
        var end = Integer.MAX_VALUE;
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparing(Node::element));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null && !list.get(i).isEmpty()) {
                var ele = list.get(i).get(0);
                max = Math.max(max, ele);
                queue.add(new Node(ele, 0, i));
            }
        }
        while (!queue.isEmpty()) {
            var node = queue.remove();
            var min = node.element;
            if (max - min < end - start) {
                start = min;
                end = max;
            }
            if (node.index + 1 < list.get(node.listIndex).size()) {
                var ele = list.get(node.listIndex).get(node.index + 1);
                max = Math.max(max, ele);
                queue.add(new Node(ele, node.index + 1, node.listIndex));
            } else {
                break;
            }
        }
        return new int[]{start, end};
    }

    private record Node(int element, int index, int listIndex) {
    }

}
