package com.algo.heaps;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Median {

    public static void main(String[] args) {
        int[] stream = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
        printMedian(stream);
    }

    private static void printMedian(int[] stream) {
        Queue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> higher = new PriorityQueue<>();
        for (int number : stream) {
            addElement(number, lower, higher);
            balanceHeaps(lower, higher);
            double medain = getMedian(lower, higher);
            System.out.println("Median = " + medain);
        }
    }

    private static void addElement(int number, Queue<Integer> lower, Queue<Integer> higher) {
        if (lower.size() == 0 || number < lower.peek()) {
            lower.add(number);
        } else {
            higher.add(number);
        }
    }

    private static void balanceHeaps(Queue<Integer> lower, Queue<Integer> higher) {
        Queue<Integer> bigHeap = Math.max(lower.size(), higher.size()) == lower.size() ? lower : higher;
        Queue<Integer> smallHeap = Math.min(lower.size(), higher.size()) == lower.size() ? lower : higher;
        if (bigHeap.size() - smallHeap.size() >= 2) {
            smallHeap.add(bigHeap.remove());
        }

    }

    private static double getMedian(Queue<Integer> lower, Queue<Integer> higher) {

        double medain = 0;
        if (lower.size() == higher.size()) {
            medain = (double) (lower.peek() + higher.peek()) / 2;
        } else {
            Queue<Integer> bigHeap = Math.max(lower.size(), higher.size()) == lower.size() ? lower : higher;
            medain = bigHeap.peek();
        }
        return medain;

    }
}
