package com.algo.dnc;

public class FirstOccurrence {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 3, 5, 6, 7, 7, 7};
        int key = 7;
        System.out.println("First occurrence of " + key + " = " + findFirstOccurrence(arr, key));
    }

    private static int findFirstOccurrence(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int loc=-1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if(key==arr[mid]){
                loc=mid;
                high=mid;
            }else if(key>arr[mid]){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return loc;
    }


}
