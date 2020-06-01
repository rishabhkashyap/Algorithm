package com.algo.sorting;

import java.util.Arrays;

public class LexicographicalSort {
    public static void main(String[] args) {
        String[] words = {"Peach", "Orange", "Mango", "Cherry", "Apple", "apple", "123", "mango","abc","ABC"};
        Arrays.sort(words);
        System.out.println("Normal sorting using java libray");
        Arrays.stream(words).forEach(e -> System.out.print(e + "\t"));
        System.out.println("\n\nLexicographical sorting");
        lexicographicalSort(words);
        Arrays.stream(words).forEach(e -> System.out.print(e + "\t"));
    }

    public static void lexicographicalSort(String[] words) {
        for (int i = 0; i < words.length-1; i++) {
            for (int j = 0; j < words.length - i - 1; ++j) {
                if (words[j].compareTo(words[j + 1]) > 0) {
                    exchange(words, j, j + 1);
                }
            }
        }
    }

    private static void exchange(String[] words, int j, int i) {
        String temp = words[j];
        words[j] = words[i];
        words[i] = temp;
    }
}
