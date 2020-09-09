package com.algo.stack;

import java.util.EmptyStackException;

public class StackArr implements Stack {

    private int[] arr;
    private int count;
    private int top;

    public StackArr(int size) {
        arr = new int[size];
        top = -1;
    }

    @Override
    public void push(int element) {
        if (top == arr.length) {
            throw new ArrayIndexOutOfBoundsException("Stack is full");
        }
        arr[++top] = element;
        ++count;

    }

    @Override
    public int pop() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        --count;
        int poppedItem = arr[top];
        --top;
        return poppedItem;
    }

    @Override
    public int peek() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        return arr[top];
    }

    @Override
    public boolean isEmpty() {
        return (top == -1) ? true : false;
    }

    @Override
    public void display() {
        int i = top;
        while (i >=0) {
            System.out.print(arr[i] + "\t");
            --i;
        }
    }

    @Override
    public int size() {
        return count;
    }
}
