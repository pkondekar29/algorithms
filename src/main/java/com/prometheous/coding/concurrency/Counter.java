package com.prometheous.coding.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private int count = 0;
    Lock lock = new ReentrantLock();
    public void increament() {
        lock.lock();
        try {
            count += 1;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}
