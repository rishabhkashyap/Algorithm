package com.algo.arrays;

import java.util.ArrayList;
import java.util.List;

public class BigNumberOp {

    public static void main(String[] arr) {

        List<Integer> number = new ArrayList<>();
        number.add(7);
        number.add(1);
        number.add(8);
        number.add(9);
        List<Integer> result = sum(number, 5);
        result.forEach(e -> System.out.print(e + "\t"));

    }

    private static List<Integer> sum(List<Integer> number, int i) {
        int size = number.size();
        int sum = number.get(size - 1) + i;
        number.set(size - 1, sum % 10);
        int carry = sum / 10;
        for (int j = size - 2; j > 0; j--) {

            if (carry == 1) {
                number.set(j, number.get(j)+carry);
                carry = number.get(j) / 10;
                number.set(j, number.get(j) % 10);
            }
        }
        if (carry == 1) {
            number.add(0, 1);
        }
        return number;
    }
}
