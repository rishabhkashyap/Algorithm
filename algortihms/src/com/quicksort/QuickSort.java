package com.quicksort;

public class QuickSort {
	private int size;
	private int [] numbers;
	
	public QuickSort(int[] numbers){
		this.numbers=numbers;
		this.size=numbers.length;
	}
	
	public void doQuicksort(int low,int high){
		int i=low;
		int j=high;
		int pivot=numbers[low+(high-low)/2];
		
		while(i<=j){
			while(numbers[i]<pivot){
				++i;
			}
			while(numbers[j]>pivot){
				--j;
			}
			if(i<=j){
				exchange(i,j);
				++i;
				--j;
			}
		}
		if(low<j){
			doQuicksort(low,j);
		}
		if(high>i){
			doQuicksort(i,high);
		}
				
	}
	
	private  void exchange(int i,int j){
		int temp=numbers[i];
		numbers[i]=numbers[j];
		numbers[j]=temp;
	}

}
