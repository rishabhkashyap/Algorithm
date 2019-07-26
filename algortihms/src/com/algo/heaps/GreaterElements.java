package com.algo.heaps;

public class GreaterElements {

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(30);
        heap.insert(9);
        heap.insert(8);
        heap.insert(7);
        heap.insert(2);
        heap.insert(40);
        heap.insert(99);
        heap.insert(60);
        heap.insert(80);
        heap.displayHeap();
        System.out.println();
        int element = 9;
        printGreaterElement(heap, element);


    }

    private static void printGreaterElement(Heap heap, int element) {

        printGreaterElement(heap, element, 0);
    }

    private static void printGreaterElement(Heap heap, int element, int index) {
        if (index > heap.getSize()) {
            return;
        }
        if (heap.getElement(index) <= element) {
            return;

        }

        System.out.print(heap.getElement(index) + "\t");
        printGreaterElement(heap, element, heap.getLeftChild(index));
        printGreaterElement(heap, element, heap.getRightChild(index));
    }
}
