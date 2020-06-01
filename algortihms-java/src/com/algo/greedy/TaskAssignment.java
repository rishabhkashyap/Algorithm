package com.algo.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskAssignment {

    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 6, 4, 4};
        List<Assignment> assignments = getOptimalTaskAssignment(arr);
        assignments.forEach(e -> System.out.println(e.getTask1() + "\t" + e.getTask2()));
    }

    private static List<Assignment> getOptimalTaskAssignment(int[] tasks) {

        Arrays.sort(tasks);
        List<Assignment> assignments = new ArrayList<>();
        int i = 0;
        int j = tasks.length - 1;
        while (i < j) {
            Assignment assignment = new Assignment(tasks[i], tasks[j]);
            assignments.add(assignment);
            ++i;
            --j;

        }
        return assignments;

    }

    private static class Assignment {
        private int task1;
        private int task2;

        public Assignment(int task1, int task2) {
            this.task1 = task1;
            this.task2 = task2;
        }

        public int getTask1() {
            return task1;
        }

        public int getTask2() {
            return task2;
        }
    }
}
