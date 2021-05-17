package com.algo.stack;

import java.util.EmptyStackException;

public class DoubleStack {
    public static void main(String[] args) {
        DStack dStack = new DStack(5);
        dStack.pushToStack1(1);
        dStack.pushToStack1(2);
        dStack.pushToStack2(3);
        dStack.pushToStack2(4);
        dStack.pushToStack2(5);

        System.out.println("\n-----------------Stack1---------------------------------");
        System.out.print(dStack.popFromStack1()+"\t");
        System.out.print(dStack.popFromStack1()+"\t");
        System.out.println("\n-----------------Stack2---------------------------------");
        System.out.print(dStack.popFromStack2()+"\t");
        System.out.print(dStack.popFromStack2()+"\t");
        System.out.print(dStack.popFromStack2()+"\t");

    }

    private static class DStack {
        private int top1;
        private int top2;
        private int size1;
        private int size2;
        private int[] arr;

        public DStack(int initialCapacity) {
            this.top1 = -1;
            this.top2 = initialCapacity;
            this.size1 = 0;
            this.size2 = 0;
            this.arr = new int[initialCapacity];
        }

        public int pushToStack1(int element) {
            if (isStackFull()) {
                throw new RuntimeException("Stack1 is full");
            }
            arr[++top1] = element;
            ++size1;
            return element;
        }


        public int pushToStack2(int element) {
            if (isStackFull()) {
                throw new RuntimeException("Stack2 is full");
            }
            arr[--top2] = element;
            ++size2;
            return element;
        }

        private boolean isStackFull() {
            return top2 - top1 == 1;
        }

        public int popFromStack1() {
            if (size1 == 0) {
                throw new EmptyStackException();
            }
            int element = arr[top1--];
            --size1;
            return element;
        }

        public int popFromStack2() {
            if (size2 == 0) {
                throw new EmptyStackException();
            }
            int element = arr[top2++];
            --size2;
            return element;
        }
    }
}
