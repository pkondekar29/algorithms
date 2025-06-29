package com.prometheous.coding.concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Driver {

    public static void main(String[] args) throws InterruptedException {
//        Counter counter = new Counter();
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        for (int i = 0; i < 1000; i++) {
//            executorService.submit(() -> counter.increament());
//        }
//        try {
//            executorService.awaitTermination(5, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            executorService.shutdownNow();
//            Thread.currentThread().interrupt();
//        }
//        System.out.println(counter.getCount());

//        System.out.println("--- Advantage 1: Interruptible and Timed Lock Acquisition ---\n");
//        demonstrateInterruptibleLock();
//        Thread.sleep(2000); // Pause between demonstrations
//
//        System.out.println("\n--- Advantage 2: Fairness Option ---\n");
//        demonstrateFairness();
//        Thread.sleep(2000); // Pause between demonstrations
//
//        System.out.println("\n--- Advantage 3: Multiple Condition Variables ---\n");
//        demonstrateMultipleConditions();
//        Thread.sleep(2000); // Pause between demonstrations

        System.out.println("\n--- Advantage 4: Lock Inspection ---\n");
        demonstrateLockInspection();
    }

    // ===================================================================================
    // Advantage 1: Interruptible and Timed Lock Acquisition
    // ===================================================================================
    public static void demonstrateInterruptibleLock() throws InterruptedException {
        final ReentrantLock lock = new ReentrantLock();

        // Thread-1 will acquire the lock and hold it indefinitely.
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread-1: Attempting to acquire the lock...");
            lock.lock();
            System.out.println("Thread-1: Acquired the lock. Holding it forever...");
            try {
                // Simulate holding the lock indefinitely
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                // This won't be reached in this simple case
            } finally {
                lock.unlock();
            }
        }, "Thread-1");

        // Thread-2 will first try a timed lock, then an interruptible lock.
        Thread thread2 = new Thread(() -> {
            System.out.println("Thread-2: Attempting to acquire lock with 1-sec timeout.");
            try {
                boolean acquired = lock.tryLock(1, TimeUnit.SECONDS);
                if (acquired) {
                    System.out.println("Thread-2: Acquired the lock (This should not happen).");
                    lock.unlock();
                } else {
                    System.out.println("Thread-2: Timed lock attempt failed as expected.");
                }

                System.out.println("Thread-2: Now attempting an interruptible lock...");
                // lockInterruptibly() will block, but it can be interrupted.
                // A thread waiting on a 'synchronized' lock cannot be interrupted.
                lock.lockInterruptibly();
                System.out.println("Thread-2: Acquired the lock after being interrupted (This shouldn't happen).");
                lock.unlock();

            } catch (InterruptedException e) {
                System.out.println("Thread-2: Successfully interrupted while waiting for the lock!");
            }
        }, "Thread-2");

        thread1.start();
        Thread.sleep(500); // Ensure Thread-1 acquires the lock first.
        thread2.start();

        Thread.sleep(2000); // Let Thread-2 wait for a bit.
        System.out.println("Main Thread: Interrupting Thread-2.");
        thread2.interrupt(); // This is the key action.

        // Clean up the first thread
        thread1.interrupt();
    }


    // ===================================================================================
    // Advantage 2: Fairness Option
    // ===================================================================================
    public static void demonstrateFairness() {
        // Create a fair lock: true means it grants access to the longest-waiting thread.
        final ReentrantLock fairLock = new ReentrantLock(true);
        Runnable job = () -> {
            System.out.println(Thread.currentThread().getName() + " is waiting for the lock.");
            fairLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " has acquired the lock.");
                Thread.sleep(50); // Simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                System.out.println(Thread.currentThread().getName() + " is releasing the lock.");
                fairLock.unlock();
            }
        };

        // Start threads in a specific order. With a fair lock, they should
        // acquire the lock in roughly the same order they started waiting.
        System.out.println("With a FAIR lock, threads should acquire it in FIFO order.");
        Thread t1 = new Thread(job, "Thread-A");
        Thread t2 = new Thread(job, "Thread-B");
        Thread t3 = new Thread(job, "Thread-C");
        t1.start();
        t2.start();
        t3.start();
    }

    // ===================================================================================
    // Advantage 3: Multiple Condition Variables
    // ===================================================================================
    public static void demonstrateMultipleConditions() throws InterruptedException {
        BoundedBlockingQueue<Integer> queue = new BoundedBlockingQueue<>(5);
        Random random = new Random();
        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Producer: Putting item " + i);
                    queue.put(i);
                    Thread.sleep(300); // Slow down producer
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    Integer item = queue.take();
                    System.out.println("Consumer: Took item " + item);
                    Thread.sleep(100); // Slow down consumer
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }

    // Helper class for the Multiple Conditions demo
    static class BoundedBlockingQueue<E> {
        private final Queue<E> queue;
        private final int capacity;
        private final ReentrantLock lock = new ReentrantLock();

        // Condition 1: For when the queue is not full (for producers to wait on)
        private final Condition notFull = lock.newCondition();

        // Condition 2: For when the queue is not empty (for consumers to wait on)
        private final Condition notEmpty = lock.newCondition();

        public BoundedBlockingQueue(int capacity) {
            this.queue = new LinkedList<>();
            this.capacity = capacity;
        }

        public void put(E e) throws InterruptedException {
            lock.lock();
            try {
                while (queue.size() == capacity) {
                    System.out.println("Queue is FULL. Producer is waiting on 'notFull' condition.");
                    notFull.await(); // Producer waits until queue is not full
                }
                queue.add(e);
                // Signal to any waiting consumers that an item is now available.
                notEmpty.signal();
            } finally {
                lock.unlock();
            }
        }

        public E take() throws InterruptedException {
            lock.lock();
            try {
                while (queue.isEmpty()) {
                    System.out.println("Queue is EMPTY. Consumer is waiting on 'notEmpty' condition.");
                    notEmpty.await(); // Consumer waits until queue is not empty
                }
                E item = queue.poll();
                // Signal to any waiting producers that there is now space.
                notFull.signal();
                return item;
            } finally {
                lock.unlock();
            }
        }
    }

    // ===================================================================================
    // Advantage 4: Lock Inspection
    // ===================================================================================
    public static void demonstrateLockInspection() throws InterruptedException {
        final ReentrantLock inspectLock = new ReentrantLock();

        Thread inspectionThread = new Thread(() -> {
            try {
                inspectLock.tryLock(200, TimeUnit.MILLISECONDS);

                System.out.println("Inspection Thread: Inside critical section.");
                // Recursive lock acquisition
                System.out.println("Inspection Thread: Lock hold count is " + inspectLock.getHoldCount());
                inspectLock.lock();
                System.out.println("Inspection Thread: Lock hold count is " + inspectLock.getHoldCount());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                inspectLock.unlock();
                inspectLock.unlock();
            }
        });

        System.out.println("Before starting: Is lock held? " + inspectLock.isLocked());
        inspectionThread.start();
        Thread.sleep(100); // Give the thread time to acquire the lock

        System.out.println("After starting: Is lock held? " + inspectLock.isLocked());
        System.out.println("After starting: How many threads are waiting for the lock? " + inspectLock.getQueueLength());
        System.out.println("After starting: Is the lock fair? " + inspectLock.isFair());

        inspectionThread.join();
        System.out.println("After thread finished: Is lock held? " + inspectLock.isLocked());

    }

}
