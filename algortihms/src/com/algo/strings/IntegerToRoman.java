package com.algo.strings;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println("Roman eqivalent of 99 = " + intToRoman(25));
    }

    private static String intToRoman(int num) {
        Map<Integer, String> map = new LinkedHashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC ");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        List<Integer> keys = new ArrayList<>(map.keySet());
        int index = 0;
        while (num != 0) {
            int key = keys.get(index);
            int count = 0;
            if (index < map.size() && num / key > 0) {
                count = num / key;
                while (count > 0) {
                    stringBuilder.append(map.get(key));
                    --count;
                }
                num %= key;
            }
            ++index;

        }
        return stringBuilder.toString();
    }
}
