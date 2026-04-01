package com.concurrency.problems;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

//Problem: https://leetcode.com/problems/fizz-buzz-multithreaded/description/?envType=problem-list-v2&envId=concurrency

public class FizzBuzz1195 {
    static void main() {
        var fizzBuzz = new FizzBuzz(7);
        var threadFizz = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.println(Thread.currentThread().getName() + " " + "fizz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "threadFizz");
        var threadBuzz = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.println(Thread.currentThread().getName() + " " + "buzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "threadBuzz");
        var threadFizzBuzz = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.println(Thread.currentThread().getName() + " " + "fizzbuzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "threadFizzBuzz");
        var threadNum = new Thread(() -> {
            try {
                fizzBuzz.number((e) -> System.out.println(Thread.currentThread().getName() + " " + e));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "threadNum");
        threadFizz.start();
        threadBuzz.start();
        threadFizzBuzz.start();
        threadNum.start();
    }

    private static class FizzBuzz {

        private final int n;

        private final Lock lock;

        private final Condition condition;

        private int counter;

        public FizzBuzz(int n) {
            this.n = n;
            this.lock = new ReentrantLock();
            this.condition = lock.newCondition();
            this.counter = 1;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            while (true) {
                lock.lock();
                try {
                    while (!(counter % 3 == 0 && counter % 5 != 0) && counter <= n) {
                        condition.await();
                    }
                    if (counter > n) {
                        condition.signalAll();
                        break;
                    }
                    printFizz.run();
                    ++counter;
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            while (true) {
                lock.lock();
                try {
                    while (!(counter % 3 != 0 && counter % 5 == 0) && counter <= n) {
                        condition.await();
                    }
                    if (counter > n) {
                        condition.signalAll();
                        break;
                    }
                    printBuzz.run();
                    ++counter;
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (true) {
                lock.lock();
                try {
                    while (!(counter % 3 == 0 && counter % 5 == 0) && counter <= n) {
                        condition.await();
                    }
                    if (counter > n) {
                        condition.signalAll();
                        break;
                    }
                    printFizzBuzz.run();
                    ++counter;
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            while (true) {
                lock.lock();
                try {
                    while (!(counter % 3 != 0 && counter % 5 != 0) && counter <= n) {
                        condition.await();
                    }
                    if (counter > n) {
                        condition.signalAll();
                        break;
                    }
                    printNumber.accept(counter);
                    ++counter;
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
