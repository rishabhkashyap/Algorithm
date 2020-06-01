package com.algo.greedy;


public class WaterContainer {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 5};
       // int[] arr = {1, 5, 4, 3};
        System.out.println(getMaxWaterAmount(arr));
    }

    private static int getMaxWaterAmount(int[] arr) {
        int area = Integer.MIN_VALUE;
        int left=0;
        int right=arr.length-1;
        while (left<right){
            int currentArea=Math.min(arr[left],arr[right])*(right-left);
            area=Math.max(currentArea,area);
            if(arr[left]<arr[right]){
                ++left;
            }else {
                --right;
            }

        }
        return area;
    }




}
