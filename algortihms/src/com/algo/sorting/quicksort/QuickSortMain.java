package com.algo.sorting.quicksort;

public class QuickSortMain {

	public static void main(String[] args) {
		int arr[]={5,4,6,3,1,8,23};
		QuickSort quick=new QuickSort(arr);
		quick.doQuicksort(0, arr.length-1);
		for(int num:arr){
			System.out.print(num+"\t");
		}

	}

}
