//
//Given an unsorted array arr[0..n-1] of size n, find the minimum length subarray arr[s..e] 
//such that sorting this subarray makes the whole array sorted.

package com.algo.sorting;


import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class SubSort {

	public static void main(String[] args) {
		int[] arr = { 10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60 };
		//int[]arr= {0, 1, 15, 25, 6, 7, 30, 40, 50};
		int leftIndex = getLeftIndex(arr);
		int rightIndex = getRightIndex(arr);
		int subSortMax=getMax(arr, leftIndex, rightIndex);
		int subSortMin=getMin(arr, leftIndex, rightIndex);
		
		//once we have max  and min from sub array
		//we have to check :
		//1.Is there any element [0,leftIndex] which is greater than subSortMin and update left index accordingly
		//2.Is there any element [rightIndex,arr.length-1] which is smaller than subSortMax and update right index accordingly
		
		leftIndex=updateLeftIndex(arr,0,leftIndex,subSortMin);
		rightIndex=updateRightIndex(arr,rightIndex, arr.length-1,subSortMax);
		
		System.out.println(" \nIndex begin = " + leftIndex + "\t Index end = " + rightIndex);
	}


	private static int updateRightIndex(int[] arr, int rightIndex, int end, int subSortMax) {
		
		for(int i=rightIndex+1;i<=end;i++) {
			if(arr[i]<subSortMax) {
				rightIndex=i;
			}
		}	
		return rightIndex;
	}


	private static int updateLeftIndex(int[] arr, int begin, int leftIndex, int subSortMin) {
		for(int i=begin;i<=leftIndex;i++ ) {
			if(arr[i]>subSortMin) {
				leftIndex=i;
			}
		}
		return leftIndex;
	}










	private static int getLeftIndex(int[] arr) {
		int leftIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				leftIndex = i;
				break;
			}
		}
		--leftIndex;
		System.out.println("left index = " + leftIndex);
		return leftIndex;
	}

	private static int getRightIndex(int[] arr) {
		int rightIndex = 0;
		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i] < arr[i - 1]) {
				rightIndex = i;
				break;
			}

		}
		System.out.println("right index = " + rightIndex);
		return rightIndex;
	}
	
	private static int getMax(int[] arr,int leftMin,int rightMax) {
		OptionalInt maxElementOpt=null;	
		maxElementOpt=Arrays.stream(arr,leftMin,rightMax)
				         .max();
				         
		
		return maxElementOpt.getAsInt();
	}
	
	private static int getMin(int[] arr,int leftMin,int rightMax) {
		OptionalInt minElementOpt=null;
		minElementOpt=Arrays.stream(arr, leftMin, rightMax)
				            .min();
		return minElementOpt.getAsInt();
	}

}
