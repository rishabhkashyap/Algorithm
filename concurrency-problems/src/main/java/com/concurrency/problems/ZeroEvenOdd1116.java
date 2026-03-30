package com.concurrency.problems;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOdd1116 {

    static void main() {
        var zeroEvenOdd = new ZeroEvenOdd(5);
        var zeroThread = new Thread(() -> {
            try {
                zeroEvenOdd.zero(e -> System.out.println(Thread.currentThread().getName()+" "+e));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "ZeroThread");
        var evenThread = new Thread(() -> {
            try {
                zeroEvenOdd.even(e -> System.out.println(Thread.currentThread().getName()+" "+e));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "EvenThread");
        var oddThread = new Thread(() -> {
            try {
                zeroEvenOdd.odd(e -> System.out.println(Thread.currentThread().getName()+" "+e));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "OddThread");
        zeroThread.start();
        evenThread.start();
        oddThread.start();
    }

    private static class ZeroEvenOdd {
        private final Lock lock;

        private final Condition condition;

        private final int n;

        private int counter;

        private int flag;

        public ZeroEvenOdd(int n) {
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
