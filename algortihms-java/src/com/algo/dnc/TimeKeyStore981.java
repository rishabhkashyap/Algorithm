package com.algo.dnc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Problem: https://leetcode.com/problems/time-based-key-value-store/description/
public class TimeKeyStore981 {
    static void main() {
    }

    private static class TimeMap {
        private final Map<String, List<Pair>> map;

        public TimeMap() {
            this.map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
           map.computeIfAbsent(key, e ->new ArrayList<>()).add(new Pair(value, timestamp));
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) {
                return "";
            }
            List<Pair> list = map.get(key);
            int low = 0;
            int high = list.size() - 1;
            String result = "";
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (timestamp >= list.get(mid).timestamp()) {
                    result = list.get(mid).value();
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return result;
        }

        private record Pair(String value, int timestamp) {
        }
    }
}
