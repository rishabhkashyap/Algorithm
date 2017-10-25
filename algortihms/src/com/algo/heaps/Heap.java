package com.algo.heaps;

public class Heap {
	private int[] heap;
	private int size;

	public Heap(int capacity) {
		heap = new int[capacity];
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	// inserts element in heap
	public void insert(int element) {
		heap[size] = element;		
		hapifyUp(size);
		++size;
	}

	public int delete() {
		int deletedElement = heap[0];
		heap[0] = heap[size - 1];
		--size;
		heapifyDown(0);
		return deletedElement;
	}

	private void heapifyDown(int index) {
		
		int largeChild=0;
		int top=heap[index];
		while(index<size/2){
			int leftChild=getLeftChild(index);
			int rightChild=getRightChild(index);
			if(rightChild<size && heap[rightChild]>heap[leftChild]){
				largeChild=rightChild;
			}else{
				largeChild=leftChild;				
			}
			if(top>=heap[largeChild]){
				break;
			}
			heap[index]=heap[largeChild];
			index=largeChild;
		}
		heap[index]=top;
		

	}

	private void hapifyUp(int index) {
		int value = heap[index];
		int parent = (index - 1) / 2;
		while (index > 0 && heap[parent] < value) {
			heap[index] = heap[parent];
			index = parent;
			parent = (parent - 1) / 2;

		}
		heap[index] = value;

	}

	// get left child index
	public int getLeftChild(int index) {
		return 2 * index + 1;
	}

	// get right child
	public int getRightChild(int index) {
		return 2 * index + 2;
	}

	public void displayHeap() {
		for (int i=0;i<size;i++) {
			System.out.print(heap[i] + "\t");
		}
		System.out.println();
	}

}
