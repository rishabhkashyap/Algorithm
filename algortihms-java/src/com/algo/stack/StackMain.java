package com.algo.stack;

public class StackMain {
    public static void main(String[] args) {
        System.out.println("\n**************Array implementation****************");
        Stack stack = new StackArr(5);
        doStackOperation(stack);
        System.out.println("\n**************List implementation****************");
        stack = new StackList();
        doStackOperation(stack);
    }

    private static void doStackOperation(Stack stack){
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
        System.out.println("Total elements in stack = "+stack.size());
        System.out.println("Is stack empty = "+stack.isEmpty());

    }
}
