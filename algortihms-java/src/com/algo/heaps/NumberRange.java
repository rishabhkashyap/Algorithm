package com.algo.heaps;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class NumberRange {
    public static void main(String[] args) {
        List<List<Integer>> lists = List.of(
                List.of(2, 3, 4, 8, 10, 15),
                List.of(1, 5, 12),
                List.of(7, 8, 15, 16),
                List.of(3, 6)
        );
        int[] result = findSmallestRange(lists);
        System.out.println("Range start = " + result[0] + " end = " + result[1]);
    }

    private static int[] findSmallestRange(List<List<Integer>> nums) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        Queue<Element> queue = new PriorityQueue<>(Comparator.comparing(Element::value));
        for (int i = 0; i < nums.size(); i++) {
            var value = nums.get(i).get(0);
            queue.add(new Element(i, 0, value));
            left = Math.min(left, value);
            right = Math.max(right, value);
        }
        int[] result = {left, right};
        while (true) {
            var ele = queue.remove();
            if (ele.loc() + 1 >= nums.get(ele.index()).size()) {
                break;
            }
            var nextValue = nums.get(ele.index).get(ele.loc() + 1);
            queue.add(new Element(ele.index(), ele.loc() + 1, nextValue));
            left = queue.peek().value();
            right = Math.max(right, nextValue);
            if (right - left < result[1] - result[0]) {
                result[0] = left;
                result[1] = right;
            }
        }
        return result;
    }

    private record Element(int index, int loc, int value){}


}
