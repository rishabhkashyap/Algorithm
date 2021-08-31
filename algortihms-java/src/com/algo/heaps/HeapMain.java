package com.algo.heaps;

public class HeapMain {

	public static void main(String[] args) {
		Heap heap=new Heap(10);
		System.out.println("Inserting 2");
		heap.insert(2);
		heap.displayHeap();
		System.out.println("Inserting 6");
		heap.insert(6);
		heap.displayHeap();
		System.out.println("Inserting 1");
		heap.insert(1);
		heap.displayHeap();
		System.out.println("Inserting 9");
		heap.insert(9);
		heap.displayHeap();
		System.out.println("Inserting 10");
		heap.insert(10);
		heap.displayHeap();
		System.out.println("Inserting -1");
		heap.insert(-1);
		heap.displayHeap();
		System.out.println("Deleted element = "+heap.delete());
		heap.displayHeap();
		System.out.println("Deleted element = "+heap.delete());
		heap.displayHeap();

	}

}
