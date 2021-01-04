package com.algo.dnc;

public class MissingTerm {
    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 13, 16};
        //int[] arr = {5, 7, 9, 11, 15};
        int missingTerm = findMissingTerm(arr);
        System.out.println("Missing term = " + missingTerm);
    }

    private static int findMissingTerm(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int missingTerm = -1;
        int difference = (arr[arr.length - 1] - arr[0]) / arr.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] - arr[mid - 1] != difference) {
                missingTerm = arr[mid] - difference;
                break;
            } else if (arr[mid + 1] - arr[mid] != difference) {
                missingTerm = arr[mid] + difference;
                break;
            } else if (arr[mid] - arr[0] != (mid - 0) * difference) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return missingTerm;
    }
}
