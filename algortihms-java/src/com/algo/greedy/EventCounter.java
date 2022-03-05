package com.algo.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
public class EventCounter {
    public static void main(String[] args) {
        int[][] arr = {{1, 4}, {4, 4}, {2, 2}, {3, 4}, {1, 1}};
        System.out.println(countEvents(arr));

    }

    private static int countEvents(int[][] arr) {
        Event[] eventsArr = createEvents(arr);
        Arrays.sort(eventsArr, (e1, e2) -> e1.start - e2.start);
        Queue<Integer> queue = new PriorityQueue<>();
        int day = 1;
        int i = 0;
        int eventCount = 0;
        while (i < eventsArr.length || !queue.isEmpty()) {
            while (i < eventsArr.length && day == eventsArr[i].start) {
                queue.add(eventsArr[i++].end);
            }
            if (!queue.isEmpty()) {
                queue.remove();
                ++eventCount;
            }
            ++day;
            while (!queue.isEmpty() && day > queue.peek()) {
                queue.remove();
            }
        }
        return eventCount;
    }

    private static Event[] createEvents(int[][] arr) {
        Event[] events = new Event[arr.length];
        for (int i = 0; i < events.length; i++) {
            events[i] = new Event(arr[i][0], arr[i][1]);
        }
        return events;
    }

    private static class Event {

        private final int start;

        public int end;


        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }


    }
}
