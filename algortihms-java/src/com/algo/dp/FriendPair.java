package com.algo.dp;

public class FriendPair {
    public static void main(String[] args) {
        int k = 5;
        int result = generateFriendPair(k);
        System.out.println("Number of generated pairs = " + result);
    }

    private static int generateFriendPair(int k) {
        int[] arr = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            if (i <= 2) {
                arr[i] = i;
            } else {
                arr[i] = arr[i - 1] + arr[i - 2] * (i - 1);
            }
        }
        return arr[k];
    }
}
