package com.concurrency.problems;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Problem: https://leetcode.com/problems/print-foobar-alternately/?envType=problem-list-v2&envId=concurrency
public class FooBar1115 {
    static void main() {
        var fooBar = new FooBar(2);
        Thread threadA = new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.println(Thread.currentThread().getName()+" "+"foo"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        },"fooThread");
        Thread threadB = new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.println(Thread.currentThread().getName()+" "+"bar"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "barThread");

        threadA.start();
        threadB.start();
    }

    private static class FooBar {
        private int n;

        private final Lock lock;

        private final Condition condition;

        private boolean flag;

        public FooBar(int n) {
            this.n = n;
            this.lock = new ReentrantLock();
            this.condition = lock.newCondition();
            this.flag = true;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                lock.lock();
                try {
                    while (!flag) {
                        condition.await();
                    }
                    printFoo.run();
                    flag = false;
                    condition.signal();
                } finally {
                    lock.unlock();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                lock.lock();
                try {
                    while (flag) {
                        condition.await();
                    }
                    printBar.run();
                    flag = true;
                    condition.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
