package com.algo.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinChange {
    public static void main(String[] args) {
        List<Integer> availableChange = Arrays.asList(1, 2, 5, 10, 20, 50, 100, 500, 200, 2000);
        int amount = 70;
        int minChange = getMinChangeCount(amount, availableChange);
        System.out.println("\n\nGet minimum channge = " + minChange);

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
}
