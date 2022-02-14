package com.algo.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinChange {
    public static void main(String[] args) {
        List<Integer> availableChange = Arrays.asList(1, 2, 5, 10, 20, 50, 100, 500, 200, 2000);
        int amount = 2194;
        int minChange = getMinChangeCount(amount, availableChange);
        System.out.println("\n\nGet minimum change = " + minChange);
        System.out.println("\n");
        minChange = getMinChange2(amount, availableChange);
        System.out.println("\nGet minimum change = " + minChange);
        System.out.println("\n");
        minChange = getMinChange3(amount, availableChange);
        System.out.println("\nGet minimum change = " + minChange);


    }

    private static int getMinChangeCount(int amount, List<Integer> availableChange) {
        Collections.sort(availableChange);
        int count = 0;
        List<Integer> changeDenomination = new ArrayList<>();
        while (amount > 0) {
            int minChange = 0;
            for (Integer change : availableChange) {
                if (change <= amount) {
                    minChange = change;
                }
            }
            changeDenomination.add(minChange);
            amount -= minChange;
            ++count;

        }
        System.out.println("***************Denomination***************** ");
        changeDenomination.forEach(e -> System.out.print(e + "\t"));
        return count;
    }

    private static int getMinChange2(int amount, List<Integer> denomination) {
        denomination.sort((e1, e2) -> e2.compareTo(e1));
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int count = 0;
        while (amount > 0) {
            if (i < denomination.size() && amount >= denomination.get(i)) {
                amount -= denomination.get(i);
                ++count;
                result.add(denomination.get(i));
            } else {
                ++i;
            }
        }
        System.out.println("***************Denomination***************** ");
        result.forEach(e -> System.out.print(e + "\t"));
        return count;

    }

    private static int getMinChange3(int amount, List<Integer> denomination) {
        denomination.sort((e1, e2) -> e2.compareTo(e1));
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (Integer change : denomination) {
            while (amount >= change) {
                result.add(change);
                amount -= change;
                ++count;
            }
        }
        System.out.println("***************Denomination***************** ");
        result.forEach(e -> System.out.print(e + "\t"));
        return count;

    }

}
