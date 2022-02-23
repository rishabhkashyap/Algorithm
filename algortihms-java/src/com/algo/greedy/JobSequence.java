package com.algo.greedy;

import java.util.Arrays;

public class JobSequence {
    public static void main(String[] args) {
        int[] deadline = {4, 1, 1, 1};
        int[] profit = {20, 10, 40, 30};
        System.out.println(findMaxProfit(deadline, profit));
    }

    private static int findMaxProfit(int[] deadline, int[] profit) {
        Job[] arr = new Job[deadline.length];
        for (int i = 0; i < deadline.length; i++) {
            arr[i] = new Job(i + 1, deadline[i], profit[i]);
        }
        int[] result = jobScheduling(arr, arr.length);
        return result[1];

    }
    private static int[] jobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (e1, e2) -> e2.profit - e1.profit);
        int count = 0;
        int profit = 0;
        boolean[] timeSlot = new boolean[arr.length + 1];
        for (Job job : arr) {
            int availableSlotIndex = Math.min(n, job.deadline - 1);
            while (availableSlotIndex >= 0) {
                if (timeSlot[availableSlotIndex] == false) {
                    profit += job.profit;
                    ++count;
                    timeSlot[availableSlotIndex] = true;
                    break;
                }
                --availableSlotIndex;
            }
        }
        int[] result = {count, profit};
        return result;
    }


    private static class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }
}
