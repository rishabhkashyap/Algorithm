package com.algo.stack;

public class StackMain {
    public static void main(String[] args) {
        Stack stack = new StackArr(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.display();
        System.out.println("\nPopped item = " + stack.pop());
        System.out.println("Total element = " + stack.size());
        stack.display();
        stack.push(5);
        stack.push(10);
        System.out.println();
        stack.display();
        System.out.println("\nElement at top = " + stack.peek());
    }
}
