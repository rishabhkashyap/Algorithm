package com.concurrency.problems;

//Problem: https://leetcode.com/problems/print-zero-even-odd/description/?envType=problem-list-v2&envId=concurrency

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOdd1116 {
    static void main(){
        var zeroEvenOdd1 = new ZeroEvenOdd1(6);
        var threadZero = new Thread(() -> {
            try {
                zeroEvenOdd1.zero(e-> System.out.print(e+" "));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        var threadEven = new Thread(() -> {
            try {
                zeroEvenOdd1.even(e-> System.out.print(e+" "));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        var threadOdd = new Thread(() -> {
            try {
                zeroEvenOdd1.odd(e-> System.out.print(e+" "));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threadZero.start();
        threadOdd.start();
        threadEven.start();
    }

    private static class ZeroEvenOdd1 {
        private final Lock lock;

        private final Condition condition;

        private final int n;

        private int counter;

        private int flag;

        public ZeroEvenOdd1(int n) {
            this.lock = new ReentrantLock();
            this.condition = lock.newCondition();
            this.counter = 1;
            this.n = n;
            this.flag = 0;
        }

        public void zero(IntConsumer printNumber) throws InterruptedException {
            while (true) {
                lock.lock();
                try {
                    while (flag != 0) {
                        condition.await();
                    }
                    if (counter > n) {
                        break;
                    }
                    printNumber.accept(0);
                    if (counter % 2 == 0) {
                        flag = 2;
                    } else {
                        flag = 1;
                    }
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            while (true) {
                lock.lock();
                try {
                    while (flag != 2 && counter <= n) {
                        condition.await();
                    }
                    if (counter > n) {
                        break;
                    }
                    printNumber.accept(counter);
                    ++counter;
                    flag = 0;
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            while (true) {
                lock.lock();
                try {
                    while (flag != 1 && counter <= n) {
                        condition.await();
                    }
                    if (counter > n) {
                        break;
                    }
                    printNumber.accept(counter);
                    ++counter;
                    flag = 0;
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
