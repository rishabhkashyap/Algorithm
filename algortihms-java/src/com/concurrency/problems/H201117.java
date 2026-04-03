package com.concurrency.problems;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Problem: https://leetcode.com/problems/building-h2o/description/?envType=problem-list-v2&envId=concurrency

public class H201117 {
    static void main() {
        //var h20 = new H2O1();
        var h20 = new H2O2();
        //var h20 = new H2O3();
        for (int i = 0; i < 10; i++) {
            var threadH = new Thread(
                    () -> {
                        try {
                            h20.hydrogen(() -> System.out.println(Thread.currentThread().getName()+" "+"H"));
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }, "threadH");
            threadH.start();
        }
        for (int i = 0; i < 5; i++) {
            var threadO = new Thread(
                    () -> {
                        try {
                            h20.oxygen(() -> System.out.println(Thread.currentThread().getName()+" "+"O"));
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }, "threadO");
            threadO.start();
        }

    }


    //Using single condition
    private static class H2O1 {

        private final Lock lock;

        private final Condition condition;

        private int hCount;

        private int oCount;

        public H2O1() {
            this.lock = new ReentrantLock();
            this.condition = lock.newCondition();
            this.hCount = 0;
            this.oCount = 0;
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            lock.lock();
            try {
                while (hCount == 2) {
                    condition.await();
                }
                releaseHydrogen.run();
                ++hCount;
                if (hCount == 2 && oCount == 1) {
                    hCount = 0;
                    oCount = 0;
                }
                condition.signalAll();
            } finally {
                lock.unlock();
            }


        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            lock.lock();
            try {
                while (oCount == 1) {
                    condition.await();
                }
                releaseOxygen.run();
                ++oCount;
                if (hCount == 2 && oCount == 1) {
                    hCount = 0;
                    oCount = 0;
                }
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }

    }

    //Using multiple condition
    private static class H2O2 {

        private final Lock lock;

        private final Condition hCond;

        private final Condition oCond;

        private int hCount;

        private int oCount;

        public H2O2() {
            this.lock = new ReentrantLock();
            this.oCond = lock.newCondition();
            this.hCond = lock.newCondition();
            this.hCount = 0;
            this.oCount = 0;
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            lock.lock();
            try {
                while (hCount == 2) {
                    hCond.await();
                }
                releaseHydrogen.run();
                ++hCount;
                signalAll();
            } finally {
                lock.unlock();
            }
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            lock.lock();
            try {
                while (oCount == 1) {
                    oCond.await();
                }
                releaseOxygen.run();
                ++oCount;
                signalAll();
            } finally {
                lock.unlock();
            }
        }

        private void signalAll() {
            if (hCount == 2 && oCount == 1) {
                hCount = 0;
                oCount = 0;
                hCond.signal();
                oCond.signal();
            }
            if (hCount < 2) {
                hCond.signal();
            }
            if (oCount < 1) {
                oCond.signal();
            }
        }
    }

    //Solution using Semaphore and cyclic barrier
    private static class H2O3 {

        private final Semaphore hSem;

        private final Semaphore oSem;

        private final CyclicBarrier barrier;

        public H2O3() {
            this.hSem = new Semaphore(2);
            this.oSem = new Semaphore(1);
            this.barrier = new CyclicBarrier(3);
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            hSem.acquire();
            try {
                barrier.await();
                releaseHydrogen.run();
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            } finally {
                hSem.release();
            }
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            oSem.acquire();
            try {
                barrier.await();
                releaseOxygen.run();
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            } finally {
                oSem.release();
            }
        }
    }
}
