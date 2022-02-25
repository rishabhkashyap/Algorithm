package com.algo.recursion;


public class KSwaps {
    public static void main(String[] args) {
//        String number = "129814999";
//       int k = 2;
//		String number="68543";
//		int k=1;
        String number = "7599";
        int k = 3;
        System.out.println("Largest number after " + k + " swaps = " + findMaxNumber1(number, k));
    }

    //Time Complexity: O((n^2)^k).
    //For every recursive call n^2 recursive calls is generated until
    // the value of k is 0. So total recursive calls are O((n^2)^k).
    private static String findMaxNumber1(String number, int swaps) {
        char[] numArr = number.toCharArray();
        Result result = new Result();
        findMaxNumber1(numArr, swaps, result);
        return result.getNumber();
    }

    private static void findMaxNumber1(char[] arr, int swaps, Result result) {
        if (swaps == 0) {
            if (String.valueOf(arr).compareTo(result.getNumber()) > 0) {
                result.setNumber(String.valueOf(arr));
            }
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    swap(arr, i, j);
                    findMaxNumber1(arr, swaps - 1, result);
                    swap(arr, i, j);

                }
            }
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static class Result {
        private String number;

        public Result() {
            this.number = "0";
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }

}
