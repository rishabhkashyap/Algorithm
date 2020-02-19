package com.algo.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FractionalKanpsack {

    public static void main(String[] args) {
        int[] weight = {10, 40, 20, 30};
        int[] value = {60, 40, 100, 120};
        int capacity = 50;
        System.out.println("Max value = " + getMAxValue(capacity, weight, value));
    }

    private static double getMAxValue(int capacity, int[] weight, int[] value) {
        if (weight.length != value.length) {
            throw new IllegalArgumentException("Number of weights and values are not equal");
        }
        List<Item> items = getItemList(weight, value);
        int currentWeight = 0;
        int currentValue = 0;
        for (Item item : items) {
            if (currentWeight + item.getWeight() <= capacity) {
                currentWeight += item.getWeight();
                currentValue += item.getValue();
            } else {
                int remainingWeight = capacity - currentWeight;
                currentWeight += remainingWeight;
                currentValue += remainingWeight * item.getCost();

            }
        }
        return currentValue;

    }

    private static List<Item> getItemList(int[] weight, int[] value) {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < weight.length; i++) {
            items.add(new Item(weight[i], value[i]));
        }
        Collections.sort(items);
        return items;
    }

    private static class Item implements Comparable<Item> {
        private Integer weight;
        private Integer value;
        private float cost;

        private Item(Integer weight, Integer value) {
            this.weight = weight;
            this.value = value;
            this.cost = calculateCost(weight, value);
        }

        public Integer getWeight() {
            return weight;
        }

        public Integer getValue() {
            return value;
        }

        public float getCost() {
            return cost;
        }

        private float calculateCost(Integer weight, Integer value) {
            return (float) (value / weight);
        }


        @Override
        public int compareTo(Item o) {
            return (int) (o.cost - cost);
        }
    }
}
