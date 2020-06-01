package com.algo.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection {

    public static void main(String[] args) {
        int[] start = {5, 5, 0, 1, 8, 3};
        int[] finish = {7, 9, 6, 2, 9, 4};

        Activity[] activities = new Activity[start.length];
        for (int i = 0; i < start.length; i++) {
            Activity activity = new Activity(start[i], finish[i]);
            activities[i] = activity;
        }
        List<Activity> activityList = getMaxNonOverlappingActivities(activities);

        activityList.forEach(e -> System.out.println(e.getStart() + "\t" + e.getEnd()));
    }

    private static List<Activity> getMaxNonOverlappingActivities(Activity[] activities) {
        Arrays.sort(activities, Comparator.comparingInt(Activity::getEnd));
        List<Activity> activityList = new ArrayList<>();
        int finishIndex = 0;
        activityList.add(activities[0]);
        for (int startIndex = 1; startIndex < activities.length; ++startIndex) {
            if (activities[startIndex].getStart() >= activities[finishIndex].getEnd()) {
                activityList.add(activities[startIndex]);
                finishIndex = startIndex;
            }
        }
        return activityList;
    }

    private static class Activity {
        private Integer start;
        private Integer end;

        public Activity(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }

        public Integer getStart() {
            return start;
        }

        public Integer getEnd() {
            return end;
        }
    }
}
