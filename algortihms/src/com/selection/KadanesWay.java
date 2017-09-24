package com.selection;

public class KadanesWay {

	public static void main(String[] args) {
		//int[] intArr = { 3, -1, -1, -1, -1, -1, 2, 0, 0, 0 };
		 //int[] intArr = {-1, 3, -5, 4, 6, -1, 2, -7, 13, -3};
		// int[] intArr={-6,-2,-3,-4,-1,-5,-5};
		int[] intArr=  {-2, -3, 4, -1, -2, 1, 5, -3};
		getMaxSubArray(intArr);

	}

	private static void getMaxSubArray(int[] arr) {
		int maxSum = Integer.MIN_VALUE;
		int cummulativeSum = 0;
		int startindex = 0;
		int endIndex = 0;
		int maxSofar = 0;
		for (int i = 0; i < arr.length; i++) {
			cummulativeSum += arr[i];
			if (cummulativeSum > maxSum) {
				maxSum = cummulativeSum;
				startindex = maxSofar;
				endIndex = i;

			} else if (cummulativeSum < 0) {
				cummulativeSum = 0;
				maxSofar = i + 1;

			}
		}
		System.out.println();
		System.out.println(maxSum);
		System.out.println();
		for (int i = startindex; i <= endIndex; i++) {
			System.out.print(arr[i] + "\t");
		}

	}
}
