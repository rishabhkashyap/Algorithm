package com.algo.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class Medain {

    public static void main(String[] args) {
        int[] stream = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
        printMedain(stream);
    }

    private static void printMedain(int[] stream) {
        PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> higher = new PriorityQueue<>();
        for (int number : stream) {
            addElement(number, lower, higher);
            balanceHeaps(lower, higher);
            double medain = getMedain(lower, higher);
            System.out.println("Medain = " + medain);
        }
    }

    private static double getMedain(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {

        double medain = 0;
        if (lower.size() == higher.size()) {
            medain = (double) (lower.peek() + higher.peek()) / 2;
        } else {
            PriorityQueue<Integer> bigHeap = Math.max(lower.size(), higher.size()) == lower.size() ? lower : higher;
            medain = bigHeap.peek();
        }
        return medain;

    }

    private static void balanceHeaps(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        PriorityQueue<Integer> bigHeap = Math.max(lower.size(), higher.size()) == lower.size() ? lower : higher;
        PriorityQueue<Integer> smallHeap = Math.min(lower.size(), higher.size()) == lower.size() ? lower : higher;
        if (bigHeap.size() - smallHeap.size() >= 2) {
            smallHeap.add(bigHeap.remove());
        }

    }

    private static void addElement(int number, PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        if (lower.size() == 0 || number < lower.peek()) {
            lower.add(number);
        } else {
            higher.add(number);
        }
    }
}
