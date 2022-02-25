package com.algo.greedy;

import java.util.Arrays;

public class MeetingRoom {

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
//        int[] start = {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924};
//        int[] end = {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252 };
        scheduleMeeting(start, end);
    }

    private static void scheduleMeeting(int[] start, int[] end) {
        Meeting[] meetings = createMeetings(start, end);
        Arrays.sort(meetings, (e1, e2) -> e1.getEndTime() - e2.getEndTime());
        int endTime = 0;
        for (Meeting meeting : meetings) {
            if (meeting.getStartTime() >= endTime) {
                System.out.println(meeting);
                endTime = meeting.getEndTime();
            }
        }
    }

    private static Meeting[] createMeetings(int[] start, int[] end) {
        Meeting[] meetings = new Meeting[start.length];
        for (int i = 0; i < start.length; i++) {
            meetings[i] = new Meeting(i + 1, start[i], end[i]);
        }
        return meetings;
    }


    private static class Meeting {

        private int id;

        private int startTime;

        private int endTime;

        public Meeting(int id, int startTime, int endTime) {
            this.id = id;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "id=" + id +
                    ", startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }
    }


}
