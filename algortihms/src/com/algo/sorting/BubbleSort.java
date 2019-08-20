package com.algo.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int[]arr={5,2,1,10,6,9};
		sortIteratively(arr);
		for(int i:arr){
			System.out.print(i+"  ");
		}

	}
	
	private  static void sortIteratively(int[]a){
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


    private static void bubbleSortRecursion1(int[] arr, int j, int n) {
        if (n == 1) {
            return;
        }
        if (j == n - 1) {
            bubbleSortRecursion1(arr, 0, n - 1);
        }

        if (arr[j] > arr[j + 1]) {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;

        }
        bubbleSortRecursion1(arr, j + 1, n-1);
    }

    private static void sortRecurssion2(int[] a, int n) {

        for (int j = 0; j < n - 1; j++) {
            if (a[j] > a[j + 1]) {
                int temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
            }
            if (n - 1 > 1) {
                sortRecurssion2(a, n - 1);
            }
        }

    }

}
