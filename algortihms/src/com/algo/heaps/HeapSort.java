package com.algo.heaps;

public class HeapSort {

	private int[] arr;
	int size;

	public HeapSort(int[] arr) {
		super();
		this.arr = arr;
		this.size = arr.length;
	}

	public static void main(String[] args) {
		int[]arr={5,4,3,2,1};
		HeapSort hs=new HeapSort(arr);
		System.out.println("Unsorted array :");
		hs.displayArr();
		hs.sort();
		System.out.println("\nSorted array :");
		hs.displayArr();
		
	}

	public void sort() {
		for (int i = size / 2 - 1; i >= 0; i--) {
			heapify(i);
		}
		for (int i = arr.length-1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[size - 1];
			arr[size - 1] = temp;
			--size;
			heapify(0);
		}

	}

	private void heapify(int i) {
		int leftChildIndex = getLeftChildIndex(i);
		int rightChildIndex = getRightChildIndex(i);
		int largestIndex = i;
		if (leftChildIndex < size && arr[leftChildIndex] > arr[largestIndex]) {
			largestIndex = leftChildIndex;
		}
		if (rightChildIndex < size && arr[rightChildIndex] > arr[largestIndex]) {
			largestIndex = rightChildIndex;
		}
		if (largestIndex != i) {
			int swap = arr[i];
			arr[i] = arr[largestIndex];
			arr[largestIndex] = swap;
			// Recursively heapify affected subtree
			heapify(largestIndex);
		}

	}

	private int getRightChildIndex(int i) {
		return 2 * i + 2;
	}

	private int getLeftChildIndex(int i) {
		return 2 * i + 1;
	}

	public void displayArr() {
		System.out.println();
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
