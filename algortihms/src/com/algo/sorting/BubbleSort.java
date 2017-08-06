package com.algo.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int[]arr={5,2,1,10,6,9};
		sort(arr);
		for(int i:arr){
			System.out.print(i+"  ");
		}

	}
	
	private  static void sort(int[]a){
		for(int i=0;i<a.length-1;i++){
			for(int j=0;j<a.length-i-1;j++){
				if(a[j]<a[j+1]){
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
	}

}
