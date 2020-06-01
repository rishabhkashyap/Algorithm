package com.algo.strings;

public class ReplaceRemove {
    public static void main(String[] args) {
        char[] arr = {'a', 'c', 'd', 'b', 'b', 'c', 'a'};
        System.out.println("Actual string");
        display(arr);
        updateString(arr);
        System.out.println("\n\nString after change");
        display(arr);

    }

    public static void updateString(char[] arr) {
        int numAs = countAs(arr);
        int updatedLength=removeBs(arr);
        addDs(arr, numAs,updatedLength);

    }

    private static int countAs(char[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'a') {
                ++count;
            }
        }
        return count;
    }

    private static int removeBs(char[] arr) {
        int currentIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 'b') {
                arr[currentIndex] = arr[i];
                ++currentIndex;
            }
        }
        return currentIndex;
    }

    private static void addDs(char[] arr, int numAs,int length) {
        int wIndex = length + numAs - 1;
        for (int i = length - 1; i >= 0; --i) {
            if (arr[i] == 'a') {
                arr[wIndex--] = 'd';
                arr[wIndex--] = 'd';
            } else {
                arr[wIndex--] = arr[i];
            }
        }
    }

    private static void display(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
