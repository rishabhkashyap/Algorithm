package com.algo.recursion;


//Find all possible combinations of k numbers that add up to a number n,
//given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
import java.util.ArrayList;
import java.util.List;

public class SumItUpK {

    public static void main(String[] args) {
        int target = 10;
        int k = 3;
        printCompinations(target, k);

    }

    private static void printCompinations(int target, int k) {
        List<Integer> numbers = new ArrayList<>();
        printCombinationHelper(target, k, numbers, 1);
    }

    private static void printCombinationHelper(int target, int k, List<Integer> numbers, int i) {
        if (target == 0 && numbers.size() == k) {
            printList(numbers);
            return;
        }


        if (target < 0) {
            return;
        }
        for (int j = i; j <= 9; j++) {
            numbers.add(j);
            printCombinationHelper(target - j, k, numbers, j + 1);
            numbers.remove(numbers.size() - 1);
        }
    }

    private static void printList(List<Integer> sumNumber) {
        sumNumber.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}
