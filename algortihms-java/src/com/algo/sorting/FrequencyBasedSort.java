package com.algo.sorting;

import java.util.*;
import java.util.stream.Collectors;


//Element which is repeated most is the smallest elment
//If frequency is same then element whose first index is smaller will be consider smaller

public class FrequencyBasedSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 3, 8, 1, 6, 1, 3, 7, 8};
        int[] result = sort(arr);
        Arrays.stream(result).forEach(e -> System.out.print(e + "\t"));
    }

    private static int[] sort(int[] arr) {
        return sortedArray(getFreqMap(arr), arr.length);
    }

    private static int[] sortedArray(Map<Integer, ElementData> freqMap, int size) {
        List<Map.Entry<Integer, ElementData>> entryList = new ArrayList<>(freqMap.entrySet());
        entryList.sort((e1, e2) -> compareTo(e1.getValue(), e2.getValue()));
        List<ElementData> elementDataList = entryList.stream()
                .map((e) -> e.getValue())
                .collect(Collectors.toList());
        int[] resultArr = new int[size];
        int k = 0;
        for (ElementData elementData : elementDataList)
            for (int i = 0; i < elementData.getCount(); i++) {
                resultArr[k++] = elementData.getValue();
            }
        return resultArr;

    }

    private static Map<Integer, ElementData> getFreqMap(int[] arr) {
        Map<Integer, ElementData> freqMap = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (freqMap.containsKey(arr[i])) {
                ElementData elementData = freqMap.get(arr[i]);
                elementData.setCount(elementData.getCount() + 1);
                freqMap.put(arr[i], elementData);
            } else {
                ElementData elementData = new ElementData(arr[i], i, 1);
                freqMap.put(arr[i], elementData);
            }
        }
        return freqMap;
    }


    private static int compareTo(ElementData elementData1, ElementData elementData2) {
        if (elementData1.count != elementData2.count) {
            return elementData2.count - elementData1.count;
        } else {
            return elementData1.index - elementData2.index;
        }
    }

    private static class ElementData {
        private int index;
        private int count;
        private int value;

        private ElementData(int value, int index, int count) {
            this.value = value;
            this.index = index;
            this.count = count;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }


    }
}
