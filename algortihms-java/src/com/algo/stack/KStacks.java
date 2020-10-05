package com.algo.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class KStacks {

    public static void main(String[] args) {

        Stack stacks = new Stack(3, 5);

        stacks.push(0, 1);
        stacks.push(0, 2);
        stacks.push(0, 3);
        System.out.println("Poped value from stack 1 = " + stacks.pop(0));
        stacks.push(0, 10);
        stacks.push(2, 8);
        stacks.push(2, 9);
        stacks.push(2, 22);
        stacks.display();
        System.out.println("Poped value from stack 2 = " + stacks.pop(2));
        stacks.push(0, 90);
        stacks.display();


    }


    static class Stack {

        private int[] stackData;

        private int[] nextIndex;

        private int[] topOfStack;

        private int nextAvailable;

        public Stack(int numberOfStacks, int capacity) {
            stackData = new int[capacity];
            nextIndex = new int[capacity];
            topOfStack = new int[numberOfStacks];
            Arrays.setAll(topOfStack, i -> -1);
            Arrays.setAll(nextIndex, i -> i + 1);
            nextIndex[nextIndex.length - 1] = -1;
            nextAvailable = 0;

        }

        public void push(int stackIndex, int element) {
            if (stackIndex < 0 || stackIndex > topOfStack.length) {
                throw new RuntimeException("Wrong Stack index");
            }

            if (nextAvailable == -1) {
                System.out.println("All stacks are full");
                return;
            }
            //Get current index where element will be inseted
            int currentIndex = nextAvailable;
            //Update next available using nextIndex array
            nextAvailable = nextIndex[currentIndex];
            stackData[currentIndex] = element;
            //Update top of stack
            nextIndex[currentIndex] = topOfStack[stackIndex];
            topOfStack[stackIndex] = currentIndex;


        }

        public int pop(int stackIndex) {
            int value = -99999;
            if (stackIndex < 0 || stackIndex > topOfStack.length) {
                throw new RuntimeException("Wrong Stack index");

            }
            if (topOfStack[stackIndex] == -1) {
                throw new EmptyStackException();
            }
            int currentIndex = topOfStack[stackIndex];
            value = stackData[currentIndex];
            //Get previous top value from next indes
            topOfStack[stackIndex] = nextIndex[currentIndex];
            //Since element is poped from stack ,next index must have vaccant location,
            // so copy next available value to it
            nextIndex[currentIndex] = nextAvailable;
            //since element is deleted from current index ,so it will become next available
            nextAvailable = currentIndex;


            return value;
        }

        public void display() {
            System.out.println("Stack data");
            Arrays.stream(stackData)
                    .forEach(e -> System.out.print(e + "\t"));
            System.out.println("\nTop of stacks");
            Arrays.stream(topOfStack)
                    .forEach(e -> System.out.print(e + "\t"));
            System.out.println("\nNext index");
            Arrays.stream(nextIndex)
                    .forEach(e -> System.out.print(e + "\t"));
            System.out.println("\nNext available = " + nextAvailable);

        }


    }
}
    