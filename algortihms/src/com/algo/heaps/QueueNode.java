package com.algo.heaps;

public class QueueNode implements Comparable<QueueNode> {
    private int array;
    private int element;
    private int index;

    public QueueNode(int array, int element, int index) {
        this.array = array;
        this.element = element;
        this.index = index;
    }

    public int getArray() {
        return array;
    }

    public int getElement() {
        return element;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(QueueNode ac) {
        // TODO Auto-generated method stub
        return this.element - ac.getElement();
    }


}
