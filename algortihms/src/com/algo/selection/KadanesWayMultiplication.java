package com.algo.selection;

public class KadanesWayMultiplication {

	public static void main(String[] args) {
		//int[] intArr = { 3, -1, -1, -1, -1, -1, 2, 0, 0, 0 };
		 //int[] intArr = {-1, 3, -5, 4, 6, -1, 2, -7, 13, -3};
		// int[] intArr={-6,-2,-3,-4,-1,-5,-5};
		int[] intArr=  {6, -3, -10, 0, 2};
		getMaxSubArray(intArr);

	}

	private static void getMaxSubArray(int[] arr) {
		int maxProduct = Integer.MIN_VALUE;
		int cummulativeProduct = 1;
		int startindex = 0;
		int endIndex = 0;
		int maxSofar = 0;
		for (int i = 0; i < arr.length; i++) {
			cummulativeProduct *= arr[i];
			if (cummulativeProduct > maxProduct) {
				maxProduct = cummulativeProduct;
				startindex = maxSofar;
				endIndex = i;

			} else if (cummulativeProduct < 0) {
				cummulativeProduct = 0;
				maxSofar = i + 1;

			}
		}
		System.out.println();
		System.out.println(maxProduct);
		System.out.println();
		for (int i = startindex; i <= endIndex; i++) {
			System.out.print(arr[i] + "\t");
		}

	}
}
