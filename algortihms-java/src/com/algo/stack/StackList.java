package com.algo.stack;

import com.algo.linkedList.Node;

import java.util.EmptyStackException;

public class StackList implements Stack {
    private Node top;
    private int count;

    @Override
    public void push(int element) {
        Node node = new Node(element);
        if (top == null) {
            top = node;
            ++count;
            return;
        }
        node.setNext(top);
        top = node;
        ++count;
    }

    @Override
    public int pop() {
        if (top == null || count == 0) {
            throw new EmptyStackException();
        }
        Node node = top;
        top = top.getNext();
        node.setNext(null);
        --count;
        return node.getValue();
    }

    @Override
    public int peek() {
        if (top == null || count == 0) {
            throw new EmptyStackException();
        }
        return top.getValue();
    }

    @Override
    public boolean isEmpty() {
        return (top == null || count == 0) ? true : false;
    }

    @Override
    public void display() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.getValue() + "\t");
            temp = temp.getNext();
        }
    }

    @Override
    public int size() {
        return count;
    }
}
